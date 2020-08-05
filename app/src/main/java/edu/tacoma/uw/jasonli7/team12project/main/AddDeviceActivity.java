package edu.tacoma.uw.jasonli7.team12project.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.tacoma.uw.jasonli7.team12project.R;
import edu.tacoma.uw.jasonli7.team12project.authenticate.LoginFragment;

public class AddDeviceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);
        AddDeviceFragment fragment = new AddDeviceFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.add_Device_fragment_id, fragment)
                .commit();
    }
}