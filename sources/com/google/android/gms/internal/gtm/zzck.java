package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;
public final class zzck extends zzan {
    private static final byte[] zzabr = "\n".getBytes();
    private final String zzabp = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", zzao.VERSION, Build.VERSION.RELEASE, zzcz.zza(Locale.getDefault()), Build.MODEL, Build.ID);
    private final zzcv zzabq;

    public zzck(zzap zzap) {
        super(zzap);
        this.zzabq = new zzcv(zzap.zzcn());
    }

    private final int zza(URL url) {
        Preconditions.checkNotNull(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection zzb = zzb(url);
            zzb.connect();
            zza(zzb);
            int responseCode = zzb.getResponseCode();
            if (responseCode == 200) {
                zzcs().zzcl();
            }
            zzb("GET status", Integer.valueOf(responseCode));
            zzb.disconnect();
            return responseCode;
        } catch (IOException e) {
            zzd("Network GET connection error", e);
            if (0 == 0) {
                return 0;
            }
            httpURLConnection.disconnect();
            return 0;
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private final URL zzd(zzcd zzcd) {
        String str;
        String str2;
        if (zzcd.zzfj()) {
            String valueOf = String.valueOf(zzbq.zzet());
            String valueOf2 = String.valueOf(zzbq.zzev());
            if (valueOf2.length() != 0) {
                str = valueOf.concat(valueOf2);
                return new URL(str);
            }
            str2 = new String(valueOf);
        } else {
            String valueOf3 = String.valueOf(zzbq.zzeu());
            String valueOf4 = String.valueOf(zzbq.zzev());
            if (valueOf4.length() != 0) {
                str = valueOf3.concat(valueOf4);
                return new URL(str);
            }
            str2 = new String(valueOf3);
        }
        str = str2;
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final URL zzfs() {
        String valueOf = String.valueOf(zzbq.zzet());
        String valueOf2 = String.valueOf(zzby.zzzs.get());
        try {
            return new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    public final void zzaw() {
        zza("Network initialized. User agent", this.zzabp);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0157, code lost:
        if (zza(r5) == 200) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0199, code lost:
        if (zza(r6, r5) == 200) goto L_0x0133;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01b3 A[EDGE_INSN: B:71:0x01b3->B:67:0x01b3 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.Long> zzb(java.util.List<com.google.android.gms.internal.gtm.zzcd> r9) {
        /*
        // Method dump skipped, instructions count: 436
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzck.zzb(java.util.List):java.util.List");
    }

    public final boolean zzfr() {
        NetworkInfo networkInfo;
        zzk.zzav();
        zzdb();
        try {
            networkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        zzq("No network connectivity");
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0075 A[SYNTHETIC, Splitter:B:27:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087 A[SYNTHETIC, Splitter:B:35:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(java.net.URL r5, byte[] r6) {
        /*
            r4 = this;
            java.lang.String r0 = "Error closing http post connection output stream"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)
            int r1 = r6.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "POST bytes, url"
            r4.zzb(r2, r1, r5)
            boolean r1 = com.google.android.gms.internal.gtm.zzam.zzda()
            if (r1 == 0) goto L_0x0022
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6)
            java.lang.String r2 = "Post payload\n"
            r4.zza(r2, r1)
        L_0x0022:
            r1 = 0
            android.content.Context r2 = r4.getContext()     // Catch:{ IOException -> 0x006c, all -> 0x0069 }
            r2.getPackageName()     // Catch:{ IOException -> 0x006c, all -> 0x0069 }
            java.net.HttpURLConnection r5 = r4.zzb(r5)     // Catch:{ IOException -> 0x006c, all -> 0x0069 }
            r2 = 1
            r5.setDoOutput(r2)     // Catch:{ IOException -> 0x0067 }
            int r2 = r6.length     // Catch:{ IOException -> 0x0067 }
            r5.setFixedLengthStreamingMode(r2)     // Catch:{ IOException -> 0x0067 }
            r5.connect()     // Catch:{ IOException -> 0x0067 }
            java.io.OutputStream r1 = r5.getOutputStream()     // Catch:{ IOException -> 0x0067 }
            r1.write(r6)     // Catch:{ IOException -> 0x0067 }
            r4.zza(r5)     // Catch:{ IOException -> 0x0067 }
            int r6 = r5.getResponseCode()     // Catch:{ IOException -> 0x0067 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r6 != r2) goto L_0x0052
            com.google.android.gms.internal.gtm.zzae r2 = r4.zzcs()     // Catch:{ IOException -> 0x0067 }
            r2.zzcl()     // Catch:{ IOException -> 0x0067 }
        L_0x0052:
            java.lang.String r2 = "POST status"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x0067 }
            r4.zzb(r2, r3)     // Catch:{ IOException -> 0x0067 }
            r1.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r1 = move-exception
            r4.zze(r0, r1)
        L_0x0063:
            r5.disconnect()
            return r6
        L_0x0067:
            r6 = move-exception
            goto L_0x006e
        L_0x0069:
            r6 = move-exception
            r5 = r1
            goto L_0x0085
        L_0x006c:
            r6 = move-exception
            r5 = r1
        L_0x006e:
            java.lang.String r2 = "Network POST connection error"
            r4.zzd(r2, r6)     // Catch:{ all -> 0x0084 }
            if (r1 == 0) goto L_0x007d
            r1.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x0079:
            r6 = move-exception
            r4.zze(r0, r6)
        L_0x007d:
            if (r5 == 0) goto L_0x0082
            r5.disconnect()
        L_0x0082:
            r5 = 0
            return r5
        L_0x0084:
            r6 = move-exception
        L_0x0085:
            if (r1 == 0) goto L_0x008f
            r1.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r1 = move-exception
            r4.zze(r0, r1)
        L_0x008f:
            if (r5 == 0) goto L_0x0094
            r5.disconnect()
        L_0x0094:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzck.zza(java.net.URL, byte[]):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x001f A[SYNTHETIC, Splitter:B:18:0x001f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.net.HttpURLConnection r4) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "Error closing http connection input stream"
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x001b }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0019 }
        L_0x000a:
            int r2 = r4.read(r1)     // Catch:{ all -> 0x0019 }
            if (r2 > 0) goto L_0x000a
            r4.close()     // Catch:{ IOException -> 0x0014 }
            return
        L_0x0014:
            r4 = move-exception
            r3.zze(r0, r4)
            return
        L_0x0019:
            r1 = move-exception
            goto L_0x001d
        L_0x001b:
            r1 = move-exception
            r4 = 0
        L_0x001d:
            if (r4 == 0) goto L_0x0027
            r4.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r4 = move-exception
            r3.zze(r0, r4)
        L_0x0027:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzck.zza(java.net.HttpURLConnection):void");
    }

    @VisibleForTesting
    public final String zza(zzcd zzcd, boolean z) {
        String str;
        Preconditions.checkNotNull(zzcd);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : zzcd.zzdm().entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    zza(sb, key, entry.getValue());
                }
            }
            zza(sb, "ht", String.valueOf(zzcd.zzfh()));
            zza(sb, "qt", String.valueOf(zzcn().currentTimeMillis() - zzcd.zzfh()));
            if (z) {
                long zzfk = zzcd.zzfk();
                if (zzfk != 0) {
                    str = String.valueOf(zzfk);
                } else {
                    str = String.valueOf(zzcd.zzfg());
                }
                zza(sb, "z", str);
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d4 A[SYNTHETIC, Splitter:B:39:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e6 A[SYNTHETIC, Splitter:B:47:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzb(java.net.URL r11, byte[] r12) {
        /*
        // Method dump skipped, instructions count: 244
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzck.zzb(java.net.URL, byte[]):int");
    }

    private static void zza(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append(Typography.amp);
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    @VisibleForTesting
    private final HttpURLConnection zzb(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(zzby.zzaad.get().intValue());
            httpURLConnection.setReadTimeout(zzby.zzaae.get().intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.zzabp);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    private final URL zzb(zzcd zzcd, String str) {
        String str2;
        if (zzcd.zzfj()) {
            String zzet = zzbq.zzet();
            String zzev = zzbq.zzev();
            str2 = a.t2(a.q0(str, a.q0(zzev, a.q0(zzet, 1))), zzet, zzev, "?", str);
        } else {
            String zzeu = zzbq.zzeu();
            String zzev2 = zzbq.zzev();
            str2 = a.t2(a.q0(str, a.q0(zzev2, a.q0(zzeu, 1))), zzeu, zzev2, "?", str);
        }
        try {
            return new URL(str2);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }
}
