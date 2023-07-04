package com.example.linebot.data;

import com.example.linebot.service.JankenResponse;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;

@Repository
public class JankenLog {
    //Spring Frame のデータベース接続ライブラリを利用する
    private JdbcTemplate jdbcTemplate;

    //Spring Framework のデータベース接続ライブラリを利用する
    public JankenLog(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //janken_log テーブルにJankenResponseのデータを記録する(永続化)
    //戻り値のnはデータベースに記録できた行数
    public int insert(JankenResponse response){
        String sql = "insert into janken_log VALUES(?,?,?)";
        int n = jdbcTemplate.update(
                sql,response.jibun(),response.aite(),response.kekka());
        return n;
    }

    //janken_log テーブルに記録された全てのデータをJankenResponse のリストとして取得する
    public List<JankenResponse> selectall(){
        String sql = "select jibun,aite,kekka from janken_log";
        List<JankenResponse> selected
                =jdbcTemplate.query(
                        sql,new DataClassRowMapper<>(JankenResponse.class));
        return selected;
    }
}
