package com.github.nkolytschew.userservice.service.impl;

import com.github.nkolytschew.userservice.service.RatingServiceHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@Service
public class RatingServiceHandlerImpl implements RatingServiceHandler {

    private final RestTemplate template;
    private final String url;

    /**
     * @param url as {@link String} - configure URL to LegacyService via application.properties
     */
    public RatingServiceHandlerImpl(@Value("${remote.service.ratingservice.url}") String url) {
        this.template = new RestTemplate();
        this.url = url;
    }

    /**
     * If we are using {@link RestTemplate#getForObject(URI, Class)}, we can map the response directly to {@link String}, without wrapping it into a {@link ResponseEntity}.
     */
    @Override
    public String findRatingsByUser(String userId) {
        final String requestUrl = this.url + "rating/" + userId;
        final String response = this.template.getForObject(requestUrl, String.class);

        return response;
    }

    @Override
    public String createNewRating(String ratingAsJson) {
        final String requestUrl = this.url + "rating/";
        final ResponseEntity<String> response = this.template.postForEntity(requestUrl, ratingAsJson, String.class);

        return response.getBody();
    }

    @Override
    public String deleteRatingById(Long id) {
        final String requestUrl = this.url + "rating/" + id;
        final ResponseEntity<String> response = this.template.exchange(requestUrl, HttpMethod.DELETE, null, String.class);

        return response.getBody();
    }
}
