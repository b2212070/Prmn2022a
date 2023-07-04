package com.example.linebot.service;

import com.example.linebot.data.Blob;
import com.example.linebot.data.JankenAPI;
import com.example.linebot.data.JankenLog;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.ImageMessageContent;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;

@Service
public class JankenService {

    private Blob blob;
    private JankenAPI jankenAPI;

    //データ層;データベースのjanken_logにアクセスするクラス
    private JankenLog jankenLog;
    
    public JankenService(Blob blob,JankenAPI jankenAPI,JankenLog jankenLog){
        this.blob=blob;
        this.jankenAPI=jankenAPI;
        this.jankenLog=jankenLog;
    }
    public JankenResult doJanken(MessageEvent<ImageMessageContent> event)
        throws Exception{
        //画像データを取得する
        Resource imageResource =blob.getImageResource(event);
        //じゃんけんを実行する
        JankenResponse jankenResponse = jankenAPI.playGame(imageResource);
        //じゃんけんの結果を永続化する
        jankenLog.insert(jankenResponse);
        //ビジネスサービスの処理結果を返す
        JankenResult jankenResult =new JankenResult(imageResource.contentLength(), jankenResponse);
        return jankenResult;
    }
}
