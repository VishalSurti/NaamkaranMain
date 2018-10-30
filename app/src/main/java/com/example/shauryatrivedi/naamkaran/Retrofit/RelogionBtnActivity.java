package com.example.shauryatrivedi.naamkaran.Retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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
                Intent intent=new Intent(RelogionBtnActivity.this,GenderActivity.class);
                intent.putExtra("Religion","3");
                RelogionBtnActivity.this.startActivity(intent);
            }
        });

        imgBtnMuslim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RelogionBtnActivity.this,GenderActivity.class);
                intent.putExtra("Religion","8");
                RelogionBtnActivity.this.startActivity(intent);
            }
        });

        imgBtnChristian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RelogionBtnActivity.this,GenderActivity.class);
                intent.putExtra("Religion","10");
                RelogionBtnActivity.this.startActivity(intent);
            }
        });

        imgBtnTrending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RelogionBtnActivity.this,GenderActivity.class);
                intent.putExtra("Religion","7");
                RelogionBtnActivity.this.startActivity(intent);
            }
        });

    }
}


//    private ImageButton imgBtnMle, imgBtnFmle;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_parsing);
//
//        imgBtnMle = (ImageButton)findViewById(R.id.imgBtnMale);
//        imgBtnFmle = (ImageButton)findViewById(R.id.imgBtnFemale);
//
//        imgBtnMle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent int1 = new Intent(ParsingActivity.this, ParsingRetrofitActivity.class);
//                int1.putExtra("Gender", "m");
//                ParsingActivity.this.startActivity(int1);
//            }
//        });
//
//        imgBtnFmle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent int2 = new Intent (ParsingActivity.this, ParsingRetrofitActivity.class);
//                int2.putExtra("Gender", "f");
//                ParsingActivity.this.startActivity(int2);
//            }
//        });
//    }
//}