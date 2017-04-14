package com.example.frances.ebs.spirits;

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

import com.example.frances.ebs.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Frances on 4/3/2017.
 */

public class fillBlank extends AppCompatActivity {

    String[] allDrinks = {"WHISKEY", "IRISH WHISKEY", "BOURBON", "SCOTCH", "GIN", "VODKA", "RUM", "TEQUILA", "BRANDY", "COGNAC", "WHITE WINE",
            "RED WINE", "BLUSH", "APERITIFS", "CHAMPAGNE", "DESSERT WINES"};

    HashMap<String, String> spirits = new HashMap<String, String>()
    {{
        put("whiskey", "Jack Daniels\nSeagrams 7\nSeagrams V.O.\nWindsor Canadian\nCrown Royal\nCanadian Club\nDads Hat Rye\nWigle");
        put("irish whiskey", "Jameson\nBushmills\nTullemore Dew\nPowers\nRed Breast 12\n");
        put("bourbon", "Jim Beam\nMakers Mark\nOld Grandad\nWild Turkey\nBookers\nKnob Creek\nBlantons");
        put("scotch", "Dewars\nJohnnie Walker Red\nJohnnie Walker Black\nJohnnie Walker Gold\nJohnnie Walker Green\nJohnnie Walker Platinum\nJohnnie Walker Blue\nChivas Regal\nJ&B\nLagavulin\nGlenlivet\nGlenfiddich\nMacallan");
        put("gin", "Beefeater\nTanqueray\nBombay\nBombay Saphire\nHendricks\nMahon\nBoodles\nPortabello Road\nBlue Coat\nWigle Ginever");
        put("vodka", "Absolute\nStolichnaya\nBelvedere\nFinlandia\nKetel One\nSkyy\nGrey Goose\nGolia\nSmirnoff\nVan Gogh\nPravda\nCiroc\nEffen\nBoyd & Blair");
        put("rum", "Bacardi\nMalibu\nParrot Bay\nCaptain Morgan\nMyers Dark Rum\nMount Gay\nCockspur 8 Year\nBacardi Anejo\nAppleton Estates\nMaggies Farm");
        put("tequila", "Jose Cuervo\n1800\nPatron\nPatron Reposado\nPatron XO\nRoca\nSauza\nCabo Wabo\nDon Julio\nHornitos\nCasa Noble");
        put("brandy", "Christian Brothers\nE&J\nVecchia Romagna");
        put("cognac", "Courvoisier\nHennessey\nRemy Martin\nLouis XIII");
        put("white wine", "Chardonnay\nSauvignon Blanc\nPinot Grigio\nRiesling");
        put("red wine", "Cabernet Sauvignon\nMerlot\nShiraz\nPinot Noir");
        put("blush", "White Zinfandel");
        put("aperitifs", "Dry Vermouth\nSweet Vermouth\nDubonnet\nDry Sherry\nDry Port");
        put("champagne", "Champagne\nSparkling Wine");
        put("dessert wines", "Sweet Port\nSweet & Nutty Sherry");
    }};

    EditText ans1, ans2, ans3;
    TextView spirit, result;
    Button check;
    String drink;

    Handler handler;
    Random r = new Random();

    ArrayList asked = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spiritsfillblank);

        ans1 = (EditText) findViewById(R.id.ans1);
        ans2 = (EditText) findViewById(R.id.ans2);
        ans3 = (EditText) findViewById(R.id.ans3);
        check = (Button) findViewById(R.id.checkS);
        result = (TextView) findViewById(R.id.resultS);
        spirit = (TextView) findViewById(R.id.spiritType);
        handler = new Handler();

        result.setVisibility(View.GONE);
        check.setVisibility(View.VISIBLE);

        spirit.setText(allDrinks[r.nextInt(allDrinks.length)]);
        drink = spirit.getText().toString().toLowerCase();
        //drink.setText("RED-HEADED SLUT");
        asked.add(spirit.getText().toString());
    }

    private ArrayList getAnswers() {
        ArrayList<String> answers = new ArrayList();

        answers.add(ans1.getText().toString().toLowerCase());
        answers.add(ans2.getText().toString().toLowerCase());
        answers.add(ans3.getText().toString().toLowerCase());

        return answers;

    }

    public void checkAnswer(View v) {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }


        check.setVisibility(View.INVISIBLE);

        String[] s = spirits.get(drink).split("\n");
        for (int i = 0; i< s.length; i++)
        {
            s[i] = s[i].toLowerCase();
        }


        ArrayList<String> ans = new ArrayList(Arrays.asList(s));

        Log.e("ans", ans.toString());

        ArrayList<String> a = getAnswers();
        Log.e("guess", a.toString());

        boolean cor = true;

        for (int i = 0; i<3; i++)
        {
            if (!a.get(i).isEmpty() && !ans.contains(a.get(i).toLowerCase().trim()))
            {
                result.setVisibility(View.VISIBLE);
                result.setText("WRONG!");
                result.setTextColor(Color.parseColor("#F60000"));
                setCorrectAns();
                cor = false;
            }
        }

        if (cor) {
            result.setVisibility(View.VISIBLE);
            result.setText("CORRECT!");
            result.setTextColor(Color.parseColor("#00BF00"));
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ans1.setText("");
                ans2.setText("");
                ans3.setText("");

                ans1.setTextColor(Color.parseColor("#000000"));
                ans2.setTextColor(Color.parseColor("#000000"));
                ans3.setTextColor(Color.parseColor("#000000"));

                ans1.setTypeface(Typeface.DEFAULT);
                ans2.setTypeface(Typeface.DEFAULT);
                ans3.setTypeface(Typeface.DEFAULT);


                result.setVisibility(View.GONE);
                check.setVisibility(View.VISIBLE);

                while (asked.contains(spirit.getText().toString()) || asked.size() == 0) {
                    spirit.setText(allDrinks[r.nextInt(allDrinks.length)]);
                }
                asked.add(spirit.getText().toString());
                drink = spirit.getText().toString().toLowerCase();

                if (asked.size() == allDrinks.length)
                {
                    Log.e("size", Integer.toString(asked.size()));
                    Log.e("asked", asked.toString());
                    asked.clear();
                }


            }
        }, 4000);
    }

    public void setCorrectAns()
    {
        String[] s = spirits.get(drink).split("\n");

        int count = 0;
        EditText[] edits = new EditText[] {ans1, ans2, ans3};
        ArrayList<String> name = new ArrayList<String>();

        while (count<3)
        {
            int i = r.nextInt(s.length);
            if (!name.contains(s[i]))
            {
                name.add(s[i]);
                count++;
            }
        }

        for (int i = 0; i< 3; i++)
        {
            edits[i].setTextColor(Color.parseColor("#00BF00"));
            edits[i].setTypeface(Typeface.DEFAULT_BOLD);
            edits[i].setText(name.get(i));
        }
    }
}
