package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzaat;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbg;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzcw;
import com.google.android.gms.internal.ads.zzdw;
import com.google.android.gms.internal.ads.zzwe;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
public final class zzf implements zzdw, Runnable {
    private final List<Object[]> zzbom = new Vector();
    private final AtomicReference<zzdw> zzbon = new AtomicReference<>();
    private final AtomicReference<zzdw> zzboo = new AtomicReference<>();
    private zzbbg zzbop;
    private CountDownLatch zzboq = new CountDownLatch(1);
    private Context zzvr;
    private final int zzxo;

    public zzf(Context context, zzbbg zzbbg) {
        this.zzvr = context;
        this.zzbop = zzbbg;
        int intValue = ((Integer) zzwe.zzpu().zzd(zzaat.zzcqg)).intValue();
        if (intValue == 1) {
            this.zzxo = zzcw.zznk;
        } else if (intValue != 2) {
            this.zzxo = zzcw.zznj;
        } else {
            this.zzxo = zzcw.zznl;
        }
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcqw)).booleanValue()) {
            zzbbi.zzedu.execute(this);
            return;
        }
        zzwe.zzpq();
        if (zzbat.zzyn()) {
            zzbbi.zzedu.execute(this);
        } else {
            run();
        }
    }

    @Nullable
    private final zzdw zzca() {
        if (this.zzxo == zzcw.zznk) {
            return this.zzboo.get();
        }
        return this.zzbon.get();
    }

    private static Context zze(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private final boolean zzjy() {
        try {
            this.zzboq.await();
            return true;
        } catch (InterruptedException e) {
            zzbbd.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private final void zzjz() {
        zzdw zzca = zzca();
        if (!(this.zzbom.isEmpty() || zzca == null)) {
            for (Object[] objArr : this.zzbom) {
                if (objArr.length == 1) {
                    zzca.zza((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    zzca.zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.zzbom.clear();
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, com.google.android.gms.internal.ads.zzbbg] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // java.lang.Runnable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            com.google.android.gms.internal.ads.zzbbg r2 = r5.zzbop     // Catch:{ all -> 0x0059 }
            boolean r2 = r2.zzeds     // Catch:{ all -> 0x0059 }
            com.google.android.gms.internal.ads.zzaai<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzaat.zzcoi     // Catch:{ all -> 0x0059 }
            com.google.android.gms.internal.ads.zzaap r4 = com.google.android.gms.internal.ads.zzwe.zzpu()     // Catch:{ all -> 0x0059 }
            java.lang.Object r3 = r4.zzd(r3)     // Catch:{ all -> 0x0059 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0059 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0059 }
            if (r3 != 0) goto L_0x001b
            if (r2 == 0) goto L_0x001b
            r0 = 1
        L_0x001b:
            int r2 = r5.zzxo     // Catch:{ all -> 0x0059 }
            int r3 = com.google.android.gms.internal.ads.zzcw.zznk     // Catch:{ all -> 0x0059 }
            if (r2 == r3) goto L_0x0036
            com.google.android.gms.internal.ads.zzbbg r2 = r5.zzbop     // Catch:{ all -> 0x0059 }
            java.lang.String r2 = r2.zzbra     // Catch:{ all -> 0x0059 }
            android.content.Context r3 = r5.zzvr     // Catch:{ all -> 0x0059 }
            android.content.Context r3 = zze(r3)     // Catch:{ all -> 0x0059 }
            int r4 = r5.zzxo     // Catch:{ all -> 0x0059 }
            com.google.android.gms.internal.ads.zzed r2 = com.google.android.gms.internal.ads.zzed.zzb(r2, r3, r0, r4)     // Catch:{ all -> 0x0059 }
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.internal.ads.zzdw> r3 = r5.zzbon     // Catch:{ all -> 0x0059 }
            r3.set(r2)     // Catch:{ all -> 0x0059 }
        L_0x0036:
            int r2 = r5.zzxo     // Catch:{ all -> 0x0059 }
            int r3 = com.google.android.gms.internal.ads.zzcw.zznj     // Catch:{ all -> 0x0059 }
            if (r2 == r3) goto L_0x004f
            com.google.android.gms.internal.ads.zzbbg r2 = r5.zzbop     // Catch:{ all -> 0x0059 }
            java.lang.String r2 = r2.zzbra     // Catch:{ all -> 0x0059 }
            android.content.Context r3 = r5.zzvr     // Catch:{ all -> 0x0059 }
            android.content.Context r3 = zze(r3)     // Catch:{ all -> 0x0059 }
            com.google.android.gms.internal.ads.zzdp r0 = com.google.android.gms.internal.ads.zzdp.zza(r2, r3, r0)     // Catch:{ all -> 0x0059 }
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.internal.ads.zzdw> r2 = r5.zzboo     // Catch:{ all -> 0x0059 }
            r2.set(r0)     // Catch:{ all -> 0x0059 }
        L_0x004f:
            java.util.concurrent.CountDownLatch r0 = r5.zzboq
            r0.countDown()
            r5.zzvr = r1
            r5.zzbop = r1
            return
        L_0x0059:
            r0 = move-exception
            java.util.concurrent.CountDownLatch r2 = r5.zzboq
            r2.countDown()
            r5.zzvr = r1
            r5.zzbop = r1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzf.run():void");
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, View view, Activity activity) {
        zzdw zzca = zzca();
        return zzca != null ? zzca.zza(context, view, activity) : "";
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zzb(Context context) {
        zzdw zzdw;
        if (!zzjy()) {
            return "";
        }
        int i = this.zzxo;
        if (i == zzcw.zznk || i == zzcw.zznl) {
            zzdw = this.zzboo.get();
        } else {
            zzdw = this.zzbon.get();
        }
        if (zzdw == null) {
            return "";
        }
        zzjz();
        return zzdw.zzb(zze(context));
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, String str, View view, Activity activity) {
        zzdw zzca;
        if (!zzjy() || (zzca = zzca()) == null) {
            return "";
        }
        zzjz();
        return zzca.zza(zze(context), str, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zzb(View view) {
        zzdw zzca = zzca();
        if (zzca != null) {
            zzca.zzb(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zza(MotionEvent motionEvent) {
        zzdw zzca = zzca();
        if (zzca != null) {
            zzjz();
            zzca.zza(motionEvent);
            return;
        }
        this.zzbom.add(new Object[]{motionEvent});
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zza(int i, int i2, int i3) {
        zzdw zzca = zzca();
        if (zzca != null) {
            zzjz();
            zzca.zza(i, i2, i3);
            return;
        }
        this.zzbom.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }
}
