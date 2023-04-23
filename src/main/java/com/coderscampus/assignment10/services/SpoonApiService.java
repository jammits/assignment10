package com.coderscampus.assignment10.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


@Service
public class SpoonApiService {

    @Value("${spoonacular.urls.base}")
    private String baseUrl;

    @Value("${spoonacular.urls.mealplan}")
    private String mealPlan;

    @Value("${spoonacular.api.key}")
    private String apiKey;


    public <T> ResponseEntity<T> getResponse(String timeFrame,String numCalories, String diet, String exclusions, Class<T> reponseClass) {
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl+mealPlan)
                .queryParam("timeFrame", timeFrame)
                .queryParamIfPresent("targetCalories", Optional.ofNullable(numCalories))
                .queryParamIfPresent("diet", Optional.ofNullable(diet))
                .queryParamIfPresent("exclude", Optional.ofNullable(exclusions))
                .queryParam("apiKey",apiKey)
                .build()
                .toUri();

        RestTemplate restTemp = new RestTemplate();
        return restTemp.getForEntity(uri, reponseClass);
    }
}
