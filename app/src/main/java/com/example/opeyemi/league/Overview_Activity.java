package com.example.opeyemi.league;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Overview_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview_);

        TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
        ViewPager pager = (ViewPager)findViewById(R.id.pager);

        setViewPager(pager);
        tabs.setupWithViewPager(pager);

    }

    private void setViewPager(ViewPager pager){
        ViewPagerAdapter adapter =new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TipsFragment(),"Tips");
        adapter.addFragment(new SpellFragment(),"Spells");
        adapter.addFragment(new LoreFragment(),"Lore");

        pager.setAdapter(adapter);
    }
}
