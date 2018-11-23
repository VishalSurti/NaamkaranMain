package com.example.shauryatrivedi.naamkaran.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shauryatrivedi.naamkaran.R;

public class NameActivity extends AppCompatActivity {

    private String TAG = NameActivity.class.getSimpleName();
    String getName, getMeaning;
    TextView name,meaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        name = (TextView)findViewById(R.id.nmeVal);
        meaning = (TextView)findViewById(R.id.mngVal);

        getName = getIntent().getStringExtra("name");
        getMeaning = getIntent().getStringExtra("meaning");

        name.setText(getName);
        meaning.setText(getMeaning);
    }
}
