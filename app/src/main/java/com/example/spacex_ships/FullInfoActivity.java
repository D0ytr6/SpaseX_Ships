package com.example.spacex_ships;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FullInfoActivity extends AppCompatActivity {

    private ShipState current_ship;
    private TextView ID, Name, Type, Year, Port, Weight;
    private ImageView ship_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_info);
        ID = findViewById(R.id.ship_id);
        Name = findViewById(R.id.ship_name);
        Type = findViewById(R.id.ship_type);
        Year = findViewById(R.id.year);
        Port = findViewById(R.id.port);
        Weight = findViewById(R.id.weight);
        ship_img = findViewById(R.id.ship_img);

        if(savedInstanceState == null){
            Bundle arguments = getIntent().getExtras();
            this.current_ship = (ShipState) arguments.get("difficult");
        }
        Picasso.get().load(current_ship.getShip_img()).into(ship_img);
        ID.append(current_ship.getShip_ID());
        Name.append(current_ship.getShip_name());
        Type.append(current_ship.getShip_type());
        Year.append(current_ship.getYear_built());
        Port.append(current_ship.getHome_port());
        Weight.append(current_ship.getShip_weight());

    }
}