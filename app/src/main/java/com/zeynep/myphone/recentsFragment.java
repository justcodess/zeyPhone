package com.zeynep.myphone;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class recentsFragment extends Fragment {

    private RecyclerView benimrecyc;
    TextView plus;
    private ArrayList<people> mylist;
    private myreycadaptor myadaptor;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);
        super.onCreate((savedInstanceState));

        plus = view.findViewById(R.id.plus); // Doğru id'yi kullanarak plus TextView nesnesini bulun
        benimrecyc = view.findViewById(R.id.mylist);
        mylist = new ArrayList<>();
        myadaptor = new myreycadaptor(mylist);
        benimrecyc.setAdapter(myadaptor);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        benimrecyc.setLayoutManager(layoutManager); // LayoutManager'ı RecyclerView'a ekledik

        myadaptor.notifyDataSetChanged();


        plus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), kayitol.class);
                startActivity(intent);


            }
        });
        // MainActivity'den gelen verileri al

        Bundle bundle = getActivity().getIntent().getExtras();
        if (bundle != null) {
            String numara = bundle.getString("intentNumara");

        }
        numbersList(); // numbersList metodunu çağırın
        return view;
    }
    private void numbersList() {
        SQLiteDatabase db = getActivity().openOrCreateDatabase("login", MODE_PRIVATE, null);
        Cursor cursor = db.rawQuery("SELECT * FROM person", null);

        // Verileri mylist listesine ekle
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String numara = cursor.getString(cursor.getColumnIndex("numara"));
                mylist.add(new people(numara));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        myadaptor.notifyDataSetChanged();
    }

}