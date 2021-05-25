package a2.g.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.AnalyticsEvents;
public final class m implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ o b;

    public m(Context context, o oVar) {
        this.a = context;
        this.b = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bundle bundle = new Bundle();
        String[] strArr = {"com.facebook.core.Core", "com.facebook.login.Login", "com.facebook.share.Share", "com.facebook.places.Places", "com.facebook.messenger.Messenger", "com.facebook.applinks.AppLinks", "com.facebook.marketing.Marketing", "com.facebook.gamingservices.GamingServices", "com.facebook.all.All", "com.android.billingclient.api.BillingClient", "com.android.vending.billing.IInAppBillingService"};
        String[] strArr2 = {"core_lib_included", "login_lib_included", "share_lib_included", "places_lib_included", "messenger_lib_included", "applinks_lib_included", "marketing_lib_included", "gamingservices_lib_included", "all_lib_included", "billing_client_lib_included", "billing_service_lib_included"};
        int i = 0;
        for (int i2 = 0; i2 < 11; i2++) {
            String str = strArr[i2];
            String str2 = strArr2[i2];
            try {
                Class.forName(str);
                bundle.putInt(str2, 1);
                i |= 1 << i2;
            } catch (ClassNotFoundException unused) {
            }
        }
        SharedPreferences sharedPreferences = this.a.getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0);
        if (sharedPreferences.getInt("kitsBitmask", 0) != i) {
            sharedPreferences.edit().putInt("kitsBitmask", i).apply();
            this.b.i(AnalyticsEvents.EVENT_SDK_INITIALIZE, null, bundle);
        }
    }
}
