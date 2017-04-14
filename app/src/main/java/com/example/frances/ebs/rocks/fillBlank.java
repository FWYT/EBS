package com.example.frances.ebs.rocks;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.frances.ebs.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Frances on 3/29/2017.
 */

public class fillBlank extends AppCompatActivity {

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
        put("rusty nail", "None");
        put("nutty irishman", "None");
        put("stinger", "None");
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

    Map<String, String> top = new HashMap<String, String>()
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
        put("kamikaze", "Lime");
        put("purple hooter", "Lime");
        put("windex", "Lime");
        put("raspberry kamikaze", "Lime");
        put("mudslide", "None");
        put("after five", "None");
        put("b~51", "None");
        put("b~52", "None");
        put("b~53", "None");
        put("oatmeal cookie", "None");
    }};

    String[] topOp = new String[]{"None", "Orange", "Lemon", "Lime", "Lemon Twist", "Mint Leaf", "Cherry", "Orange and Cherry", "Olive"};

    Spinner mixerAmount1, mixerAmount2, garnishDropdown, liquorAmount1, liquorAmount2, liquorAmount3, liquorAmount4, liquorAmount5, liquorAmount6, topDropdown;
    EditText liquor1, liquor2, liquor3, liquor4, liquor5, liquor6, mixer1, mixer2;
    TextView drink, result;
    Button check;

    ArrayList asked = new ArrayList();
    Handler handler;
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fillblank);
        RelativeLayout l4 = (RelativeLayout) findViewById(R.id.l4);
        RelativeLayout l5 = (RelativeLayout) findViewById(R.id.l5);
        RelativeLayout l6 = (RelativeLayout) findViewById(R.id.l6);
        RelativeLayout m1 = (RelativeLayout) findViewById(R.id.m1);
        RelativeLayout m2 = (RelativeLayout) findViewById(R.id.m2);
        TextView m = (TextView) findViewById(R.id.mixText);

        l4.setVisibility(View.GONE);
        l5.setVisibility(View.GONE);
        l6.setVisibility(View.GONE);
        m1.setVisibility(View.GONE);
        m2.setVisibility(View.GONE);
        m.setVisibility(View.GONE);

        /*mixerAmount1 = (Spinner)findViewById(R.id.mixerAmount1);
        String[] items = new String[]{"", "100%", "50%"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        mixerAmount1.setAdapter(adapter);

        mixerAmount2 = (Spinner)findViewById(R.id.mixerAmount2);
        mixerAmount2.setAdapter(adapter);*/

        garnishDropdown = (Spinner)findViewById(R.id.garnishDropdown);
        String[] g = new String[]{"None", "Splash Coke", "Splash Grenadine", "Splash Sprite", "Splash Lime Juice"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, g);
        garnishDropdown.setAdapter(adapter2);

        liquorAmount1 = (Spinner) findViewById(R.id.liquorAmount1);
        liquorAmount2 = (Spinner) findViewById(R.id.liquorAmount2);
        liquorAmount3 = (Spinner) findViewById(R.id.liquorAmount3);
        //liquorAmount4 = (Spinner) findViewById(R.id.liquorAmount4);
        //liquorAmount5 = (Spinner) findViewById(R.id.liquorAmount5);
        //liquorAmount6 = (Spinner) findViewById(R.id.liquorAmount6);
        String[] amount = new String[]{"","1 1/2", "1 1/4", "3/4", "1", "1/2", "1/4"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, amount);
        liquorAmount1.setAdapter(adapter3);
        liquorAmount2.setAdapter(adapter3);
        liquorAmount3.setAdapter(adapter3);
        //liquorAmount4.setAdapter(adapter3);
        //liquorAmount5.setAdapter(adapter3);
        //liquorAmount6.setAdapter(adapter3);

        topDropdown = (Spinner)findViewById(R.id.topDropdown);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, topOp);
        topDropdown.setAdapter(adapter4);

        liquor1 = (EditText) findViewById(R.id.liquor1);
        liquor2 = (EditText) findViewById(R.id.liquor2);
        liquor3 = (EditText) findViewById(R.id.liquor3);
        //liquor4 = (EditText) findViewById(R.id.liquor4);
        //liquor5 = (EditText) findViewById(R.id.liquor5);
        //liquor6 = (EditText) findViewById(R.id.liquor6);
        //mixer1 = (EditText) findViewById(R.id.mixer1);
        //mixer2 = (EditText) findViewById(R.id.mixer2);
        drink = (TextView) findViewById(R.id.drink);
        result = (TextView) findViewById(R.id.result);
        check = (Button) findViewById(R.id.check);

        handler = new Handler();

        liquorAmount1.setSelection(0);
        liquorAmount2.setSelection(0);
        liquorAmount3.setSelection(0);
        //liquorAmount4.setSelection(0);
        //liquorAmount5.setSelection(0);
        //liquorAmount6.setSelection(0);
        //mixerAmount1.setSelection(0);
        //mixerAmount2.setSelection(0);
        liquor1.setText("");
        liquor2.setText("");
        liquor3.setText("");
        //liquor4.setText("");
        //liquor5.setText("");
        //liquor6.setText("");
        //mixer1.setText("");
        //mixer2.setText("");


        garnishDropdown.setSelection(0);

        result.setVisibility(View.GONE);
        check.setVisibility(View.VISIBLE);

        drink.setText(allDrinks[r.nextInt(allDrinks.length)]);
        //drink.setText("RED-HEADED SLUT");
        asked.add(drink.getText().toString());
        //prev = drink.getText().toString();
    }

    private ArrayList getAnswers()
    {
        ArrayList answers = new ArrayList();

        if (!liquor1.getText().toString().isEmpty())
        {
            answers.add(liquorAmount1.getSelectedItem().toString() + " oz " + liquor1.getText().toString().toLowerCase().trim());
        }


        if (!liquor2.getText().toString().isEmpty())
        {
            answers.add(liquorAmount2.getSelectedItem().toString() + " oz " + liquor2.getText().toString().toLowerCase().trim());
        }

        if (!liquor3.getText().toString().isEmpty())
        {
            answers.add(liquorAmount3.getSelectedItem().toString() + " oz " + liquor3.getText().toString().toLowerCase().trim());
        }

        answers.add(garnishDropdown.getSelectedItem().toString().toLowerCase());

        answers.add(topDropdown.getSelectedItem().toString().toLowerCase());


        return answers;
    }

    public ArrayList parseAnswer()
    {
        ArrayList ans = new ArrayList();

        String liq = liquor.get(drink.getText().toString().toLowerCase());
        if (liq.contains("&")) {
            String[] l = liq.split("&");

            for (int i = 0; i < l.length; i++)
            {
                l[i] = l[i].toLowerCase().trim();
                ans.add(l[i]);
            }
        }
        else
        {
            ans.add(liq.toLowerCase());
        }

        /*String mix = mixer.get(drink.getText().toString().toLowerCase());
        if (mix.contains("50/50"))
        {
            mix = mix.substring(6);
            String[] m = mix.split("&");
            m[0] = m[0].toLowerCase().trim();
            m[1] = m[1].toLowerCase().trim();
            ans.add("50% " + m[0]);
            ans.add("50% " + m[1]);
        }
        else
        {
            ans.add("100% " + mix.toLowerCase());
        }*/

        ans.add(garnish.get(drink.getText().toString().toLowerCase()).toLowerCase());

        ans.add(top.get(drink.getText().toString().toLowerCase()).toLowerCase());


        return ans;
    }

    public void checkAnswer(View v)
    {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }


        check.setVisibility(View.INVISIBLE);

        ArrayList correctAns = parseAnswer();
        Log.e("CORRECT", correctAns.toString());
        ArrayList guess = getAnswers();
        Log.e("GUESS", guess.toString());

        boolean cor = true;

        if (correctAns.size() != guess.size())
        {
            cor = false;
            result.setVisibility(View.VISIBLE);
            result.setText("WRONG!");
            result.setTextColor(Color.parseColor("#F60000"));
        }


        if (cor) {
            for (int i = 0; i < guess.size(); i++) {
                if (!correctAns.contains(guess.get(i))) {
                    Log.e("WRONG", guess.get(i).toString());
                    cor = false;
                    result.setVisibility(View.VISIBLE);
                    result.setText("WRONG!");
                    result.setTextColor(Color.parseColor("#F60000"));
                    break;
                }
            }
        }

        if (cor == false)
        {
            setCorrectAnswers();
        }
        else
        {
            result.setVisibility(View.VISIBLE);
            result.setText("CORRECT!");
            result.setTextColor(Color.parseColor("#00BF00"));
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                liquor1.setTextColor(Color.parseColor("#000000"));
                liquor2.setTextColor(Color.parseColor("#000000"));
                liquor3.setTextColor(Color.parseColor("#000000"));

                liquor1.setTypeface(Typeface.DEFAULT);
                liquor2.setTypeface(Typeface.DEFAULT);
                liquor3.setTypeface(Typeface.DEFAULT);


                liquorAmount1.setSelection(0);
                liquorAmount2.setSelection(0);
                liquorAmount3.setSelection(0);

                liquor1.setText("");
                liquor2.setText("");
                liquor3.setText("");


                garnishDropdown.setSelection(0);
                topDropdown.setSelection(0);

                result.setVisibility(View.GONE);
                check.setVisibility(View.VISIBLE);

                while (asked.contains(drink.getText().toString()) || asked.size() == 0) {
                    drink.setText(allDrinks[r.nextInt(allDrinks.length)]);
                }
                asked.add(drink.getText().toString());

                if (asked.size() == allDrinks.length)
                {
                    asked.clear();
                }


            }
        }, 6000);

    }

    private void setCorrectAnswers()
    {
        liquor1.setText("");
        liquor2.setText("");
        liquor3.setText("");

        liquorAmount1.setSelection(0);
        liquorAmount2.setSelection(0);
        liquorAmount3.setSelection(0);


        liquor1.setTextColor(Color.parseColor("#00BF00"));
        liquor1.setTypeface(Typeface.DEFAULT_BOLD);
        liquor2.setTextColor(Color.parseColor("#00BF00"));
        liquor2.setTypeface(Typeface.DEFAULT_BOLD);
        liquor3.setTextColor(Color.parseColor("#00BF00"));
        liquor3.setTypeface(Typeface.DEFAULT_BOLD);


        EditText[] liqs = {liquor1, liquor2, liquor3};
        Spinner[] ams = {liquorAmount1, liquorAmount2, liquorAmount3};
        String liq = liquor.get(drink.getText().toString().toLowerCase());
        if (liq.contains("&"))
        {
            String[] l = liq.split("&");

            for (int i = 0; i<l.length; i++)
            {
                String[] lS = l[i].split(" ");
                int idx = 0;

                for (int k = 0; k< lS.length; k++)
                {
                    idx += lS[k].length()+1;
                    if (lS[k].equals("oz"))
                    {
                        break;
                    }
                }
                liqs[i].setText(l[i].substring(idx).trim());

                if (l[i].contains("1 1/4"))
                {
                    ams[i].setSelection(2);
                }
                else if (l[i].contains("1 1/2"))
                {
                    ams[i].setSelection(1);
                }
                else if (l[i].contains("3/4"))
                {
                    ams[i].setSelection(3);
                }
                else if (l[i].contains("1/2"))
                {
                    ams[i].setSelection(5);
                }

            }

        }
        else
        {
            String[] lS = liq.split(" ");
            int idx = 0;
            for (int k = 0; k< lS.length; k++)
            {
                idx += lS[k].length()+1;
                if (lS[k].equals("oz"))
                {
                    break;
                }
            }
            liquor1.setText(liq.substring(idx).trim());
            liquorAmount1.setSelection(1);

            liquor2.setText("");
        }


        String garn = garnish.get(drink.getText().toString().toLowerCase()).toLowerCase();
        String[] g = new String[]{"None", "Splash Coke", "Splash Grenadine", "Splash Sprite"};
        for (int k = 0; k<g.length; k++)
        {
            if (g[k].toLowerCase().equals(garn.toLowerCase()))
            {
                garnishDropdown.setSelection(k);
                break;
            }
        }

        String t = top.get(drink.getText().toString().toLowerCase()).toLowerCase();
        for (int k = 0; k<topOp.length; k++)
        {
            if (topOp[k].toLowerCase().equals(t.toLowerCase()))
            {
                topDropdown.setSelection(k);
                break;
            }
        }
    }
}
