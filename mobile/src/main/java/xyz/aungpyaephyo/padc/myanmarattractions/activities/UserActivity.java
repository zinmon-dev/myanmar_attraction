package xyz.aungpyaephyo.padc.myanmarattractions.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import xyz.aungpyaephyo.padc.myanmarattractions.R;
import xyz.aungpyaephyo.padc.myanmarattractions.fragments.RegisterFragment;
import xyz.aungpyaephyo.padc.myanmarattractions.fragments.UserActivityFragment;
import xyz.aungpyaephyo.padc.myanmarattractions.utils.MyanmarAttractionsConstants;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if(MyanmarAttractionsConstants.GO_TO_FORM ==2){

            RegisterFragment fragment = new RegisterFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container,fragment)
                    .commit();
        }
        else {
            UserActivityFragment logfragment = new UserActivityFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, logfragment)
                    .commit();

            if (findViewById(R.id.fl_container_2) != null) {
                RegisterFragment fragment = new RegisterFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_container_2, fragment)
                        .commit();
            }
        }
    }

}
