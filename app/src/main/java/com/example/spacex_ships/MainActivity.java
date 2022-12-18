package com.example.spacex_ships;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText result;
    private ShipAdapter adapter;
    private ArrayList<ShipState> states = new ArrayList<ShipState>();
    ListView ship_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ship_list = findViewById(R.id.ships_list);
        adapter = new ShipAdapter(MainActivity.this, states);
        ship_list.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spacexdata.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SpaceXApi spaceXApi = retrofit.create(SpaceXApi.class);

        Call<List<Ship>> call = spaceXApi.getShips();

        call.enqueue(new Callback<List<Ship>>() {
            @Override
            public void onResponse(Call<List<Ship>> call, Response<List<Ship>> response) {
                if(!response.isSuccessful()){
                    Log.d("Code", String.valueOf(response.code()));
                    return;
                }
                List<Ship> ships = response.body();
                for (Ship ship : ships){
                    ShipState sh = new ShipState(ship.getShip_name(), ship.getShip_type(), ship.getShip_model());
                    adapter.add(sh);
//                    String content = "";
//                    content += "ID: " + ship.getShip_id() + '\n';
//                    content += "Name: " + ship.getShip_name() + '\n';
//                    result.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Ship>> call, Throwable t) {
                Log.d("error", String.valueOf(t));
            }
        });
    }

}