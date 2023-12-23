package com.example.haleseva.news_package.client;

import com.example.haleseva.news_package.news.NewsResponse;
import com.example.haleseva.utils.HttpHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

public class NewsClient {
    private RestTemplate restTemplate = new RestTemplate();
    final private String APP_ID = "8de7bab42e3d4ff4b25e420af2d05a7a";
    final private String NEWS_API = "https://newsapi.org";

    public Optional<NewsResponse> callNews(final String location) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromHttpUrl(NEWS_API).pathSegment("v2","everything");
        uriComponentsBuilder.queryParam("q",location);
        uriComponentsBuilder.queryParam("sortBy","date");
        uriComponentsBuilder.queryParam("apiKey",APP_ID);
        return HttpHandler.call(restTemplate,NewsResponse.class,uriComponentsBuilder);
    }

}
