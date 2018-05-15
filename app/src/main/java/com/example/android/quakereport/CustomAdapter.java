package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    public CustomAdapter(Activity context, ArrayList<Earthquake> miwoks) {
        super(context, 0, miwoks);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_list_item, parent, false);
        }

        Earthquake current = (Earthquake) getItem(position);

        TextView mag = (TextView) listitemView.findViewById(R.id.magnitude);
        String toSet = Double.toString(current.getMagnitude());
        mag.setText(toSet);

        TextView loc = (TextView) listitemView.findViewById(R.id.location);
        loc.setText(current.getName());

        TextView date = (TextView) listitemView.findViewById(R.id.date);
        String dateSet;

        long dateUni = current.getDate1();
        Date dateObject = new Date(dateUni);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        dateSet = dateFormatter.format(dateObject);
        date.setText(dateSet);

        TextView time = (TextView) listitemView.findViewById(R.id.time);
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String timeStr;

        time.setText(timeFormatter.format(dateObject));


        return listitemView;
    }
}
