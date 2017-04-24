package com.example.step04listview2;

/**
 * Created by jeongwoo on 2017-04-24.
 */

public class CountryDto {
    //멤버필드
    private int imageResId;
    private String name;
    //디폴트 생성자
    public CountryDto(){}

    public CountryDto(int imageResId, String name) {
        this.imageResId = imageResId;
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
