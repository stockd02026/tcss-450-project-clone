package edu.tacoma.uw.jasonli7.team12project.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.tacoma.uw.jasonli7.team12project.R;

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
}