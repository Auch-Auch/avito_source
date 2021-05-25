package saschpe.android.customtabs;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import b7.a.a.b;
import java.util.List;
public final class CustomTabsHelper {
    public CustomTabsSession a;
    public CustomTabsClient b;
    public CustomTabsServiceConnection c;
    public ConnectionCallback d;

    public interface ConnectionCallback {
        void onCustomTabsConnected();

        void onCustomTabsDisconnected();
    }

    public interface CustomTabFallback {
        void openUri(Context context, Uri uri);
    }

    public class a extends CustomTabsServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            CustomTabsHelper customTabsHelper = CustomTabsHelper.this;
            customTabsHelper.b = null;
            ConnectionCallback connectionCallback = customTabsHelper.d;
            if (connectionCallback != null) {
                connectionCallback.onCustomTabsDisconnected();
            }
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            CustomTabsHelper.this.b = customTabsClient;
            customTabsClient.warmup(0);
            ConnectionCallback connectionCallback = CustomTabsHelper.this.d;
            if (connectionCallback != null) {
                connectionCallback.onCustomTabsConnected();
            }
            CustomTabsHelper.this.getSession();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            CustomTabsHelper customTabsHelper = CustomTabsHelper.this;
            customTabsHelper.b = null;
            ConnectionCallback connectionCallback = customTabsHelper.d;
            if (connectionCallback != null) {
                connectionCallback.onCustomTabsDisconnected();
            }
        }
    }

    public static void addKeepAliveExtra(Context context, Intent intent) {
        intent.putExtra("android.support.customtabs.extra.KEEP_ALIVE", new Intent().setClassName(context.getPackageName(), b.class.getCanonicalName()));
    }

    public static void openCustomTab(Context context, CustomTabsIntent customTabsIntent, Uri uri, CustomTabFallback customTabFallback) {
        String a3 = b7.a.a.a.a(context);
        if (a3 != null) {
            if (Build.VERSION.SDK_INT >= 22) {
                Intent intent = customTabsIntent.intent;
                StringBuilder L = a2.b.a.a.a.L("2//");
                L.append(context.getPackageName());
                intent.putExtra("android.intent.extra.REFERRER", Uri.parse(L.toString()));
            }
            customTabsIntent.intent.setPackage(a3);
            customTabsIntent.launchUrl(context, uri);
        } else if (customTabFallback != null) {
            customTabFallback.openUri(context, uri);
        }
    }

    public void bindCustomTabsService(Activity activity) {
        String a3;
        if (this.b == null && (a3 = b7.a.a.a.a(activity)) != null) {
            a aVar = new a();
            this.c = aVar;
            CustomTabsClient.bindCustomTabsService(activity, a3, aVar);
        }
    }

    public CustomTabsSession getSession() {
        CustomTabsClient customTabsClient = this.b;
        if (customTabsClient == null) {
            this.a = null;
        } else if (this.a == null) {
            this.a = customTabsClient.newSession(null);
        }
        return this.a;
    }

    public boolean mayLaunchUrl(Uri uri, Bundle bundle, List<Bundle> list) {
        CustomTabsSession session;
        if (this.b == null || (session = getSession()) == null || !session.mayLaunchUrl(uri, bundle, list)) {
            return false;
        }
        return true;
    }

    public void setConnectionCallback(ConnectionCallback connectionCallback) {
        this.d = connectionCallback;
    }

    public void unbindCustomTabsService(Activity activity) {
        CustomTabsServiceConnection customTabsServiceConnection = this.c;
        if (customTabsServiceConnection != null) {
            activity.unbindService(customTabsServiceConnection);
            this.b = null;
            this.a = null;
        }
    }
}
