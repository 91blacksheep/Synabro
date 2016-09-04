package com.example.user.first.Lib.BlacksheepLib;

import android.content.Context;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Administrator on 2016-08-24.
 */
public class CBSListview
{
    /* value */
    CBSListviewAdapter m_cAdapter = null;
    ListView m_listView = null;

    /*
     * *
     */

    public CBSListview(ListView listView)
    {
        m_cAdapter = new CBSListviewAdapter();
        m_listView = listView;
    }
    public CBSListview(Context context)
    {
        m_cAdapter = new CBSListviewAdapter();

        m_listView = new ListView(context);
        //m_listView.setAdapter(m_cAdapter);
    }
    public void SetAdapter()
    {
        m_listView.setAdapter(m_cAdapter);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    //
    public void OnDraw(CBSListviewAdapter.Draw OnDraw)
    {
        m_cAdapter.SetDraw(OnDraw);
    }

    public void SetItemClickCallback(AdapterView.OnItemClickListener onCallback)
    {
        m_listView.setOnItemClickListener(onCallback);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    //

    public Object GetItem(int position)
    {
        return m_cAdapter.getItem(position);
    }

    public void AddItem(CBSListviewData item)
    {
        m_cAdapter.addItem(item);
    }

    public void RemoveItem(int idx)
    {
        m_cAdapter.removeItem(idx);
    }
}
