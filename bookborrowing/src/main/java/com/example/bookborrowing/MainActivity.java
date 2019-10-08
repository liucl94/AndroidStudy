package com.example.bookborrowing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mUserNameEditText;
    private RadioGroup mSexRadioGroup;
    private EditText mBorrowingTimeEditText;
    private CheckBox mHistoryCheckBox;
    private CheckBox mSuspenseCheckBox;
    private CheckBox mArtCheckBox;
    private TextView mAgeTextView;
    private SeekBar mAgeSeekBar;
    private ImageView mBookImageView;
    private TextView mBookNameTextView;
    private TextView mBookTypeTextView;
    private TextView mApplicableAgeTextView;
    private Button searchButton;
    private TextView mResultTextView;
    private Button mNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        findViews();
        //初始化数据
        initData();
        //添加监听器
        setListeners();
        //自测
    }

    private void setListeners() {
    }

    private void initData() {
    }

    private void findViews() {
        mUserNameEditText = findViewById(R.id.userNameEditText);
        mSexRadioGroup = findViewById(R.id.sexRadioGroup);
        mBorrowingTimeEditText = findViewById(R.id.borrowingTimeEditText);
        mHistoryCheckBox = findViewById(R.id.historyCheckBox);
        mSuspenseCheckBox = findViewById(R.id.suspenseCheckBox);
        mArtCheckBox = findViewById(R.id.artCheckBox);
        mAgeTextView = findViewById(R.id.ageTextView);
        mAgeSeekBar = findViewById(R.id.ageSeekBar);
        mBookImageView = findViewById(R.id.bookImageView);
        mBookNameTextView = findViewById(R.id.bookNameTextView);
        mBookTypeTextView = findViewById(R.id.bookTypeTextView);
        mApplicableAgeTextView = findViewById(R.id.applicableAgeTextView);
        searchButton = findViewById(R.id.searchButton);
        mResultTextView = findViewById(R.id.resultTextView);
        mNextButton = findViewById(R.id.nextButton);

        mAgeSeekBar.setProgress(18);
        Integer mAge = mAgeSeekBar.getProgress();
        mAgeTextView.setText(mAge.toString());
    }
}
