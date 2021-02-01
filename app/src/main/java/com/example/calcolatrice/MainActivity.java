package com.example.calcolatrice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int selezione;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSelectMode = (Button)findViewById(R.id.btnSelect);
        btnSelectMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selezionaModalita();
                }
        });

    }

    public void selezionaModalita() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("SELECT MODE:");
        String[] opzioni = {"Normal mode", "Converter"};
        builder.setItems(opzioni, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        NormalMode();
                        break;
                    case 1:
                        Converter();
                        break;
                }
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    public void NormalMode()
    {
       Intent i=new Intent(this, NormalMode.class);
       startActivity(i);
    }

    public void Converter()
    {
        Intent i=new Intent(this, Converter.class);
        startActivity(i);
    }
}