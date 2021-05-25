package com.yandex.mobile.ads.impl;

import a2.b.a.a.a;
import android.content.Context;
import android.os.Environment;
import android.support.annotation.NonNull;
import java.io.File;
public final class bs {
    @NonNull
    public static File a(@NonNull Context context, @NonNull String str) {
        String externalStorageState = Environment.getExternalStorageState();
        File externalCacheDir = "mounted".equals(externalStorageState) || (!Environment.isExternalStorageRemovable() && !"mounted_ro".equals(externalStorageState)) ? context.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(externalCacheDir.getPath());
        return new File(a.t(sb, File.separator, str));
    }
}
