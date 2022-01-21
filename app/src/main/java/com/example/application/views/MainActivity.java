package com.example.application.views;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.application.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends BaseActivity {
    String TOKEN = null;
    Integer ID = null;

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Activity Creation Pipeline (Don't try to change the sequence of methods, it can result in nullpointerexecpetion at runtime)
        setupSystemInterfaceTools();
        findViews();
        checkExtras();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navlistner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @SuppressLint("NonConstantResourceId")
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
                createProfileIntenetion();
                break;
        }
        return true;
    }

    private void createProfileIntenetion() {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        intent.putExtra("TOKEN", TOKEN);
        intent.putExtra("ID", ID);
        startActivity(intent);
    }

    private void findViews() {
        bottomNav=findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navlistner);
    }

    private void setupSystemInterfaceTools(){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CatalogueFragment()).commit();
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_baseline_person_30);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void checkExtras() {
        if (getIntent().getExtras()!=null) {
            TOKEN = getIntent().getExtras().get("TOKEN").toString();
            ID = getIntent().getExtras().getInt("ID");
        }
    }
}