package com.example.haleseva.news_package.news;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Setter
@Getter
public class NewsResponse {


    public String status;
    public int totalResults;
    public ArrayList<Article> articles;

    @Getter
    @Setter
    public static class Article{
        public Source source;
        public String author;
        public String title;
        public String description;
        public String url;
        public String urlToImage;
        public Date publishedAt;
        public String content;
    }


    @Getter
    @Setter
    public static class Source{
        public String id;
        public String name;
    }


}
