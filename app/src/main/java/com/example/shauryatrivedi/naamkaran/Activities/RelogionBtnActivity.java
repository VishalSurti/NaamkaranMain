package com.example.shauryatrivedi.naamkaran.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.shauryatrivedi.naamkaran.R;

public class RelogionBtnActivity extends AppCompatActivity {

    private ImageButton imgBtnHindu, imgBtnMuslim, imgBtnChristian, imgBtnTrending;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relogion_btn);

        imgBtnHindu=(ImageButton)findViewById(R.id.imgBtnHind);
        imgBtnMuslim=(ImageButton)findViewById(R.id.imgBtnMusl);
        imgBtnChristian=(ImageButton)findViewById(R.id.imgBtnChrist);
        imgBtnTrending=(ImageButton)findViewById(R.id.imgBtnTrend);

        imgBtnHindu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RelogionBtnActivity.this, MainActivity.class);
                intent.putExtra("Religion","3");
                RelogionBtnActivity.this.startActivity(intent);
                Toast.makeText(RelogionBtnActivity.this,"Hindu",Toast.LENGTH_SHORT).show();
            }
        });

        imgBtnMuslim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RelogionBtnActivity.this,MainActivity.class);
                intent.putExtra("Religion","8");
                RelogionBtnActivity.this.startActivity(intent);
                Toast.makeText(RelogionBtnActivity.this,"Muslim",Toast.LENGTH_SHORT).show();
            }
        });

        imgBtnChristian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RelogionBtnActivity.this,MainActivity.class);
                intent.putExtra("Religion","10");
                RelogionBtnActivity.this.startActivity(intent);
                Toast.makeText(RelogionBtnActivity.this,"Christian",Toast.LENGTH_SHORT).show();
            }
        });

        imgBtnTrending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RelogionBtnActivity.this,MainActivity.class);
                intent.putExtra("Religion","7");
                RelogionBtnActivity.this.startActivity(intent);
                Toast.makeText(RelogionBtnActivity.this,"Trending",Toast.LENGTH_SHORT).show();
            }
        });

    }
}


