package com.example.lab08.listview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView liste;
    String [] dizi  = {"istanbul","ankara","izmir","giresun","edirne","sivas","antalya","adana"};
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liste = findViewById(R.id.listee);
        textView = findViewById(R.id.textView);

        ArrayAdapter<String> listeAdapter = new ArrayAdapter<String>(this,R.layout.item,R.id.textView,dizi);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder pencere = new AlertDialog.Builder(MainActivity.this);
                pencere.setTitle("uyarı");
                pencere.setMessage("Bu numarayı aramak istediğinize emin misiniz ? ");

                pencere.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, dizi[position]+" adlı kişinin numarası aranıyor", Toast.LENGTH_SHORT).show();
                    }
                });
                pencere.setNegativeButton("İPTAL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "iptal edildi", Toast.LENGTH_SHORT).show();
                    }
                });

                pencere.show();

            }
        });

        liste.setAdapter(listeAdapter);


    }
}
