package jp.mayosuke.android.mylocation;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;

public class LocationProvider extends ContentProvider {
    private static final String TAG = LocationProvider.class.getSimpleName();

    public static final String AUTHORITY = "jp.mayosuke.android.provider.location";
    private static final String SCHEME = "content://";
    public static final Uri CONTENT_URI = Uri.parse(SCHEME + AUTHORITY + "/");

     /**
     * The MIME type of {@link #CONTENT_URI} providing a directory of locations.
     */
    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.mayosuke.location";

    /**
     * The MIME type of a {@link #CONTENT_URI} sub-directory of a single location.
     */
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.mayosuke.location";

    private static final String DATABASE_NAME = "locations.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "locations";

    public static final class Location implements BaseColumns {
        public static final String TIME = "time";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";
        public static final String ALTITUDE = "altitude";
        
        private Location() {}
    }

    private SQLiteOpenHelper mDbHelper;

    @Override
    public boolean onCreate() {
        Log.d(TAG, "onCreate()");
        UiUtil.isInMainThread();

        mDbHelper = new SQLiteOpenHelper(getContext(), DATABASE_NAME, null, DATABASE_VERSION) {
            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void onCreate(SQLiteDatabase db) {
                // TODO Auto-generated method stub
                
            }
        };
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        Log.d(TAG, "query()");
        UiUtil.isInMainThread();
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getType(Uri uri) {
        Log.d(TAG, "getType()");
        UiUtil.isInMainThread();
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.d(TAG, "insert()");
        UiUtil.isInMainThread();
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Log.d(TAG, "delete()");
        UiUtil.isInMainThread();
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
            String[] selectionArgs) {
        Log.d(TAG, "update()");
        UiUtil.isInMainThread();
        // TODO Auto-generated method stub
        return 0;
    }

}
