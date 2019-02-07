package uren.com.happysleepingbabies;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import uren.com.happysleepingbabies.Activities.MainContentActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fabric.with(this, new Crashlytics());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainContentActivity();
            }
        }, 3000);
    }

    private void startMainContentActivity(){
        Intent intent = new Intent(MainActivity.this, MainContentActivity.class);
        startActivity(intent);
        finish();
    }
}
