package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Base64;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.common.base.Ascii;
import com.google.firebase.FirebaseApp;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
@KeepForSdk
public class Metadata {
    public final Context a;
    @GuardedBy("this")
    public String b;
    @GuardedBy("this")
    public String c;
    @GuardedBy("this")
    public int d;
    @GuardedBy("this")
    public int e = 0;

    public Metadata(Context context) {
        this.a = context;
    }

    public static String getDefaultSenderId(FirebaseApp firebaseApp) {
        String gcmSenderId = firebaseApp.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String applicationId = firebaseApp.getOptions().getApplicationId();
        if (!applicationId.startsWith("1:")) {
            return applicationId;
        }
        String[] split = applicationId.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public static String getIdFromPublicKey(PublicKey publicKey) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            digest[0] = (byte) ((digest[0] & Ascii.SI) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public final PackageInfo a(String str) {
        try {
            return this.a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            String.valueOf(e2).length();
            return null;
        }
    }

    public final synchronized void b() {
        PackageInfo a3 = a(this.a.getPackageName());
        if (a3 != null) {
            this.b = Integer.toString(a3.versionCode);
            this.c = a3.versionName;
        }
    }

    public synchronized String getAppVersionCode() {
        if (this.b == null) {
            b();
        }
        return this.b;
    }

    public synchronized String getAppVersionName() {
        if (this.c == null) {
            b();
        }
        return this.c;
    }

    public synchronized int getGmsVersionCode() {
        PackageInfo a3;
        if (this.d == 0 && (a3 = a("com.google.android.gms")) != null) {
            this.d = a3.versionCode;
        }
        return this.d;
    }

    public synchronized int getIidImplementation() {
        int i = this.e;
        if (i != 0) {
            return i;
        }
        PackageManager packageManager = this.a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            return 0;
        }
        if (!PlatformVersion.isAtLeastO()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            if (PlatformVersion.isAtLeastO()) {
                this.e = 2;
            } else {
                this.e = 1;
            }
            return this.e;
        }
        this.e = 2;
        return 2;
    }

    @KeepForSdk
    public boolean isGmscorePresent() {
        return getIidImplementation() != 0;
    }
}
