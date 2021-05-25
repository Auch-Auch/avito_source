package com.facebook.imageutils;

import android.media.ExifInterface;
import android.os.Build;
import com.facebook.common.logging.FLog;
import com.facebook.soloader.DoNotOptimize;
import java.io.IOException;
import java.io.InputStream;
public class HeifExifUtil {
    public static final String TAG = "HeifExifUtil";

    @DoNotOptimize
    public static class HeifExifUtilAndroidN {
        private HeifExifUtilAndroidN() {
        }
    }

    public static int getOrientation(InputStream inputStream) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return new ExifInterface(inputStream).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            } catch (IOException e) {
                FLog.d(TAG, "Failed reading Heif Exif orientation -> ignoring", (Throwable) e);
                return 0;
            }
        } else {
            FLog.d(TAG, "Trying to read Heif Exif information before Android N -> ignoring");
            return 0;
        }
    }
}
