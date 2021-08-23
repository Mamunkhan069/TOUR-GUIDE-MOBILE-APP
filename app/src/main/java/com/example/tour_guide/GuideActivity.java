package com.example.tour_guide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {
    private ListView listView;
    DatabaseReference databaseReference;
    private List<guideInformation> guideInformationslist;
    private listviewadapter listviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        listView=findViewById(R.id.listviewid);
        databaseReference= FirebaseDatabase.getInstance().getReference("guideInformation");
        guideInformationslist= new ArrayList<>();
        listviewAdapter = new listviewadapter(GuideActivity.this,guideInformationslist);

    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                guideInformationslist.clear();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    guideInformation guideInformation=dataSnapshot.getValue(guideInformation.class);
                    guideInformationslist.add(guideInformation);


                }
                listView.setAdapter(listviewAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
