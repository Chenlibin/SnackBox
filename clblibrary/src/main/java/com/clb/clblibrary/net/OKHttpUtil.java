package com.clb.clblibrary.net;

import android.text.TextUtils;
import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

public class OKHttpUtil {

    private static OkHttpClient client = new OkHttpClient();


    private static OKHttpUtil httpUtil = new OKHttpUtil();

    private OKHttpUtil() {
//        client.setSslSocketFactory(SslContextFactory.getSSLContext().getSocketFactory());
        client.setConnectTimeout(15, TimeUnit.SECONDS);
        client.setWriteTimeout(20, TimeUnit.SECONDS);
        client.setReadTimeout(10, TimeUnit.SECONDS);
    }


    public static OKHttpUtil getInstance() {
        return httpUtil;
    }

    public Response request(String url) throws IOException {
        return client.newCall(createRequest(url).build()).execute();
    }

    public Response request(String url, Param... params) throws IOException {
        Request request = createPostParam(url, params);
        return client.newCall(request).execute();
    }

    /*******************
     * get
     *********************/
    public String getString(String url) throws IOException {
        return request(url).body().string();
    }

    public byte[] getBytes(String url) throws IOException {
        return request(url).body().bytes();
    }

    public InputStream getStream(String url) throws IOException {
        return request(url).body().byteStream();
    }

    public void asyncGetRequest(String url, Callback callback) {
        client.newCall(createRequest(url).build()).enqueue(callback);
    }

    public void asyncGetRequest(String url, String cookie, Callback callback) {
        client.newCall(createRequest(url, cookie).build()).enqueue(callback);
    }

    /*******************
     * post
     ********************/
    public String postString(String url, Param... params) throws IOException {
        return request(url, params).body().toString();
    }

    public byte[] postBytes(String url, Param... params) throws IOException {
        return request(url, params).body().bytes();
    }

    public InputStream postStream(String url, Param... params) throws IOException {
        return request(url, params).body().byteStream();
    }

    public void asyncPostRequest(String url, Callback callback, Param... params) {
        Request request = createPostParam(url, params);
        client.newCall(request).enqueue(callback);
    }

    public Response upload(String url, File[] files, String[] fileNames, Param... params) throws IOException {
        Request request = createMultipartFormRequest(url, null, files, fileNames, params);
        return client.newCall(request).execute();
    }

    public Response upload(String url, File file, String fileName) throws IOException {
        Request request = createMultipartFormRequest(url, null, new File[]{file}, new String[]{fileName}, new Param[0]);
        return client.newCall(request).execute();
    }

    public Response upload(String url, File file, String fileKey, Param... params) throws IOException {
        Request request = createMultipartFormRequest(url, null, new File[]{file}, new String[]{fileKey}, params);
        return client.newCall(request).execute();
    }

    public void asyncUpload(Callback callback, String url, String cookie, File[] files, String[] fileKeys, Param... params) throws IOException {
        Request request = createMultipartFormRequest(url, cookie, files, fileKeys, params);
        client.newCall(request).enqueue(callback);
    }

    public void asyncUpload(Callback callback, String url, File file, String fileKey) throws IOException {
        Request request = createMultipartFormRequest(url, null, new File[]{file}, new String[]{fileKey}, new Param[0]);
        client.newCall(request).enqueue(callback);
    }

    public void asyncUpload(Callback callback, String url, String cookie, File file, String fileKey, Param... params) throws IOException {
        Request request = createMultipartFormRequest(url, cookie, new File[]{file}, new String[]{fileKey}, params);
        client.newCall(request).enqueue(callback);
    }

    public void downLoad(String url, Callback callback) {
        asyncGetRequest(url, callback);
    }

    private Request createMultipartFormRequest(String url, String cookie, File[] files, String[] fileNames, Param... params) {
        params = validateParam(params);

        MultipartBuilder builder = new MultipartBuilder().type(MultipartBuilder.FORM);
        // 拼接普通参数
        for (Param param : params) {
            builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + param.name + "\""), RequestBody.create(null, param.value));
        }
        if (files != null) {
            RequestBody fileBody = null;
            int len = files.length;
            for (int i = 0; i < len; i++) {
                File file = files[i];
                String fileName = file.getName();
                fileBody = RequestBody.create(MediaType.parse(guessMimeType(fileName)), file);
                builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + fileNames[i] + "\"; filename=\"" + fileName + "\""), fileBody);
            }
        }
        RequestBody requestBody = builder.build();
        return new Request.Builder().url(url).addHeader("cookie", cookie).post(requestBody).build();
    }

    private Param[] validateParam(Param... params) {
        if (params == null)
            return new Param[0];
        else
            return params;
    }

    private String guessMimeType(String path) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String contentTypeFor = fileNameMap.getContentTypeFor(path);
        if (contentTypeFor == null) {
            contentTypeFor = "application/octet-stream";
        }
        return contentTypeFor;
    }

    private Request createPostParam(String url, Param[] params) {
        if (params == null)
            params = new Param[0];
        FormEncodingBuilder builder = new FormEncodingBuilder();
        for (Param param : params) {
            if (param != null && !TextUtils.isEmpty(param.name) && !TextUtils.isEmpty(param.value)) {
                builder.add(param.name, param.value);
                Log.e("debug_request", param.name + "=>" + param.value);
            }
        }
        RequestBody requestBody = builder.build();
        try {
            Log.e("request_url", url);
            Log.e("net", requestBody.contentLength() + "----len");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Request.Builder().url(url).post(requestBody).build();
    }

    /**
     * 创建一个请求
     */
    private Request.Builder createRequest(String url) {
        return new Request.Builder().url(url);
    }

    /**
     * 创建一个请求,且携带cookie
     */
    private Request.Builder createRequest(String url, String cookie) {
        return createRequest(url).addHeader("cookie", cookie);
    }

    public static class Param {
        public String name;
        public String value;
        public int id;

        public Param() {
        }

        public Param(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }


    public interface InitCallback {

    }
}
