package com.example.frances.ebs.tall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.frances.ebs.R;

/**
 * Created by Frances on 3/21/2017.
 */

public class tallMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highballmenu);

        ImageView pic = (ImageView) findViewById(R.id.glassPic);
        pic.setVisibility(View.GONE);
    }

    public void allDrinks(View v)
    {
        Intent myIntent = new Intent(tallMenu.this, allDrinks.class);
        tallMenu.this.startActivity(myIntent);
    }

    public void multipleChoice(View v)
    {
        Intent myIntent = new Intent(tallMenu.this, multipleChoice.class);
        tallMenu.this.startActivity(myIntent);
    }

    public void fillBlank(View v)
    {
        Intent myIntent = new Intent(tallMenu.this, fillBlank.class);
        tallMenu.this.startActivity(myIntent);
    }
}
