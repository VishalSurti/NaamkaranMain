package com.example.shauryatrivedi.naamkaran.Activities;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shauryatrivedi.naamkaran.Adapters.NameListAdapter;
import com.example.shauryatrivedi.naamkaran.R;
import com.example.shauryatrivedi.naamkaran.Retrofit.ApiClient;
import com.example.shauryatrivedi.naamkaran.Retrofit.GenderApi;
import com.example.shauryatrivedi.naamkaran.Retrofit.NameInterface;
import com.example.shauryatrivedi.naamkaran.Retrofit.Pojo1;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String relgn, gender;
    NameListAdapter nameListAdapter;
    List<GenderApi> gndr;
    ListView listView;

    private String TAG = MainActivity.class.getSimpleName();
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.layout.activity_main);
        gender = getIntent().getStringExtra("Gender");
        relgn = getIntent().getStringExtra("Religion");
        GetName();
    }

    private void GetName() {
        NameInterface api= ApiClient.getClient().create(NameInterface.class);
        Call<Pojo1> calll=api.get_Gender(relgn,gender);

        calll.enqueue(new Callback<Pojo1>() {
            Throwable t;
            @Override
            public void onResponse(Call<Pojo1> call, Response<Pojo1> response) {
                Pojo1 genderlist=response.body();
//                if(genderlist!=null)
//                {
//                    Log.d(TAG,"Number of names recieved: "+ genderlist.size();
//                }
                gndr = genderlist.getGenderData();
                nameListAdapter = new NameListAdapter(MainActivity.this,gndr);
                listView.setAdapter(nameListAdapter);
                Toast.makeText(getApplicationContext(),"IN MAIN ACTIVITY",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Pojo1> call, Throwable t) {

                Log.e(TAG, t.toString());
                Toast.makeText(getApplicationContext(), "FAILED ACTIVITY", Toast.LENGTH_SHORT).show();
            }
        });
    }
}