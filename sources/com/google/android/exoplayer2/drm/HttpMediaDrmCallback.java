package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableMap;
import com.google.common.net.HttpHeaders;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
public final class HttpMediaDrmCallback implements MediaDrmCallback {
    public final HttpDataSource.Factory a;
    @Nullable
    public final String b;
    public final boolean c;
    public final Map<String, String> d;

    public HttpMediaDrmCallback(@Nullable String str, HttpDataSource.Factory factory) {
        this(str, false, factory);
    }

    public static byte[] a(HttpDataSource.Factory factory, String str, @Nullable byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        List<String> list;
        StatsDataSource statsDataSource = new StatsDataSource(factory.createDataSource());
        DataSpec build = new DataSpec.Builder().setUri(str).setHttpRequestHeaders(map).setHttpMethod(2).setHttpBody(bArr).setFlags(1).build();
        int i = 0;
        DataSpec dataSpec = build;
        int i2 = 0;
        while (true) {
            try {
                DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(statsDataSource, dataSpec);
                try {
                    byte[] byteArray = Util.toByteArray(dataSourceInputStream);
                    Util.closeQuietly(dataSourceInputStream);
                    return byteArray;
                } catch (HttpDataSource.InvalidResponseCodeException e) {
                    int i3 = e.responseCode;
                    String str2 = null;
                    if ((i3 == 307 || i3 == 308) && i2 < 5) {
                        Map<String, List<String>> map2 = e.headerFields;
                        if (!(map2 == null || (list = map2.get(HttpHeaders.LOCATION)) == null || list.isEmpty())) {
                            str2 = list.get(i);
                        }
                    }
                    if (str2 != null) {
                        i2++;
                        dataSpec = dataSpec.buildUpon().setUri(str2).build();
                        Util.closeQuietly(dataSourceInputStream);
                    } else {
                        throw e;
                    }
                } catch (Throwable th) {
                    Util.closeQuietly(dataSourceInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                throw new MediaDrmCallbackException(build, (Uri) Assertions.checkNotNull(statsDataSource.getLastOpenedUri()), statsDataSource.getResponseHeaders(), statsDataSource.getBytesRead(), e2);
            }
        }
    }

    public void clearAllKeyRequestProperties() {
        synchronized (this.d) {
            this.d.clear();
        }
    }

    public void clearKeyRequestProperty(String str) {
        Assertions.checkNotNull(str);
        synchronized (this.d) {
            this.d.remove(str);
        }
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException {
        String str;
        String licenseServerUrl = keyRequest.getLicenseServerUrl();
        if (this.c || TextUtils.isEmpty(licenseServerUrl)) {
            licenseServerUrl = this.b;
        }
        if (!TextUtils.isEmpty(licenseServerUrl)) {
            HashMap hashMap = new HashMap();
            UUID uuid2 = C.PLAYREADY_UUID;
            if (uuid2.equals(uuid)) {
                str = "text/xml";
            } else {
                str = C.CLEARKEY_UUID.equals(uuid) ? AbstractSpiCall.ACCEPT_JSON_VALUE : StringExtensionsKt.APPLICATION_OCTET_STREAM;
            }
            hashMap.put("Content-Type", str);
            if (uuid2.equals(uuid)) {
                hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
            }
            synchronized (this.d) {
                hashMap.putAll(this.d);
            }
            return a(this.a, licenseServerUrl, keyRequest.getData(), hashMap);
        }
        throw new MediaDrmCallbackException(new DataSpec.Builder().setUri(Uri.EMPTY).build(), Uri.EMPTY, ImmutableMap.of(), 0, new IllegalStateException("No license URL"));
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws MediaDrmCallbackException {
        return a(this.a, provisionRequest.getDefaultUrl() + "&signedRequest=" + Util.fromUtf8Bytes(provisionRequest.getData()), null, Collections.emptyMap());
    }

    public void setKeyRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        synchronized (this.d) {
            this.d.put(str, str2);
        }
    }

    public HttpMediaDrmCallback(@Nullable String str, boolean z, HttpDataSource.Factory factory) {
        Assertions.checkArgument(!z || !TextUtils.isEmpty(str));
        this.a = factory;
        this.b = str;
        this.c = z;
        this.d = new HashMap();
    }
}
