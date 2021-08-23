package com.example.tour_guide;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomAdapter extends BaseExpandableListAdapter {
    private Context context;
    List<String> listdataheader;
    int[] dhakadistrictimages;
    HashMap<String,List<String>> listdatachild;

    public CustomAdapter(Context context, List<String> listdataheader, int[] dhakadistrictimages, HashMap<String, List<String>> listdatachild) {
        this.context = context;
        this.listdataheader = listdataheader;
        this.dhakadistrictimages = dhakadistrictimages;
        this.listdatachild = listdatachild;
    }


    @Override
    public int getGroupCount() {
        return listdataheader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listdatachild.get(listdataheader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listdataheader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return listdatachild.get(listdataheader.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String headerTitle = (String) getGroup(i);
        if(view==null){
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.list_childdetailsgroup, null);
        }
        TextView ListHeader = (TextView) view
                .findViewById(R.id.ListchilddetailHeadertextviewid);
        ImageView imageView=view.findViewById(R.id.imageviewid);
        TextView secondtext=view.findViewById(R.id.headersecondtextviewid);

        ListHeader.setTypeface(null, Typeface.BOLD);
        ListHeader.setText(headerTitle);
        imageView.setImageResource(dhakadistrictimages[i]);
        secondtext.setText("Read More...");

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final String childText = (String) getChild(i, i1);

        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.list_childdetailsitem, null);
        }

        TextView txtListChild = (TextView) view
                .findViewById(R.id.ListchilddetaiItemtextviewid);

        txtListChild.setText(childText);
        return view;

    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
