package com.example.administrator.androidstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.ImageView;

import com.example.administrator.androidstudy.model.Food;
import com.example.administrator.androidstudy.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MealsChooseActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private RadioGroup mSexRadioGroup;
    private CheckBox mHotCheckBox;
    private CheckBox mFishCheckBox;
    private CheckBox mSourCheckBox;
    private SeekBar mSeekBar;
    private Button mSearchButton;
    private ToggleButton mShowToggleButton;
    private ImageView mFoodImageView;
    private List<Food> mFoods;
    private Person mPerson;
    private List<Food> mFoodResult;
    private boolean mIsFish;
    private boolean mIsHot;
    private boolean mIsSour;
    private int mPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_choose);

        //初始化控件
        findViews();
        //初始化数据
        initData();
        //为控件添加监听器，实现基本功能
        setListeners();
        //自测
    }

    private void setListeners() {
        //设置单选框监听器
        mSexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.maleRadioButton :
                        mPerson.setSex("男");
                    case R.id.femaleRadioButton :
                        mPerson.setSex("女");
                }
            }
        });
        //设置复选框的监听器
        mHotCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mIsHot = isChecked;
            }
        });
        mFishCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mIsFish = isChecked;
            }
        });
        mSourCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mIsSour = isChecked;
            }
        });
        //设置SeekBar监听器
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mPrice = seekBar.getProgress();
                Toast.makeText(MealsChooseActivity.this, "价格" + mPrice, Toast.LENGTH_SHORT).show();
            }
        });
        //设置按钮监听器
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mShowToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initData() {
        //创建存放食物的list
        mFoods = new ArrayList<>();

        //初始化添加所有食物数据
        mFoods.add(new Food("麻辣香锅", 55, R.drawable.malaxiangguo, true, false, false));
        mFoods.add(new Food("水煮鱼", 48, R.drawable.shuizhuyu, true, true, false));
        mFoods.add(new Food("麻辣火锅", 80, R.drawable.malahuoguo, true, true, false));
        mFoods.add(new Food("清蒸鲈鱼", 68, R.drawable.qingzhengluyu, false, true, false));
        mFoods.add(new Food("桂林米粉", 15, R.drawable.guilin, false, false, false));
        mFoods.add(new Food("上汤娃娃菜", 28, R.drawable.wawacai, false, false, false));
        mFoods.add(new Food("红烧肉", 60, R.drawable.hongshaorou, false, false, false));
        mFoods.add(new Food("木须肉", 40, R.drawable.muxurou, false, false, false));
        mFoods.add(new Food("酸菜牛肉面", 35, R.drawable.suncainiuroumian, false, false, true));
        mFoods.add(new Food("西芹炒百合", 38, R.drawable.xiqin, false, false, false));
        mFoods.add(new Food("酸辣汤", 40, R.drawable.suanlatang, true, false, true));

        mPerson = new Person();

        mFoodResult = new ArrayList<>();
    }

    private void findViews(){
        mNameEditText = findViewById(R.id.nameEditText);
        mSexRadioGroup = findViewById(R.id.sexRadioGroup);
        mHotCheckBox = findViewById(R.id.hotCheckBox);
        mFishCheckBox = findViewById(R.id.fishCheckBox);
        mSourCheckBox = findViewById(R.id.sourCheckBox);
        mSeekBar = findViewById(R.id.seekBar);
        mSeekBar.setProgress(30);
        mSearchButton =  findViewById(R.id.searchButton);
        mShowToggleButton = findViewById(R.id.showToggleButton);
        mShowToggleButton.setChecked(true);
        mFoodImageView =  findViewById(R.id.foodImageView);
    }

}
