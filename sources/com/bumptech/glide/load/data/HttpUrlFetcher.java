package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
public class HttpUrlFetcher implements DataFetcher<InputStream> {
    @VisibleForTesting
    public static final b g = new a();
    public final GlideUrl a;
    public final int b;
    public final b c;
    public HttpURLConnection d;
    public InputStream e;
    public volatile boolean f;

    public static class a implements b {
    }

    public interface b {
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i) {
        b bVar = g;
        this.a = glideUrl;
        this.b = i;
        this.c = bVar;
    }

    public final InputStream a(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            Objects.requireNonNull((a) this.c);
            this.d = (HttpURLConnection) url.openConnection();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.d.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.d.setConnectTimeout(this.b);
            this.d.setReadTimeout(this.b);
            boolean z = false;
            this.d.setUseCaches(false);
            this.d.setDoInput(true);
            this.d.setInstanceFollowRedirects(false);
            this.d.connect();
            this.e = this.d.getInputStream();
            if (this.f) {
                return null;
            }
            int responseCode = this.d.getResponseCode();
            int i2 = responseCode / 100;
            if (i2 == 2) {
                HttpURLConnection httpURLConnection = this.d;
                if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                    this.e = ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
                } else {
                    if (Log.isLoggable("HttpUrlFetcher", 3)) {
                        httpURLConnection.getContentEncoding();
                    }
                    this.e = httpURLConnection.getInputStream();
                }
                return this.e;
            }
            if (i2 == 3) {
                z = true;
            }
            if (z) {
                String headerField = this.d.getHeaderField(HttpHeaders.LOCATION);
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    cleanup();
                    return a(url3, i + 1, url, map);
                }
                throw new HttpException("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new HttpException(responseCode);
            } else {
                throw new HttpException(this.d.getResponseMessage(), responseCode);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!");
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.f = true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream = this.e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.d = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        long logTime = LogTime.getLogTime();
        try {
            dataCallback.onDataReady(a(this.a.toURL(), 0, null, this.a.getHeaders()));
            if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                return;
            }
        } catch (IOException e2) {
            Log.isLoggable("HttpUrlFetcher", 3);
            dataCallback.onLoadFailed(e2);
            if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                return;
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                LogTime.getElapsedMillis(logTime);
            }
            throw th;
        }
        LogTime.getElapsedMillis(logTime);
    }
}
