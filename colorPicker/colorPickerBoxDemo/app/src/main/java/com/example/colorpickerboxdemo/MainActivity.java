package com.example.colorpickerboxdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import petrov.kristiyan.colorpicker.ColorPicker;

public class MainActivity extends AppCompatActivity {

    RelativeLayout mainlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout mainlayout = findViewById(R.id.layout);

        Button changeBg_btn = findViewById(R.id.colorPicker_btn);

        changeBg_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });
    }

    private void openColorPicker() {
        final ColorPicker colorPicker = new ColorPicker(this);
        ArrayList<String> colors = new ArrayList<>();

        colors.add("#258174");
        colors.add("#3C8D2F");
        colors.add("#20724F");
        colors.add("#6A3AB2");
        colors.add("#323299");
        colors.add("#800080");
        colors.add("#b79716");
        colors.add("#966d37");
        colors.add("#b77231");
        colors.add("#808000");
//        colors.add("#000");
//        colors.add("#ededed");
//        colors.add("#96C3EB");

        colorPicker.setColors(colors)
                .setTitle("You can choose maximum 4 colors")
                .setColumns(5)
                .setRoundColorButton(true)
                .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {

                    @Override
                    public void onChooseColor(int position, int color) {
                        mainlayout.setBackgroundColor(color);
                    }

                    @Override
                    public void onCancel() {

                    }
                }).show();

    }
}