package com.my.target;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.GestureDetector;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public final class fr extends fs {
    @Nullable
    public a b;
    public boolean c;
    public boolean d;
    @Nullable
    public d e;

    public interface a {
        void d(@NonNull String str);

        void onError(@NonNull String str);
    }

    public class b implements g.a {
        public b() {
        }
    }

    public class c implements View.OnTouchListener {
        public final /* synthetic */ g a;

        public c(fr frVar, g gVar) {
            this.a = gVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
            if (r4 <= ((float) r0.getHeight())) goto L_0x003d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
            if (r2 != false) goto L_0x0058;
         */
        @Override // android.view.View.OnTouchListener
        @android.annotation.SuppressLint({"ClickableViewAccessibility"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
            /*
                r7 = this;
                com.my.target.fr$g r8 = r7.a
                java.util.Objects.requireNonNull(r8)
                int r0 = r9.getAction()
                r1 = 0
                if (r0 == 0) goto L_0x0058
                r2 = 1
                if (r0 == r2) goto L_0x0040
                r3 = 2
                if (r0 == r3) goto L_0x0013
                goto L_0x005b
            L_0x0013:
                android.view.View r0 = r8.a
                if (r0 != 0) goto L_0x0018
                goto L_0x003c
            L_0x0018:
                float r3 = r9.getX()
                float r4 = r9.getY()
                r5 = 0
                int r6 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r6 < 0) goto L_0x003c
                int r6 = r0.getWidth()
                float r6 = (float) r6
                int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
                if (r3 > 0) goto L_0x003c
                int r3 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r3 < 0) goto L_0x003c
                int r0 = r0.getHeight()
                float r0 = (float) r0
                int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r0 > 0) goto L_0x003c
                goto L_0x003d
            L_0x003c:
                r2 = 0
            L_0x003d:
                if (r2 == 0) goto L_0x005b
                goto L_0x0058
            L_0x0040:
                com.my.target.fr$g$a r9 = r8.b
                if (r9 == 0) goto L_0x0052
                java.lang.String r9 = "Gestures: user clicked"
                com.my.target.ae.a(r9)
                com.my.target.fr$g$a r8 = r8.b
                com.my.target.fr$b r8 = (com.my.target.fr.b) r8
                com.my.target.fr r8 = com.my.target.fr.this
                r8.d = r2
                goto L_0x005b
            L_0x0052:
                java.lang.String r8 = "View's onUserClick() is not registered."
                com.my.target.ae.a(r8)
                goto L_0x005b
            L_0x0058:
                r8.onTouchEvent(r9)
            L_0x005b:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.my.target.fr.c.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public interface d {
        void dN();
    }

    public static final class e extends WebChromeClient {
        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String message = consoleMessage.message();
            int lineNumber = consoleMessage.lineNumber();
            ae.a("js console message: " + message + " at line: " + lineNumber);
            return false;
        }
    }

    public static final class g extends GestureDetector {
        @NonNull
        public final View a;
        @Nullable
        public a b;

        public interface a {
        }

        public g(@NonNull Context context, @NonNull View view) {
            super(context, new GestureDetector.SimpleOnGestureListener());
            this.a = view;
            setIsLongpressEnabled(false);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public fr(@NonNull Context context) {
        super(context);
        e eVar = new e();
        f fVar = new f();
        g gVar = new g(getContext(), this);
        gVar.b = new b();
        setOnTouchListener(new c(this, gVar));
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setSupportZoom(false);
            settings.setAppCachePath(getContext().getCacheDir().getAbsolutePath());
            settings.setAllowFileAccess(false);
            settings.setAllowContentAccess(false);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        setWebChromeClient(eVar);
        setWebViewClient(fVar);
    }

    @Override // com.my.target.fs, android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        d dVar = this.e;
        if (dVar != null) {
            dVar.dN();
        }
    }

    public void setBannerWebViewListener(@Nullable a aVar) {
        this.b = aVar;
    }

    public void setData(@NonNull String str) {
        this.c = false;
        this.d = false;
        loadDataWithBaseURL("https://ad.mail.ru/", str, "text/html", "UTF-8", null);
    }

    public void setOnLayoutListener(@Nullable d dVar) {
        this.e = dVar;
    }

    public final class f extends WebViewClient {
        public f() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            fr frVar = fr.this;
            if (!frVar.c) {
                frVar.c = true;
                ae.a("page loaded");
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            ae.a("load page started");
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            ae.a("load failed. error: " + i + " description: " + str + " url: " + str2);
            super.onReceivedError(webView, i, str, str2);
            a aVar = fr.this.b;
            if (aVar != null) {
                if (str == null) {
                    str = "unknown JS error";
                }
                aVar.onError(str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f, float f2) {
            super.onScaleChanged(webView, f, f2);
            ae.a("scale new: " + f2 + " old: " + f);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Uri url;
            if (!fr.this.d || (url = webResourceRequest.getUrl()) == null) {
                return true;
            }
            String uri = url.toString();
            a aVar = fr.this.b;
            if (aVar != null) {
                aVar.d(uri);
            }
            fr.this.d = false;
            return true;
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            CharSequence description = webResourceError.getDescription();
            String charSequence = description != null ? description.toString() : null;
            int errorCode = webResourceError.getErrorCode();
            String uri = webResourceRequest.getUrl().toString();
            ae.a("load failed. error: " + errorCode + " description: " + charSequence + " url: " + uri);
            a aVar = fr.this.b;
            if (aVar != null) {
                if (charSequence == null) {
                    charSequence = "Unknown JS error";
                }
                aVar.onError(charSequence);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            fr frVar = fr.this;
            if (!frVar.d || str == null) {
                return true;
            }
            a aVar = frVar.b;
            if (aVar != null) {
                aVar.d(str);
            }
            fr.this.d = false;
            return true;
        }
    }
}
