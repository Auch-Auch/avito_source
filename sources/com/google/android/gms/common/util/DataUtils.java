package com.google.android.gms.common.util;

import android.database.CharArrayBuffer;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.ByteArrayOutputStream;
@KeepForSdk
public final class DataUtils {
    @KeepForSdk
    public static void copyStringToBuffer(@RecentlyNonNull String str, @RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        if (TextUtils.isEmpty(str)) {
            charArrayBuffer.sizeCopied = 0;
        } else {
            char[] cArr = charArrayBuffer.data;
            if (cArr == null || cArr.length < str.length()) {
                charArrayBuffer.data = str.toCharArray();
            } else {
                str.getChars(0, str.length(), charArrayBuffer.data, 0);
            }
        }
        charArrayBuffer.sizeCopied = str.length();
    }

    @RecentlyNonNull
    @KeepForSdk
    public static byte[] loadImageBytes(@RecentlyNonNull Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
