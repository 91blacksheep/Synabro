package com.example.user.first.Lib;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by USER on 2016-08-12.
 */
public class CTextFileManager
{
    private static final String FILE_NAME = "myText.txt";

    Context m_Context = null;

    public CTextFileManager(Context context)
    {
        m_Context = context;
    }

    public void save(String strData)
    {
        if(strData == null || strData.equals(""))
        {
            return;
        }

        FileOutputStream fos = null;

        try
        {
            fos = m_Context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.write(strData.getBytes());
            fos.close();
        }
        catch (IOException e)
        {
            //Toast.makeText(m_Context, "파일 저장 실패", Toast.LENGTH_SHORT).show();
        }
    }

    public String load()
    {
        try
        {
            FileInputStream fis = m_Context.openFileInput(FILE_NAME);
            byte[] data = new byte[fis.available()];

            while(fis.read(data) != -1){}

            fis.close();

            return new String(data);
        }
        catch (IOException e)
        {
            return "나만의 글귀";
        }
    }

    public void delete()
    {
        m_Context.deleteFile(FILE_NAME);
    }
}
