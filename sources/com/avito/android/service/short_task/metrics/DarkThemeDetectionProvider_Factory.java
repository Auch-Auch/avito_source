package com.avito.android.service.short_task.metrics;

import android.content.Context;
import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DarkThemeDetectionProvider_Factory implements Factory<DarkThemeDetectionProvider> {
    public final Provider<Analytics> a;
    public final Provider<Context> b;

    public DarkThemeDetectionProvider_Factory(Provider<Analytics> provider, Provider<Context> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DarkThemeDetectionProvider_Factory create(Provider<Analytics> provider, Provider<Context> provider2) {
        return new DarkThemeDetectionProvider_Factory(provider, provider2);
    }

    public static DarkThemeDetectionProvider newInstance(Analytics analytics, Context context) {
        return new DarkThemeDetectionProvider(analytics, context);
    }

    @Override // javax.inject.Provider
    public DarkThemeDetectionProvider get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
