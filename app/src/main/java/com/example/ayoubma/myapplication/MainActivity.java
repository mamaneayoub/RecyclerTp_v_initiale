package com.example.ayoubma.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.*;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerAdapter mAdapter;
    List<PhotoActivity> mPhotosList = new ArrayList<PhotoActivity>();
    List<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
       // mLinearLayoutManager = new LinearLayoutManager(this);

        GridLayoutManager manager = new GridLayoutManager (MainActivity.this, 2, GridLayoutManager .VERTICAL, false);
        manager .setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

            @Override
            public int getSpanSize(int arg0) {
                return (arg0 % 3) == 0 ? 2 : 1;
            }
        });

        //mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setLayoutManager(manager);




        data.add("GT4 STINGER une supercar KIA de 315 ch");
        data.add("lamborghini Huracán une supercar Mercedes de 560 ch");
        data.add("AMG R50 une supercar Mercedes de 1 300 ch");
        data.add("lamborghini Huracán une supercar Mercedes de 760 ch");
        data.add("McLaren 570 GT une supercar McLaren de 500 ch");
        data.add("lamborghini Huracán une supercar Mercedes de 860 ch");
        data.add("lamborghini Huracán une supercar lamborghini de 560 ch");
        data.add("lamborghini Huracán une supercar Mercedes de 960 ch");
        data.add("lamborghini Huracán une supercar Mercedes de 1 960 ch");
        data.add("lamborghini Huracán une supercar Mercedes de 2 960 ch");
        data.add("lamborghini Huracán une supercar Mercedes de 3 960 ch");

        for(int i = 0; i < 11; i++) {
            PhotoActivity img = new PhotoActivity();
            img.setTitle("image title "+i);
            img.setDescription(data.get(i));
            int drawableResourceId = this.getResources().getIdentifier("images_"+String.valueOf(i), "drawable", this.getPackageName());
            img.setResId(drawableResourceId);
            // add in list
            mPhotosList.add(img);
        }
        mAdapter = new RecyclerAdapter(mPhotosList, MainActivity.this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
