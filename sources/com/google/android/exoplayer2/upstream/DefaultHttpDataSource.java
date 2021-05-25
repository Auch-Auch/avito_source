package com.google.android.exoplayer2.upstream;

import a2.b.a.a.a;
import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Predicate;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
public class DefaultHttpDataSource extends BaseDataSource implements HttpDataSource {
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    public static final Pattern u = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final AtomicReference<byte[]> v = new AtomicReference<>();
    public final boolean e;
    public final int f;
    public final int g;
    public final String h;
    @Nullable
    public final HttpDataSource.RequestProperties i;
    public final HttpDataSource.RequestProperties j;
    @Nullable
    public Predicate<String> k;
    @Nullable
    public DataSpec l;
    @Nullable
    public HttpURLConnection m;
    @Nullable
    public InputStream n;
    public boolean o;
    public int p;
    public long q;
    public long r;
    public long s;
    public long t;

    public DefaultHttpDataSource() {
        this(ExoPlayerLibraryInfo.DEFAULT_USER_AGENT, 8000, 8000);
    }

    public static URL b(URL url, @Nullable String str) throws IOException {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if ("https".equals(protocol) || UriUtil.HTTP_SCHEME.equals(protocol)) {
                return url2;
            }
            throw new ProtocolException(a.c3("Unsupported protocol redirect: ", protocol));
        }
        throw new ProtocolException("Null location redirect");
    }

    public static void e(HttpURLConnection httpURLConnection, long j2) {
        int i2 = Util.SDK_INT;
        if (i2 == 19 || i2 == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j2 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j2 <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.m = null;
        }
    }

    public final long bytesRead() {
        return this.t;
    }

    public final long bytesRemaining() {
        long j2 = this.r;
        return j2 == -1 ? j2 : j2 - this.t;
    }

    public final long bytesSkipped() {
        return this.s;
    }

    public final HttpURLConnection c(DataSpec dataSpec) throws IOException {
        HttpURLConnection d;
        DataSpec dataSpec2 = dataSpec;
        URL url = new URL(dataSpec2.uri.toString());
        int i2 = dataSpec2.httpMethod;
        byte[] bArr = dataSpec2.httpBody;
        long j2 = dataSpec2.position;
        long j3 = dataSpec2.length;
        boolean isFlagSet = dataSpec2.isFlagSet(1);
        if (!this.e) {
            return d(url, i2, bArr, j2, j3, isFlagSet, true, dataSpec2.httpRequestHeaders);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            if (i3 <= 20) {
                d = d(url, i2, bArr, j2, j3, isFlagSet, false, dataSpec2.httpRequestHeaders);
                int responseCode = d.getResponseCode();
                String headerField = d.getHeaderField(HttpHeaders.LOCATION);
                if ((i2 == 1 || i2 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                    d.disconnect();
                    url = b(url, headerField);
                } else if (i2 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    break;
                } else {
                    d.disconnect();
                    url = b(url, headerField);
                    i2 = 1;
                    bArr = null;
                }
                dataSpec2 = dataSpec;
                i3 = i4;
                j3 = j3;
                j2 = j2;
            } else {
                throw new NoRouteToHostException(a.M2("Too many redirects: ", i4));
            }
        }
        return d;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearAllRequestProperties() {
        this.j.clear();
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearRequestProperty(String str) {
        Assertions.checkNotNull(str);
        this.j.remove(str);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws HttpDataSource.HttpDataSourceException {
        boolean z = false;
        InputStream inputStream = null;
        try {
            if (this.n != null) {
                e(this.m, bytesRemaining());
                try {
                    this.n.close();
                } catch (IOException e2) {
                    throw new HttpDataSource.HttpDataSourceException(e2, this.l, 3);
                }
            }
        } finally {
            this.n = inputStream;
            a();
            if (this.o) {
                this.o = z;
                transferEnded();
            }
        }
    }

    public final HttpURLConnection d(URL url, int i2, @Nullable byte[] bArr, long j2, long j3, boolean z, boolean z2, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f);
        httpURLConnection.setReadTimeout(this.g);
        HashMap hashMap = new HashMap();
        HttpDataSource.RequestProperties requestProperties = this.i;
        if (requestProperties != null) {
            hashMap.putAll(requestProperties.getSnapshot());
        }
        hashMap.putAll(this.j.getSnapshot());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        if (!(j2 == 0 && j3 == -1)) {
            String V2 = a.V2("bytes=", j2, "-");
            if (j3 != -1) {
                StringBuilder L = a.L(V2);
                L.append((j2 + j3) - 1);
                V2 = L.toString();
            }
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, V2);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.h);
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, z ? "gzip" : "identity");
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        httpURLConnection.setRequestMethod(DataSpec.getStringForHttpMethod(i2));
        if (bArr != null) {
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    public final void f() throws IOException {
        if (this.s != this.q) {
            byte[] andSet = v.getAndSet(null);
            if (andSet == null) {
                andSet = new byte[4096];
            }
            while (true) {
                long j2 = this.s;
                long j3 = this.q;
                if (j2 != j3) {
                    int read = this.n.read(andSet, 0, (int) Math.min(j3 - j2, (long) andSet.length));
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.s += (long) read;
                        bytesTransferred(read);
                    } else {
                        throw new EOFException();
                    }
                } else {
                    v.set(andSet);
                    return;
                }
            }
        }
    }

    @Nullable
    public final HttpURLConnection getConnection() {
        return this.m;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public int getResponseCode() {
        int i2;
        if (this.m == null || (i2 = this.p) <= 0) {
            return -1;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.upstream.BaseDataSource, com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.m;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        if (r7 != 0) goto L_0x0056;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x011b  */
    @Override // com.google.android.exoplayer2.upstream.DataSource
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long open(com.google.android.exoplayer2.upstream.DataSpec r20) throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        /*
        // Method dump skipped, instructions count: 440
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.DefaultHttpDataSource.open(com.google.android.exoplayer2.upstream.DataSpec):long");
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i2, int i3) throws HttpDataSource.HttpDataSourceException {
        try {
            f();
            if (i3 == 0) {
                return 0;
            }
            long j2 = this.r;
            if (j2 != -1) {
                long j3 = j2 - this.t;
                if (j3 != 0) {
                    i3 = (int) Math.min((long) i3, j3);
                }
                return -1;
            }
            int read = this.n.read(bArr, i2, i3);
            if (read != -1) {
                this.t += (long) read;
                bytesTransferred(read);
                return read;
            } else if (this.r == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e2) {
            throw new HttpDataSource.HttpDataSourceException(e2, this.l, 2);
        }
    }

    public void setContentTypePredicate(@Nullable Predicate<String> predicate) {
        this.k = predicate;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void setRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        this.j.set(str, str2);
    }

    public DefaultHttpDataSource(String str) {
        this(str, 8000, 8000);
    }

    public DefaultHttpDataSource(String str, int i2, int i3) {
        this(str, i2, i3, false, null);
    }

    public DefaultHttpDataSource(String str, int i2, int i3, boolean z, @Nullable HttpDataSource.RequestProperties requestProperties) {
        super(true);
        this.h = Assertions.checkNotEmpty(str);
        this.j = new HttpDataSource.RequestProperties();
        this.f = i2;
        this.g = i3;
        this.e = z;
        this.i = requestProperties;
    }

    @Deprecated
    public DefaultHttpDataSource(String str, @Nullable Predicate<String> predicate) {
        this(str, predicate, 8000, 8000);
    }

    @Deprecated
    public DefaultHttpDataSource(String str, @Nullable Predicate<String> predicate, int i2, int i3) {
        this(str, predicate, i2, i3, false, null);
    }

    @Deprecated
    public DefaultHttpDataSource(String str, @Nullable Predicate<String> predicate, int i2, int i3, boolean z, @Nullable HttpDataSource.RequestProperties requestProperties) {
        super(true);
        this.h = Assertions.checkNotEmpty(str);
        this.k = predicate;
        this.j = new HttpDataSource.RequestProperties();
        this.f = i2;
        this.g = i3;
        this.e = z;
        this.i = requestProperties;
    }
}
