package com.example.linebot.presentation.replier;

import com.example.linebot.presentation.replier.Replier;
import com.example.linebot.service.Senreki;
import com.example.linebot.service.SenrekiService;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import org.springframework.stereotype.Component;

@Component
public class SenrekiReply implements Replier {

    private SenrekiService senrekiService;

    public SenrekiReply(SenrekiService senrekiService) {
        this.senrekiService = senrekiService;
    }

    @Override
    public Message reply() {
        Senreki senreki = senrekiService.calcSenreki();
        String message = String.format("ゲーム回数: %d\n自分の勝った回数: %d\n自分の勝率: %.2f%%",
                senreki.gameCount(), senreki.jibunWinCount(), senreki.jibunWinRate() * 100);
        return new TextMessage(message);
    }
}