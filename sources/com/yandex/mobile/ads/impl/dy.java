package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.StatFs;
import android.util.DisplayMetrics;
import com.facebook.common.statfs.StatFsHelper;
import com.sumsub.sns.R2;
import java.io.File;
public final class dy {
    public static long a(File file) {
        long j;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException unused) {
            j = 10485760;
        }
        return Math.max(Math.min(j, (long) StatFsHelper.DEFAULT_DISK_RED_LEVEL_IN_BYTES), 10485760L);
    }

    public static int a(Context context) {
        int i;
        try {
            int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            i = Math.min(maxMemory / 8, ((int) ((((float) (displayMetrics.widthPixels * displayMetrics.heightPixels)) * displayMetrics.density) / 1024.0f)) * 3);
        } catch (IllegalArgumentException unused) {
            i = R2.styleable.MockView_mock_labelBackgroundColor;
        }
        return Math.max(i, (int) R2.styleable.MockView_mock_labelBackgroundColor);
    }
}
