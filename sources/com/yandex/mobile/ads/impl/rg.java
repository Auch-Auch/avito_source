package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.annotation.NonNull;
import java.util.List;
public final class rg {
    @NonNull
    private final String a;
    @NonNull
    private final PackageManager b;

    public rg(@NonNull Context context) {
        this.a = context.getPackageName();
        this.b = context.getPackageManager();
    }

    public final boolean a(@NonNull String str) {
        try {
            return this.b.checkPermission(str, this.a) == 0;
        } catch (Exception unused) {
        }
    }

    public final boolean a(@NonNull Intent intent) {
        List<ResolveInfo> queryIntentActivities = this.b.queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
            return false;
        }
        return true;
    }
}
