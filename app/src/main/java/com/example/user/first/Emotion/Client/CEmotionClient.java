package com.example.user.first.Emotion.Client;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.first.Emotion.Interface.CEmotionDataList;
import com.example.user.first.Home.CHomeClient;
import com.example.user.first.R;
import com.example.user.first.Setting.CSettingClient;
import com.example.user.first.StoryList.Client.CStoryListClient;
import com.example.user.first.StoryPlayer.Client.CStoryPlayerClient;
import com.example.user.first.UiSetting.CMyText;

import java.util.ArrayList;

/**
 * Created by USER on 2016-06-26.
 */

public class CEmotionClient extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    String message;

    Toolbar toolbar;
    View navHeaderView;
    TextView navHeaderTxt;
    NavigationView navigationView;

    ImageView achievement, anger, autonomy, complex, distrust, fear, happy, industry, lead, sad, senseOfGuilt, shame, trust;

    ArrayList<ImageView> menuList = new ArrayList<ImageView> ();
    ArrayList<CMenuData> menuData = new ArrayList<CMenuData> ();

    class CMenuData
    {
        String m_url = null;
        Bitmap m_bmpIcon = null;
    }

    protected void onCreate ( Bundle savedInstanceState )
    {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.emotion_list_layout );

        /* 메뉴 아이콘 생성 */
        SetMenuID ();
        CEmotionDataList.CData cData = null;

        int size = CEmotionDataList.GetInstance ().Size ();
        int i = 0;
        while ( i < size )
        {
            cData = CEmotionDataList.GetInstance ().Get ( i );

            CMenuData cMenuData = new CMenuData ();

            cMenuData.m_url = cData.strUrl;
            cMenuData.m_bmpIcon = cData.bmpIcon;

            menuData.add ( cMenuData );

            i++;
        }

        size = menuList.size ();
        i = 0;
        while ( i < size )
        {
            //Log.i("menuList", "draw");
            menuList.get ( i ).setImageBitmap ( menuData.get ( i ).m_bmpIcon );
            i++;
        }

        /* 네비게이션 드로어 초기화 */
        SetNav ();

        navigationView = (NavigationView) findViewById ( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener ( this );

        navHeaderView = navigationView.getHeaderView ( 0 );
        navHeaderTxt = (TextView) navHeaderView.findViewById ( R.id.mytext );

        /* 나만의 글귀 */
        Intent intent = getIntent ();
        message = intent.getStringExtra ( CMyText.EXTRA_MESSAGE );
        navHeaderTxt.setText ( message );
    }

    private void SetMenuID ()
    {
        achievement = (ImageView) findViewById ( R.id.emotion_achievement );
        anger = (ImageView) findViewById ( R.id.emotion_anger );
        autonomy = (ImageView) findViewById ( R.id.emotion_autonomy );
        complex = (ImageView) findViewById ( R.id.emotion_complex );
        distrust = (ImageView) findViewById ( R.id.emotion_distrust );
        fear = (ImageView) findViewById ( R.id.emotion_fear );
        happy = (ImageView) findViewById ( R.id.emotion_happy );
        industry = (ImageView) findViewById ( R.id.emotion_industry );
        lead = (ImageView) findViewById ( R.id.emotion_lead );
        sad = (ImageView) findViewById ( R.id.emotion_sad );
        senseOfGuilt = (ImageView) findViewById ( R.id.emotion_sense_of_guilt );
        shame = (ImageView) findViewById ( R.id.emotion_shame );
        trust = (ImageView) findViewById ( R.id.emotion_trust );

        /*  */
        menuList.add ( happy );
        menuList.add ( sad );
        menuList.add ( achievement );
        menuList.add ( anger );
        menuList.add ( trust );
        menuList.add ( distrust );
        menuList.add ( autonomy );
        menuList.add ( shame );
        menuList.add ( lead );
        menuList.add ( senseOfGuilt );
        menuList.add ( industry );
        menuList.add ( complex );
        menuList.add ( fear );
    }

    private void SetNav ()
    {
        /**/
        toolbar = (Toolbar) findViewById ( R.id.toolbar );

        setSupportActionBar ( toolbar );
        getSupportActionBar ().setTitle ( null );

        DrawerLayout drawer = (DrawerLayout) findViewById ( R.id.drawer_layout );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle (
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.setDrawerListener ( toggle );
        toggle.syncState ();
    }

    public void onClickButton ( View v )
    {
        switch ( v.getId () )
        {

        }
    }

    @Override
    public void onBackPressed ()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById ( R.id.drawer_layout );
        if ( drawer.isDrawerOpen ( GravityCompat.START ) )
        {
            drawer.closeDrawer ( GravityCompat.START );
        }
        else
        {
            super.onBackPressed ();
        }
    }

    @SuppressWarnings ( "StatementWithEmptyBody" )
    @Override
    public boolean onNavigationItemSelected ( MenuItem item )
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId ();

        if ( id == R.id.nav_home )
        {
            Intent intent = new Intent ( getApplicationContext (), CHomeClient.class );
            startActivity ( intent );
        }
        else if ( id == R.id.nav_storybook )
        {
            Intent intent = new Intent ( getApplicationContext (), CStoryListClient.class );
            startActivity ( intent );
        }
        else if ( id == R.id.nav_emotion_list )
        {
            Intent intent = new Intent ( getApplicationContext (), CEmotionClient.class );
            startActivity ( intent );
        }
        else if ( id == R.id.nav_setting )
        {
            Intent intent = new Intent ( getApplicationContext (), CSettingClient.class );
            startActivity ( intent );
        }
        else if ( id == R.id.nav_btn4 )
        {
            Intent intent = new Intent ( getApplicationContext (), CStoryPlayerClient.class );
            startActivity ( intent );
        }
        else if ( id == R.id.nav_btn5 )
        {

        }
        else if ( id == R.id.changetext )
        {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById ( R.id.drawer_layout );
        drawer.closeDrawer ( GravityCompat.START );

        return true;
    }
}
