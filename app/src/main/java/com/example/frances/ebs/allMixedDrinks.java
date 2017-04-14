package com.example.frances.ebs;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Frances on 4/11/2017.
 */

public class allMixedDrinks extends AppCompatActivity {

    String[] allDrinks = {"MARGARITA", "BLUE MARGARITA", "GOLD MARGARITA", "GRAND GOLD MARGARITA", "CADILAC MARGARITA", "MARTINI", "VODKA MARTINI", "DRY MARTINI", "BONE DRY MARTINI", "GIBSON", "GIMLET", "DIRTY MARTINI",
            "MANHATTAN", "PERFECT MANHATTAN", "DRY MANHATTAN", "ROB ROY", "BASIC COSMOPOLITAN", "TOP SHELF COSMOPOLITAN", "APPLE MARTINI", "BASIC ESPRESSO MARTINI", "SIDECAR", "NEGRONI", "OLD FASHIONED", "MOJITO",
            "MINT JULIP", "MOSCOW MULE", "HOT TODDY", "IRISH COFFEE", "KAMIKAZE(SHOOTER)", "WINDEX(SHOOTER)", "CHOCOLATE CAKE", "LEMON DROP", "CAPTAIN ON ACID(SHOOTER)", "APPLE SAUCE", "WASHINGTON APPLE(SHOOTER)",
            "RED HEADED SLUT(SHOOTER)", "MIND ERASER", "ZIPPER HEAD", "SPRITZERS", "MIMOSA", "BELLINI", "KIR ROYAL", "SCREWDRIVER", "CAPE CODDER", "SEA BREEZE", "BAY BREEZE", "MADRAS", "GREYHOUND", "SALTY DOG", "SOMBRERO", "HIGHBALL", "WHISKEY SOUR", "FUZZY NAVEL", "CUBA LIBRE", "TOM COLLINS", "SLOE GIN FIZZ",
            "BACARDI COCKTAIL", "TEQUILA SUNRISE", "WOO WOO", "SEX ON THE BEACH", "PEARL HARBOR", "WATER-MELON", "WHITE RUSSIAN", "TOASTED ALMOND", "GRAPE CRUSH", "RED-HEADED SLUT",
            "WASHINGTON APPLE", "ORGASM", "ALABAMA SLAMMER", "CAPTAIN ON ACID", "SCREAMING ORGASM", "RUSSIAN QUALUDE", "CALIFORNIA LEMONADE", "LONG ISLAND ICE TEA", "LONG BEACH ICE TEA", "ELECTRIC LEMONADE", "GRATEFUL DEAD",
            "NUCLEAR TEA", "ADIOS M.F.", "BOURBON ON THE ROCKS", "SCOTCH ON THE ROCKS", "TOP SHELF SCOTCH ON THE ROCKS", "BLACK RUSSIAN", "SICILIAN KISS",
            "GOD MOTHER", "GOD FATHER", "RUSTY NAIL", "NUTTY IRISHMAN", "STINGER", "KAMIKAZE", "PURPLE HOOTER", "WINDEX",
            "RASPBERRY KAMIKAZE", "MUDSLIDE", "AFTER FIVE", "B~51", "B~52", "B~53", "OATMEAL COOKIE", "RED DEATH"};

