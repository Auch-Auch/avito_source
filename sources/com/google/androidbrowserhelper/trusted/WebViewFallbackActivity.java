package com.google.androidbrowserhelper.trusted;

import a2.j.c.a.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;
public class WebViewFallbackActivity extends AppCompatActivity {
    public static final String g = WebViewFallbackActivity.class.getSimpleName();
    public Uri c;
    public int d;
    public WebView e;
    public List<Uri> f = new ArrayList();

    public static Intent createLaunchIntent(Context context, Uri uri, LauncherActivityMetadata launcherActivityMetadata) {
        Intent intent = new Intent(context, WebViewFallbackActivity.class);
        intent.putExtra("com.google.browser.examples.twawebviewfallback.WebViewFallbackActivity.LAUNCH_URL", uri);
        intent.putExtra("com.google.browser.examples.twawebviewfallback.WebViewFallbackActivity.KEY_STATUS_BAR_COLOR", ContextCompat.getColor(context, launcherActivityMetadata.statusBarColorId));
        intent.putExtra("com.google.browser.examples.twawebviewfallback.WebViewFallbackActivity.KEY_NAVIGATION_BAR_COLOR", ContextCompat.getColor(context, launcherActivityMetadata.navigationBarColorId));
        if (launcherActivityMetadata.additionalTrustedOrigins != null) {
            intent.putStringArrayListExtra("com.google.browser.examples.twawebviewfallback.WebViewFallbackActivity.KEY_EXTRA_ORIGINS", new ArrayList<>(launcherActivityMetadata.additionalTrustedOrigins));
        }
        return intent;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        ArrayList<String> stringArrayListExtra;
        super.onCreate(bundle);
        Uri uri = (Uri) getIntent().getParcelableExtra("com.google.browser.examples.twawebviewfallback.WebViewFallbackActivity.LAUNCH_URL");
        this.c = uri;
        if ("https".equals(uri.getScheme())) {
            if (getIntent().hasExtra("com.google.browser.examples.twawebviewfallback.WebViewFallbackActivity.KEY_NAVIGATION_BAR_COLOR")) {
                getWindow().setNavigationBarColor(getIntent().getIntExtra("com.google.browser.examples.twawebviewfallback.WebViewFallbackActivity.KEY_NAVIGATION_BAR_COLOR", 0));
            }
            if (getIntent().hasExtra("com.google.browser.examples.twawebviewfallback.WebViewFallbackActivity.KEY_STATUS_BAR_COLOR")) {
                this.d = getIntent().getIntExtra("com.google.browser.examples.twawebviewfallback.WebViewFallbackActivity.KEY_STATUS_BAR_COLOR", 0);
                getWindow().setStatusBarColor(this.d);
            } else {
                this.d = getWindow().getStatusBarColor();
            }
            if (getIntent().hasExtra("com.google.browser.examples.twawebviewfallback.WebViewFallbackActivity.KEY_EXTRA_ORIGINS") && (stringArrayListExtra = getIntent().getStringArrayListExtra("com.google.browser.examples.twawebviewfallback.WebViewFallbackActivity.KEY_EXTRA_ORIGINS")) != null) {
                for (String str : stringArrayListExtra) {
                    Uri parse = Uri.parse(str);
                    if ("https".equalsIgnoreCase(parse.getScheme())) {
                        this.f.add(parse);
                    }
                }
            }
            WebView webView = new WebView(this);
            this.e = webView;
            webView.setWebViewClient(new g(this));
            WebSettings settings = this.e.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            setContentView(this.e, new ViewGroup.LayoutParams(-1, -1));
            if (bundle != null) {
                this.e.restoreState(bundle);
            } else {
                this.e.loadUrl(this.c.toString());
            }
        } else {
            throw new IllegalArgumentException("launchUrl scheme must be 'https'");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.e.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.e.goBack();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        WebView webView = this.e;
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        WebView webView = this.e;
        if (webView != null) {
            webView.onResume();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        WebView webView = this.e;
        if (webView != null) {
            webView.saveState(bundle);
        }
    }
}
