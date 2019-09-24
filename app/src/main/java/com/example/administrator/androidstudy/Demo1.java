package com.example.administrator.androidstudy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Demo1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //只使用java代码实现线性布局
        //1.根布局为线性布局
        LinearLayout linearLayout = new LinearLayout(this);
        //2.设置宽高
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        //3.设置背景色为红色
        linearLayout.setBackgroundColor(Color.RED);
        //4.指定此Activity的内容视图为该线性布局
        setContentView(linearLayout);
    }
}
