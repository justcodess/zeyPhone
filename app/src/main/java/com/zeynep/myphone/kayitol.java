package com.zeynep.myphone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class kayitol extends AppCompatActivity {

    //private AppBarConfiguration appBarConfiguration;
    //private ActivityMain3Binding binding;
    Button btndone,btncancel;
    EditText editad,editsoyad,editcompany,numaraekle,emailekle;
    SQLiteDatabase db;
    Intent intent;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayitol);

        btndone = findViewById(R.id.btndone);
        btncancel = findViewById(R.id.btncancel);
        editad = findViewById(R.id.editad);
        editsoyad = findViewById(R.id.editsoyad);
        editcompany = findViewById(R.id.editcompany);
        numaraekle = findViewById(R.id.numaraekle);
        emailekle = findViewById(R.id.emailekle);

        //bu eklendi
        numaraekle.setText(getIntent().getStringExtra("numara"));




        //SQL bağlama(tablo oluşturduk içindeki sutunları oluşturduk
        try {
            db = this.openOrCreateDatabase("login", MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS person(Id INTEGER PRIMARY KEY,ad VARCHAR,soyad VARCHAR,numara VARCHAR,email VARCHAR,company VARCHAR)");

        } catch (Exception e) {
            e.printStackTrace();

        }

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(kayitol.this, recentsFragment.class);
                startActivity(intent);
                finish();
            }
        });

        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ad = editad.getText().toString();
                String soyad = editsoyad.getText().toString();
                String numara = numaraekle.getText().toString();
                String company = editcompany.getText().toString();
                String email = emailekle.getText().toString();

                // Verileri veritabanına ekleme işlemi
                ContentValues values = new ContentValues();
                values.put("ad", ad);
                values.put("soyad", soyad);
                values.put("numara",numara);
                values.put("company", company);
                values.put("email", email);

                long result = db.insert("person", null, values);
                if (result != -1) {
                    Toast.makeText(kayitol.this, "Bilgiler kaydedildi.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(kayitol.this, "Bir hata oluştu. Bilgiler kaydedilemedi.", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(kayitol.this, contactsFragment.class);
                startActivity(intent);
                finish();
            }
        });
    }
    protected void onDestroy() {
        super.onDestroy();
        // Veritabanı bağlantısını kapatma
        if (db != null) {
            db.close();
        }
    }
    }
