package com.facebook.internal;

import a2.g.r.i;
import a2.g.r.j;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.common.R;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
public class WebDialog extends Dialog {
    public static final int m = R.style.com_facebook_activity_theme;
    public static volatile int n;
    public String a;
    public String b;
    public OnCompleteListener c;
    public WebView d;
    public ProgressDialog e;
    public ImageView f;
    public FrameLayout g;
    public e h;
    public boolean i;
    public boolean j;
    public boolean k;
    public WindowManager.LayoutParams l;

    public interface OnCompleteListener {
        void onComplete(Bundle bundle, FacebookException facebookException);
    }

    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            WebDialog.this.cancel();
        }
    }

    public class b extends WebView {
        public b(WebDialog webDialog, Context context) {
            super(context);
        }

        @Override // android.webkit.WebView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            try {
                super.onWindowFocusChanged(z);
            } catch (NullPointerException unused) {
            }
        }
    }

    public class c implements View.OnTouchListener {
        public c(WebDialog webDialog) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.hasFocus()) {
                return false;
            }
            view.requestFocus();
            return false;
        }
    }

    public class d extends WebViewClient {
        public d(a aVar) {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            WebDialog webDialog = WebDialog.this;
            if (!webDialog.j) {
                webDialog.e.dismiss();
            }
            WebDialog.this.g.setBackgroundColor(0);
            WebDialog.this.d.setVisibility(0);
            WebDialog.this.f.setVisibility(0);
            WebDialog.this.k = true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Utility.logd("FacebookSDK.WebDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
            WebDialog webDialog = WebDialog.this;
            if (!webDialog.j) {
                webDialog.e.show();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            WebDialog.this.sendErrorToListener(new FacebookDialogException(str, i, str2));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.cancel();
            WebDialog.this.sendErrorToListener(new FacebookDialogException(null, -11, null));
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x008e  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0094  */
        @Override // android.webkit.WebViewClient
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean shouldOverrideUrlLoading(android.webkit.WebView r6, java.lang.String r7) {
            /*
                r5 = this;
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r0 = "Redirect URL: "
                r6.append(r0)
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                java.lang.String r0 = "FacebookSDK.WebDialog"
                com.facebook.internal.Utility.logd(r0, r6)
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                java.lang.String r6 = r6.b
                boolean r6 = r7.startsWith(r6)
                r0 = 1
                if (r6 == 0) goto L_0x00a4
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                android.os.Bundle r6 = r6.parseResponseUri(r7)
                java.lang.String r7 = "error"
                java.lang.String r7 = r6.getString(r7)
                if (r7 != 0) goto L_0x0035
                java.lang.String r7 = "error_type"
                java.lang.String r7 = r6.getString(r7)
            L_0x0035:
                java.lang.String r1 = "error_msg"
                java.lang.String r1 = r6.getString(r1)
                if (r1 != 0) goto L_0x0043
                java.lang.String r1 = "error_message"
                java.lang.String r1 = r6.getString(r1)
            L_0x0043:
                if (r1 != 0) goto L_0x004b
                java.lang.String r1 = "error_description"
                java.lang.String r1 = r6.getString(r1)
            L_0x004b:
                java.lang.String r2 = "error_code"
                java.lang.String r2 = r6.getString(r2)
                boolean r3 = com.facebook.internal.Utility.isNullOrEmpty(r2)
                r4 = -1
                if (r3 != 0) goto L_0x005d
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x005d }
                goto L_0x005e
            L_0x005d:
                r2 = -1
            L_0x005e:
                boolean r3 = com.facebook.internal.Utility.isNullOrEmpty(r7)
                if (r3 == 0) goto L_0x0072
                boolean r3 = com.facebook.internal.Utility.isNullOrEmpty(r1)
                if (r3 == 0) goto L_0x0072
                if (r2 != r4) goto L_0x0072
                com.facebook.internal.WebDialog r7 = com.facebook.internal.WebDialog.this
                r7.sendSuccessToListener(r6)
                goto L_0x00a3
            L_0x0072:
                if (r7 == 0) goto L_0x008a
                java.lang.String r6 = "access_denied"
                boolean r6 = r7.equals(r6)
                if (r6 != 0) goto L_0x0084
                java.lang.String r6 = "OAuthAccessDeniedException"
                boolean r6 = r7.equals(r6)
                if (r6 == 0) goto L_0x008a
            L_0x0084:
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                r6.cancel()
                goto L_0x00a3
            L_0x008a:
                r6 = 4201(0x1069, float:5.887E-42)
                if (r2 != r6) goto L_0x0094
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                r6.cancel()
                goto L_0x00a3
            L_0x0094:
                com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
                r6.<init>(r2, r7, r1)
                com.facebook.internal.WebDialog r7 = com.facebook.internal.WebDialog.this
                com.facebook.FacebookServiceException r2 = new com.facebook.FacebookServiceException
                r2.<init>(r6, r1)
                r7.sendErrorToListener(r2)
            L_0x00a3:
                return r0
            L_0x00a4:
                java.lang.String r6 = "fbconnect://cancel"
                boolean r6 = r7.startsWith(r6)
                if (r6 == 0) goto L_0x00b2
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                r6.cancel()
                return r0
            L_0x00b2:
                java.lang.String r6 = "touch"
                boolean r6 = r7.contains(r6)
                r1 = 0
                if (r6 == 0) goto L_0x00bc
                return r1
            L_0x00bc:
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this     // Catch:{ ActivityNotFoundException -> 0x00d1 }
                android.content.Context r6 = r6.getContext()     // Catch:{ ActivityNotFoundException -> 0x00d1 }
                android.content.Intent r2 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x00d1 }
                java.lang.String r3 = "android.intent.action.VIEW"
                android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ ActivityNotFoundException -> 0x00d1 }
                r2.<init>(r3, r7)     // Catch:{ ActivityNotFoundException -> 0x00d1 }
                r6.startActivity(r2)     // Catch:{ ActivityNotFoundException -> 0x00d1 }
                return r0
            L_0x00d1:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.WebDialog.d.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
        }
    }

    public class e extends AsyncTask<Void, Void, String[]> {
        public String a;
        public Bundle b;
        public Exception[] c;

        public e(String str, Bundle bundle) {
            this.a = str;
            this.b = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // android.os.AsyncTask
        public String[] doInBackground(Void[] voidArr) {
            String[] stringArray = this.b.getStringArray("media");
            String[] strArr = new String[stringArray.length];
            this.c = new Exception[stringArray.length];
            CountDownLatch countDownLatch = new CountDownLatch(stringArray.length);
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            for (int i = 0; i < stringArray.length; i++) {
                try {
                    if (isCancelled()) {
                        Iterator it = concurrentLinkedQueue.iterator();
                        while (it.hasNext()) {
                            ((AsyncTask) it.next()).cancel(true);
                        }
                        return null;
                    }
                    Uri parse = Uri.parse(stringArray[i]);
                    if (Utility.isWebUri(parse)) {
                        strArr[i] = parse.toString();
                        countDownLatch.countDown();
                    } else {
                        concurrentLinkedQueue.add(ShareInternalUtility.newUploadStagingResourceWithImageRequest(currentAccessToken, parse, new j(this, strArr, i, countDownLatch)).executeAsync());
                    }
                } catch (Exception unused) {
                    Iterator it2 = concurrentLinkedQueue.iterator();
                    while (it2.hasNext()) {
                        ((AsyncTask) it2.next()).cancel(true);
                    }
                }
            }
            countDownLatch.await();
            return strArr;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.os.AsyncTask
        public void onPostExecute(String[] strArr) {
            String[] strArr2 = strArr;
            WebDialog.this.e.dismiss();
            Exception[] excArr = this.c;
            for (Exception exc : excArr) {
                if (exc != null) {
                    WebDialog.this.sendErrorToListener(exc);
                    return;
                }
            }
            if (strArr2 == null) {
                WebDialog.this.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                return;
            }
            List asList = Arrays.asList(strArr2);
            if (asList.contains(null)) {
                WebDialog.this.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                return;
            }
            Utility.putJSONValueInBundle(this.b, "media", new JSONArray((Collection) asList));
            WebDialog.this.a = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/" + ServerProtocol.DIALOG_PATH + this.a, this.b).toString();
            WebDialog.this.b((WebDialog.this.f.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WebDialog(android.content.Context r2, java.lang.String r3) {
        /*
            r1 = this;
            int r0 = getWebDialogTheme()
            if (r0 != 0) goto L_0x000a
            int r0 = getWebDialogTheme()
        L_0x000a:
            r1.<init>(r2, r0)
            java.lang.String r2 = "fbconnect://success"
            r1.b = r2
            r2 = 0
            r1.i = r2
            r1.j = r2
            r1.k = r2
            r1.a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.WebDialog.<init>(android.content.Context, java.lang.String):void");
    }

    public static int getWebDialogTheme() {
        Validate.sdkInitialized();
        return n;
    }

    public static void initDefaultTheme(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null && n == 0) {
                    setWebDialogTheme(applicationInfo.metaData.getInt(FacebookSdk.WEB_DIALOG_THEME));
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    public static WebDialog newInstance(Context context, String str, Bundle bundle, int i2, OnCompleteListener onCompleteListener) {
        initDefaultTheme(context);
        return new WebDialog(context, str, bundle, i2, onCompleteListener);
    }

    public static void setWebDialogTheme(int i2) {
        if (i2 == 0) {
            i2 = m;
        }
        n = i2;
    }

    public final int a(int i2, float f2, int i3, int i4) {
        int i5 = (int) (((float) i2) / f2);
        double d2 = 0.5d;
        if (i5 <= i3) {
            d2 = 1.0d;
        } else if (i5 < i4) {
            d2 = 0.5d + ((((double) (i4 - i5)) / ((double) (i4 - i3))) * 0.5d);
        }
        return (int) (((double) i2) * d2);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void b(int i2) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        b bVar = new b(this, getContext());
        this.d = bVar;
        bVar.setVerticalScrollBarEnabled(false);
        this.d.setHorizontalScrollBarEnabled(false);
        this.d.setWebViewClient(new d(null));
        this.d.getSettings().setJavaScriptEnabled(true);
        this.d.loadUrl(this.a);
        this.d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.d.setVisibility(4);
        this.d.getSettings().setSavePassword(false);
        this.d.getSettings().setSaveFormData(false);
        this.d.setFocusable(true);
        this.d.setFocusableInTouchMode(true);
        this.d.setOnTouchListener(new c(this));
        linearLayout.setPadding(i2, i2, i2, i2);
        linearLayout.addView(this.d);
        linearLayout.setBackgroundColor(-872415232);
        this.g.addView(linearLayout);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.c != null && !this.i) {
            sendErrorToListener(new FacebookOperationCanceledException());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        ProgressDialog progressDialog;
        WebView webView = this.d;
        if (webView != null) {
            webView.stopLoading();
        }
        if (!this.j && (progressDialog = this.e) != null && progressDialog.isShowing()) {
            this.e.dismiss();
        }
        super.dismiss();
    }

    public OnCompleteListener getOnCompleteListener() {
        return this.c;
    }

    public WebView getWebView() {
        return this.d;
    }

    public boolean isListenerCalled() {
        return this.i;
    }

    public boolean isPageFinished() {
        return this.k;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        WindowManager.LayoutParams layoutParams;
        this.j = false;
        if (Utility.mustFixWindowParamsForAutofill(getContext()) && (layoutParams = this.l) != null && layoutParams.token == null) {
            layoutParams.token = getOwnerActivity().getWindow().getAttributes().token;
            StringBuilder L = a2.b.a.a.a.L("Set token on onAttachedToWindow(): ");
            L.append(this.l.token);
            Utility.logd("FacebookSDK.WebDialog", L.toString());
        }
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        this.e = progressDialog;
        progressDialog.requestWindowFeature(1);
        this.e.setMessage(getContext().getString(R.string.com_facebook_loading));
        this.e.setCanceledOnTouchOutside(false);
        this.e.setOnCancelListener(new a());
        requestWindowFeature(1);
        this.g = new FrameLayout(getContext());
        resize();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        ImageView imageView = new ImageView(getContext());
        this.f = imageView;
        imageView.setOnClickListener(new i(this));
        this.f.setImageDrawable(getContext().getResources().getDrawable(R.drawable.com_facebook_close));
        this.f.setVisibility(4);
        if (this.a != null) {
            b((this.f.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
        this.g.addView(this.f, new ViewGroup.LayoutParams(-2, -2));
        setContentView(this.g);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.j = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            WebView webView = this.d;
            if (webView == null || !webView.canGoBack()) {
                cancel();
            } else {
                this.d.goBack();
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        e eVar = this.h;
        if (eVar == null || eVar.getStatus() != AsyncTask.Status.PENDING) {
            resize();
            return;
        }
        this.h.execute(new Void[0]);
        this.e.show();
    }

    @Override // android.app.Dialog
    public void onStop() {
        e eVar = this.h;
        if (eVar != null) {
            eVar.cancel(true);
            this.e.dismiss();
        }
        super.onStop();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        if (layoutParams.token == null) {
            this.l = layoutParams;
        }
        super.onWindowAttributesChanged(layoutParams);
    }

    public Bundle parseResponseUri(String str) {
        Uri parse = Uri.parse(str);
        Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
        parseUrlQueryString.putAll(Utility.parseUrlQueryString(parse.getFragment()));
        return parseUrlQueryString;
    }

    public void resize() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        int i4 = i2 < i3 ? i2 : i3;
        if (i2 < i3) {
            i2 = i3;
        }
        getWindow().setLayout(Math.min(a(i4, displayMetrics.density, 480, 800), displayMetrics.widthPixels), Math.min(a(i2, displayMetrics.density, 800, 1280), displayMetrics.heightPixels));
    }

    public void sendErrorToListener(Throwable th) {
        FacebookException facebookException;
        if (this.c != null && !this.i) {
            this.i = true;
            if (th instanceof FacebookException) {
                facebookException = (FacebookException) th;
            } else {
                facebookException = new FacebookException(th);
            }
            this.c.onComplete(null, facebookException);
            dismiss();
        }
    }

    public void sendSuccessToListener(Bundle bundle) {
        OnCompleteListener onCompleteListener = this.c;
        if (onCompleteListener != null && !this.i) {
            this.i = true;
            onCompleteListener.onComplete(bundle, null);
            dismiss();
        }
    }

    public void setExpectedRedirectUrl(String str) {
        this.b = str;
    }

    public void setOnCompleteListener(OnCompleteListener onCompleteListener) {
        this.c = onCompleteListener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebDialog(Context context, String str, Bundle bundle, int i2, OnCompleteListener onCompleteListener) {
        super(context, i2 == 0 ? getWebDialogTheme() : i2);
        String str2 = ServerProtocol.DIALOG_REDIRECT_URI;
        this.b = str2;
        this.i = false;
        this.j = false;
        this.k = false;
        bundle = bundle == null ? new Bundle() : bundle;
        str2 = Utility.isChromeOS(context) ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : str2;
        this.b = str2;
        bundle.putString("redirect_uri", str2);
        bundle.putString("display", "touch");
        bundle.putString("client_id", FacebookSdk.getApplicationId());
        bundle.putString(ServerProtocol.DIALOG_PARAM_SDK_VERSION, String.format(Locale.ROOT, "android-%s", FacebookSdk.getSdkVersion()));
        this.c = onCompleteListener;
        if (!str.equals("share") || !bundle.containsKey("media")) {
            String dialogAuthority = ServerProtocol.getDialogAuthority();
            this.a = Utility.buildUri(dialogAuthority, FacebookSdk.getGraphApiVersion() + "/" + ServerProtocol.DIALOG_PATH + str, bundle).toString();
            return;
        }
        this.h = new e(str, bundle);
    }

    public static class Builder {
        public Context a;
        public String b;
        public String c;
        public int d;
        public OnCompleteListener e;
        public Bundle f;
        public AccessToken g;

        public Builder(Context context, String str, Bundle bundle) {
            this.g = AccessToken.getCurrentAccessToken();
            if (!AccessToken.isCurrentAccessTokenActive()) {
                String metadataApplicationId = Utility.getMetadataApplicationId(context);
                if (metadataApplicationId != null) {
                    this.b = metadataApplicationId;
                } else {
                    throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
            }
            this.a = context;
            this.c = str;
            if (bundle != null) {
                this.f = bundle;
            } else {
                this.f = new Bundle();
            }
        }

        public WebDialog build() {
            AccessToken accessToken = this.g;
            if (accessToken != null) {
                this.f.putString("app_id", accessToken.getApplicationId());
                this.f.putString("access_token", this.g.getToken());
            } else {
                this.f.putString("app_id", this.b);
            }
            return WebDialog.newInstance(this.a, this.c, this.f, this.d, this.e);
        }

        public String getApplicationId() {
            return this.b;
        }

        public Context getContext() {
            return this.a;
        }

        public OnCompleteListener getListener() {
            return this.e;
        }

        public Bundle getParameters() {
            return this.f;
        }

        public int getTheme() {
            return this.d;
        }

        public Builder setOnCompleteListener(OnCompleteListener onCompleteListener) {
            this.e = onCompleteListener;
            return this;
        }

        public Builder setTheme(int i) {
            this.d = i;
            return this;
        }

        public Builder(Context context, String str, String str2, Bundle bundle) {
            str = str == null ? Utility.getMetadataApplicationId(context) : str;
            Validate.notNullOrEmpty(str, "applicationId");
            this.b = str;
            this.a = context;
            this.c = str2;
            if (bundle != null) {
                this.f = bundle;
            } else {
                this.f = new Bundle();
            }
        }
    }
}
