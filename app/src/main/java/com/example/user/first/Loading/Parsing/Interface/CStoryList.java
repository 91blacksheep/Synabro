package com.example.user.first.Loading.Parsing.Interface;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.first.Story.CStoryDataList;
import com.example.user.first.R;

import java.util.ArrayList;

/**
 * Created by KICT-15 on 2016-07-05.
 */
public class CStoryList //extends BaseAdapter
{
    /* final */
    final String url = "https://www.youtube.com/watch?v=";

    /* value */
    //  Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<CStoryDataList> list = null;

    Context m_context = null;

    /*
    * *
    */

    /*

    //  ListViewAdapter의 생성자
    public CStoryList(Context context)
    {
        list = new ArrayList<CStoryDataList>();

        this.m_context = context;

        list.add(new CStoryDataList("LEnsRQLB4DU", "까만구름, 하얀구름아", "▶ 우울한 마음", url+"i1jSCpo1Vq0", "내적", "우울"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "나도 공주!", "▶ 질투", url+"i1jSCpo1Vq0", "내적", "질투"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "또륵, 또르륵 사탕", "▶ 눈물은 언제 나는 걸까?", url+"i1jSCpo1Vq0", "내적", "눈물"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "세모야! 굴러봐!", "▶ 미운마음, 미운 친구", url+"i1jSCpo1Vq0", "내적", "미워하는마음"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "어두운 밤", "▶ 두려움", url+"i1jSCpo1Vq0", "내적", "두려움"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "콩닥, 철썩 파도", "▶ 심장은 왜 뛰는 걸까?", url+"i1jSCpo1Vq0", "내적", "정서의형성"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "내 등에 풍선이?! 어떻게 해요?", "▶ 폭력", url+"i1jSCpo1Vq0", "외적", "폭력"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "띵똥땡똥, 띵똥땡똥", "▶ 가족관계", url+"i1jSCpo1Vq0", "외적", "가족관계"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "리본 마을", "▶ 소리지르기", url+"i1jSCpo1Vq0", "외적", "소리지르기"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "마음의 스케치북", "▶ 부정적인 언어 사용", url+"i1jSCpo1Vq0", "외적", "비속어사용"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "별콩이와 달콩이", "▶ 친구관계", url+"i1jSCpo1Vq0", "외적", "교우관계"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "손가락 사탕", "▶ 손톱 물어뜯기", url+"i1jSCpo1Vq0", "외적", "습관"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "야금야금 우걱우걱", "▶ 간식의 남용", url+"i1jSCpo1Vq0", "외적", "간식남용"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "폭폭이의 달리기", "▶ 떼 쓰기", url+"i1jSCpo1Vq0", "외적", "떼쓰기"));

        OnClickTapAll();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    public void OnClickTapAll()
    {
        if(list.size() > 0)
        {
            setClear();
            notifyDataSetChanged();
        }

        list.add(new CStoryDataList("LEnsRQLB4DU", "까만구름, 하얀구름아", "▶ 우울한 마음", url+"i1jSCpo1Vq0", "내적", "우울"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "나도 공주!", "▶ 질투", url+"i1jSCpo1Vq0", "내적", "질투"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "또륵, 또르륵 사탕", "▶ 눈물은 언제 나는 걸까?", url+"i1jSCpo1Vq0", "내적", "눈물"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "세모야! 굴러봐!", "▶ 미운마음, 미운 친구", url+"i1jSCpo1Vq0", "내적", "미워하는마음"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "어두운 밤", "▶ 두려움", url+"i1jSCpo1Vq0", "내적", "두려움"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "콩닥, 철썩 파도", "▶ 심장은 왜 뛰는 걸까?", url+"i1jSCpo1Vq0", "내적", "정서의형성"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "내 등에 풍선이?! 어떻게 해요?", "▶ 폭력", url+"i1jSCpo1Vq0", "외적", "폭력"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "띵똥땡똥, 띵똥땡똥", "▶ 가족관계", url+"i1jSCpo1Vq0", "외적", "가족관계"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "리본 마을", "▶ 소리지르기", url+"i1jSCpo1Vq0", "외적", "소리지르기"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "마음의 스케치북", "▶ 부정적인 언어 사용", url+"i1jSCpo1Vq0", "외적", "비속어사용"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "별콩이와 달콩이", "▶ 친구관계", url+"i1jSCpo1Vq0", "외적", "교우관계"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "손가락 사탕", "▶ 손톱 물어뜯기", url+"i1jSCpo1Vq0", "외적", "습관"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "야금야금 우걱우걱", "▶ 간식의 남용", url+"i1jSCpo1Vq0", "외적", "간식남용"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "폭폭이의 달리기", "▶ 떼 쓰기", url+"i1jSCpo1Vq0", "외적", "떼쓰기"));
    }

    public void OnClickTapEx()
    {
        if(list.size() > 0)
        {
            setClear();
            notifyDataSetChanged();
        }

        list.add(new CStoryDataList("LEnsRQLB4DU", "내 등에 풍선이?! 어떻게 해요?", "▶ 폭력", url+"i1jSCpo1Vq0", "외적", "폭력"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "띵똥땡똥, 띵똥땡똥", "▶ 가족관계", url+"i1jSCpo1Vq0", "외적", "가족관계"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "리본 마을", "▶ 소리지르기", url+"i1jSCpo1Vq0", "외적", "소리지르기"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "마음의 스케치북", "▶ 부정적인 언어 사용", url+"i1jSCpo1Vq0", "외적", "비속어사용"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "별콩이와 달콩이", "▶ 친구관계", url+"i1jSCpo1Vq0", "외적", "교우관계"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "손가락 사탕", "▶ 손톱 물어뜯기", url+"i1jSCpo1Vq0", "외적", "습관"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "야금야금 우걱우걱", "▶ 간식의 남용", url+"i1jSCpo1Vq0", "외적", "간식남용"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "폭폭이의 달리기", "▶ 떼 쓰기", url+"i1jSCpo1Vq0", "외적", "떼쓰기"));
    }

    public void OnClickTapInner()
    {
        if(list.size() > 0)
        {
            setClear();
            notifyDataSetChanged();
        }

        list.add(new CStoryDataList("LEnsRQLB4DU", "구름아 내마음을 말해줘", "▶ 감정은 무엇일까?", url+"i1jSCpo1Vq0", "내적", "감정"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "까만구름, 하얀구름", "▶ 우울한 마음", url+"i1jSCpo1Vq0", "내적", "우울"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "나도 공주!", "▶ 질투", url+"i1jSCpo1Vq0", "내적", "질투"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "또륵, 또르륵 사탕", "▶ 눈물은 언제 나는 걸까?", url+"i1jSCpo1Vq0", "내적", "눈물"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "세모야! 굴러봐!", "▶ 미운마음, 미운 친구", url+"i1jSCpo1Vq0", "내적", "미워하는마음"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "어두운 밤", "▶ 두려움", url+"i1jSCpo1Vq0", "내적", "두려움"));
        list.add(new CStoryDataList("LEnsRQLB4DU", "콩닥, 철썩 파도", "▶ 심장은 왜 뛰는 걸까?", url+"i1jSCpo1Vq0", "내적", "정서의형성"));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.story_list_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.thumbnail) ;
        TextView titleTextView = (TextView) convertView.findViewById(R.id.titleText) ;
        TextView descTextView = (TextView) convertView.findViewById(R.id.exText) ;

        titleTextView.setSelected(true);    //글이 길면 흐르는 효과
        descTextView.setSelected(true);     //글이 길면 흐르는 효과

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        CStoryDataList listViewItem = list.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        iconImageView.setImageBitmap(listViewItem.Get_Bmp());
        titleTextView.setText(listViewItem.Get_title());
        descTextView.setText(listViewItem.Get_ex());

        return convertView;
    }

    //  Adapter에 사용되는 데이터의 개수를 리턴 : 필수 구현
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

    public void setClear()
    {
        int i = list.size();
        while(--i >= 0)
        {
            list.remove(i);
        }

        list.clear();
    }

    public void addItem(CStoryDataList item)
    {
        list.add(item);
    }
    */
}