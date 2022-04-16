package com.example.a109590016_hw702;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Recepie extends AppCompatActivity {

    ActionBar actionBar;
    int pos;
    String fullReceipe;
    TextView mShowText;
    ImageView foodPic;
    int foodId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepie);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        pos = intent.getIntExtra("Position", 0);
        switch(pos){
            case 0:
                fullReceipe = "2 cups farro\n" +
                        "¾ pound fresh asparagus, trimmed\n" +
                        "1 cup red and yellow cherry tomatoes, halved\n" +
                        "¾ cup chopped walnuts\n" +
                        "¾ cup dried cranberries\n" +
                        "½ cup chopped fresh parsley\n" +
                        "⅓ cup chopped fresh chives\n" +
                        "¼ cup balsamic vinaigrette, or to taste\n" +
                        "1 cup shaved Parmesan cheese, divided";
                foodId = R.drawable.farro;
                break;
            case 1:
                fullReceipe = "4 cups strawberries, sliced\n" +
                        "1 cup white sugar\n" +
                        "8 cups cold water\n" +
                        "1 lime, cut into 8 wedges\n" +
                        "8 fresh mint sprigs";
                foodId = R.drawable.strawberry;
                break;
            case 2:
                fullReceipe = "2 whole artichokes\n" +
                        "2 tablespoons butter\n" +
                        "2 cloves garlic, sliced\n" +
                        "salt and pepper to taste";
                foodId = R.drawable.artichokes;
                break;
            case 3:
                fullReceipe = "¼ cup butter\n" +
                        "1 pound leeks, chopped\n" +
                        "1 onion, chopped\n" +
                        "2 quarts water\n" +
                        "3 large potatoes, chopped\n" +
                        "2 large carrots, chopped\n" +
                        "1 bunch fresh asparagus, trimmed and cut into 1 inch pieces\n" +
                        "⅓ cup uncooked long-grain white rice\n" +
                        "4 teaspoons salt\n" +
                        "½ pound fresh spinach\n" +
                        "1 cup heavy cream";
                foodId = R.drawable.soup;
                break;
            case 4:
                fullReceipe = "1 teaspoon butter\n" +
                        "1 tablespoon olive oil\n" +
                        "1 clove garlic, minced\n" +
                        "1 medium shallot, minced\n" +
                        "1 bunch fresh asparagus spears, trimmed\n" +
                        "¼ lime, juiced\n" +
                        "salt and pepper to taste";
                foodId = R.drawable.lime;
                break;
            case 5:
                fullReceipe = "white sugar, for rimming\n" +
                        "2 large limes, quartered\n" +
                        "½ bunch mint leaves\n" +
                        "7 strawberries, quartered\n" +
                        "1 cup white sugar\n" +
                        "1 cup white rum\n" +
                        "2 cups club soda\n" +
                        "8 cups ice cubes";
                foodId = R.drawable.mojito;
                break;
            case 6:
                fullReceipe = "1 cup raw peas\n" +
                        "½ lemon, juiced\n" +
                        "salt and ground black pepper to taste";
                foodId = R.drawable.salad;
                break;
            case 7:
                fullReceipe = "2 cups fresh strawberries, hulled and halved\n" +
                        "1 lemon, zested and juiced\n" +
                        "1 lemon, juiced\n" +
                        "¼ cup water\n" +
                        "2 tablespoons honey\n" +
                        "salt and cayenne pepper to taste\n" +
                        "¼ cup freshly sliced mint leaves";
                foodId = R.drawable.lamb;
                break;
            case 8:
                fullReceipe = "2 ounces rice vermicelli\n" +
                        "8 rice wrappers (8.5 inch diameter)\n" +
                        "8 large cooked shrimp - peeled, deveined and cut in half\n" +
                        "1 ⅓ tablespoons chopped fresh Thai basil\n" +
                        "3 tablespoons chopped fresh mint leaves\n" +
                        "3 tablespoons chopped fresh cilantro\n" +
                        "2 leaves lettuce, chopped\n" +
                        "4 teaspoons fish sauce\n" +
                        "¼ cup water\n" +
                        "2 tablespoons fresh lime juice\n" +
                        "1 clove garlic, minced\n" +
                        "2 tablespoons white sugar\n" +
                        "½ teaspoon garlic chili sauce\n" +
                        "3 tablespoons hoisin sauce\n" +
                        "1 teaspoon finely chopped peanuts";
                foodId = R.drawable.vietnamese;
                break;
            default:
                break;

        }
        mShowText = (TextView) findViewById(R.id.recepieText);
        mShowText.setText(fullReceipe);
        foodPic = (ImageView) findViewById(R.id.foodPic);
        foodPic.setImageResource(foodId);

    }
}