package a7.b.a.a;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import ru.ok.android.sdk.R;
public class a extends WebViewClient {
    public final Context a;
    public boolean showPage = true;

    public a(Context context) {
        this.a = context;
    }

    public final String a(int i) {
        return this.a.getString(i);
    }

    public String getErrorMessage(int i) {
        String str;
        if (i == -11) {
            str = a(R.string.error_failed_ssl_handshake);
        } else if (i == -8) {
            str = a(R.string.error_timeout);
        } else if (i != -6) {
            str = i != -2 ? null : a(R.string.error_host_lookup);
        } else {
            str = a(R.string.error_connect);
        }
        return str != null ? str : a(R.string.error_unknown);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.showPage) {
            webView.setVisibility(0);
        } else {
            webView.setVisibility(4);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.showPage = false;
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.showPage = false;
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.showPage = true;
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public String getErrorMessage(SslError sslError) {
        String str;
        int primaryError = sslError.getPrimaryError();
        if (primaryError == 0) {
            str = a(R.string.error_ssl_not_yet_valid);
        } else if (primaryError == 1) {
            str = a(R.string.error_ssl_expired);
        } else if (primaryError == 2) {
            str = a(R.string.error_ssl_id_mismatch);
        } else if (primaryError != 3) {
            str = null;
        } else {
            str = a(R.string.error_ssl_untrusted);
        }
        if (str == null && primaryError == 4) {
            str = a(R.string.error_ssl_date_invalid);
        }
        return str != null ? str : a(R.string.error_unknown);
    }
}
