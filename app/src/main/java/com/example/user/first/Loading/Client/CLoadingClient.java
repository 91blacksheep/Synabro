package com.example.user.first.Loading.Client;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.user.first.Home.CHomeClient;
import com.example.user.first.Lib.CTextFileManager;
import com.example.user.first.Lib.BlacksheepLib.CWebInterface;
import com.example.user.first.Loading.Interface.CLoader;
import com.example.user.first.R;

/**
 * Created by Administrator on 2016-07-22.
 */
public class CLoadingClient extends AppCompatActivity
{

    CLoader m_cLoader = null;
    TextView TView;
    String str;

    public final static String EXTRA_MESSAGE = "unikys.todo.MESSAGE";

    CTextFileManager cTextFileManager = null;

    /*
    * *
    */

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);

        cTextFileManager = new CTextFileManager(this);
        str = cTextFileManager.load();

        TView = (TextView)findViewById(R.id.loading);

        /**/
        CWebInterface.DestroyInstance();

        /**/
        CWebInterface.GetInstance().Enter();

        m_cLoader = new CLoader();

        m_cLoader.start();

        m_cLoader.SetEndCallback(new CLoader.EndCallback()
        {
            public void OnEndCallback()
            {
                //Log.i("web",cData.byteData.toString());

                CWebInterface.GetInstance().Exit();
                m_cLoader.Exit();
                m_cLoader = null;

                Intent intent = new Intent(getApplicationContext(), CHomeClient.class);
                String message = str;
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    protected void onDestroy()
    {
        Log.i("System","onDestroy");

        if(m_cLoader != null)
        {
            m_cLoader.Exit();
            m_cLoader = null;

            CWebInterface.GetInstance().ResClear();
            CWebInterface.GetInstance().Exit();
        }
        super.onDestroy();
    }
}
