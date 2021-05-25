package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
public final class CurrentAccessTokenExpirationBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (AccessTokenManager.ACTION_CURRENT_ACCESS_TOKEN_CHANGED.equals(intent.getAction()) && FacebookSdk.isInitialized()) {
            AccessTokenManager a = AccessTokenManager.a();
            AccessToken accessToken = a.c;
            a.d(accessToken, accessToken);
        }
    }
}
