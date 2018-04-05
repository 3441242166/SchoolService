package com.example.wanhao.schoolservice.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.customizeview.NoScrollViewPager;
import com.example.wanhao.schoolservice.fragment.BBSFagment;
import com.example.wanhao.schoolservice.fragment.MainFragment;
import com.example.wanhao.schoolservice.fragment.MeFragment;
import com.example.wanhao.schoolservice.fragment.MessageFragment;
import com.example.wanhao.schoolservice.util.ActivityCollector;
import com.example.wanhao.schoolservice.util.BottomNavigationViewHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.ac_main_bottom)
    BottomNavigationView navigation;
    @BindView(R.id.ac_main_viewpager)
    NoScrollViewPager viewPager;

    private MessageFragment messageFragment;
    private BBSFagment bbsFagment;
    private MainFragment mainFragment;
    private MeFragment meFragment;

    private List<Fragment> fragmentList;
    private FragmentPagerAdapter adapter;

    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ActivityCollector.addActivity(this);
        ButterKnife.bind(this);
        initView();
        initEvent();

    }

    private void initEvent() {
        viewPager.setNoScroll(true);
        viewPager.setOverScrollMode(viewPager.OVER_SCROLL_NEVER);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.main_menu_home:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.main_menu_message:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.main_menu_bbs:
                        viewPager.setCurrentItem(2);
                        return true;
                    case R.id.main_menu_me:
                        viewPager.setCurrentItem(3);
                        return true;
                }
                return false;
            }
        });



    }

    private void initView() {

        fragmentList = new ArrayList<>();
        mainFragment = new MainFragment();
        messageFragment = new MessageFragment();
        bbsFagment = new BBSFagment();
        meFragment = new MeFragment();

        fragmentList.add(mainFragment);
        fragmentList.add(messageFragment);
        fragmentList.add(bbsFagment);
        fragmentList.add(meFragment);

        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }
            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(5);
        BottomNavigationViewHelper.disableShiftMode(navigation);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
