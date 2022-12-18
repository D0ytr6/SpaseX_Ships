package com.example.spacex_ships;

import android.os.Parcel;
import android.os.Parcelable;

public class ShipState implements Parcelable {

    private String ship_name;
    private String ship_type;
    private String year_built;

    public ShipState(String ship_name, String ship_type, String year_built) {
        this.ship_name = ship_name;
        this.ship_type = ship_type;
        this.year_built = year_built;
    }

    protected ShipState(Parcel in) {
        ship_name = in.readString();
        ship_type = in.readString();
        year_built = in.readString();
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
        parcel.writeString(year_built);
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
}
