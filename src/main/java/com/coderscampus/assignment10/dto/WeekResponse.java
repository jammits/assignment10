package com.coderscampus.assignment10.dto;


import java.util.List;
import java.util.Map;

public class WeekResponse {

    private Map<String, Day> week;

    public Map<String, Day> getWeek() {
        return week;
    }

    public void setWeek(Map<String, Day> week) {
        this.week = week;
    }
}
