package com.example.frances.ebs.other;

import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Frances on 4/10/2017.
 */

public class multipleChoice extends AppCompatActivity {

    String[] allDrinks = {"MARGARITA", "BLUE MARGARITA", "GOLD MARGARITA", "GRAND GOLD MARGARITA", "CADILAC MARGARITA", "MARTINI", "VODKA MARTINI", "DRY MARTINI", "BONE DRY MARTINI", "GIBSON", "GIMLET", "DIRTY MARTINI",
                          "MANHATTAN", "PERFECT MANHATTAN", "DRY MANHATTAN", "ROB ROY", "BASIC COSMOPOLITAN", "TOP SHELF COSMOPOLITAN", "APPLE MARTINI", "BASIC ESPRESSO MARTINI", "SIDECAR", "NEGRONI", "OLD FASHIONED", "MOJITO",
                          "MINT JULIP", "MOSCOW MULE", "HOT TODDY", "IRISH COFFEE", "KAMIKAZE(SHOOTER)", "WINDEX(SHOOTER)", "CHOCOLATE CAKE", "LEMON DROP", "CAPTAIN ON ACID(SHOOTER)", "APPLE SAUCE", "WASHINGTON APPLE(SHOOTER)",
                          "RED HEADED SLUT(SHOOTER)", "MIND ERASER", "ZIPPER HEAD"};

    Map<String, String> liquor = new HashMap<String, String>()
    {{
       put("margarita", "1 1/4 oz Tequila & 3/4 Triple Sec");
       put("blue margarita", "1 1/4 oz Tequila & 3/4 Blue Curacao");
       put("gold margarita", "1 1/4 oz Gold Tequila & 3/4 oz Triple Sec");
       put("grand gold margarita", "1 1/4 oz Gold Tequila & 3/4 oz Grand Marnier");
       put("cadilac margarita", "1 1/4 oz Gold Tequila & 3/4 oz Grand Marnier & 1/2 oz Chambord");
       put("martini", "2 1/2 oz Gin & 1/2 oz Dry Vermouth");
       put("vodka martini", "2 1/2 oz Vodka & 1/2 oz Dry Vermouth");
       put("dry martini", "2 3/4 oz Gin & 1/4 oz Dry Vermouth");
       put("bone dry martini", "3 oz Gin");
       put("gibson", "2 1/2 oz Gin & 1/2 oz Dry Vermouth");
       put("gimlet", "2 1/2 oz Gin");
       put("dirty martini", "2 1/2 oz Gin");
       put("manhattan", "2 1/2 oz Whiskey & 1/2 oz Sweet Vermouth");
       put("perfect manhattan", "2 1/2 oz Whiskey & 1/4 oz Sweet Vermouth & 1/4 oz Dry Vermouth");
       put("dry manhattan", "2 1/2 oz Whiskey & 1/2 oz Dry Vermouth");
       put("rob roy", "2 1/2 oz Scotch Whiskey & 1/2 oz Sweet Vermouth");
       put("old fashioned", "2 1/2 oz Whiskey");
       put("mojito", "1 oz Rum");
       put("mint julip", "2 1/2 oz Kentucky Bourbon");
       put("moscow mule", "1 1/2 oz Vodka");
       put("hot toddy", "1 oz Irish Whiskey");
       put("irish coffee", "1 oz Whiskey") ;
       put("basic cosmopolitan", "2 oz Vodka & 1 oz Triple Sec");
       put("top shelf cosmopolitan", "2 oz Absolute Citron & 1 oz Cointreau");
       put("apple martini", "2 oz Vodka & 1 oz Apple Pucker");
       put("basic espresso martini", "1 oz Vanilla Vodka & 1 oz Kahlua");
       put("sidecar", "2 oz Cognac & 1 oz Cointreau");
       put("negroni", "1 oz Campari & 1 oz Top Shelf Gin & 1 oz Sweet Vermouth");
       put("kamikaze(shooter)", "1/2 oz Vodka & 1/2 oz Triple Sec");
       put("windex(shooter)", "1/2 oz Vodka & 1/2 oz Blue Curacao");
       put("chocolate cake", "1/2 oz Citron & 1/2 oz Frangelico");
       put("lemon drop", "1 oz Citron");
       put("captain on acid(shooter)", "1/3 oz Captain Morgan & 1/3 oz Malibu Rum & 1/3 oz Blue Curacao");
       put("apple sauce", "1/2 oz Goldschlager & 1/2 oz Apple Pucker");
       put("washington apple(shooter)", "1/2 oz Crown Royal & 1/2 oz Apple Pucker");
       put("red headed slut(shooter)", "1/2 oz Peach Schnapps & 1/2 oz Jagermeister");
       put("mind eraser", "1/2 oz Vodka & 1/2 oz Kahlua");
       put("zipper head", "1/2 oz Vodka & 1/2 oz Chambord");
    }};

