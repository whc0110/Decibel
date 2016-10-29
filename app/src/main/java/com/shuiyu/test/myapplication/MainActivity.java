package com.shuiyu.test.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.view.ViewHelper;
import com.shuiyu.test.myapplication.Fragment.Dynamic_Fragment;
import com.shuiyu.test.myapplication.Fragment.Hall_Fragment;
import com.shuiyu.test.myapplication.Fragment.Message_Fragment;
import com.shuiyu.test.myapplication.Fragment.User_Fragment;
import com.zhy.autolayout.AutoLayoutActivity;

import static com.nineoldandroids.view.ViewPropertyAnimator.animate;

public class MainActivity extends AutoLayoutActivity implements View.OnClickListener {

    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        RadioButton main_radio_hall = (RadioButton) findViewById(R.id.main_radio_hall);
        RadioButton main_radio_dynamic = (RadioButton) findViewById(R.id.main_radio_dynamic);
        RadioButton main_radio_message = (RadioButton) findViewById(R.id.main_radio_message);
        RadioButton main_radio_user = (RadioButton) findViewById(R.id.main_radio_user);

        main_radio_hall.setOnClickListener(this);
        main_radio_dynamic.setOnClickListener(this);
        main_radio_message.setOnClickListener(this);
        main_radio_user.setOnClickListener(this);
        //设置初始化页面
        Fragment home_fragment = new Hall_Fragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_framelayout, home_fragment, "hall_fragment")
                .commit();
        main_radio_hall.setChecked(true);
    }

    @Override
    public void onClick(View v) {

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        Fragment hall_fragment = fm.findFragmentByTag("hall_fragment");
        Fragment dynamic_fragment = fm.findFragmentByTag("dynamic_fragment");
        Fragment message_fragment = fm.findFragmentByTag("message_fragment");
        Fragment user_fragment = fm.findFragmentByTag("user_fragment");
        if (hall_fragment != null) {
            ft.hide(hall_fragment);
        }
        if (dynamic_fragment != null) {
            ft.hide(dynamic_fragment);
        }
        if (message_fragment != null) {
            ft.hide(message_fragment);
        }
        if (user_fragment != null) {
            ft.hide(user_fragment);
        }
        animateClickView(v, new ClickAnimation() {
            @Override
            public void onClick(View v) {

            }
        });
        switch (v.getId()) {
            case R.id.main_radio_hall:
                if (hall_fragment == null) {
                    hall_fragment = new Hall_Fragment();
                    ft.add(R.id.main_framelayout, hall_fragment, "hall_fragment");
                } else {
                    ft.show(hall_fragment);
                }
                break;
            case R.id.main_radio_dynamic:
                if (dynamic_fragment == null) {
                    dynamic_fragment = new Dynamic_Fragment();
                    ft.add(R.id.main_framelayout, dynamic_fragment, "dynamic_fragment");
                } else {
                    ft.show(dynamic_fragment);
                }
                break;
            case R.id.main_radio_message:
                if (message_fragment == null) {
                    message_fragment = new Message_Fragment();
                    ft.add(R.id.main_framelayout, message_fragment, "message_fragment");
                } else {
                    ft.show(message_fragment);
                }
                break;
            case R.id.main_radio_user:
                if (user_fragment == null) {
                    user_fragment = new User_Fragment();
                    ft.add(R.id.main_framelayout, user_fragment, "user_fragment");
                } else {
                    ft.show(user_fragment);
                }
                break;
        }
        ft.commit();
    }
    private void animateClickView(final View v, final ClickAnimation callback) {
        float factor = 2;
        animate(v).scaleX(factor).scaleY(factor).alpha(0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                ViewHelper.setScaleX(v, 1);
                ViewHelper.setScaleY(v, 1);
                ViewHelper.setAlpha(v, 1);
                if (callback != null) {
                    callback.onClick(v);
                }
                super.onAnimationEnd(animation);
            }
        });
    }
    public interface ClickAnimation {
        public void onClick(View v);
    }
}
