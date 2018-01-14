package com.example.asus.stock_control.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.stock_control.R;
import com.example.asus.stock_control.ui.activity.SupplierAddActivity;
import com.example.asus.stock_control.ui.activity.SupplierDeleteActivity;
import com.example.asus.stock_control.ui.activity.SupplierEditorActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by asus on 2018/1/11.
 */

public class SupplierFrgment extends BaseFragment {
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.recyclerView_supplier)
    RecyclerView recyclerViewSupplier;
    @BindView(R.id.swipeRefresh_supplier)
    SwipeRefreshLayout swipeRefreshSupplier;
    Unbinder unbinder;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_fragment_supplier, container, false);
        unbinder = ButterKnife.bind(this, view);
        inittoobar();
        swipeRefresh();
        initView();
        return view;
    }

    private void inittoobar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolBar);
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("供应商");
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
        setHasOptionsMenu(true);
    }

    private void initView() {//recycleview
    }

    private void swipeRefresh() {//网络访问
        swipeRefreshSupplier.setColorSchemeResources(R.color.primary_color,R.color.accent_color);
        swipeRefreshSupplier.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_activity_supplier,menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.menu_add_supplier){
            Intent intent=new Intent(getActivity(), SupplierAddActivity.class);
            startActivity(intent);
        }
        if (item.getItemId()==R.id.menu_editor_supplier){
            Intent intent=new Intent(getActivity(), SupplierEditorActivity.class);
            startActivity(intent);
        }
        if (item.getItemId()==R.id.menu_delete_supplier){
            Intent intent=new Intent(getActivity(), SupplierDeleteActivity.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.menu_select_supplier){
            Intent intent=new Intent(getActivity(), SupplierDeleteActivity.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
