package com.example.harshitha.talentacquisition;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.harshitha.talentacquisition.R;

import adapters.ProfileAdapter;

/**
 * Created by harshu on 9/7/2015.
 */
public class Tabfragment1 extends Fragment {

    ImageView im;

    ListView listview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

     View x=inflater.inflate(R.layout.tab_fragment1, container, false);
        im=(ImageView)x.findViewById(R.id.imv1);


     /*   listview=(ListView)x.findViewById(R.id.list1);
        String[] values1=new String[]{
                        "Incture Technologies",
                "Senior Android developer",
                "Designation",
                "Bangalore",
                "Location",
                "Details",
                "August 2013-present",

        };
*/
       // ProfileAdapter adapter=new ProfileAdapter(getActivity(),R.layout.profile_item,values1);
       // listview.setAdapter(adapter);





        DisplayMetrics displaymetrics = new DisplayMetrics();
      getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;

        im.getLayoutParams().height=(int)(0.30*(height));
        im.getLayoutParams().width=(int)(0.35*(width));
        return x;

    }
}