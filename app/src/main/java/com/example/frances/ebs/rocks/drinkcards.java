package com.example.frances.ebs.rocks;

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

    String[] allDrinks = {"BOURBON ON THE ROCKS", "SCOTCH ON THE ROCKS", "TOP SHELF SCOTCH ON THE ROCKS", "BLACK RUSSIAN", "SICILIAN KISS",
            "GOD MOTHER", "GOD FATHER", "RUSTY NAIL", "NUTTY IRISHMAN", "STINGER", "KAMIKAZE", "PURPLE HOOTER", "WINDEX",
            "RASPBERRY KAMIKAZE", "MUDSLIDE", "AFTER FIVE", "B~51", "B~52", "B~53", "OATMEAL COOKIE"};

    Map<String, String> liquor = new HashMap<String, String>()
    {{
        put("bourbon on the rocks", "1 1/2 oz Bourbon Whiskey");
        put("scotch on the rocks", "1 1/2 oz Scotch Whiskey");
        put("top shelf scotch on the rocks", "1 1/2 oz Scotch Whiskey");
        put("black russian", "1 1/4 oz Vodka & 3/4 oz Kahlua");
        put("sicilian kiss", "1 1/4 oz Southern Comfort & 3/4 oz Amaretto");
        put("god mother", "1 1/4 oz Vodka & 3/4 oz Amaretto");
        put("god father", "1 1/4 oz Scotch & 3/4 oz Amaretto");
        put("rusty nail", "1 1/4 oz Scotch & 3/4 oz Drambuie");
        put("Nutty Irishman", "1 1/4 oz Baileys & 3/4 oz Frangelico");
        put("stinger", "1 1/4 oz Brandy & 3/4 oz White Creme De Menthe");
        put("kamikaze", "1 1/4 oz Vodka & 3/4 oz Triple Sec");
        put("purple hooter", "1 1/4 oz Vodka & 3/4 oz Chambord");
        put("windex", "1 1/4 oz Vodka & 3/4 oz Blue Curacao");
        put("raspberry kamikaze", "1 1/4 oz Raspberry Vodka & 3/4 oz Triple Sec");
        put("mudslide", "1/2 oz Kahlua & 1/2 oz Baileys & 1/2 oz Vodka");
        put("after five", "1/2 oz Kahlua & 1/2 oz Baileys & 1/2 oz Peppermint Schnapps");
        put("b~51", "1/2 oz Kahlua & 1/2 oz Baileys & 1/2 oz Frangelico");
        put("b~52", "1/2 oz Kahlua & 1/2 oz Baileys & 1/2 oz Grand Marnier");
        put("b~53", "1/2 oz Kahlua & 1/2 oz Baileys & 1/2 oz Amaretto");
        put("oatmeal cookie", "1/2 oz Kahlua & 1/2 oz Baileys & 1/2 oz Goldschlager");
    }};

    Map<String, String> mixer = new HashMap<String, String>()
    {{
        put("bourbon on the rocks", "");
        put("scotch on the rocks", "");
        put("top shelf scotch on the rocks", "");
        put("black russian", "");
        put("sicilian kiss", "");
        put("god mother", "");
        put("god father", "");
        put("rusty nail", "");
        put("Nutty Irishman", "");
        put("stinger", "");
        put("kamikaze", "");
        put("purple hooter", "");
        put("windex", "");
        put("raspberry kamikaze", "");
        put("mudslide", "");
        put("after five", "");
        put("b~51", "");
        put("b~52", "");
        put("b~53", "");
        put("oatmeal cookie", "");
    }};

    Map<String, String> garnish = new HashMap<String, String>()
    {{
        put("bourbon on the rocks", "None");
        put("scotch on the rocks", "None");
        put("top shelf scotch on the rocks", "None");
        put("black russian", "None");
        put("sicilian kiss", "None");
        put("god mother", "None");
        put("god father", "None");
        put("rusty nail", "Lemon Twist");
        put("Nutty Irishman", "None");
        put("stinger", "Mint Leaf");
        put("kamikaze", "Splash Lime Juice");
        put("purple hooter", "Splash Lime Juice");
        put("windex", "Splash Lime Juice");
        put("raspberry kamikaze", "Splash Lime Juice");
        put("mudslide", "None");
        put("after five", "None");
        put("b~51", "None");
        put("b~52", "None");
        put("b~53", "None");
        put("oatmeal cookie", "None");
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
