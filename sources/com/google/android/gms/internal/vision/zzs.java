package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.vision.L;
import javax.annotation.concurrent.GuardedBy;
public abstract class zzs<T> {
    private final Object lock = new Object();
    private final String tag;
    private final String zzdm;
    private final String zzdn;
    private boolean zzdo = false;
    private boolean zzdp = false;
    @GuardedBy("lock")
    private T zzdq;
    private final Context zzg;

    public zzs(Context context, String str, String str2) {
        this.zzg = context;
        this.tag = str;
        String valueOf = String.valueOf(str2);
        this.zzdm = valueOf.length() != 0 ? "com.google.android.gms.vision.dynamite.".concat(valueOf) : new String("com.google.android.gms.vision.dynamite.");
        this.zzdn = str2;
    }

    public final boolean isOperational() {
        return zzr() != null;
    }

    public abstract T zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException;

    public abstract void zzp() throws RemoteException;

    public final void zzq() {
        synchronized (this.lock) {
            if (this.zzdq != null) {
                try {
                    zzp();
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public final T zzr() {
        synchronized (this.lock) {
            T t = this.zzdq;
            if (t != null) {
                return t;
            }
            DynamiteModule dynamiteModule = null;
            try {
                dynamiteModule = DynamiteModule.load(this.zzg, DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION, this.zzdm);
            } catch (DynamiteModule.LoadingException unused) {
                String format = String.format("%s.%s", "com.google.android.gms.vision", this.zzdn);
                L.d("Cannot load thick client module, fall back to load optional module %s", format);
                try {
                    dynamiteModule = DynamiteModule.load(this.zzg, DynamiteModule.PREFER_REMOTE, format);
                } catch (DynamiteModule.LoadingException e) {
                    L.e(e, "Error loading optional module %s", format);
                    if (!this.zzdo) {
                        L.d("Broadcasting download intent for dependency %s", this.zzdn);
                        String str = this.zzdn;
                        Intent intent = new Intent();
                        intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
                        intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", str);
                        intent.setAction("com.google.android.gms.vision.DEPENDENCY");
                        this.zzg.sendBroadcast(intent);
                        this.zzdo = true;
                    }
                }
            }
            if (dynamiteModule != null) {
                try {
                    this.zzdq = zza(dynamiteModule, this.zzg);
                } catch (RemoteException | DynamiteModule.LoadingException unused2) {
                }
            }
            boolean z = this.zzdp;
            if (!z && this.zzdq == null) {
                this.zzdp = true;
            } else if (z) {
                T t2 = this.zzdq;
            }
            return this.zzdq;
        }
    }
}
