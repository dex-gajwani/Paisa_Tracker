package com.example.paisatracker;

import android.os.Bundle;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;

import com.google.android.material.navigation.NavigationView;

public class main_page extends AppCompatActivity {

    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    private Toolbar supportActionBar;
    View navigation;
    income income;
    home home;
    expense expense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        androidx.appcompat.widget.Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav_menu);
        drawerLayout = findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this , drawerLayout , toolbar ,  R.string.open , R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigation = findViewById(R.id.fragment_nav);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        Toast.makeText(getApplicationContext() , "HOME" , Toast.LENGTH_SHORT).show();
                        home = new home();
                        open_frag(home);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_income:
                        Toast.makeText(getApplicationContext() , "INCOME" , Toast.LENGTH_SHORT).show();
                        income = new income();
                        open_frag(income);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_expense:
                        Toast.makeText(getApplicationContext() , "EXPENSE" , Toast.LENGTH_SHORT).show();
                        expense = new expense();
                        open_frag(expense);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
    }

    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }

    public void open_frag(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.frag_cont , fragment)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }
}