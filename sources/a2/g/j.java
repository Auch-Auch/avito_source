package a2.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.avito.android.messenger.map.sharing.di.SharingMapFragmentModule;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
@AutoHandleExceptions
public final class j {
    public static final String a = "a2.g.j";
    public static AtomicBoolean b = new AtomicBoolean(false);
    public static AtomicBoolean c = new AtomicBoolean(false);
    public static b d = new b(true, FacebookSdk.AUTO_INIT_ENABLED_PROPERTY);
    public static b e = new b(true, FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY);
    public static b f = new b(true, FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY);
    public static b g = new b(false, "auto_event_setup_enabled");
    public static b h = new b(true, FacebookSdk.MONITOR_ENABLED_PROPERTY);
    public static SharedPreferences i;

    public static class a implements Runnable {
        public final /* synthetic */ long a;

        public a(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            FetchedAppSettings queryAppSettings;
            if (j.f.a() && (queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false)) != null && queryAppSettings.getCodelessEventsEnabled()) {
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                if (((attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) ? null : attributionIdentifiers.getAndroidAdvertiserId()) != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
                    bundle.putString("fields", "auto_event_setup_enabled");
                    GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, FacebookSdk.getApplicationId(), null);
                    newGraphPathRequest.setSkipClientToken(true);
                    newGraphPathRequest.setParameters(bundle);
                    JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
                    if (jSONObject != null) {
                        j.g.b = Boolean.valueOf(jSONObject.optBoolean("auto_event_setup_enabled", false));
                        b bVar = j.g;
                        bVar.d = this.a;
                        j.f(bVar);
                    }
                }
            }
            j.c.set(false);
        }
    }

    public static class b {
        public String a;
        public Boolean b;
        public boolean c;
        public long d;

        public b(boolean z, String str) {
            this.c = z;
            this.a = str;
        }

        public boolean a() {
            Boolean bool = this.b;
            return bool == null ? this.c : bool.booleanValue();
        }
    }

    public static void a() {
        d(g);
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = g;
        if (bVar.b == null || currentTimeMillis - bVar.d >= 604800000) {
            bVar.b = null;
            bVar.d = 0;
            if (c.compareAndSet(false, true)) {
                FacebookSdk.getExecutor().execute(new a(currentTimeMillis));
            }
        }
    }

    public static void b() {
        Bundle bundle;
        Bundle bundle2;
        if (FacebookSdk.isInitialized()) {
            if (b.compareAndSet(false, true)) {
                i = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.USER_SETTINGS", 0);
                b[] bVarArr = {e, f, d};
                for (int i2 = 0; i2 < 3; i2++) {
                    b bVar = bVarArr[i2];
                    if (bVar == g) {
                        a();
                    } else if (bVar.b == null) {
                        d(bVar);
                        if (bVar.b == null) {
                            e();
                            try {
                                Context applicationContext = FacebookSdk.getApplicationContext();
                                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                                if (!(applicationInfo == null || (bundle2 = applicationInfo.metaData) == null || !bundle2.containsKey(bVar.a))) {
                                    bVar.b = Boolean.valueOf(applicationInfo.metaData.getBoolean(bVar.a, bVar.c));
                                }
                            } catch (PackageManager.NameNotFoundException e2) {
                                Utility.logd(a, e2);
                            }
                        }
                    } else {
                        f(bVar);
                    }
                }
                a();
                try {
                    Context applicationContext2 = FacebookSdk.getApplicationContext();
                    ApplicationInfo applicationInfo2 = applicationContext2.getPackageManager().getApplicationInfo(applicationContext2.getPackageName(), 128);
                    if (!(applicationInfo2 == null || (bundle = applicationInfo2.metaData) == null)) {
                        bundle.containsKey(FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY);
                        applicationInfo2.metaData.containsKey(FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY);
                        b();
                        f.a();
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                c();
            }
        }
    }

    public static void c() {
        int i2;
        if (b.get() && FacebookSdk.isInitialized()) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            int i3 = 0;
            int i4 = ((d.a() ? 1 : 0) << 0) | 0 | ((e.a() ? 1 : 0) << 1) | ((f.a() ? 1 : 0) << 2) | ((h.a() ? 1 : 0) << 3);
            int i5 = i.getInt("com.facebook.sdk.USER_SETTINGS_BITMASK", 0);
            if (i5 != i4) {
                i.edit().putInt("com.facebook.sdk.USER_SETTINGS_BITMASK", i4).commit();
                try {
                    ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                    if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                        String[] strArr = {FacebookSdk.AUTO_INIT_ENABLED_PROPERTY, FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY, FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY, FacebookSdk.MONITOR_ENABLED_PROPERTY};
                        boolean[] zArr = {true, true, true, true};
                        int i6 = 0;
                        i2 = 0;
                        for (int i7 = 0; i7 < 4; i7++) {
                            try {
                                i2 |= (applicationInfo.metaData.containsKey(strArr[i7]) ? 1 : 0) << i7;
                                i6 |= (applicationInfo.metaData.getBoolean(strArr[i7], zArr[i7]) ? 1 : 0) << i7;
                            } catch (PackageManager.NameNotFoundException unused) {
                            }
                        }
                        i3 = i6;
                        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(applicationContext);
                        Bundle bundle = new Bundle();
                        bundle.putInt("usage", i2);
                        bundle.putInt(SharingMapFragmentModule.INITIAL_STATE, i3);
                        bundle.putInt("previous", i5);
                        bundle.putInt("current", i4);
                        internalAppEventsLogger.logEventImplicitly("fb_sdk_settings_changed", bundle);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                i2 = 0;
                InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(applicationContext);
                Bundle bundle = new Bundle();
                bundle.putInt("usage", i2);
                bundle.putInt(SharingMapFragmentModule.INITIAL_STATE, i3);
                bundle.putInt("previous", i5);
                bundle.putInt("current", i4);
                internalAppEventsLogger.logEventImplicitly("fb_sdk_settings_changed", bundle);
            }
        }
    }

    public static void d(b bVar) {
        e();
        try {
            String string = i.getString(bVar.a, "");
            if (!string.isEmpty()) {
                JSONObject jSONObject = new JSONObject(string);
                bVar.b = Boolean.valueOf(jSONObject.getBoolean("value"));
                bVar.d = jSONObject.getLong("last_timestamp");
            }
        } catch (JSONException e2) {
            Utility.logd(a, e2);
        }
    }

    public static void e() {
        if (!b.get()) {
            throw new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
        }
    }

    public static void f(b bVar) {
        e();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", bVar.b);
            jSONObject.put("last_timestamp", bVar.d);
            i.edit().putString(bVar.a, jSONObject.toString()).commit();
            c();
        } catch (Exception e2) {
            Utility.logd(a, e2);
        }
    }
}
