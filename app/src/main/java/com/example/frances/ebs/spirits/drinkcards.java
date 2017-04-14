package com.example.frances.ebs.spirits;

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
 * Created by Frances on 3/29/2017.
 */

public class drinkcards extends AppCompatActivity {
    String[] allDrinks = {"WHISKEY", "IRISH WHISKEY", "BOURBON", "SCOTCH", "GIN", "VODKA", "RUM", "TEQUILA", "BRANDY", "COGNAC", "WHITE WINE",
            "RED WINE", "BLUSH", "APERITIFS", "CHAMPAGNE", "DESSERT WINES"};

    HashMap<String, String> spirits = new HashMap<String, String>()
    {{
        put("whiskey", "Jack Daniels\nSeagrams 7\nSeagrams V.O.\nWindsor Canadian\nCrown Royal\nCanadian Club\nDad's Hat Rye (Local)\nWigle (Local-multiple brands)");
        put("irish whiskey", "Jameson\nBushmills\nTullemore Dew\nPowers\nRed Breast 12\n");
        put("bourbon", "Jim Beam-sour mash\nMakers Mark\nOld Grandad\nWild Turkey\nBookers\nKnob Creek\nBlanton's");
        put("scotch", "Dewars\nJohnnie Walker (Red, Black, Gold, Green, Platinum, Blue)\nChivas Regal\nJ&B\nLagavulin\nThe Glenlivet - single malt\nGlenfiddich - single malt\nMacallan - single malt");
        put("gin", "Beefeater\nTanqueray\nBombay\\Bombay Saphire\nHendricks\nMahon\nBoodles\nPortabello Road\nBlue Coat (Local)\nWigle Ginever (Local)");
        put("vodka", "Absolute\nStolichnaya\nBelvedere\nFinlandia\nKetel One\nSkyy\nGrey Goose\nGolia\nSmirnoff\nVan Gogh\nPravda\nCiroc\nEffen\nBoyd & Blair (Local)");
        put("rum", "Bacardi\nMalibu\nParrot Bay\nCaptain Morgan\nMyers Dark Rum\nMount Gay\nCockspur 8 Year\nBacardi Anejo\nAppleton Estates\nMaggie's Farm (Local)");
        put("tequila", "Jose Cuervo\n1800\nPatron, Patron Reposado, Patron XO, Roca\nSauza\nCabo Wabo\nDon Julio\nHornitos\nCasa Noble");
        put("brandy", "Christian Brothers\nE&J\nVecchia Romagna");
        put("cognac", "Courvoisier\nHennessey\nRemy Martin\nLouis XIII");
        put("white wine", "Chardonnay\nSauvignon Blanc\nPinot Grigio\nRiesling");
        put("red wine", "Cabernet Sauvignon\nMerlot\nShiraz\nPinot Noir");
        put("blush", "White Zinfandel");
        put("aperitifs", "Dry Vermouth\nSweet Vermouth\nDubonnet\nDry Sherry\nDry Port");
        put("champagne", "Champagne\nSparkling Wine (If not made in Champagne Region of France)");
        put("dessert wines", "Sweet Port\nSweet & Nutty Sherry");
    }};

    String drink;
    TextView nameText, spiritslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spiritscard);

        Intent prevIntent = getIntent();
        drink = prevIntent.getStringExtra("drink");

        nameText = (TextView) findViewById(R.id.drinkName);
        spiritslist = (TextView) findViewById(R.id.spiritsList);

        setCard();
    }

    private void setCard()
    {
        nameText.setText(drink.toUpperCase());
        spiritslist.setText(spirits.get(drink.toLowerCase()));
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
