package com.yandex.metrica;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.ads;
import com.yandex.metrica.impl.ob.adw;
import com.yandex.metrica.impl.ob.adx;
import com.yandex.metrica.impl.ob.bl;
import com.yandex.metrica.impl.ob.dl;
public class YandexMetricaConfig {
    @NonNull
    public final String apiKey;
    @Nullable
    public final String appVersion;
    @Nullable
    public final Boolean crashReporting;
    @Nullable
    public final Boolean firstActivationAsUpdate;
    @Nullable
    public final Boolean installedAppCollecting;
    @Nullable
    public final Location location;
    @Nullable
    public final Boolean locationTracking;
    @Nullable
    public final Boolean logs;
    @Nullable
    public final Integer maxReportsInDatabaseCount;
    @Nullable
    public final Boolean nativeCrashReporting;
    @Nullable
    public final PreloadInfo preloadInfo;
    @Nullable
    public final Integer sessionTimeout;
    @Nullable
    public final Boolean statisticsSending;

    public static class Builder {
        public static final adw<String> n = new ads(new adx());
        @NonNull
        public final String a;
        @Nullable
        public String b;
        @Nullable
        public Integer c;
        @Nullable
        public Boolean d;
        @Nullable
        public Boolean e;
        @Nullable
        public Location f;
        @Nullable
        public Boolean g;
        @Nullable
        public Boolean h;
        @Nullable
        public Boolean i;
        @Nullable
        public PreloadInfo j;
        @Nullable
        public Boolean k;
        @Nullable
        public Boolean l;
        @Nullable
        public Integer m;

        public Builder(@NonNull String str) {
            n.a(str);
            this.a = str;
        }

        @NonNull
        public YandexMetricaConfig build() {
            return new YandexMetricaConfig(this);
        }

        @NonNull
        public Builder handleFirstActivationAsUpdate(boolean z) {
            this.k = Boolean.valueOf(z);
            return this;
        }

        @NonNull
        public Builder withAppVersion(@Nullable String str) {
            this.b = str;
            return this;
        }

        @NonNull
        public Builder withCrashReporting(boolean z) {
            this.d = Boolean.valueOf(z);
            return this;
        }

        @NonNull
        public Builder withInstalledAppCollecting(boolean z) {
            this.h = Boolean.valueOf(z);
            return this;
        }

        @NonNull
        public Builder withLocation(@Nullable Location location) {
            this.f = location;
            return this;
        }

        @NonNull
        public Builder withLocationTracking(boolean z) {
            this.g = Boolean.valueOf(z);
            return this;
        }

        @NonNull
        public Builder withLogs() {
            this.i = Boolean.TRUE;
            return this;
        }

        @NonNull
        public Builder withMaxReportsInDatabaseCount(int i2) {
            this.m = Integer.valueOf(i2);
            return this;
        }

        @NonNull
        public Builder withNativeCrashReporting(boolean z) {
            this.e = Boolean.valueOf(z);
            return this;
        }

        @NonNull
        public Builder withPreloadInfo(@Nullable PreloadInfo preloadInfo) {
            this.j = preloadInfo;
            return this;
        }

        @NonNull
        public Builder withSessionTimeout(int i2) {
            this.c = Integer.valueOf(i2);
            return this;
        }

        @NonNull
        public Builder withStatisticsSending(boolean z) {
            this.l = Boolean.valueOf(z);
            return this;
        }
    }

    public YandexMetricaConfig(@NonNull Builder builder) {
        this.apiKey = builder.a;
        this.appVersion = builder.b;
        this.sessionTimeout = builder.c;
        this.crashReporting = builder.d;
        this.nativeCrashReporting = builder.e;
        this.location = builder.f;
        this.locationTracking = builder.g;
        this.installedAppCollecting = builder.h;
        this.logs = builder.i;
        this.preloadInfo = builder.j;
        this.firstActivationAsUpdate = builder.k;
        this.statisticsSending = builder.l;
        this.maxReportsInDatabaseCount = builder.m;
    }

