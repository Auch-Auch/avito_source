package com.facebook.login;

import android.content.ComponentName;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
public class CustomTabPrefetchHelper extends CustomTabsServiceConnection {
    public static CustomTabsClient b;
    public static CustomTabsSession c;

    public static CustomTabsSession getPreparedSessionOnce() {
        CustomTabsSession customTabsSession = c;
        c = null;
        return customTabsSession;
    }

    public static void mayLaunchUrl(Uri uri) {
        CustomTabsClient customTabsClient;
        CustomTabsSession customTabsSession = c;
        if (customTabsSession == null && customTabsSession == null && (customTabsClient = b) != null) {
            c = customTabsClient.newSession(null);
        }
        CustomTabsSession customTabsSession2 = c;
        if (customTabsSession2 != null) {
            customTabsSession2.mayLaunchUrl(uri, null, null);
        }
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        CustomTabsClient customTabsClient2;
        b = customTabsClient;
        customTabsClient.warmup(0);
        if (c == null && (customTabsClient2 = b) != null) {
            c = customTabsClient2.newSession(null);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
