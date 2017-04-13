package com.example.hansel.demo4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        preferences = getSharedPreferences("values",MODE_PRIVATE);
        final Ideas ideaList = new Ideas();
        ideaList.newIdea(new Idea("Milk", "Good for Bone"));
        ideaList.newIdea(new Idea("Sausage", "Not so healthy"));
        ideaList.newIdea(new Idea("Lemon", "Sour"));
        Map<String,?> keys = preferences.getAll();
        for(Map.Entry<String,?> entry : keys.entrySet()){
            ideaList.newIdea(new Idea(entry.getKey(),entry.getValue().toString()));
        }
        ArrayList<String> myArray = ideaList.getIdeas();
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myArray);
        ListView listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(myAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Index: "+ position );
                System.out.println("Item: "+ ideaList.getIdeaList().get(position).getIdea() );
                System.out.println("Desc: "+ ideaList.getIdeaList().get(position).getDesc() );
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        preferences.edit().clear().apply();
    }

    public void handler(View view){
        Intent intent = new Intent(this, ItemAdding.class);
        startActivity(intent);
    }

}
