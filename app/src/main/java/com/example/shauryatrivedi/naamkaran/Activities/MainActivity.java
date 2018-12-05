package com.example.shauryatrivedi.naamkaran.Activities;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shauryatrivedi.naamkaran.Adapters.NameListAdapter;
import com.example.shauryatrivedi.naamkaran.R;
import com.example.shauryatrivedi.naamkaran.Retrofit.ApiClient;
import com.example.shauryatrivedi.naamkaran.Retrofit.GenderApi;
import com.example.shauryatrivedi.naamkaran.Retrofit.NameInterface;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private String relgn, gender;
    private String tempStr1,tempStr2;
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
        relgn = getIntent().getStringExtra("Religion");
        gender =  getIntent().getStringExtra("Gender");
        Toast.makeText(MainActivity.this,"Gender is "+gender+" and Religion is "+relgn,Toast.LENGTH_SHORT).show();

//        int tempRl = Integer.parseInt(relgn);
//        int tempGn = Integer.parseInt(gender);
//        Toast.makeText(MainActivity.this,"TempRel is "+tempRl+" and TempGen is "+tempGn,Toast.LENGTH_SHORT).show();
        ActionBar();
        GetName(relgn, gender);
    }

    private void ActionBar(){
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.layout_actionbar);

        View view = getSupportActionBar().getCustomView();
        autoCom = (AutoCompleteTextView)findViewById(R.id.atoComTxtVw);

        ImageButton next = (ImageButton)findViewById(R.id.actnBr_fwd);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                int nexRl = Integer.parseInt(relgn);
                int nexGn = Integer.parseInt(gender);
                nexRl = 8;
                nexGn = 2;
                tempStr1 = Integer.toString(nexRl);
                tempStr2 = Integer.toString(nexGn);
                GetName(tempStr1, tempStr2);
                Toast.makeText(MainActivity.this,"NextRel is "+tempStr1+" and NextGen is "+tempStr2, Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton prev = (ImageButton)findViewById(R.id.actnBr_back);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int prvRl = Integer.parseInt(relgn);
                int prvGn = Integer.parseInt(gender);
                prvRl = 3;
                prvGn = 2;
                tempStr1 = Integer.toString(prvRl);
                tempStr2 = Integer.toString(prvGn);
                GetName(tempStr1, tempStr2);
                Toast.makeText(MainActivity.this,"PrevRel is "+tempStr1+" and PrevGen is "+tempStr2, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void GetName(String rl, String gn) {
        this.relgn = rl;
        this.gender = gn;

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
