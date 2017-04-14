package com.example.frances.ebs.highball;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.frances.ebs.R;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Frances on 2/28/2017.
 */

public class multipleChoice extends AppCompatActivity {

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

    Random r = new Random();

    TextView choice1, choice2, choice3, choice4, answer, question;
    String ans;
    int qIndex;
    String[] choices;
    TextView correct;
    Handler handler;

    TextView pressed;

    Thread thread;

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

    //if answer is a recipe, use 20sp as font size
    private void createQuestion()
    {
        String[] qs = {"Which drink contains ", "What garnish does drink contain", "What mixer does drink use",
                       "Which of the following describes a drink"};


        int i = r.nextInt(allDrinks.length);
        ans = allDrinks[i];

        qIndex = r.nextInt(qs.length);
        String q = "";

        if (qIndex != 0)
        {
            q = qs[qIndex].replace("drink", ans);
        }
        else
        {
            q = qs[qIndex] + liquor.get(ans.toLowerCase());

            if (!mixer.get(ans.toLowerCase()).isEmpty())
            {
                q += " + " + mixer.get(ans.toLowerCase());;
            }

            if (!garnish.get(ans.toLowerCase()).equals("None"))
            {
                q += " + " + garnish.get(ans.toLowerCase());
            }
        }

        question.setText(q + "?");
    }

    private void createAnswers()
    {
        choices = new String[4];
        int count = 1;
        String a = "";

        if (qIndex == 3)
        {
            choices[0] = liquor.get(ans.toLowerCase());

            if (!mixer.get(ans.toLowerCase()).isEmpty())
            {
                choices[0] += ", " + mixer.get(ans.toLowerCase());
            }

            if (!garnish.get(ans.toLowerCase()).equals("None"))
            {
                choices[0] += ", " + garnish.get(ans.toLowerCase());
            }

            while (count != 4)
            {
                int i = r.nextInt(allDrinks.length);
                if (allDrinks[i] != ans)
                {
                    a = liquor.get(allDrinks[i].toLowerCase());

                    if (!mixer.get(ans.toLowerCase()).isEmpty())
                    {
                        a += ", " + mixer.get(allDrinks[i].toLowerCase());
                    }

                    if (!garnish.get(allDrinks[i].toLowerCase()).equals("None"))
                    {
                        a += ", " + garnish.get(allDrinks[i].toLowerCase());
                    }

                    if (!Arrays.asList(choices).contains(a))
                    {
                        choices[count] = a;
                        count++;
                    }

                }
            }
        }
        else if (qIndex == 0)
        {
            choices[0] = ans;

            while (count != 4)
            {
                int i = r.nextInt(allDrinks.length);
                if (allDrinks[i] != ans)
                {
                    a = allDrinks[i];

                    if (!Arrays.asList(choices).contains(a))
                    {
                        choices[count] = a;
                        count++;
                    }
                }

            }
        }
        else if (qIndex == 1)
        {
            String[] g = {"Lime", "Lace grenadine", "Splash of Soda", "Salt rim of the glass", "None"};
            choices[0] = garnish.get(ans.toLowerCase());

            while (count != 4)
            {
                int i = r.nextInt(g.length);
                if (g[i] != choices[0])
                {
                    a = g[i];

                    if (!Arrays.asList(choices).contains(a))
                    {
                        choices[count] = a;
                        count++;
                    }
                }
            }
        }
        else
        {
            choices[0] = mixer.get(ans.toLowerCase());

            while (count != 4)
            {
                int i = r.nextInt(allDrinks.length);
                if (mixer.get(allDrinks[i].toLowerCase()) != choices[0])
                {
                    a = mixer.get(allDrinks[i].toLowerCase());
                    if (!Arrays.asList(choices).contains(a))
                    {
                        choices[count] = a;
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
            if (qIndex == 3)
            {
                cs[i].setTextSize(15);
            }
            else
            {
                cs[i].setTextSize(18);
            }
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
