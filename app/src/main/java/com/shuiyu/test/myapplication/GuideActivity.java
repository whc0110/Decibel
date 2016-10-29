package com.shuiyu.test.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.shuiyu.test.myapplication.Bean.Guide;
import com.shuiyu.test.myapplication.Http.DemoApi;
import com.shuiyu.test.myapplication.Http.OkHttpUtils;
import com.zhy.autolayout.AutoLayoutActivity;

public class GuideActivity extends AutoLayoutActivity {

    private LinearLayout main_linear_one;
    private LinearLayout main_linear_two;
    private SimpleDraweeView main_image_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        HttpConn(DemoApi.Guide);
        mhandler.sendEmptyMessageDelayed(0, 3000);
    }

    private void initView() {
        main_linear_one = (LinearLayout) findViewById(R.id.main_Linear_one);
        main_linear_two = (LinearLayout) findViewById(R.id.main_Linear_two);
        main_image_type = (SimpleDraweeView) findViewById(R.id.main_image_type);
    }

    Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    main_linear_one.setVisibility(View.GONE);
                    main_linear_two.setVisibility(View.VISIBLE);
                    mhandler.sendEmptyMessageDelayed(2,2000);
                    break;
                case 1:
                    String result = (String) msg.obj;
                    Gson gson = new Gson();
                    Guide guide = gson.fromJson(result,Guide.class);
                    Uri uri = Uri.parse(guide.getData().getBootImg().get(0));
                    main_image_type.setImageURI(uri);
                    Log.e("DemoApi.Guide",guide.toString());
                    break;
                case 2:
                    Intent intent = new Intent(GuideActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    };
    public void  HttpConn(String url) {
        new OkHttpUtils().setmOkHttpCon(url, new OkHttpUtils.OkHttpCon() {
            @Override
            public void GetFrom(String result) {
                Message msg = new Message();
                msg.obj=result;
                msg.what=1;
                mhandler.sendMessage(msg);
            }
        });
    }
}
