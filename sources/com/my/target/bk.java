package com.my.target;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.my.target.ga;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.net.URI;
import java.util.ArrayList;
import org.json.JSONObject;
public class bk {
    @NonNull
    public final String a;
    @NonNull
    public final WebViewClient b = new d(null);
    @Nullable
    public a c;
    @Nullable
    public ga d;
    public boolean e;
    public boolean f;

    public interface a {
        boolean a(int i, int i2, int i3, int i4, boolean z, int i5);

        boolean a(@NonNull ConsoleMessage consoleMessage, @NonNull bk bkVar);

        boolean a(@NonNull String str, @NonNull JsResult jsResult);

        boolean a(boolean z, bm bmVar);

        void aN();

        void aO();

        boolean aP();

        void b(@NonNull Uri uri);

        boolean b(float f, float f2);

        void c(@NonNull bk bkVar);

        boolean c(@Nullable Uri uri);

        boolean m(@NonNull String str);

        void onClose();

        void onVisibilityChanged(boolean z);
    }

    @SuppressLint({"RtlHardcoded"})
    public static class c {
        public static int n(@Nullable String str) {
            if (str == null) {
                return 53;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1314880604:
                    if (str.equals("top-right")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1012429441:
                    if (str.equals("top-left")) {
                        c = 0;
                        break;
                    }
                    break;
                case -655373719:
                    if (str.equals("bottom-left")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1163912186:
                    if (str.equals("bottom-right")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1288627767:
                    if (str.equals("bottom-center")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1755462605:
                    if (str.equals("top-center")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                return 51;
            }
            if (c == 1) {
                return 17;
            }
            if (c == 2) {
                return 83;
            }
            if (c == 3) {
                return 85;
            }
            if (c != 4) {
                return c != 5 ? 53 : 81;
            }
            return 49;
        }
    }

    public class d extends WebViewClient {
        public d(b bVar) {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            bk bkVar = bk.this;
            if (!bkVar.e) {
                bkVar.e = true;
                a aVar = bkVar.c;
                if (aVar != null) {
                    aVar.c(bkVar);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            a2.b.a.a.a.U0("Error: ", str);
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            bk.this.b(webResourceRequest.getUrl());
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            bk.this.b(Uri.parse(str));
            return true;
        }
    }

    public class e extends WebChromeClient {
        public e(b bVar) {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            bk bkVar = bk.this;
            a aVar = bkVar.c;
            return aVar != null ? aVar.a(consoleMessage, bkVar) : super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            a aVar = bk.this.c;
            return aVar != null ? aVar.a(str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
        }
    }

    public class f implements ga.a {
        public f(b bVar) {
        }

        @Override // com.my.target.ga.a
        public void aN() {
            a aVar = bk.this.c;
            if (aVar != null) {
                aVar.aN();
            }
        }

        @Override // com.my.target.ga.a
        public void onVisibilityChanged(boolean z) {
            a aVar = bk.this.c;
            if (aVar != null) {
                aVar.onVisibilityChanged(z);
            }
        }
    }

    public bk(@NonNull String str) {
        this.a = str;
    }

    public static bk g(@NonNull String str) {
        return new bk(str);
    }

    @NonNull
    public final String a(Rect rect) {
        return rect.left + "," + rect.top + "," + rect.width() + "," + rect.height();
    }

    public void a(@Nullable a aVar) {
        this.c = aVar;
    }

    public void a(@NonNull bn bnVar) {
        StringBuilder L = a2.b.a.a.a.L("mraidbridge.setScreenSize(");
        L.append(d(bnVar.aV()));
        L.append(");window.mraidbridge.setMaxSize(");
        L.append(d(bnVar.aU()));
        L.append(");window.mraidbridge.setCurrentPosition(");
        L.append(a(bnVar.aS()));
        L.append(");window.mraidbridge.setDefaultPosition(");
        L.append(a(bnVar.aT()));
        L.append(")");
        e(L.toString());
        e("mraidbridge.fireSizeChangeEvent(" + d(bnVar.aS()) + ")");
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void a(@NonNull ga gaVar) {
        this.d = gaVar;
        WebSettings settings = gaVar.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
            if ("interstitial".equals(this.a)) {
                settings.setMediaPlaybackRequiresUserGesture(false);
            }
        }
        this.d.setScrollContainer(false);
        this.d.setVerticalScrollBarEnabled(false);
        this.d.setHorizontalScrollBarEnabled(false);
        this.d.setWebViewClient(this.b);
        this.d.setWebChromeClient(new e(null));
        this.d.setVisibilityChangedListener(new f(null));
    }

    public void a(@NonNull String str, @NonNull String str2) {
        StringBuilder L = a2.b.a.a.a.L("mraidbridge.fireErrorEvent(");
        L.append(JSONObject.quote(str2));
        L.append(", ");
        L.append(JSONObject.quote(str));
        L.append(")");
        e(L.toString());
    }

    public void a(@NonNull ArrayList<String> arrayList) {
        StringBuilder L = a2.b.a.a.a.L("mraidbridge.setSupports(");
        L.append(TextUtils.join(",", arrayList));
        L.append(")");
        e(L.toString());
    }

    public void aL() {
        e("mraidbridge.fireReadyEvent()");
    }

    @VisibleForTesting
    public void b(@NonNull Uri uri) {
        a aVar;
        String scheme = uri.getScheme();
        String host = uri.getHost();
        if ("mytarget".equals(scheme)) {
            if ("onloadmraidjs".equals(host)) {
                ae.a("MraidBridge: JS call onLoad");
            }
            ae.a("MraidBridge: got mytarget scheme " + uri);
        } else if ("mraid".equals(scheme)) {
            if (host.contains(",")) {
                host = host.substring(0, host.indexOf(",")).trim();
            }
            ae.a("Got mraid command " + uri);
            String uri2 = uri.toString();
            JSONObject jSONObject = null;
            bl blVar = new bl(host, this.a);
            String blVar2 = blVar.toString();
            StringBuilder L = a2.b.a.a.a.L("mraidbridge.nativeComplete(");
            L.append(JSONObject.quote(blVar2));
            L.append(")");
            e(L.toString());
            int indexOf = uri2.indexOf("{");
            int lastIndexOf = uri2.lastIndexOf("}") + 1;
            if (indexOf >= 0 && lastIndexOf > 0 && indexOf < lastIndexOf) {
                try {
                    if (lastIndexOf <= uri2.length()) {
                        jSONObject = new JSONObject(uri2.substring(indexOf, lastIndexOf));
                    }
                } catch (Throwable th) {
                    a(blVar.toString(), th.getMessage());
                    return;
                }
            }
            c(blVar, jSONObject);
        } else {
            try {
                new URI(uri.toString());
                ga gaVar = this.d;
                if (gaVar != null && gaVar.dW() && (aVar = this.c) != null) {
                    aVar.b(uri);
                }
            } catch (Throwable unused) {
                ae.a("Invalid MRAID URL: " + uri);
                a("", "Mraid command sent an invalid URL");
            }
        }
    }

    @VisibleForTesting
    public boolean c(@NonNull bl blVar, @Nullable JSONObject jSONObject) {
        ga gaVar;
        String blVar2 = blVar.toString();
        if (blVar.da && (gaVar = this.d) != null && !gaVar.dW()) {
            a(blVar2, "Cannot execute this command unless the user clicks");
            return false;
        } else if (this.c == null) {
            a(blVar2, "Invalid state to execute this command");
            return false;
        } else if (this.d == null) {
            a(blVar2, "The current WebView is being destroyed");
            return false;
        } else {
            blVar2.hashCode();
            char c2 = 65535;
            switch (blVar2.hashCode()) {
                case -1910759310:
                    if (blVar2.equals("vpaidInit")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1886160473:
                    if (blVar2.equals("playVideo")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1289167206:
                    if (blVar2.equals(Tracker.Events.CREATIVE_EXPAND)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -934437708:
                    if (blVar2.equals("resize")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -733616544:
                    if (blVar2.equals("createCalendarEvent")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 0:
                    if (blVar2.equals("")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3417674:
                    if (blVar2.equals("open")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 94756344:
                    if (blVar2.equals("close")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 133423073:
                    if (blVar2.equals("setOrientationProperties")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 459238621:
                    if (blVar2.equals("storePicture")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 624734601:
                    if (blVar2.equals("setResizeProperties")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case 892543864:
                    if (blVar2.equals("vpaidEvent")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 1797992422:
                    if (blVar2.equals("playheadEvent")) {
                        c2 = '\f';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    this.c.aO();
                    break;
                case 1:
                    ae.a("playVideo is currently unsupported");
                    return false;
                case 2:
                    Uri uri = null;
                    if (jSONObject != null) {
                        uri = Uri.parse(jSONObject.getString("url"));
                    }
                    return this.c.c(uri);
                case 3:
                    return this.c.aP();
                case 4:
                    ae.a("createCalendarEvent is currently unsupported");
                    return false;
                case 5:
                    a(blVar2, "Unspecified MRAID Javascript command");
                    return false;
                case 6:
                    if (jSONObject != null) {
                        this.c.b(Uri.parse(jSONObject.getString("url")));
                        break;
                    } else {
                        a(blVar2, "open params cannot be null");
                        return false;
                    }
                case 7:
                    this.c.onClose();
                    break;
                case '\b':
                    if (jSONObject == null) {
                        a(blVar2, "setOrientationProperties params cannot be null");
                        return false;
                    }
                    boolean z = jSONObject.getBoolean("allowOrientationChange");
                    String string = jSONObject.getString("forceOrientation");
                    bm o = bm.o(string);
                    if (o != null) {
                        return this.c.a(z, o);
                    }
                    a(blVar2, "wrong orientation " + string);
                    return false;
                case '\t':
                    ae.a("storePicture is currently unsupported");
                    return false;
                case '\n':
                    if (jSONObject != null) {
                        return this.c.a(jSONObject.getInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY), jSONObject.getInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY), jSONObject.getInt("offsetX"), jSONObject.getInt("offsetY"), jSONObject.optBoolean("allowOffscreen", false), c.n(jSONObject.optString("customClosePosition")));
                    }
                    a(blVar2, "setResizeProperties params cannot be null");
                    return false;
                case 11:
                    if (jSONObject != null) {
                        return this.c.m(jSONObject.getString("event"));
                    }
                    a(blVar2, "vpaidEvent params cannot be null");
                    return false;
                case '\f':
                    if (jSONObject != null) {
                        return this.c.b((float) jSONObject.getDouble("remain"), (float) jSONObject.getDouble("duration"));
                    }
                    a(blVar2, "playheadEvent params cannot be null");
                    return false;
            }
            return true;
        }
    }

    @NonNull
    public final String d(Rect rect) {
        return rect.width() + "," + rect.height();
    }

    public void detach() {
        this.d = null;
    }

    public final void e(@NonNull String str) {
        if (this.d == null) {
            a2.b.a.a.a.U0("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t", str);
            return;
        }
        String e3 = a2.b.a.a.a.e3("javascript:window.", str, ";");
        StringBuilder L = a2.b.a.a.a.L("Injecting Javascript into MRAID WebView ");
        L.append(hashCode());
        L.append(": ");
        L.append(e3);
        ae.a(L.toString());
        this.d.loadUrl(e3);
    }

    public void h(@NonNull String str) {
        ga gaVar = this.d;
        if (gaVar == null) {
            ae.a("MRAID bridge called setContentHtml before WebView was attached");
            return;
        }
        this.e = false;
        gaVar.loadDataWithBaseURL("https://ad.mail.ru/", str, "text/html", "UTF-8", null);
    }

    public void i(String str) {
        StringBuilder L = a2.b.a.a.a.L("mraidbridge.setPlacementType(");
        L.append(JSONObject.quote(str));
        L.append(")");
        e(L.toString());
    }

    public boolean isVisible() {
        ga gaVar = this.d;
        return gaVar != null && gaVar.isVisible();
    }

    public void j(String str) {
        StringBuilder L = a2.b.a.a.a.L("mraidbridge.setState(");
        L.append(JSONObject.quote(str));
        L.append(")");
        e(L.toString());
    }

    public void q(boolean z) {
        if (z != this.f) {
            e("mraidbridge.setIsViewable(" + z + ")");
        }
        this.f = z;
    }
}
