package com.example.shauryatrivedi.naamkaran.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.shauryatrivedi.naamkaran.R;

public class GenderActivity extends AppCompatActivity {


    private ImageButton imgBtnMale, imgBtnFemale;
    private String relgn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        imgBtnMale=(ImageButton)findViewById(R.id.imgBtnMale);
        imgBtnFemale=(ImageButton)findViewById(R.id.imgBtnFemale);

        relgn = getIntent().getStringExtra("Religion");

        imgBtnMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GenderActivity.this,MainActivity.class);
                intent.putExtra("Gender","1");
                intent.putExtra("Religion",relgn);
                GenderActivity.this.startActivity(intent);
            }
        });

        imgBtnFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GenderActivity.this,MainActivity.class);
                intent.putExtra("Gender","2");
                intent.putExtra("Religion",relgn);
                GenderActivity.this.startActivity(intent);
            }
        });
    }
}
