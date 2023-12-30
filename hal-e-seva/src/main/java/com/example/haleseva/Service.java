package com.example.haleseva;

import com.example.haleseva.climate_package.client.ClimaClient;
import com.example.haleseva.news_package.client.NewsClient;
import com.example.haleseva.pojos.LocationRequestPOJO;
import com.example.haleseva.pojos.LocationResponsePOJO;
import com.example.haleseva.pojos.LocationResponsePOJO.NewsData;
import com.example.haleseva.climate_package.clima.ClimaResponse;
import com.example.haleseva.news_package.news.NewsResponse;


import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Service {

    private ClimaClient climaClient = new ClimaClient();
    private NewsClient newsClient = new NewsClient();

    public LocationResponsePOJO callClima(final LocationRequestPOJO requestPOJO){
        Optional<ClimaResponse> climaResponse;
        if(requestPOJO.getCityName() == null){
            climaResponse= climaClient.callClima(requestPOJO.getLatitude(), requestPOJO.getLongitude());
        }else{
            climaResponse= climaClient.callClima(requestPOJO.getCityName());
        }

        LocationResponsePOJO locationResponsePOJO = new LocationResponsePOJO();
        locationResponsePOJO.setCity_name(climaResponse.get().getData().get(0).getCity_name());
        locationResponsePOJO.setWeather(climaResponse.get().getData().get(0).getWeather());
        locationResponsePOJO.setTemp(climaResponse.get().getData().get(0).getTemp());

        Optional<NewsResponse> newsResponse = newsClient.callNews(locationResponsePOJO.getCity_name());

        ArrayList<NewsData> newsDatas = newsResponse.get().getArticles().stream().map(i ->{
            NewsData newsData = new NewsData();
            newsData.setTitle(i.getTitle());
            newsData.setDescription(i.getDescription());
            newsData.setUrl(i.getUrl());
            newsData.setUrlToImage(i.getUrlToImage());
            newsData.setContent(i.getContent());
            return newsData;
        }).collect(Collectors.toCollection(ArrayList::new));

        locationResponsePOJO.setNewsData(newsDatas);

        return locationResponsePOJO;
    }

}
