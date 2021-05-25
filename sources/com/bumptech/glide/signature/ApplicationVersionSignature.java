package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
public final class ApplicationVersionSignature {
    public static final ConcurrentMap<String, Key> a = new ConcurrentHashMap();

    @NonNull
    public static Key obtain(@NonNull Context context) {
        PackageInfo packageInfo;
        String str;
        String packageName = context.getPackageName();
        Key key = a.get(packageName);
        if (key != null) {
            return key;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            context.getPackageName();
            packageInfo = null;
        }
        if (packageInfo != null) {
            str = String.valueOf(packageInfo.versionCode);
        } else {
            str = UUID.randomUUID().toString();
        }
        ObjectKey objectKey = new ObjectKey(str);
        Key putIfAbsent = a.putIfAbsent(packageName, objectKey);
        return putIfAbsent == null ? objectKey : putIfAbsent;
    }
}
