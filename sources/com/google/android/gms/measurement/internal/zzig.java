package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.List;
import java.util.Map;
@WorkerThread
public final class zzig implements Runnable {
    private final URL zza;
    private final byte[] zzb = null;
    private final zzih zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzie zzf;

    public zzig(zzie zzie, String str, URL url, byte[] bArr, Map<String, String> map, zzih zzih) {
        this.zzf = zzie;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzih);
        this.zza = url;
        this.zzc = zzih;
        this.zzd = str;
        this.zze = null;
    }

    private final void zzb(int i, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        this.zzf.zzq().zza(new Runnable(this, i, exc, bArr, map) { // from class: com.google.android.gms.measurement.internal.zzij
            private final zzig zza;
            private final int zzb;
            private final Exception zzc;
            private final byte[] zzd;
            private final Map zze;

            {
                this.zza = r1;
                this.zzb = r2;
                this.zzc = r3;
                this.zzd = r4;
                this.zze = r5;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d  */
    @Override // java.lang.Runnable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.zzie r0 = r7.zzf
            r0.zzc()
            r0 = 0
            r1 = 0
            com.google.android.gms.measurement.internal.zzie r2 = r7.zzf     // Catch:{ IOException -> 0x0068, all -> 0x005c }
            java.net.URL r3 = r7.zza     // Catch:{ IOException -> 0x0068, all -> 0x005c }
            java.net.HttpURLConnection r2 = r2.zza(r3)     // Catch:{ IOException -> 0x0068, all -> 0x005c }
            java.util.Map<java.lang.String, java.lang.String> r3 = r7.zze     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            if (r3 == 0) goto L_0x0037
            java.util.Set r3 = r3.entrySet()     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
        L_0x001b:
            boolean r4 = r3.hasNext()     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            if (r4 == 0) goto L_0x0037
            java.lang.Object r4 = r3.next()     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            java.lang.Object r5 = r4.getKey()     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            r2.addRequestProperty(r5, r4)     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            goto L_0x001b
        L_0x0037:
            int r1 = r2.getResponseCode()     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            java.util.Map r3 = r2.getHeaderFields()     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            com.google.android.gms.measurement.internal.zzie r4 = r7.zzf     // Catch:{ IOException -> 0x0051, all -> 0x004c }
            byte[] r4 = com.google.android.gms.measurement.internal.zzie.zza(r4, r2)     // Catch:{ IOException -> 0x0051, all -> 0x004c }
            r2.disconnect()
            r7.zzb(r1, r0, r4, r3)
            return
        L_0x004c:
            r4 = move-exception
            r6 = r4
            r4 = r3
            r3 = r6
            goto L_0x005f
        L_0x0051:
            r4 = move-exception
            r6 = r4
            r4 = r3
            r3 = r6
            goto L_0x006b
        L_0x0056:
            r3 = move-exception
            r4 = r0
            goto L_0x005f
        L_0x0059:
            r3 = move-exception
            r4 = r0
            goto L_0x006b
        L_0x005c:
            r3 = move-exception
            r2 = r0
            r4 = r2
        L_0x005f:
            if (r2 == 0) goto L_0x0064
            r2.disconnect()
        L_0x0064:
            r7.zzb(r1, r0, r0, r4)
            throw r3
        L_0x0068:
            r3 = move-exception
            r2 = r0
            r4 = r2
        L_0x006b:
            if (r2 == 0) goto L_0x0070
            r2.disconnect()
        L_0x0070:
            r7.zzb(r1, r3, r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzig.run():void");
    }

    public final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzc.zza(this.zzd, i, exc, bArr, map);
    }
}
