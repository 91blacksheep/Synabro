package com.example.user.first.Story.Story.PlayerView;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.example.user.first.Lib.CDeveloperKey;
import com.example.user.first.Loading.Parsing.Interface.CTalkGuideLine_List;
import com.example.user.first.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by KICT-15 on 2016-07-08.
 */
public class CStory_Player extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener
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
            switch (type)
            {
                case "우울":
                    list = new CTalkGuideLine_List(getLayoutInflater());

                    list.addItem("우울");
                    list.addItem("1. 아이와 함께 그동안 솜사탕이 된 기억들을 나눠보세요.");
                    list.addItem("2. 그 솜사탕을 먹고 생겨난 기억 사탕들도 함께 나눠보세요.");
                    list.addItem("3. 솜사탕의 변화와 사탕이 섞이면서 색다른 솜사탕이 되고 색다른 기억 사탕이 되는 것을 아이에게 느낄 수 있도록 해주세요.");
                    list.addItem("4. 아이의 솜사탕도 소중하고 기억 사탕도 소중하지만, 다른 사람들의 솜사탕과\n" +
                            "기억 사탕들도 소중하고 섞이면서 다른 솜사탕이 될 수 있다는 것을 알려주세요. 아마 분명 즐거운 시간이 될 것이예요.");
                    list.addItem("5. 오늘의 기억들도 솜사탕과 기억 사탕이 되어 아이와 부모님에게 남을 것이랍니다.");
                    break;
                case "질투":
                    list = new CTalkGuideLine_List(getLayoutInflater());

                    list.addItem("질투");
                    list.addItem("1. 아이와 함께 그동안 솜사탕이 된 기억들을 나눠보세요.");
                    list.addItem("2. 그 솜사탕을 먹고 생겨난 기억 사탕들도 함께 나눠보세요.");
                    list.addItem("3. 솜사탕의 변화와 사탕이 섞이면서 색다른 솜사탕이 되고 색다른 기억 사탕이 되는 것을 아이에게 느낄 수 있도록 해주세요.");
                    list.addItem("4. 아이의 솜사탕도 소중하고 기억 사탕도 소중하지만, 다른 사람들의 솜사탕과\n" +
                            "기억 사탕들도 소중하고 섞이면서 다른 솜사탕이 될 수 있다는 것을 알려주세요. 아마 분명 즐거운 시간이 될 것이예요.");
                    list.addItem("5. 오늘의 기억들도 솜사탕과 기억 사탕이 되어 아이와 부모님에게 남을 것이랍니다.");
                    break;
                case "눈물":
                    list = new CTalkGuideLine_List(getLayoutInflater());

                    list.addItem("눈물");
                    list.addItem("1. 아이와 함께 그동안 솜사탕이 된 기억들을 나눠보세요.");
                    list.addItem("2. 그 솜사탕을 먹고 생겨난 기억 사탕들도 함께 나눠보세요.");
                    list.addItem("3. 솜사탕의 변화와 사탕이 섞이면서 색다른 솜사탕이 되고 색다른 기억 사탕이 되는 것을 아이에게 느낄 수 있도록 해주세요.");
                    list.addItem("4. 아이의 솜사탕도 소중하고 기억 사탕도 소중하지만, 다른 사람들의 솜사탕과\n" +
                            "기억 사탕들도 소중하고 섞이면서 다른 솜사탕이 될 수 있다는 것을 알려주세요. 아마 분명 즐거운 시간이 될 것이예요.");
                    list.addItem("5. 오늘의 기억들도 솜사탕과 기억 사탕이 되어 아이와 부모님에게 남을 것이랍니다.");
                    break;
                case "미워하는마음":
                    list = new CTalkGuideLine_List(getLayoutInflater());

                    list.addItem("미워하는마음");
                    list.addItem("1. 아이와 함께 동그라미가 되었던 경험과 세모가 된 기억들을 이야기 해보세요.");
                    list.addItem("2. 동그라미 친구들이 놀아주지 않았을 때, 세모 친구의 기분에 대해 이야기 해보세요.");
                    list.addItem("3. 1번 동그라미 친구 입장이 되어 슬퍼하는 세모 친구와 어떻게 하면 함께 놀 수 있을지 가상의 이야기를 꾸며보세요.");
                    list.addItem("4. 어떻게 하면 동그라미 친구들이 세모친구를 미워하지 않을 수 있을지 동그라미 친구들과 가상의 대화를 나누어 보세요.\n"
                            + "(예 : 부모님이 동그라미 친구");
                    list.addItem("5. 세모 친구만 할 수 있는 일이 뭐가 있을지 이야기를 나누면서 다른 사람들과 차이점이 나쁜 것이 아님을 생각할 수 있게 해주세요.");
                    list.addItem("6. 이야기에 나오는 동그라미와 세모 뿐 아니라 네모, 별모양과 같은 여러 가지 다른 도형들에 대해서도 생각해 보고 칭찬을 하는 시간을 가져보세요.");
                    list.addItem("7. 서로 다름을 이해하고 미워하는 마음을 올바르게 표현할 수 있도록 도와주세요.");
                    break;
                case "두려움":
                    list = new CTalkGuideLine_List(getLayoutInflater());

                    list.addItem("두려움");
                    list.addItem("1. 아이와 함께 그동안 솜사탕이 된 기억들을 나눠보세요.");
                    list.addItem("2. 그 솜사탕을 먹고 생겨난 기억 사탕들도 함께 나눠보세요.");
                    list.addItem("3. 솜사탕의 변화와 사탕이 섞이면서 색다른 솜사탕이 되고 색다른 기억 사탕이 되는 것을 아이에게 느낄 수 있도록 해주세요.");
                    list.addItem("4. 아이의 솜사탕도 소중하고 기억 사탕도 소중하지만, 다른 사람들의 솜사탕과\n" +
                            "기억 사탕들도 소중하고 섞이면서 다른 솜사탕이 될 수 있다는 것을 알려주세요. 아마 분명 즐거운 시간이 될 것이예요.");
                    list.addItem("5. 오늘의 기억들도 솜사탕과 기억 사탕이 되어 아이와 부모님에게 남을 것이랍니다.");
                    break;
                case "정서의형성":
                    list = new CTalkGuideLine_List(getLayoutInflater());

                    list.addItem("정서의형성");
                    list.addItem("1. 아이와 함께 그동안 솜사탕이 된 기억들을 나눠보세요.");
                    list.addItem("2. 그 솜사탕을 먹고 생겨난 기억 사탕들도 함께 나눠보세요.");
                    list.addItem("3. 솜사탕의 변화와 사탕이 섞이면서 색다른 솜사탕이 되고 색다른 기억 사탕이 되는 것을 아이에게 느낄 수 있도록 해주세요.");
                    list.addItem("4. 아이의 솜사탕도 소중하고 기억 사탕도 소중하지만, 다른 사람들의 솜사탕과\n" +
                            "기억 사탕들도 소중하고 섞이면서 다른 솜사탕이 될 수 있다는 것을 알려주세요. 아마 분명 즐거운 시간이 될 것이예요.");
                    list.addItem("5. 오늘의 기억들도 솜사탕과 기억 사탕이 되어 아이와 부모님에게 남을 것이랍니다.");
                    break;
                case "폭력":
                    list = new CTalkGuideLine_List(getLayoutInflater());

                    list.addItem("폭력");
                    list.addItem("1. 아이와 함께 그동안 솜사탕이 된 기억들을 나눠보세요.");
                    list.addItem("2. 그 솜사탕을 먹고 생겨난 기억 사탕들도 함께 나눠보세요.");
                    list.addItem("3. 솜사탕의 변화와 사탕이 섞이면서 색다른 솜사탕이 되고 색다른 기억 사탕이 되는 것을 아이에게 느낄 수 있도록 해주세요.");
                    list.addItem("4. 아이의 솜사탕도 소중하고 기억 사탕도 소중하지만, 다른 사람들의 솜사탕과\n" +
                            "기억 사탕들도 소중하고 섞이면서 다른 솜사탕이 될 수 있다는 것을 알려주세요. 아마 분명 즐거운 시간이 될 것이예요.");
                    list.addItem("5. 오늘의 기억들도 솜사탕과 기억 사탕이 되어 아이와 부모님에게 남을 것이랍니다.");
                    break;
                case "가족관계":
                    list = new CTalkGuideLine_List(getLayoutInflater());

                    list.addItem("가족관계");
                    list.addItem("1. 아이와 함께 그동안 솜사탕이 된 기억들을 나눠보세요.");
                    list.addItem("2. 그 솜사탕을 먹고 생겨난 기억 사탕들도 함께 나눠보세요.");
                    list.addItem("3. 솜사탕의 변화와 사탕이 섞이면서 색다른 솜사탕이 되고 색다른 기억 사탕이 되는 것을 아이에게 느낄 수 있도록 해주세요.");
                    list.addItem("4. 아이의 솜사탕도 소중하고 기억 사탕도 소중하지만, 다른 사람들의 솜사탕과\n" +
                            "기억 사탕들도 소중하고 섞이면서 다른 솜사탕이 될 수 있다는 것을 알려주세요. 아마 분명 즐거운 시간이 될 것이예요.");
                    list.addItem("5. 오늘의 기억들도 솜사탕과 기억 사탕이 되어 아이와 부모님에게 남을 것이랍니다.");
                    break;
                case "소리지르기":
                    list = new CTalkGuideLine_List(getLayoutInflater());

                    list.addItem("1. 새로운 친구가 생기거나 새로운 장난감이 생기는 일과 같이\n"
                            + "설레었던 경험을 아이와 나누어보세요.");
                    list.addItem("2. 기대하던 일이 이루어졌을 때 기분을 아이와 함께 나누어보세요.");
                    list.addItem("3. 친구와 싸우거나 의견이 달랐던 경험을 나누어 보세요\n"
                            + "그리고 그때 어떤 기분이었는지 함께 나누어 보세요");
                    list.addItem("4. 소리를 질러서 리본들이 엉켜있는 것처럼, 소리를 질러본 경험이나\n"
                            + "소리를 지르고 싶었던 기억에 대해 이야기를 나누어 보세요.\n"
                            + "그럴 때 어떻게 하는 것이 좋을지 상황을 꾸며보세요.");
                    list.addItem("5. 동화속에서 나오는 상황을 아이와 함께 역할을 나누어 꾸며보세요.\n"
                            + "그리고 엉켜버린 리본을 어떻게 풀어낼 것인지 이야기를 나누어보세요.");
                    break;
                case "비속어사용":
                    list = new CTalkGuideLine_List(getLayoutInflater());

                    list.addItem("비속어사용");
                    list.addItem("1. 아이와 함께 그동안 솜사탕이 된 기억들을 나눠보세요.");
                    list.addItem("2. 그 솜사탕을 먹고 생겨난 기억 사탕들도 함께 나눠보세요.");
                    list.addItem("3. 솜사탕의 변화와 사탕이 섞이면서 색다른 솜사탕이 되고 색다른 기억 사탕이 되는 것을 아이에게 느낄 수 있도록 해주세요.");
                    list.addItem("4. 아이의 솜사탕도 소중하고 기억 사탕도 소중하지만, 다른 사람들의 솜사탕과\n" +
                            "기억 사탕들도 소중하고 섞이면서 다른 솜사탕이 될 수 있다는 것을 알려주세요. 아마 분명 즐거운 시간이 될 것이예요.");
                    list.addItem("5. 오늘의 기억들도 솜사탕과 기억 사탕이 되어 아이와 부모님에게 남을 것이랍니다.");
                    break;
                case "교우관계":
                    list = new CTalkGuideLine_List(getLayoutInflater());

                    list.addItem("교우관계");
                    list.addItem("1. 아이와 함께 그동안 솜사탕이 된 기억들을 나눠보세요.");
                    list.addItem("2. 그 솜사탕을 먹고 생겨난 기억 사탕들도 함께 나눠보세요.");
                    list.addItem("3. 솜사탕의 변화와 사탕이 섞이면서 색다른 솜사탕이 되고 색다른 기억 사탕이 되는 것을 아이에게 느낄 수 있도록 해주세요.");
                    list.addItem("4. 아이의 솜사탕도 소중하고 기억 사탕도 소중하지만, 다른 사람들의 솜사탕과\n" +
                            "기억 사탕들도 소중하고 섞이면서 다른 솜사탕이 될 수 있다는 것을 알려주세요. 아마 분명 즐거운 시간이 될 것이예요.");
                    list.addItem("5. 오늘의 기억들도 솜사탕과 기억 사탕이 되어 아이와 부모님에게 남을 것이랍니다.");
                    break;
                case "습관":
                    list = new CTalkGuideLine_List(getLayoutInflater());

                    list.addItem("습관");
                    list.addItem("1. 아이와 함께 그동안 솜사탕이 된 기억들을 나눠보세요.");
                    list.addItem("2. 그 솜사탕을 먹고 생겨난 기억 사탕들도 함께 나눠보세요.");
                    list.addItem("3. 솜사탕의 변화와 사탕이 섞이면서 색다른 솜사탕이 되고 색다른 기억 사탕이 되는 것을 아이에게 느낄 수 있도록 해주세요.");
                    list.addItem("4. 아이의 솜사탕도 소중하고 기억 사탕도 소중하지만, 다른 사람들의 솜사탕과\n" +
                            "기억 사탕들도 소중하고 섞이면서 다른 솜사탕이 될 수 있다는 것을 알려주세요. 아마 분명 즐거운 시간이 될 것이예요.");
                    list.addItem("5. 오늘의 기억들도 솜사탕과 기억 사탕이 되어 아이와 부모님에게 남을 것이랍니다.");
                    break;
                case "간식남용":
                    list = new CTalkGuideLine_List(getLayoutInflater());

                    list.addItem("간식남용");
                    list.addItem("1. 아이와 함께 그동안 솜사탕이 된 기억들을 나눠보세요.");
                    list.addItem("2. 그 솜사탕을 먹고 생겨난 기억 사탕들도 함께 나눠보세요.");
                    list.addItem("3. 솜사탕의 변화와 사탕이 섞이면서 색다른 솜사탕이 되고 색다른 기억 사탕이 되는 것을 아이에게 느낄 수 있도록 해주세요.");
                    list.addItem("4. 아이의 솜사탕도 소중하고 기억 사탕도 소중하지만, 다른 사람들의 솜사탕과\n" +
                            "기억 사탕들도 소중하고 섞이면서 다른 솜사탕이 될 수 있다는 것을 알려주세요. 아마 분명 즐거운 시간이 될 것이예요.");
                    list.addItem("5. 오늘의 기억들도 솜사탕과 기억 사탕이 되어 아이와 부모님에게 남을 것이랍니다.");
                    break;
                case "떼쓰기":
                    list = new CTalkGuideLine_List(getLayoutInflater());

                    list.addItem("떼쓰기");
                    list.addItem("1. 아이와 함께 그동안 솜사탕이 된 기억들을 나눠보세요.");
                    list.addItem("2. 그 솜사탕을 먹고 생겨난 기억 사탕들도 함께 나눠보세요.");
                    list.addItem("3. 솜사탕의 변화와 사탕이 섞이면서 색다른 솜사탕이 되고 색다른 기억 사탕이 되는 것을 아이에게 느낄 수 있도록 해주세요.");
                    list.addItem("4. 아이의 솜사탕도 소중하고 기억 사탕도 소중하지만, 다른 사람들의 솜사탕과\n" +
                            "기억 사탕들도 소중하고 섞이면서 다른 솜사탕이 될 수 있다는 것을 알려주세요. 아마 분명 즐거운 시간이 될 것이예요.");
                    list.addItem("5. 오늘의 기억들도 솜사탕과 기억 사탕이 되어 아이와 부모님에게 남을 것이랍니다.");
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
            player.cueVideo("i1jSCpo1Vq0");
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