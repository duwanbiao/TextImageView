package com.simple.text.image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.simple.text.imageView.TextImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextImageView textImage = findViewById(R.id.textImage);
        textImage.setText("2.5555555");
    }
}