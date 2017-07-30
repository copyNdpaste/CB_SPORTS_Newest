package com.example.mh.cb_sports_festival;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class TabActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Greeting greeting = new Greeting();
                    return greeting;
                case 1:
                    Outline outline = new Outline();
                    return outline;
                case 2:
                    Symbol symbol = new Symbol();
                    return symbol;
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "인사말";
                case 1:
                    return "대회개요";
                case 2:
                    return "상징물";
            }
            return null;
        }
    }

    public void onButtonHomeClicked(View V) { //홈으로 이동
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }
    //햄버거메뉴
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.notice) {
            Toast.makeText(this, "공지사항",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://2017sports.chungbuk.go.kr/www/selectBbsNttList.do?bbsNo=1&key=98"));
            startActivity(intent);
        } else if (id == R.id.news) {
            Toast.makeText(this, "대회뉴스",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://2017sports.chungbuk.go.kr/www/selectBbsNttList.do?bbsNo=21&key=99"));
            startActivity(intent);
        } else if (id == R.id.introduce) {
            Toast.makeText(this, "대회소개",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, TabActivity.class);
            startActivity(intent);
        } else if (id == R.id.game_introduce) {
            Toast.makeText(this, "경기 소개",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Introduce.class);
            startActivity(intent);
        } else if (id == R.id.game_date) {
            Toast.makeText(this, "경기 일정",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://2017sports.chungbuk.go.kr/www/contents.do?key=83"));
            startActivity(intent);
        } else if (id == R.id.stadium) {
            Toast.makeText(this, "경기장 소개",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://2017sports.chungbuk.go.kr/www/selectStadiumIntroList.do?key=85"));
            startActivity(intent);
        } else if (id == R.id.total_ranking) {
            Toast.makeText(this, "종합 순위 ",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://national.sports.or.kr/rankall.do?kind=indexRankAll&gubun=03"));
            startActivity(intent);
        } else if (id == R.id.food_lodge) {
            Toast.makeText(this, "경기장 주변 맛집/숙박",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://tour.chungbuk.go.kr/home/sub.php?menukey=225"));
            startActivity(intent);
        } else if (id == R.id.hotplace) {
            Toast.makeText(this, "관광 명소",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://tour.chungbuk.go.kr/home/sub.php?menukey=222&mod=&page=2&scode=00000002"));
            startActivity(intent);
        } else if (id == R.id.service_call) {
            Toast.makeText(this, "고객센터",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,ServiceCall.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}