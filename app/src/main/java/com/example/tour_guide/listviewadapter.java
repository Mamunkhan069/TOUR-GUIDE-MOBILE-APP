package com.example.tour_guide;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class listviewadapter extends ArrayAdapter<guideInformation> {
    private Activity contex;
    private List<guideInformation> guideInformationslist;

    public listviewadapter(@NonNull Activity context, List<guideInformation> guideInformationslist) {
        super(context, R.layout.guidedemolayout, guideInformationslist);
        this.contex = context;
        this.guideInformationslist = guideInformationslist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater= contex.getLayoutInflater();
       View view = layoutInflater.inflate(R.layout.guidedemolayout,null,true);

       guideInformation guideInformation=guideInformationslist.get(position);
        TextView name=view.findViewById(R.id.nametextid);
        TextView email=view.findViewById(R.id.emailtextid);
        TextView age=view.findViewById(R.id.agetextid);
        TextView mobilenumber=view.findViewById(R.id.mobiletextid);
        TextView district=view.findViewById(R.id.districttextid);

        return view;
    }
}
