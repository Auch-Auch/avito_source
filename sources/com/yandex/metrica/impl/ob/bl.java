package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.text.TextUtils;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.preferences.Preference;
import com.yandex.metrica.PreloadInfo;
import com.yandex.metrica.YandexMetricaConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
public class bl {
    private PreloadInfo b(String str) throws JSONException {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("trackid")) {
            str2 = jSONObject.optString("trackid");
        }
        PreloadInfo.Builder newBuilder = PreloadInfo.newBuilder(str2);
        HashMap<String, String> a = abc.a(jSONObject.optString("params"));
        if (a != null && a.size() > 0) {
            for (Map.Entry<String, String> entry : a.entrySet()) {
                newBuilder.setAdditionalParams(entry.getKey(), entry.getValue());
            }
        }
        return newBuilder.build();
    }

    private Location c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Location location = new Location(jSONObject.has(GeoContract.PROVIDER) ? jSONObject.optString(GeoContract.PROVIDER) : null);
            location.setLongitude(jSONObject.getDouble("lng"));
            location.setLatitude(jSONObject.getDouble("lat"));
            location.setTime(jSONObject.optLong("time"));
            location.setAccuracy((float) jSONObject.optDouble(GeoContract.ACCURACY));
            location.setAltitude((double) ((float) jSONObject.optDouble("alt")));
            return location;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a(YandexMetricaConfig yandexMetricaConfig) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("apikey", yandexMetricaConfig.apiKey);
            jSONObject.put(Preference.APP_VERSION, yandexMetricaConfig.appVersion);
            jSONObject.put("session_timeout", yandexMetricaConfig.sessionTimeout);
            jSONObject.put("location", a(yandexMetricaConfig.location));
            jSONObject.put("preload_info", a(yandexMetricaConfig.preloadInfo));
            jSONObject.put("collect_apps", yandexMetricaConfig.installedAppCollecting);
            jSONObject.put("logs", yandexMetricaConfig.logs);
            jSONObject.put("crash_enabled", yandexMetricaConfig.crashReporting);
            jSONObject.put("crash_native_enabled", yandexMetricaConfig.nativeCrashReporting);
            jSONObject.put("location_enabled", yandexMetricaConfig.locationTracking);
            jSONObject.put("max_reports_in_db_count", yandexMetricaConfig.maxReportsInDatabaseCount);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public YandexMetricaConfig a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                YandexMetricaConfig.Builder newConfigBuilder = YandexMetricaConfig.newConfigBuilder(jSONObject.getString("apikey"));
                if (jSONObject.has(Preference.APP_VERSION)) {
                    newConfigBuilder.withAppVersion(jSONObject.optString(Preference.APP_VERSION));
                }
                if (jSONObject.has("session_timeout")) {
                    newConfigBuilder.withSessionTimeout(jSONObject.getInt("session_timeout"));
                }
                newConfigBuilder.withLocation(c(jSONObject.optString("location")));
                newConfigBuilder.withPreloadInfo(b(jSONObject.optString("preload_info")));
                if (jSONObject.has("collect_apps")) {
                    newConfigBuilder.withInstalledAppCollecting(jSONObject.optBoolean("collect_apps"));
                }
                if (jSONObject.has("logs") && jSONObject.optBoolean("logs")) {
                    newConfigBuilder.withLogs();
                }
                if (jSONObject.has("crash_enabled")) {
                    newConfigBuilder.withCrashReporting(jSONObject.optBoolean("crash_enabled"));
                }
                if (jSONObject.has("crash_native_enabled")) {
                    newConfigBuilder.withNativeCrashReporting(jSONObject.optBoolean("crash_native_enabled"));
                }
                if (jSONObject.has("location_enabled")) {
                    newConfigBuilder.withLocationTracking(jSONObject.optBoolean("location_enabled"));
                }
                if (jSONObject.has("max_reports_in_db_count")) {
                    newConfigBuilder.withMaxReportsInDatabaseCount(jSONObject.optInt("max_reports_in_db_count"));
                }
                return newConfigBuilder.build();
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private String a(PreloadInfo preloadInfo) {
        if (preloadInfo == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("trackid", preloadInfo.getTrackingId());
            jSONObject.put("params", abc.b(preloadInfo.getAdditionalParams()));
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private String a(Location location) {
        if (location == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(GeoContract.PROVIDER, location.getProvider());
            jSONObject.put("time", location.getTime());
            jSONObject.put(GeoContract.ACCURACY, (double) location.getAccuracy());
            jSONObject.put("alt", location.getAltitude());
            jSONObject.put("lng", location.getLongitude());
            jSONObject.put("lat", location.getLatitude());
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
