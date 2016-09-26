package com.example.user.first.Loading.Interface;

import android.util.Log;

import com.example.user.first.Emotion.Interface.CEmotionDataList;
import com.example.user.first.Lib.BlacksheepLib.CWebInterface;
import com.example.user.first.StoryList.Interface.CStoryDataList;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2016-08-20.
 */

public class CLoader extends Thread
{


    CWebInterface.CData cData = null;
    EndCallback m_Callback = null;

    boolean m_bActive = false;

    /* interface */
    public interface EndCallback
    {
        void OnEndCallback ();
    }


    /*
    * *
    */

    public void SetEndCallback ( EndCallback Callback )
    {
        m_Callback = Callback;
    }


    public CLoader ()
    {
        m_Callback = null;
    }

    public void run ()
    {
        m_bActive = true;

        Log.i ( "CLoader", "0%" );

        CWebInterface.GetInstance ().Request ( "json_data", "https://raw.githubusercontent.com/91blacksheep/Synabro/master/web_data/json_data.data" );
        CWebInterface.GetInstance ().Request ( "Emotion_JSON_DATA", "https://raw.githubusercontent.com/Jo-jangho/Synabro/master/web_data/Emotion_JSON_DATA.data" );

        CWebInterface.CData cData = null;
        String strJsonData = null;

        while ( true )
        {
            if ( m_bActive == false )
            {
                return;
            }

            cData = CWebInterface.GetInstance ().Find ( "json_data" );

            if ( cData == null )
            {
                continue;
            }

            if ( cData.strErr != null )
            {
                Log.i ( "web", cData.strErr.toString () );
                return;
            }

            try
            {
                //strData = new String(cData.byteData,"EUC-KR");
                strJsonData = new String ( cData.byteData, "UTF-8" );
                Log.i ( "web", strJsonData );
            }
            catch ( UnsupportedEncodingException e )
            {
                e.printStackTrace ();

                Log.i ( "web", "error" );
                return;
            }

            break;
        }

        Log.i ( "CLoader", "50%" );

        /**/
        CStoryDataList.GetInstance ().Init ( strJsonData );
        CStoryDataList.GetInstance ().LoadingIcon ();

        /**/
        //CWebInterface.GetInstance().ResClear();


        Log.i ( "CLoader", "60%" );

        cData = null;
        strJsonData = null;

        while ( true )
        {
            if ( m_bActive == false )
            {
                return;
            }

            cData = CWebInterface.GetInstance ().Find ( "Emotion_JSON_DATA" );

            if ( cData == null )
            {
                continue;
            }

            if ( cData.strErr != null )
            {
                Log.i ( "web", cData.strErr );
                return;
            }

            try
            {
                //strData = new String(cData.byteData,"EUC-KR");
                strJsonData = new String ( cData.byteData, "UTF-8" );
                //Log.i("web",strJsonData);
            }
            catch ( UnsupportedEncodingException e )
            {
                e.printStackTrace ();

                Log.i ( "web", "error" );
                return;
            }

            break;
        }

        //Log.i("CLoader",strJsonData);

        CEmotionDataList.GetInstance ().Init ( strJsonData );
        CEmotionDataList.GetInstance ().LoadingIcon ();

        CWebInterface.GetInstance ().ResClear ();

        Log.i ( "CLoader", "100%" );

        if ( m_Callback != null )
        {
            m_Callback.OnEndCallback ();
        }
    }


    public void Exit ()
    {
        m_bActive = false;
    }
}