    Map<String, String[]> recipes = new HashMap<String, String[]>()
    {{
        put("margarita", new String[]{"1 1/4 oz Tequila", "3/4 oz Triple Sec", "splash lime juice", "sour mix", "garnish with lime", "up or margarita glass"});
        put("blue margarita", new String[]{"1 1/4 oz Tequila", "3/4 oz Blue Curacao", "splash lime juice", "sour mix", "garnish with lime", "up or margarita glass"});
        put("gold margarita", new String[]{"1 1/4 oz Gold Tequila", "3/4 oz Triple Sec", "splash lime juice", "sour mix", "garnish with lime", "up or margarita glass"});
        put("grand gold margarita", new String[]{"1 1/4 oz Gold Tequila", "3/4 oz Grand Marnier", "splash lime juice", "sour mix", "garnish with lime", "up or margarita glass"});
        put("cadilac margarita", new String[]{"1 1/4 oz Gold Tequila", "3/4 oz Grand Marnier", "1/2 oz Chambord", "splash lime juice", "sour mix", "garnish with lime", "up or margarita glass"});
        put("martini", new String[]{"2 1/2 oz Gin", "1/2 oz Dry Vermouth", "garnish with olive", "ice back or water back", "up glass"});
        put("vodka martini", new String[]{"2 1/2 oz Vodka", "1/2 oz Dry Vermouth", "garnish with olive", "ice back or water back", "up glass"});
        put("dry martini", new String[]{"2 3/4 oz Gin", "1/4 oz Dry Vermouth", "garnish with olive", "ice back or water back", "up glass"});
        put("bone dry martini", new String[]{"3 oz Gin", "garnish with olive", "ice back or water back", "up glass"});
        put("gibson", new String[]{"2 1/2 oz Gin", "1/2 oz Dry Vermouth", "garnish with 3 cocktail onions", "up glass"});
        put("gimlet", new String[]{"2 1/2 oz Gin", "1/2 oz Lime Juice", "garnish with lime", "up glass"});
        put("dirty martini",new String[]{"2 1/2 oz Gin", "1/2 oz Olive Juice", "garnish with 3 olives", "up glass"});
        put("manhattan", new String[]{"2 1/2 oz Whiskey", "1/2 oz Sweet Vermouth", "garnish with cherry", "rocks glass"});
        put("perfect manhattan", new String[]{"2 1/2 oz Whiskey", "1/4 oz Sweet Vermouth", "1/4 oz Dry Vermouth", "garnish with cherry", "rocks glass"});
        put("dry manhattan", new String[]{"2 1/2 oz Whiskey", "1/2 oz Dry Vermouth", "garnish with cherry", "rocks glass"});
        put("rob roy", new String[]{"2 1/2 oz Scotch Whiskey", "1/2 oz Sweet Vermouth", "garnish with cherry", "rocks glass"});
        put("old fashioned", new String[]{"2 1/2 oz Whiskey", "1 slice of orange", "1 sugar cube", "2 dashes of bitters", "1 cherry", "splash soda", "rocks glass"});
        put("mojito", new String[]{"highball glass", "1 oz Rum", "1/2 lime", "5 mint leaves", "1/2 oz Simple Syrup", "splash soda"});
        put("mint julip", new String[]{"rocks glass", "2 1/2 oz Kentucky Bourbon", "1/2 oz Simple Syrup", "5 mint leaves", "garnish with lime and mint"});
        put("moscow mule", new String[]{"1/2 lime", "1 1/2 oz Vodka", "Ginger beer", "mug"});
        put("hot toddy", new String[]{"1 oz Irish Whiskey", "Hot water", "lemon", "honey", "irish glass"});
        put("irish coffee", new String[]{"1 oz Whiskey", "Coffee", "1 cup Heavy Cream", "1 tbsp powdered sugar", "1 tbsp Vanilla Extract", "irish glass"}) ;
        put("basic cosmopolitan", new String[]{"2 oz Vodka", "1 oz Triple Sec", "splash cranberry juice", "splash lime juice", "garnish with lime", "up glass"});
        put("top shelf cosmopolitan", new String[]{"2 oz Absolute Citron", "1 oz Cointreau", "splash cranberry juice", "splash lime juice", "garnish with lime", "up glass"});
        put("apple martini", new String[]{"2 oz Vodka", "1 oz Apple Pucker", "garnish with apple slice", "up glass"});
        put("basic espresso martini", new String[]{"1 oz Vanilla Vodka", "1 oz Kahlua", "splash espresso", "cream", "garnish with 3 espresso beans", "up glass"});
        put("sidecar", new String[]{"2 oz Cognac", "1 oz Cointreau", "splash sour mix", "garnish with lemon twist", "up glass"});
        put("negroni", new String[]{"1 oz Campari", "1 oz Top Shelf Gin", "1 oz Sweet Vermouth", "garnish with orange twist", "up glass"});
        put("kamikaze(shooter)", new String[]{"1/2 oz Vodka", "1/2 oz Triple Sec", "splash lime juice", "shooter glass"});
        put("windex(shooter)", new String[]{"1/2 oz Vodka", "1/2 oz Blue Curacao", "splash lime juice", "shooter glass"});
        put("chocolate cake", new String[]{"1/2 oz Citron", "1/2 oz Frangelico", "garnish with sugared lemon on separate glass", "shooter glass"});
        put("lemon drop", new String[]{"1 oz Citron", "garnish with sugared lemon on separate glass", "shooter glass"});
        put("captain on acid(shooter)", new String[]{"1/3 oz Captain Morgan", "1/3 oz Malibu Rum", "1/3 oz Blue Curacao", "Splash pineapple juice", "splash grenadine", "shooter glass"});
        put("apple sauce", new String[]{"1/2 oz Goldschlager", "1/2 oz Apple Pucker", "splash pineapple juice", "shooter glass"});
        put("washington apple(shooter)", new String[]{"1/2 oz Crown Royal", "1/2 oz Apple Pucker", "splash cranberry juice", "shooter glass"});
        put("red headed slut(shooter)", new String[]{"1/2 oz Peach Schnapps", "1/2 oz Jagermeister", "splash cranberry juice", "shooter glass"});
        put("mind eraser", new String[]{"1/2 oz Vodka", "1/2 oz Kahlua", "splash soda", "garnish with large straw", "shooter glass"});
        put("zipper head", new String[]{"1/2 oz Vodka", "1/2 oz Chambord", "splash soda", "garnish with large straw", "shooter glass"});
        put("spritzers", new String[]{"5 oz White Wine", "splash soda", "garnish with lemon twist", "ice", "white wine glass"});
        put("mimosa", new String[]{"25% orange juice", "75% champagne or sparkling wine", "garnish with orange", "flute glass"});
        put("bellini", new String[]{"1/2 oz Peach Schnapps", "champagne or sparkling wine", "flute glass"});
        put("kir royal", new String[]{"1/2 oz Chambord", "champagne or sparkling wine", "garnish with raspberry", "flute glass"});
        put("screwdriver", new String[]{"1 oz Vodka", "Orange juice", "garnish with orange", "highball glass"});
        put("cape codder", new String[]{"1 oz Vodka", "Cranberry Juice", "garnish with lime", "highball glass"});
        put("sea breeze", new String[]{"1 oz Vodka", "Cranberry Juice", "Grapefruit Juice", "garnish with lime", "highball glass"});
        put("bay breeze", new String[]{"1 oz Vodka", "Cranberry Juice", "Pineapple Juice", "garnish with lime", "highball glass"});
        put("madras", new String[]{"1 oz Vodka", "Orange Juice", "Cranberry Juice", "garnish with lime", "highball glass"});
        put("greyhound", new String[]{"1 oz Vodka", "Grapefruit juice", "highball glass"});
        put("salty dog", new String[]{"1 oz Vodka", "Grapefruit Juice", "Salt rim of glass", "highball glass"});
        put("sombrero", new String[]{"1 oz Coffee flavored brandy", "cream or milk", "highball glass"});
        put("highball", new String[]{"1 oz Whiskey", "Ginger ale", "highball glass"});
        put("whiskey sour", new String[]{"1 oz Whiskey", "Sour Mix", "garnish with orange and cherry", "highball glass"});
        put("fuzzy navel", new String[]{"1 oz Peach Schnapps", "Orange juice", "garnish with orange", "highball glass"});
        put("cuba libre", new String[]{"1 oz Rum", "Coke", "garnish with lime", "highball glass"});
        put("tom collins", new String[]{"1 oz Gin", "Sour mix", "splash soda", "highball glass", "garnish with orange and cherry"});
        put("sloe gin fizz", new String[]{"1 oz Sloe Gin", "Sour Mix", "splash soda", "highball glass", "garnish with orange and cherry"});
        put("bacardi cocktail", new String[]{"1 oz Bacardi", "Sour Mix", "splash grenadine", "highball glass", "garnish with orange and cherry"});
        put("tequila sunrise", new String[]{"1 oz Tequila", "Orange Juice", "splash grenadine", "garnish with orange", "highball glass"});
        put("woo woo", new String[]{"1/2 oz Vodka", "1/2 oz Peach Schnapps", "Cranberry Juice", "garnish with lime", "highball glass"});
        put("sex on the beach", new String[]{"1/2 oz Vodka", "1/2 oz Peach Schnapps", "Cranberry Juice", "Orange juice", "garnish with lime", "highball glass"});
        put("pearl harbor", new String[]{"1/2 oz Vodka", "1/2 oz Melon Liqueur", "Pineapple juice", "highball glass"});
        put("water-melon", new String[]{"1/2 oz Vodka", "1/2 oz Melon Liqueur", "Cranberry Juice", "garnish with lime", "highball glass"});
        put("white russian", new String[]{"1/2 oz Vodka", "1/2 oz Kahlua", "cream", "highball glass"});
        put("toasted almond", new String[]{"1/2 oz Amaretto", "1/2 oz Kahlua", "cream", "highball glass"});
        put("grape crush", new String[]{"1/2 oz Vodka", "1/2 oz Chambord", "Sour mix", "highball glass", "garnish with orange and cherry"});
        put("red-headed slut", new String[]{"1/2 oz Peach Schnapps", "1/2 oz Jagermeister", "Cranberry Juice", "highball glass", "garnish with lime"});
        put("washington apple", new String[]{"1/2 oz Crown Royal", "1/2 oz Apple Pucker", "Cranberry juice", "garnish with lime", "highball glass"});
        put("orgasm", new String[]{"1/2 oz Kahlua", "1/2 oz Baileys",  "1/2 oz Amaretto", "Cream", "tall glass"});
        put("alabama slammer", new String[]{"1/2 oz Amaretto", "1/2 oz Southern Comfort",  "1/2 oz Sloe Gin", "Orange Juice", "garnish with orange", "tall glass"});
        put("captain on acid", new String[]{"1/2 oz Captain Morgan", "1/2 oz Malibu Rum", "1/2 oz Blue Curacao", "Pineapple Juice", "Splash Grenadine", "tall glass"});
        put("screaming orgasm", new String[]{"1/2 oz Vodka", "1/2 oz Kahlua", "1/2 oz Baileys", "1/2 oz Amaretto", "cream", "tall glass"});
        put("russian qualude", new String[]{"1/2 oz Vodka", "1/2 oz Kahlua", "1/2 oz Baileys", "1/2 oz Frangelico", "cream", "tall glass"});
        put("california lemonade", new String[]{"1/2 oz Vodka", "1/2 oz Gin", "1/2 oz Rum", "1/2 oz Triple Sec", "Sour mix", "splash grenadine", "garnish with lemon", "tall glass"});
        put("long island ice tea", new String[]{"1/4 oz Vodka", "1/4 oz Gin", "1/4 oz Rum", "1/4 oz Tequila", "1/4 oz Triple Sec", "Sour Mix", "splash coke", "garnish with lemon", "tall glass"});
        put("long beach ice tea", new String[]{"1/4 oz Vodka", "1/4 oz Gin", "1/4 oz Rum", "1/4 oz Tequila", "1/4 oz Triple Sec", "Cranberry Juice", "splash sprite", "garnish with lemon", "tall glass"});
        put("electric lemonade", new String[]{"1/4 oz Vodka", "1/4 oz Gin", "1/4 oz Rum", "1/4 oz Tequila", "1/4 oz Triple Sec", "Sour mix", "splash sprite", "garnish with lemon", "tall glass"});
        put("grateful dead", new String[]{"1/4 oz Vodka", "1/4 oz Gin", "1/4 oz Rum", "1/4 oz Tequila", "1/4 oz Triple Sec", "1/2 oz Chambord", "Sour mix", "garnish with lemon", "tall glass"});
        put("nuclear tea", new String[]{"1/4 oz Vodka", "1/4 oz Gin", "1/4 oz Rum", "1/4 oz Tequila", "1/4 oz Triple Sec", "1/2 oz Midori or Melon", "Sour mix", "garnish with lemon", "tall glass"});
        put("adios m.f.", new String[]{"1/4 oz Vodka", "1/4 oz Gin", "1/4 oz Rum", "1/4 oz Tequila", "1/4 oz Triple Sec", "1/2 oz Blue Curacao", "Sour Mix", "garnish with lemon", "tall glass"});
        put("bourbon on the rocks", new String[]{"1 1/2 oz Bourbon Whiskey", "Rocks Glass"});
        put("scotch on the rocks", new String[]{"1 1/2 oz Scotch Whiskey", "Rocks Glass"});
        put("top shelf scotch on the rocks", new String[]{"1 1/2 oz Scotch Whiskey", "Rocks Glass"});
        put("black russian", new String[]{"1 1/4 oz Vodka", "3/4 oz Kahlua", "Rocks Glass"});
        put("sicilian kiss", new String[]{"1 1/4 oz Southern Comfort", "3/4 oz Amaretto", "Rocks Glass"});
        put("god mother", new String[]{"1 1/4 oz Vodka", "3/4 oz Amaretto", "Rocks Glass"});
        put("god father", new String[]{"1 1/4 oz Scotch", "3/4 oz Amaretto", "Rocks Glass"});
        put("rusty nail", new String[]{"1 1/4 oz Scotch", "3/4 oz Drambuie", "Rocks Glass", "garnish with lemon twist"});
        put("nutty irishman", new String[]{"1 1/4 oz Baileys", "3/4 oz Frangelico", "Rocks Glass"});
        put("stinger", new String[]{"1 1/4 oz Brandy", "3/4 oz White Creme De Menthe", "Rocks Glass", "garnish with mint leaf"});
        put("kamikaze", new String[]{"1 1/4 oz Vodka", "3/4 oz Triple Sec", "Rocks Glass", "garnish with lime", "splash lime juice"});
        put("purple hooter", new String[]{"1 1/4 oz Vodka", "3/4 oz Chambord", "splash lime juice", "garnish with lime", "Rocks Glass"});
        put("windex", new String[]{"1 1/4 oz Vodka", "3/4 oz Blue Curacao", "splash lime juice", "garnish with lime", "Rocks Glass"});
        put("raspberry kamikaze", new String[]{"1 1/4 oz Raspberry Vodka", "3/4 oz Triple Sec", "splash lime juice", "garnish with lime", "Rocks Glass"});
        put("mudslide", new String[]{"1/2 oz Kahlua", "1/2 oz Baileys", "1/2 oz Vodka", "Rocks Glass"});
        put("after five", new String[]{"1/2 oz Kahlua", "1/2 oz Baileys", "1/2 oz Peppermint Schnapps", "Rocks Glass"});
        put("b~51", new String[]{"1/2 oz Kahlua", "1/2 oz Baileys", "1/2 oz Frangelico", "Rocks Glass"});
        put("b~52", new String[]{"1/2 oz Kahlua", "1/2 oz Baileys", "1/2 oz Grand Marnier", "Rocks Glass"});
        put("b~53", new String[]{"1/2 oz Kahlua", "1/2 oz Baileys", "1/2 oz Amaretto", "Rocks Glass"});
        put("oatmeal cookie", new String[]{"1/2 oz Kahlua", "1/2 oz Baileys", "1/2 oz Goldschlager", "Rocks Glass"});
        put("red death", new String[]{"tall glass", "1/4 oz Amaretto", "1/4 oz Southern Comfort", "1/4 oz Sloe Gin", "1/4 oz Vodka", "1/4 oz Triple Sec", "splash lime juice", "Orange Juice", "garnish with lime"});
    }};

