package com.github.nkolytschew.userservice.service.impl;

import com.github.nkolytschew.userservice.service.LegacyServiceHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class LegacyServiceHandlerImpl implements LegacyServiceHandler {

    private final RestTemplate template;
    private final String url;

    /**
     * @param url as {@link String} - configure URL to LegacyService via application.properties
     */
    public LegacyServiceHandlerImpl(@Value("${remote.service.legacyservice.url}") String url) {
        this.template = new RestTemplate();
        this.url = url;
    }

    /**
     * Depending on the function, the {@link RestTemplate} may returns {@link ResponseEntity}, with the HTTP-StatusCode, HTTP-StatusCodeValue and a typed body.
     * <p>
     * In this case we don't ne a response, so we set response type to null.
     */
    @Override
    public void sendRequest(Long id, Map<String, Object> requestBodyAsJson) {
        final String requestUrl = this.url + "api/v1/shelter/" + id;
        this.template.postForObject(requestUrl, requestBodyAsJson, Void.class);
    }

    /**
     * Depending on the function, the {@link RestTemplate} may returns {@link ResponseEntity}, with the HTTP-StatusCode, HTTP-StatusCodeValue and a typed body.
     * <p>
     * In this case we map the response to {@link String}.
     */
    @Override
    public String getAnimalShelter(Long id) {
        final String requestUrl = this.url + "api/v1/shelter/" + id;
        final ResponseEntity<String> response = this.template.getForEntity(requestUrl, String.class);

        return response.getBody();
    }
}
