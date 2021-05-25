package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
@TargetApi(11)
public final class zzbfi extends WebChromeClient {
    private final zzbfq zzdgc;

    public zzbfi(zzbfq zzbfq) {
        this.zzdgc = zzbfq;
    }

    private final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        zza zzabw;
        try {
            zzbfq zzbfq = this.zzdgc;
            if (zzbfq == null || zzbfq.zzabe() == null || this.zzdgc.zzabe().zzabw() == null || (zzabw = this.zzdgc.zzabe().zzabw()) == null || zzabw.zzjx()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(str2);
                if (z) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(1);
                    TextView textView = new TextView(context);
                    textView.setText(str3);
                    EditText editText = new EditText(context);
                    editText.setText(str4);
                    linearLayout.addView(textView);
                    linearLayout.addView(editText);
                    builder.setView(linearLayout).setPositiveButton(17039370, new zzbfo(jsPromptResult, editText)).setNegativeButton(17039360, new zzbfp(jsPromptResult)).setOnCancelListener(new zzbfm(jsPromptResult)).create().show();
                } else {
                    builder.setMessage(str3).setPositiveButton(17039370, new zzbfn(jsResult)).setNegativeButton(17039360, new zzbfk(jsResult)).setOnCancelListener(new zzbfl(jsResult)).create().show();
                }
                return true;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(str3).length());
            sb.append("window.");
            sb.append(str);
            sb.append("('");
            sb.append(str3);
            sb.append("')");
            zzabw.zzbo(sb.toString());
            return false;
        } catch (WindowManager.BadTokenException e) {
            zzbbd.zzd("Fail to display Dialog.", e);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzbfq)) {
            zzbbd.zzfe("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        zzc zzaba = ((zzbfq) webView).zzaba();
        if (zzaba == null) {
            zzbbd.zzfe("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzaba.close();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String sourceId = consoleMessage.sourceId();
        int lineNumber = consoleMessage.lineNumber();
        StringBuilder K = a.K(a.q0(sourceId, a.q0(message, 19)), "JS: ", message, " (", sourceId);
        K.append(":");
        K.append(lineNumber);
        K.append(")");
        String sb = K.toString();
        if (sb.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i = zzbfr.zzelu[consoleMessage.messageLevel().ordinal()];
        if (i == 1) {
            zzbbd.zzfc(sb);
        } else if (i == 2) {
            zzbbd.zzfe(sb);
        } else if (i == 3 || i == 4) {
            zzbbd.zzfd(sb);
        } else if (i != 5) {
            zzbbd.zzfd(sb);
        } else {
            zzbbd.zzef(sb);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.zzdgc.zzabf() != null) {
            webView2.setWebViewClient(this.zzdgc.zzabf());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = CacheDataSink.DEFAULT_FRAGMENT_SIZE - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j != 0) {
            if (j2 == 0) {
                j = Math.min(Math.min((long) PlaybackStateCompat.ACTION_PREPARE_FROM_URI, j4) + j, (long) PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            } else if (j2 <= Math.min(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED - j, j4)) {
                j += j2;
            }
            j2 = j;
        } else if (j2 > j4 || j2 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            j2 = 0;
        }
        quotaUpdater.updateQuota(j2);
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z;
        if (callback != null) {
            zzp.zzkp();
            if (!zzayh.zzr(this.zzdgc.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                zzp.zzkp();
                if (!zzayh.zzr(this.zzdgc.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        zzc zzaba = this.zzdgc.zzaba();
        if (zzaba == null) {
            zzbbd.zzfe("Could not get ad overlay when hiding custom view.");
        } else {
            zzaba.zzuo();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "alert", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zza(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(21)
    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        if (!PlatformVersion.isAtLeastLollipop() || zzacz.zzdby.get().booleanValue()) {
            super.onPermissionRequest(permissionRequest);
            return;
        }
        zzbfq zzbfq = this.zzdgc;
        if (zzbfq == null || zzbfq.zzabe() == null || this.zzdgc.zzabe().zzacj() == null) {
            super.onPermissionRequest(permissionRequest);
            return;
        }
        String[] zza = this.zzdgc.zzabe().zzacj().zza(permissionRequest.getResources());
        if (zza.length > 0) {
            permissionRequest.grant(zza);
        } else {
            permissionRequest.deny();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        long j3 = CacheDataSink.DEFAULT_FRAGMENT_SIZE - j2;
        long j4 = j + PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        if (j3 < j4) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j4);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        zzc zzaba = this.zzdgc.zzaba();
        if (zzaba == null) {
            zzbbd.zzfe("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzaba.zza(view, customViewCallback);
        zzaba.setRequestedOrientation(i);
    }

    private static Context zza(WebView webView) {
        if (!(webView instanceof zzbfq)) {
            return webView.getContext();
        }
        zzbfq zzbfq = (zzbfq) webView;
        Activity zzzq = zzbfq.zzzq();
        if (zzzq != null) {
            return zzzq;
        }
        return zzbfq.getContext();
    }
}
