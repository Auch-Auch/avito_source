package a2.g.k.y;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
public final class c implements Application.ActivityLifecycleCallbacks {

    public class a implements Runnable {
        public a(c cVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            Context applicationContext = FacebookSdk.getApplicationContext();
            InAppPurchaseActivityLifecycleTracker.a(applicationContext, d.a(d.d(applicationContext, InAppPurchaseActivityLifecycleTracker.g, "inapp")), false);
            InAppPurchaseActivityLifecycleTracker.a(applicationContext, d.a(d.d(applicationContext, InAppPurchaseActivityLifecycleTracker.g, "subs")), true);
        }
    }

    public class b implements Runnable {
        public b(c cVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            Class<?> b;
            ArrayList<String> stringArrayList;
            long j;
            Context applicationContext = FacebookSdk.getApplicationContext();
            ArrayList<String> a = d.a(d.d(applicationContext, InAppPurchaseActivityLifecycleTracker.g, "inapp"));
            char c = 0;
            if (a.isEmpty()) {
                Object obj = InAppPurchaseActivityLifecycleTracker.g;
                ArrayList<String> arrayList = new ArrayList<>();
                if (obj == null || (b = d.b(applicationContext, "com.android.vending.billing.IInAppBillingService")) == null || d.c(b, "getPurchaseHistory") == null) {
                    a = arrayList;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    if (d.f(applicationContext, obj, "inapp").booleanValue()) {
                        String str = null;
                        int i = 0;
                        boolean z = false;
                        while (true) {
                            Object[] objArr = new Object[5];
                            objArr[c] = 6;
                            objArr[1] = d.c;
                            objArr[2] = "inapp";
                            objArr[3] = str;
                            objArr[4] = new Bundle();
                            Object e = d.e(applicationContext, "com.android.vending.billing.IInAppBillingService", "getPurchaseHistory", obj, objArr);
                            if (e != null) {
                                long j2 = 1000;
                                long currentTimeMillis = System.currentTimeMillis() / 1000;
                                Bundle bundle = (Bundle) e;
                                if (bundle.getInt("RESPONSE_CODE") == 0 && (stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST")) != null) {
                                    Iterator<String> it = stringArrayList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        String next = it.next();
                                        try {
                                            try {
                                                j = 1000;
                                                try {
                                                    if (currentTimeMillis - (new JSONObject(next).getLong("purchaseTime") / 1000) > 1200) {
                                                        z = true;
                                                        break;
                                                    }
                                                    arrayList2.add(next);
                                                    i++;
                                                    j2 = j;
                                                } catch (JSONException unused) {
                                                    continue;
                                                }
                                            } catch (JSONException unused2) {
                                                j = 1000;
                                            }
                                        } catch (JSONException unused3) {
                                            j = j2;
                                        }
                                    }
                                    str = bundle.getString("INAPP_CONTINUATION_TOKEN");
                                    if (i >= 30 || str == null || z) {
                                        break;
                                    }
                                    c = 0;
                                }
                            }
                            str = null;
                            c = 0;
                        }
                    }
                    a = d.a(arrayList2);
                }
            }
            InAppPurchaseActivityLifecycleTracker.a(applicationContext, a, false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            FacebookSdk.getExecutor().execute(new a(this));
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        try {
            if (InAppPurchaseActivityLifecycleTracker.c.booleanValue() && activity.getLocalClassName().equals("com.android.billingclient.api.ProxyBillingActivity")) {
                FacebookSdk.getExecutor().execute(new b(this));
            }
        } catch (Exception unused) {
        }
    }
}
