package com.example.frances.ebs.cordials;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.frances.ebs.R;

/**
 * Created by Frances on 4/10/2017.
 */

public class cordialsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highballmenu);

        ImageView pic = (ImageView) findViewById(R.id.glassPic);
        pic.setVisibility(View.GONE);

        Button fill = (Button) findViewById(R.id.guessDrink);
        fill.setVisibility(View.GONE);
    }

    public void allDrinks(View v)
    {
        Intent myIntent = new Intent(cordialsMenu.this, allDrinks.class);
        cordialsMenu.this.startActivity(myIntent);
    }

    public void multipleChoice(View v)
    {
        Intent myIntent = new Intent(cordialsMenu.this, multipleChoice.class);
        cordialsMenu.this.startActivity(myIntent);
    }
}
