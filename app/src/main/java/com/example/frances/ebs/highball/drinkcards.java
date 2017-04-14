package com.example.frances.ebs.highball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.frances.ebs.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Frances on 2/26/2017.
 */

public class drinkcards extends AppCompatActivity {

    Map<String, String> liquor = new HashMap<String, String>()
    {{
        put("screwdriver", "1 oz Vodka");
        put("cape codder", "1 oz Vodka");
        put("sea breeze", "1 oz Vodka");
        put("bay breeze", "1 oz Vodka");
        put("madras", "1 oz Vodka");
        put("greyhound", "1 oz Vodka");
        put("salty dog", "1 oz Vodka");
        put("sombrero", "1 oz Coffee Flavored Brandy");
        put("highball", "1 oz Whiskey");
        put("whiskey sour", "1 oz Whiskey");
        put("fuzzy navel", "1 oz Peach Schnapps");
        put("cuba libre", "1 oz Rum");
        put("tom collins", "1 oz Gin");
        put("sloe gin fizz", "1 oz Sloe Gin");
        put("bacardi cocktail", "1 oz Bacardi");
        put("tequila sunrise", "1 oz Tequila");
        put("woo woo", "1/2 oz Vodka & 1/2 oz Peach Schnapps");
        put("sex on the beach", "1/2 oz Vodka & 1/2 oz Peach Schnapps");
        put("pearl harbor", "1/2 oz Vodka & 1/2 oz Melon Liqueur");
        put("water-melon", "1/2 oz Vodka & 1/2 oz Melon Liqueur");
        put("white russian", "1/2 oz Vodka & 1/2 oz Kahlua");
        put("toasted almond", "1/2 oz Amaretto & 1/2 oz Kahlua");
        put("grape crush", "1/2 oz Vodka & 1/2 oz Chambord");
        put("red-headed slut", "1/2 oz Jagermeister & 1/2 oz Peach Schnapps");
        put("washington apple", "1/2 oz Crown Royal & 1/2 oz Apple Pucker");
    }};

    Map<String, String> mixer = new HashMap<String, String>()
    {{
        put("screwdriver", "Orange Juice");
        put("cape codder", "Cranberry Juice");
        put("sea breeze", "50/50 Cranberry & Grapefruit Juice");
        put("bay breeze", "50/50 Cranberry & Pineapple Juice");
        put("madras", "50/50 Orange & Cranberry Juice");
        put("greyhound", "Grapefruit Juice");
        put("salty dog", "Grapefruit Juice");
        put("sombrero", "Cream or Milk");
        put("highball", "Ginger Ale");
        put("whiskey sour", "Sour Mix");
        put("fuzzy navel", "Orange Juice");
        put("cuba libre", "Coke");
        put("tom collins", "Sour Mix");
        put("sloe gin fizz", "Sour Mix");
        put("bacardi cocktail", "Sour Mix");
        put("tequila sunrise", "Orange Juice");
        put("woo woo", "Cranberry Juice");
        put("sex on the beach", "50/50 Orange & Cranberry Juice");
        put("pearl harbor", "Pineapple Juice");
        put("water-melon", "Cranberry Juice");
        put("white russian", "Cream");
        put("toasted almond", "Cream");
        put("grape crush", "Sour Mix");
        put("red-headed slut", "Cranberry Juice");
        put("washington apple", "Cranberry Juice");
    }};

    Map<String, String> garnish = new HashMap<String, String>()
    {{
        put("screwdriver", "None");
        put("cape codder", "None");
        put("sea breeze", "None");
        put("bay breeze", "None");
        put("madras", "None");
        put("greyhound", "None");
        put("salty dog", "Salt rim of the glass");
        put("sombrero", "None");
        put("highball", "None");
        put("whiskey sour", "None");
        put("fuzzy navel", "None");
        put("cuba libre", "Lime");
        put("tom collins", "Splash of Soda");
        put("sloe gin fizz", "Splash of Soda");
        put("bacardi cocktail", "Lace grenadine");
        put("tequila sunrise", "Lace grenadine");
        put("woo woo", "None");
        put("sex on the beach", "None");
        put("pearl harbor", "None");
        put("water-melon", "None");
        put("white russian", "None");
        put("toasted almond", "None");
        put("grape crush", "None");
        put("red-headed slut", "None");
        put("washington apple", "None");
    }};

    String[] allDrinks = {"SCREWDRIVER", "CAPE CODDER", "SEA BREEZE", "BAY BREEZE", "MADRAS", "GREYHOUND", "SALTY DOG", "SOMBRERO", "HIGHBALL", "WHISKEY SOUR", "FUZZY NAVEL", "CUBA LIBRE", "TOM COLLINS", "SLOE GIN FIZZ",
            "BACARDI COCKTAIL", "TEQUILA SUNRISE", "WOO WOO", "SEX ON THE BEACH", "PEARL HARBOR", "WATER-MELON", "WHITE RUSSIAN", "TOASTED ALMOND", "GRAPE CRUSH", "RED-HEADED SLUT",
            "WASHINGTON APPLE"};

    String drink;

    TextView nameText;
    TextView liquorText;
    TextView mixerText;
    TextView garnishText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drinkcard);

        Intent prevIntent = getIntent();
        drink = prevIntent.getStringExtra("drink");

        nameText = (TextView) findViewById(R.id.drinkName);
        liquorText = (TextView) findViewById(R.id.liquor);
        mixerText = (TextView) findViewById(R.id.mixer);
        garnishText = (TextView) findViewById(R.id.garnish);

        setCard();
    }

    private void setCard()
    {
        nameText.setText(drink.toUpperCase());
        liquorText.setText(liquor.get(drink));
        mixerText.setText(mixer.get(drink));
        garnishText.setText(garnish.get(drink));
    }


    public void right(View view)
    {
        int i = Arrays.asList(allDrinks).indexOf(drink.toUpperCase());
        Log.e("DRINK INDEX", Integer.toString(i)+"\n\n\n\n");
        if (i == allDrinks.length-1)
        {
            i=0;
        }
        else
        {
            i+=1;
        }
        drink = allDrinks[i].toLowerCase();
        setCard();
    }

    public void left(View view)
    {
        int i = Arrays.asList(allDrinks).indexOf(drink.toUpperCase());
        if (i == 0)
        {
            i=allDrinks.length-1;
        }
        else
        {
            i-=1;
        }
        drink = allDrinks[i].toLowerCase();
        setCard();
    }
}
