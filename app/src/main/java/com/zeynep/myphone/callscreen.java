package com.zeynep.myphone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class callscreen extends AppCompatActivity {
    ImageButton btnoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callscreen);

        TextView txtshow =findViewById(R.id.txtshow);

        Intent intent = getIntent();
        String numara = intent.getStringExtra("intentNumara");
        String text =   numara ;

        txtshow.setText(text);


        btnoff=findViewById(R.id.kapat);
        btnoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(callscreen.this, "ARAMA SONLANDIRILDI", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(callscreen.this, keypadFragment.class);
                startActivity(intent);
                finish();
            }
        });


    }
}