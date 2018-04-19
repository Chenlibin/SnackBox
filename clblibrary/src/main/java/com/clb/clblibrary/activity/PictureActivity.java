package com.clb.clblibrary.activity;

import android.content.Intent;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

public abstract class PictureActivity extends RootActivity {

    //别人的开源库，用于打开系统图库，获取图片资源，并剪裁
    public void jump2Gallery() {
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())         //全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .isCamera(false)                                // 是否显示拍照按钮
                .enableCrop(true)                               // 是否裁剪
                .cropWH(300, 300)            // 裁剪宽高比，设置如果大于图片本身宽高则无效
                .scaleEnabled(true)                             // 裁剪是否可放大缩小图片
                .selectionMode(PictureConfig.SINGLE)            // 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .freeStyleCropEnabled(true)                     // 裁剪框是否可拖拽 true or false
                .withAspectRatio(1, 1)      // int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .forResult(PictureConfig.CHOOSE_REQUEST);           //结果回调onActivityResult code
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    onImageSelect(selectList);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
//                    adapter.setList(selectList);
//                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    }
    //选中图片后，回调到主界面进行操作
    protected abstract void onImageSelect(List<LocalMedia> selectList);
}
