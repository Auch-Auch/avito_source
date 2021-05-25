package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import androidx.annotation.GuardedBy;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;
public final class zzatg extends ContextWrapper {
    @GuardedBy("this")
    private Context zzduy;
    @GuardedBy("this")
    private WeakReference<Activity> zzduz = new WeakReference<>(null);

    private zzatg(Context context) {
        super(context);
    }

    public static zzatg zzaa(Context context) {
        return new zzatg(zzl(context));
    }

    public static Context zzab(Context context) {
        if (context instanceof zzatg) {
            return ((zzatg) context).getBaseContext();
        }
        return zzl(context);
    }

    private final synchronized Intent zzd(Intent intent) {
        if (!(this.zzduy == null || intent.getComponent() == null)) {
            if (intent.getComponent().getPackageName().equals(this.zzduy.getPackageName())) {
                Intent intent2 = (Intent) intent.clone();
                intent2.setClassName(super.getPackageName(), intent.getComponent().getClassName());
                return intent2;
            }
        }
        return intent;
    }

    private final synchronized void zze(Intent intent) {
        Activity activity = this.zzduz.get();
        if (activity == null) {
            intent.addFlags(268435456);
            super.startActivity(intent);
            return;
        }
        try {
            Intent intent2 = (Intent) intent.clone();
            intent2.setFlags(intent.getFlags() & -268435457);
            activity.startActivity(intent2);
        } catch (Throwable th) {
            zzp.zzkt().zza(th, "");
            intent.addFlags(268435456);
            super.startActivity(intent);
        }
    }

    private static Context zzl(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized ApplicationInfo getApplicationInfo() {
        Context context = this.zzduy;
        if (context != null) {
            return context.getApplicationInfo();
        }
        return super.getApplicationInfo();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized String getPackageName() {
        Context context = this.zzduy;
        if (context != null) {
            return context.getPackageName();
        }
        return super.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized String getPackageResourcePath() {
        Context context = this.zzduy;
        if (context != null) {
            return context.getPackageResourcePath();
        }
        return super.getPackageResourcePath();
    }

    public final synchronized void setAppPackageName(String str) throws PackageManager.NameNotFoundException {
        this.zzduy = createPackageContext(str, 0);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized void startActivity(Intent intent) {
        zze(zzd(intent));
    }
}
