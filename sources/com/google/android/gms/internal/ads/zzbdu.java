package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;
public final class zzbdu implements zzom {
    private static final Pattern zzbia = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzbib = new AtomicReference<>();
    private final int zzbid;
    private final int zzbie;
    private final String zzbif;
    private final zzou zzbii;
    private final zzpa<? super zzbdu> zzbij;
    private zzon zzbik;
    private HttpURLConnection zzbil;
    private InputStream zzbim;
    private boolean zzbin;
    private long zzbio;
    private long zzbip;
    private long zzbiq;
    private long zzcq;
    private SSLSocketFactory zzeje = new zzbdx(this);
    private int zzejf;
    private Set<Socket> zzejg = new HashSet();

    public zzbdu(String str, zzpa<? super zzbdu> zzpa, int i, int i2, int i3) {
        this.zzbif = zzoz.checkNotEmpty(str);
        this.zzbij = zzpa;
        this.zzbii = new zzou();
        this.zzbid = i;
        this.zzbie = i2;
        this.zzejf = i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long zzc(java.net.HttpURLConnection r9) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r9.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "]"
            if (r1 != 0) goto L_0x0034
            long r3 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0013 }
            goto L_0x0036
        L_0x0013:
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 28
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            java.lang.String r1 = "Unexpected Content-Length ["
            r3.append(r1)
            r3.append(r0)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzbbd.zzfc(r1)
        L_0x0034:
            r3 = -1
        L_0x0036:
            java.lang.String r1 = "Content-Range"
            java.lang.String r9 = r9.getHeaderField(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 != 0) goto L_0x00c9
            java.util.regex.Pattern r1 = com.google.android.gms.internal.ads.zzbdu.zzbia
            java.util.regex.Matcher r1 = r1.matcher(r9)
            boolean r5 = r1.find()
            if (r5 == 0) goto L_0x00c9
            r5 = 2
            java.lang.String r5 = r1.group(r5)     // Catch:{ NumberFormatException -> 0x00a8 }
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x00a8 }
            r7 = 1
            java.lang.String r1 = r1.group(r7)     // Catch:{ NumberFormatException -> 0x00a8 }
            long r7 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x00a8 }
            long r5 = r5 - r7
            r7 = 1
            long r5 = r5 + r7
            r7 = 0
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x006c
            r3 = r5
            goto L_0x00c9
        L_0x006c:
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x00c9
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00a8 }
            int r1 = r1.length()     // Catch:{ NumberFormatException -> 0x00a8 }
            int r1 = r1 + 26
            java.lang.String r7 = java.lang.String.valueOf(r9)     // Catch:{ NumberFormatException -> 0x00a8 }
            int r7 = r7.length()     // Catch:{ NumberFormatException -> 0x00a8 }
            int r1 = r1 + r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00a8 }
            r7.<init>(r1)     // Catch:{ NumberFormatException -> 0x00a8 }
            java.lang.String r1 = "Inconsistent headers ["
            r7.append(r1)     // Catch:{ NumberFormatException -> 0x00a8 }
            r7.append(r0)     // Catch:{ NumberFormatException -> 0x00a8 }
            java.lang.String r0 = "] ["
            r7.append(r0)     // Catch:{ NumberFormatException -> 0x00a8 }
            r7.append(r9)     // Catch:{ NumberFormatException -> 0x00a8 }
            r7.append(r2)     // Catch:{ NumberFormatException -> 0x00a8 }
            java.lang.String r0 = r7.toString()     // Catch:{ NumberFormatException -> 0x00a8 }
            com.google.android.gms.internal.ads.zzbbd.zzfe(r0)     // Catch:{ NumberFormatException -> 0x00a8 }
            long r0 = java.lang.Math.max(r3, r5)     // Catch:{ NumberFormatException -> 0x00a8 }
            r3 = r0
            goto L_0x00c9
        L_0x00a8:
            java.lang.String r0 = java.lang.String.valueOf(r9)
            int r0 = r0.length()
            int r0 = r0 + 27
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Unexpected Content-Range ["
            r1.append(r0)
            r1.append(r9)
            r1.append(r2)
            java.lang.String r9 = r1.toString()
            com.google.android.gms.internal.ads.zzbbd.zzfc(r9)
        L_0x00c9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdu.zzc(java.net.HttpURLConnection):long");
    }

    private final void zzio() {
        HttpURLConnection httpURLConnection = this.zzbil;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzbbd.zzc("Unexpected error while disconnecting", e);
            }
            this.zzbil = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        if (r3 > android.support.v4.media.session.PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) goto L_0x0034;
     */
    @Override // com.google.android.gms.internal.ads.zzom
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() throws com.google.android.gms.internal.ads.zzos {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.zzbim     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x0075
            java.net.HttpURLConnection r2 = r9.zzbil     // Catch:{ all -> 0x008d }
            long r3 = r9.zzbip     // Catch:{ all -> 0x008d }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            long r7 = r9.zzcq     // Catch:{ all -> 0x008d }
            long r3 = r3 - r7
        L_0x0014:
            int r7 = com.google.android.gms.internal.ads.zzpq.SDK_INT     // Catch:{ all -> 0x008d }
            r8 = 19
            if (r7 == r8) goto L_0x001e
            r8 = 20
            if (r7 != r8) goto L_0x0065
        L_0x001e:
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x0065 }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x002e
            int r3 = r2.read()     // Catch:{ Exception -> 0x0065 }
            r4 = -1
            if (r3 != r4) goto L_0x0034
            goto L_0x0065
        L_0x002e:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0065
        L_0x0034:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x0065 }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x0065 }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0065 }
            if (r4 != 0) goto L_0x004c
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x0065 }
            if (r3 == 0) goto L_0x0065
        L_0x004c:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x0065 }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x0065 }
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0065 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x0065 }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x0065 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0065 }
            r3.invoke(r2, r4)     // Catch:{ Exception -> 0x0065 }
        L_0x0065:
            java.io.InputStream r2 = r9.zzbim     // Catch:{ IOException -> 0x006b }
            r2.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x0075
        L_0x006b:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzos r3 = new com.google.android.gms.internal.ads.zzos
            com.google.android.gms.internal.ads.zzon r4 = r9.zzbik
            r5 = 3
            r3.<init>(r2, r4, r5)
            throw r3
        L_0x0075:
            r9.zzbim = r0
            r9.zzio()
            boolean r0 = r9.zzbin
            if (r0 == 0) goto L_0x0087
            r9.zzbin = r1
            com.google.android.gms.internal.ads.zzpa<? super com.google.android.gms.internal.ads.zzbdu> r0 = r9.zzbij
            if (r0 == 0) goto L_0x0087
            r0.zze(r9)
        L_0x0087:
            java.util.Set<java.net.Socket> r0 = r9.zzejg
            r0.clear()
            return
        L_0x008d:
            r2 = move-exception
            r9.zzbim = r0
            r9.zzio()
            boolean r0 = r9.zzbin
            if (r0 == 0) goto L_0x00a0
            r9.zzbin = r1
            com.google.android.gms.internal.ads.zzpa<? super com.google.android.gms.internal.ads.zzbdu> r0 = r9.zzbij
            if (r0 == 0) goto L_0x00a0
            r0.zze(r9)
        L_0x00a0:
            java.util.Set<java.net.Socket> r0 = r9.zzejg
            r0.clear()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdu.close():void");
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.zzbil;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final int read(byte[] bArr, int i, int i2) throws zzos {
        try {
            if (this.zzbiq != this.zzbio) {
                byte[] andSet = zzbib.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (true) {
                    long j = this.zzbiq;
                    long j2 = this.zzbio;
                    if (j == j2) {
                        zzbib.set(andSet);
                        break;
                    }
                    int read = this.zzbim.read(andSet, 0, (int) Math.min(j2 - j, (long) andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzbiq += (long) read;
                        zzpa<? super zzbdu> zzpa = this.zzbij;
                        if (zzpa != null) {
                            zzpa.zzc(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.zzbip;
            if (j3 != -1) {
                long j4 = j3 - this.zzcq;
                if (j4 == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j4);
            }
            int read2 = this.zzbim.read(bArr, i, i2);
            if (read2 != -1) {
                this.zzcq += (long) read2;
                zzpa<? super zzbdu> zzpa2 = this.zzbij;
                if (zzpa2 != null) {
                    zzpa2.zzc(this, read2);
                }
                return read2;
            } else if (this.zzbip == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzos(e, this.zzbik, 2);
        }
    }

    public final void setReceiveBufferSize(int i) {
        this.zzejf = i;
        for (Socket socket : this.zzejg) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzejf);
                } catch (SocketException e) {
                    zzbbd.zzd("Failed to update receive buffer size.", e);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x0127 A[EDGE_INSN: B:119:0x0127->B:50:0x0127 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d5 A[Catch:{ IOException -> 0x0241 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e2 A[Catch:{ IOException -> 0x0241 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e4 A[Catch:{ IOException -> 0x0241 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ea A[Catch:{ IOException -> 0x0241 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011d A[Catch:{ IOException -> 0x0241 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x017f  */
    @Override // com.google.android.gms.internal.ads.zzom
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zzon r24) throws com.google.android.gms.internal.ads.zzos {
        /*
        // Method dump skipped, instructions count: 612
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdu.zza(com.google.android.gms.internal.ads.zzon):long");
    }

    /* access modifiers changed from: private */
    public final void zza(Socket socket) {
        this.zzejg.add(socket);
    }
}
