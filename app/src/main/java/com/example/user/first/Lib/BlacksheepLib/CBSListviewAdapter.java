package com.example.user.first.Lib.BlacksheepLib;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-08-24.
 */
public class CBSListviewAdapter extends BaseAdapter
{
    /* interface */
    public interface Draw
    {
        public View OnDraw(int position, View convertView, ViewGroup parent);
    }

    /* value */
    ArrayList<CBSListviewData> list = null;

    Draw m_OnDraw = null;

    /*
     * *
     */

    public CBSListviewAdapter()
    {
        list = new ArrayList<CBSListviewData>();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //
    public void SetDraw(Draw OnDraw)
    {
        m_OnDraw = OnDraw;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Log.i("CBSListviewAdapter","getView");
        if(m_OnDraw == null)
            return null;

        return m_OnDraw.OnDraw(position,convertView,parent);
    }

    @Override
    public int getCount()
    {
        return list.size();
    }


    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position)
    {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position)
    {
        return list.get(position);
    }

    public void addItem(CBSListviewData item)
    {
        list.add(item);
    }

    public void removeItem(int idx)
    {
        list.remove(idx);
    }
    public void setClearAll()
    {
        int i = list.size();
        while(--i >= 0)
        {
            list.remove(i);
        }

        list.clear();
    }
}
