package com.example.linebot.data;

import org.springframework.core.io.ByteArrayResource;

public class LINEImageResource extends ByteArrayResource {
    public LINEImageResource(byte[] byteArray){
        super(byteArray);
    }

    @Override
    public String getFilename(){
        //LINEBOTを通すと、LINE側で全ての画像がJPEGに変更すされる。
        //そのため、元のファイル名とは異なる仮のファイル名を設定する。
        return "image.jpg";
    }
}
