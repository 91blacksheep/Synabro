package com.example.user.first.StoryList.Client;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.user.first.Emotion.Client.CEmotionClient;
import com.example.user.first.Home.CHomeClient;
import com.example.user.first.Lib.BlacksheepLib.CBSListview;
import com.example.user.first.Lib.BlacksheepLib.CBSListviewAdapter;
import com.example.user.first.Lib.BlacksheepLib.CBSListviewData;
import com.example.user.first.R;
import com.example.user.first.Setting.CSettingClient;
import com.example.user.first.StoryPlayer.Client.CStoryPlayerClient;
import com.example.user.first.StoryList.Interface.CStoryDataList;
import com.example.user.first.UiSetting.CMyText;

/**
 * Created by KICT-15 on 2016-07-06.
 */
public class CStoryListClient extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    class CItem extends CBSListviewData
    {
        String m_title = null;
        String m_ex = null;
        String m_url = null;
        String m_group = null;
        String m_type = null;
        Bitmap bmpIcon = null;
    }

    /* value */
    final String url = "https://www.youtube.com/watch?v=";


    CBSListview cBSListview;
    ScrollView scrollView;
    Toolbar toolbar;
    View navHeaderView;
    TextView navHeaderTxt;
    NavigationView navigationView;

    String message;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_list_layout);

        /**/
        scrollView = (ScrollView)findViewById(R.id.scrView);

        /**/
        ListView listView = (ListView)findViewById(R.id.listView);
        cBSListview = new CBSListview(listView);

        CStoryDataList.CData cData;
        int i = CStoryDataList.GetInstance().Size();
        while(--i >= 0)
        {
            cData = CStoryDataList.GetInstance().Get(i);

            CItem cItem = new CItem();
            cItem.m_title = cData.strTitle;
            cItem.m_ex = cData.strEx;
            cItem.m_url = cData.strUrl;
            cItem.m_group = cData.strGroup;
            cItem.m_type = cData.strType;
            cItem.bmpIcon = cData.bmpIcon;

            cBSListview.AddItem(cItem);
        }

        cBSListview.OnDraw(OnDraw);

        cBSListview.SetAdapter();


        /* 네비게이션 드로어 초기화 */
        SetNav();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navHeaderView = navigationView.getHeaderView(0);
        navHeaderTxt = (TextView)navHeaderView.findViewById(R.id.mytext);

        /* 나만의 글귀 */
        Intent intent = getIntent();
        message = intent.getStringExtra(CMyText.EXTRA_MESSAGE);
        navHeaderTxt.setText(message);

        /* 리스트 아이템 Init*/
        //listView.setAdapter(cStoryList);
        listView.setOnItemClickListener(mItemClickListener);
    }

    CBSListviewAdapter.Draw OnDraw = new CBSListviewAdapter.Draw()
    {
        @Override
        public View OnDraw(int position, View convertView, ViewGroup parent)
        {
            Context context = parent.getContext();

            // "listview_item" Layout을 inflate하여 convertView 참조 획득.
            if (convertView == null)
            {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.story_list_item, parent, false);
            }

            /**/
            CItem listViewItem = (CItem)cBSListview.GetItem(position);

            ImageView iconImageView = (ImageView) convertView.findViewById(R.id.thumbnail) ;
            iconImageView.setImageBitmap(listViewItem.bmpIcon);

            TextView titleTextView = (TextView) convertView.findViewById(R.id.titleText) ;
            titleTextView.setText(listViewItem.m_title);
            titleTextView.setSelected(true);    //글이 길면 흐르는 효과

            TextView descTextView = (TextView) convertView.findViewById(R.id.exText) ;
            descTextView.setText(listViewItem.m_ex);
            descTextView.setSelected(true);     //글이 길면 흐르는 효과

            return convertView;
        }
    };

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
        /*switch(v.getId())
        {
            case R.id.btnAll:
                cStoryList.OnClickTapAll();
                listView.smoothScrollToPosition(0);
                break;
            case R.id.btnInner:
                cStoryList.OnClickTapInner();
                listView.smoothScrollToPosition(0);
                break;
            case R.id.btnEx:
                cStoryList.OnClickTapEx();
                listView.smoothScrollToPosition(0);
                break;
            case R.id.btnTop:
                listView.smoothScrollToPosition(0);
                break;
        }*/
    }

    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long l_position)
        {
            CItem item = (CItem)parent.getItemAtPosition(position);

            Log.i("Play:",item.m_url);

            String url = item.m_url;
            String type = item.m_type;

            Intent intent = new Intent(getApplicationContext(), CStoryPlayerClient.class);
            intent.putExtra("url", url);
            intent.putExtra("type", type);
            startActivityForResult(intent, 0);
        }
    };

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
            Intent intent = new Intent(getApplicationContext(), CHomeClient.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_storybook)
        {
            Intent intent = new Intent(getApplicationContext(), CStoryListClient.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_emotion_list)
        {
            Intent intent = new Intent(getApplicationContext(), CEmotionClient.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_setting)
        {
            Intent intent = new Intent(getApplicationContext(), CSettingClient.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_btn4)
        {
            Intent intent = new Intent(getApplicationContext(), CStoryPlayerClient.class);
            startActivity(intent);
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