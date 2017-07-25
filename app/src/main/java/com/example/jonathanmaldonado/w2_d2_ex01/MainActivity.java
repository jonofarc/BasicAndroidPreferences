package com.example.jonathanmaldonado.w2_d2_ex01;

import android.content.SharedPreferences;
import android.media.audiofx.BassBoost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyApplicationSettings";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("Key", "Some Value");
        editor.commit();

        String value = settings.getString("Key", "");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();


    }

    public void SaveFields(View view) {


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        EditText name = (EditText) findViewById(R.id.user_name);
        EditText lastName = (EditText) findViewById(R.id.user_last_name);
        editor.putString("Name",name.getText().toString() );
        editor.putString("LastName",lastName.getText().toString() );
        editor.commit();

        name.setText("");
        lastName.setText("");

    }

    public void ReadName(View view) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        String value = settings.getString("Name", "");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
    }


    public void ReadLastName(View view) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        String value = settings.getString("LastName", "");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
    }

    public void UpdatePreferences(View view) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        EditText name = (EditText) findViewById(R.id.user_name);
        EditText lastName = (EditText) findViewById(R.id.user_last_name);
        String nameValue = settings.getString("Name", "");
        String lastNameValue = settings.getString("LastName", "");
        name.setText(nameValue);
        lastName.setText(lastNameValue);
        editor.putString("Name",name.getText().toString() );
        editor.putString("LastName",lastName.getText().toString() );
        editor.commit();
    }
}
