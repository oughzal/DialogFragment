package com.omarcomputer.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity2 extends AppCompatActivity {
    FrameLayout fragments;
    Button btnFragmentA, btnFragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fragments = findViewById(R.id.fragments);
        btnFragmentA = findViewById(R.id.btnFragmentA);
        btnFragmentB = findViewById(R.id.btnFragmentB);
        btnFragmentA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragments,new FragmentA()).commit();
            }
        });
btnFragmentB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.fragments,new FragmentB())
                        .addToBackStack(null)
                        .commit();
            }
        });


    }
}