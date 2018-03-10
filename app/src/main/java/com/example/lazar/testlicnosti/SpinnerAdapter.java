package com.example.lazar.testlicnosti;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Lazar on 3/5/18.
 */

public class SpinnerAdapter extends ArrayAdapter<String> {

    Context context;
    String[] values;

    public SpinnerAdapter(@NonNull Context context, int textViewResourceId, String[] values) {
        super(context, textViewResourceId, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getPosition(@Nullable String item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public boolean isEnabled(int position) {
        if (position == 0) {
            return false;
        }
        return true;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView label = new TextView(context);
        label.setBackgroundColor(Color.WHITE);
        label.setTextColor(Color.BLACK);
        label.setPadding(16, 0, 16, 0);
        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        label.setText(values[position]);

        // And finally return your dynamic (or custom) view for each spinner item
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = new TextView(context);
        if (position == 0) {
            label.setTextColor(Color.GRAY);
        }else {
            label.setTextColor(Color.BLACK);
        }

        label.setText(values[position]);

        return label;
    }
}
