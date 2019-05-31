package com.roman.tihai.hireme;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        OnclickListenerDelegate{

    private RecyclerView recyclerView;
    private CompanyAdapter companyAdapter;
    private ArrayList<Company> companyArrayList = new ArrayList<>();
    private Button expandBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        toolbar.setTitleTextColor(Color.WHITE);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("ALL JOBS"));
        tabLayout.addTab(tabLayout.newTab().setText("SENDED"));
        tabLayout.addTab(tabLayout.newTab().setText("RECEIVE"));

        FloatingActionButton fab = findViewById(R.id.fab);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String CompanyName = data.getStringExtra("CompanyName");
                String Email = data.getStringExtra("Email");
                String Date = data.getStringExtra("Date");
                String Link = data.getStringExtra("Link");
                String Info = data.getStringExtra("Info");
                String Status = data.getStringExtra("Status");

                Company company = new Company(CompanyName, Email, Date, Link, Info, Status);
                System.out.println(company.getCompanyName());
                System.out.println(company.getEmail());
                System.out.println(company.getDate());
                System.out.println(company.getLink());
                System.out.println(company.getInfo());
                System.out.println(company.getStatus());
                companyArrayList.add(company);
                companyAdapter.notifyDataSetChanged();
                Snackbar.make(findViewById(R.id.drawer_layout), CompanyName + ": Successfully added",
                        Snackbar.LENGTH_SHORT).show();
            }
        }

        if(requestCode == 10){
            if(resultCode == RESULT_FIRST_USER){
                String CompanyName = data.getStringExtra("CompanyName");
                String Email = data.getStringExtra("Email");
                String Date = data.getStringExtra("Date");
                String Link = data.getStringExtra("Link");
                String Info = data.getStringExtra("Info");
                String Status = data.getStringExtra("Status");
                int position = data.getIntExtra("Positions", 0);

                Company target = companyArrayList.get(position);

                target.setCompanyName(CompanyName);
                target.setEmail(Email);
                target.setDate(Date);
                target.setLink(Link);
                target.setInfo(Info);
                target.setStatus(Status);

                companyAdapter.notifyDataSetChanged();

                Snackbar.make(findViewById(R.id.drawer_layout), companyArrayList.get(position).getCompanyName() + ": Successfully Edited",
                        Snackbar.LENGTH_SHORT).show();
            }
            if(resultCode == RESULT_OK){
                int position = data.getIntExtra("Positions", 0);
                Snackbar.make(findViewById(R.id.drawer_layout), companyArrayList.get(position).getCompanyName() + ": Successfully Deleted",
                        Snackbar.LENGTH_SHORT).show();
                companyArrayList.remove(position);
                companyAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        companyAdapter = new CompanyAdapter(getApplicationContext(), companyArrayList, this);
        recyclerView.setAdapter(companyAdapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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

    public void onClick(View view) {
        Intent intent = new Intent(this, CreateCompanyActivity.class);
        startActivityForResult(intent, 0);
    }


    @Override
    public void onClickViewHolder(View view, int position) {

        String CompanyName = companyArrayList.get(position).getCompanyName().trim();
        String Email = companyArrayList.get(position).getEmail().trim();
        String Date = companyArrayList.get(position).getDate().trim();
        String Link = companyArrayList.get(position).getLink().trim();
        String Info = companyArrayList.get(position).getInfo().trim();
        String Status = companyArrayList.get(position).getStatus().trim();

        Intent intent = new Intent(this, InfoCompany.class);

        intent.putParcelableArrayListExtra("Companies", companyArrayList);
        intent.putExtra("Position", position);

        intent.putExtra("CompanyName", CompanyName);
        intent.putExtra("Email", Email);
        intent.putExtra("Date", Date);
        intent.putExtra("Link", Link);
        intent.putExtra("info", Info);
        intent.putExtra("Status", Status);

        startActivityForResult(intent, 10);
    }
}
