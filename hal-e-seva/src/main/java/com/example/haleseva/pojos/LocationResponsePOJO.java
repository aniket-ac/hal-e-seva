package com.example.haleseva.pojos;

import com.example.haleseva.climate_package.clima.ClimaResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class LocationResponsePOJO {
    //CLima
    public String city_name;
    public ClimaResponse.Weather weather;
    public int temp;

    //News
    public ArrayList<NewsData> newsData;
    @Getter
    @Setter
    public static class NewsData{
        public String title;
        public String description;
        public String url;
        public String urlToImage;
    }


}
