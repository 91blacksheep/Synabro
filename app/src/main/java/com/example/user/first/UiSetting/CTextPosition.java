package com.example.user.first.UiSetting;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-22.
 */
public class CTextPosition extends AppCompatActivity
{
    Context m_context = null;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;

    public CTextPosition(TextView textView1, TextView textView2, TextView textView3, TextView textView4, TextView textView5, Context context)
    {
        /**/
        this.m_context = context;
        this.textView1 = textView1;
        this.textView2 = textView2;
        this.textView3 = textView3;
        this.textView4 = textView4;
        this.textView5 = textView5;

        /**/
        SetTextPosition(textView1, 0, -17);
        SetTextPosition(textView2, 23, -5);
        SetTextPosition(textView3, 16, 13);
        SetTextPosition(textView4, -10, 13);
        SetTextPosition(textView5, -17, -5);
    }

    private void SetTextPosition(TextView textView, int  x, int y)
    {
        //디바이스 크기 불러오기
        DisplayMetrics device = m_context.getResources().getDisplayMetrics();
        float deviceX = device.widthPixels;
        float deviceY = device.heightPixels;

        textView.setX((deviceX / 100) * x);
        textView.setY((deviceY / 100) * y);
    }
}