package com.example.ayoubma.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        imageView = (ImageView) findViewById(R.id.image_activity);
        textView = (TextView) findViewById(R.id.item_description_activity);

        imageView.setImageResource(getIntent().getIntExtra("PHOTO", 0));
        textView.setText("Description :"+getIntent().getStringExtra("DESCRIPTION"));
    }
}
