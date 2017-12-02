package cam.heloworld.rescuex;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Help extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{


    TextView sets;
    TextView friendz;
    TextView termz;
    TextView Policies;
    TextView Tipz;
    TextView emergencyz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_layout);
        sets=(TextView)findViewById(R.id.haccount);
        friendz=(TextView)findViewById(R.id.hfriends);
        termz=(TextView)findViewById(R.id.h_terms);
        Policies=(TextView)findViewById(R.id.hprivacy);
        Tipz=(TextView)findViewById(R.id.htips);
        emergencyz=(TextView)findViewById(R.id.halert);
        emergencyz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emergencyIntent= new Intent(Help.this, Safety.class);
                startActivity(emergencyIntent);
            }
        });
        Tipz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tipsIntent= new Intent(Help.this, Safety.class);
                startActivity(tipsIntent);
            }
        });
        Policies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent policyIntent = new Intent(Help.this, Privacy.class);
                startActivity(policyIntent);
            }
        });
        termz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent termzIntent= new Intent(Help.this, Terms.class);
                startActivity(termzIntent);
            }
        });
        friendz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent friengzIntent = new Intent(Help.this, About.class);
                startActivity(friengzIntent);
            }
        });
        sets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setsIntent= new Intent(Help.this, About.class);
                startActivity(setsIntent);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile_layout) {
            Intent searchIntent= new Intent(Help.this, Profile.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_users_activity) {
            Intent searchIntent = new Intent(Help.this, UsersActivity.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_history_layout) {
            Intent searchIntent= new Intent(Help.this, History.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_help_layout) {
            Intent searchIntent= new Intent(Help.this, Help.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_feedback_layout) {
            Intent searchIntent= new Intent(Help.this, Feedback.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_signout_layout) {
            Intent searchIntent= new Intent(Help.this, Singout.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        } else if (id == R.id.nav_friends_layout) {
            Intent searchIntent= new Intent(Help.this, Friends.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        } else if (id == R.id.nav_share) {
            Intent searchIntent= new Intent(Help.this, Share.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
