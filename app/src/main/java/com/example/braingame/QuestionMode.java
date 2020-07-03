package com.example.braingame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuestionMode extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_mode);
    }

    public void novicemode (View view){
        Intent intent=new Intent(this,Novice.class);
        startActivity(intent);
    }
    public void Easymode (View view){
        Intent intent=new Intent(this,Easy.class);
        startActivity(intent);
    }
    public void Mediummode (View view){
        Intent intent=new Intent(this,Medium.class);
        startActivity(intent);
    }
    public void Gurumode (View view){
        Intent intent=new Intent(this,Guru.class);
        startActivity(intent);
    }

}
