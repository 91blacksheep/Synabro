package com.example.user.first.Story.StoryList.View;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.user.first.Emotion.CEmotion_List;
import com.example.user.first.Home.CHome;
import com.example.user.first.Lib.BlacksheepLib.CWebInterface;
import com.example.user.first.Loading.Parsing.Interface.CStoryList;
import com.example.user.first.Lib.BlacksheepLib.CBSListview;
import com.example.user.first.Lib.BlacksheepLib.CBSListviewAdapter;
import com.example.user.first.Lib.BlacksheepLib.CBSListviewData;
import com.example.user.first.Loading.Parsing.Lib.CStoryData;
import com.example.user.first.R;
import com.example.user.first.Setting.CSetting_List;
import com.example.user.first.Story.Story.PlayerView.CStory_Player;
import com.example.user.first.UiSetting.CMyText;

/**
 * Created by KICT-15 on 2016-07-06.
 */
public class CStoryListClient extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    class CItem extends CBSListviewData
    {
        public String m_thumbnail = null;
        public String m_title = null;
        public String m_ex = null;
        public String m_url = null;
        public String m_group = null;
        public String m_type = null;
        public Bitmap bmpIcon = null;
    }

    /* value */
    //final String url = "https://www.youtube.com/watch?v=";


    CBSListview cBSListview;
    ScrollView scrollView;
    Toolbar toolbar;
    View nav_header_view;
    TextView nav_header_txt;
    NavigationView navigationView;

    String message;

    //public ListView listView;
    public CStoryList cStoryList = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_list_layout);

        /**/
        cStoryList = new CStoryList(this);

        scrollView = (ScrollView)findViewById(R.id.scrView);

        /**/
        ListView listView = (ListView)findViewById(R.id.listView);
        cBSListview = new CBSListview(listView);

        CItem cItem = new CItem();
        cItem.m_thumbnail = "LEnsRQLB4DU";
        cItem.m_title = "세모야 굴러봐";
        cItem.m_ex = "▶ 우울한 마음";
        cItem.m_url = "Z1pgXANlTpA";
        cItem.m_group = "내적";
        cItem.m_type = "미움";

        CWebInterface.CData cData =  CWebInterface.GetInstance().Find("Img1");
        cItem.bmpIcon = BitmapFactory.decodeByteArray(cData.byteData, 0, cData.byteData.length);

        cBSListview.AddItem(cItem);

        cBSListview.OnDraw(OnDraw);

        cBSListview.SetAdapter();


        /* 네비게이션 드로어 초기화 */
        SetNav();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        nav_header_view = navigationView.getHeaderView(0);
        nav_header_txt = (TextView)nav_header_view.findViewById(R.id.mytext);

        /* 나만의 글귀 */
        Intent intent = getIntent();
        message = intent.getStringExtra(CMyText.EXTRA_MESSAGE);
        nav_header_txt.setText(message);

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

            String url = item.m_url;
            String type = item.m_type;

            Intent intent = new Intent(getApplicationContext(), CStory_Player.class);
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
            Intent intent = new Intent(getApplicationContext(), CHome.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_storybook)
        {
            Intent intent = new Intent(getApplicationContext(), CStoryListClient.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_emotion_list)
        {
            Intent intent = new Intent(getApplicationContext(), CEmotion_List.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_setting)
        {
            Intent intent = new Intent(getApplicationContext(), CSetting_List.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_btn4)
        {
            Intent intent = new Intent(getApplicationContext(), CStory_Player.class);
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