package com.heeexy.example.util.model;

import java.util.Date;
import java.util.List;

public class MenuModel {
    private List<Morning> morning;
    private List<Nooning> nooning;
    private List<Night> night;
    private Date key;

    public void setMorning(List<Morning> morning) {
        this.morning = morning;
    }

    public List<Morning> getMorning() {
        return morning;
    }

    public void setNooning(List<Nooning> nooning) {
        this.nooning = nooning;
    }

    public List<Nooning> getNooning() {
        return nooning;
    }

    public void setNight(List<Night> night) {
        this.night = night;
    }

    public List<Night> getNight() {
        return night;
    }

    public Date getKey() {
        return key;
    }

    public void setKey(Date key) {
        this.key = key;
    }
}
