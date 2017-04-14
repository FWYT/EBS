package com.example.frances.ebs.spirits;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.frances.ebs.R;
import com.example.frances.ebs.rocks.*;

/**
 * Created by Frances on 3/29/2017.
 */

public class spiritsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highballmenu);

        ImageView pic = (ImageView) findViewById(R.id.glassPic);
        pic.setVisibility(View.GONE);
    }

    public void allDrinks(View v)
    {
        Intent myIntent = new Intent(spiritsMenu.this, spiritsList.class);
        spiritsMenu.this.startActivity(myIntent);
    }

    public void multipleChoice(View v)
    {
        Intent myIntent = new Intent(spiritsMenu.this, multipleChoice.class);
        spiritsMenu.this.startActivity(myIntent);
    }

    public void fillBlank(View v)
    {
        Intent myIntent = new Intent(spiritsMenu.this, fillBlank.class);
        spiritsMenu.this.startActivity(myIntent);
    }
}
