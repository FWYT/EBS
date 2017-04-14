package com.example.frances.ebs.tall;

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
 * Created by Frances on 3/21/2017.
 */

public class drinkcards extends AppCompatActivity {

    String[] allDrinks = {"ORGASM", "ALABAMA SLAMMER", "CAPTAIN ON ACID", "SCREAMING ORGASM", "RUSSIAN QUALUDE", "CALIFORNIA LEMONADE", "LONG ISLAND ICE TEA", "LONG BEACH ICE TEA", "ELECTRIC LEMONADE", "GRATEFUL DEAD",
            "NUCLEAR TEA", "ADIOS M.F."};

    Map<String, String> liquor = new HashMap<String, String>()
    {{
        put("orgasm", "1/2 oz Khalua & 1/2 oz Baileys & 1/2 oz Amaretto");
        put("alabama slammer", "1/2 oz Amaretto & 1/2 oz Southern Comfort & 1/2 oz Sloe Gin");
        put("captain on acid", "1/2 oz Captain Morgan & 1/2 Malibu Rum & 1/2 oz Blue Curacao");
        put("screaming orgasm", "1/2 oz Vodka & 1/2 oz Kahlua & 1/2 oz Baileys & 1/2 oz Amaretto");
        put("russian qualude", "1/2 oz Vodka & 1/2 oz Kahlua & 1/2 oz Baileys & 1/2 oz Frangelico");
        put("california lemonade", "1/2 oz Vodka & 1/2 oz Gin & 1/2 oz Rum & 1/2 oz Triple Sec");
        put("long island ice tea", "1/4 oz Vodka & 1/4 oz Gin & 1/4 oz Rum & 1/4 oz Tequila & 1/4 oz Triple Sec");
        put("long beach ice tea", "1/4 oz Vodka & 1/4 oz Gin & 1/4 oz Rum & 1/4 oz Tequila & 1/4 oz Triple Sec");
        put("electric lemonade", "1/4 oz Vodka & 1/4 oz Gin & 1/4 oz Rum & 1/4 oz Tequila & 1/4 oz Triple Sec");
        put("grateful dead", "1/4 oz Vodka & 1/4 oz Gin & 1/4 oz Rum & 1/4 oz Tequila & 1/4 oz Triple Sec & 1/2 oz Chambord");
        put("nuclear tea", "1/4 oz Vodka & 1/4 oz Gin & 1/4 oz Rum & 1/4 oz Tequila & 1/4 oz Triple Sec & 1/2 oz Midori or Melon");
        put("adios m.f.", "1/4 oz Vodka & 1/4 oz Gin & 1/4 oz Rum & 1/4 oz Tequila & 1/4 oz Triple Sec & 1/2 oz Blue Curacao");
    }};

    Map<String, String> mixer = new HashMap<String, String>()
    {{
        put("orgasm", "Cream");
        put("alabama slammer", "Orange Juice");
        put("captain on acid", "Pineapple Juice");
        put("screaming orgasm", "Cream");
        put("russian qualude", "Cream");
        put("california lemonade", "Sour Mix");
        put("long island ice tea", "Sour Mix");
        put("long beach ice tea", "Cranberry Juice");
        put("electric lemonade", "Sour Mix");
        put("grateful dead", "Sour Mix");
        put("nuclear tea", "Sour Mix");
        put("adios m.f.", "Sour Mix");
    }};

    Map<String, String> garnish = new HashMap<String, String>()
    {{
        put("orgasm", "None");
        put("alabama slammer", "None");
        put("captain on acid", "Splash Grenadine");
        put("screaming orgasm", "None");
        put("russian qualude", "None");
        put("california lemonade", "Splash Grenadine");
        put("long island ice tea", "Splash Coke");
        put("long beach ice tea", "Splash Sprite");
        put("electric lemonade", "Splash Sprite");
        put("grateful dead", "None");
        put("nuclear tea", "None");
        put("adios m.f.", "None");
    }};

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
