package com.example.linebot.presentation;

import com.example.linebot.presentation.replier.*;
import com.example.linebot.service.*;
import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.event.message.ImageMessageContent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@LineMessageHandler
public class Callback {

    private static final Logger log = LoggerFactory.getLogger(Callback.class);
    private SenrekiService senrekiService;
    private JankenService jankenService;

    public Callback(SenrekiService senrekiService, JankenService jankenService) {
        this.senrekiService = senrekiService;
        this.jankenService = jankenService;
    }

    // フォローイベントに対応する
    @EventMapping
    public Message handleFollow(FollowEvent event) {
        // 実際はこのタイミングでフォロワーのユーザIDをデータベースに格納しておくなど
        Follow follow = new Follow(event);
        return follow.reply();
    }

    // 文章で話しかけられたとき（テキストメッセージのイベント）に対応する
    @EventMapping
    public Message handleMessage(MessageEvent<TextMessageContent> event) {
        String text = event.getMessage().getText();
        if (text.equalsIgnoreCase("戦歴")) {
            Senreki senreki = senrekiService.calcSenreki();
            return new SenrekiReply(senrekiService).reply();
        } else {
            return new Parrot(event).reply();
        }
    }

    @EventMapping
    public List<Message> handleJanken(MessageEvent<ImageMessageContent> event) throws Exception {
        // じゃんけんを実施するビジネスサービス層のクラスを呼び出す
        JankenResult jankenResult = jankenService.doJanken(event);

        return List.of(new ImageSizeReply(jankenResult).reply(), new JankenReply(jankenResult).reply());
    }
}