package a2.g.k;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
@AutoHandleExceptions
public class o {
    public static final String c = "a2.g.k.o";
    public static ScheduledThreadPoolExecutor d;
    public static AppEventsLogger.FlushBehavior e = AppEventsLogger.FlushBehavior.AUTO;
    public static final Object f = new Object();
    public static String g;
    public static boolean h;
    public static String i;
    public final String a;
    public final a b;

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            HashSet hashSet = new HashSet();
            for (a aVar : f.b.b()) {
                hashSet.add(aVar.b);
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                FetchedAppSettingsManager.queryAppSettings((String) it.next(), true);
            }
        }
    }

    public o(Context context, String str, AccessToken accessToken) {
        this(Utility.getActivityName(context), str, accessToken);
    }

    public static void a(Application application, String str) {
        if (FacebookSdk.isInitialized()) {
            if (!d.c) {
                InternalAppEventsLogger.a().execute(new b());
            }
            if (!UserDataStore.b.get()) {
                UserDataStore.a();
            }
            if (str == null) {
                str = FacebookSdk.getApplicationId();
            }
            FacebookSdk.publishInstallAsync(application, str);
            ActivityLifecycleTracker.startTracking(application, str);
            return;
        }
        throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
    }

    public static AppEventsLogger.FlushBehavior c() {
        AppEventsLogger.FlushBehavior flushBehavior;
        synchronized (f) {
            flushBehavior = e;
        }
        return flushBehavior;
    }

    public static void d() {
        synchronized (f) {
            if (d == null) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
                d = scheduledThreadPoolExecutor;
                scheduledThreadPoolExecutor.scheduleAtFixedRate(new a(), 0, 86400, TimeUnit.SECONDS);
            }
        }
    }

    public static void e(AppEvent appEvent, a aVar) {
        f.c.execute(new i(aVar, appEvent));
        if (!appEvent.getIsImplicit() && !h) {
            if (appEvent.getName().equals(AppEventsConstants.EVENT_NAME_ACTIVATED_APP)) {
                h = true;
            } else {
                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
            }
        }
    }

    public static void l(String str) {
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", str);
    }

    public static void m(String str) {
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0);
        if (str != null) {
            sharedPreferences.edit().putString(Constants.INSTALL_REFERRER, str).apply();
        }
    }

    public void b() {
        f.c.execute(new h(q.EXPLICIT));
    }

    public void f(String str, double d2, Bundle bundle) {
        h(str, Double.valueOf(d2), bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
    }

    public void g(String str, Bundle bundle) {
        h(str, null, bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
    }

    public void h(String str, Double d2, Bundle bundle, boolean z, @Nullable UUID uuid) {
        if (str != null && !str.isEmpty()) {
            if (FetchedAppGateKeepersManager.getGateKeeperForKey("app_events_killswitch", FacebookSdk.getApplicationId(), false)) {
                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "KillSwitch is enabled and fail to log app event: %s", str);
                return;
            }
            try {
                e(new AppEvent(this.a, str, d2, bundle, z, ActivityLifecycleTracker.isInBackground(), uuid), this.b);
            } catch (JSONException e2) {
                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e2.toString());
            } catch (FacebookException e3) {
                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event: %s", e3.toString());
            }
        }
    }

    public void i(String str, Double d2, Bundle bundle) {
        h(str, d2, bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
    }

    public void j(BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z) {
        if (bigDecimal == null) {
            l("purchaseAmount cannot be null");
        } else if (currency == null) {
            l("currency cannot be null");
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency.getCurrencyCode());
            h(AppEventsConstants.EVENT_NAME_PURCHASED, Double.valueOf(bigDecimal.doubleValue()), bundle, z, ActivityLifecycleTracker.getCurrentSessionGuid());
            if (c() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                f.c.execute(new h(q.EAGER_FLUSHING_EVENT));
            }
        }
    }

    public void k(Bundle bundle, String str) {
        String str2;
        try {
            String string = bundle.getString("fb_push_payload");
            if (!Utility.isNullOrEmpty(string)) {
                str2 = new JSONObject(string).getString("campaign");
                if (str2 == null) {
                    Logger.log(LoggingBehavior.DEVELOPER_ERRORS, c, "Malformed payload specified for logging a push notification open.");
                    return;
                }
                Bundle y1 = a2.b.a.a.a.y1("fb_push_campaign", str2);
                if (str != null) {
                    y1.putString("fb_push_action", str);
                }
                g("fb_mobile_push_opened", y1);
            }
        } catch (JSONException unused) {
            str2 = null;
        }
    }

    public o(String str, String str2, AccessToken accessToken) {
        Validate.sdkInitialized();
        this.a = str;
        accessToken = accessToken == null ? AccessToken.getCurrentAccessToken() : accessToken;
        if (accessToken == null || accessToken.isExpired() || (str2 != null && !str2.equals(accessToken.getApplicationId()))) {
            this.b = new a(null, str2 == null ? Utility.getMetadataApplicationId(FacebookSdk.getApplicationContext()) : str2);
        } else {
            this.b = new a(accessToken.getToken(), FacebookSdk.getApplicationId());
        }
        d();
    }
}
