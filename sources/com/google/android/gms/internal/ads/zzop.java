package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.net.Uri;
import androidx.browser.trusted.sharing.ShareTarget;
import com.facebook.common.util.UriUtil;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
public final class zzop implements zzom {
    private static final Pattern zzbia = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzbib = new AtomicReference<>();
    private final boolean zzbic;
    private final int zzbid;
    private final int zzbie;
    private final String zzbif;
    private final zzpm<String> zzbig = null;
    private final zzou zzbih;
    private final zzou zzbii;
    private final zzpa<? super zzop> zzbij;
    private zzon zzbik;
    private HttpURLConnection zzbil;
    private InputStream zzbim;
    private boolean zzbin;
    private long zzbio;
    private long zzbip;
    private long zzbiq;
    private long zzcq;

    public zzop(String str, zzpm<String> zzpm, zzpa<? super zzop> zzpa, int i, int i2, boolean z, zzou zzou) {
        this.zzbif = zzoz.checkNotEmpty(str);
        this.zzbij = zzpa;
        this.zzbii = new zzou();
        this.zzbid = i;
        this.zzbie = i2;
        this.zzbic = true;
        this.zzbih = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long zzc(java.net.HttpURLConnection r8) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r8.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0018
            long r1 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0011 }
            goto L_0x001a
        L_0x0011:
            java.lang.String r1 = java.lang.String.valueOf(r0)
            r1.length()
        L_0x0018:
            r1 = -1
        L_0x001a:
            java.lang.String r3 = "Content-Range"
            java.lang.String r8 = r8.getHeaderField(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 != 0) goto L_0x006f
            java.util.regex.Pattern r3 = com.google.android.gms.internal.ads.zzop.zzbia
            java.util.regex.Matcher r3 = r3.matcher(r8)
            boolean r4 = r3.find()
            if (r4 == 0) goto L_0x006f
            r4 = 2
            java.lang.String r4 = r3.group(r4)     // Catch:{ NumberFormatException -> 0x0068 }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x0068 }
            r6 = 1
            java.lang.String r3 = r3.group(r6)     // Catch:{ NumberFormatException -> 0x0068 }
            long r6 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x0068 }
            long r4 = r4 - r6
            r6 = 1
            long r4 = r4 + r6
            r6 = 0
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x0050
            r1 = r4
            goto L_0x006f
        L_0x0050:
            int r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x006f
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0068 }
            r0.length()     // Catch:{ NumberFormatException -> 0x0068 }
            java.lang.String r0 = java.lang.String.valueOf(r8)     // Catch:{ NumberFormatException -> 0x0068 }
            r0.length()     // Catch:{ NumberFormatException -> 0x0068 }
            long r0 = java.lang.Math.max(r1, r4)     // Catch:{ NumberFormatException -> 0x0068 }
            r1 = r0
            goto L_0x006f
        L_0x0068:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r8.length()
        L_0x006f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzop.zzc(java.net.HttpURLConnection):long");
    }

    private final void zzio() {
        HttpURLConnection httpURLConnection = this.zzbil;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
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
            java.io.InputStream r2 = r9.zzbim     // Catch:{ all -> 0x0088 }
            if (r2 == 0) goto L_0x0075
            java.net.HttpURLConnection r2 = r9.zzbil     // Catch:{ all -> 0x0088 }
            long r3 = r9.zzbip     // Catch:{ all -> 0x0088 }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            long r7 = r9.zzcq     // Catch:{ all -> 0x0088 }
            long r3 = r3 - r7
        L_0x0014:
            int r7 = com.google.android.gms.internal.ads.zzpq.SDK_INT     // Catch:{ all -> 0x0088 }
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
            com.google.android.gms.internal.ads.zzpa<? super com.google.android.gms.internal.ads.zzop> r0 = r9.zzbij
            if (r0 == 0) goto L_0x0087
            r0.zze(r9)
        L_0x0087:
            return
        L_0x0088:
            r2 = move-exception
            r9.zzbim = r0
            r9.zzio()
            boolean r0 = r9.zzbin
            if (r0 == 0) goto L_0x009b
            r9.zzbin = r1
            com.google.android.gms.internal.ads.zzpa<? super com.google.android.gms.internal.ads.zzop> r0 = r9.zzbij
            if (r0 == 0) goto L_0x009b
            r0.zze(r9)
        L_0x009b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzop.close():void");
    }

    public final Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.zzbil;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
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
                        zzpa<? super zzop> zzpa = this.zzbij;
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
                zzpa<? super zzop> zzpa2 = this.zzbij;
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

    @Override // com.google.android.gms.internal.ads.zzom
    public final long zza(zzon zzon) throws zzos {
        HttpURLConnection httpURLConnection;
        HttpURLConnection zza;
        this.zzbik = zzon;
        long j = 0;
        this.zzcq = 0;
        this.zzbiq = 0;
        try {
            URL url = new URL(zzon.uri.toString());
            byte[] bArr = zzon.zzbhy;
            long j2 = zzon.position;
            long j3 = zzon.zzcp;
            boolean isFlagSet = zzon.isFlagSet(1);
            if (!this.zzbic) {
                httpURLConnection = zza(url, bArr, j2, j3, isFlagSet, true);
            } else {
                URL url2 = url;
                byte[] bArr2 = bArr;
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i <= 20) {
                        zza = zza(url2, bArr2, j2, j3, isFlagSet, false);
                        int responseCode = zza.getResponseCode();
                        if (!(responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303)) {
                            if (bArr2 == null) {
                                if (responseCode != 307) {
                                    if (responseCode != 308) {
                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                        bArr2 = null;
                        String headerField = zza.getHeaderField(HttpHeaders.LOCATION);
                        zza.disconnect();
                        if (headerField != null) {
                            url2 = new URL(url2, headerField);
                            String protocol = url2.getProtocol();
                            if ("https".equals(protocol) || UriUtil.HTTP_SCHEME.equals(protocol)) {
                                i = i2;
                                j3 = j3;
                                j2 = j2;
                            } else {
                                String valueOf = String.valueOf(protocol);
                                throw new ProtocolException(valueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(valueOf) : new String("Unsupported protocol redirect: "));
                            }
                        } else {
                            throw new ProtocolException("Null location redirect");
                        }
                    } else {
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("Too many redirects: ");
                        sb.append(i2);
                        throw new NoRouteToHostException(sb.toString());
                    }
                }
                httpURLConnection = zza;
            }
            this.zzbil = httpURLConnection;
            try {
                int responseCode2 = httpURLConnection.getResponseCode();
                if (responseCode2 < 200 || responseCode2 > 299) {
                    Map<String, List<String>> headerFields = this.zzbil.getHeaderFields();
                    zzio();
                    zzor zzor = new zzor(responseCode2, headerFields, zzon);
                    if (responseCode2 == 416) {
                        zzor.initCause(new zzoo(0));
                    }
                    throw zzor;
                }
                this.zzbil.getContentType();
                if (responseCode2 == 200) {
                    long j4 = zzon.position;
                    if (j4 != 0) {
                        j = j4;
                    }
                }
                this.zzbio = j;
                if (!zzon.isFlagSet(1)) {
                    long j5 = zzon.zzcp;
                    long j6 = -1;
                    if (j5 != -1) {
                        this.zzbip = j5;
                    } else {
                        long zzc = zzc(this.zzbil);
                        if (zzc != -1) {
                            j6 = zzc - this.zzbio;
                        }
                        this.zzbip = j6;
                    }
                } else {
                    this.zzbip = zzon.zzcp;
                }
                try {
                    this.zzbim = this.zzbil.getInputStream();
                    this.zzbin = true;
                    zzpa<? super zzop> zzpa = this.zzbij;
                    if (zzpa != null) {
                        zzpa.zza(this, zzon);
                    }
                    return this.zzbip;
                } catch (IOException e) {
                    zzio();
                    throw new zzos(e, zzon, 1);
                }
            } catch (IOException e2) {
                zzio();
                String valueOf2 = String.valueOf(zzon.uri.toString());
                throw new zzos(valueOf2.length() != 0 ? "Unable to connect to ".concat(valueOf2) : new String("Unable to connect to "), e2, zzon, 1);
            }
        } catch (IOException e3) {
            String valueOf3 = String.valueOf(zzon.uri.toString());
            throw new zzos(valueOf3.length() != 0 ? "Unable to connect to ".concat(valueOf3) : new String("Unable to connect to "), e3, zzon, 1);
        }
    }

    private final HttpURLConnection zza(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.zzbid);
        httpURLConnection.setReadTimeout(this.zzbie);
        for (Map.Entry<String, String> entry : this.zzbii.zzir().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        if (!(j == 0 && j2 == -1)) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            String sb2 = sb.toString();
            if (j2 != -1) {
                String valueOf = String.valueOf(sb2);
                sb2 = a.q2(valueOf.length() + 20, valueOf, (j + j2) - 1);
            }
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, sb2);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.zzbif);
        if (!z) {
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }
}
