package com.avito.android.di.module;

import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsFlushInteractor;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ClickStreamModule_ProvideClickstreamFlushInteractorFactory implements Factory<InHouseAnalyticsFlushInteractor> {
    public final Provider<ShortTaskExactScheduler> a;

    public ClickStreamModule_ProvideClickstreamFlushInteractorFactory(Provider<ShortTaskExactScheduler> provider) {
        this.a = provider;
    }

    public static ClickStreamModule_ProvideClickstreamFlushInteractorFactory create(Provider<ShortTaskExactScheduler> provider) {
        return new ClickStreamModule_ProvideClickstreamFlushInteractorFactory(provider);
    }

    public static InHouseAnalyticsFlushInteractor provideClickstreamFlushInteractor(ShortTaskExactScheduler shortTaskExactScheduler) {
        return (InHouseAnalyticsFlushInteractor) Preconditions.checkNotNullFromProvides(ClickStreamModule.provideClickstreamFlushInteractor(shortTaskExactScheduler));
    }

    @Override // javax.inject.Provider
    public InHouseAnalyticsFlushInteractor get() {
        return provideClickstreamFlushInteractor(this.a.get());
    }
}
