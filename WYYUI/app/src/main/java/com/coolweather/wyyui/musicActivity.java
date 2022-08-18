package com.coolweather.wyyui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.ActionBar;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class musicActivity extends AppCompatActivity {

    private ListView listView;
    private List<music> musicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ActionBar actionBar = getActionBar();
        if (actionBar != null)
        actionBar.hide();

        musicList = getMusicFile(this);
        //Log.d("123", musicList.toString());
        prepareListView(this);
    }

    private void prepareListView(Context context) {
        listView = findViewById(R.id.list_view);
        MyAdapter adapter = new MyAdapter(this, R.layout.music_item, musicList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                music music = musicList.get(i);
                List<String> musicName = new ArrayList<>();
                List<String> musicUrl = new ArrayList<>();
                for (music music1 : musicList) {
                    musicName.add(music1.getName());
                    musicUrl.add(music1.getUrl());
                }
                Intent intent = new Intent(context, playActivity.class);
                intent.putExtra("url", music.getUrl());
                intent.putExtra("singName", music.getName());
                intent.putStringArrayListExtra("musicName", (ArrayList<String>) musicName);
                intent.putStringArrayListExtra("musicUrl", (ArrayList<String>) musicUrl);
                intent.putExtra("order_num", music.getId());
                startActivity(intent);
            }
        });
    }



    public static List<music> getMusicFile(Context context) {
        // 生成动态数组，并且转载数据
        List<music> musicFiles = new ArrayList<>();
        int num=1;
        // 查询媒体数据库
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null, null, null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        // 遍历媒体数据库
        if (cursor.moveToNext()) {

            while (!cursor.isAfterLast()) {
                //歌曲编号
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
                //歌曲标题
                String title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
                //歌曲的专辑名：MediaStore.Audio.Media.ALBUM
                String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
                //歌曲的歌手名： MediaStore.Audio.Media.ARTIST
                String artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
                //歌曲文件的路径 ：MediaStore.Audio.Media.DATA
                String url = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                //歌曲的总播放时长 ：MediaStore.Audio.Media.DURATION
                int duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
                //歌曲文件的大小 ：MediaStore.Audio.Media.SIZE
                long size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));

                music music = new music(num++, title, artist, url, album, duration, size);
                //Log.d("123", "music"+music.toString());
                musicFiles.add(music);

                if (size > 1024 * 800) {// 大于800k
                    if (title.equals("<unknown>") || title.equals("")) {
                        title = "未知";
                    }
                    if ("<unknown>".equals(artist) || "".equals(artist)) {
                        artist = "未知";
                    }

                    //music music = new music(id, title, artist, url, album, duration, size);
                    //Log.d("123", "music"+music.toString());
                    musicFiles.add(music);
                }
                cursor.moveToNext();
            }
        }
        //Log.d("123", musicFiles.toString());
        return musicFiles;
    }

    class MyAdapter extends ArrayAdapter<music> {
        private int id;

        public MyAdapter(@NonNull Context context, int resource,List<music> musicList) {
            super(context, resource, musicList);
            this.id = resource;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            music music = getItem(position);
            View view = null;
            ViewHolder holder = null;
            if (convertView == null) {
                view = LayoutInflater.from(parent.getContext()).inflate(id, parent, false);
                holder = new ViewHolder();
                holder.id = view.findViewById(R.id.order_num);
                holder.name = view.findViewById(R.id.name);
                holder.singerName = view.findViewById(R.id.singerName);
                holder.time = view.findViewById(R.id.time);
                view.setTag(holder);
            } else {
                view = convertView;
                holder = (ViewHolder) view.getTag();
            }
            holder.id.setText(String.valueOf(music.getId()));
            holder.name.setText(music.getTitle());
            holder.singerName.setText(music.getSingerName()+" - "+music.getName());
            int duration = music.getDuration();
            Log.d("123", String.valueOf(duration));
            String time = "";
            if (duration < 60000) {
                time += "0."+duration/1000;
            } else {
                time += duration/60000+".";
                time += duration%1000;
            }
            holder.time.setText(time);
            return view;
        }

        private class ViewHolder {
            TextView id;
            TextView name;
            TextView singerName;
            TextView time;
        }
    }
}