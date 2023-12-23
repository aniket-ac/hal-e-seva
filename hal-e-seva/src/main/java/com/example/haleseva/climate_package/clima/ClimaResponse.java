package com.example.haleseva.climate_package.clima;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
public class ClimaResponse {
    public int count;
    public ArrayList<Datum> data;

    @Getter
    @Setter
    public static class Datum{
        public double app_temp;
        public int aqi;
        public String city_name;
        public int clouds;
        public String country_code;
        public String datetime;
        public double dewpt;
        public double dhi;
        public double dni;
        public double elev_angle;
        public double ghi;
        public Object gust;
        public int h_angle;
        public double lat;
        public double lon;
        public String ob_time;
        public String pod;
        public int precip;
        public double pres;
        public int rh;
        public int slp;
        public int snow;
        public double solar_rad;
        public ArrayList<String> sources;
        public String state_code;
        public String station;
        public String sunrise;
        public String sunset;
        public int temp;
        public String timezone;
        public int ts;
        public double uv;
        public int vis;
        public Weather weather;
        public String wind_cdir;
        public String wind_cdir_full;
        public int wind_dir;
        public double wind_spd;
    }

    @Getter
    @Setter
    public static class Weather{
        public String icon;
        public int code;
        public String description;
    }


}
