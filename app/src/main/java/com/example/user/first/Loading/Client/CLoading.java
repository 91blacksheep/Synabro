package com.example.user.first.Loading.Client;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.user.first.Home.CHome;
import com.example.user.first.Lib.CTextFileManager;
import com.example.user.first.Lib.BlacksheepLib.CWebInterface;
import com.example.user.first.R;

/**
 * Created by Administrator on 2016-07-22.
 */
public class CLoading extends AppCompatActivity
{
    final String img_url1 = "https://i.ytimg.com/vi/";
    final String img_url2 = "/hqdefault.jpg?custom=true&w=196&h=110&stc=true&jpg444=true&jpgq=90&sp=68&sigh=";

    TextView TView;
    String str;

    public final static String EXTRA_MESSAGE = "unikys.todo.MESSAGE";

    CTextFileManager cTextFileManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);

        cTextFileManager = new CTextFileManager(this);
        str = cTextFileManager.load();

        TView = (TextView)findViewById(R.id.loading);

        CWebInterface.GetInstance().Enter();

        CWebInterface.GetInstance().Request("Img1",img_url1+ "Z1pgXANlTpA" + img_url2 + "xepddd37db0XArMi49LZlYHV6N4");
        CWebInterface.GetInstance().Request("Img1",img_url1+ "JwGCwxl1jEg" + img_url2 + "6r8zj-eF6THa0VgQvLJM7tJGO-U");
        CWebInterface.GetInstance().Request("Img1",img_url1+ "1n73jHf48gc" + img_url2 + "2ih4gpzbIOduHl_wza-ZYjLnTeY");
        CWebInterface.GetInstance().Request("Img1",img_url1+ "eHlSmYmpln0" + img_url2 + "zSQNEOzvBsNsT3-CR2taQg5ZA88");
        CWebInterface.GetInstance().Request("Img1",img_url1+ "NKdz3G8fgQ4" + img_url2 + "cPuYeUBqheQdO0omsWn4QPgmiKc");
        CWebInterface.GetInstance().Request("Img1",img_url1+ "sfsXNdKRWXg" + img_url2 + "SG_v4uWRY_BM16prvpKeme4A520");

        CWebInterface.GetInstance().SetRequestCallback(new CWebInterface.RequestCallback()
        {
            public void OnRequestCallback()
            {
                Intent intent = new Intent(getApplicationContext(), CHome.class);
                String message = str;
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                finish();
            }
        });
    }
}
