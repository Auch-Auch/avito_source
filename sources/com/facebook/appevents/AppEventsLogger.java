package com.facebook.appevents;

import a2.b.a.a.a;
import a2.g.k.c;
import a2.g.k.d;
import a2.g.k.f;
import a2.g.k.g;
import a2.g.k.h;
import a2.g.k.m;
import a2.g.k.o;
import a2.g.k.p;
import a2.g.k.q;
import a2.g.k.v;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class AppEventsLogger {
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    public o a;

    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY
    }

    public enum ProductAvailability {
        IN_STOCK,
        OUT_OF_STOCK,
        PREORDER,
        AVALIABLE_FOR_ORDER,
        DISCONTINUED
    }

    public enum ProductCondition {
        NEW,
        REFURBISHED,
        USED
    }

    public AppEventsLogger(Context context, String str, AccessToken accessToken) {
        this.a = new o(context, str, accessToken);
    }

    @Deprecated
    public static void activateApp(Context context, String str) {
        String str2 = o.c;
    }

    public static void augmentWebView(WebView webView, Context context) {
        String str = o.c;
        String[] split = Build.VERSION.RELEASE.split("\\.");
        int i = 0;
        int parseInt = split.length > 0 ? Integer.parseInt(split[0]) : 0;
        if (split.length > 1) {
            i = Integer.parseInt(split[1]);
        }
        if (parseInt < 4 || (parseInt == 4 && i <= 1)) {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, o.c, "augmentWebView is only available for Android SDK version >= 17 on devices running Android >= 4.2");
            return;
        }
        p pVar = new p(context);
        StringBuilder L = a.L("fbmq_");
        L.append(FacebookSdk.getApplicationId());
        webView.addJavascriptInterface(pVar, L.toString());
    }

    public static void clearUserData() {
        SharedPreferences sharedPreferences = UserDataStore.a;
        InternalAppEventsLogger.a().execute(new v());
    }

    public static void clearUserID() {
        ReentrantReadWriteLock reentrantReadWriteLock = d.a;
        AppEventUtility.assertIsNotMainThread();
        if (!d.c) {
            d.a();
        }
        InternalAppEventsLogger.a().execute(new c(null));
    }

    @Deprecated
    public static void deactivateApp(Context context, String str) {
        String str2 = o.c;
    }

    public static String getAnonymousAppDeviceGUID(Context context) {
        if (o.g == null) {
            synchronized (o.f) {
                if (o.g == null) {
                    String string = context.getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).getString("anonymousAppDeviceGUID", null);
                    o.g = string;
                    if (string == null) {
                        o.g = "XZ" + UUID.randomUUID().toString();
                        context.getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).edit().putString("anonymousAppDeviceGUID", o.g).apply();
                    }
                }
            }
        }
        return o.g;
    }

    public static FlushBehavior getFlushBehavior() {
        return o.c();
    }

    public static String getUserData() {
        if (!UserDataStore.b.get()) {
            UserDataStore.a();
        }
        return Utility.mapToJsonStr(UserDataStore.c);
    }

    public static String getUserID() {
        if (!d.c) {
            d.a();
        }
        d.a.readLock().lock();
        try {
            return d.b;
        } finally {
            d.a.readLock().unlock();
        }
    }

    public static void initializeLib(Context context, String str) {
        String str2 = o.c;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            o.d.execute(new m(context, new o(context, str, (AccessToken) null)));
        }
    }

    public static AppEventsLogger newLogger(Context context) {
        return new AppEventsLogger(context, null, null);
    }

    public static void onContextStop() {
        String str = o.c;
        f.c.execute(new g());
    }

    public static void setFlushBehavior(FlushBehavior flushBehavior) {
        synchronized (o.f) {
            o.e = flushBehavior;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setInstallReferrer(String str) {
        o.m(str);
    }

    public static void setPushNotificationsRegistrationId(String str) {
        synchronized (o.f) {
            if (!Utility.stringsEqualOrEmpty(o.i, str)) {
                o.i = str;
                o oVar = new o(FacebookSdk.getApplicationContext(), (String) null, (AccessToken) null);
                oVar.g(AppEventsConstants.EVENT_NAME_PUSH_TOKEN_OBTAINED, null);
                if (o.c() != FlushBehavior.EXPLICIT_ONLY) {
                    oVar.b();
                }
            }
        }
    }

    public static void setUserData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        SharedPreferences sharedPreferences = UserDataStore.a;
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString(UserDataStore.EMAIL, str);
        }
        if (str2 != null) {
            bundle.putString(UserDataStore.FIRST_NAME, str2);
        }
        if (str3 != null) {
            bundle.putString(UserDataStore.LAST_NAME, str3);
        }
        if (str4 != null) {
            bundle.putString(UserDataStore.PHONE, str4);
        }
        if (str5 != null) {
            bundle.putString(UserDataStore.DATE_OF_BIRTH, str5);
        }
        if (str6 != null) {
            bundle.putString(UserDataStore.GENDER, str6);
        }
        if (str7 != null) {
            bundle.putString(UserDataStore.CITY, str7);
        }
        if (str8 != null) {
            bundle.putString(UserDataStore.STATE, str8);
        }
        if (str9 != null) {
            bundle.putString(UserDataStore.ZIP, str9);
        }
        if (str10 != null) {
            bundle.putString("country", str10);
        }
        UserDataStore.c(bundle);
    }

    public static void setUserID(String str) {
        ReentrantReadWriteLock reentrantReadWriteLock = d.a;
        AppEventUtility.assertIsNotMainThread();
        if (!d.c) {
            d.a();
        }
        InternalAppEventsLogger.a().execute(new c(str));
    }

    @Deprecated
    public static void updateUserProperties(Bundle bundle, GraphRequest.Callback callback) {
    }

    @Deprecated
    public static void updateUserProperties(Bundle bundle, String str, GraphRequest.Callback callback) {
    }

    public void flush() {
        this.a.b();
    }

    public String getApplicationId() {
        return this.a.b.b;
    }

    public boolean isValidForAccessToken(AccessToken accessToken) {
        o oVar = this.a;
        Objects.requireNonNull(oVar);
        return oVar.b.equals(new a2.g.k.a(accessToken.getToken(), FacebookSdk.getApplicationId()));
    }

    public void logEvent(String str) {
        this.a.g(str, null);
    }

    public void logProductItem(String str, ProductAvailability productAvailability, ProductCondition productCondition, String str2, String str3, String str4, String str5, BigDecimal bigDecimal, Currency currency, String str6, String str7, String str8, Bundle bundle) {
        o oVar = this.a;
        Objects.requireNonNull(oVar);
        if (str == null) {
            o.l("itemID cannot be null");
        } else if (productAvailability == null) {
            o.l("availability cannot be null");
        } else if (productCondition == null) {
            o.l("condition cannot be null");
        } else if (str2 == null) {
            o.l("description cannot be null");
        } else if (str3 == null) {
            o.l("imageLink cannot be null");
        } else if (str4 == null) {
            o.l("link cannot be null");
        } else if (str5 == null) {
            o.l("title cannot be null");
        } else if (bigDecimal == null) {
            o.l("priceAmount cannot be null");
        } else if (currency == null) {
            o.l("currency cannot be null");
        } else if (str6 == null && str7 == null && str8 == null) {
            o.l("Either gtin, mpn or brand is required");
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_ITEM_ID, str);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_AVAILABILITY, productAvailability.name());
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_CONDITION, productCondition.name());
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_DESCRIPTION, str2);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_IMAGE_LINK, str3);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_LINK, str4);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_TITLE, str5);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_PRICE_AMOUNT, bigDecimal.setScale(3, 4).toString());
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_PRICE_CURRENCY, currency.getCurrencyCode());
            if (str6 != null) {
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_GTIN, str6);
            }
            if (str7 != null) {
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_MPN, str7);
            }
            if (str8 != null) {
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_BRAND, str8);
            }
            oVar.g(AppEventsConstants.EVENT_NAME_PRODUCT_CATALOG_UPDATE, bundle);
            if (o.c() != FlushBehavior.EXPLICIT_ONLY) {
                f.c.execute(new h(q.EAGER_FLUSHING_EVENT));
            }
        }
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency) {
        o oVar = this.a;
        Objects.requireNonNull(oVar);
        AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled();
        oVar.j(bigDecimal, currency, null, false);
    }

    @Deprecated
    public void logPurchaseImplicitly(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled();
    }

    public void logPushNotificationOpen(Bundle bundle) {
        this.a.k(bundle, null);
    }

    @Deprecated
    public void logSdkEvent(String str, Double d, Bundle bundle) {
        o oVar = this.a;
        Objects.requireNonNull(oVar);
        if (str.startsWith("fb_ak") && FacebookSdk.getAutoLogAppEventsEnabled()) {
            oVar.h(str, d, bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
        }
    }

    public static void activateApp(Application application) {
        o.a(application, null);
    }

    @Deprecated
    public static void deactivateApp(Context context) {
        deactivateApp(null, null);
    }

    public static AppEventsLogger newLogger(Context context, AccessToken accessToken) {
        return new AppEventsLogger(context, null, accessToken);
    }

    public void logPushNotificationOpen(Bundle bundle, String str) {
        this.a.k(bundle, str);
    }

    public static void activateApp(Application application, String str) {
        o.a(application, str);
    }

    public static AppEventsLogger newLogger(Context context, String str, AccessToken accessToken) {
        return new AppEventsLogger(context, str, accessToken);
    }

    public void logEvent(String str, double d) {
        this.a.f(str, d, null);
    }

    @Deprecated
    public static void activateApp(Context context) {
        activateApp((Application) null, (String) null);
    }

    public static AppEventsLogger newLogger(Context context, String str) {
        return new AppEventsLogger(context, str, null);
    }

    public void logEvent(String str, Bundle bundle) {
        this.a.g(str, bundle);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        o oVar = this.a;
        Objects.requireNonNull(oVar);
        AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled();
        oVar.j(bigDecimal, currency, bundle, false);
    }

    public void logEvent(String str, double d, Bundle bundle) {
        this.a.f(str, d, bundle);
    }

    @Deprecated
    public static void setUserData(Bundle bundle) {
        UserDataStore.c(bundle);
    }
}
