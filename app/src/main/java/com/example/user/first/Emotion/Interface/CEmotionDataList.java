package com.example.user.first.Emotion.Interface;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.user.first.Lib.BlacksheepLib.CWebInterface;
import com.example.user.first.Lib.CDefineUrl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by 장호 on 2016-09-20.
 */

public class CEmotionDataList
{
    /* class */
    public class CData
    {
        public String strUrl = null;
        public Bitmap bmpIcon = null;
    }

    /* vluse */
    private ArrayList<CEmotionDataList.CData> m_list = null;

    private static CEmotionDataList instance = null;

    /*
     * *
     */

    public static CEmotionDataList GetInstance()
    {
        if(instance != null)
        {
            return instance;
        }

        instance = new CEmotionDataList();

        return instance;
    }

    public void Init(String strJsonArray)
    {
        m_list = new ArrayList<CEmotionDataList.CData>();

        JSONArray jsonArray = null;
        String strImg_url1 = null;

        CEmotionDataList.CData cData = null;
        try
        {
            jsonArray = new JSONArray(strJsonArray);

            /**/
            JSONObject json = null;
            int i = jsonArray.length();
            while (--i >= 0)
            {
                json = jsonArray.getJSONObject(i);

                /**/
                cData = new CEmotionDataList.CData();

                strImg_url1 = json.getString("img_id1");

                cData.strUrl = json.getString("url");

                cData.bmpIcon = null;

                m_list.add(cData);

                CWebInterface.GetInstance().Request("Img" + i, CDefineUrl.gitRes + strImg_url1);

                Log.i("Data:",json.getString("name"));

            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            Log.i("json","json err!! "+e);
        }
    }

    public void LoadingIcon()
    {

        CEmotionDataList.CData cData;
        CWebInterface.CData cWebData = null;
        Bitmap bmp = null;

        int i = 0;
        int size = m_list.size();
        while(i < size)
        {
            cWebData = CWebInterface.GetInstance().Find("Img"+i);

            if(cWebData == null)
                continue;

            if(cWebData.eState == CWebInterface.EState.error)
            {
                Log.i("error",cWebData.strErr);
                return;
            }

            bmp = BitmapFactory.decodeByteArray(cWebData.byteData, 0, cWebData.byteData.length);

            CWebInterface.GetInstance().Remove("Img"+i);

            if(bmp == null)
            {
                Log.i("error","bmp is null");
                return;
            }

            cData = m_list.get(i);

            cData.bmpIcon = bmp;

            i++;
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    //
    public int Size()
    {
        return  m_list.size();
    }

    public CEmotionDataList.CData Get(int idx)
    {
        return m_list.get(idx);
    }
}
