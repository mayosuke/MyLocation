package jp.mayosuke.android.mylocation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

public class LocationReceiver extends BroadcastReceiver {
    private static final String TAG = LocationReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive():intent=" + intent);
        if (intent.hasExtra(LocationManager.KEY_LOCATION_CHANGED)) {
            final Location location = intent.getParcelableExtra(LocationManager.KEY_LOCATION_CHANGED);
            Log.d(TAG, "  location=" + location);
        }
        if (intent.hasExtra(LocationManager.KEY_PROVIDER_ENABLED)) {
            final boolean isProviderEnabled = intent.getBooleanExtra(LocationManager.KEY_PROVIDER_ENABLED, false);
            Log.d(TAG, "  providerEnabled=" + isProviderEnabled);
        }
        if (intent.hasExtra(LocationManager.KEY_STATUS_CHANGED)) {
            final int status = intent.getIntExtra(LocationManager.KEY_STATUS_CHANGED, -1);
            Log.d(TAG, "  status=" + status);
        }
    }
    
}
