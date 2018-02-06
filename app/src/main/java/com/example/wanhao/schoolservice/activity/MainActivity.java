package com.example.wanhao.schoolservice.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.customizeview.NoScrollViewPager;
import com.example.wanhao.schoolservice.fragment.BBSFagment;
import com.example.wanhao.schoolservice.fragment.MainFragment;
import com.example.wanhao.schoolservice.fragment.MessageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    BottomNavigationView navigation;
    NoScrollViewPager viewPager;
    DrawerLayout drawer;
    NavigationView navigationView;

    private MessageFragment messageFragment;
    private BBSFagment BBSFagment;
    private MainFragment mainFragment;
    private List<Fragment> fragmentList;
    private FragmentPagerAdapter adapter;

    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

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
                }
                return false;
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawer.closeDrawers();
                switch (item.getItemId()){
                    case R.id.main_drawer_message:
                        startActivity(new Intent(MainActivity.this, MessageActivity.class));
                        break;
                    case R.id.main_drawer_collect:
                        break;
                    case R.id.main_drawer_care:
                        startActivity(new Intent(MainActivity.this, CareActivity.class));
                        break;
                    case R.id.main_drawer_leaveword:
                        break;
                    case R.id.main_drawer_exit:
                        startActivity(new Intent(MainActivity.this, LodingActivity.class));
                        break;
                    case R.id.main_drawer_set:
                        startActivity(new Intent(MainActivity.this, SettingActivity.class));
                        break;
                    case R.id.main_drawer_money:
                        break;
                }
                return true;
            }
        });

    }

    private void initView() {

        navigationView =(NavigationView) findViewById(R.id.ac_main_nav);
        navigation = (BottomNavigationView)findViewById(R.id.ac_main_bottom);
        viewPager = (NoScrollViewPager) findViewById(R.id.ac_main_viewpager);
        drawer = (DrawerLayout) findViewById(R.id.ac_main_draw);

        fragmentList = new ArrayList<>();
        mainFragment = new MainFragment();
        messageFragment = new MessageFragment();
        BBSFagment = new BBSFagment();

        fragmentList.add(mainFragment);
        fragmentList.add(messageFragment);
        fragmentList.add(BBSFagment);


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
        viewPager.setOffscreenPageLimit(2);

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
