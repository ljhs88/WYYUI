package com.coolweather.wyyui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class playActivity extends AppCompatActivity implements View.OnClickListener {

    private final MediaPlayer mediaPlayer = new MediaPlayer();
    String url;
    String singName;
    private Button button_start;
    private Button button_up;
    private Button button_down;
    private TextView singNameText;
    private List<String> musicName;
    private List<String> musicUrl;
    private int order_num;
    private int STATE = 0;// 0 - 暂停，1 - 开启
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        singNameText = findViewById(R.id.singName);
        button_start = findViewById(R.id.start_button);
        button_up = findViewById(R.id.up_button);
        button_down = findViewById(R.id.down_button);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        singName = intent.getStringExtra("singName");
        musicName = intent.getStringArrayListExtra("musicName");
        musicUrl = intent.getStringArrayListExtra("musicUrl");
        order_num = intent.getIntExtra("order_num", 0);

        //prepareMediaPlayer(url, singName);

        prepareText(singName);

        button_start.setOnClickListener(this);
        button_up.setOnClickListener(this);
        button_down.setOnClickListener(this);

    }

    private void prepareMediaPlayer(String url, String singName) {
        try {
            singNameText.setText(singName);
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (intent != null) {
            stopService(intent);
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "NonConstantResourceId"})
    @Override
    public void onClick(View v) {
        intent = new Intent("com.coolweather.wyyui.music");
        intent.setPackage(getBaseContext().getPackageName());
        bundle = new Bundle();
        switch (v.getId()) {
            case R.id.start_button:
                Log.d("123", "start");
                if(STATE == 0) {
                    button_start.setBackground(this.getDrawable(R.drawable.pause));
                    STATE = 1;
                } else {
                    button_start.setBackground(this.getDrawable(R.drawable.start));
                    STATE = 0;
                }
                startService();
                break;
            case R.id.up_button:
                button_start.setBackground(this.getDrawable(R.drawable.start));
                STATE = 0;
                order_num = (order_num-1)%musicName.size();
                url = musicUrl.get(order_num);
                singName = musicName.get(order_num);
                prepareText(singName);
                break;
            case R.id.down_button:
                STATE = 0;
                button_start.setBackground(this.getDrawable(R.drawable.start));
                order_num = (order_num+1)%musicName.size();
                url = musicUrl.get(order_num);
                singName = musicName.get(order_num);
                prepareText(singName);
                break;
        }

    }

    public void startService(){
        prepareText(singName);
        bundle.putInt("state", STATE);
        bundle.putString("url", url);
        intent.putExtras(bundle);
        startService(intent);
    }

    private void prepareText(String singName) {
        singNameText.setText(singName);
    }

    /*@Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.start_button:
                if (!mediaPlayer.isPlaying()) {
                    // 如果没有播放就播放
                    mediaPlayer.start();
                    button_start.setBackground(this.getDrawable(R.drawable.pause));
                    Log.d("123", "start");
                } else {
                    // 如果播放就停止
                    mediaPlayer.pause();
                    button_start.setBackground(this.getDrawable(R.drawable.start));
                    Log.d("123", "pause");
                }
                break;
            case R.id.up_button:
                mediaPlayer.reset();
                button_start.setBackground(this.getDrawable(R.drawable.start));
                order_num = (order_num-1)%musicName.size();
                url = musicUrl.get(order_num);
                singName = musicName.get(order_num);
                prepareMediaPlayer(url, singName);
                break;
            case R.id.down_button:
                mediaPlayer.reset();
                button_start.setBackground(this.getDrawable(R.drawable.start));
                order_num = (order_num+1)%musicName.size();
                url = musicUrl.get(order_num);
                singName = musicName.get(order_num);
                prepareMediaPlayer(url, singName);
                break;
        }
    }*/

}