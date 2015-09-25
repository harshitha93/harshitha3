package com.example.harshitha.talentacquisition;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.harshitha.talentacquisition.R;

import adapters.ViewpagerAdapter;

/**
 * Created by harshu on 9/7/2015.
 */
public class UserProfile extends AppCompatActivity {
    Toolbar tb1;
ImageView im;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        tb1=(Toolbar)findViewById(R.id.scrolltb);
        if(tb1!=null)
            setSupportActionBar(tb1);

        final ActionBar ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Profile");

       // im=(ImageView)findViewById(R.id.imv1);

        //DisplayMetrics displaymetrics = new DisplayMetrics();
        //getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        //int height = displaymetrics.heightPixels;
        //int width = displaymetrics.widthPixels;

        //im.getLayoutParams().height=(int)(0.30*(height));
        //im.getLayoutParams().width=(int)(0.35*(width));

        //Log.d("height",""+height);
        //Log.d("width",""+width);



        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Experience"));
        tabLayout.addTab(tabLayout.newTab().setText("Skills"));
        tabLayout.addTab(tabLayout.newTab().setText("Education"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);


        final ViewpagerAdapter adapter = new ViewpagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }


}

