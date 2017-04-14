package com.example.frances.ebs.tall;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.frances.ebs.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Frances on 3/21/2017.
 */

public class multipleChoice extends AppCompatActivity {

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

    Random r = new Random();

    TextView choice1, choice2, choice3, choice4, answer, question;
    String ans;
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
            String[] g = {"Splash Coke", "Splash Grenadine", "Splash Sprite", "None"};
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
                cs[i].setTextSize(12);
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
