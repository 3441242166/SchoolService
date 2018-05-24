package com.example.wanhao.schoolservice.util;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class JsonUtil {
    private static final String TAG = "JsonUtil";

    public static RequestBody getJsonBody(HashMap<String,String> map){

        String jsonString = new Gson().toJson(map);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonString);
        return body;
    }

}
