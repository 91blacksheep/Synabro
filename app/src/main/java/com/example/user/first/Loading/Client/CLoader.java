package com.example.user.first.Loading.Client;

import android.util.Log;

import com.example.user.first.Lib.BlacksheepLib.CWebInterface;
import com.example.user.first.Story.CStoryDataList;

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
        void OnEndCallback();
    }


    /*
    * *
    */

    public void SetEndCallback(EndCallback Callback)
    {
        m_Callback = Callback;
    }


    public CLoader()
    {
        m_Callback = null;
    }

    public void run()
    {
        m_bActive = true;

        Log.i("CLoader","0%");

        CWebInterface.GetInstance().Request("json_data","https://raw.githubusercontent.com/91blacksheep/Synabro/master/web_data/json_data.data");

        CWebInterface.CData cData = null;

        String strData = null;
        while (true)
        {
            if(m_bActive == false)
                return;

            cData = CWebInterface.GetInstance().Find("json_data");

            if(cData == null)
            {
                continue;
            }

            if (cData.strErr != null)
            {
                Log.i("web", cData.strErr.toString());
                return;
            }

            try
            {
                //strData = new String(cData.byteData,"EUC-KR");
                strData = new String(cData.byteData,"UTF-8");
                Log.i("web",strData);
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();

                Log.i("web","error");
                return;
            }

            break;
        }

        Log.i("CLoader","50%");

        /**/
        CStoryDataList.GetInstance().Init(strData);
        CStoryDataList.GetInstance().LoadingIcon();

        CWebInterface.GetInstance().ResClear();

        Log.i("CLoader","100%");

        if(m_Callback != null)
            m_Callback.OnEndCallback();
    }


    public void Exit()
    {
        m_bActive = false;
    }
}