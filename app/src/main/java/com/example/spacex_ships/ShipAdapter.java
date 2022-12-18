package com.example.spacex_ships;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ShipAdapter extends ArrayAdapter<ShipState> {

    Context context;
    LayoutInflater inflater;
    ArrayList<ShipState> ships_list_data;

    public ShipAdapter(Context context, @NonNull ArrayList<ShipState> objects) {
        super(context, 0, objects);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.ships_list_data = objects;

    }
    public ArrayList<ShipState> getValueList(){
        return ships_list_data;
    }

    @Override
    public int getCount() {
        return ships_list_data.size();
    }

    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null){
            convertView = inflater.inflate(R.layout.ship_list_item, parent, false);
        }

        ShipState ship_row = ships_list_data.get(position);

        TextView ship_name = (TextView) convertView.findViewById(R.id.ship_name);
        TextView ship_type = (TextView) convertView.findViewById(R.id.ship_type);
        TextView year_built = (TextView) convertView.findViewById(R.id.year_built);

        ship_name.setText(ship_row.getShip_name());
        ship_type.setText(ship_row.getShip_type());
        year_built.setText(ship_row.getYear_built());

        return convertView;
    }


}
