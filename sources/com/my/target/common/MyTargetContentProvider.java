package com.my.target.common;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ae;
import com.my.target.af;
public final class MyTargetContentProvider extends ContentProvider {
    public boolean a = true;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Context context = MyTargetContentProvider.this.getContext();
                Integer num = (Integer) context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("com.my.target.autoInitMode");
                if (num == null || num.intValue() != 0) {
                    ae.c("start autoinitialization");
                    MyTargetManager.initSdk(context);
                }
            } catch (Throwable th) {
                StringBuilder L = a2.b.a.a.a.L("autoinitialization failed: ");
                L.append(th.getMessage());
                ae.c(L.toString());
            }
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (providerInfo != null) {
            if ("com.my.target.mytargetcontentprovider".equals(providerInfo.authority)) {
                ae.c("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
                this.a = false;
            }
            super.attachInfo(context, providerInfo);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (!this.a) {
            return false;
        }
        af.a(new a());
        return false;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }
}
