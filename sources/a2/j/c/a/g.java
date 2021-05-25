package a2.j.c.a;

import android.net.Uri;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.androidbrowserhelper.trusted.WebViewFallbackActivity;
import java.util.Iterator;
public class g extends WebViewClient {
    public final /* synthetic */ WebViewFallbackActivity a;

    public g(WebViewFallbackActivity webViewFallbackActivity) {
        this.a = webViewFallbackActivity;
    }

    public final boolean a(Uri uri) {
        boolean z;
        Uri uri2 = this.a.c;
        if (!"data".equals(uri.getScheme()) && !b(uri, uri2)) {
            Iterator<Uri> it = this.a.f.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (b(it.next(), uri)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                new CustomTabsIntent.Builder().setToolbarColor(this.a.d).build().launchUrl(this.a, uri);
                return true;
            }
        }
        return false;
    }

    public final boolean b(Uri uri, Uri uri2) {
        return uri.getScheme().equalsIgnoreCase(uri2.getScheme()) && uri.getHost().equalsIgnoreCase(uri2.getHost()) && uri.getPort() == uri2.getPort();
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        ViewGroup viewGroup = (ViewGroup) webView.getParent();
        viewGroup.removeView(webView);
        webView.destroy();
        this.a.e = new WebView(webView.getContext());
        this.a.e.setWebViewClient(this);
        WebSettings settings = this.a.e.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        viewGroup.addView(this.a.e);
        Toast.makeText(webView.getContext(), "Recovering from crash", 1).show();
        WebViewFallbackActivity webViewFallbackActivity = this.a;
        webViewFallbackActivity.e.loadUrl(webViewFallbackActivity.c.toString());
        return true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return a(Uri.parse(str));
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 21)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return a(webResourceRequest.getUrl());
    }
}
