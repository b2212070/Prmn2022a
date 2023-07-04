package com.example.linebot.data;

import com.example.linebot.service.JankenResponse;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Repository
public class JankenAPI {
    //あなたのEC2の画像の送付先 application.propertiesファイルから読み込まれる
    @Value("${janken.api.url}")
    private String API_URL;

    //Springの機能を使って、HTTPの要求メッセージを作成する
    //(ブラウザに相当する)
    private final RestTemplate restTemplate;

    public JankenAPI(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate=restTemplateBuilder.build();
    }

    public JankenResponse playGame(Resource imageResource){
        //HTTPのヘッダに"multipart/form-data"でデータを送信することを設定する
        //(HTMLの<form...>に対応する)
        HttpHeaders formHeaders =new HttpHeaders();
        formHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        //本来は、HTTPのPOSTは複数の値を送ることができるので、Mapで送信データを定義する
        //HTMLの<input .../>に対応する)
        MultiValueMap<String, Object> map =new LinkedMultiValueMap<>();
        map.add("file",imageResource);

        //HTTPの要求メッセージを作成し、API_URLにPOSTする
        //取得できるデータ(JSON)の形は、JankenResponseに格納できるという想定で行う
        //(HTMLで、FORMの送信ボタンが押された後のブラウザの処理に相当する)
        HttpEntity<MultiValueMap<String,Object>> formEnity =
                new HttpEntity<>(map,formHeaders);
        ResponseEntity<JankenResponse> response =
                restTemplate.postForEntity(API_URL,formEnity,JankenResponse.class);

        //HTTPの返答メッセージから、返答データを取得する
        //(HTMLで、ブラウザの画面が表示されることに対応する)
        return response.getBody();


        //EC2上のじゃんけん処理を呼び出す
        //return new JankenResponse(3,3,3);
    }
}
