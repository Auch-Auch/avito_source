package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker;
import com.facebook.internal.FetchedAppSettings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class FetchedAppSettingsManager {
    public static final String[] a = {"supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout", "app_events_feature_bitmask", "auto_event_mapping_android", "seamless_login", "smart_login_bookmark_icon_url", "smart_login_menu_icon_url", "restrictive_data_filter_params", "aam_rules", "suggested_events_setting"};
    public static final Map<String, FetchedAppSettings> b = new ConcurrentHashMap();
    public static final AtomicReference<d> c = new AtomicReference<>(d.NOT_LOADED);
    public static final ConcurrentLinkedQueue<FetchedAppSettingsCallback> d = new ConcurrentLinkedQueue<>();
    public static boolean e = false;
    public static boolean f = false;
    @Nullable
    public static JSONArray g = null;

    public interface FetchedAppSettingsCallback {
        void onError();

        void onSuccess(FetchedAppSettings fetchedAppSettings);
    }

    public static class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(Context context, String str, String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject;
            SharedPreferences sharedPreferences = this.a.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
            FetchedAppSettings fetchedAppSettings = null;
            String string = sharedPreferences.getString(this.b, null);
            if (!Utility.isNullOrEmpty(string)) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    Utility.logd("FacebookSDK", e);
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    fetchedAppSettings = FetchedAppSettingsManager.parseAppSettingsFromJSON(this.c, jSONObject);
                }
            }
            JSONObject a3 = FetchedAppSettingsManager.a(this.c);
            if (a3 != null) {
                FetchedAppSettingsManager.parseAppSettingsFromJSON(this.c, a3);
                sharedPreferences.edit().putString(this.b, a3.toString()).apply();
            }
            if (fetchedAppSettings != null) {
                String sdkUpdateMessage = fetchedAppSettings.getSdkUpdateMessage();
                if (!FetchedAppSettingsManager.e && sdkUpdateMessage != null && sdkUpdateMessage.length() > 0) {
                    FetchedAppSettingsManager.e = true;
                    String[] strArr = FetchedAppSettingsManager.a;
                }
            }
            String str = this.c;
            JSONObject a4 = FetchedAppGateKeepersManager.a(str);
            if (a4 != null) {
                FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(String.format("com.facebook.internal.APP_GATEKEEPERS.%s", str), a4.toString()).apply();
                FetchedAppGateKeepersManager.parseAppGateKeepersFromJSON(str, a4);
            }
            AutomaticAnalyticsLogger.logActivateAppEvent();
            InAppPurchaseActivityLifecycleTracker.update();
            FetchedAppSettingsManager.c.set(FetchedAppSettingsManager.b.containsKey(this.c) ? d.SUCCESS : d.ERROR);
            FetchedAppSettingsManager.b();
        }
    }

    public static class b implements Runnable {
        public final /* synthetic */ FetchedAppSettingsCallback a;

        public b(FetchedAppSettingsCallback fetchedAppSettingsCallback) {
            this.a = fetchedAppSettingsCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onError();
        }
    }

    public static class c implements Runnable {
        public final /* synthetic */ FetchedAppSettingsCallback a;
        public final /* synthetic */ FetchedAppSettings b;

        public c(FetchedAppSettingsCallback fetchedAppSettingsCallback, FetchedAppSettings fetchedAppSettings) {
            this.a = fetchedAppSettingsCallback;
            this.b = fetchedAppSettings;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onSuccess(this.b);
        }
    }

    public enum d {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR
    }

    public static JSONObject a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", new ArrayList(Arrays.asList(a))));
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, str, null);
        newGraphPathRequest.setSkipClientToken(true);
        newGraphPathRequest.setParameters(bundle);
        return newGraphPathRequest.executeAndWait().getJSONObject();
    }

    public static synchronized void b() {
        synchronized (FetchedAppSettingsManager.class) {
            d dVar = c.get();
            if (!d.NOT_LOADED.equals(dVar)) {
                if (!d.LOADING.equals(dVar)) {
                    FetchedAppSettings fetchedAppSettings = b.get(FacebookSdk.getApplicationId());
                    Handler handler = new Handler(Looper.getMainLooper());
                    if (d.ERROR.equals(dVar)) {
                        while (true) {
                            ConcurrentLinkedQueue<FetchedAppSettingsCallback> concurrentLinkedQueue = d;
                            if (!concurrentLinkedQueue.isEmpty()) {
                                handler.post(new b(concurrentLinkedQueue.poll()));
                            } else {
                                return;
                            }
                        }
                    } else {
                        while (true) {
                            ConcurrentLinkedQueue<FetchedAppSettingsCallback> concurrentLinkedQueue2 = d;
                            if (!concurrentLinkedQueue2.isEmpty()) {
                                handler.post(new c(concurrentLinkedQueue2.poll(), fetchedAppSettings));
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void getAppSettingsAsync(FetchedAppSettingsCallback fetchedAppSettingsCallback) {
        d.add(fetchedAppSettingsCallback);
        loadAppSettingsAsync();
    }

    @Nullable
    public static FetchedAppSettings getAppSettingsWithoutQuery(String str) {
        if (str != null) {
            return b.get(str);
        }
        return null;
    }

    public static void loadAppSettingsAsync() {
        d dVar = d.ERROR;
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        if (Utility.isNullOrEmpty(applicationId)) {
            c.set(dVar);
            b();
        } else if (b.containsKey(applicationId)) {
            c.set(d.SUCCESS);
            b();
        } else {
            AtomicReference<d> atomicReference = c;
            d dVar2 = d.NOT_LOADED;
            d dVar3 = d.LOADING;
            if (!(atomicReference.compareAndSet(dVar2, dVar3) || atomicReference.compareAndSet(dVar, dVar3))) {
                b();
            } else {
                FacebookSdk.getExecutor().execute(new a(applicationContext, String.format("com.facebook.internal.APP_SETTINGS.%s", applicationId), applicationId));
            }
        }
    }

    public static FetchedAppSettings parseAppSettingsFromJSON(String str, JSONObject jSONObject) {
        FacebookRequestErrorClassification facebookRequestErrorClassification;
        JSONArray optJSONArray;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Map map;
        JSONArray optJSONArray2 = jSONObject.optJSONArray("android_sdk_error_categories");
        if (optJSONArray2 == null) {
            facebookRequestErrorClassification = FacebookRequestErrorClassification.getDefaultErrorClassification();
        } else {
            facebookRequestErrorClassification = FacebookRequestErrorClassification.createFromJSON(optJSONArray2);
        }
        int i = 0;
        int optInt = jSONObject.optInt("app_events_feature_bitmask", 0);
        boolean z = (optInt & 8) != 0;
        boolean z2 = (optInt & 16) != 0;
        boolean z3 = (optInt & 32) != 0;
        boolean z4 = (optInt & 256) != 0;
        boolean z5 = (optInt & 16384) != 0;
        JSONArray optJSONArray3 = jSONObject.optJSONArray("auto_event_mapping_android");
        g = optJSONArray3;
        if (optJSONArray3 != null && InternalSettings.isUnityApp()) {
            UnityReflection.sendEventMapping(optJSONArray3.toString());
        }
        boolean optBoolean = jSONObject.optBoolean("supports_implicit_sdk_logging", false);
        String optString = jSONObject.optString("gdpv4_nux_content", "");
        boolean optBoolean2 = jSONObject.optBoolean("gdpv4_nux_enabled", false);
        int optInt2 = jSONObject.optInt("app_events_session_timeout", Constants.getDefaultAppEventsSessionTimeoutInSeconds());
        EnumSet<SmartLoginOption> parseOptions = SmartLoginOption.parseOptions(jSONObject.optLong("seamless_login"));
        JSONObject optJSONObject = jSONObject.optJSONObject("android_dialog_configs");
        HashMap hashMap = new HashMap();
        if (!(optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("data")) == null)) {
            while (i < optJSONArray.length()) {
                FetchedAppSettings.DialogFeatureConfig parseDialogConfig = FetchedAppSettings.DialogFeatureConfig.parseDialogConfig(optJSONArray.optJSONObject(i));
                if (parseDialogConfig == null) {
                    jSONArray2 = optJSONArray;
                    jSONArray = optJSONArray3;
                } else {
                    jSONArray2 = optJSONArray;
                    String dialogName = parseDialogConfig.getDialogName();
                    Map map2 = (Map) hashMap.get(dialogName);
                    jSONArray = optJSONArray3;
                    if (map2 == null) {
                        map = new HashMap();
                        hashMap.put(dialogName, map);
                    } else {
                        map = map2;
                    }
                    map.put(parseDialogConfig.getFeatureName(), parseDialogConfig);
                }
                i++;
                optJSONArray = jSONArray2;
                optJSONArray3 = jSONArray;
            }
        }
        FetchedAppSettings fetchedAppSettings = new FetchedAppSettings(optBoolean, optString, optBoolean2, optInt2, parseOptions, hashMap, z, facebookRequestErrorClassification, jSONObject.optString("smart_login_bookmark_icon_url"), jSONObject.optString("smart_login_menu_icon_url"), z2, z3, optJSONArray3, jSONObject.optString("sdk_update_message"), z4, z5, jSONObject.optString("aam_rules"), jSONObject.optString("suggested_events_setting"), jSONObject.optString("restrictive_data_filter_params"));
        b.put(str, fetchedAppSettings);
        return fetchedAppSettings;
    }

    @Nullable
    public static FetchedAppSettings queryAppSettings(String str, boolean z) {
        if (!z) {
            Map<String, FetchedAppSettings> map = b;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        JSONObject a3 = a(str);
        if (a3 == null) {
            return null;
        }
        FetchedAppSettings parseAppSettingsFromJSON = parseAppSettingsFromJSON(str, a3);
        if (str.equals(FacebookSdk.getApplicationId())) {
            c.set(d.SUCCESS);
            b();
        }
        return parseAppSettingsFromJSON;
    }

    public static void setIsUnityInit(boolean z) {
        f = z;
        JSONArray jSONArray = g;
        if (jSONArray != null && z) {
            UnityReflection.sendEventMapping(jSONArray.toString());
        }
    }
}
