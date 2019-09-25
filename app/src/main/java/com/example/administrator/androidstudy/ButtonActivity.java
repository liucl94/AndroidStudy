package com.example.administrator.androidstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        //1.获取按钮
        Button btn1 = findViewById(R.id.btn1);
        //点击事件
        MyOnClickListener mcl = new MyOnClickListener();

        //2.为按钮注册点击事件监听器
        btn1.setOnClickListener(mcl);

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //在控制台输出
                Log.e("Tag", "点击了注册匿名内部类事件监听器对象的按钮");
            }
        });

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.e("Tag", "通过Activity实现点击事件接口");
    }

    public void myClick(View v){
        Log.e("Tag", "XML事件绑定按钮");
    }

    class MyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //在控制台输出一句话
            Log.e("Tag", "点击了注册内部类事件监听器对象的按钮");
        }
    }
}
