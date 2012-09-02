package jp.mayosuke.android.mylocation;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mTextView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView1 = (TextView) findViewById(R.id.textView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_get_location:
            getCurrentLocation();
            break;
        case R.id.menu_start_auto_logging:
            startAutoLogging();
            break;
        case R.id.menu_settings:
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getCurrentLocation() {
        Log.d(TAG, "getCurrentLocation()");
        mTextView1.setText("現在位置を取得しています・・・\n");
        final LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//        final Location lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//        if (lastLocation != null) {
//            mTextView1.append("最後に取得した位置：" + lastLocation.toString() + "\n");
//        }
//        final LocationListener locationListener = new LocationListener() {
//            @Override
//            public void onLocationChanged(Location location) {
//                Log.d(TAG, "getCurrentLocation().locationListener.onLocationChanged():location=" + location.toString());
//                mTextView1.append("現在位置：" + location.toString() + "\n");
//            }
//            @Override
//            public void onStatusChanged(String provider, int status, Bundle extras) {
//                Log.d(TAG, "getCurrentLocation().locationListener.onStatusChanged():provider=" + provider + ",status=" + status + ",extras=" + extras);
//            }
//            @Override
//            public void onProviderEnabled(String provider) {
//                Log.d(TAG, "getCurrentLocation().locationListener.onProviderEnabled():provider=" + provider);
//            }
//            @Override
//            public void onProviderDisabled(String provider) {
//                Log.d(TAG, "getCurrentLocation().locationListener.onProviderDisabled():provider=" + provider);
//            }
//        };
        final Intent intent = new Intent();
        intent.setAction("jp.mayosuke.android.mylocation.action.LOCATION_CHANGED");
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER, pendingIntent);
//        locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER, locationListener, null);
//        locationManager.removeUpdates(locationListener);
    }

    private void startAutoLogging() {
        Log.d(TAG, "startAutoLogging()");
    }
}
