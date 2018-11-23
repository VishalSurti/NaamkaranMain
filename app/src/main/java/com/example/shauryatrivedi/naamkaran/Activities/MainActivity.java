package com.example.shauryatrivedi.naamkaran.Activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    List<GenderApi> nameList;
    ListView listView;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listVw);
        gender =  getIntent().getStringExtra("Gender");
        relgn = getIntent().getStringExtra("Religion");
        Toast.makeText(MainActivity.this,"Gender is "+gender+" and Religion is "+relgn,Toast.LENGTH_SHORT).show();
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
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent int1 = new Intent(MainActivity.this,NameActivity.class);
                        int1.putExtra("name",nameList.get(position).getName());
                        int1.putExtra("meaning",nameList.get(position).getMeaning());
                        startActivity(int1);
                    }
                });
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
