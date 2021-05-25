package com.vk.sdk.dialogs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vk.sdk.R;
import com.vk.sdk.VKServiceActivity;
import com.vk.sdk.api.VKError;
import com.vk.sdk.util.VKUtil;
import java.util.Locale;
import java.util.Map;
public class VKOpenAuthDialog implements DialogInterface.OnDismissListener {
    public static final String VK_EXTRA_API_VERSION = "version";
    public static final String VK_EXTRA_CLIENT_ID = "client_id";
    public static final String VK_EXTRA_REVOKE = "revoke";
    public static final String VK_EXTRA_SCOPE = "scope";
    public static final String VK_EXTRA_TOKEN_DATA = "extra-token-data";
    public static final String VK_EXTRA_VALIDATION_REQUEST = "extra-validation-request";
    public static final String VK_RESULT_INTENT_NAME = "com.vk.auth-token";
    public Bundle mBundle;
    public Intent mData;
    public Dialog mDialog;
    public View mProgress;
    public int mReqCode;
    public int mResCode = -1;
    public View mView;
    @Nullable
    public VKError mVkError;
    public WebView mWebView;

    public class a implements DialogInterface.OnCancelListener {
        public final /* synthetic */ Dialog a;

        public a(VKOpenAuthDialog vKOpenAuthDialog, Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.a.dismiss();
        }
    }

    public static class b extends WebViewClient {
        public boolean a = true;
        @NonNull
        public final VKOpenAuthDialog b;

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Dialog dialog = b.this.b.mDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        }

        /* renamed from: com.vk.sdk.dialogs.VKOpenAuthDialog$b$b  reason: collision with other inner class name */
        public class DialogInterface$OnClickListenerC0324b implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC0324b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                b.this.b.a();
            }
        }

        public b(@NonNull VKOpenAuthDialog vKOpenAuthDialog) {
            this.b = vKOpenAuthDialog;
        }

        public boolean a(String str) {
            if (!str.startsWith("https://oauth.vk.com/blank.html")) {
                return false;
            }
            Intent intent = new Intent(VKOpenAuthDialog.VK_RESULT_INTENT_NAME);
            String substring = str.substring(str.indexOf(35) + 1);
            intent.putExtra(VKOpenAuthDialog.VK_EXTRA_TOKEN_DATA, substring);
            Map<String, String> explodeQueryString = VKUtil.explodeQueryString(substring);
            VKError vKError = this.b.mVkError;
            if (vKError != null) {
                intent.putExtra(VKOpenAuthDialog.VK_EXTRA_VALIDATION_REQUEST, vKError.request.registerObject());
            }
            if (explodeQueryString == null || (!explodeQueryString.containsKey("error") && !explodeQueryString.containsKey("cancel"))) {
                VKOpenAuthDialog vKOpenAuthDialog = this.b;
                vKOpenAuthDialog.mResCode = -1;
                vKOpenAuthDialog.mData = intent;
            } else {
                VKOpenAuthDialog vKOpenAuthDialog2 = this.b;
                vKOpenAuthDialog2.mResCode = 0;
                vKOpenAuthDialog2.mData = intent;
            }
            Dialog dialog = this.b.mDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.a) {
                View view = this.b.mProgress;
                if (view != null) {
                    view.setVisibility(8);
                }
                webView.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            a(str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.a = false;
            try {
                new AlertDialog.Builder(webView.getContext()).setMessage(str).setPositiveButton(R.string.vk_retry, new DialogInterface$OnClickListenerC0324b()).setNegativeButton(17039360, new a()).show();
            } catch (Exception unused) {
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (a(str)) {
                return true;
            }
            this.a = true;
            return false;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x004e: APUT  
      (r11v1 java.lang.Object[])
      (4 ??[int, float, short, byte, char])
      (wrap: java.lang.Integer : 0x004a: INVOKE  (r1v15 java.lang.Integer) = (r1v14 int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     */
    @SuppressLint({"SetJavaScriptEnabled"})
    public final void a() {
        try {
            VKError vKError = this.mVkError;
            String str = vKError == null ? null : vKError.redirectUri;
            if (str == null) {
                int i = this.mBundle.getInt("client_id", 0);
                String string = this.mBundle.getString("scope");
                String string2 = this.mBundle.getString("version");
                boolean z = this.mBundle.getBoolean(VK_EXTRA_REVOKE, false);
                Locale locale = Locale.US;
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = string;
                objArr[2] = "https://oauth.vk.com/blank.html";
                objArr[3] = string2;
                objArr[4] = Integer.valueOf(z ? 1 : 0);
                str = String.format(locale, "https://oauth.vk.com/authorize?client_id=%s&scope=%s&redirect_uri=%s&display=mobile&v=%s&response_type=token&revoke=%d", objArr);
            }
            this.mWebView.setWebViewClient(new b(this));
            this.mWebView.getSettings().setJavaScriptEnabled(true);
            this.mWebView.loadUrl(str);
            this.mWebView.setBackgroundColor(0);
            this.mWebView.setLayerType(1, null);
            this.mWebView.setVerticalScrollBarEnabled(false);
            this.mWebView.setVisibility(4);
            this.mWebView.setOverScrollMode(2);
            this.mProgress.setVisibility(0);
        } catch (Exception unused) {
            this.mResCode = 0;
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        View view = this.mView;
        Activity activity = view == null ? null : (Activity) view.getContext();
        if (activity instanceof VKServiceActivity) {
            ((VKServiceActivity) activity).onActivityResultPublic(this.mReqCode, this.mResCode, this.mData);
        }
    }

    public void show(@NonNull Activity activity, Bundle bundle, int i, @Nullable VKError vKError) {
        this.mVkError = vKError;
        this.mBundle = bundle;
        this.mReqCode = i;
        View inflate = View.inflate(activity, R.layout.vk_open_auth_dialog, null);
        this.mView = inflate;
        this.mProgress = inflate.findViewById(R.id.progress);
        this.mWebView = (WebView) this.mView.findViewById(R.id.copyUrl);
        Dialog dialog = new Dialog(activity, R.style.VKAlertDialog);
        dialog.setContentView(this.mView);
        dialog.setOnCancelListener(new a(this, dialog));
        dialog.setOnDismissListener(this);
        dialog.getWindow().setStatusBarColor(0);
        this.mDialog = dialog;
        dialog.show();
        a();
    }
}
