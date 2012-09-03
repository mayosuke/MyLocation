package jp.mayosuke.android.mylocation;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.ContentObserver;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mTextView1;

    private static final Uri URI = Uri.parse(LocationProvider.AUTHORITY);
    private final ContentObserver mObserver = new ContentObserver(null) {
        @Override
        public void onChange(boolean selfChange, Uri uri) {
            Log.d(TAG, "mObserver.onChange():selfChange=" + selfChange + ",uri=" + uri);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate():savedInstanceState=" + savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView1 = (TextView) findViewById(R.id.textView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu()");
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume()");

        getContentResolver().registerContentObserver(URI, true, mObserver);

        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause()");

        getContentResolver().unregisterContentObserver(mObserver);

        super.onPause();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_get_location:
            getCurrentLocation();
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getCurrentLocation() {
        Log.d(TAG, "getCurrentLocation()");
        mTextView1.setText("現在位置を取得しています・・・\n");
        final LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        final Intent intent = new Intent();
        intent.setAction("jp.mayosuke.android.mylocation.action.LOCATION_CHANGED");
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER, pendingIntent);
    }

    private void onLocationUpdate(final Location location) {
        Log.d(TAG, "onLocationUpdate()");
        if (location == null) {
            return;
        }
        Log.d(TAG, "  location=" +location);
        mTextView1.setText(location.toString());
    }
}
