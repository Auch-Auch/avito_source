package com.vk.sdk.payments;

import a2.s.a.c.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKUIHelper;
public class VKPaymentsReceiver extends BroadcastReceiver {
    public static VKAccessTokenTracker a = new a();

    public static class a extends VKAccessTokenTracker {
        @Override // com.vk.sdk.VKAccessTokenTracker
        public void onVKAccessTokenChanged(@Nullable VKAccessToken vKAccessToken, @Nullable VKAccessToken vKAccessToken2) {
            Context applicationContext = VKUIHelper.getApplicationContext();
            VKAccessTokenTracker vKAccessTokenTracker = VKPaymentsReceiver.a;
            if (applicationContext != null) {
                b.c(applicationContext).f(false);
            }
        }
    }

    public static void a(Context context, boolean z) {
        boolean z2 = false;
        boolean z3 = true;
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                z2 = true;
            }
            z3 = z2;
        }
        if (z3 && VKSdk.isIsPaymentsEnable()) {
            if (VKAccessToken.currentToken() == null && !a.isTracking()) {
                a.startTracking();
            }
            b.c(context).f(z);
        }
    }

    public static void onReceiveStatic(Context context) {
        a(context, false);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent == null ? null : intent.getStringExtra(Constants.REFERRER);
        a(context, intent != null && "com.android.vending.INSTALL_REFERRER".equals(intent.getAction()) && stringExtra != null && stringExtra.startsWith("utm_source=vk"));
    }
}
