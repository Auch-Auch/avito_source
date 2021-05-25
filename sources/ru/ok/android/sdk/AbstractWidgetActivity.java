package ru.ok.android.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;
import kotlinx.coroutines.DebugKt;
import ru.ok.android.sdk.util.OkEncryptUtil;
import ru.ok.android.sdk.util.OkRequestUtil;
public abstract class AbstractWidgetActivity extends Activity {
    public static final HashMap<String, String> DEFAULT_OPTIONS;
    public final HashMap<String, String> args = new HashMap<>();
    public String mAccessToken;
    public String mAppId;
    public String mSessionSecretKey;
    public boolean retryAllowed = true;

    public final class OkWidgetViewClient extends a7.b.a.a.a {
        public OkWidgetViewClient(Context context) {
            super(context);
        }

        @Override // a7.b.a.a.a, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            AbstractWidgetActivity.this.processError(getErrorMessage(i));
        }

        @Override // a7.b.a.a.a, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            AbstractWidgetActivity.this.processError(getErrorMessage(sslError));
        }

        @Override // a7.b.a.a.a, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!str.startsWith(AbstractWidgetActivity.this.getReturnUrl())) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            AbstractWidgetActivity.this.processResult(OkRequestUtil.getUrlParameters(str).getString("result"));
            return true;
        }
    }

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ((WebView) AbstractWidgetActivity.this.findViewById(R.id.web_view)).loadUrl(AbstractWidgetActivity.this.prepareUrl(null));
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AbstractWidgetActivity.this.processResult(this.a);
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        DEFAULT_OPTIONS = hashMap;
        hashMap.put("st.popup", DebugKt.DEBUG_PROPERTY_VALUE_ON);
        hashMap.put("st.silent", DebugKt.DEBUG_PROPERTY_VALUE_ON);
    }

    public final String getBaseUrl() {
        return Odnoklassniki.getInstance().getConnectBaseUrl() + "dk?st.cmd=" + getWidgetId() + "&st.access_token=" + this.mAccessToken + "&st.app=" + this.mAppId + "&st.return=" + getReturnUrl();
    }

    public abstract int getCancelledMessageId();

    public final String getReturnUrl() {
        StringBuilder L = a2.b.a.a.a.L("okwidget://");
        L.append(getWidgetId().toLowerCase());
        return L.toString();
    }

    public abstract String getWidgetId();

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        HashMap hashMap;
        super.onCreate(bundle);
        this.args.clear();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.mAppId = extras.getString(Shared.PARAM_APP_ID);
            this.mAccessToken = extras.getString("access_token");
            this.mSessionSecretKey = extras.getString(Shared.PARAM_SESSION_SECRET_KEY);
            if (extras.containsKey(Shared.PARAM_WIDGET_ARGS) && (hashMap = (HashMap) extras.getSerializable(Shared.PARAM_WIDGET_ARGS)) != null) {
                this.args.putAll(hashMap);
            }
            if (extras.containsKey(Shared.PARAM_WIDGET_RETRY_ALLOWED)) {
                this.retryAllowed = extras.getBoolean(Shared.PARAM_WIDGET_RETRY_ALLOWED, true);
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != i) {
            return false;
        }
        processError(getString(getCancelledMessageId()));
        return true;
    }

    public String prepareUrl(@Nullable HashMap<String, String> hashMap) {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<String, String> entry : this.args.entrySet()) {
            treeMap.put(entry.getKey(), entry.getValue());
        }
        treeMap.put("st.return", getReturnUrl());
        StringBuilder sb = new StringBuilder(200);
        StringBuilder sb2 = new StringBuilder(getBaseUrl());
        for (Map.Entry entry2 : treeMap.entrySet()) {
            if (Shared.WIDGET_SIGNED_ARGS.contains(entry2.getKey())) {
                sb.append((String) entry2.getKey());
                sb.append('=');
                sb.append((String) entry2.getValue());
            }
            if (!((String) entry2.getKey()).equals("st.return")) {
                sb2.append(Typography.amp);
                sb2.append((String) entry2.getKey());
                sb2.append('=');
                sb2.append(OkRequestUtil.encode((String) entry2.getValue()));
            }
        }
        String md5 = OkEncryptUtil.toMD5(((Object) sb) + this.mSessionSecretKey);
        if (hashMap == null) {
            hashMap = DEFAULT_OPTIONS;
        }
        for (Map.Entry<String, String> entry3 : hashMap.entrySet()) {
            sb2.append(Typography.amp);
            sb2.append(entry3.getKey());
            sb2.append('=');
            sb2.append(entry3.getValue());
        }
        return a2.b.a.a.a.t(sb2, "&st.signature=", md5);
    }

    public final void processError(String str) {
        if (!this.retryAllowed) {
            processResult(str);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(str);
        builder.setPositiveButton(getString(R.string.retry), new a());
        builder.setNegativeButton(getString(R.string.cancel), new b(str));
        try {
            builder.show();
        } catch (RuntimeException unused) {
            processResult(str);
        }
    }

    public abstract void processResult(String str);
}
