package com.example.asus.stock_control.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.asus.stock_control.R;
import com.example.asus.stock_control.ui.fragment.EditorFragment;
import com.example.asus.stock_control.ui.fragment.EmployeeFrgment;
import com.example.asus.stock_control.ui.fragment.ProductFrgment;
import com.example.asus.stock_control.ui.fragment.SupplierFrgment;

public class MainActivity extends BaseAcitivty {

    private BottomNavigationBar navigationBarMain;
    private FragmentManager fragmentManager;
    private EmployeeFrgment employeeFrgment;
    private ProductFrgment productFrgment;
    private SupplierFrgment supplierFrgment;
    private EditorFragment editorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationBarMain=findViewById(R.id.navigation_bar_main);
        fragmentManager=getSupportFragmentManager();
        initFragment();
        initNavigationBar();

    }

    private void initNavigationBar() {
        navigationBarMain.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        navigationBarMain.setBarBackgroundColor(R.color.md_cyan_50);
        navigationBarMain.setActiveColor(R.color.md_teal_A400);
        navigationBarMain.addItem(new BottomNavigationItem(R.drawable.employee, "员工"))
                .addItem(new BottomNavigationItem(R.drawable.product, "产品"))
                .addItem(new BottomNavigationItem(R.drawable.supplier, "供应商"))
                .addItem(new BottomNavigationItem(R.drawable.editor, "编辑"))
                .initialise();

        navigationBarMain.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                changeFragment(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

    }

    //加载主界面
    private void initFragment() {

        employeeFrgment = new EmployeeFrgment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_main, employeeFrgment);
        transaction.commit();
    }

    private void changeFragment(int position) {
        if (fragmentManager.getBackStackEntryCount()>0){
            fragmentManager.popBackStack("000",1);
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (position) {
            case 0:

                if (employeeFrgment==null){
                    // EmployeeFrgment();
                    employeeFrgment = new EmployeeFrgment();
                    transaction.add(R.id.frame_main, employeeFrgment);
                }else {
                    transaction.show(employeeFrgment);
                }
                break;
            case 1:

                if (productFrgment==null){
                    //ProductFrgment();
                    productFrgment=new ProductFrgment();
                    transaction.add(R.id.frame_main, productFrgment);
                }else {
                    transaction.show(productFrgment);
                }
                break;
            case 2:

                if (supplierFrgment==null){
                    // SupplierFrgment();
                    supplierFrgment=new SupplierFrgment();
                    transaction.add(R.id.frame_main, supplierFrgment);
                }
                transaction.show(supplierFrgment);
                break;
            case 3:
                if (editorFragment==null){
                    editorFragment=new EditorFragment();
                    transaction.add(R.id.frame_main,editorFragment);
                }else {
                    transaction.show(editorFragment);
                }

            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (employeeFrgment != null) {
            transaction.hide(employeeFrgment);
        }
        if (productFrgment != null) {
            transaction.hide(productFrgment);
        }
        if (supplierFrgment != null) {
            transaction.hide(supplierFrgment);
        }
        if (editorFragment!=null){
            transaction.hide(editorFragment);
        }

    }
}
