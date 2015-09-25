package com.example.harshitha.talentacquisition;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    TextView tv;
    TextView tv1;
    RelativeLayout r1,r2,r3;
    DrawerLayout d1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        tv=(TextView)findViewById(R.id.tv3);
        tv1=(TextView)findViewById(R.id.tv4);

        r1=(RelativeLayout)findViewById(R.id.rel1);
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, Apply.class);
                startActivity(i);
            }
        });

        r2=(RelativeLayout)findViewById(R.id.rel2);
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Apply.class);
                startActivity(i);
            }
        });


        r3=(RelativeLayout)findViewById(R.id.header);
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d1=(DrawerLayout)findViewById(R.id.drawer);
                d1.closeDrawers();
                Intent i=new Intent(MainActivity.this,UserProfile.class);
                startActivity(i);
            }
        });
        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        if(toolbar!=null)
        setSupportActionBar(toolbar);

        final ActionBar actionBar=getSupportActionBar();
        // actionbar.setHomeAsUpIndicator(R.drawable.icon_history);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("All Jobs");
        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()){


                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.Profile:
                    { Intent i=new Intent(MainActivity.this,UserProfile.class);
                        startActivity(i);}
                    return true;

                    case R.id.History:
                    {Intent i=new Intent(MainActivity.this,MainActivity.class);
                        startActivity(i);}
                    return true;
                    case R.id.Savejobs:
                    {Intent i=new Intent(MainActivity.this,MainActivity.class);
                        startActivity(i);}
                    return true;
                    case R.id.Preferences:
                    {
                        d1=(DrawerLayout)findViewById(R.id.drawer);
                        d1.closeDrawers();
                        Intent i=new Intent(MainActivity.this,Preferences.class);
                        startActivity(i);}
                    return true;
                    case R.id.Jobrequest:
                    {
                        Intent i=new Intent(MainActivity.this,JobRequest.class);
                        startActivity(i);
                    }
                    return true;
                    case R.id.Settings:
                    {
                        Intent i = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });


        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


//end of onCreate
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id==android.R.id.home)
        {
            onBackPressed();
            return true;
        }

        if(id==R.id.action_filter)
        {
            Intent i=new Intent(MainActivity.this,Filters.class);
            startActivity(i);
            return true;
        }
        if(id==R.id.action_search)
        {
            Intent i=new Intent(MainActivity.this,Search.class);
            startActivity(i);
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
