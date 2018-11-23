package com.example.shauryatrivedi.naamkaran.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.shauryatrivedi.naamkaran.R;

public class ReligionBtnActivity extends AppCompatActivity {

    private ImageButton imgBtnHindu, imgBtnMuslim, imgBtnChristian, imgBtnTrending;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_religion_btn);

        imgBtnHindu=(ImageButton)findViewById(R.id.imgBtnHind);
        imgBtnMuslim=(ImageButton)findViewById(R.id.imgBtnMusl);
        imgBtnChristian=(ImageButton)findViewById(R.id.imgBtnChrist);
        imgBtnTrending=(ImageButton)findViewById(R.id.imgBtnTrend);

        imgBtnHindu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ReligionBtnActivity.this, GenderActivity.class);
                intent.putExtra("Religion","3");
                ReligionBtnActivity.this.startActivity(intent);
                Toast.makeText(ReligionBtnActivity.this,"Hindu",Toast.LENGTH_SHORT).show();
            }
        });

        imgBtnMuslim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ReligionBtnActivity.this,GenderActivity.class);
                intent.putExtra("Religion","8");
                ReligionBtnActivity.this.startActivity(intent);
                Toast.makeText(ReligionBtnActivity.this,"Muslim",Toast.LENGTH_SHORT).show();
            }
        });

        imgBtnChristian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ReligionBtnActivity.this,GenderActivity.class);
                intent.putExtra("Religion","10");
                ReligionBtnActivity.this.startActivity(intent);
                Toast.makeText(ReligionBtnActivity.this,"Christian",Toast.LENGTH_SHORT).show();
            }
        });

        imgBtnTrending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ReligionBtnActivity.this,GenderActivity.class);
                intent.putExtra("Religion","7");
                ReligionBtnActivity.this.startActivity(intent);
                Toast.makeText(ReligionBtnActivity.this,"Trending",Toast.LENGTH_SHORT).show();
            }
        });

    }
}


