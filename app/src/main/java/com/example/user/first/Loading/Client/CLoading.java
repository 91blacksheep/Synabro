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

    final String img_url = "https://i.ytimg.com/vi/PaBwPRa__ic/hqdefault.jpg?custom=true&w=196&h=110&stc=true&jpg444=true&jpgq=90&sp=68&sigh=";

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

        CWebInterface.GetInstance().Request("Img1",img_url+"LEnsRQLB4DU");
        CWebInterface.GetInstance().Request("Img2",img_url+"LEnsRQLB4DU");
        CWebInterface.GetInstance().Request("Img3",img_url+"LEnsRQLB4DU");
        CWebInterface.GetInstance().Request("Img4",img_url+"LEnsRQLB4DU");
        CWebInterface.GetInstance().Request("Img5",img_url+"LEnsRQLB4DU");
        CWebInterface.GetInstance().Request("Img6",img_url+"LEnsRQLB4DU");
        CWebInterface.GetInstance().Request("Img7",img_url+"LEnsRQLB4DU");
        CWebInterface.GetInstance().Request("Img8",img_url+"LEnsRQLB4DU");
        CWebInterface.GetInstance().Request("Img9",img_url+"LEnsRQLB4DU");
        CWebInterface.GetInstance().Request("Img10",img_url+"LEnsRQLB4DU");
        CWebInterface.GetInstance().Request("Img11",img_url+"LEnsRQLB4DU");
        CWebInterface.GetInstance().Request("Img12",img_url+"LEnsRQLB4DU");
        CWebInterface.GetInstance().Request("Img13",img_url+"LEnsRQLB4DU");
        CWebInterface.GetInstance().Request("Img14",img_url+"LEnsRQLB4DU");
        CWebInterface.GetInstance().Request("Img15",img_url+"LEnsRQLB4DU");

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
