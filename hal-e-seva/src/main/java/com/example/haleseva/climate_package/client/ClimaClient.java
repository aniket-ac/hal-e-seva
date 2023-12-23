package com.example.haleseva.climate_package.client;

import com.example.haleseva.climate_package.clima.ClimaResponse;
import com.example.haleseva.utils.HttpHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Configuration
public class ClimaClient {
    private RestTemplate restTemplate = new RestTemplate();
    final private String APP_ID = "1a21218a13b54dd184bbf33719a586ed";
    final private String CLLIMA_URI = "https://api.weatherbit.io/";

    public Optional<ClimaResponse> callClima(final double latitude, final double longitude) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromHttpUrl(CLLIMA_URI).pathSegment("v2.0", "current");
        uriComponentsBuilder.queryParam("lat", latitude);
        uriComponentsBuilder.queryParam("lon", longitude);
        uriComponentsBuilder.queryParam("key", APP_ID);
        return HttpHandler.call(restTemplate, ClimaResponse.class,uriComponentsBuilder);
    }

}
