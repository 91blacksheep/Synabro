package com.example.user.first.Lib.BlacksheepLib;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016-08-20.
 */
public class CWebInterface extends Thread
{
    /* interface */
    public interface RequestCallback
    {
        void OnRequestCallback ();
    }

    /* final */
    public final static int SLEEP = 1500;

    /* enum */
    public enum EState
    {
        request,
        success,
        error
    }

    /* class */
    public class CData
    {
        public String strID = null;

        public String strURL = null;

        public String strErr = null;
        public EState eState = null;

        public byte[] byteData = null;
    }

    static CWebInterface instance = null;

    ArrayList<CData> m_ReqList = null;
    ArrayList<CData> m_ResList = null;

    boolean m_bActive = false;

    RequestCallback m_Callback = null;

    /*
    * *
    */


    public static void DestroyInstance ()
    {
        instance = null;
    }

    public static CWebInterface GetInstance ()
    {
        if ( instance != null )
        {
            return instance;
        }

        instance = new CWebInterface ();

        return instance;
    }

    public CWebInterface ()
    {
        m_ReqList = new ArrayList<CData> ();
        m_ResList = new ArrayList<CData> ();
    }

    public void Request ( String strID, String strUrl )
    {
        CData cData = new CData ();

        cData.strID = strID;
        cData.strURL = strUrl;
        cData.eState = EState.request;

        m_ReqList.add ( cData );
    }

    public void SetRequestCallback ( RequestCallback Callback )
    {
        m_Callback = Callback;
    }

    public int RequestSize ()
    {
        return m_ReqList.size ();
    }

    public CData Find ( String strID )
    {
        CData cData = null;

        int i = m_ResList.size ();
        while ( --i >= 0 )
        {
            cData = m_ResList.get ( i );

            if ( true == cData.strID.equals ( strID ) )
            {
                return cData;
            }
        }

        return null;
    }

    public void Remove ( String strID )
    {
        CData cData = null;

        int i = m_ResList.size ();
        while ( --i >= 0 )
        {
            cData = m_ResList.get ( i );

            if ( true == cData.strID.equals ( strID ) )
            {
                m_ResList.remove ( i );
            }
        }
    }

    public void ResClear ()
    {
        m_ResList.clear ();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    public void Enter ()
    {
        m_bActive = true;

        this.start ();
    }

    public void Exit ()
    {
        m_bActive = false;
        Log.i ( "CWebInterface", "End?" );
        this.interrupt ();

        int i = 0;
        /**/
        if ( m_ResList != null )
        {
            i = m_ResList.size ();
            while ( --i >= 0 )
            {
                m_ResList.remove ( i );
            }
            //m_ResList = null;
        }

        /**/
        if ( m_ReqList != null )
        {
            i = m_ReqList.size ();
            while ( --i >= 0 )
            {
                m_ReqList.remove ( i );
            }
            //m_ReqList = null;
        }
    }

    public void run ()
    {
        URL url = null;
        URLConnection connection = null;
        InputStream in = null;

        int nCount = 0;
        CData cData = null;

        while ( m_bActive == true )
        {
            //Log.i("Run","test");
            /*
            try
            {
                Thread.sleep(SLEEP);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
                return;
            }*/

            /**/
            try
            {
                // Log.i("CWebInterface","run");

                nCount = m_ReqList.size ();
                if ( nCount <= 0 )
                {
                    if ( m_Callback != null )
                    {
                        m_Callback.OnRequestCallback ();
                        m_Callback = null;
                    }
                    continue;
                }

                cData = m_ReqList.get ( 0 );

                url = new URL ( cData.strURL );

                connection = url.openConnection ();
                in = connection.getInputStream ();

                //int contentLength = connection.getContentLength();

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream ();

                byte[] readByte = new byte[1024];
                int readLen;
                while ( (readLen = in.read ( readByte )) != -1 )
                {
                    outputStream.write ( readByte, 0, readLen );
                }

                cData.byteData = outputStream.toByteArray ();

                cData.eState = EState.success;

                in.close ();
                url = null;

            }
            catch ( MalformedURLException e )
            {
                Log.d ( "WebError!!!", e.toString () );

                cData.eState = EState.error;
                cData.strErr = e.toString ();

                continue;
            }
            catch ( IOException e )
            {
                Log.d ( "WebError!!!", e.toString () );

                cData.eState = EState.error;
                cData.strErr = e.toString ();

                continue;
            }

            m_ReqList.remove ( 0 );
            m_ResList.add ( cData );
        }

        Log.i ( "CWebInterface", "End" );
    }
}
