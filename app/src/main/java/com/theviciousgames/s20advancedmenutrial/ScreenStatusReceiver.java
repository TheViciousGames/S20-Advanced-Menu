package com.theviciousgames.s20advancedmenutrial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenStatusReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF))
        {
            Tools.setRefreshRate(48);
        }
        else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON))
        {
            Tools.setRefreshRate(120);
        }
    }
}
