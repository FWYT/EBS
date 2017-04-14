package com.example.frances.ebs.spirits;

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

/**
 * Created by Frances on 3/29/2017.
 */

public class spiritsList extends AppCompatActivity {

    String[] allDrinks = {"WHISKEY", "IRISH WHISKEY", "BOURBON", "SCOTCH", "GIN", "VODKA", "RUM", "TEQUILA", "BRANDY", "COGNAC", "WHITE WINE",
                          "RED WINE", "BlUSH", "APERITIFS", "CHAMPAGNE", "DESSERT WINES"};

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
                Intent i = new Intent(spiritsList.this, drinkcards.class);
                i.putExtra("drink", d.toLowerCase());
                spiritsList.this.startActivity(i);
            }
        });

    }

    public void drinkCard(View v)
    {
        Intent i = new Intent(spiritsList.this, drinkcards.class);
        i.putExtra("drink", allDrinks[0].toLowerCase());
        spiritsList.this.startActivity(i);
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
