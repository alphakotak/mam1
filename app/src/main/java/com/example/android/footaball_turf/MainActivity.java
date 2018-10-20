package com.example.android.footaball_turf;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.footaball_turf.data.RegisterDbHelper;

import static com.example.android.footaball_turf.data.RegisterDbHelper.COLUMN_EMAIL;
import static com.example.android.footaball_turf.data.RegisterDbHelper.COLUMN_NAME;
import static com.example.android.footaball_turf.data.RegisterDbHelper.COLUMN_PASS;
import static com.example.android.footaball_turf.data.RegisterDbHelper.TABLE_NAME;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = MainActivity.this;

    private EditText mNameEditText;
    private EditText mEmailEditText;
    private EditText mPassEditText;

    private Button ButtonRegister;
    private TextView LoginIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEditText = (EditText) findViewById(R.id.name);
        mEmailEditText = (EditText) findViewById(R.id.email);
        mPassEditText = (EditText) findViewById(R.id.password);

        ButtonRegister = (Button) findViewById(R.id.button_register);
        LoginIntent = (TextView) findViewById(R.id.loginIntent);

        ButtonRegister.setOnClickListener(this);
        LoginIntent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button_register:
                addUser();
                break;
            case R.id.loginIntent:
                Intent intentLogin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentLogin);
                break;


        }

    }



    public void addUser() {
        String nameString = mNameEditText.getText().toString().trim();
        String emailString = mEmailEditText.getText().toString().trim();
        String passString = mPassEditText.getText().toString().trim();

        RegisterDbHelper mdbHelper = new RegisterDbHelper(this);
        SQLiteDatabase db = mdbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, nameString);
        values.put(COLUMN_EMAIL, emailString);
        values.put(COLUMN_PASS, passString);

        // Inserting Row
        long newRowId = db.insert(TABLE_NAME, null, values);
        Log.v("CatalogActivity", "New row ID" + newRowId);

        if (newRowId == -1) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "User saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }

    }

}

