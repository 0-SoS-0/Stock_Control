package com.example.asus.stock_control.ui.activity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.asus.stock_control.R;
import com.example.asus.stock_control.dialog.Dialog_Employee_Add;
import com.example.asus.stock_control.dialog.Dialog_Employee_Delete;
import com.example.asus.stock_control.dialog.Dialog_Employee_Editor;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/1/12.
 */

public class EditorActivity extends BaseAcitivty implements View.OnClickListener {
    @BindView(R.id.add)
    ImageView add;
    @BindView(R.id.delete)
    ImageView delete;
    @BindView(R.id.editor)
    ImageView editor;
    @BindView(R.id.tool_bar)
    Toolbar toolBar;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        ButterKnife.bind(this);
        setSupportActionBar(toolBar);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDefaultDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.go_back);
            actionBar.setTitle("编辑");
        }
        add.setOnClickListener(this);
        delete.setOnClickListener(this);
        editor.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.equals(add)) {
            Dialog dialogAdd = new Dialog_Employee_Add(EditorActivity.this, R.style.editor);
            dialogAdd.setContentView(R.layout.dialog_activity_editor_add_employee);
            dialogAdd.show();
        }

        if (v.equals(editor)) {
            Dialog dialogEditor = new Dialog_Employee_Editor(EditorActivity.this, R.style.editor);
            dialogEditor.setContentView(R.layout.dialog_activity_editor_editor_employee);
            dialogEditor.show();

        }
        if (v.equals(delete)) {
            Dialog dialogDelete = new Dialog_Employee_Delete(EditorActivity.this, R.style.editor);
            dialogDelete.setContentView(R.layout.dialog_activity_editor_delete_employee);
            dialogDelete.show();

        }
    }
}
