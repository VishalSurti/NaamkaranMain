package com.example.shauryatrivedi.naamkaran.Activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shauryatrivedi.naamkaran.Adapters.NameListAdapter;
import com.example.shauryatrivedi.naamkaran.R;
import com.example.shauryatrivedi.naamkaran.Retrofit.ApiClient;
import com.example.shauryatrivedi.naamkaran.Retrofit.GenderApi;
import com.example.shauryatrivedi.naamkaran.Retrofit.NameInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private String relgn, gender;
    private NameListAdapter nameListAdapter;
    private List<GenderApi> nameList;
    private ListView listView;
    private AutoCompleteTextView autoCom;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listVw);
        gender =  getIntent().getStringExtra("Gender");
        relgn = getIntent().getStringExtra("Religion");
        autoCom = (AutoCompleteTextView)findViewById(R.id.atoComTxtVw);
        Toast.makeText(MainActivity.this,"Gender is "+gender+" and Religion is "+relgn,Toast.LENGTH_SHORT).show();

        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.layout_actionbar);

        View view = getSupportActionBar().getCustomView();

        ImageButton next = (ImageButton)findViewById(R.id.actnBr_fwd);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Next", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton prev = (ImageButton)findViewById(R.id.actnBr_back);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Previous", Toast.LENGTH_SHORT).show();
            }
        });

        GetName();
    }

    private void GetName() {
        NameInterface api = ApiClient.getClient().create(NameInterface.class);
        Call<List<GenderApi>> call = api.get_Gender(relgn, gender);

        call.enqueue(new Callback<List<GenderApi>>() {
            @Override
            public void onResponse(Call<List<GenderApi>> call, Response<List<GenderApi>> response) {
                nameList = response.body();
                String[] names = new String[nameList.size()];
                for (int i = 0; i<nameList.size(); i++){
                    names[i] = nameList.get(i).getName();
                }
                nameListAdapter = new NameListAdapter(MainActivity.this,nameList);
                listView.setAdapter(nameListAdapter);

//                String[] strList = nameList.toArray(new String [nameList.size()]);
//
//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.select_dialog_item, strList);
//                autoCom.setThreshold(5);
//                autoCom.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<GenderApi>> call, Throwable t) {
                if (t instanceof IOException){
                    Toast.makeText(MainActivity.this, "Network Issue", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, t.toString());
                }else {
                    Toast.makeText(MainActivity.this, "Conversion Issue", Toast.LENGTH_SHORT).show();
                }
            }
        });
        }
    }
