package com.example.androidtkachov;

import android.annotation.SuppressLint;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class FullscreenActivity extends AppCompatActivity {

    private TextView messagePhoto;
    Random random = new Random(System.currentTimeMillis());

    int min = 0;
    int max = 100;
    int number = min + random.nextInt(max - min + 1);

    @SuppressLint({"WrongViewCast", "SetTextI18n"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        messagePhoto = findViewById(R.id.text_message_photo);
        messagePhoto.setText(" " + number);

        Button clickStartButton = findViewById(R.id.button_start);
        clickStartButton.setOnClickListener(clickStartListener);

        Button clickEndButton = findViewById(R.id.button_end);
        clickEndButton.setOnClickListener(clickEndListener);

    }

    private final View.OnClickListener clickStartListener = new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View v) {

            finish();
        }

    };


    private final View.OnClickListener clickEndListener = new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(FullscreenActivity.this, FullscreenActivity.class);
            messagePhoto.setText("  " + number);
            startActivity(intent);
        }
    };
}
