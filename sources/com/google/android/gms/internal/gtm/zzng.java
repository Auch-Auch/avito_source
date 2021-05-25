package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public final class zzng implements zznh {
    private HttpURLConnection zzatk;
    private InputStream zzatl = null;

    @Override // com.google.android.gms.internal.gtm.zznh
    public final void close() {
        HttpURLConnection httpURLConnection = this.zzatk;
        try {
            InputStream inputStream = this.zzatl;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzev.zza(valueOf.length() != 0 ? "HttpUrlConnectionNetworkClient: Error when closing http input stream: ".concat(valueOf) : new String("HttpUrlConnectionNetworkClient: Error when closing http input stream: "), e);
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.google.android.gms.internal.gtm.zznh
    public final InputStream zzcj(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        this.zzatk = httpURLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            this.zzatl = inputStream;
            return inputStream;
        }
        String m2 = a.m2(25, "Bad response: ", responseCode);
        if (responseCode == 404) {
            throw new FileNotFoundException(m2);
        } else if (responseCode == 503) {
            throw new zznl(m2);
        } else {
            throw new IOException(m2);
        }
    }
}
