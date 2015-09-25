package com.example.harshitha.talentacquisition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.text.TextWatcher;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by harshu on 9/2/2015.
 */
public class Search extends Activity {

    EditText et;
    LinearLayout linear;
    ImageView img1;
    ImageView img2;
    ImageView img3;

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;


    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_history);

        img1 = (ImageView) findViewById(R.id.imageview1);
        img2 = (ImageView) findViewById(R.id.imageview2);
        img3 = (ImageView) findViewById(R.id.imageview3);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Search.this, MainActivity.class);
                startActivity(i);

            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Search.this, AdvanceSearch.class);
                startActivity(i);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Search.this, MainActivity.class);
                startActivity(i);

            }
        });

        // Listview Data
        String products[] = {"Android Developer", "Web Developer", "UI Designer", "Talent Executive", "Project Manager",
                "Java Developer", "IT Admin",
                "Finance Consultant", "Finance Manager", "HR Head", "Business Analyst"};

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.searchet);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.search_list_item, R.id.product_name, products);
        lv.setAdapter(adapter);


        inputSearch.addTextChangedListener(new TextWatcher() {


            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                Search.this.adapter.getFilter().filter(cs);
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

    }
}