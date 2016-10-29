package com.shuiyu.test.myapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shuiyu.test.myapplication.R;

/**
 * Created by Dinosaur on 2016/10/28.
 */

public class Dynamic_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dynamic,container,false);
    }
}
