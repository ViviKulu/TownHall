package com.tap.vivianbabiryekulumba;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Lifecycle;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.ui.PlayerUIController;
import com.pierfrancescosoffritti.androidyoutubeplayer.ui.menu.MenuItem;
import com.tap.vivianbabiryekulumba.townhall.R;
import com.tap.vivianbabiryekulumba.townhall.util.VideoInfo;
import com.tap.vivianbabiryekulumba.townhall.util.YouTubeDataEndpoint;

import java.util.Random;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class YouTubeActivity extends AppCompatActivity  {
    public static final String VIDEO_ID = "https://www.youtube.com/watch?v=miVnU3wybEY&list=UUHip-wiEtSSRtJtA2OoChOA";
    private YouTubePlayerView youTubePlayerView;
    Button next_vid;
//    private String[] videoIds = {"6JYIGclVQdw", "LvetJ9U_tVY"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube);
        youTubePlayerView = findViewById(R.id.youtube_player_view);
        next_vid = findViewById(R.id.next_video_button);
        initYouTubePlayer();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfiguration) {
        super.onConfigurationChanged(newConfiguration);
        youTubePlayerView.getPlayerUIController().getMenu().dismiss();
    }

    private void initYouTubePlayer() {
        initPlayerMenu();
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.initialize(youTubePlayer -> {

            youTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady() {
                    loadVideo(youTubePlayer, VIDEO_ID);
                }
            });

            setPlayNextVideoButtonClickListener(youTubePlayer);

        }, true);
    }

    private void initPlayerMenu() {
        youTubePlayerView.getPlayerUIController().showMenuButton(true);
        youTubePlayerView.getPlayerUIController().getMenu().addItem(
                new MenuItem("example", R.drawable.ic_settings_24dp, (view) -> Toast.makeText(this, "item clicked", Toast.LENGTH_SHORT).show())
        );
    }

    private void loadVideo(com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer youTubePlayer, String videoId) {
        if(getLifecycle().getCurrentState() == Lifecycle.State.RESUMED)
            youTubePlayer.loadVideo(VIDEO_ID, 0);
        else
            youTubePlayer.cueVideo(VIDEO_ID, 0);

        setVideoTitle(youTubePlayerView.getPlayerUIController(), videoId);
    }

    private void setPlayNextVideoButtonClickListener(final com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer youTubePlayer) {
        next_vid.setOnClickListener(view -> {
            loadVideo(youTubePlayer, VIDEO_ID);
        });
    }

    @SuppressLint("CheckResult")
    private void setVideoTitle(PlayerUIController playerUIController, String VIDEO_ID) {

        Single<VideoInfo> observable = YouTubeDataEndpoint.getVideoInfoFromYouTubeDataAPIs(VIDEO_ID);

        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        videoInfo -> playerUIController.setVideoTitle(videoInfo.getVideoTitle()),
                        error -> { Log.e(getClass().getSimpleName(), "Can't retrieve video title, are you connected to the internet?"); }
                );
    }
}
