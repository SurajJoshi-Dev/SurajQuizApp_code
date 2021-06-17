package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;


import Modelspojo.Quizmodel;
import QuizAdapters.Quizadapter;

public class RecyclerMain extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_main);
        getSupportActionBar().hide();

        recyclerView=findViewById(R.id.Recycler_id);

        ArrayList<Quizmodel> list =new ArrayList<>();
        list.add(new Quizmodel(R.drawable.quizim,"Add Questions"));
        list.add(new Quizmodel(R.drawable.quizim,"All Questions"));
        list.add(new Quizmodel(R.drawable.quizim,"Test Settings"));
        list.add(new Quizmodel(R.drawable.quizim,"Create Test Section"));

        Quizadapter quizadapter=new Quizadapter(list,this);
        recyclerView.setAdapter(quizadapter);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

/*
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
            }     */
    }
}