package com.coderscampus.assignment10.web;

import com.coderscampus.assignment10.dto.DayResponse;
import com.coderscampus.assignment10.dto.WeekResponse;

import com.coderscampus.assignment10.services.SpoonApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MealController {


    @Autowired
    SpoonApiService spoonApiService;

    @GetMapping("/mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
        return spoonApiService.getResponse("week",numCalories,diet,exclusions,WeekResponse.class);

    }


    @GetMapping("/mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
        return spoonApiService.getResponse("day",numCalories,diet,exclusions,DayResponse.class);


    }

}