    @NonNull
    public static Builder createBuilderFromConfig(@NonNull YandexMetricaConfig yandexMetricaConfig) {
        Builder newConfigBuilder = newConfigBuilder(yandexMetricaConfig.apiKey);
        if (dl.a((Object) yandexMetricaConfig.appVersion)) {
            newConfigBuilder.withAppVersion(yandexMetricaConfig.appVersion);
        }
        if (dl.a(yandexMetricaConfig.sessionTimeout)) {
            newConfigBuilder.withSessionTimeout(yandexMetricaConfig.sessionTimeout.intValue());
        }
        if (dl.a(yandexMetricaConfig.crashReporting)) {
            newConfigBuilder.withCrashReporting(yandexMetricaConfig.crashReporting.booleanValue());
        }
        if (dl.a(yandexMetricaConfig.nativeCrashReporting)) {
            newConfigBuilder.withNativeCrashReporting(yandexMetricaConfig.nativeCrashReporting.booleanValue());
        }
        if (dl.a(yandexMetricaConfig.location)) {
            newConfigBuilder.withLocation(yandexMetricaConfig.location);
        }
        if (dl.a(yandexMetricaConfig.locationTracking)) {
            newConfigBuilder.withLocationTracking(yandexMetricaConfig.locationTracking.booleanValue());
        }
        if (dl.a(yandexMetricaConfig.installedAppCollecting)) {
            newConfigBuilder.withInstalledAppCollecting(yandexMetricaConfig.installedAppCollecting.booleanValue());
        }
        if (dl.a(yandexMetricaConfig.logs) && yandexMetricaConfig.logs.booleanValue()) {
            newConfigBuilder.withLogs();
        }
        if (dl.a(yandexMetricaConfig.preloadInfo)) {
            newConfigBuilder.withPreloadInfo(yandexMetricaConfig.preloadInfo);
        }
        if (dl.a(yandexMetricaConfig.firstActivationAsUpdate)) {
            newConfigBuilder.handleFirstActivationAsUpdate(yandexMetricaConfig.firstActivationAsUpdate.booleanValue());
        }
        if (dl.a(yandexMetricaConfig.statisticsSending)) {
            newConfigBuilder.withStatisticsSending(yandexMetricaConfig.statisticsSending.booleanValue());
        }
        if (dl.a(yandexMetricaConfig.maxReportsInDatabaseCount)) {
            newConfigBuilder.withMaxReportsInDatabaseCount(yandexMetricaConfig.maxReportsInDatabaseCount.intValue());
        }
        return newConfigBuilder;
    }

    public static YandexMetricaConfig fromJson(String str) {
        return new bl().a(str);
    }

    @NonNull
    public static Builder newConfigBuilder(@NonNull String str) {
        return new Builder(str);
    }

    public String toJson() {
        return new bl().a(this);
    }

    public YandexMetricaConfig(@NonNull YandexMetricaConfig yandexMetricaConfig) {
        this.apiKey = yandexMetricaConfig.apiKey;
        this.appVersion = yandexMetricaConfig.appVersion;
        this.sessionTimeout = yandexMetricaConfig.sessionTimeout;
        this.crashReporting = yandexMetricaConfig.crashReporting;
        this.nativeCrashReporting = yandexMetricaConfig.nativeCrashReporting;
        this.location = yandexMetricaConfig.location;
        this.locationTracking = yandexMetricaConfig.locationTracking;
        this.installedAppCollecting = yandexMetricaConfig.installedAppCollecting;
        this.logs = yandexMetricaConfig.logs;
        this.preloadInfo = yandexMetricaConfig.preloadInfo;
        this.firstActivationAsUpdate = yandexMetricaConfig.firstActivationAsUpdate;
        this.statisticsSending = yandexMetricaConfig.statisticsSending;
        this.maxReportsInDatabaseCount = yandexMetricaConfig.maxReportsInDatabaseCount;
    }
}
