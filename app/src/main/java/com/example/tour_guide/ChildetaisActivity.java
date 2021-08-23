package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChildetaisActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private CustomAdapter customAdapter;
    List<String> listdataheader;
    HashMap<String,List<String>> listdatachild;
    private  int lastexpandedposition=-1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childetais);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        expandableListView=findViewById(R.id.exlistviewtforchilditem);


        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            String childname=bundle.getString("name");

            showDetails(childname);
        }
    }
    void showDetails(String childname){

        if(childname.equals("dhaka")){
            int[] dhakadistrictimages={R.drawable.lalbag,R.drawable .satgambuj,R.drawable.jahangir};
            dhakadistrictdata();
            customAdapter=new CustomAdapter(this,listdataheader,dhakadistrictimages,listdatachild);
            expandableListView.setAdapter(customAdapter);
            expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                @Override
                public void onGroupExpand(int i) {
                    if(lastexpandedposition !=-1 && lastexpandedposition!=i){
                        expandableListView.collapseGroup(lastexpandedposition);
                    }
                    lastexpandedposition=i;
                }
            });


        }
        if(childname.equals("gazipur")){
            int[] dhakadistrictimages={R.drawable.lalbag,R.drawable .satgambuj,R.drawable.jahangir};
            dhakadistrictdata();
            customAdapter=new CustomAdapter(this,listdataheader,dhakadistrictimages,listdatachild);
            expandableListView.setAdapter(customAdapter);
            expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                @Override
                public void onGroupExpand(int i) {
                    if(lastexpandedposition !=-1 && lastexpandedposition!=i){
                        expandableListView.collapseGroup(lastexpandedposition);
                    }
                    lastexpandedposition=i;
                }
            });

        }

    }
    void dhakadistrictdata(){

        String[] headerstring=getResources().getStringArray(R.array.dhaka_district_headertext);
        String[] childdatastring=getResources().getStringArray(R.array.dhaka_district_itemtext);

        listdataheader=new ArrayList<>();
        listdatachild=new HashMap<>();
        for(int i=0;i<headerstring.length;i++){

            listdataheader.add(headerstring[i]);
            List<String> child=new ArrayList<>();
            child.add(childdatastring[i]);
            listdatachild.put(listdataheader.get(i),child);
        }
    }


}

/*
    expandableListView.findViewById(R.id.exlistviewtforchilditem);
     customAdapter=new CustomAdapter(this,listdataheader,dhakadistrictimages,listdatachild);
            expandableListView.setAdapter(customAdapter);
             void dhakadistrictdata(){
        String[] headerstring=getResources().getStringArray(R.array.dhaka_district_headertext);
        String[] childdatastring=getResources().getStringArray(R.array.dhaka_district_itemtext);

        listdataheader=new ArrayList<>();
        listdatachild=new HashMap<>();
        for(int i=0;i<headerstring.length;i++){

            listdataheader.add(headerstring[i]);
            List<String> child=new ArrayList<>();
            child.add(childdatastring[i]);
            listdatachild.put(listdataheader.get(i),child);
        }
    }

*
* */
