package com.zeynep.myphone;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.ArrayList;


public class keypadFragment extends Fragment {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    TextView resultText;
    EditText editTextPhone;
    ArrayList<String> numbersList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_keypad, container, false);


        numbersList = new ArrayList<>(); // Liste nesnesini oluşturun
        //add number yazını tanımladım
        TextView addnumber = rootView.findViewById(R.id.myTextView);

        addnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextPhone = rootView.findViewById(R.id.editTextPhone); // EditText'inizin doğru kimliğini (id) kullanarak bulunması


                // Tıklanabilir metne tıklandığında yapılacak işlemler buraya yazılır
                Intent intent = new Intent(getActivity(), kayitol.class);
                intent.putExtra("numara", editTextPhone.getText().toString());
                startActivity(intent);


            }
        });
        ImageButton btnon = rootView.findViewById(R.id.ara);
        btnon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = resultText.getText().toString(); // resultText TextView'indeki numarayı alın
                numbersList.add(number); // Numarayı listeye ekleyin


                Toast.makeText(getActivity(), "ARAMA YAPILIYOR.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), callscreen.class);
                intent.putExtra("intentNumara", resultText.getText().toString());
                startActivity(intent);
            }


        });



        return rootView;


    }
    public interface OnNumberEnteredListener {
        void onNumberEntered(String number);
    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn0 = view.findViewById(R.id.button0);
        btn1 = view.findViewById(R.id.button1);
        btn2 = view.findViewById(R.id.button2);
        btn3 = view.findViewById(R.id.button3);
        btn4 = view.findViewById(R.id.button4);
        btn5 = view.findViewById(R.id.button5);
        btn6 = view.findViewById(R.id.button6);
        btn7 = view.findViewById(R.id.button7);
        btn8 = view.findViewById(R.id.button8);
        btn9 = view.findViewById(R.id.button9);
        resultText = view.findViewById(R.id.editTextPhone);

        //butonlara tıklandığında ekranda numara çıkar
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiClick('0');
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiClick('1');
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiClick('2');
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiClick('3');
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiClick('4');
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiClick('5');
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiClick('6');
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiClick('7');
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiClick('8');
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayiClick('9');
            }
        });


    }


    public void sayiClick(char sayi){

        if(resultText.getText().toString() == "0"){
            resultText.setText("");
        }

        resultText.setText(resultText.getText() + String.valueOf(sayi));

    };
}