package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harshitha.talentacquisition.R;


/**
 * Created by harshu on 9/10/2015.
 */
public class ProfileAdapter extends ArrayAdapter<String> {

    Context c;
    String[] items1;
    TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7;
    ImageView img;
    LayoutInflater inflater;

    public ProfileAdapter(Context context, int resource, String[] data) {
        super(context, resource, data);
        this.c = context;
        items1 = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.profile_item, parent, false);
            txt1 = (TextView) view.findViewById(R.id.text1);
            txt2 = (TextView) view.findViewById(R.id.text2);
            txt3 = (TextView) view.findViewById(R.id.text3);
            txt4 = (TextView) view.findViewById(R.id.text4);
            txt5 = (TextView) view.findViewById(R.id.text5);
            txt6 = (TextView) view.findViewById(R.id.text6);
            txt7 = (TextView) view.findViewById(R.id.text7);


            img = (ImageView) view.findViewById(R.id.image);


            String z = items1[3];
            txt1.setText(z);
            txt2.setText(z);
            txt3.setText(z);
            txt4.setText(z);
            txt5.setText(z);
            txt6.setText(z);
            txt7.setText(z);
            if (position == 0) {
                img.setBackgroundResource(R.drawable.icon_fav);
            }
            if (position == 1) {
                img.setBackgroundResource(R.drawable.icon_fav);
            }
        }
        return view;
    }
}

