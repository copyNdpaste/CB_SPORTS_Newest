package com.example.mh.cb_sports_festival;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LayoutAnimationController;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Introduce extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ExpandableListView eList;
    private ExpandableListAdapter adapter;
    private LayoutAnimationController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce_navigation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        eList = (ExpandableListView) findViewById(R.id.elist);
        eList.setGroupIndicator(null);
        eList.setChildIndicator(null);
        adapter = new MyExpandableListAdapter();
        eList.setAdapter(adapter);
        eList.setLayoutAnimation(controller);
        eList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                if (eList.isGroupExpanded(groupPosition) != true) {
                    int groupCount = eList.getCount();
                    for (int i = 0; i <= groupCount; i++) {
                        eList.collapseGroup(i);
                    }
                    eList.expandGroup(groupPosition);
                    return true;
                } else {
                    return false;
                }
            }
        });

        eList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                ExpandableListAdapter adap = parent.getExpandableListAdapter();
                int gp = (int) adap.getGroupId(groupPosition);
                int cp = (int) adap.getChildId(groupPosition, childPosition);
                if (gp == 0) {
                    switch (cp) {
                        case 0:
                            Intent intent = new Intent(getApplicationContext(),
                                    TabActivity.class);
                            startActivity(intent);
                            break;
                        case 1:
                            Intent intent1 = new Intent(getApplicationContext(),
                                    TabActivity.class);
                            startActivity(intent1);
                    }
                } else if (gp == 1) {
                    switch (cp) {
                        case 0:
                            Intent intent = new Intent(getApplicationContext(),
                                    TabActivity.class);
                            startActivity(intent);
                            break;
                        case 1:
                            Intent intent1 = new Intent(getApplicationContext(),
                                    TabActivity.class);
                            startActivity(intent1);
                            break;
                    }
                }

                return true;
            }

        });

        String[] groups = { "ㄱ", "ㄴ", "ㄷ","ㄹ","ㅂ","ㅅ","ㅇ","ㅈ","ㅊ","ㅋ","ㅌ","ㅎ"}; //눈에 보이는 곳
        String[][] children = {
                {"검도", "골프", "궁도","근대5종"},
                {"농구"},
                {"당구", "댄스스포츠"},
                {"럭비","레슬링","롤러"},
                {"바둑","배구","배드민턴","보디빌딩","복싱","볼링"},
                {"사격","산악","세일링","세팍타크로","수상스키","수영","스쿼시","승마","씨름"},
                {"야구소프트볼(야구)","양궁","역도","우슈","유도","육상"},
                {"자전거","정구","조정"},
                {"철인3종","체조","축구"},
                {"카누"},
                {"탁구","태권도","택견","테니스"},
                {"펜싱","핀수영"},
                {"하키","핸드볼"},
        };

        List<Map<String, String>> provData
                =new ArrayList<>();
        List<List<Map<String, String>>> cityData
                =new ArrayList<>();

        for(int i=0; i<groups.length; i++) {
            Map<String, String> prov =  new HashMap<>();
            prov.put("prov",groups[i]);
            provData.add(prov);

            List<Map<String,String>> cityes
                    =new ArrayList<>();
            for (int j=0; j<children[i].length; j++){
                Map<String, String> city
                        =new HashMap<>();
                city.put("city", children[i][j]);
                cityes.add(city);
            }//데이터
            cityData.add(cityes);
        }
        ExpandableListAdapter adapter
                =new SimpleExpandableListAdapter(
                this,
                provData,
                android.R.layout.simple_expandable_list_item_1,
                new String[] {"prov"},
                new int[] {android.R.id.text1},
                cityData,
                android.R.layout.simple_expandable_list_item_1,
                new String[] {"city"},
                new int[] {android.R.id.text1}
        );
        ExpandableListView expandableListView
                = (ExpandableListView)findViewById(R.id.elist);
        expandableListView.setAdapter(adapter);
    }

    class MyExpandableListAdapter extends BaseExpandableListAdapter {

        String[] groups = { "ㄱ", "ㄴ", "ㄷ","ㄹ","ㅂ","ㅅ","ㅇ","ㅈ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ" };
        String[][] children = {
                {"검도", "골프", "궁도","근대5종"},
                {"농구"},
                {"당구", "댄스스포츠"},
                {"럭비","레슬링","롤러"},
                {"바둑","배구","배드민턴","보디빌딩","복싱","볼링"},
                {"사격","산악","세일링","세팍타크로","수상스키","수영","스쿼시","승마","씨름"},
                {"야구소프트볼(야구)","양궁","역도","우슈","유도","육상"},
                {"자전거","정구","조정"},
                {"철인3종","체조","축구"},
                {"카누"},
                {"탁구","태권도","택견","테니스"},
                {"펜싱","핀수영"},
                {"하키","핸드볼"}
        };

        public Object getChild(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return children[groupPosition][childPosition];
        }

        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        public int getChildrenCount(int groupPosition) {
            int i = 0;
            try {
                i = children[groupPosition].length;
            } catch (Exception e) {

            }
            return i;
        }

        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        public int getGroupCount() {
            return groups.length;
        }

        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            TextView tv = getGenericView();
            tv.setText(getGroup(groupPosition).toString());
            return tv;
        }

        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {

            TextView tv = getGenericView();
            tv.setText(getChild(groupPosition, childPosition).toString());
            return tv;
        }

        public TextView getGenericView() {
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT, 64);
            TextView tv = new TextView(getBaseContext());

            tv.setLayoutParams(lp);
            tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            tv.setTextColor(Color.WHITE);
            return tv;
        }

        public boolean hasStableIds() {
            return true;
        }

        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
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
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
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