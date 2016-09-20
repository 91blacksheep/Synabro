package com.example.user.first.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.first.Lib.CTextFileManager;
import com.example.user.first.Loading.Client.CLoading;
import com.example.user.first.UiSetting.CMyText;
import com.example.user.first.Emotion.CEmotion_List;
import com.example.user.first.R;
import com.example.user.first.Setting.CSetting_List;
import com.example.user.first.PlayerView.CStory_Player;
import com.example.user.first.Story.CStoryListClient;
import com.example.user.first.UiSetting.CTextPosition;

public class CHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    /* var */
    ImageView homeStory, homeEmotion, homeMemo, homeWorkshop, homeSetting;
    TextView myText;

    Toolbar toolbar;
    View nav_header_view;
    TextView nav_header_txt;
    NavigationView navigationView;

    String message;

    CTextPosition cTextPosition = null;
    CTextFileManager cTextFileManager = null;

    /* method */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home_layout);

        /**/
        homeStory = (ImageView)findViewById(R.id.home_story);
        homeEmotion = (ImageView)findViewById(R.id.home_emotion);
        homeMemo = (ImageView)findViewById(R.id.home_memo);
        homeWorkshop = (ImageView)findViewById(R.id.home_workshop);
        homeSetting = (ImageView)findViewById(R.id.home_setting);
        myText = (TextView)findViewById(R.id.mytext);

        /* 네비게이션 드로어 초기화 */
        SetNav();
        nav_header_view = navigationView.getHeaderView(0);
        nav_header_txt = (TextView)nav_header_view.findViewById(R.id.mytext);

        /* 나만의 글귀 */
        Intent intent = getIntent();
        message = intent.getStringExtra(CMyText.EXTRA_MESSAGE);
        nav_header_txt.setText(message);
        myText.setText(message);

        cTextFileManager = new CTextFileManager(this);
        cTextFileManager.save(message);
    }

    private void SetNav()
    {
        /**/
        toolbar = (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void onClickButton(View v)
    {
        switch(v.getId())
        {
            case R.id.changetext:
                Intent intent1 = new Intent(getApplicationContext(), CMyText.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.home_story:
                Intent intent2 = new Intent(getApplicationContext(), CStoryListClient.class);
                intent2.putExtra(CLoading.EXTRA_MESSAGE, message);
                startActivity(intent2);
                break;
            case R.id.home_emotion:
                Intent intent3 = new Intent(getApplicationContext(), CEmotion_List.class);
                intent3.putExtra(CLoading.EXTRA_MESSAGE, message);
                startActivity(intent3);
                break;
            case R.id.home_memo:
                Intent intent4 = new Intent(getApplicationContext(), CSetting_List.class);
                intent4.putExtra(CLoading.EXTRA_MESSAGE, message);
                startActivity(intent4);
                break;
            case R.id.home_workshop:
                break;
            case R.id.home_setting:
                break;
        }
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.nav_home)
        {
            Intent intent = new Intent(getApplicationContext(), CHome.class);
            startActivity(intent);
            finish();
        }
        else if (id == R.id.nav_storybook)
        {
            Intent intent = new Intent(getApplicationContext(), CStoryListClient.class);
            startActivity(intent);
            finish();
        }
        else if (id == R.id.nav_emotion_list)
        {
            Intent intent = new Intent(getApplicationContext(), CEmotion_List.class);
            startActivity(intent);
            finish();
        }
        else if (id == R.id.nav_setting)
        {
            Intent intent = new Intent(getApplicationContext(), CSetting_List.class);
            startActivity(intent);
            finish();
        }
        else if (id == R.id.nav_btn4)
        {
            Intent intent = new Intent(getApplicationContext(), CStory_Player.class);
            startActivity(intent);
            finish();
        }
        else if (id == R.id.nav_btn5)
        {

        }
        else if (id == R.id.changetext)
        {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}