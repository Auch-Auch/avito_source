package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.CustomTab;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
public class CustomTabMainActivity extends Activity {
    public static final String EXTRA_ACTION = a2.b.a.a.a.E2(CustomTabMainActivity.class, new StringBuilder(), ".extra_action");
    public static final String EXTRA_CHROME_PACKAGE = a2.b.a.a.a.E2(CustomTabMainActivity.class, new StringBuilder(), ".extra_chromePackage");
    public static final String EXTRA_PARAMS = a2.b.a.a.a.E2(CustomTabMainActivity.class, new StringBuilder(), ".extra_params");
    public static final String EXTRA_URL = a2.b.a.a.a.E2(CustomTabMainActivity.class, new StringBuilder(), ".extra_url");
    public static final String NO_ACTIVITY_EXCEPTION = a2.b.a.a.a.E2(CustomTabMainActivity.class, new StringBuilder(), ".no_activity_exception");
    public static final String REFRESH_ACTION = a2.b.a.a.a.E2(CustomTabMainActivity.class, new StringBuilder(), ".action_refresh");
    public boolean a = true;
    public BroadcastReceiver b;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intent intent2 = new Intent(CustomTabMainActivity.this, CustomTabMainActivity.class);
            intent2.setAction(CustomTabMainActivity.REFRESH_ACTION);
            String str = CustomTabMainActivity.EXTRA_URL;
            intent2.putExtra(str, intent.getStringExtra(str));
            intent2.addFlags(603979776);
            CustomTabMainActivity.this.startActivity(intent2);
        }
    }

    public final void a(int i, Intent intent) {
        Bundle bundle;
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.b);
        if (intent != null) {
            String stringExtra = intent.getStringExtra(EXTRA_URL);
            if (stringExtra != null) {
                Uri parse = Uri.parse(stringExtra);
                bundle = Utility.parseUrlQueryString(parse.getQuery());
                bundle.putAll(Utility.parseUrlQueryString(parse.getFragment()));
            } else {
                bundle = new Bundle();
            }
            Intent createProtocolResultIntent = NativeProtocol.createProtocolResultIntent(getIntent(), bundle, null);
            if (createProtocolResultIntent != null) {
                intent = createProtocolResultIntent;
            }
            setResult(i, intent);
        } else {
            setResult(i, NativeProtocol.createProtocolResultIntent(getIntent(), null, null));
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION;
        if (str.equals(getIntent().getAction())) {
            setResult(0);
            finish();
        } else if (bundle == null) {
            String stringExtra = getIntent().getStringExtra(EXTRA_ACTION);
            Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_PARAMS);
            boolean openCustomTab = new CustomTab(stringExtra, bundleExtra).openCustomTab(this, getIntent().getStringExtra(EXTRA_CHROME_PACKAGE));
            this.a = false;
            if (!openCustomTab) {
                setResult(0, getIntent().putExtra(NO_ACTIVITY_EXCEPTION, true));
                finish();
                return;
            }
            this.b = new a();
            LocalBroadcastManager.getInstance(this).registerReceiver(this.b, new IntentFilter(str));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (REFRESH_ACTION.equals(intent.getAction())) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CustomTabActivity.DESTROY_ACTION));
            a(-1, intent);
        } else if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(intent.getAction())) {
            a(-1, intent);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a) {
            a(0, null);
        }
        this.a = true;
    }
}
