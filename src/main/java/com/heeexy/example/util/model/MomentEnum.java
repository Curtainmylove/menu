package com.heeexy.example.util.model;

public enum MomentEnum {
    MORNING("早上"),NOONING("中午"),NIGHT("晚上");

    private String cnName;

    private MomentEnum(String cnName) {
        this.cnName = cnName;
    }

    public String getCnName() {
        return this.cnName;
    }

}
