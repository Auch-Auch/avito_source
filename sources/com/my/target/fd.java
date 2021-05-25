package com.my.target;

import a2.b.a.a.a;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
public class fd extends fb {
    public boolean b = false;

    public final void b(@NonNull Context context) {
        ContentResolver contentResolver;
        ae.a("send google AId");
        boolean z = false;
        String str = null;
        try {
            str = AdvertisingIdClient.getAdvertisingIdInfo(context).getId();
            ae.a("google AId: " + str);
            boolean z2 = !AdvertisingIdClient.getAdvertisingIdInfo(context).isLimitAdTrackingEnabled();
            StringBuilder sb = new StringBuilder();
            sb.append("ad tracking enabled: ");
            sb.append(!z2);
            ae.a(sb.toString());
            addParam("advertising_id", str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(z2 ? 1 : 0);
            sb2.append("");
            addParam("advertising_tracking_enabled", sb2.toString());
        } catch (Throwable th) {
            a.q1(th, a.L("failed to send google AId, "));
        }
        if (!(str == null || str.length() == 0)) {
            z = !str.matches("^[0]+(-[0]+)+$");
        }
        if (!z && (contentResolver = context.getContentResolver()) != null) {
            String string = Settings.Secure.getString(contentResolver, "android_id");
            if (!TextUtils.isEmpty(string)) {
                addParam("android_id", string);
            }
        }
    }

    @Override // com.my.target.fb
    @WorkerThread
    public synchronized void collectData(@NonNull Context context) {
        if (af.isMainThread()) {
            ae.a("You must not call collectData method from main thread");
        } else if (!this.b) {
            b(context);
            this.b = true;
        }
    }
}
