package com.arshilgenius.kisan.agriculture;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.arshilgenius.kisan.agriculture.Activity.Paddy;

import java.util.ArrayList;

public class dayListAdapter extends ArrayAdapter<Date1> {

    private static final String TAG="dayListAdapter";
    private Context mContext;
    private int mResource;
    private int lastPosition=-1;
    static class ViewHolder{
        TextView date;
        TextView info;
    }

    public dayListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Date1> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String date=getItem(position).getDate();
        String info=getItem(position).getInfo();

        Date1 d=new Date1(date,info);

        final View result ;
        ViewHolder holder;


        if (convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.date = (TextView) convertView.findViewById(R.id.textView1);
            holder.info = (TextView) convertView.findViewById(R.id.textView2);
            result = convertView;
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
            result=convertView;
        }
        Animation animation = AnimationUtils.loadAnimation(mContext, (position>lastPosition)?R.anim.load_down_anum:R.anim.load_up_anum);

        result.startAnimation(animation);
        lastPosition=position;

        holder.date.setText(date);
        holder.info.setText(info);

        return convertView;

    }
}
