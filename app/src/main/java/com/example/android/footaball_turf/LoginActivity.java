package com.example.android.footaball_turf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.footaball_turf.data.RegisterDbHelper;
import com.example.android.footaball_turf.R;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = LoginActivity.this;


    private EditText mEmailEditText;
    private EditText mPassEditText;

    private Button ButtonLogin;
    private TextView RegisterIntent;

    private RegisterDbHelper databaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmailEditText = (EditText) findViewById(R.id.email);
        mPassEditText = (EditText) findViewById(R.id.password);

        ButtonLogin = (Button) findViewById(R.id.button_login);
        RegisterIntent = (TextView) findViewById(R.id.registerIntent);

        ButtonLogin.setOnClickListener(this);
        RegisterIntent.setOnClickListener(this);

        databaseHelper = new RegisterDbHelper(activity);



    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button_login:
                verify();
                break;
            case R.id.registerIntent:
                Intent intentRegister = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intentRegister);
                break;
        }

    }

    private void verify(){

        if(databaseHelper.checkUser(mEmailEditText.getText().toString().trim(), mPassEditText.getText().toString().trim()))
        {
            Intent ChooseIntent = new Intent(activity, Choose_activity1.class);
            ChooseIntent.putExtra("EMAIL", mEmailEditText.getText().toString().trim());
            empty();
            startActivity(ChooseIntent);
        }
        else
        {
            Toast.makeText(this, "Wrong Email or Password. Try Again." , Toast.LENGTH_SHORT).show();

        }

    }

    private void empty(){
        mEmailEditText.setText(null);
        mPassEditText.setText(null);
    }
}
