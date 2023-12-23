package com.example.haleseva.utils;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpHandler {

    public static <T> Optional<T> call(RestTemplate restTemplate, Class<T> clazz, UriComponentsBuilder uriComponentsBuilder) {
        try {
            ResponseEntity<T> response = restTemplate.getForEntity(uriComponentsBuilder.build().toUriString(), clazz);

            if (response.getStatusCode()
                    .isError()) {
                return Optional.empty();
            }
            return Optional.ofNullable(response.getBody());

        } catch (HttpStatusCodeException e) {
            throw e;
        }
    }

}
