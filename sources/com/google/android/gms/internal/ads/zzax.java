package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
@VisibleForTesting
public final class zzax {
    public long zzcm;
    public final String zzcn;
    public final String zzr;
    public final long zzs;
    public final long zzt;
    public final long zzu;
    public final long zzv;
    public final List<zzu> zzx;

    private zzax(String str, String str2, long j, long j2, long j3, long j4, List<zzu> list) {
        this.zzcn = str;
        this.zzr = "".equals(str2) ? null : str2;
        this.zzs = j;
        this.zzt = j2;
        this.zzu = j3;
        this.zzv = j4;
        this.zzx = list;
    }

    public static zzax zzc(zzba zzba) throws IOException {
        if (zzav.zzb((InputStream) zzba) == 538247942) {
            return new zzax(zzav.zza(zzba), zzav.zza(zzba), zzav.zzc(zzba), zzav.zzc(zzba), zzav.zzc(zzba), zzav.zzc(zzba), zzav.zzb(zzba));
        }
        throw new IOException();
    }

    public final boolean zza(OutputStream outputStream) {
        try {
            zzav.zza(outputStream, 538247942);
            zzav.zza(outputStream, this.zzcn);
            String str = this.zzr;
            if (str == null) {
                str = "";
            }
            zzav.zza(outputStream, str);
            zzav.zza(outputStream, this.zzs);
            zzav.zza(outputStream, this.zzt);
            zzav.zza(outputStream, this.zzu);
            zzav.zza(outputStream, this.zzv);
            List<zzu> list = this.zzx;
            if (list != null) {
                zzav.zza(outputStream, list.size());
                for (zzu zzu2 : list) {
                    zzav.zza(outputStream, zzu2.getName());
                    zzav.zza(outputStream, zzu2.getValue());
                }
            } else {
                zzav.zza(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            zzaq.d("%s", e.toString());
            return false;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:9:0x000e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.google.android.gms.internal.ads.zzu>] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzax(java.lang.String r14, com.google.android.gms.internal.ads.zzn r15) {
        /*
            r13 = this;
            java.lang.String r2 = r15.zzr
            long r3 = r15.zzs
            long r5 = r15.zzt
            long r7 = r15.zzu
            long r9 = r15.zzv
            java.util.List<com.google.android.gms.internal.ads.zzu> r0 = r15.zzx
            if (r0 == 0) goto L_0x0010
        L_0x000e:
            r11 = r0
            goto L_0x0044
        L_0x0010:
            java.util.Map<java.lang.String, java.lang.String> r15 = r15.zzw
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r15.size()
            r0.<init>(r1)
            java.util.Set r15 = r15.entrySet()
            java.util.Iterator r15 = r15.iterator()
        L_0x0023:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x000e
            java.lang.Object r1 = r15.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            com.google.android.gms.internal.ads.zzu r11 = new com.google.android.gms.internal.ads.zzu
            java.lang.Object r12 = r1.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r11.<init>(r12, r1)
            r0.add(r11)
            goto L_0x0023
        L_0x0044:
            r0 = r13
            r1 = r14
            r0.<init>(r1, r2, r3, r5, r7, r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzax.<init>(java.lang.String, com.google.android.gms.internal.ads.zzn):void");
    }
}