    EditText answer;
    TextView drink;
    TextView result;
    Button check;

    ArrayList asked = new ArrayList();
    Handler handler;
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fillblankother);

        answer = (EditText) findViewById(R.id.recipe);
        drink = (TextView) findViewById(R.id.drink);
        result = (TextView) findViewById(R.id.result);
        check = (Button) findViewById(R.id.check);

        handler = new Handler();

        drink.setText(allDrinks[r.nextInt(allDrinks.length)]);
        asked.add(drink.getText().toString());
    }

    public void checkAnswer(View v)
    {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        String[] guess = answer.getText().toString().split(",");
        for(int i = 0; i< guess.length; i++)
        {
            guess[i] = guess[i].trim().toLowerCase();
        }
        Log.e("guess", Arrays.asList(guess).toString());

        String[] ans = recipes.get(drink.getText().toString().toLowerCase());
        String a = "";
        for(int i = 0; i< ans.length; i++)
        {
            ans[i] = ans[i].trim().toLowerCase();
            a += ans[i];
            if (i != ans.length-1)
            {
                a += ", ";
            }
        }
        Log.e("ans", Arrays.asList(ans).toString());

        boolean correct = true;

        if (ans.length != guess.length){
            correct = false;
        }

        for(int i = 0; i<guess.length; i++)
        {
            if (!Arrays.asList(ans).contains(guess[i]))
            {
                correct = false;
                break;
            }
        }

        check.setVisibility(View.GONE);
        result.setVisibility(View.VISIBLE);

        if (correct)
        {
            result.setText("CORRECT!");
            result.setTextColor(Color.parseColor("#00BF00"));
        }
        else
        {
            result.setText("WRONG!");
            result.setTextColor(Color.parseColor("#F60000"));
            answer.setTextColor(Color.parseColor("#00BF00"));
            answer.setTypeface(Typeface.DEFAULT_BOLD);

            answer.setText(a);
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                answer.setTextColor(Color.parseColor("#000000"));
                answer.setTypeface(Typeface.DEFAULT);

                answer.setText("");
                check.setVisibility(View.VISIBLE);
                result.setVisibility(View.GONE);

                while (asked.contains(drink.getText().toString()) || asked.size() == 0) {
                    drink.setText(allDrinks[r.nextInt(allDrinks.length)]);
                }
                asked.add(drink.getText().toString());

                if (asked.size() == allDrinks.length)
                {
                    asked.clear();
                }

            }
        }, 5000);
    }
}
