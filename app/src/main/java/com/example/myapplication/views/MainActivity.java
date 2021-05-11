package com.example.myapplication.views;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.utilities.Utils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity {
    String TOKEN = null;
    Integer ID = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CatalogueFragment()).commit();
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav=findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navlistner);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_person_30);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().getExtras()!=null) {
            TOKEN = getIntent().getExtras().get("TOKEN").toString();
            ID = getIntent().getExtras().getInt("ID");
        }

        OnClickListener oclBtnOk = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        };
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    FavouritesFragment favFragment;
                    switch(item.getItemId()){
                        case R.id.nav_favourites:
                            selectedFragment = new FavouritesFragment();
                            break;
                        case R.id.nav_rooms:
                            selectedFragment = new RoomsFragment();
                            break;
                        case R.id.nav_catalogue:
                            selectedFragment = new CatalogueFragment();
                            break;
                        case R.id.nav_messeges:
                            selectedFragment = new SupportFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                    return true;
                }

            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        final MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) search.getActionView();
        HideKeyboardSearch(searchView);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("TOKEN", TOKEN);
                intent.putExtra("ID", ID);
                startActivity(intent);
                break;
        }
        return true;
    }
}