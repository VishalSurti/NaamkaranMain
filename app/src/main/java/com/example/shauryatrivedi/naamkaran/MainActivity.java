package com.example.shauryatrivedi.naamkaran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.shauryatrivedi.naamkaran.Retrofit.ApiClient;
import com.example.shauryatrivedi.naamkaran.Retrofit.GenderApi;
import com.example.shauryatrivedi.naamkaran.Retrofit.NameInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private String relgn, gender;
    private String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relgn = getIntent().getStringExtra("Religion");
        gender = getIntent().getStringExtra("Gender");


    }

    private void GetName() {
        NameInterface api= ApiClient.getClient().create(NameInterface.class);
        Call<List<GenderApi>> calll=api.get_Gender(relgn,gender);

        calll.enqueue(new Callback<List<GenderApi>>() {
            @Override
            public void onResponse(Call<List<GenderApi>> call, Response<List<GenderApi>> response) {





            }

            @Override
            public void onFailure(Call<List<GenderApi>> call, Throwable t) {

                Log.e(TAG, t.toString());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}