package com.zeynep.myphone;

import static android.app.PendingIntent.getActivity;
import static android.content.Context.MODE_PRIVATE;

import static androidx.core.content.ContentProviderCompat.requireContext;
import static java.security.AccessController.getContext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class myreycadaptor extends RecyclerView.Adapter<myreycadaptor.Myholder> {
    private ArrayList<people> mylist;
    SQLiteDatabase db;

    public myreycadaptor(ArrayList<people> mylist) {
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_item, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, @SuppressLint("RecyclerView") int position) {
        people currentPerson = mylist.get(position);

        if (currentPerson != null) {
            holder.person_name.setText(currentPerson.getAd());
            holder.person_surname.setText(currentPerson.getSoyad());
            holder.person_number.setText(currentPerson.getNumara());
        } else {
            // Eğer currentPerson null ise, boş bir varsayılan değeri kullanabilirsiniz
            holder.person_name.setText("");
            holder.person_number.setText("");
        }


        // Sola kaydırma işlemi için tıklanma olayı dinleyicisi ekle
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPerson != null && currentPerson.isDeletable()) {
                    // Tıklanan pozisyondaki öğeyi sil
                    deleteItem(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public void deleteItem(int position) {
        people deletedPerson = mylist.get(position);
       // deletedPerson.setDeletable(true); // Silinecek kişiyi işaretle

        mylist.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mylist.size());


        // Veritabanından silme işlemini gerçekleştir
        if (deletedPerson != null&& db != null) {
            db.delete("person", "ad=?", new String[]{deletedPerson.getAd()});
        }
    }



    public class Myholder extends RecyclerView.ViewHolder {
        TextView person_name,person_surname, person_number;
        Button deleteButton;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            person_name = itemView.findViewById(R.id.addname);
            person_surname = itemView.findViewById(R.id.addsurname);
            person_number = itemView.findViewById(R.id.addnumber);
        }
    }
}
