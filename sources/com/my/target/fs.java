package com.my.target;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class fs extends FrameLayout {
    @Nullable
    public WebView a;

    public fs(@NonNull Context context) {
        super(context);
        try {
            WebView webView = new WebView(V(context));
            this.a = webView;
            webView.clearCache(true);
            addView(this.a);
        } catch (Throwable th) {
            StringBuilder L = a.L("Webview cannot be initialized, Ad will not work properly ");
            L.append(th.getMessage());
            ae.b(L.toString());
            th.printStackTrace();
        }
    }

    @NonNull
    public static Context V(@NonNull Context context) {
        return Build.VERSION.SDK_INT < 23 ? context.createConfigurationContext(new Configuration()) : context;
    }

    public static void a(@NonNull Throwable th) {
        StringBuilder L = a.L("WebView fail: ");
        L.append(th.getMessage());
        ae.b(L.toString());
    }

    public boolean canGoBack() {
        try {
            WebView webView = this.a;
            return webView != null && webView.canGoBack();
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public void destroy() {
        WebView webView = this.a;
        if (webView != null) {
            try {
                webView.destroy();
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    @Nullable
    public WebSettings getSettings() {
        try {
            WebView webView = this.a;
            if (webView == null) {
                return null;
            }
            return webView.getSettings();
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    @Nullable
    public String getUrl() {
        try {
            WebView webView = this.a;
            if (webView == null) {
                return null;
            }
            return webView.getUrl();
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public void goBack() {
        WebView webView = this.a;
        if (webView != null) {
            try {
                webView.goBack();
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    public void loadDataWithBaseURL(@Nullable String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        WebView webView = this.a;
        if (webView != null) {
            try {
                webView.loadDataWithBaseURL(str, str2, str3, str4, str5);
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    public void loadUrl(String str) {
        WebView webView = this.a;
        if (webView != null) {
            try {
                webView.loadUrl(str);
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WebView webView = this.a;
        if (webView != null) {
            webView.layout(0, 0, i3 - i, i4 - i2);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        WebView webView = this.a;
        if (webView != null) {
            webView.measure(i, i2);
            setMeasuredDimension(this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public void onPause() {
        WebView webView = this.a;
        if (webView != null) {
            try {
                webView.onPause();
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    public void onResume() {
        WebView webView = this.a;
        if (webView != null) {
            try {
                webView.onResume();
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    @Override // android.view.View
    public void setHorizontalScrollBarEnabled(boolean z) {
        WebView webView = this.a;
        if (webView != null) {
            webView.setHorizontalScrollBarEnabled(z);
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public void setOnTouchListener(@Nullable View.OnTouchListener onTouchListener) {
        WebView webView = this.a;
        if (webView != null) {
            webView.setOnTouchListener(onTouchListener);
        }
    }

    @Override // android.view.View
    public void setScrollContainer(boolean z) {
        WebView webView = this.a;
        if (webView != null) {
            webView.setScrollContainer(z);
        }
    }

    @Override // android.view.View
    public void setVerticalScrollBarEnabled(boolean z) {
        WebView webView = this.a;
        if (webView != null) {
            webView.setVerticalScrollBarEnabled(z);
        }
    }

    public void setWebChromeClient(@Nullable WebChromeClient webChromeClient) {
        WebView webView = this.a;
        if (webView != null) {
            try {
                webView.setWebChromeClient(webChromeClient);
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    public void setWebViewClient(@NonNull WebViewClient webViewClient) {
        WebView webView = this.a;
        if (webView != null) {
            try {
                webView.setWebViewClient(webViewClient);
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    public void stopLoading() {
        WebView webView = this.a;
        if (webView != null) {
            try {
                webView.stopLoading();
            } catch (Throwable th) {
                a(th);
            }
        }
    }
}
