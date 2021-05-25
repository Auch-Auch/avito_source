package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdwf<V> implements Runnable {
    @NullableDecl
    private zzdwd<V> zzhql;

    public zzdwf(zzdwd<V> zzdwd) {
        this.zzhql = zzdwd;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdvt<? extends V> zzdvt;
        zzdwd<V> zzdwd = this.zzhql;
        if (zzdwd != null && (zzdvt = zzdwd.zzhqj) != null) {
            this.zzhql = null;
            if (zzdvt.isDone()) {
                zzdwd.setFuture(zzdvt);
                return;
            }
            boolean z = true;
            try {
                ScheduledFuture scheduledFuture = zzdwd.zzhqk;
                ((zzdwd) zzdwd).zzhqk = null;
                String str = "Timed out";
                if (scheduledFuture != null) {
                    try {
                        long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                        if (abs > 10) {
                            StringBuilder sb = new StringBuilder(str.length() + 66);
                            sb.append(str);
                            sb.append(" (timeout delayed by ");
                            sb.append(abs);
                            sb.append(" ms after scheduled time)");
                            str = sb.toString();
                        }
                    } catch (Throwable th) {
                        zzdwd.setException(new zzdwi(str));
                        throw th;
                    }
                }
                String valueOf = String.valueOf(str);
                String valueOf2 = String.valueOf(zzdvt);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 2 + valueOf2.length());
                sb2.append(valueOf);
                sb2.append(": ");
                sb2.append(valueOf2);
                zzdwd.setException(new zzdwi(sb2.toString()));
            } finally {
                zzdvt.cancel(z);
            }
        }
    }
}
