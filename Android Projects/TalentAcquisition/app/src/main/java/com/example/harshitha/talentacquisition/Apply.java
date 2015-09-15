package com.example.harshitha.talentacquisition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by harshu on 9/1/2015.
 */
public class Apply extends AppCompatActivity {

    Toolbar toolbar1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apply);

        toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar1!=null)
            setSupportActionBar(toolbar1);

        final ActionBar actionbar= getSupportActionBar();
        // actionbar.setHomeAsUpIndicator(R.drawable.icon_history);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle("Apply");
        final com.github.clans.fab.FloatingActionMenu b = (com.github.clans.fab.FloatingActionMenu)findViewById(R.id.menu);
        com.github.clans.fab.FloatingActionButton b1 = (com.github.clans.fab.FloatingActionButton)findViewById(R.id.menu_item1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     b.close(true);

                Intent i = new Intent(Apply.this, Forward.class);
                startActivity(i);

            }
        });

        com.github.clans.fab.FloatingActionButton b2 = (com.github.clans.fab.FloatingActionButton)findViewById(R.id.menu_item2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.close(true);


                Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();

            }
        });

        com.github.clans.fab.FloatingActionButton b3 = (com.github.clans.fab.FloatingActionButton)findViewById(R.id.menu_item3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.close(true);

                Intent i = new Intent(Apply.this, Attach.class);
                startActivity(i);

            }
        });


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if(id==android.R.id.home)
        {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }




    }
