package com.avito.android.analytics;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CrashReporterImpl_Factory implements Factory<CrashReporterImpl> {
    public final Provider<Analytics> a;

    public CrashReporterImpl_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static CrashReporterImpl_Factory create(Provider<Analytics> provider) {
        return new CrashReporterImpl_Factory(provider);
    }

    public static CrashReporterImpl newInstance(Analytics analytics) {
        return new CrashReporterImpl(analytics);
    }

    @Override // javax.inject.Provider
    public CrashReporterImpl get() {
        return newInstance(this.a.get());
    }
}
