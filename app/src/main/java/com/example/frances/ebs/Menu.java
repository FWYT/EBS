package com.example.frances.ebs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.frances.ebs.cordials.cordialsMenu;
import com.example.frances.ebs.highball.highballMenu;
import com.example.frances.ebs.other.othersMenu;
import com.example.frances.ebs.rocks.rocksMenu;
import com.example.frances.ebs.spirits.spiritsMenu;
import com.example.frances.ebs.tall.tallMenu;

public class Menu extends AppCompatActivity {
    //Button highball = (Button) findViewById(R.id.highball);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void highballMenu(View v)
    {
        //Toast.makeText(this, "Clicked on Button", Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(Menu.this, highballMenu.class);
        Menu.this.startActivity(myIntent);
    }

    public void tallMenu(View v)
    {
        //Toast.makeText(this, "Clicked on Button", Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(Menu.this, tallMenu.class);
        Menu.this.startActivity(myIntent);
    }

    public void rocksMenu(View v)
    {
        Intent myIntent = new Intent(Menu.this, rocksMenu.class);
        Menu.this.startActivity(myIntent);
    }

    public void spiritsMenu(View v)
    {
        Intent myIntent = new Intent(Menu.this, spiritsMenu.class);
        Menu.this.startActivity(myIntent);
    }

    public void cordialsMenu(View v)
    {
        Intent mI = new Intent(Menu.this, cordialsMenu.class);
        Menu.this.startActivity(mI);
    }

    public void othersMenu(View v)
    {
        Intent mI = new Intent(Menu.this, othersMenu.class);
        Menu.this.startActivity(mI);
    }

    public void allMenu(View v)
    {
        Intent mI = new Intent(Menu.this, allMixedDrinks.class);
        Menu.this.startActivity(mI);
    }
}
