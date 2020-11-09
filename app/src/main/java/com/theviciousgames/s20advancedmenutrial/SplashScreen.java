package com.theviciousgames.s20advancedmenutrial;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SplashScreen extends AppCompatActivity {

    private int refreshRate;
    private String resolution;
    private Boolean adaptiveRefreshRateStatus, powerSaverStatus, adbStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        startMainActivity();

    }

    protected void startMainActivity() {
        final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable = new Runnable() {
            public void run() {
                getInformation();
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                intent.putExtra("Resolution", resolution);
                intent.putExtra("RefreshRate", refreshRate);
                intent.putExtra("AdaptiveRefreshRate", adaptiveRefreshRateStatus);
                intent.putExtra("PowerSaverStatus", powerSaverStatus);
                intent.putExtra("ADBStatus", adbStatus);
                startActivity(intent);
                finish();
            }
        };
        worker.schedule(runnable, 1, TimeUnit.SECONDS);
    }

    protected void getInformation() {
        refreshRate = Tools.getRefreshRate(SplashScreen.this);
        resolution = Tools.getResolution(SplashScreen.this);
        adaptiveRefreshRateStatus = false;
        powerSaverStatus = Tools.getPowerSaverStatus();
        adbStatus = Tools.getADBStatus();

    }
}