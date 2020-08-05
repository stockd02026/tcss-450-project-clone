package edu.tacoma.uw.jasonli7.team12project.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.tacoma.uw.jasonli7.team12project.R;
/**
 * Team 12 Group project.
 *
 * @author Daniel Stocksett.
 *
 * @version 3rd Aug 2020.
 *
 * An activity for adding new review data to the server.
 */
public class AddReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);
        AddReviewFragment fragment = new AddReviewFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.add_Review_fragment_id, fragment)
                .commit();
    }
    //--------------------------------------------------------
    //server calls go here.
}