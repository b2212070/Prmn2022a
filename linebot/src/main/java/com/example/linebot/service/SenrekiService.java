package com.example.linebot.service;

import com.example.linebot.data.JankenLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SenrekiService {

    private JankenLog jankenLog;

    public SenrekiService(JankenLog jankenLog) {
        this.jankenLog = jankenLog;
    }

    public Senreki calcSenreki() {
        //データベースから永続化されたJankenResponseのリストを取得する
        List<JankenResponse> jankenResponses = jankenLog.selectall();
        //(1)ゲーム回数をJankenResponseから計算する
        int gameCount = jankenResponses.size();

        //(2)自分が勝った回数をJankenResponseから計算する
        int jibunWinCount = 0;
        for (JankenResponse response : jankenResponses) {
            if ("勝ち".equals(response.kekka())) {
              jibunWinCount++;
            }
        }

        //(3)ゲーム回数・自分が勝った回数から自分の勝率(float)を計算する
        //ただし、ゲームの回数が0の時は勝率も0にする
        float jibunWinRate = (gameCount != 0) ? ((float) jibunWinCount / gameCount) : 0.0f;

        //(4)Senreki インスタンスを生成して戻り値にする
        Senreki senreki = new Senreki(gameCount, jibunWinCount, jibunWinRate);
        return senreki;
    }



}
