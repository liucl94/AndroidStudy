package com.example.administrator.androidstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo4_signup);
    }

    public void register(View v){
        //1.判断姓名密码是否为空
        EditText nameEdt = findViewById(R.id.name);
        EditText pwdEdt = findViewById(R.id.pwd);
        final ProgressBar proBar = findViewById(R.id.progress);

        String name = nameEdt.getText().toString();
        String pwd = pwdEdt.getText().toString();

        if(name.equals("") || pwd.equals("")) {
            //2.如果为空，则提示
            //无焦点提示,参数1：环境上下文;参数2：提示信息；参数3：提示时间
            Toast.makeText(this, "姓名或密码不能为空！", Toast.LENGTH_LONG).show();
        } else {
            //3.都不为空，则出现进度条
            proBar.setVisibility(View.VISIBLE);
            new Thread(){
                @Override
                public void run() {
                    for(int i = 1; i <= 100 ; i++){
                        proBar.setProgress(i);
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }

}
