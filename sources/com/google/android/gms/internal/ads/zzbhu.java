package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import androidx.annotation.Nullable;
import androidx.browser.trusted.sharing.ShareTarget;
import java.util.Collections;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzbhu {
    private final String method;
    public final Uri uri;
    public final String url;
    public final Map<String, String> zzam;

    @TargetApi(21)
    public zzbhu(WebResourceRequest webResourceRequest) {
        this(webResourceRequest.getUrl().toString(), webResourceRequest.getUrl(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
    }

    public zzbhu(String str) {
        this(str, Uri.parse(str), null, null);
    }

    private zzbhu(String str, Uri uri2, @Nullable String str2, @Nullable Map<String, String> map) {
        this.url = str;
        this.uri = uri2;
        this.method = str2 == null ? ShareTarget.METHOD_GET : str2;
        this.zzam = map == null ? Collections.emptyMap() : map;
    }
}
