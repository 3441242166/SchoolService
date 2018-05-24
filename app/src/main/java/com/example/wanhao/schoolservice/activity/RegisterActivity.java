package com.example.wanhao.schoolservice.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.presenter.RegisterPresenter;
import com.example.wanhao.schoolservice.view.IRegisterView;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,IRegisterView{
    private static final String TAG = "RegisterActivity";

    @BindView(R.id.ac_register_loding)
    Button btGo;
    @BindView(R.id.ac_register_fab)
    FloatingActionButton fab;
    @BindView(R.id.ac_register_count)
    EditText etUsername;
    @BindView(R.id.ac_register_password)
    EditText etPassword;
    @BindView(R.id.ac_register_code)
    EditText etCode;
    @BindView(R.id.ac_register_getcode)
    TextView tvCode;
    private MaterialDialog dialog;

    private RegisterPresenter presenter;

    CountDownTimer timer = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            tvCode.setText(millisUntilFinished/1000 + "秒");
        }

        @Override
        public void onFinish() {
            tvCode.setClickable(true);
            tvCode.setText("获取验证码");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        InitView();
    }

    private void InitView() {
        presenter = new RegisterPresenter(this,this);

        btGo.setOnClickListener(this);
        fab.setOnClickListener(this);
        tvCode.setOnClickListener(this);

        MaterialDialog.Builder builder = new MaterialDialog.Builder(this)
                .title("Zzz...")
                .content("加载中...")
                .progress(true,100,false);
        dialog = builder.build();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ac_register_loding:
                presenter.register(etUsername.getText().toString(),etPassword.getText().toString(),etCode.getText().toString());
                break;
            case R.id.ac_register_getcode:
                presenter.getVerificationCode(etUsername.getText().toString(), tvCode, timer);
                break;
            case R.id.ac_register_fab:
                onBackPressed();
                break;
        }
    }

    @Override
    public void showProgress() {
        dialog.show();
    }

    @Override
    public void dismissProgress() {
        dialog.dismiss();
    }

    @Override
    public void loadDataSuccess(Object tData) {
        finish();
    }

    @Override
    public void loadDataError(String throwable) {
        Toasty.error(this,throwable,Toast.LENGTH_SHORT,true).show();
    }
}
