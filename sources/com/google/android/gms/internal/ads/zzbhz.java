package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebView;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;
public final class zzbhz {
    @VisibleForTesting
    @GuardedBy("InvokeJavascriptWorkaround.class")
    private static Boolean zzeqa;

    private zzbhz() {
    }

    @TargetApi(19)
    public static void zza(WebView webView, String str) {
        if (!PlatformVersion.isAtLeastKitKat() || !zzb(webView)) {
            String valueOf = String.valueOf(str);
            webView.loadUrl(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        webView.evaluateJavascript(str, null);
    }

    @TargetApi(19)
    private static boolean zzb(WebView webView) {
        boolean booleanValue;
        synchronized (zzbhz.class) {
            if (zzeqa == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    zzeqa = Boolean.TRUE;
                } catch (IllegalStateException unused) {
                    zzeqa = Boolean.FALSE;
                }
            }
            booleanValue = zzeqa.booleanValue();
        }
        return booleanValue;
    }
}
