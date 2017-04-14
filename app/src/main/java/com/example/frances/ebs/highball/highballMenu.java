package com.example.frances.ebs.highball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.frances.ebs.Menu;
import com.example.frances.ebs.R;

/**
 * Created by Frances on 2/26/2017.
 */

public class highballMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highballmenu);
    }

    public void allDrinks(View v)
    {
        Intent myIntent = new Intent(highballMenu.this, allDrinks.class);
        highballMenu.this.startActivity(myIntent);
    }

    public void multipleChoice(View v)
    {
        Intent myIntent = new Intent(highballMenu.this, multipleChoice.class);
        highballMenu.this.startActivity(myIntent);
    }

    public void fillBlank(View v)
    {
        Intent myIntent = new Intent(highballMenu.this, fillBlank.class);
        highballMenu.this.startActivity(myIntent);
    }

}
