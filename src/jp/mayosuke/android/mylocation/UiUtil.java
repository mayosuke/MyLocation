package jp.mayosuke.android.mylocation;

import android.os.Looper;
import android.util.Log;

final public class UiUtil {
    private static final String TAG = UiUtil.class.getSimpleName();

    private UiUtil() {}

    public static boolean isInMainThread() {
        final boolean isInMainThread = Looper.getMainLooper().getThread() == Thread.currentThread();
        Log.d(TAG, "isInMainThread()=" + isInMainThread);
        return isInMainThread;
    }
}
