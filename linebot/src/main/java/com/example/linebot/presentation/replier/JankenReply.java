package com.example.linebot.presentation.replier;

import com.example.linebot.service.JankenResult;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

public class JankenReply implements Replier{
    public static final String MESSEAGE_FORMAT="あなた:%s,相手:%s\n結果:%s";

    private final JankenResult jankenResult;
    private String jibun;
    private String aite;


    public JankenReply(JankenResult jankenResult){
        this.jankenResult=jankenResult;
    }

    @Override
    public Message reply(){
        if (jankenResult.response().aite()==0){
            aite = "グー";
        }else if(jankenResult.response().aite()==1){
            aite ="チー";
        }else{
            aite="パー";
        }

        if(jankenResult.response().jibun()==0){
            jibun="グー";
        }else if(jankenResult.response().jibun()==1){
            jibun="チー";
        }else{
            jibun="パー";
        }
        
        String message =String.format(MESSEAGE_FORMAT,jibun,aite,jankenResult.response().kekka());
        return new TextMessage(message);
    }

    //private final JankenResult jankenResult;
    //public ImageSizeReply(JankenResult jankenResult){
      //  this.jankenResult=jankenResult;
    //}

    //@Override
    //public Message reply(){
      //  String message = String.format(MESSEAGE_FORMAT,jankenResult.imageSize());
       // return new TextMessage(message);
   // }


}


