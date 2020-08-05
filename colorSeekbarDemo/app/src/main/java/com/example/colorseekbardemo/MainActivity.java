package com.example.colorseekbardemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.divyanshu.colorseekbar.ColorSeekBar;

public class MainActivity extends AppCompatActivity {

    View view;
    ColorSeekBar colorSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.view);
        colorSeekBar = findViewById(R.id.color_seekbar);

        colorSeekBar.setOnColorChangeListener(new ColorSeekBar.OnColorChangeListener() {
            @Override
            public void onColorChangeListener(int i) {
                view.setBackgroundColor(i);
            }
        });
    }
}