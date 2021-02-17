package com.example.imagesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonPhoto1, buttonPhoto2;
    private ImageView photo1, photo2;
    private boolean isChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initListeners();
    }

    private void initUI() {
        buttonPhoto1 = findViewById(R.id.buttonPhoto1);
        buttonPhoto2 = findViewById(R.id.buttonPhoto2);
        photo1 = findViewById(R.id.photo1);
        photo2 = findViewById(R.id.photo2);
    }

    private void initListeners() {
        buttonPhoto1.setOnClickListener(this);
        buttonPhoto2.setOnClickListener(this);
        photo2.setOnClickListener(this);
    }

    private void getImageUrl(String url, boolean isChangedUs) {
        Glide.with(this).load(url).into(photo2);

        isChanged = isChangedUs;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonPhoto1) {
            photo1.setImageResource(R.drawable.car1);
        }
        if (v.getId() == R.id.buttonPhoto2) {
            photo1.setImageResource(R.drawable.car2);
        }
        if (v.getId() == R.id.photo2) {
            if (!isChanged) {
                getImageUrl("https://www.nicepng.com/png/detail/837-8373756_beagle-clipart-transparent-background-beagle-dog.png", true);
            } else {
                getImageUrl("https://pngimg.com/uploads/fiat/fiat_PNG11863.png", false);
            }
        }
    }

}
