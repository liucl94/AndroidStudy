package com.example.administrator.androidstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    private int mCurrentIndex;

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
        //设置EditText监听器
        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPerson.setName(s.toString());
            }
        });
        //设置单选框监听器
        mSexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.maleRadioButton :
                        mPerson.setSex("男");
                        break;
                    case R.id.femaleRadioButton :
                        mPerson.setSex("女");
                        break;
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
                Toast.makeText(MealsChooseActivity.this, "价格:" + mPrice, Toast.LENGTH_SHORT).show();
            }
        });
        //设置按钮监听器
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });
        mShowToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //下一个时
                if(mShowToggleButton.isChecked()){
                    mCurrentIndex++;
                    //如果结果列表不为空，显示下一个菜品
                    if (mFoodResult != null && mFoodResult.size() > mCurrentIndex ){
                        mFoodImageView.setImageResource(mFoodResult.get(mCurrentIndex).getPicture());
                    }
                    //否则提示用户没有啦
                    else {
                        Toast.makeText(MealsChooseActivity.this, "没有啦", Toast.LENGTH_SHORT).show();
                    }
                }
                //显示信息时
                else {
                    //如果结果列表不为空，显示下一个菜品信息
                    if (mFoodResult != null && mFoodResult.size() > mCurrentIndex ){
                        Toast.makeText(MealsChooseActivity.this, "用户名：" + mPerson.getName() + "\r\n性别：" + mPerson.getSex() + "\r\n菜名：" + mFoodResult.get(mCurrentIndex).getName() + "\r\n价格：" + mFoodResult.get(mCurrentIndex).getPrice(), Toast.LENGTH_SHORT).show();
                    }
                    //否则提示用户没有啦
                    else {
                        Toast.makeText(MealsChooseActivity.this, "没有啦", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    //查找菜品
    private void search() {

        //如果为空则初始化
        if (mFoodResult == null){
            mFoodResult = new ArrayList<>();
        }
        //清空上一次的结果列表
        mFoodResult.clear();
        //结果列表的当前菜品
        mCurrentIndex = 0;
        //遍历所有菜
        for (Food food: mFoods
             ) {
            //菜品价格小于用户设置的价格并且口味有一个符合
            if (food.getPrice() < mPrice &&
                    (food.isHot() == mIsHot || food.isFish() == mIsFish || food.isSour() == mIsSour)){
                //符合条件的结果加入结果列表中
                mFoodResult.add(food);
            }
        }
        //如果结果列表不为空且结果列表有至少有一个菜品，则表示第一个结果列表的菜品图片
        if (mFoodResult != null && mFoodResult.size() > mCurrentIndex ){
            mFoodImageView.setImageResource(mFoodResult.get(mCurrentIndex).getPicture());
            Toast.makeText(MealsChooseActivity.this, "为您找到" + mFoodResult.size() +"道菜！", Toast.LENGTH_SHORT).show();
        }
        //否则提示用户没有符合条件的菜
        else {
            Toast.makeText(MealsChooseActivity.this, "没有符合条件的菜", Toast.LENGTH_SHORT).show();
        }
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
        mPrice = mSeekBar.getProgress();
        mSearchButton =  findViewById(R.id.searchButton);
        mShowToggleButton = findViewById(R.id.showToggleButton);
        mShowToggleButton.setChecked(true);
        mFoodImageView =  findViewById(R.id.foodImageView);
    }

}
