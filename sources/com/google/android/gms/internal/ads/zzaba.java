package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzaba {
    private File file;
    @VisibleForTesting
    private String zzbra;
    @VisibleForTesting
    private String zzcya;
    @VisibleForTesting
    private BlockingQueue<zzabk> zzcyd = new ArrayBlockingQueue(100);
    @VisibleForTesting
    private LinkedHashMap<String, String> zzcye = new LinkedHashMap<>();
    @VisibleForTesting
    private Map<String, zzabe> zzcyf = new HashMap();
    private final HashSet<String> zzcyg = new HashSet<>(Arrays.asList("noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"));
    private AtomicBoolean zzcyh;
    @VisibleForTesting
    private Context zzvr;

    public final void zza(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.zzvr = context;
        this.zzbra = str;
        this.zzcya = str2;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.zzcyh = atomicBoolean;
        atomicBoolean.set(zzack.zzdag.get().booleanValue());
        if (this.zzcyh.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.file = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.zzcye.put(entry.getKey(), entry.getValue());
        }
        zzbbi.zzedu.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzaaz
            private final zzaba zzcyc;

            {
                this.zzcyc = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzcyc.zzrl();
            }
        });
        Map<String, zzabe> map2 = this.zzcyf;
        zzabe zzabe = zzabe.zzcyj;
        map2.put("action", zzabe);
        this.zzcyf.put("ad_format", zzabe);
        this.zzcyf.put("e", zzabe.zzcyk);
    }

    public final zzabe zzcu(String str) {
        zzabe zzabe = this.zzcyf.get(str);
        if (zzabe != null) {
            return zzabe;
        }
        return zzabe.zzcyi;
    }

    public final void zzcv(String str) {
        if (!this.zzcyg.contains(str)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("sdkVersion", this.zzbra);
            linkedHashMap.put("ue", str);
            zza(zza(this.zzcye, linkedHashMap), "");
        }
    }

    public final /* synthetic */ void zzrl() {
        while (true) {
            try {
                zzabk take = this.zzcyd.take();
                String zzrq = take.zzrq();
                if (!TextUtils.isEmpty(zzrq)) {
                    zza(zza(this.zzcye, take.zzrr()), zzrq);
                }
            } catch (InterruptedException e) {
                zzbbd.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    public final boolean zza(zzabk zzabk) {
        return this.zzcyd.offer(zzabk);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0087 A[SYNTHETIC, Splitter:B:32:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0092 A[SYNTHETIC, Splitter:B:37:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.util.Map<java.lang.String, java.lang.String> r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            java.lang.String r1 = r4.zzcya
            android.net.Uri r1 = android.net.Uri.parse(r1)
            android.net.Uri$Builder r1 = r1.buildUpon()
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0014:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x0030
            java.lang.Object r2 = r5.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r1.appendQueryParameter(r3, r2)
            goto L_0x0014
        L_0x0030:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            android.net.Uri r1 = r1.build()
            java.lang.String r1 = r1.toString()
            r5.<init>(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x004b
            java.lang.String r1 = "&it="
            r5.append(r1)
            r5.append(r6)
        L_0x004b:
            java.lang.String r5 = r5.toString()
            java.util.concurrent.atomic.AtomicBoolean r6 = r4.zzcyh
            boolean r6 = r6.get()
            if (r6 == 0) goto L_0x00a1
            java.io.File r6 = r4.file
            if (r6 == 0) goto L_0x009b
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x007f }
            r3 = 1
            r2.<init>(r6, r3)     // Catch:{ IOException -> 0x007f }
            byte[] r5 = r5.getBytes()     // Catch:{ IOException -> 0x007a, all -> 0x0077 }
            r2.write(r5)     // Catch:{ IOException -> 0x007a, all -> 0x0077 }
            r5 = 10
            r2.write(r5)     // Catch:{ IOException -> 0x007a, all -> 0x0077 }
            r2.close()     // Catch:{ IOException -> 0x0072 }
            return
        L_0x0072:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzbbd.zzd(r0, r5)
            return
        L_0x0077:
            r5 = move-exception
            r1 = r2
            goto L_0x0090
        L_0x007a:
            r5 = move-exception
            r1 = r2
            goto L_0x0080
        L_0x007d:
            r5 = move-exception
            goto L_0x0090
        L_0x007f:
            r5 = move-exception
        L_0x0080:
            java.lang.String r6 = "CsiReporter: Cannot write to file: sdk_csi_data.txt."
            com.google.android.gms.internal.ads.zzbbd.zzd(r6, r5)     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x008f
            r1.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzbbd.zzd(r0, r5)
        L_0x008f:
            return
        L_0x0090:
            if (r1 == 0) goto L_0x009a
            r1.close()     // Catch:{ IOException -> 0x0096 }
            goto L_0x009a
        L_0x0096:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbbd.zzd(r0, r6)
        L_0x009a:
            throw r5
        L_0x009b:
            java.lang.String r5 = "CsiReporter: File doesn't exists. Cannot write CSI data to file."
            com.google.android.gms.internal.ads.zzbbd.zzfe(r5)
            return
        L_0x00a1:
            com.google.android.gms.ads.internal.zzp.zzkp()
            android.content.Context r6 = r4.zzvr
            java.lang.String r0 = r4.zzbra
            com.google.android.gms.internal.ads.zzayh.zzb(r6, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaba.zza(java.util.Map, java.lang.String):void");
    }

    public final Map<String, String> zza(Map<String, String> map, @Nullable Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String str = (String) linkedHashMap.get(key);
            linkedHashMap.put(key, zzcu(key).zzg(str, entry.getValue()));
        }
        return linkedHashMap;
    }
}
