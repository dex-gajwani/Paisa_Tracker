package com.example.paisatracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class pass_book extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<data_list> userlist;
    Adapter adapter;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_book);
        userlist = new ArrayList<>();
        while(i < data_storage.amount.size())
            userlist.add(new data_list(data_storage.amount.get(i++), data_storage.comment.get(i++)));
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(userlist);
        recyclerView.setAdapter((RecyclerView.Adapter) adapter);
    }
}