package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
public class GlideUrl implements Key {
    public final Headers a;
    @Nullable
    public final URL b;
    @Nullable
    public final String c;
    @Nullable
    public String d;
    @Nullable
    public URL e;
    @Nullable
    public volatile byte[] f;
    public int g;

    public GlideUrl(URL url) {
        this(url, Headers.DEFAULT);
    }

    public final String a() {
        if (TextUtils.isEmpty(this.d)) {
            String str = this.c;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) Preconditions.checkNotNull(this.b)).toString();
            }
            this.d = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.d;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof GlideUrl)) {
            return false;
        }
        GlideUrl glideUrl = (GlideUrl) obj;
        if (!getCacheKey().equals(glideUrl.getCacheKey()) || !this.a.equals(glideUrl.a)) {
            return false;
        }
        return true;
    }

    public String getCacheKey() {
        String str = this.c;
        return str != null ? str : ((URL) Preconditions.checkNotNull(this.b)).toString();
    }

    public Map<String, String> getHeaders() {
        return this.a.getHeaders();
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.g == 0) {
            int hashCode = getCacheKey().hashCode();
            this.g = hashCode;
            this.g = this.a.hashCode() + (hashCode * 31);
        }
        return this.g;
    }

    public String toString() {
        return getCacheKey();
    }

    public String toStringUrl() {
        return a();
    }

    public URL toURL() throws MalformedURLException {
        if (this.e == null) {
            this.e = new URL(a());
        }
        return this.e;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        if (this.f == null) {
            this.f = getCacheKey().getBytes(Key.CHARSET);
        }
        messageDigest.update(this.f);
    }

    public GlideUrl(String str) {
        this(str, Headers.DEFAULT);
    }

    public GlideUrl(URL url, Headers headers) {
        this.b = (URL) Preconditions.checkNotNull(url);
        this.c = null;
        this.a = (Headers) Preconditions.checkNotNull(headers);
    }

    public GlideUrl(String str, Headers headers) {
        this.b = null;
        this.c = Preconditions.checkNotEmpty(str);
        this.a = (Headers) Preconditions.checkNotNull(headers);
    }
}
