package com.coolweather.wyyui;

public class music {

    private int id;

    private String title;

    private String singerName;

    private String url;

    private String name;

    private int duration;

    private long size;

    public music(int id, String title, String singerName, String url, String name, int duration, long size) {
        this.id = id;
        this.title = title;
        this.singerName = singerName;
        this.url = url;
        this.name = name;
        this.duration = duration;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getSingerName() {
        return singerName;
    }

    public String getUrl() {
        return url;
    }

    public int getDuration() {
        return duration;
    }

    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "music{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", singerName='" + singerName + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", size=" + size +
                '}';
    }
}
