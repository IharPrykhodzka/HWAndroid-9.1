package com.example.hwandroid91v2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

class MainActivity extends Activity implements View.OnClickListener {

    private String selectedColor;
    private Integer chooseColor;
    private Button btnOK2;
    private Spinner spinnerColors;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnOK).setOnClickListener(this);

        btnOK2 = findViewById(R.id.btnOK);
        spinnerColors = findViewById(R.id.spinnerThemes);
        ArrayAdapter arrayAdapter2 = ArrayAdapter.createFromResource(this, R.array.spinnerThemes, android.R.layout.simple_spinner_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerColors.setAdapter(arrayAdapter2);

        spinnerColors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapterView, View view, int position, long id) {
                String[] spinnerLanguages = getResources().getStringArray(R.array.spinnerThemes);
                selectedColor = spinnerLanguages[position];

            }

            @Override
            public void onNothingSelected(AdapterView adapterView) {
            }

        });

        btnOK2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedColor.equals("Чёрный")) {
                    chooseColor = 0;
                } else if (selectedColor.equals("Black")) {
                    chooseColor = 0;
                }
                if (selectedColor.equals("Зелёный")) {
                    chooseColor = 1;
                } else if (selectedColor.equals("Green")) {
                    chooseColor = 1;
                }
                if (selectedColor.equals("Синий")) {
                    chooseColor = 2;
                } else if (selectedColor.equals("Blue")) {
                    chooseColor = 2;
                }

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (chooseColor == 0) {
            Utils.changeToTheme(this, Utils.THEME_BLACK);
        }else if (chooseColor == 1) {
            Utils.changeToTheme(this, Utils.THEME_GREEN);
        }else if (chooseColor == 2) {
            Utils.changeToTheme(this, Utils.THEME_BLUE);
        }
    }

    public static class Utils {

        private static int sTheme;

        public final static int THEME_BLACK = 0;
        public final static int THEME_GREEN = 1;
        public final static int THEME_BLUE = 2;


        public static void changeToTheme(Activity activity, int theme) {
            sTheme = theme;
            activity.finish();

            activity.startActivity(new Intent(activity, activity.getClass()));

        }


        public static void onActivityCreateSetTheme(Activity activity) {
            switch (sTheme) {
                default:
                case THEME_BLACK:
                    activity.setTheme(R.style.MyBlackTheme);
                    break;
                case THEME_GREEN:
                    activity.setTheme(R.style.MyGreenTheme);
                    break;
                case THEME_BLUE:
                    activity.setTheme(R.style.MyBlueTheme);
                    break;
            }
        }
    }
}