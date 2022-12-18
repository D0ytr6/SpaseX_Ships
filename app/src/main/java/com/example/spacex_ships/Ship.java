package com.example.spacex_ships;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private String ship_id;
    private String ship_name;
    private String ship_model;
    private String ship_type;

    public String getShip_id() {
        return ship_id;
    }

    public String getShip_name() {
        return ship_name;
    }

    public String getShip_model() {
        return ship_model;
    }

    public String getShip_type() {
        return ship_type;
    }
//    private Boolean active;
//    private Integer imo;
//    private Integer mmsi;
//    private Integer abs;
//
//    @SerializedName("class")
//    private Integer cls;
//    private Integer weight_lbs;
//    private Integer weight_kg;
//    private Integer year_built;
//    private String home_port;
//    private String status;
//    private String speed_kn;
//    private String course_deg;
//
//    @SerializedName("position")
//    private List<Position> position = new ArrayList<>();
//
//    private Integer successful_landings;
//    private Integer attempted_landings;
//    private String url;
//    private String image;
//
//
////    @SerializedName("data")
////    public List<Datum> data = new ArrayList();
////
////    private class Role {
////        private String
////    }
//
//    private class Position{
//        private String latitude;
//        private String longitude;
//    }
//
//    private class Mission{
//        private String name;
//        private Integer flight;
//
//    }

}