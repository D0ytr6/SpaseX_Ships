package com.example.spacex_ships;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

// use for ignoring other fields, that don't mentioned in class but exist in JSON
@JsonIgnoreProperties(ignoreUnknown=true)
@Entity(tableName = "ships",indices = @Index(value = {"ship_id"},unique = true))
public class Ship {
    @PrimaryKey@NonNull
    @ColumnInfo(name = "ship_id")
    String ship_id;

    @ColumnInfo(name = "ship_name")
    private String ship_name;

    @ColumnInfo(name = "ship_model")
    private String ship_model;

    @ColumnInfo(name = "ship_type")
    private String ship_type;

    @ColumnInfo(name = "year_built")
    private Integer year_built;

    @ColumnInfo(name = "home_port")
    private String home_port;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "weight_kg")
    private Integer weight_kg;

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


    public Integer getYear_built() {
        return year_built;
    }

    public void setYear_built(Integer year_built) {
        this.year_built = year_built;
    }

    public String getHome_port() {
        return home_port;
    }

    public void setHome_port(String home_port) {
        this.home_port = home_port;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setShip_id(@NonNull String ship_id) {
        this.ship_id = ship_id;
    }

    public void setShip_name(String ship_name) {
        this.ship_name = ship_name;
    }

    public void setShip_model(String ship_model) {
        this.ship_model = ship_model;
    }

    public void setShip_type(String ship_type) {
        this.ship_type = ship_type;
    }

    public Integer getWeight_kg() {
        return weight_kg;
    }

    public void setWeight_kg(Integer weight_kg) {
        this.weight_kg = weight_kg;
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