package com.coderscampus.assignment10.web;

import com.coderscampus.assignment10.dto.DayResponse;
import com.coderscampus.assignment10.dto.WeekResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class MealController {


    @Value("${spoonacular.urls.base}")
    private String baseUrl;

    @Value("${spoonacular.urls.mealplan}")
    private String mealPlan;

    @GetMapping("/mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl+mealPlan)
                    .queryParam("timeFrame", "week")
                    .queryParamIfPresent("targetCalories", Optional.ofNullable(numCalories))
                    .queryParamIfPresent("diet", Optional.ofNullable(diet))
                    .queryParamIfPresent("exclude", Optional.ofNullable(exclusions))
                    .queryParam("apiKey","93bb8586676844849df887fff1e04574")
                    .build()
                    .toUri();

        RestTemplate restTemp = new RestTemplate();
        return restTemp.getForEntity(uri, WeekResponse.class);

    }


    @GetMapping("/mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl+mealPlan)
                .queryParam("timeFrame", "day")
                .queryParamIfPresent("targetCalories", Optional.ofNullable(numCalories))
                .queryParamIfPresent("diet", Optional.ofNullable(diet))
                .queryParamIfPresent("exclude", Optional.ofNullable(exclusions))
                .queryParam("apiKey","93bb8586676844849df887fff1e04574")
                .build()
                .toUri();

        RestTemplate restTemp = new RestTemplate();
        return restTemp.getForEntity(uri, DayResponse.class);


    }

}
