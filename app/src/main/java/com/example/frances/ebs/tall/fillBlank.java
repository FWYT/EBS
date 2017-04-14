package com.example.frances.ebs.tall;

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
import android.widget.Spinner;
import android.widget.TextView;

import com.example.frances.ebs.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Frances on 3/21/2017.
 */

public class fillBlank extends AppCompatActivity {

    Spinner mixerAmount1, mixerAmount2, garnishDropdown, liquorAmount1, liquorAmount2, liquorAmount3, liquorAmount4, liquorAmount5, liquorAmount6, topDropdown;
    EditText liquor1, liquor2, liquor3, liquor4, liquor5, liquor6, mixer1, mixer2;
    TextView drink, result;
    Button check;

    String[] allDrinks = {"ORGASM", "ALABAMA SLAMMER", "CAPTAIN ON ACID", "SCREAMING ORGASM", "RUSSIAN QUALUDE", "CALIFORNIA LEMONADE", "LONG ISLAND ICE TEA", "LONG BEACH ICE TEA", "ELECTRIC LEMONADE", "GRATEFUL DEAD",
            "NUCLEAR TEA", "ADIOS M.F."};

    Map<String, String> liquor = new HashMap<String, String>()
    {{
        put("orgasm", "1/2 oz Kahlua & 1/2 oz Baileys & 1/2 oz Amaretto");
        put("alabama slammer", "1/2 oz Amaretto & 1/2 oz Southern Comfort & 1/2 oz Sloe Gin");
        put("captain on acid", "1/2 oz Captain Morgan & 1/2 oz Malibu Rum & 1/2 oz Blue Curacao");
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

    Map<String, String> top = new HashMap<String, String>()
    {{
        put("orgasm", "None");
        put("alabama slammer", "Orange");
        put("captain on acid", "None");
        put("screaming orgasm", "None");
        put("russian qualude", "None");
        put("california lemonade", "Lemon");
        put("long island ice tea", "Lemon");
        put("long beach ice tea", "Lemon");
        put("electric lemonade", "Lemon");
        put("grateful dead", "Lemon");
        put("nuclear tea", "Lemon");
        put("adios m.f.", "Lemon");
    }};

    String[] topOp = new String[]{"None", "Orange", "Lemon", "Lime", "Lemon Twist", "Mint Leaf", "Cherry", "Orange and Cherry", "Olive"};

    ArrayList asked = new ArrayList();
    Handler handler;
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fillblank);

        mixerAmount1 = (Spinner)findViewById(R.id.mixerAmount1);
        String[] items = new String[]{"", "100%", "50%"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        mixerAmount1.setAdapter(adapter);

        mixerAmount2 = (Spinner)findViewById(R.id.mixerAmount2);
        mixerAmount2.setAdapter(adapter);

        garnishDropdown = (Spinner)findViewById(R.id.garnishDropdown);
        String[] g = new String[]{"None", "Splash Coke", "Splash Grenadine", "Splash Sprite"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, g);
        garnishDropdown.setAdapter(adapter2);

        topDropdown = (Spinner)findViewById(R.id.topDropdown);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, topOp);
        topDropdown.setAdapter(adapter4);

        liquorAmount1 = (Spinner) findViewById(R.id.liquorAmount1);
        liquorAmount2 = (Spinner) findViewById(R.id.liquorAmount2);
        liquorAmount3 = (Spinner) findViewById(R.id.liquorAmount3);
        liquorAmount4 = (Spinner) findViewById(R.id.liquorAmount4);
        liquorAmount5 = (Spinner) findViewById(R.id.liquorAmount5);
        liquorAmount6 = (Spinner) findViewById(R.id.liquorAmount6);
        String[] amount = new String[]{"", "1", "1/2", "1/4"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, amount);
        liquorAmount1.setAdapter(adapter3);
        liquorAmount2.setAdapter(adapter3);
        liquorAmount3.setAdapter(adapter3);
        liquorAmount4.setAdapter(adapter3);
        liquorAmount5.setAdapter(adapter3);
        liquorAmount6.setAdapter(adapter3);

        liquor1 = (EditText) findViewById(R.id.liquor1);
        liquor2 = (EditText) findViewById(R.id.liquor2);
        liquor3 = (EditText) findViewById(R.id.liquor3);
        liquor4 = (EditText) findViewById(R.id.liquor4);
        liquor5 = (EditText) findViewById(R.id.liquor5);
        liquor6 = (EditText) findViewById(R.id.liquor6);
        mixer1 = (EditText) findViewById(R.id.mixer1);
        mixer2 = (EditText) findViewById(R.id.mixer2);
        drink = (TextView) findViewById(R.id.drink);
        result = (TextView) findViewById(R.id.result);
        check = (Button) findViewById(R.id.check);

        handler = new Handler();

        liquorAmount1.setSelection(0);
        liquorAmount2.setSelection(0);
        liquorAmount3.setSelection(0);
        liquorAmount4.setSelection(0);
        liquorAmount5.setSelection(0);
        liquorAmount6.setSelection(0);
        mixerAmount1.setSelection(0);
        mixerAmount2.setSelection(0);
        liquor1.setText("");
        liquor2.setText("");
        liquor3.setText("");
        liquor4.setText("");
        liquor5.setText("");
        liquor6.setText("");
        mixer1.setText("");
        mixer2.setText("");


        garnishDropdown.setSelection(0);

        result.setVisibility(View.GONE);
        check.setVisibility(View.VISIBLE);

        drink.setText(allDrinks[r.nextInt(allDrinks.length)]);
        //drink.setText("CAPTAIN ON ACID");
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

        if (!liquor4.getText().toString().isEmpty())
        {
            answers.add(liquorAmount4.getSelectedItem().toString() + " oz " + liquor4.getText().toString().toLowerCase().trim());
        }

        if (!liquor5.getText().toString().isEmpty())
        {
            answers.add(liquorAmount5.getSelectedItem().toString() + " oz " + liquor5.getText().toString().toLowerCase().trim());
        }

        if (!liquor6.getText().toString().isEmpty())
        {
            answers.add(liquorAmount6.getSelectedItem().toString() + " oz " + liquor6.getText().toString().toLowerCase().trim());
        }

        if (!mixer1.getText().toString().isEmpty())
        {
            answers.add(mixerAmount1.getSelectedItem().toString() + " " + mixer1.getText().toString().toLowerCase().trim());
        }

        if (!mixer2.getText().toString().isEmpty())
        {
            answers.add(mixerAmount2.getSelectedItem().toString() + " " + mixer2.getText().toString().toLowerCase().trim());
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

        String mix = mixer.get(drink.getText().toString().toLowerCase());
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
        }

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
                liquor4.setTextColor(Color.parseColor("#000000"));
                liquor5.setTextColor(Color.parseColor("#000000"));
                liquor6.setTextColor(Color.parseColor("#000000"));
                mixer1.setTextColor(Color.parseColor("#000000"));
                mixer2.setTextColor(Color.parseColor("#000000"));

                liquor1.setTypeface(Typeface.DEFAULT);
                liquor2.setTypeface(Typeface.DEFAULT);
                liquor3.setTypeface(Typeface.DEFAULT);
                liquor4.setTypeface(Typeface.DEFAULT);
                liquor5.setTypeface(Typeface.DEFAULT);
                liquor6.setTypeface(Typeface.DEFAULT);
                mixer1.setTypeface(Typeface.DEFAULT);
                mixer2.setTypeface(Typeface.DEFAULT);

                liquorAmount1.setSelection(0);
                liquorAmount2.setSelection(0);
                liquorAmount3.setSelection(0);
                liquorAmount4.setSelection(0);
                liquorAmount5.setSelection(0);
                liquorAmount6.setSelection(0);
                mixerAmount1.setSelection(0);
                mixerAmount2.setSelection(0);
                liquor1.setText("");
                liquor2.setText("");
                liquor3.setText("");
                liquor4.setText("");
                liquor5.setText("");
                liquor6.setText("");
                mixer1.setText("");
                mixer2.setText("");


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
        liquor4.setText("");
        liquor5.setText("");
        liquor6.setText("");
        mixer1.setText("");
        mixer2.setText("");
        mixerAmount1.setSelection(0);
        mixerAmount2.setSelection(0);
        liquorAmount1.setSelection(0);
        liquorAmount2.setSelection(0);
        liquorAmount3.setSelection(0);
        liquorAmount4.setSelection(0);
        liquorAmount5.setSelection(0);
        liquorAmount6.setSelection(0);

        liquor1.setTextColor(Color.parseColor("#00BF00"));
        liquor1.setTypeface(Typeface.DEFAULT_BOLD);
        liquor2.setTextColor(Color.parseColor("#00BF00"));
        liquor2.setTypeface(Typeface.DEFAULT_BOLD);
        liquor3.setTextColor(Color.parseColor("#00BF00"));
        liquor3.setTypeface(Typeface.DEFAULT_BOLD);
        liquor4.setTextColor(Color.parseColor("#00BF00"));
        liquor4.setTypeface(Typeface.DEFAULT_BOLD);
        liquor5.setTextColor(Color.parseColor("#00BF00"));
        liquor5.setTypeface(Typeface.DEFAULT_BOLD);
        liquor6.setTextColor(Color.parseColor("#00BF00"));
        liquor6.setTypeface(Typeface.DEFAULT_BOLD);
        mixer1.setTextColor(Color.parseColor("#00BF00"));
        mixer1.setTypeface(Typeface.DEFAULT_BOLD);
        mixer2.setTextColor(Color.parseColor("#00BF00"));
        mixer2.setTypeface(Typeface.DEFAULT_BOLD);

        EditText[] liqs = {liquor1, liquor2, liquor3, liquor4, liquor5, liquor6};
        Spinner[] ams = {liquorAmount1, liquorAmount2, liquorAmount3, liquorAmount4, liquorAmount5, liquorAmount6};
        String liq = liquor.get(drink.getText().toString().toLowerCase());
        if (liq.contains("&"))
        {
            String[] l = liq.split("&");

            for (int i = 0; i<l.length; i++)
            {
                liqs[i].setText(l[i].substring(7).trim());

                if (l[i].contains("1/4"))
                {
                    ams[i].setSelection(3);
                }
                else if (l[i].contains("1/2"))
                {
                    ams[i].setSelection(2);
                }
                else if (l[i].contains("1"))
                {
                    ams[i].setSelection(1);
                }

            }

        }
        else
        {
            liquor1.setText(liq.substring(5).trim());
            liquorAmount1.setSelection(1);

            liquor2.setText("");
        }

        String mix = mixer.get(drink.getText().toString().toLowerCase());
        if (mix.contains("50/50"))
        {
            mix = mix.substring(6);
            String[] m = mix.split("&");

            mixer1.setText(m[0].trim());
            mixer2.setText(m[1].trim());
            mixerAmount1.setSelection(2);
            mixerAmount2.setSelection(2);
        }
        else
        {
            mixer1.setText(mix);
            mixerAmount1.setSelection(1);
            mixer2.setText("");
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
