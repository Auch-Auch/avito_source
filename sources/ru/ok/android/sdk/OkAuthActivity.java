package ru.ok.android.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import java.net.URLEncoder;
import ru.ok.android.sdk.util.OkAuthType;
public class OkAuthActivity extends Activity {
    public static final int RESULT_CANCELLED = 3;
    public static final int RESULT_FAILED = 2;
    public String a;
    public String b;
    public String c;
    public String[] d;
    public OkAuthType e;
    public boolean f;
    public boolean g = false;
    public WebView h;
    public boolean i;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            OkAuthActivity okAuthActivity = OkAuthActivity.this;
            int i2 = OkAuthActivity.RESULT_FAILED;
            okAuthActivity.a();
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            OkAuthActivity.this.onCancel(this.a);
        }
    }

    public class c extends a7.b.a.a.a {
        public c(Context context) {
            super(context);
        }

        @Override // a7.b.a.a.a, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            OkAuthActivity okAuthActivity = OkAuthActivity.this;
            String errorMessage = getErrorMessage(i);
            int i2 = OkAuthActivity.RESULT_FAILED;
            okAuthActivity.c(errorMessage);
        }

        @Override // a7.b.a.a.a, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            OkAuthActivity okAuthActivity = OkAuthActivity.this;
            String errorMessage = getErrorMessage(sslError);
            int i = OkAuthActivity.RESULT_FAILED;
            okAuthActivity.c(errorMessage);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
            if (r14.equals("expires_in") == false) goto L_0x0045;
         */
        @Override // a7.b.a.a.a, android.webkit.WebViewClient
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean shouldOverrideUrlLoading(android.webkit.WebView r19, java.lang.String r20) {
            /*
            // Method dump skipped, instructions count: 232
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.ok.android.sdk.OkAuthActivity.c.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
        }
    }

    public final void a() {
        boolean z;
        boolean z2 = false;
        if (!((this.a == null || this.b == null) ? false : true)) {
            onFail(getString(R.string.no_application_data));
            return;
        }
        OkAuthType okAuthType = this.e;
        if (okAuthType == OkAuthType.NATIVE_SSO || okAuthType == OkAuthType.ANY) {
            Intent intent = new Intent();
            intent.setClassName("ru.ok.android", "ru.ok.android.external.LoginExternal");
            ResolveInfo resolveActivity = getPackageManager().resolveActivity(intent, 0);
            if (this.f && resolveActivity == null) {
                intent.setClassName("ru.ok.android.debug", "ru.ok.android.external.LoginExternal");
                resolveActivity = getPackageManager().resolveActivity(intent, 0);
            }
            if (resolveActivity != null) {
                try {
                    PackageInfo packageInfo = getPackageManager().getPackageInfo(resolveActivity.activityInfo.packageName, 64);
                    if (packageInfo != null) {
                        if (packageInfo.versionCode >= 120) {
                            z = false;
                            for (Signature signature : packageInfo.signatures) {
                                try {
                                    if (signature.toCharsString().equals("3082025b308201c4a00302010202044f6760f9300d06092a864886f70d01010505003071310c300a06035504061303727573310c300a06035504081303737062310c300a0603550407130373706231163014060355040a130d4f646e6f6b6c6173736e696b6931143012060355040b130b6d6f62696c65207465616d311730150603550403130e416e647265792041736c616d6f763020170d3132303331393136333831375a180f32303636313232313136333831375a3071310c300a06035504061303727573310c300a06035504081303737062310c300a0603550407130373706231163014060355040a130d4f646e6f6b6c6173736e696b6931143012060355040b130b6d6f62696c65207465616d311730150603550403130e416e647265792041736c616d6f7630819f300d06092a864886f70d010101050003818d003081890281810080bea15bf578b898805dfd26346b2fbb662889cd6aba3f8e53b5b27c43a984eeec9a5d21f6f11667d987b77653f4a9651e20b94ff10594f76a93a6a36e6a42f4d851847cf1da8d61825ce020b7020cd1bc2eb435b0d416908be9393516ca1976ff736733c1d48ff17cd57f21ad49e05fc99384273efc5546e4e53c5e9f391c430203010001300d06092a864886f70d0101050500038181007d884df69a9748eabbdcfe55f07360433b23606d3b9d4bca03109c3ffb80fccb7809dfcbfd5a466347f1daf036fbbf1521754c2d1d999f9cbc66b884561e8201459aa414677e411e66360c3840ca4727da77f6f042f2c011464e99f34ba7df8b4bceb4fa8231f1d346f4063f7ba0e887918775879e619786728a8078c76647ed")) {
                                        z = true;
                                    }
                                } catch (PackageManager.NameNotFoundException unused) {
                                }
                            }
                            if (z) {
                                intent.putExtra("client_id", this.a);
                                intent.putExtra(Shared.PARAM_CLIENT_SECRET, "6C6B6397C2BCE5EDB7290039");
                                intent.putExtra("redirect_uri", this.c);
                                String[] strArr = this.d;
                                if (strArr != null && strArr.length > 0) {
                                    intent.putExtra(Shared.PARAM_SCOPES, strArr);
                                }
                                try {
                                    startActivityForResult(intent, 31337);
                                } catch (ActivityNotFoundException unused2) {
                                }
                            }
                            z2 = z;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused3) {
                    z = false;
                }
            }
            if (z2) {
                this.g = true;
                return;
            } else if (this.e == OkAuthType.NATIVE_SSO) {
                onFail(getString(R.string.no_ok_application_installed));
                return;
            }
        }
        OkAuthType okAuthType2 = this.e;
        if (okAuthType2 == OkAuthType.WEBVIEW_OAUTH || okAuthType2 == OkAuthType.ANY) {
            this.h.loadUrl(b());
        }
    }

    public final String b() {
        String format = String.format(Odnoklassniki.getInstance().getConnectBaseUrl() + "oauth/authorize?client_id=%s&response_type=token&redirect_uri=%s&layout=m&platform=%s", this.a, this.c, "ANDROID");
        String[] strArr = this.d;
        return (strArr == null || strArr.length <= 0) ? format : a2.b.a.a.a.e3(format, "&scope=", URLEncoder.encode(TextUtils.join(";", strArr)));
    }

    public final void c(String str) {
        if (!this.i && !isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(str);
            builder.setPositiveButton(getString(R.string.retry), new a());
            builder.setNegativeButton(getString(R.string.cancel), new b(str));
            try {
                builder.show();
            } catch (RuntimeException unused) {
                onCancel(str);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    @Override // android.app.Activity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r8, int r9, android.content.Intent r10) {
        /*
            r7 = this;
            r0 = 31337(0x7a69, float:4.3912E-41)
            if (r8 != r0) goto L_0x0044
            r8 = 0
            r7.g = r8
            r0 = 1
            if (r10 == 0) goto L_0x0011
            java.lang.String r1 = "error"
            java.lang.String r1 = r10.getStringExtra(r1)
            goto L_0x0013
        L_0x0011:
            java.lang.String r1 = ""
        L_0x0013:
            r2 = -1
            if (r9 != r2) goto L_0x003a
            java.lang.String r9 = "access_token"
            java.lang.String r9 = r10.getStringExtra(r9)
            java.lang.String r2 = "session_secret_key"
            java.lang.String r2 = r10.getStringExtra(r2)
            java.lang.String r3 = "refresh_token"
            java.lang.String r3 = r10.getStringExtra(r3)
            r4 = 0
            java.lang.String r6 = "expires_in"
            long r4 = r10.getLongExtra(r6, r4)
            if (r9 == 0) goto L_0x003a
            if (r2 == 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r2 = r3
        L_0x0036:
            r7.onSuccess(r9, r2, r4)
            goto L_0x003b
        L_0x003a:
            r8 = 1
        L_0x003b:
            if (r8 == 0) goto L_0x0040
            r7.onFail(r1)
        L_0x0040:
            r7.finish()
            goto L_0x0047
        L_0x0044:
            super.onActivityResult(r8, r9, r10)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.ok.android.sdk.OkAuthActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void onCancel(String str) {
        Intent intent = new Intent();
        intent.putExtra("error", str);
        setResult(3, intent);
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ok_auth_activity);
        WebView webView = (WebView) findViewById(R.id.web_view);
        this.h = webView;
        webView.setWebViewClient(new c(this));
        this.h.getSettings().setJavaScriptEnabled(true);
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        this.a = bundle.getString("client_id");
        this.b = bundle.getString(Shared.PARAM_APP_KEY);
        String string = bundle.getString("redirect_uri");
        this.c = string;
        if (string == null) {
            this.c = "okauth://auth";
        }
        this.d = bundle.getStringArray(Shared.PARAM_SCOPES);
        this.e = (OkAuthType) bundle.getSerializable("auth_type");
        this.f = bundle.getBoolean(Shared.PARAM_ALLOW_DEBUG_OK_SSO);
        boolean z = bundle.getBoolean("SSO_STARTED", false);
        this.g = z;
        if (!z) {
            a();
        }
    }

    public final void onFail(String str) {
        Intent intent = new Intent();
        intent.putExtra("error", str);
        setResult(2, intent);
        finish();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (4 != i2) {
            return false;
        }
        c(getString(R.string.authorization_canceled));
        return true;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.i = false;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("client_id", this.a);
        bundle.putString(Shared.PARAM_APP_KEY, this.b);
        bundle.putString("redirect_uri", this.c);
        bundle.putStringArray(Shared.PARAM_SCOPES, this.d);
        bundle.putSerializable("auth_type", this.e);
        bundle.putBoolean("SSO_STARTED", this.g);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.i = true;
    }

    public final void onSuccess(String str, String str2, long j) {
        SharedPreferences.Editor edit = getSharedPreferences(Shared.PREFERENCES_FILE, 0).edit();
        edit.putString("acctkn", str);
        edit.putString("ssk", str2);
        edit.apply();
        Intent intent = new Intent();
        intent.putExtra("access_token", str);
        intent.putExtra(Shared.PARAM_SESSION_SECRET_KEY, str2);
        if (j > 0) {
            intent.putExtra("expires_in", j);
        }
        setResult(-1, intent);
        finish();
    }
}
