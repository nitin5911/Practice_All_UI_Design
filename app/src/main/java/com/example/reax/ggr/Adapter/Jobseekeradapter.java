package com.example.reax.ggr.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reax.ggr.R;

/**
 * Created by reax on 22/12/17.
 */

public class Jobseekeradapter extends BaseAdapter {
    //Navigation Menu Data
    int Image_data[]={R.drawable.user,R.drawable.summary,R.drawable.list,R.drawable.interview,R.drawable.filter,R.drawable.jobmela,R.drawable.experience,R.drawable.placeholder};
    String text_data[]={"Update Profile","Summary","Job applied","My Interviews","Job Prefrences","Job Mela Participate","Feedback On Local Services","Map"};
    Context context;
    LayoutInflater layoutInflater;

    public Jobseekeradapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return text_data.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view_obj=layoutInflater.inflate(R.layout.listviewdata,null);
        ImageView img= (ImageView) view_obj.findViewById(R.id.naviconid);
        TextView text_obj=(TextView)view_obj.findViewById(R.id.navtextid);
        img.setImageResource(Image_data[i]);
        text_obj.setText(text_data[i]);
        return view_obj;
    }
}
