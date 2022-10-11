package com.coolweather.wyyui;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.IOException;

public class MyMusicService extends Service {

    private MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "开始播放", Toast.LENGTH_SHORT).show();
        if(mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setLooping(false);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("123", "onStartCommand");
        if(intent != null) {
            Log.d("123", "intent");
            Bundle bundle = intent.getExtras();
            if(bundle != null) {
                int state = intent.getIntExtra("state", -1);
                String url = intent.getStringExtra("url");
                Log.d("123", "state= "+state+"url= "+url);
                switch(state) {
                    case 1:
                        if(url != null) {
                            Log.d("123", "play");
                            prepareMediaPlayer(url);
                            play();
                        }
                        break;
                    case 0:
                        pause();
                        break;
                    case 2:
                        stop();
                        break;
                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void pause() {
        if(mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    private void stop() {
        if(mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    private void play() {
        mediaPlayer.start();
    }

    private void prepareMediaPlayer(String url) {
        try {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
                mediaPlayer = null;
                mediaPlayer= new MediaPlayer();
            }
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "stop media player", Toast.LENGTH_SHORT).show();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}
