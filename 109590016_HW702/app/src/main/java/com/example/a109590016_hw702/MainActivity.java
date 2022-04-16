package com.example.a109590016_hw702;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a109590016_hw702.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> name = new LinkedList<>();
    private final LinkedList<String> description = new LinkedList<>();
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        name.addLast("Farro Salad with Asparagus and Parmesan");
        name.addLast("Mexican Strawberry Water (Agua de Fresa)");
        name.addLast("Artichokes");
        name.addLast("French Spring Soup");
        name.addLast("Garlic Asparagus with Lime");
        name.addLast("Strawberry Mojito");
        name.addLast("Lemon Pea Salad");
        name.addLast("Rack of Lamb with Strawberry Mint Sauce");
        name.addLast("Vietnamese Fresh Spring Rolls");

        description.addLast("A light and delicious way to get your whole grains. Perfect salad for picnics, baby or bridal showers or just because!");
        description.addLast("Fresh fruit waters, or Aguas de Frutas, made with crushed or blended fruit are a common and popular drink all over Mexico. This recipe is extremely flavorful and refreshing, especially when fresh strawberries are in season.");
        description.addLast("Simple and delicious steamed artichokes. Serve these with melted butter for dipping. You will need a pan with a steamer insert.");
        description.addLast("I make this during asparagus season when my husband's patch is producing a lot. It is very fresh tasting, and the longer it sits, the better it is.");
        description.addLast("This fresh tasting asparagus dish is always popular. Try it with Havarti or Swiss cheese melted on top.");
        description.addLast("I had this drink at a popular chain restaurant and decided to try it at home. I have served it at a couple different gatherings now and it has always been given rave reviews. It's the perfect drink for a hot summer day!");
        description.addLast("It's my favorite dish on a hot summer day.");
        description.addLast("As far as mint sauces go, I love experimenting with new ideas, especially around Easter time, and I really liked how this came out. The combination of the sweet-savory sauce and the Dijon crumb crust complemented the lamb perfectly.");
        description.addLast("These spring rolls are a refreshing change from the usual fried variety, and have become a family favorite. They are great as a cool summertime appetizer, and are delicious dipped in one or both of the sauces.");
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new WordListAdapter(this, name, description);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}