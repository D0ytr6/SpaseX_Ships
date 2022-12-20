package com.example.spacex_ships;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ShipViewModel shipViewModel;
    private List<Ship> getShips;
    private ShipAdapter adapter;
    ListView ship_list;
    private Repository repository;

    private ArrayList<ShipState> states = new ArrayList<ShipState>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ship_list = findViewById(R.id.ships_list);

        repository = new Repository(getApplication());
        getShips = new ArrayList<>();
        shipViewModel = new ViewModelProvider(this).get(ShipViewModel.class);

        adapter = new ShipAdapter(MainActivity.this, states);
        ship_list.setAdapter(adapter);

        makeRequest();

        shipViewModel.getAllShips().observe(this, new Observer<List<Ship>>() {
            @Override
            public void onChanged(List<Ship> ships) {
                for (Ship ship : ships) {
                    if(ship.getYear_built() != null && ship.getWeight_kg() != null){
                        ShipState sh = new ShipState(ship.getShip_name(), ship.getShip_type(), ship.getShip_model(),
                                ship.getYear_built().toString(), ship.getHome_port(),
                                ship.getImage(), ship.getWeight_kg().toString(), ship.getShip_id());
                        adapter.add(sh);
                    }
                    if(ship.getYear_built() == null && ship.getWeight_kg() != null) {
                        ShipState sh = new ShipState(ship.getShip_name(), ship.getShip_type(), ship.getShip_model(),
                                "No Information", ship.getHome_port(), ship.getImage(), ship.getWeight_kg().toString(), ship.getShip_id());
                        adapter.add(sh);
                    }
                    if(ship.getYear_built() != null && ship.getWeight_kg() == null){
                        ShipState sh = new ShipState(ship.getShip_name(), ship.getShip_type(), ship.getShip_model(),
                                ship.getYear_built().toString(), ship.getHome_port(), ship.getImage(), "No Information", ship.getShip_id());
                        adapter.add(sh);
                    }
                    else{
                        ShipState sh = new ShipState(ship.getShip_name(), ship.getShip_type(), ship.getShip_model(),
                                "No Information", ship.getHome_port(), ship.getImage(), "No Information", ship.getShip_id());
                        adapter.add(sh);
                    }

                }
                Log.d("main", "onChanged: "+ ships);
            }
        });

        ship_list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                // по позиции получаем выбранный элемент
                ShipState selectedItem = states.get(position);
                Intent intent = new Intent(MainActivity.this, FullInfoActivity.class);
                intent.putExtra("difficult", selectedItem);
                startActivity(intent);
            }
        });

    }

    private void makeRequest() {
        ObjectMapper o = new ObjectMapper();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spacexdata.com/")
                .addConverterFactory(JacksonConverterFactory.create(o))
                .build();

        // create realization of interface methods
        SpaceXApi spaceXApi = retrofit.create(SpaceXApi.class);

        // create call object
        Call<List<Ship>> call = spaceXApi.getShips();

        // make call in other thread
        call.enqueue(new Callback<List<Ship>>() {
            @Override
            public void onResponse(Call<List<Ship>> call, Response<List<Ship>> response) {
                if(!response.isSuccessful()){
                    Log.d("Code", String.valueOf(response.code()));
                    return;
                }
                repository.insert(response.body());
            }

            @Override
            public void onFailure(Call<List<Ship>> call, Throwable t) {
                Log.d("error", String.valueOf(t));
            }
        });
    }
}