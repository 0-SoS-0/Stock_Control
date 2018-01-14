package com.example.asus.stock_control.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.asus.stock_control.R;

import java.util.List;

/**
 * Created by asus on 2018/1/13.
 */

public class Dialog_Transaction_Delete extends Dialog implements View.OnClickListener {


    private Button dialogButtonSubmit;
    private Button dialogButtonCancel;
    private Context context;

    public Dialog_Transaction_Delete(@NonNull Context context, int editor) {
        super(context, editor);
        this.context = context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_activity_editor_delete_transction);
        dialogButtonCancel=findViewById(R.id.dialog_button_cancel);
        dialogButtonSubmit=findViewById(R.id.dialog_button_ok);
        dialogButtonSubmit.setOnClickListener(this);
        dialogButtonCancel.setOnClickListener(this);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        params.width = (int) (displayMetrics.widthPixels * 0.75);
        params.height = (int) (displayMetrics.heightPixels * 0.65);
        window.setAttributes(params);
        //init();
    }

    private void init() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Window window = getWindow();
                WindowManager.LayoutParams params = window.getAttributes();
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                params.width = (int) (displayMetrics.widthPixels * 0.75);
                params.height = (int) (displayMetrics.heightPixels * 0.65);
                window.setAttributes(params);
            }
        });
    }


    @Override
    public void onClick(View v) {
        if (v.equals(dialogButtonSubmit)){
            //提交逻辑
        }
        if (v.equals(dialogButtonCancel)){
            dismiss();
        }

    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, @Nullable Menu menu, int deviceId) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
