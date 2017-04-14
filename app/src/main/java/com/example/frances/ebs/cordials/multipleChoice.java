package com.example.frances.ebs.cordials;

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
 * Created by Frances on 4/10/2017.
 */

public class multipleChoice extends AppCompatActivity {

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
        put("benedictine", "Cognac base made by the monks of the 16th century, contains a variety of herb roots and other secret ingredients");
        put("blue curacao", "Same as triple sec but blue in color. Orange flavor. Produced in the island of Curacao near Aruba");
        put("campari", "Bitter orange liquor");
        put("chambord", "Raspberry flavored (small round bottle)");
        put("chartreuse", "Pungent, herbal brandy base");
        put("cinnamon schnapps", "Cinnamon flavor used in fireballs with Tabasco sauce");
        put("cointreau", "A fine orange liqueur replaces triple sec in margaritas and is used in cosmopolitans");
        put("creme de almond", "Rich nutty almond flavor");
        put("creme de banana", "Banana flavor (Golden Dream)");
        put("creme de menthe", "Peppermint flavor");
        put("creme de cacao", "Chocolate flavor");
        put("creme de cassis", "Burgundy in color made of black currants, served on the rocks or mixed with vermouth");
        put("drambuie", "Scotch base honey flavored used in rusty nails");
        put("frangelico", "Hazelnut flavor");
        put("grand marnier", "Orange flavored, Cognac base. Served in a brandy snifter");
        put("galliano", "Italian liqueur, tastes like mild spice. A forgotten cordial used in Harvey Wallbangers and international stingers");
        put("goldschlagger", "Cinnamon flavored 107 proof and has real gold fragments");
        put("irish mist", "Honey whiskey flavored usually served on the rocks as an after dinner drink");
        put("jagermeister", "Tastes like medicine. 56 secret ingredients served chilled");
        put("kahlua", "Coffee flavored. Product of Mexico");
        put("kamora", "Kahlua knock-off. Coffee flavor");
        put("kapali", "Kahlua knock-off. Coffee flavor");
        put("metaxa", "Greek brandy used in Italian stingers");
        put("midori", "Top shelf Melon liqueur");
        put("ouzo", "Black licorice/anisette flavor");
        put("peppermint schnapps", "Peppermint flavor");
        put("peach schnapps", "Peach flavor");
        put("sambucca", "Black licorice/anisette flavor served in snifter with 3 coffee beans. Black Sambucca is sweeter");
        put("sloe gin", "Gin seeped in sloe berries. Sweet cherry flavor used in Alabama Slammers");
        put("southern comfort", "Bourbon based peach flavor. Used in Alabama Slammers. Nicknamed SoCo");
        put("rumpleminz", "Top shelf peppermint schnapps, 100 proof");
        put("tia maria", "Coffee flavor made in Jamaica similar to Kahlua but not as sweet. Served on the rocks and in some coffee drinks");
        put("triple sec", "Orange flavor used in margaritas and kamikazes. Produced in the island of Curacao near Aruba");
        put("tuacca", "Italian liqueur flavored with vanilla and citrus");
        put("yukon jack", "Orange flavor whiskey base poured as a shot or a chilled shot");
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

        question.setTextSize(20);
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
        String[] qs = {"Which of the following satisfied this description: ", "What is drink"};


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
            String s = desc.get(ansType.toLowerCase());
            //ansDrink = ss[k].toUpperCase();
            q = qs[qIndex] + s;
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
            //int k = r.nextInt(spirits.get(ansType.toLowerCase()).split("\n").length);
            choices[0] = desc.get(ansType.toLowerCase());

            while (count != 4)
            {
                int i = r.nextInt(allDrinks.length);
                if (allDrinks[i] != ansType)
                {
                    String ss = desc.get(allDrinks[i].toLowerCase());


                    if (!Arrays.asList(choices).contains(ss))
                    {
                        choices[count] = ss;
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
            if (qIndex == 1) {
                cs[i].setTextSize(13);
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
