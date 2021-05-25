package com.avito.android.di.module;

import com.avito.android.AnalyticsToggles;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.EventObserver;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class CoreAnalyticsModule_ProvideAnalyticsFactory implements Factory<Analytics> {
    public final CoreAnalyticsModule a;
    public final Provider<Set<EventObserver>> b;
    public final Provider<AnalyticsToggles> c;

    public CoreAnalyticsModule_ProvideAnalyticsFactory(CoreAnalyticsModule coreAnalyticsModule, Provider<Set<EventObserver>> provider, Provider<AnalyticsToggles> provider2) {
        this.a = coreAnalyticsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static CoreAnalyticsModule_ProvideAnalyticsFactory create(CoreAnalyticsModule coreAnalyticsModule, Provider<Set<EventObserver>> provider, Provider<AnalyticsToggles> provider2) {
        return new CoreAnalyticsModule_ProvideAnalyticsFactory(coreAnalyticsModule, provider, provider2);
    }

    public static Analytics provideAnalytics(CoreAnalyticsModule coreAnalyticsModule, Set<EventObserver> set, AnalyticsToggles analyticsToggles) {
        return (Analytics) Preconditions.checkNotNullFromProvides(coreAnalyticsModule.provideAnalytics(set, analyticsToggles));
    }

    @Override // javax.inject.Provider
    public Analytics get() {
        return provideAnalytics(this.a, this.b.get(), this.c.get());
    }
}
