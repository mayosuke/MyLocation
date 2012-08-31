package jp.mayosuke.android.mylocation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

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
            mTextView1.append("現在位置の情報を取得します。\n");
        case R.id.menu_start_auto_logging:
            
        case R.id.menu_settings:
            
        }
        return super.onOptionsItemSelected(item);
    }
}
