package com.example.shauryatrivedi.naamkaran.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.shauryatrivedi.naamkaran.R;
import com.example.shauryatrivedi.naamkaran.Retrofit.GenderApi;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

public class NameListAdapter extends BaseAdapter implements SectionIndexer {
    private Context context;
    private LayoutInflater inflater;
    private List<GenderApi> list;
    private HashMap<String, Integer> alphaIndexer;
    private String[] sections;

    public NameListAdapter(Context context, List<GenderApi> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return list.size();
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
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view = inflater.inflate(R.layout.name_list,null);
        TextView txtname = (TextView) view.findViewById(R.id.txtname);
        GenderApi info = list.get(i);
        String nam = info.getName();
        txtname.setText(nam);
        return view;
    }

    @Override
    public Object[] getSections() {
        return sections;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return 0;
    }

    @Override
    public int getSectionForPosition(int position) {
        return alphaIndexer.get(sections[position]);
    }
}
