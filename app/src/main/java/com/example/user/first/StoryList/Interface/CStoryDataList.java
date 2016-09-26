package com.example.user.first.StoryList.Interface;

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
 * Created by KICT-15 on 2016-07-05.
 */
public class CStoryDataList
{
    /* class */
    public class CData
    {
        public String strTitle = null;
        public String strEx = null;
        public String strUrl = null;
        public String strGroup = null;
        public String strType = null;

        public Bitmap bmpIcon = null;
    }

    /* vluse */
    private ArrayList<CData> m_list = null;

    private static CStoryDataList instance = null;

    /*
     * *
     */

    public static CStoryDataList GetInstance ()
    {
        if ( instance != null )
        {
            return instance;
        }

        instance = new CStoryDataList ();

        return instance;
    }

    public void Init ( String strJsonArray )
    {
        m_list = new ArrayList<CData> ();

        JSONArray jsonArray = null;
        String strImg_url1 = null;
        String strImg_url2 = null;

        CData cData = null;
        try
        {
            jsonArray = new JSONArray ( strJsonArray );
            //jsonArray = new JSONArray("[ { \"name\": \"세모야 굴러봐\", \"type\": \"미움\", \"group\": \"내적\", \"subtitle\": \"▶ 미운마음, 미운 친구\", \"img_id1\": \"Z1pgXANlTpA\", \"img_id2\": \"xepddd37db0XArMi49LZlYHV6N4\" }, { \"name\": \"나도공주\", \"type\": \"질투\", \"group\": \"내적\", \"subtitle\": \"▶ 질투\", \"img_id1\": \"JwGCwxl1jEg\", \"img_id2\": \"6r8zj-eF6THa0VgQvLJM7tJGO-U\" }, { \"name\": \"리본마을\", \"type\": \"소리지르기\", \"group\": \"외적\", \"subtitle\": \"▶ 소리지르기\", \"img_id1\": \"1n73jHf48gc\", \"img_id2\": \"2ih4gpzbIOduHl_wza-ZYjLnTeY\" }, { \"name\": \"띵똥땡똥똥띵땡똥\", \"type\": \"가족관계\", \"group\": \"외적\", \"subtitle\": \"▶ 가족관계\", \"img_id1\": \"eHlSmYmpln0\", \"img_id2\": \"zSQNEOzvBsNsT3-CR2taQg5ZA88\" }, { \"name\": \"어두운밤\", \"type\": \"두려움\", \"group\": \"내적\", \"subtitle\": \"▶ 두려움\", \"img_id1\": \"NKdz3G8fgQ4\", \"img_id2\": \"cPuYeUBqheQdO0omsWn4QPgmiKc\" }, { \"name\": \"콩닥철썩파도\", \"type\": \"정서의형성\", \"group\": \"내적\", \"subtitle\": \"▶ 심장은 왜 뛰는 걸까?\", \"img_id1\": \"sfsXNdKRWXg\", \"img_id2\": \"SG_v4uWRY_BM16prvpKeme4A520\" } ]");

            /**/
            JSONObject json = null;
            int i = jsonArray.length ();
            while ( --i >= 0 )
            {
                json = jsonArray.getJSONObject ( i );

                /**/
                cData = new CData ();

                cData.strTitle = json.getString ( "name" );
                cData.strEx = json.getString ( "subtitle" );

                cData.strGroup = json.getString ( "group" );
                cData.strType = json.getString ( "type" );

                strImg_url1 = json.getString ( "img_id1" );
                strImg_url2 = json.getString ( "img_id1" );

                cData.strUrl = json.getString ( "url" );

                cData.bmpIcon = null;

                m_list.add ( cData );

                CWebInterface.GetInstance ().Request ( "Img" + i, CDefineUrl.youtubeThumbnail1 + strImg_url1 + CDefineUrl.youtubeThumbnail2 + strImg_url2 );

                Log.i ( "Data:", json.getString ( "name" ) );

            }
        }
        catch ( JSONException e )
        {
            e.printStackTrace ();
            Log.i ( "json", "json err!! " + e );

            return;
        }
    }

    public void LoadingIcon ()
    {
        CData cData;
        CWebInterface.CData cWebData = null;
        Bitmap bmp = null;

        int i = 0;
        int size = m_list.size ();
        while ( i < size )
        {
            cWebData = CWebInterface.GetInstance ().Find ( "Img" + i );

            if ( cWebData == null )
            {
                continue;
            }

            if ( cWebData.eState == CWebInterface.EState.error )
            {
                Log.i ( "error", cWebData.strErr );
                return;
            }

            bmp = BitmapFactory.decodeByteArray ( cWebData.byteData, 0, cWebData.byteData.length );

            CWebInterface.GetInstance ().Remove ( "Img" + i );

            if ( bmp == null )
            {
                Log.i ( "error", "bmp is null" );
                return;
            }

            cData = m_list.get ( i );

            cData.bmpIcon = bmp;

            i++;
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    //
    public int Size ()
    {
        return m_list.size ();
    }

    public CData Get ( int idx )
    {
        return m_list.get ( idx );
    }
}