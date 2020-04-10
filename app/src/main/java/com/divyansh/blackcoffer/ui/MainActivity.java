package com.divyansh.blackcoffer.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;

import com.divyansh.blackcoffer.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(Html.fromHtml("<font color=\"grey\">#tags<br>Golf Course Road, Delhi</font>"));

        dl = findViewById(R.id.activity_main_drawer);
        t = new ActionBarDrawerToggle(this, dl, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        dl.addDrawerListener(t);
        t.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorPrimaryGreyDark));
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TagsFragment tagsFragment = new TagsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.native_host_fragment, tagsFragment).commit();

        nv = findViewById(R.id.nv);
        nv.bringToFront();
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                switch(id) {
                    case R.id.nav_dashboard:
                        break;
                    case R.id.create_events:
                        break;
                }

                return true;
            }
        });

        bottomNav = findViewById(R.id.navigation_bottom);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch(id) {
                    case R.id.tags:
                        item.setChecked(true);
                        setTitle(Html.fromHtml("<font color=\"grey\">#tags<br>Golf Course Road, Delhi</font>"));
                        TagsFragment tagsFragment = new TagsFragment();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.native_host_fragment, tagsFragment).commit();
                        break;
                    case R.id.trending:
                        item.setChecked(true);
                        setTitle(Html.fromHtml("<font color=\"grey\">Trending</font>"));
                        TagsFragment tagsFragment1 = new TagsFragment();
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        fragmentManager1.beginTransaction().replace(R.id.native_host_fragment, tagsFragment1).commit();
                        break;
                    case R.id.explore:
                        item.setChecked(true);
                        setTitle(Html.fromHtml("<font color=\"grey\">Explore</font>"));
                        TagsFragment tagsFragment2 = new TagsFragment();
                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        fragmentManager2.beginTransaction().replace(R.id.native_host_fragment, tagsFragment2).commit();
                        break;
                    case R.id.saved:
                        item.setChecked(true);
                        setTitle(Html.fromHtml("<font color=\"grey\">Saved</font>"));
                        TagsFragment tagsFragment3 = new TagsFragment();
                        FragmentManager fragmentManager3 = getSupportFragmentManager();
                        fragmentManager3.beginTransaction().replace(R.id.native_host_fragment, tagsFragment3).commit();
                        break;
                }

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.notif) {
            // do something
        }

        return super.onOptionsItemSelected(item);
    }
}
