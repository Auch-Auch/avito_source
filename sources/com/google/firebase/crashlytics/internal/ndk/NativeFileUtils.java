package com.google.firebase.crashlytics.internal.ndk;

import a2.j.e.d.d.d.a;
import a2.j.e.d.d.d.d;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public final class NativeFileUtils {
    @NonNull
    public static byte[] binaryImagesJsonFromMapsFile(@Nullable File file, @NonNull Context context) throws IOException {
        Throwable th;
        if (file == null || !file.exists()) {
            return new byte[0];
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            try {
                byte[] a = new a(context, new d()).a(bufferedReader2);
                CommonUtils.closeQuietly(bufferedReader2);
                return a;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                CommonUtils.closeQuietly(bufferedReader);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.closeQuietly(bufferedReader);
            throw th;
        }
    }
}
