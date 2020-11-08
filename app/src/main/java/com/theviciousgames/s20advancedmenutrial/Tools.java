package com.theviciousgames.s20advancedmenutrial;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Tools extends AppCompatActivity {
    public static void createToast(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void setResolution(String val) {
        Device.Screen.Resolution.setResolution(val);
    }

    public static void setRefreshRate(int val) {
        Device.Screen.RefreshRate.setRefreshRate(val);
    }

    public static int getRefreshRate(Activity activity) {
        if (Device.Screen.RefreshRate.getRefreshRate(activity).contains("48")) {
            return 48;
        } else if (Device.Screen.RefreshRate.getRefreshRate(activity).contains("60")) {
            return 60;
        } else if (Device.Screen.RefreshRate.getRefreshRate(activity).contains("96")) {
            return 96;
        } else {
            return 120;
        }
    }

    public static String getResolution(Activity activity) {
        if (Device.Screen.Resolution.getVerticalPixel(activity) == Resources.SCREEN_RESOLUTION_VERTICAL_PIXELS_HD) {
            return "HD";
        } else if (Device.Screen.Resolution.getVerticalPixel(activity) == Resources.SCREEN_RESOLUTION_VERTICAL_PIXELS_FHD) {
            return "FHD";
        } else if (Device.Screen.Resolution.getVerticalPixel(activity) == Resources.SCREEN_RESOLUTION_VERTICAL_PIXELS_WQHD) {
            return "WQHD";
        } else {
            return "CUSTOM";
        }
    }

    public static boolean getPowerSaverStatus() {
        return Device.Power.getPowerMode();
    }

    public static boolean getADBStatus() {
        return Device.Other.getADBStatus();
    }

    public static void setADBStatus(boolean status) {
        if (status) {
            Device.Other.setADBStatus(true);
        } else {
            Device.Other.setADBStatus(false);
        }
    }

    public static String reboot(String mode) {
        if (mode.equals("1")) {
            return Device.Other.reboot("1");
        } else if (mode.equals("2")) {
            return Device.Other.reboot("2");
        } else {
            return Device.Other.reboot("3");
        }
    }
}
