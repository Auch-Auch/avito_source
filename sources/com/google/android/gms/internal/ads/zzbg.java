package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
public final class zzbg extends FilterInputStream {
    private final HttpURLConnection zzcx;

    public zzbg(HttpURLConnection httpURLConnection) {
        super(zzbd.zza(httpURLConnection));
        this.zzcx = httpURLConnection;
    }

    @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public final void close() throws IOException {
        super.close();
        this.zzcx.disconnect();
    }
}
