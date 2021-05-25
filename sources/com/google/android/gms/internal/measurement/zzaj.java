package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;
public final class zzaj extends zzag.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Context zze;
    private final /* synthetic */ Bundle zzf;
    private final /* synthetic */ zzag zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaj(zzag zzag, String str, String str2, Context context, Bundle bundle) {
        super(zzag);
        this.zzg = zzag;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052 A[Catch:{ Exception -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058 A[Catch:{ Exception -> 0x0098 }] */
    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza() {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            com.google.android.gms.internal.measurement.zzag r2 = r14.zzg     // Catch:{ Exception -> 0x0098 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0098 }
            r3.<init>()     // Catch:{ Exception -> 0x0098 }
            com.google.android.gms.internal.measurement.zzag.zza(r2, r3)     // Catch:{ Exception -> 0x0098 }
            com.google.android.gms.internal.measurement.zzag r2 = r14.zzg     // Catch:{ Exception -> 0x0098 }
            java.lang.String r3 = r14.zzc     // Catch:{ Exception -> 0x0098 }
            java.lang.String r4 = r14.zzd     // Catch:{ Exception -> 0x0098 }
            boolean r2 = com.google.android.gms.internal.measurement.zzag.zza(r2, r3, r4)     // Catch:{ Exception -> 0x0098 }
            r3 = 0
            if (r2 == 0) goto L_0x0027
            java.lang.String r3 = r14.zzd     // Catch:{ Exception -> 0x0098 }
            java.lang.String r2 = r14.zzc     // Catch:{ Exception -> 0x0098 }
            com.google.android.gms.internal.measurement.zzag r4 = r14.zzg     // Catch:{ Exception -> 0x0098 }
            java.lang.String r4 = com.google.android.gms.internal.measurement.zzag.zzb(r4)     // Catch:{ Exception -> 0x0098 }
            r10 = r2
            r11 = r3
            r9 = r4
            goto L_0x002a
        L_0x0027:
            r9 = r3
            r10 = r9
            r11 = r10
        L_0x002a:
            android.content.Context r2 = r14.zze     // Catch:{ Exception -> 0x0098 }
            com.google.android.gms.internal.measurement.zzag.zzb(r2)     // Catch:{ Exception -> 0x0098 }
            java.lang.Boolean r2 = com.google.android.gms.internal.measurement.zzag.zzj()     // Catch:{ Exception -> 0x0098 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0098 }
            if (r2 != 0) goto L_0x003e
            if (r10 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r2 = 0
            goto L_0x003f
        L_0x003e:
            r2 = 1
        L_0x003f:
            com.google.android.gms.internal.measurement.zzag r3 = r14.zzg     // Catch:{ Exception -> 0x0098 }
            android.content.Context r4 = r14.zze     // Catch:{ Exception -> 0x0098 }
            com.google.android.gms.internal.measurement.zzv r4 = r3.zza(r4, r2)     // Catch:{ Exception -> 0x0098 }
            com.google.android.gms.internal.measurement.zzag.zza(r3, r4)     // Catch:{ Exception -> 0x0098 }
            com.google.android.gms.internal.measurement.zzag r3 = r14.zzg     // Catch:{ Exception -> 0x0098 }
            com.google.android.gms.internal.measurement.zzv r3 = com.google.android.gms.internal.measurement.zzag.zzc(r3)     // Catch:{ Exception -> 0x0098 }
            if (r3 != 0) goto L_0x0058
            com.google.android.gms.internal.measurement.zzag r2 = r14.zzg     // Catch:{ Exception -> 0x0098 }
            com.google.android.gms.internal.measurement.zzag.zzb(r2)     // Catch:{ Exception -> 0x0098 }
            return
        L_0x0058:
            android.content.Context r3 = r14.zze     // Catch:{ Exception -> 0x0098 }
            int r3 = com.google.android.gms.internal.measurement.zzag.zzc(r3)     // Catch:{ Exception -> 0x0098 }
            android.content.Context r4 = r14.zze     // Catch:{ Exception -> 0x0098 }
            int r4 = com.google.android.gms.internal.measurement.zzag.zzd(r4)     // Catch:{ Exception -> 0x0098 }
            if (r2 == 0) goto L_0x0071
            int r2 = java.lang.Math.max(r3, r4)     // Catch:{ Exception -> 0x0098 }
            if (r4 >= r3) goto L_0x006e
            r3 = 1
            goto L_0x006f
        L_0x006e:
            r3 = 0
        L_0x006f:
            r8 = r3
            goto L_0x007b
        L_0x0071:
            if (r3 <= 0) goto L_0x0074
            r4 = r3
        L_0x0074:
            if (r3 <= 0) goto L_0x0078
            r2 = 1
            goto L_0x0079
        L_0x0078:
            r2 = 0
        L_0x0079:
            r8 = r2
            r2 = r4
        L_0x007b:
            com.google.android.gms.internal.measurement.zzae r13 = new com.google.android.gms.internal.measurement.zzae     // Catch:{ Exception -> 0x0098 }
            r4 = 31000(0x7918, double:1.5316E-319)
            long r6 = (long) r2     // Catch:{ Exception -> 0x0098 }
            android.os.Bundle r12 = r14.zzf     // Catch:{ Exception -> 0x0098 }
            r3 = r13
            r3.<init>(r4, r6, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0098 }
            com.google.android.gms.internal.measurement.zzag r2 = r14.zzg     // Catch:{ Exception -> 0x0098 }
            com.google.android.gms.internal.measurement.zzv r2 = com.google.android.gms.internal.measurement.zzag.zzc(r2)     // Catch:{ Exception -> 0x0098 }
            android.content.Context r3 = r14.zze     // Catch:{ Exception -> 0x0098 }
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r3)     // Catch:{ Exception -> 0x0098 }
            long r4 = r14.zza     // Catch:{ Exception -> 0x0098 }
            r2.initialize(r3, r13, r4)     // Catch:{ Exception -> 0x0098 }
            return
        L_0x0098:
            r2 = move-exception
            com.google.android.gms.internal.measurement.zzag r3 = r14.zzg
            com.google.android.gms.internal.measurement.zzag.zza(r3, r2, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaj.zza():void");
    }
}
