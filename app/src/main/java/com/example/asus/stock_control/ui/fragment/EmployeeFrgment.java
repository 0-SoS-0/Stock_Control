package com.example.asus.stock_control.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.asus.stock_control.R;
import com.example.asus.stock_control.adapter.EmployeeAdapter;
import com.example.asus.stock_control.gsonbean.EmployeeAddGsonBean;
import com.example.asus.stock_control.ui.activity.MainActivity;
import com.example.asus.stock_control.ui.activity.PurchaseOrderActivity;
import com.example.asus.stock_control.ui.activity.TransactionActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by asus on 2018/1/11.
 */

public class EmployeeFrgment extends BaseFragment {

    Unbinder unbinder1;
    @BindView(R.id.purchaseOrder)
    Button purchaseOrder;
    @BindView(R.id.transaction)
    Button transaction;
    @BindView(R.id.recyclerView_employee)
    RecyclerView recyclerViewEmployee;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    private View view;
    private MainActivity context;

    private List<EmployeeAddGsonBean> employeeBeanList=new ArrayList<>();
    private EmployeeAdapter employeeAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_fragment_employee, container, false);
        unbinder1 = ButterKnife.bind(this, view);
        intToolbar();
        initView();
        swipeRefreshEmployee();
        return view;
    }

    private void intToolbar() {
        AppCompatActivity activity= (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolBar);
        android.support.v7.app.ActionBar actionBar=activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("产品");
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
        setHasOptionsMenu(true);
    }

    private void initView() {
        purchaseOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PurchaseOrderActivity.class);
                startActivity(intent);

            }
        });

        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TransactionActivity.class);
                startActivity(intent);

            }
        });


    }

    private void swipeRefreshEmployee() {
        swipeRefresh.setColorSchemeResources(R.color.primary_color,R.color.accent_color);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });


    }
    private void adapter() {
       /* LinearLayoutManager layout = new LinearLayoutManager(getContext());
        recyclerViewEmployee.setLayoutManager(layout);
        employeeAdapter= new EmployeeAdapter(employeeBeanList,context);
        noteRecycler.setAdapter(adapter);*/
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }
}
