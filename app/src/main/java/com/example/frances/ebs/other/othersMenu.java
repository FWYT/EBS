package com.example.frances.ebs.other;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.frances.ebs.R;

/**
 * Created by Frances on 4/10/2017.
 */

public class othersMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highballmenu);

        ImageView pic = (ImageView) findViewById(R.id.glassPic);
        pic.setVisibility(View.GONE);
    }

    /*public void allDrinks(View v)
    {
        Intent myIntent = new Intent(othersMenu.this, allDrinks.class);
        othersMenu.this.startActivity(myIntent);
    }*/

    /*public void multipleChoice(View v)
    {
        Intent myIntent = new Intent(othersMenu.this, multipleChoice.class);
        othersMenu.this.startActivity(myIntent);
    }*/

    public void fillBlank(View v)
    {
        Intent myIntent = new Intent(othersMenu.this, fillBlank.class);
        othersMenu.this.startActivity(myIntent);
    }
}
