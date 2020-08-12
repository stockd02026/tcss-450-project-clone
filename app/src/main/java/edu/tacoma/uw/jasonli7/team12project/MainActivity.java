package edu.tacoma.uw.jasonli7.team12project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import edu.tacoma.uw.jasonli7.team12project.authenticate.RegisterActivity;
import edu.tacoma.uw.jasonli7.team12project.authenticate.SignInActivity;
/**
 * Team 12 Group project.
 *
 * @author Daniel Stocksett.
 *
 * @version 3rd Aug 2020.
 *
 * A Point of entry activity that connects to SignInActivity and RegisterActivity.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mLoginButton;
    Button mRegButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.top);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        toolbar.setTitle("iRate");

        mLoginButton =findViewById(R.id.login);
        mLoginButton.setOnClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    /**
     * Go to SignInActivity
     *
     * @param view
     */
    @Override
public void onClick(View view) {
        if (view.getId() == R.id.login) {

            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
            finish();

        }
    }

    /**
     * Go to RegisterActivity.
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            SharedPreferences sharedPreferences =
                    getSharedPreferences(getString(R.string.LOGIN_PREFS), Context.MODE_PRIVATE);
            sharedPreferences.edit().putBoolean(getString(R.string.LOGGEDIN), false)
                    .commit();

            Intent i = new Intent(this, RegisterActivity.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}