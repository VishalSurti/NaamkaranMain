package com.example.shauryatrivedi.naamkaran.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.shauryatrivedi.naamkaran.R;

public class GenderActivity extends AppCompatActivity {


    private ImageButton imgBtnMale, imgBtnFemale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        imgBtnMale=(ImageButton)findViewById(R.id.imgBtnMale);
        imgBtnFemale=(ImageButton)findViewById(R.id.imgBtnFemale);

        imgBtnMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GenderActivity.this,RelogionBtnActivity.class);
                intent.putExtra("Gender","1");
                GenderActivity.this.startActivity(intent);
            }
        });

        imgBtnFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GenderActivity.this,RelogionBtnActivity.class);
                intent.putExtra("Gender","2");
                GenderActivity.this.startActivity(intent);
            }
        });
    }
}
