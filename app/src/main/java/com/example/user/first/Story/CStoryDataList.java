package com.example.user.first.Story;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.util.Log;

import com.example.user.first.Lib.BlacksheepLib.CWebInterface;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by KICT-15 on 2016-07-05.
 */
public class CStoryDataList
{
    final String img_url = "https://i.ytimg.com/vi/PaBwPRa__ic/hqdefault.jpg?custom=true&w=196&h=110&stc=true&jpg444=true&jpgq=90&sp=68&sigh=";

    class CData
    {
        String m_thumbnail = null;
        String m_title = null;
        String m_ex = null;
        String m_url = null;
        String m_group = null;
        String m_type = null;
        Bitmap bmpIcon = null;
    }

    CData cData = null;

    private String m_thumbnail;
    private String m_title;
    private String m_ex;
    private String m_url;
    private String m_group;
    private String m_type;
    Bitmap bmp;

    public CStoryDataList()
    {

    }

    public CStoryDataList(String thumbnail, String title, String ex, String url, String group, String type)
    {
        this.m_thumbnail = thumbnail;
        this.m_title = title;
        this.m_ex = ex;
        this.m_url = url;
        this.m_group = group;
        this.m_type = type;

        try
        {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
            URL url2 = new URL(img_url + thumbnail);

            CWebInterface.CData cData =  CWebInterface.GetInstance().Find("Img1");

            if(cData == null)
            {
                Log.i("CWebInterface","cInputStream");
            }

            if(cData.eState == CWebInterface.EState.error)
            {
                Log.i("error",cData.strErr);
                return;
            }

            if(cData.byteData == null)
            {


            }

            bmp = BitmapFactory.decodeByteArray(cData.byteData, 0, cData.byteData.length);
            //bmp = cData.bmp;
            //bmp = BitmapFactory.decodeByteArray(cData.byteData,0,cData.byteData.length);
            //bmp = BitmapFactory.decodeStream(cData.url.openConnection().getInputStream());

            //bmp = BitmapFactory.decodeStream(url2.openConnection().getInputStream());

        }
        catch (MalformedURLException e)
        {

        }
        catch (IOException e)
        {

        }
    }

    public String Get_thumbnail()
    {
        return this.m_thumbnail;
    }
    public void Set_thumbnail(String thumbnail)
    {
        this.m_thumbnail = thumbnail;
    }

    public String Get_title()
    {
        return this.m_title;
    }
    public void Set_title(String title)
    {
        this.m_title = title;
    }

    public String Get_ex()
    {
        return this.m_ex;
    }
    public void Set_ex(String ex)
    {
        this.m_ex = ex;
    }

    public String Get_url()
    {
        return this.m_url;
    }
    public void Set_url(String url)
    {
        this.m_url = url;
    }

    public String Get_group()
    {
        return this.m_group;
    }
    public void Set_group(String group)
    {
        this.m_group = group;
    }

    public String Get_type()
    {
        return this.m_type;
    }
    public void Set_type(String type)
    {
        this.m_type = type;
    }

    public Bitmap Get_Bmp()
    {
        return bmp;
    }

    public void SetBmp(Bitmap bmp)
    {
        this.bmp = bmp;
    }
}