package com.shuiyu.test.myapplication.Http;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Dinosaur on 2016/10/28.
 */

public class OkHttpUtils {
    public interface OkHttpCon{
        void GetFrom(String result);
    }
    private OkHttpCon mOkHttpCon;
    public void setmOkHttpCon(String url,OkHttpCon mOkHttpCon){
        this.mOkHttpCon = mOkHttpCon;
        HttpConn(url);
    }
    public void  HttpConn(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        final okhttp3.Request request = new okhttp3.Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure() e=" + e);
            }
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                mOkHttpCon.GetFrom(response.body().string());
            }
        });
    }
}
