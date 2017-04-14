package com.example.frances.ebs.spirits;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.frances.ebs.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Frances on 4/3/2017.
 */

public class multipleChoice extends AppCompatActivity {

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

    Random r = new Random();

    TextView choice1, choice2, choice3, choice4, answer, question;
    String ansType, ansDrink;
    int qIndex;
    String[] choices;
    TextView correct;
    Handler handler;

    TextView pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplechoice);

        choice1 = (TextView) findViewById(R.id.choice1);
        choice2 = (TextView) findViewById(R.id.choice2);
        choice3 = (TextView) findViewById(R.id.choice3);
        choice4 = (TextView) findViewById(R.id.choice4);

        answer = (TextView) findViewById(R.id.answer);
        question = (TextView) findViewById(R.id.question);

        handler = new Handler();

        createQuestion();
        createAnswers();

        question.setTextSize(21);
    }

    public void choice(View v)
    {
        pressed = (TextView) findViewById(v.getId());
        answer.setVisibility(View.VISIBLE);

        if (pressed.getText().toString() == choices[0])
        {
            pressed.setTextColor(Color.parseColor("#00BF00"));
            answer.setText("CORRECT!");
            answer.setTextColor(Color.parseColor("#00BF00"));
        }
        else
        {
            pressed.setTextColor(Color.parseColor("#F60000"));
            answer.setText("WRONG!");
            answer.setTextColor(Color.parseColor("#F60000"));
            correct.setTextColor(Color.parseColor("#00BF00"));
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pressed.setTextColor(Color.parseColor("#777777"));
                correct.setTextColor(Color.parseColor("#777777"));
                answer.setVisibility(View.GONE);

                createQuestion();
                createAnswers();
            }
        }, 3000);

    }

    private void createQuestion()
    {
        String[] qs = {"What kind of spirit is drink", "Which of the following is a drink"};


        int i = r.nextInt(allDrinks.length);
        ansType = allDrinks[i];

        qIndex = r.nextInt(qs.length);
        String q = "";

        if (qIndex == 1)
        {
            q = qs[qIndex].replace("drink", ansType);
        }
        else
        {
            String s = spirits.get(ansType.toLowerCase());
            String[] ss = s.split("\n");
            int k = r.nextInt(ss.length);
            ansDrink = ss[k].toUpperCase();
            q = qs[qIndex].replace("drink", ansDrink);
        }

        question.setText(q + "?");
    }

    private void createAnswers()
    {
        choices = new String[4];
        int count = 1;
        String a = "";

        if (qIndex == 0)
        {
            choices[0] = ansType;

            while (count != 4)
            {
                int i = r.nextInt(allDrinks.length);
                if (allDrinks[i] != ansType)
                {
                    if (!Arrays.asList(choices).contains(allDrinks[i]))
                    {
                        choices[count] = allDrinks[i];
                        count++;
                    }

                }
            }
        }
        else
        {
            int k = r.nextInt(spirits.get(ansType.toLowerCase()).split("\n").length);
            choices[0] = spirits.get(ansType.toLowerCase()).split("\n")[k];

            while (count != 4)
            {
                int i = r.nextInt(allDrinks.length);
                if (allDrinks[i] != ansType)
                {
                    String[] ss = spirits.get(allDrinks[i].toLowerCase()).split("\n");
                    int j = r.nextInt(ss.length);

                    if (!Arrays.asList(choices).contains(ss[j]))
                    {
                        choices[count] = ss[j];
                        count++;
                    }
                }

            }
        }


        TextView[] cs = {choice1, choice2, choice3, choice4};
        cs = shuffle(cs);
        correct = cs[0];

        for (int i = 0; i<4; i++)
        {
            cs[i].setTextSize(18);

            cs[i].setText(choices[i]);
        }
    }

    private TextView[] shuffle(TextView[] arr)
    {
        int index;
        TextView temp;
        for (int i = arr.length - 1; i > 0; i--)
        {
            index = r.nextInt(i + 1);
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
