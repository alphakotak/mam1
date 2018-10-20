package com.example.android.footaball_turf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Choose_activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_activity1);
    }

    public void screening(View view)
    {
        Intent screening_intent = new Intent(this,com.example.android.footaball_turf.Screening.class);

        startActivity(screening_intent);
    }
}
