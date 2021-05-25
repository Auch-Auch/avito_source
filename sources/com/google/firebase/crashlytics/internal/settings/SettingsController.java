package com.google.firebase.crashlytics.internal.settings;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;
public class SettingsController implements SettingsDataProvider {
    public final Context a;
    public final SettingsRequest b;
    public final SettingsJsonParser c;
    public final CurrentTimeProvider d;
    public final CachedSettingsIo e;
    public final SettingsSpiCall f;
    public final DataCollectionArbiter g;
    public final AtomicReference<Settings> h;
    public final AtomicReference<TaskCompletionSource<AppSettingsData>> i = new AtomicReference<>(new TaskCompletionSource());

    public class a implements SuccessContinuation<Void, Void> {
        public a() {
        }

        /* Return type fixed from 'com.google.android.gms.tasks.Task' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.android.gms.tasks.SuccessContinuation
        @NonNull
        public Task<Void> then(@Nullable Void r5) throws Exception {
            SettingsController settingsController = SettingsController.this;
            JSONObject invoke = settingsController.f.invoke(settingsController.b, true);
            if (invoke != null) {
                SettingsData parseSettingsJson = SettingsController.this.c.parseSettingsJson(invoke);
                SettingsController.this.e.writeCachedSettings(parseSettingsJson.getExpiresAtMillis(), invoke);
                SettingsController.this.b(invoke, "Loaded settings: ");
                SettingsController settingsController2 = SettingsController.this;
                String str = settingsController2.b.instanceId;
                SharedPreferences.Editor edit = CommonUtils.getSharedPrefs(settingsController2.a).edit();
                edit.putString("existing_instance_identifier", str);
                edit.apply();
                SettingsController.this.h.set(parseSettingsJson);
                SettingsController.this.i.get().trySetResult(parseSettingsJson.getAppSettingsData());
                TaskCompletionSource<AppSettingsData> taskCompletionSource = new TaskCompletionSource<>();
                taskCompletionSource.trySetResult(parseSettingsJson.getAppSettingsData());
                SettingsController.this.i.set(taskCompletionSource);
            }
            return Tasks.forResult(null);
        }
    }

    public SettingsController(Context context, SettingsRequest settingsRequest, CurrentTimeProvider currentTimeProvider, SettingsJsonParser settingsJsonParser, CachedSettingsIo cachedSettingsIo, SettingsSpiCall settingsSpiCall, DataCollectionArbiter dataCollectionArbiter) {
        AtomicReference<Settings> atomicReference = new AtomicReference<>();
        this.h = atomicReference;
        this.a = context;
        this.b = settingsRequest;
        this.d = currentTimeProvider;
        this.c = settingsJsonParser;
        this.e = cachedSettingsIo;
        this.f = settingsSpiCall;
        this.g = dataCollectionArbiter;
        JSONObject jSONObject = new JSONObject();
        atomicReference.set(new SettingsData(a2.j.e.d.d.h.a.b(currentTimeProvider, 3600, jSONObject), null, new SessionSettingsData(jSONObject.optInt("max_custom_exception_events", 8), 4), new FeaturesSettingsData(jSONObject.optBoolean("collect_reports", true)), 0, 3600));
    }

    public static SettingsController create(Context context, String str, IdManager idManager, HttpRequestFactory httpRequestFactory, String str2, String str3, String str4, DataCollectionArbiter dataCollectionArbiter) {
        String installerPackageName = idManager.getInstallerPackageName();
        SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
        return new SettingsController(context, new SettingsRequest(str, idManager.getModelName(), idManager.getOsBuildVersionString(), idManager.getOsDisplayVersionString(), idManager, CommonUtils.createInstanceIdFrom(CommonUtils.getMappingFileId(context), str, str3, str2), str3, str2, DeliveryMechanism.determineFrom(installerPackageName).getId()), systemCurrentTimeProvider, new SettingsJsonParser(systemCurrentTimeProvider), new CachedSettingsIo(context), new DefaultSettingsSpiCall(str4, String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str), httpRequestFactory), dataCollectionArbiter);
    }

    public final SettingsData a(SettingsCacheBehavior settingsCacheBehavior) {
        Exception e2;
        SettingsData settingsData = null;
        try {
            if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                return null;
            }
            JSONObject readCachedSettings = this.e.readCachedSettings();
            if (readCachedSettings != null) {
                SettingsData parseSettingsJson = this.c.parseSettingsJson(readCachedSettings);
                if (parseSettingsJson != null) {
                    b(readCachedSettings, "Loaded cached settings: ");
                    long currentTimeMillis = this.d.getCurrentTimeMillis();
                    if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior)) {
                        if (parseSettingsJson.isExpired(currentTimeMillis)) {
                            Logger.getLogger().d("Cached settings have expired.");
                            return null;
                        }
                    }
                    try {
                        Logger.getLogger().d("Returning cached settings.");
                        return parseSettingsJson;
                    } catch (Exception e3) {
                        e2 = e3;
                        settingsData = parseSettingsJson;
                        Logger.getLogger().e("Failed to get cached settings", e2);
                        return settingsData;
                    }
                } else {
                    Logger.getLogger().e("Failed to parse cached settings data.", null);
                    return null;
                }
            } else {
                Logger.getLogger().d("No cached settings data found.");
                return null;
            }
        } catch (Exception e4) {
            e2 = e4;
            Logger.getLogger().e("Failed to get cached settings", e2);
            return settingsData;
        }
    }

    public final void b(JSONObject jSONObject, String str) throws JSONException {
        Logger logger = Logger.getLogger();
        StringBuilder L = a2.b.a.a.a.L(str);
        L.append(jSONObject.toString());
        logger.d(L.toString());
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsDataProvider
    public Task<AppSettingsData> getAppSettings() {
        return this.i.get().getTask();
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsDataProvider
    public Settings getSettings() {
        return this.h.get();
    }

    public Task<Void> loadSettingsData(Executor executor) {
        return loadSettingsData(SettingsCacheBehavior.USE_CACHE, executor);
    }

    public Task<Void> loadSettingsData(SettingsCacheBehavior settingsCacheBehavior, Executor executor) {
        SettingsData a3;
        if ((!CommonUtils.getSharedPrefs(this.a).getString("existing_instance_identifier", "").equals(this.b.instanceId)) || (a3 = a(settingsCacheBehavior)) == null) {
            SettingsData a4 = a(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
            if (a4 != null) {
                this.h.set(a4);
                this.i.get().trySetResult(a4.getAppSettingsData());
            }
            return this.g.waitForDataCollectionPermission().onSuccessTask(executor, new a());
        }
        this.h.set(a3);
        this.i.get().trySetResult(a3.getAppSettingsData());
        return Tasks.forResult(null);
    }
}
