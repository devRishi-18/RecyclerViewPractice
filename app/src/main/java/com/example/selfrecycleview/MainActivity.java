package com.example.selfrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.selfrecycleview.Adapters.FootballAdapter;
import com.example.selfrecycleview.Classes.RecyclerItemClickListener;
import com.example.selfrecycleview.Models.FootballModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        recyclerView= findViewById(R.id.recyclerview);

        ArrayList<FootballModel> list = new ArrayList<>();
        list.add(new FootballModel(R.drawable.chhetri,"SUNIL CHHETRI"));
        list.add(new FootballModel(R.drawable.anirudh,"ANIRUDH THAPA"));
        list.add(new FootballModel(R.drawable.brandon,"BRANDON FERNENDES"));
        list.add(new FootballModel(R.drawable.chhangte,"LALIANZUALA CHHANGTE"));
        list.add(new FootballModel(R.drawable.sahal,"SAHAL ABDUL SAMAD"));
        list.add(new FootballModel(R.drawable.edwin,"EDWIN VANSPAUL"));
        list.add(new FootballModel(R.drawable.aman,"AMAN CHHETRI"));

        FootballAdapter adapter = new FootballAdapter(list,this);
        recyclerView.setAdapter(adapter);

        StaggeredGridLayoutManager staggeredGridLayoutManager= new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

//        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,2);
//        recyclerView.setLayoutManager(gridLayoutManager);

//        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener
                (this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                    switch(position){
                        case 0:
                            Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                            startActivity(intent);
                            break;
                        case 1:
                            Toast.makeText(MainActivity.this, "Second item is clicked", Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            Toast.makeText(MainActivity.this, "Third item", Toast.LENGTH_SHORT).show();

                        default:
                    }
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        switch(position){
                            case 0:
//                                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
//                                startActivity(intent);
                                Toast.makeText(MainActivity.this, "first item", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(MainActivity.this, "Second item is clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(MainActivity.this, "Third item", Toast.LENGTH_SHORT).show();

                            default:
                        }
                    }
                }

                ));

//        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, true);
//        recyclerView.setLayoutManager(layoutManager);

    }
}