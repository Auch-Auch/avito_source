package com.avito.android.ab_tests;

import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UsedAbTestReporterImpl_Factory implements Factory<UsedAbTestReporterImpl> {
    public final Provider<FirebaseCrashlytics> a;

    public UsedAbTestReporterImpl_Factory(Provider<FirebaseCrashlytics> provider) {
        this.a = provider;
    }

    public static UsedAbTestReporterImpl_Factory create(Provider<FirebaseCrashlytics> provider) {
        return new UsedAbTestReporterImpl_Factory(provider);
    }

    public static UsedAbTestReporterImpl newInstance(FirebaseCrashlytics firebaseCrashlytics) {
        return new UsedAbTestReporterImpl(firebaseCrashlytics);
    }

    @Override // javax.inject.Provider
    public UsedAbTestReporterImpl get() {
        return newInstance(this.a.get());
    }
}
