package adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentManager;

import com.example.harshitha.talentacquisition.Tabfragment1;
import com.example.harshitha.talentacquisition.Tabfragment2;
import com.example.harshitha.talentacquisition.Tabfragment3;


/**
 * Created by harshu on 9/7/2015.
 */
public class ViewpagerAdapter extends FragmentStatePagerAdapter{

    int numoftabs;

     public ViewpagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.numoftabs = NumOfTabs;
    }

    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Tabfragment1 tab1 = new Tabfragment1();
                return tab1;
            case 1:
                Tabfragment2 tab2 = new Tabfragment2();
                return tab2;
            case 2:
                Tabfragment3 tab3 = new Tabfragment3();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numoftabs;
    }

}
