package com.example.linebot.service;

//gameCountは自分が勝った回数
//jibunWinCountは自分が勝った回数
//jibunWinRateは自分の勝率
//をそれそれ格納する

public record Senreki(int gameCount,int jibunWinCount,float jibunWinRate) {}
