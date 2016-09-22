package com.example.user.first.StoryPlayer.Client;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.example.user.first.Lib.CDeveloperKey;
import com.example.user.first.StoryPlayer.TalkGuideLine.Interface.CTalkGuideLine_List;
import com.example.user.first.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by KICT-15 on 2016-07-08.
 */
public class CStoryPlayerClient extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener
{
    ViewPager pager;
    String url = null;
    String type = null;

    CTalkGuideLine m_TalkGuideLine = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_player);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        type = intent.getStringExtra("type");

        /** Initializing YouTube player view **/
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(CDeveloperKey.DEVELOPER_KEY, this);

        /**/
        pager = (ViewPager) findViewById(R.id.pager);
        m_TalkGuideLine = new CTalkGuideLine();
    }

    public void onClickButton(View v)
    {
        switch(v.getId())
        {
            case R.id.btn_pre:
                int position = pager.getCurrentItem();
                pager.setCurrentItem(position - 1, true);
                break;
            case R.id.btn_next:
                int position2 = pager.getCurrentItem();
                pager.setCurrentItem(position2 + 1, true);
                break;
        }
    }

    private class CTalkGuideLine
    {
        CTalkGuideLine_List list = null;

        public CTalkGuideLine()
        {
            SetGuideLine();
        }

        private void SetGuideLine()
        {
            list = new CTalkGuideLine_List(getLayoutInflater());
            switch (type)
            {
                case "우울":
                    break;
                case "질투":

                    list.addItem(getDrawable(R.drawable.princess1));
                    list.addItem(getDrawable(R.drawable.princess2));
                    list.addItem(getDrawable(R.drawable.princess3));
                    list.addItem(getDrawable(R.drawable.princess4));
                    list.addItem(getDrawable(R.drawable.princess5));
                    list.addItem(getDrawable(R.drawable.princess6));
                    list.addItem(getDrawable(R.drawable.princess7));

                    break;
                case "눈물":
                    break;
                case "미움":
                    list.addItem(getDrawable(R.drawable.t1));
                    list.addItem(getDrawable(R.drawable.t2));
                    list.addItem(getDrawable(R.drawable.t3));
                    list.addItem(getDrawable(R.drawable.t4));
                    list.addItem(getDrawable(R.drawable.t5));
                    list.addItem(getDrawable(R.drawable.t6));
                    list.addItem(getDrawable(R.drawable.t7));
                    break;
                case "두려움":

                    list.addItem(getDrawable(R.drawable.darknight1));
                    list.addItem(getDrawable(R.drawable.darknight2));
                    list.addItem(getDrawable(R.drawable.darknight3));
                    list.addItem(getDrawable(R.drawable.darknight4));
                    list.addItem(getDrawable(R.drawable.darknight5));
                    list.addItem(getDrawable(R.drawable.darknight6));
                    list.addItem(getDrawable(R.drawable.darknight7));

                    break;
                case "정서의형성":


                    break;
                case "폭력":


                    break;
                case "가족관계":

                    list.addItem(getDrawable(R.drawable.darknight1));
                    list.addItem(getDrawable(R.drawable.darknight2));
                    list.addItem(getDrawable(R.drawable.darknight3));
                    list.addItem(getDrawable(R.drawable.darknight4));
                    list.addItem(getDrawable(R.drawable.darknight5));
                    list.addItem(getDrawable(R.drawable.darknight6));
                    list.addItem(getDrawable(R.drawable.darknight7));

                    break;
                case "소리지르기":

                    list.addItem(getDrawable(R.drawable.ribbon_vil1));
                    list.addItem(getDrawable(R.drawable.ribbon_vil2));
                    list.addItem(getDrawable(R.drawable.ribbon_vil3));
                    list.addItem(getDrawable(R.drawable.ribbon_vil4));
                    list.addItem(getDrawable(R.drawable.ribbon_vil5));
                    list.addItem(getDrawable(R.drawable.ribbon_vil6));
                    list.addItem(getDrawable(R.drawable.ribbon_vil7));

                    break;
                case "비속어사용":
                    break;
                case "교우관계":
                    break;
                case "습관":
                    break;
                case "간식남용":
                    break;
                case "떼쓰기":
                    break;
                case "심장뜀":

                    list.addItem(getDrawable(R.drawable.thrashing1));
                    list.addItem(getDrawable(R.drawable.thrashing2));
                    list.addItem(getDrawable(R.drawable.thrashing3));
                    list.addItem(getDrawable(R.drawable.thrashing4));
                    list.addItem(getDrawable(R.drawable.thrashing5));
                    list.addItem(getDrawable(R.drawable.thrashing6));
                    list.addItem(getDrawable(R.drawable.thrashing7));

                    break;
            }
            pager.setAdapter(list);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result)
    {
        Toast.makeText(this, "Failured to Initialize!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored)
    {
        /** add listeners to YouTubePlayer instance **/
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);

        /** Start buffering **/
        if (!wasRestored)
        {
            //player.cueVideo(url);
            player.cueVideo("Z1pgXANlTpA");
        }
    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener()
    {
        @Override
        public void onBuffering(boolean arg0)
        {
        }

        @Override
        public void onPaused()
        {
        }

        @Override
        public void onPlaying()
        {
        }

        @Override
        public void onSeekTo(int arg0)
        {
        }

        @Override
        public void onStopped()
        {
        }
    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener()
    {
        @Override
        public void onAdStarted()
        {
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason arg0)
        {
        }

        @Override
        public void onLoaded(String arg0)
        {
        }

        @Override
        public void onLoading()
        {
        }

        @Override
        public void onVideoEnded()
        {
        }

        @Override
        public void onVideoStarted()
        {
        }
    };
}