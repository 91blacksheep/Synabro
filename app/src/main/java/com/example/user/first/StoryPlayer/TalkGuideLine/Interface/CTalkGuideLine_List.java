package com.example.user.first.StoryPlayer.TalkGuideLine.Interface;

import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.user.first.StoryPlayer.TalkGuideLine.Lib.CTalkGuideLine_Data;
import com.example.user.first.R;

import java.util.ArrayList;

/**
 * Created by KICT-15 on 2016-07-08.
 */
public class CTalkGuideLine_List extends PagerAdapter
{
    LayoutInflater inflater;
    private ArrayList<CTalkGuideLine_Data> talkGuideLineList = new ArrayList<>();

    public CTalkGuideLine_List(LayoutInflater inflater)
    {
        //전달 받은 LayoutInflater를 멤버변수로 전달
        this.inflater = inflater;
    }

    @Override
    public int getCount()
    {
        return talkGuideLineList.size();
    }

    //ViewPager가 현재 보여질 Item(View객체)를 생성할 필요가 있는 때 자동으로 호출
    //쉽게 말해, 스크롤을 통해 현재 보여져야 하는 View를 만들어냄.
    //첫번째 파라미터 : ViewPager
    //두번째 파라미터 : ViewPager가 보여줄 View의 위치(가장 처음부터 0,1,2,3...)
    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        View view = null;

        view = inflater.inflate(R.layout.story_viewpager, null);

        ImageView tv_viewPager= (ImageView) view.findViewById(R.id.talkGuideLine);

        CTalkGuideLine_Data listViewPagerItem = talkGuideLineList.get(position);
        tv_viewPager.setImageDrawable(listViewPagerItem.GetTalkGuideLine());//setText(listViewPagerItem.Get_talkGuideLine());

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View v, Object obj)
    {
        return v == obj;
    }

    public void addItem(Drawable img)
    {
        CTalkGuideLine_Data item = new CTalkGuideLine_Data();

        item.SetTalkGuideLine(img);

        talkGuideLineList.add(item);
    }
}