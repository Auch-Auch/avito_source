package com.avito.android.version_conflict;

import android.annotation.SuppressLint;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.config.AppConfig;
import com.avito.android.remote.config.AppConfigKt;
import com.avito.android.remote.model.Navigation;
import com.avito.android.util.preferences.ConfigContract;
import com.avito.android.util.preferences.Preferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/version_conflict/PrefConfigStorage;", "Lcom/avito/android/version_conflict/MutableConfigStorage;", "Lcom/avito/android/remote/config/AppConfig;", Navigation.CONFIG, "", "saveConfig", "(Lcom/avito/android/remote/config/AppConfig;)V", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "", "isYandexReportsEnabled", "()Z", "getConfig", "()Lcom/avito/android/remote/config/AppConfig;", "", "getGeoReportTimeout", "()J", "geoReportTimeout", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "version-conflict_release"}, k = 1, mv = {1, 4, 2})
public final class PrefConfigStorage implements MutableConfigStorage {
    public final Preferences a;

    @Inject
    public PrefConfigStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.a = preferences;
    }

    @Override // com.avito.android.version_conflict.ConfigStorage
    @Nullable
    public AppConfig getConfig() {
        if (!this.a.contains(ConfigContract.VERSION_MAX)) {
            return null;
        }
        AppConfig defaultAppConfig = AppConfigKt.getDefaultAppConfig();
        defaultAppConfig.setVersionMin(this.a.getInt(ConfigContract.VERSION_MIN, 0));
        defaultAppConfig.setVersionMax(this.a.getInt(ConfigContract.VERSION_MAX, 0));
        defaultAppConfig.setPlatformVersion(this.a.getInt(ConfigContract.PLATFORM_VERSION, 0));
        defaultAppConfig.setGeoReportTimeout(this.a.getLong(ConfigContract.GEO_REPORT_TIMEOUT, 0));
        defaultAppConfig.setYandexReportsEnabled(this.a.getBoolean(ConfigContract.YANDEX_REPORTS_ENABLED));
        return defaultAppConfig;
    }

    @Override // com.avito.android.version_conflict.ConfigStorage
    public long getGeoReportTimeout() {
        return this.a.getLong(ConfigContract.GEO_REPORT_TIMEOUT, 0);
    }

    @Override // com.avito.android.version_conflict.ConfigStorage
    public boolean isYandexReportsEnabled() {
        return this.a.getBoolean(ConfigContract.YANDEX_REPORTS_ENABLED);
    }

    @Override // com.avito.android.version_conflict.MutableConfigStorage
    @SuppressLint({"CommitPrefEdits"})
    public void saveConfig(@NotNull AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(appConfig, Navigation.CONFIG);
        this.a.getSharedPreferences().edit().putInt(ConfigContract.PLATFORM_VERSION, appConfig.getPlatformVersion()).putInt(ConfigContract.VERSION_MIN, appConfig.getVersionMin()).putInt(ConfigContract.VERSION_MAX, appConfig.getVersionMax()).putLong(ConfigContract.GEO_REPORT_TIMEOUT, appConfig.getGeoReportTimeout()).putBoolean(ConfigContract.YANDEX_REPORTS_ENABLED, appConfig.isYandexReportsEnabled()).apply();
    }
}
