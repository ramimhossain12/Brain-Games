package com.example.braingame;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ScoreFragment extends Fragment {

    public interface ScoreListener {

        public void MainMenu();

    }

    static final String Ext_Score = "com.example.brainapp.Ext_Score";
    static final String Ext_Length = "com.example.brainapp.Ext_length";
    static final String Ext_Time = "com.example.brainapp.Ext_time";
    ScoreListener listener;

    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            Activity activity = (Activity) context;
            listener = (ScoreListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + "must implement ScoreListener");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_score, container, false);
    }

    public void onStart() {
        super.onStart();

        Bundle ags = getArguments();
        int score = ags.getInt(Ext_Score, 0);
        int length = ags.getInt(Ext_Length, 10);
        String time = ags.getString(Ext_Time);

        View v = getView();
        TextView aScore = (TextView) v.findViewById(R.id.txtScore);
        aScore.setText(String.format("Score: %d/%d", score, length));
        TextView aTime = (TextView) v.findViewById(R.id.txtTimeTaken);
        aTime.setText(String.format("Time: %s", time));

        Button btnM = (Button) v.findViewById(R.id.MainMenubtn);
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.MainMenu();
            }
        });
    }
}
