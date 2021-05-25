package saschpe.android.customtabs;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
public final class WebViewActivity extends AppCompatActivity {
    public static final String EXTRA_TITLE = a2.b.a.a.a.D2(WebViewActivity.class, new StringBuilder(), ".EXTRA_TITLE");
    public static final String EXTRA_URL = a2.b.a.a.a.D2(WebViewActivity.class, new StringBuilder(), ".EXTRA_URL");

    public class a extends WebViewClient {
        public final /* synthetic */ ActionBar a;

        public a(WebViewActivity webViewActivity, ActionBar actionBar) {
            this.a = actionBar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            ActionBar actionBar = this.a;
            if (actionBar != null) {
                actionBar.setTitle(webView.getTitle());
                this.a.setSubtitle(str);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_webview);
        String stringExtra = getIntent().getStringExtra(EXTRA_TITLE);
        String stringExtra2 = getIntent().getStringExtra(EXTRA_URL);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            if (stringExtra != null) {
                supportActionBar.setTitle(stringExtra);
                supportActionBar.setSubtitle(stringExtra2);
            } else {
                supportActionBar.setTitle(stringExtra2);
            }
        }
        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.loadUrl(stringExtra2);
        webView.getSettings().setJavaScriptEnabled(true);
        if (stringExtra == null) {
            webView.setWebViewClient(new a(this, supportActionBar));
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
