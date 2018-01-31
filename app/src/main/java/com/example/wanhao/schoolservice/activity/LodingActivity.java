package com.example.wanhao.schoolservice.activity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.presenter.LodingPresenter;
import com.example.wanhao.schoolservice.view.ILodingView;

public class LodingActivity extends AppCompatActivity implements View.OnClickListener,ILodingView {
    private static final String TAG = "LodingActivity";

    TextView forget;
    Button btGo;
    FloatingActionButton fab;
    EditText etUsername;
    EditText etPassword;
    CardView cardView;

    LodingPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initView();

        fab.setOnClickListener(this);
        btGo.setOnClickListener(this);
        forget.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ac_loding_fab:
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this,
                        //Pair.create((View)btGo, btGo.getTransitionName()),
                        Pair.create((View)fab, fab.getTransitionName()),
                        Pair.create((View)cardView, cardView.getTransitionName())).toBundle();
                startActivity(new Intent(this, RegisterActivity.class), bundle);
                break;
            case R.id.ac_loding_loding:
                hideKeyboard();
                presenter.login(etUsername.getText().toString(),etPassword.getText().toString());
                break;
            case R.id.ac_loding_forget:

                break;
        }
    }

    private void initView() {
        etPassword = (EditText) findViewById(R.id.ac_loding_password);
        etUsername = (EditText) findViewById(R.id.ac_loding_count);
        btGo = (Button) findViewById(R.id.ac_loding_loding);
        fab = (FloatingActionButton) findViewById(R.id.ac_loding_fab);
        forget = (TextView) findViewById(R.id.ac_loding_forget);
        cardView = (CardView) findViewById(R.id.ac_loding_cardview);

        presenter = new LodingPresenter(this,this);
    }

    @Override
    public void gotoChooseInterestedCategoryActivity(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void disimissProgress() {

    }

    @Override
    public void loadDataSuccess(Object tData) {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void loadDataError(String throwable) {
        Toast.makeText(this,throwable,Toast.LENGTH_SHORT).show();
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

}