    Map<String, String> mixer = new HashMap<String, String>()
    {{
        put("margarita", "Sour Mix");
        put("blue margarita", "Sour Mix");
        put("gold margarita", "Sour Mix");
        put("grand gold margarita", "Sour Mix");
        put("cadilac margarita", "Sour Mix");
        put("martini", "");
        put("vodka martini", "");
        put("dry martini", "");
        put("bone dry martini", "");
        put("gibson", "");
        put("gimlet", "1/2 oz Lime Juice");
        put("dirty martini", "1/2 oz Olive Juice");
        put("manhattan", "");
        put("perfect manhattan", "");
        put("dry manhattan", "");
        put("rob roy", "");
        put("old fashioned", "2 dashes of bitters, 1 sugar cube");
        put("mojito", "1/2 oz simple syrup");
        put("mint julip", "1/2 oz simple syrup");
        put("moscow mule", "Ginger beer");
        put("hot toddy", "Hot water");
        put("irish coffee", "Coffee");
        put("basic cosmopolitan", "");
        put("top shelf cosmopolitan", "");
        put("apple martini", "");
        put("basic espresso martini", "cream");
        put("sidecar", "");
        put("negroni", "");
        put("kamikaze(shooter)", "");
        put("windex(shooter)", "");
        put("chocolate cake", "");
        put("lemon drop", "");
        put("captain on acid(shooter)", "");
        put("apple sauce", "");
        put("washington apple(shooter)", "");
        put("red headed slut(shooter)", "");
        put("mind eraser", "");
        put("zipper head", "");
    }};

    Map<String, String> garnish = new HashMap<String, String>()
    {{
        put("margarita", "Lime");
        put("blue margarita", "Lime");
        put("gold margarita", "Lime");
        put("grand gold margarita", "Lime");
        put("cadilac margarita", "Lime");
        put("martini", "Olive");
        put("vodka martini", "Olive");
        put("dry martini", "Olive");
        put("bone dry martini", "Olive");
        put("gibson", "Onions");
        put("gimlet", "Lime");
        put("dirty martini", "Olive");
        put("manhattan", "Cherry");
        put("perfect manhattan", "Cherry");
        put("dry manhattan", "Cherry");
        put("rob roy", "Cherry");
        put("old fashioned", "Orange and Cherry");
        put("mojito", "Lime and Mint");
        put("mint julip", "Lime and Mint");
        put("moscow mule", "Lime");
        put("hot toddy", "Lemon and Honey");
        put("irish coffee", "Heavy cream");
        put("basic cosmopolitan", "Lime");
        put("top shelf cosmopolitan", "Lime");
        put("apple martini", "");
        put("basic espresso martini", "Coffee Beans");
        put("sidecar", "Orange");
        put("negroni", "Orange Twist");
        put("kamikaze(shooter)", "");
        put("windex(shooter)", "");
        put("chocolate cake", "Sugar Lemon");
        put("lemon drop", "Sugar Lemon");
        put("captain on acid(shooter)", "");
        put("apple sauce", "");
        put("washington apple(shooter)", "");
        put("red headed slut(shooter)", "");
        put("mind eraser", "Big Straw");
        put("zipper head", "Big Straw");
    }};
}
