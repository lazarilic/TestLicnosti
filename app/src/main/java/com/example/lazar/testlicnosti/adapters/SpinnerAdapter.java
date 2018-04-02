package com.example.lazar.testlicnosti.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Adapter class for education spinner
 */
public class SpinnerAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] values;

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
        return position != 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView label = new TextView(context);
        label.setBackgroundColor(Color.WHITE);
        label.setTextColor(Color.BLACK);
        label.setText(values[position]);

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
        label.setBackgroundColor(Color.WHITE);
        label.setPadding(16, 16, 16, 16);

        return label;
    }
}
