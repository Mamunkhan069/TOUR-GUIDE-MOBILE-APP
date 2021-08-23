package com.example.tour_guide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private int lastexpandedposition=-1;
    private String childname;
    FirebaseAuth mAuth;

    private Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        mAuth=FirebaseAuth.getInstance();

        expListView = (ExpandableListView) findViewById(R.id.lvExp);



        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);


        expListView.setAdapter(listAdapter);

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {

                return false;
            }
        });


        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                childname = listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition);
                if(groupPosition==0){
                    if(childPosition==0){
                        intent= new Intent(MainActivity.this,ChildetaisActivity.class);
                        intent.putExtra("name","dhaka");
                        startActivity(intent);
                    }
                    if(childPosition==1){
                        intent= new Intent(MainActivity.this,ChildetaisActivity.class);
                        intent.putExtra("name","gazipur");
                        startActivity(intent);
                    } if(childPosition==2){
                        intent= new Intent(MainActivity.this,ChildetaisActivity.class);
                        intent.putExtra("name","manikgonj");
                        startActivity(intent);
                    } if(childPosition==3){
                        intent= new Intent(MainActivity.this,ChildetaisActivity.class);
                        intent.putExtra("name","kishorgonj");
                        startActivity(intent);
                    } if(childPosition==1){
                        intent= new Intent(MainActivity.this,ChildetaisActivity.class);
                        intent.putExtra("name","munsigonj");
                        startActivity(intent);
                    } if(childPosition==1){
                        intent= new Intent(MainActivity.this,ChildetaisActivity.class);
                        intent.putExtra("name","narayangonj");
                        startActivity(intent);
                    } if(childPosition==1){
                        intent= new Intent(MainActivity.this,ChildetaisActivity.class);
                        intent.putExtra("name","narsindi");
                        startActivity(intent);
                    }if(childPosition==1){
                        intent= new Intent(MainActivity.this,ChildetaisActivity.class);
                        intent.putExtra("name","tangail");
                        startActivity(intent);
                    }if(childPosition==1){
                        intent= new Intent(MainActivity.this,ChildetaisActivity.class);
                        intent.putExtra("name","faridpur");
                        startActivity(intent);
                    }if(childPosition==1){
                        intent= new Intent(MainActivity.this,ChildetaisActivity.class);
                        intent.putExtra("name","gopalgonj");
                        startActivity(intent);
                    }if(childPosition==1){
                        intent= new Intent(MainActivity.this,ChildetaisActivity.class);
                        intent.putExtra("name","madaripur");
                        startActivity(intent);
                    }if(childPosition==1){
                        intent= new Intent(MainActivity.this,ChildetaisActivity.class);
                        intent.putExtra("name","shariotpur");
                        startActivity(intent);
                    }
                }
                if(groupPosition==1){
                    if(childPosition==0){
                        intent= new Intent(MainActivity.this,ChildetaisActivity.class);
                        intent.putExtra("name","rajshahi");
                        startActivity(intent);
                    }
                }

                return false;
            }
        });


        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                if(lastexpandedposition !=-1 && lastexpandedposition!=i){
                    expListView.collapseGroup(lastexpandedposition);
                }
                lastexpandedposition=i;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Guideid:
                Intent intent1 = new Intent(getApplicationContext(), GuideActivity.class);
                startActivity(intent1);

                break;
            case R.id.Registerasaguideid:
                Intent intent2 = new Intent(getApplicationContext(), RegisterguideActivity.class);
                startActivity(intent2);
                break;

                case R.id.Signoutid:
                    FirebaseAuth.getInstance().signOut();
                Intent intent3 = new Intent(getApplicationContext(), SigninActivity.class);
                startActivity(intent3);



        }

        return super.onOptionsItemSelected(item);
    }
    // Preparing the list data

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Dhaka Division");
        listDataHeader.add("Rajshahi Division");
        listDataHeader.add("Khulna Division");
        listDataHeader.add("Chattogram Division");
        listDataHeader.add("Sylhet Division");
        listDataHeader.add("Rangpur Division");
        listDataHeader.add("Barisal Division");
        listDataHeader.add("Mymensingh Division");

        // Adding child data
        List<String> Dhakadivision = new ArrayList<String>();
        Dhakadivision.add("Dhaka District");
        Dhakadivision.add("Gazipur District");
        Dhakadivision.add("Manikganj District");
        Dhakadivision.add("Kishoreganj District");
        Dhakadivision.add("Munshiganj Distric");
        Dhakadivision.add("Narayanganj District");
        Dhakadivision.add("Narsingdi District");
        Dhakadivision.add("Tangail District");
        Dhakadivision.add("Faridpur District");
        Dhakadivision.add("Gopalganj District");
        Dhakadivision.add("Madaripur District");
        Dhakadivision.add("Rajbari District");
        Dhakadivision.add("Shariatpur District");

        List<String> Rajshahidivision = new ArrayList<String>();
        Rajshahidivision.add("Rajshahi District");
        Rajshahidivision.add("Bogura District");
        Rajshahidivision.add("Chapainawabganj Distric");
        Rajshahidivision.add("Joypurhat District");
        Rajshahidivision.add("Naogaon District");
        Rajshahidivision.add("Natore District");
        Rajshahidivision.add("Pabna District");
        Rajshahidivision.add("Sirajgonj District");

        List<String> Khulnadivision = new ArrayList<String>();
        Khulnadivision.add("Khulna District");
        Khulnadivision.add("Bagerhat District");
        Khulnadivision.add("Jessore District");
        Khulnadivision.add("Jhenaidah District");
        Khulnadivision.add("Kushtia District");
        Khulnadivision.add("Magura District");
        Khulnadivision.add("Meherpur District");
        Khulnadivision.add("Narail District");
        Khulnadivision.add("Satkhira District");

        List<String> Chattogramdivision=new ArrayList<>();
        Chattogramdivision.add("Chattogram District");
        Chattogramdivision.add("Cumilla District");
        Chattogramdivision.add("Chandpur District");
        Chattogramdivision.add("Lakshmipur District");
        Chattogramdivision.add("Noakhali District");
        Chattogramdivision.add("Feni District");
        Chattogramdivision.add("Khagrachhari District");
        Chattogramdivision.add("Rangamati District");
        Chattogramdivision.add("Bandarban District");

        List<String> Sylhetdivision=new ArrayList<>();
        Sylhetdivision.add("Sylhet District");
        Sylhetdivision.add("Habiganj District");
        Sylhetdivision.add("Moulvibazar District");
        Sylhetdivision.add("Sunamganj District");

        List<String> Rangpurdivission=new ArrayList<>();
        Rangpurdivission.add("Rangpur District");
        Rangpurdivission.add("Panchagarh District");
        Rangpurdivission.add("Dinajpur District");
        Rangpurdivission.add("Nilphamari District");
        Rangpurdivission.add("Lalmonirhat District");
        Rangpurdivission.add("Kurigram District");
        Rangpurdivission.add("Gaibandha District");

        List<String> Barisaldivision=new ArrayList<>();
        Barisaldivision.add("Barisal District");
        Barisaldivision.add("Barguna District");
        Barisaldivision.add("Bhola District");
        Barisaldivision.add("Jhalokati District");
        Barisaldivision.add("Patuakhali District");
        Barisaldivision.add("Pirojpur District");

        List<String> Mymensinghdivision=new ArrayList<>();
        Mymensinghdivision.add("Mymensingh District");
        Mymensinghdivision.add("Netrokona District");
        Mymensinghdivision.add("Jamalpur Districtt");
        Mymensinghdivision.add("Sherpur District");

        listDataChild.put(listDataHeader.get(0), Dhakadivision); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Rajshahidivision);
        listDataChild.put(listDataHeader.get(2), Khulnadivision);
        listDataChild.put(listDataHeader.get(3), Chattogramdivision);
        listDataChild.put(listDataHeader.get(4), Sylhetdivision);
        listDataChild.put(listDataHeader.get(5), Rangpurdivission);
        listDataChild.put(listDataHeader.get(6), Barisaldivision);
        listDataChild.put(listDataHeader.get(7), Mymensinghdivision);
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder;
        alertDialogBuilder=new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setIcon(R.drawable.question2);
        alertDialogBuilder.setTitle(R.string.alerttitle_text);
        alertDialogBuilder.setMessage(R.string.message_text);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog=alertDialogBuilder.create();
        alertDialog.show();
    }

}
