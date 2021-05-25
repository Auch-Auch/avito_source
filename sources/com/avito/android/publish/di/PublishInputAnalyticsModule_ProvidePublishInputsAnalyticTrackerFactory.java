package com.avito.android.publish.di;

import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.analytics.PublishInputsAnalyticTracker;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class PublishInputAnalyticsModule_ProvidePublishInputsAnalyticTrackerFactory implements Factory<PublishInputsAnalyticTracker> {
    public final PublishInputAnalyticsModule a;
    public final Provider<PublishEventTracker> b;
    public final Provider<Set<ItemPresenter<?, ?>>> c;

    public PublishInputAnalyticsModule_ProvidePublishInputsAnalyticTrackerFactory(PublishInputAnalyticsModule publishInputAnalyticsModule, Provider<PublishEventTracker> provider, Provider<Set<ItemPresenter<?, ?>>> provider2) {
        this.a = publishInputAnalyticsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PublishInputAnalyticsModule_ProvidePublishInputsAnalyticTrackerFactory create(PublishInputAnalyticsModule publishInputAnalyticsModule, Provider<PublishEventTracker> provider, Provider<Set<ItemPresenter<?, ?>>> provider2) {
        return new PublishInputAnalyticsModule_ProvidePublishInputsAnalyticTrackerFactory(publishInputAnalyticsModule, provider, provider2);
    }

    public static PublishInputsAnalyticTracker providePublishInputsAnalyticTracker(PublishInputAnalyticsModule publishInputAnalyticsModule, PublishEventTracker publishEventTracker, Set<ItemPresenter<?, ?>> set) {
        return (PublishInputsAnalyticTracker) Preconditions.checkNotNullFromProvides(publishInputAnalyticsModule.providePublishInputsAnalyticTracker(publishEventTracker, set));
    }

    @Override // javax.inject.Provider
    public PublishInputsAnalyticTracker get() {
        return providePublishInputsAnalyticTracker(this.a, this.b.get(), this.c.get());
    }
}
