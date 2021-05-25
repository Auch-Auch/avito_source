package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.Map;
@TargetApi(11)
public final class zzbgv extends zzbgu {
    public zzbgv(zzbfq zzbfq, zzto zzto, boolean z) {
        super(zzbfq, zzto, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbft, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zza(webView, str, (Map<String, String>) null);
    }
}
