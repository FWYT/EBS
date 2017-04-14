package com.example.frances.ebs.rocks;

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

public class multipleChoice extends AppCompatActivity  {
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
        put("nutty irishman", "1 1/4 oz Baileys & 3/4 oz Frangelico");
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
        put("nutty irishman", "");
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
        put("nutty irishman", "None");
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
        String[] qs = {"Which drink contains ", "What garnish does drink contain",
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

        if (qIndex == 2)
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


        TextView[] cs = {choice1, choice2, choice3, choice4};
        cs = shuffle(cs);
        correct = cs[0];

        for (int i = 0; i<4; i++)
        {
            if (qIndex == 2)
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
