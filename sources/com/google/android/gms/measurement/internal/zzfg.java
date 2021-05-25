package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;
@WorkerThread
public final class zzfg implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zzfe zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzfc zzf;

    public zzfg(zzfc zzfc, String str, URL url, byte[] bArr, Map<String, String> map, zzfe zzfe) {
        this.zzf = zzfc;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzfe);
        this.zza = url;
        this.zzb = bArr;
        this.zzc = zzfe;
        this.zzd = str;
        this.zze = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cd A[SYNTHETIC, Splitter:B:44:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0108 A[SYNTHETIC, Splitter:B:57:0x0108] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0122  */
    @Override // java.lang.Runnable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 315
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfg.run():void");
    }
}
