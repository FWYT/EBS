package com.example.frances.ebs.rocks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.frances.ebs.R;
import com.example.frances.ebs.tall.*;

/**
 * Created by Frances on 3/21/2017.
 */

public class rocksMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highballmenu);

        ImageView pic = (ImageView) findViewById(R.id.glassPic);
        pic.setVisibility(View.GONE);
    }

    public void allDrinks(View v)
    {
        Intent myIntent = new Intent(rocksMenu.this, allDrinks.class);
        rocksMenu.this.startActivity(myIntent);
    }

    public void multipleChoice(View v)
    {
        Intent myIntent = new Intent(rocksMenu.this, multipleChoice.class);
        rocksMenu.this.startActivity(myIntent);
    }

    public void fillBlank(View v)
    {
        Intent myIntent = new Intent(rocksMenu.this, fillBlank.class);
        rocksMenu.this.startActivity(myIntent);
    }

}
