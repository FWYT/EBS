package com.example.frances.ebs.cordials;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.frances.ebs.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Frances on 4/10/2017.
 */

public class allDrinks extends AppCompatActivity {

    String[] allDrinks = {"AMARO MONTENEGRO", "AMARETTO", "ANISETTE", "B&B", "BAILEYS IRISH CREAM", "BENEDICTINE", "BLUE CURACAO", "CAMPARI", "CHAMBORD",
                          "CHARTREUSE", "CINNAMON SCHNAPPS", "COINTREAU", "CREME DE ALMOND", "CREME DE BANANA", "CREME DE MENTHE", "CREME DE CACAO",
                          "CREME DE CASSIS", "DRAMBUIE", "FRANGELICO", "GRAND MARNIER", "GALLIANO", "GOLDSCHLAGGER", "IRISH MIST", "JAGERMEISTER",
                          "KAHLUA", "KAMORA", "KAPALI", "METAXA", "MIDORI", "OUZO", "PEPPERMINT SCHNAPPS", "PEACH SCHNAPPS", "SAMBUCCA", "SLOE GIN",
                          "SOUTHERN COMFORT", "RUMPLEMINZ", "TIA MARIA", "TRIPLE SEC", "TUACCA", "YUKON JACK"};


    ListView drinkList;
    ArrayAdapter drinksAdapter;
    ArrayList<String> drinks = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alldrinksmenu);


        for (String s : allDrinks) {
            drinks.add(s);
        }

        drinkList = (ListView) findViewById(R.id.drinklist);
        drinksAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, drinks);
        drinkList.setAdapter(drinksAdapter);

        drinkList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String d = drinkList.getItemAtPosition(position).toString();
                Intent i = new Intent(allDrinks.this, drinkcards.class);
                i.putExtra("drink", d.toLowerCase());
                allDrinks.this.startActivity(i);
            }
        });

    }

    public void drinkCard(View v)
    {
        Intent i = new Intent(allDrinks.this, drinkcards.class);
        i.putExtra("drink", allDrinks[0].toLowerCase());
        allDrinks.this.startActivity(i);
    }

    public void search(View v)
    {
        EditText searchText = (EditText) findViewById(R.id.searchbox);
        String text = searchText.getText().toString();
        if (text.isEmpty())
        {
            drinks.clear();
            for (String s : allDrinks) {
                drinks.add(s);
            }
        }
        else
        {
            for (int i = drinks.size()-1; i>=0;i--)
            {
                String d = drinks.get(i);
                if (!d.toLowerCase().contains(text.toLowerCase()))
                {
                    drinks.remove(i);
                }
            }

        }
        drinksAdapter.notifyDataSetChanged();
    }
}
