package com.example.uidesign2;

public class Fruit {
    private String name;
    private String english;
    private int season;
    private String nickname;
    private String description;
    private int photoId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public Fruit(String name, String english, int season,int photoId , String description,String nickname ) {
        this.name = name;
        this.english = english;
        this.season = season;
        this.nickname = nickname;
        this.description = description;
        this.photoId = photoId;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", english='" + english + '\'' +
                ", season=" + season +
                ", nickname='" + nickname + '\'' +
                ", description='" + description + '\'' +
                ", photoId=" + photoId +
                '}';
    }
}
