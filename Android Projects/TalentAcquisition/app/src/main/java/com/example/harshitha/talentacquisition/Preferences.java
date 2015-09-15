package com.example.harshitha.talentacquisition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by harshu on 9/11/2015.
 */
public class Preferences extends AppCompatActivity {

    Toolbar toolbar1;
    Button b1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferences);

        toolbar1 = (Toolbar) findViewById(R.id.tool1);
        if (toolbar1 != null)
            setSupportActionBar(toolbar1);

        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Preferences");


        b1=(Button)findViewById(R.id.prefbutton1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Preferences.this, "Preferences Saved", Toast.LENGTH_SHORT).show();

                Intent i= new Intent(Preferences.this,MainActivity.class);
                startActivity(i);
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if(id==android.R.id.home)
        {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}