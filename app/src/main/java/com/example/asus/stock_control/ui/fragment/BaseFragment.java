package com.example.asus.stock_control.ui.fragment;

import android.support.v4.app.Fragment;

import com.example.asus.stock_control.ui.listener.BaseFragmentListener;

/**
 * Created by asus on 2018/1/9.
 */

public class BaseFragment extends Fragment implements BaseFragmentListener {
    @Override
    public boolean onBackPress() {
        return false;
    }
}
