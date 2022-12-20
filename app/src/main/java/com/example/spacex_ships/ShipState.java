package com.example.spacex_ships;

import android.os.Parcel;
import android.os.Parcelable;

public class ShipState implements Parcelable {

    private String ship_ID;
    private String ship_name;
    private String ship_type;
    private String ship_model;
    private String year_built;
    private String home_port;
    private String ship_img;
    private String ship_weight;

    public ShipState(String ship_name, String ship_type, String ship_model,
                     String year_built, String home_port, String ship_img, String ship_weight, String ship_ID) {
        this.ship_name = ship_name;
        this.ship_type = ship_type;
        this.ship_model = ship_model;
        this.year_built = year_built;
        this.home_port = home_port;
        this.ship_img = ship_img;
        this.ship_weight = ship_weight;
        this.ship_ID = ship_ID;
    }

    protected ShipState(Parcel in) {
        ship_name = in.readString();
        ship_type = in.readString();
        ship_model = in.readString();
        year_built = in.readString();
        home_port = in.readString();
        ship_img = in.readString();
        ship_weight = in.readString();
        ship_ID = in.readString();
    }

    public static final Creator<ShipState> CREATOR = new Creator<ShipState>() {
        @Override
        public ShipState createFromParcel(Parcel in) {
            return new ShipState(in);
        }

        @Override
        public ShipState[] newArray(int size) {
            return new ShipState[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ship_name);
        parcel.writeString(ship_type);
        parcel.writeString(ship_model);
        parcel.writeString(year_built);
        parcel.writeString(home_port);
        parcel.writeString(ship_img);
        parcel.writeString(ship_weight);
        parcel.writeString(ship_ID);
    }

    public String getShip_model() {
        return ship_model;
    }

    public void setShip_model(String ship_model) {
        this.ship_model = ship_model;
    }

    public String getHome_port() {
        return home_port;
    }

    public void setHome_port(String home_port) {
        this.home_port = home_port;
    }

    public String getShip_img() {
        return ship_img;
    }

    public void setShip_img(String ship_img) {
        this.ship_img = ship_img;
    }

    public String getShip_name() {
        return ship_name;
    }

    public void setShip_name(String ship_name) {
        this.ship_name = ship_name;
    }

    public String getShip_type() {
        return ship_type;
    }

    public void setShip_type(String ship_type) {
        this.ship_type = ship_type;
    }

    public String getYear_built() {
        return year_built;
    }

    public void setYear_built(String year_built) {
        this.year_built = year_built;
    }

    public String getShip_weight() {
        return ship_weight;
    }

    public void setShip_weight(String ship_weight) {
        this.ship_weight = ship_weight;
    }

    public String getShip_ID() {
        return ship_ID;
    }

    public void setShip_ID(String ship_ID) {
        this.ship_ID = ship_ID;
    }
}
