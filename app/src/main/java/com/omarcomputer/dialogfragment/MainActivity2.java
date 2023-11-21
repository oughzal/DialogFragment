package com.omarcomputer.dialogfragment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;

import com.omarcomputer.dialogfragment.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnShowAlert.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Alert");
            builder.setIcon(R.drawable.ic_alarm);
            builder.setMessage("Message");
            builder.setPositiveButton("OUI", (dialogInterface, i) -> {
                // code si l'utilisateur choisi OUI
            });
            builder.setNegativeButton("NON", (dialog, i) -> {
                // code si l'utilisateur choisi NON
            });
            builder.setNeutralButton("Annuler", (dialog, i) -> {

            });
            builder.show();
        });
        binding.btnDate.setOnClickListener(v -> {
            int yy,mm,dd;
            String date = binding.dateText.getText().toString();
            String[] parts = date.split("/");
            dd = Integer.parseInt(parts[0]);
            mm = Integer.parseInt(parts[1])-1;
            yy = Integer.parseInt(parts[2]);
            DatePickerDialog datePicker = new DatePickerDialog(this, (datePicker1, y, m, d) -> {
                // code après le choix d'une date
                binding.dateText.setText(""+d+"/"+(m+1)+"/"+y);
            }, yy, mm, dd);
            datePicker.show();
        });
    }
}