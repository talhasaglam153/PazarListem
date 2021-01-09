package com.pazar.listem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private Veritabani vt;
    private RecyclerView rv;
    private ListemAdapter adapter;
    private ArrayList<String> listem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        vt = new Veritabani(this);
        final String editTextGelenMetin = editText.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DataAccessObject().VeriEkle(vt, editText.getText().toString());
                listem = new DataAccessObject().VeriyiGoster(vt);
                adapter = new ListemAdapter(getApplicationContext(), listem);
                adapter.notifyDataSetChanged();
                rv.setAdapter(adapter);
            }
        });

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        listem = new DataAccessObject().VeriyiGoster(vt);
        adapter = new ListemAdapter(this, listem);
        rv.setAdapter(adapter);


    }
}