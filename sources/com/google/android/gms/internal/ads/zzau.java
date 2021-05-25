package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
public class zzau implements zzx {
    private static final boolean DEBUG = zzaq.DEBUG;
    @Deprecated
    private final zzbe zzcf;
    private final zzar zzcg;
    private final zzat zzch;

    public zzau(zzar zzar) {
        this(zzar, new zzat(4096));
    }

    private static void zza(String str, zzaa<?> zzaa, zzao zzao) throws zzao {
        zzan zzj = zzaa.zzj();
        int zzi = zzaa.zzi();
        try {
            zzj.zza(zzao);
            zzaa.zzc(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(zzi)));
        } catch (zzao e) {
            zzaa.zzc(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(zzi)));
            throw e;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0148: APUT  (r11v5 java.lang.Object[]), (2 ??[int, float, short, byte, char]), (r13v22 java.lang.Object) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0203, code lost:
        throw new com.google.android.gms.internal.ads.zzab(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0204, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0205, code lost:
        r2 = java.lang.String.valueOf(r22.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0215, code lost:
        if (r2.length() != 0) goto L_0x0217;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0217, code lost:
        r2 = "Bad URL ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x021c, code lost:
        r2 = new java.lang.String("Bad URL ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0224, code lost:
        throw new java.lang.RuntimeException(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0225, code lost:
        zza("socket", r22, new com.google.android.gms.internal.ads.zzap());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0181, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0182, code lost:
        r17 = r5;
        r13 = r0;
        r8 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x018d, code lost:
        r17 = r5;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0193, code lost:
        r0 = r8.getStatusCode();
        com.google.android.gms.internal.ads.zzaq.e("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r22.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01aa, code lost:
        if (r13 != null) goto L_0x01ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ac, code lost:
        r5 = new com.google.android.gms.internal.ads.zzy(r0, r13, false, android.os.SystemClock.elapsedRealtime() - r3, r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01bc, code lost:
        if (r0 == 401) goto L_0x01e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c5, code lost:
        if (r0 < 400) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01d1, code lost:
        throw new com.google.android.gms.internal.ads.zzr(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d4, code lost:
        if (r0 < 500) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01df, code lost:
        throw new com.google.android.gms.internal.ads.zzam(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01e5, code lost:
        throw new com.google.android.gms.internal.ads.zzam(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01e6, code lost:
        zza(com.avito.android.authorization.event.SocialButtonClickedEventKt.AUTH, r22, new com.google.android.gms.internal.ads.zzl(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01f2, code lost:
        zza("network", r22, new com.google.android.gms.internal.ads.zzz());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0204 A[ExcHandler: MalformedURLException (r0v1 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01fe A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0193  */
    @Override // com.google.android.gms.internal.ads.zzx
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzy zzc(com.google.android.gms.internal.ads.zzaa<?> r22) throws com.google.android.gms.internal.ads.zzao {
        /*
        // Method dump skipped, instructions count: 561
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzau.zzc(com.google.android.gms.internal.ads.zzaa):com.google.android.gms.internal.ads.zzy");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.ads.zzar */
    /* JADX WARN: Multi-variable type inference failed */
    private zzau(zzar zzar, zzat zzat) {
        this.zzcg = zzar;
        this.zzcf = zzar;
        this.zzch = zzat;
    }

    private final byte[] zza(InputStream inputStream, int i) throws IOException, zzam {
        zzbi zzbi = new zzbi(this.zzch, i);
        if (inputStream != null) {
            try {
                byte[] zzf = this.zzch.zzf(1024);
                while (true) {
                    int read = inputStream.read(zzf);
                    if (read == -1) {
                        break;
                    }
                    zzbi.write(zzf, 0, read);
                }
                byte[] byteArray = zzbi.toByteArray();
                try {
                    inputStream.close();
                } catch (IOException unused) {
                    zzaq.v("Error occurred when closing InputStream", new Object[0]);
                }
                this.zzch.zza(zzf);
                zzbi.close();
                return byteArray;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                        zzaq.v("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.zzch.zza(null);
                zzbi.close();
                throw th;
            }
        } else {
            throw new zzam();
        }
    }
}
