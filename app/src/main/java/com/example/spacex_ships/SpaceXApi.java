package com.example.spacex_ships;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

// realization of this methods will create retrofit
// and return an object of interface
public interface SpaceXApi {

    // call encapsulating response and request methods
    @GET("v3/ships")
    Call<List<Ship>> getShips();
}
