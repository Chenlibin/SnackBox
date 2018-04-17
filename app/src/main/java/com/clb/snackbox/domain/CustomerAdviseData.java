package com.clb.snackbox.domain;

import java.io.Serializable;

public class CustomerAdviseData implements Serializable {


    private String scanId;         //扫描时的id
    private String content;        //建议的内容
    private String time;           //提交的时间

    public String getScanId() {
        return scanId;
    }

    public void setScanId(String scanId) {
        this.scanId = scanId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CustomerAdviseData{" +
                "scanId='" + scanId + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
