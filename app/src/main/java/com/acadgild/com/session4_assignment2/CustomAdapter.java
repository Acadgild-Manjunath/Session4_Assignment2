package com.acadgild.com.session4_assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Valyoo on 12/20/2016.
 */
public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<CustomHandler> arrayList;
    LayoutInflater layoutInflater;
    public CustomAdapter(Context context1, ArrayList<CustomHandler> arrayList1){
        this.context = context1;
        this.arrayList = arrayList1;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null)
        {
            view = layoutInflater.inflate(R.layout.custom_row, viewGroup, false);
            holder = new ViewHolder();
            holder.txtName = (TextView) view.findViewById(R.id.txtName);
            holder.txtNumber = (TextView) view.findViewById(R.id.txtNumber);

            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)view.getTag();
        }

        holder.txtName.setText(arrayList.get(pos).getPersonName());
        holder.txtNumber.setText(arrayList.get(pos).getPhoneNumber());
        return view;
    }

    public class ViewHolder{
        TextView txtName;
        TextView txtNumber;
    }
}
