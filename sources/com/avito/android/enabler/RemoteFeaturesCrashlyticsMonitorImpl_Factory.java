package com.avito.android.enabler;

import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RemoteFeaturesCrashlyticsMonitorImpl_Factory implements Factory<RemoteFeaturesCrashlyticsMonitorImpl> {
    private final Provider<BuildInfo> buildInfoProvider;
    private final Provider<FirebaseCrashlytics> crashlyticsProvider;

    public RemoteFeaturesCrashlyticsMonitorImpl_Factory(Provider<BuildInfo> provider, Provider<FirebaseCrashlytics> provider2) {
        this.buildInfoProvider = provider;
        this.crashlyticsProvider = provider2;
    }

    public static RemoteFeaturesCrashlyticsMonitorImpl_Factory create(Provider<BuildInfo> provider, Provider<FirebaseCrashlytics> provider2) {
        return new RemoteFeaturesCrashlyticsMonitorImpl_Factory(provider, provider2);
    }

    public static RemoteFeaturesCrashlyticsMonitorImpl newInstance(BuildInfo buildInfo, FirebaseCrashlytics firebaseCrashlytics) {
        return new RemoteFeaturesCrashlyticsMonitorImpl(buildInfo, firebaseCrashlytics);
    }

    @Override // javax.inject.Provider
    public RemoteFeaturesCrashlyticsMonitorImpl get() {
        return newInstance(this.buildInfoProvider.get(), this.crashlyticsProvider.get());
    }
}
