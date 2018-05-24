package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;

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
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd");
        dateSet = dateFormatter.format(dateObject);
        date.setText(dateSet);

        TextView time = (TextView) listitemView.findViewById(R.id.time);
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String timeStr;

        time.setText(timeFormatter.format(dateObject));

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(current.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        return listitemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
