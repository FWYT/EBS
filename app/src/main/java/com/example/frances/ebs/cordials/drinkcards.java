package com.example.frances.ebs.cordials;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.frances.ebs.R;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Frances on 4/10/2017.
 */

public class drinkcards extends AppCompatActivity {

    String[] allDrinks = {"AMARO MONTENEGRO", "AMARETTO", "ANISETTE", "B&B", "BAILEYS IRISH CREAM", "BENEDICTINE", "BLUE CURACAO", "CAMPARI", "CHAMBORD",
            "CHARTREUSE", "CINNAMON SCHNAPPS", "COINTREAU", "CREME DE ALMOND", "CREME DE BANANA", "CREME DE MENTHE", "CREME DE CACAO",
            "CREME DE CASSIS", "DRAMBUIE", "FRANGELICO", "GRAND MARNIER", "GALLIANO", "GOLDSCHLAGGER", "IRISH MIST", "JAGERMEISTER",
            "KAHLUA", "KAMORA", "KAPALI", "METAXA", "MIDORI", "OUZO", "PEPPERMINT SCHNAPPS", "PEACH SCHNAPPS", "SAMBUCCA", "SLOE GIN",
            "SOUTHERN COMFORT", "RUMPLEMINZ", "TIA MARIA", "TRIPLE SEC", "TUACCA", "YUKON JACK"};


    HashMap<String, String> desc = new HashMap<String, String>()
    {{
        put("amaro montenegro", "Bittersweet Italian Digestif");
        put("amaretto", "Almond flavor brandy base");
        put("anisette", "Black licorice");
        put("b&b", "Blend of Benedictine and Brandy");
        put("baileys irish cream", "Whiskey based made from 1 day fresh cream");
        put("benedictine", "Cognac base made by the monks of the 16th century, contains a variety of herb roots and other secret ingredients.");
        put("blue curacao", "Same as triple sec but blue in color. Orange flavor. Produced in the island of Curacao near Aruba.");
        put("campari", "Bitter orange liquor");
        put("chambord", "Raspberry flavored (small round bottle)");
        put("chartreuse", "Pungent, herbal brandy base");
        put("cinnamon schnapps", "Cinnamon flavor used in fireballs with Tabasco sauce.");
        put("cointreau", "A fine orange liqueur replaces triple sec in margaritas and is used in cosmopolitans.");
        put("creme de almond", "Rich nutty almond flavor");
        put("creme de banana", "Banana flavor (Golden Dream)");
        put("creme de menthe", "Peppermint flavor");
        put("creme de cacao", "Chocolate flavor");
        put("creme de cassis", "Burgundy in color made of black currants, served on the rocks or mixed with vermouth.");
        put("drambuie", "Scotch base honey flavored used in rusty nails.");
        put("frangelico", "Hazelnut flavor");
        put("grand marnier", "Orange flavored, Cognac base. Served in a brandy snifter.");
        put("galliano", "Italian liqueur, tastes like mild spice. A forgotten cordial used in Harvey Wallbangers and international stingers.");
        put("goldschlagger", "Cinnamon flavored 107 proof and has real gold fragments.");
        put("irish mist", "Honey whiskey flavored usually served on the rocks as an after dinner drink.");
        put("jagermeister", "Tastes like medicine. 56 secret ingredients served chilled.");
        put("kahlua", "Coffee flavored. Product of Mexico.");
        put("kamora", "Kahlua knock-off. Coffee flavor.");
        put("kapali", "Kahlua knock-off. Coffee flavor.");
        put("metaxa", "Greek brandy used in Italian stingers.");
        put("midori", "Top shelf Melon liqueur.");
        put("ouzo", "Black licorice/anisette flavor.");
        put("peppermint schnapps", "Peppermint flavor.");
        put("peach schnapps", "Peach flavor.");
        put("sambucca", "Black licorice/anisette flavor served in snifter with 3 coffee beans. Black Sambucca is sweeter.");
        put("sloe gin", "Gin seeped in sloe berries. Sweet cherry flavor used in Alabama Slammers.");
        put("southern comfort", "Bourbon based peach flavor. Used in Alabama Slammers. Nicknamed SoCo.");
        put("rumpleminz", "Top shelf peppermint schnapps, 100 proof.");
        put("tia maria", "Coffee flavor made in Jamaica similar to Kahlua but not as sweet. Served on the rocks and in some coffee drinks.");
        put("triple sec", "Orange flavor used in margaritas and kamikazes. Produced in the island of Curacao near Aruba.");
        put("tuacca", "Italian liqueur flavored with vanilla and citrus.");
        put("yukon jack", "Orange flavor whiskey base poured as a shot or a chilled shot.");
    }};

    String drink;
    TextView nameText, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spiritscard);

        Intent prevIntent = getIntent();
        drink = prevIntent.getStringExtra("drink");

        nameText = (TextView) findViewById(R.id.spiritName);
        description = (TextView) findViewById(R.id.spiritsList);

        setCard();
    }

    private void setCard()
    {
        nameText.setText(drink.toUpperCase());
        description.setText(desc.get(drink.toLowerCase()));
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
