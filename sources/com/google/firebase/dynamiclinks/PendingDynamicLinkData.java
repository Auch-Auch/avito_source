package com.google.firebase.dynamiclinks;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;
public class PendingDynamicLinkData {
    public final DynamicLinkData a;

    @VisibleForTesting
    @KeepForSdk
    public PendingDynamicLinkData(DynamicLinkData dynamicLinkData) {
        if (dynamicLinkData == null) {
            this.a = null;
            return;
        }
        if (dynamicLinkData.getClickTimestamp() == 0) {
            dynamicLinkData.zza(DefaultClock.getInstance().currentTimeMillis());
        }
        this.a = dynamicLinkData;
    }

    public long getClickTimestamp() {
        DynamicLinkData dynamicLinkData = this.a;
        if (dynamicLinkData == null) {
            return 0;
        }
        return dynamicLinkData.getClickTimestamp();
    }

    @Nullable
    @ShowFirstParty
    @KeepForSdk
    public Bundle getExtensions() {
        DynamicLinkData dynamicLinkData = this.a;
        if (dynamicLinkData == null) {
            return new Bundle();
        }
        return dynamicLinkData.zzf();
    }

    @Nullable
    public Uri getLink() {
        String zzd;
        DynamicLinkData dynamicLinkData = this.a;
        if (dynamicLinkData == null || (zzd = dynamicLinkData.zzd()) == null) {
            return null;
        }
        return Uri.parse(zzd);
    }

    public int getMinimumAppVersion() {
        DynamicLinkData dynamicLinkData = this.a;
        if (dynamicLinkData == null) {
            return 0;
        }
        return dynamicLinkData.zze();
    }

    @Nullable
    public Intent getUpdateAppIntent(@NonNull Context context) {
        Uri uri;
        Uri uri2 = null;
        if (getMinimumAppVersion() == 0) {
            return null;
        }
        try {
            if (context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).versionCode < getMinimumAppVersion()) {
                DynamicLinkData dynamicLinkData = this.a;
                if (dynamicLinkData == null) {
                    uri = null;
                } else {
                    uri = dynamicLinkData.zzc();
                }
                if (uri != null) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    DynamicLinkData dynamicLinkData2 = this.a;
                    if (dynamicLinkData2 != null) {
                        uri2 = dynamicLinkData2.zzc();
                    }
                    return intent.setData(uri2).setPackage("com.android.vending");
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public PendingDynamicLinkData(@Nullable String str, int i, long j, @Nullable Uri uri) {
        this.a = new DynamicLinkData(null, str, i, j, null, uri);
    }
}
