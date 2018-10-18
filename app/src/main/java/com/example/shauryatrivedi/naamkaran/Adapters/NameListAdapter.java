package com.example.shauryatrivedi.naamkaran.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class NameListAdapter extends BaseAdapter {
    private Context context;
    LayoutInflater inflater;
    String[] name;
    String[] mean;
    public NameListAdapter(Context context, String[] name, String[] mean) {
        this.context = context;
        this.name = name;
        this.mean = mean;
        inflater=(LayoutInflater.from(context));
    }


    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int i) {
        return getItemId(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
