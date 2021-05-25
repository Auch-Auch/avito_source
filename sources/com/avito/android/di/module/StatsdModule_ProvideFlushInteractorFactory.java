package com.avito.android.di.module;

import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsFlushInteractor;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StatsdModule_ProvideFlushInteractorFactory implements Factory<InHouseAnalyticsFlushInteractor> {
    public final Provider<ShortTaskExactScheduler> a;

    public StatsdModule_ProvideFlushInteractorFactory(Provider<ShortTaskExactScheduler> provider) {
        this.a = provider;
    }

    public static StatsdModule_ProvideFlushInteractorFactory create(Provider<ShortTaskExactScheduler> provider) {
        return new StatsdModule_ProvideFlushInteractorFactory(provider);
    }

    public static InHouseAnalyticsFlushInteractor provideFlushInteractor(ShortTaskExactScheduler shortTaskExactScheduler) {
        return (InHouseAnalyticsFlushInteractor) Preconditions.checkNotNullFromProvides(StatsdModule.provideFlushInteractor(shortTaskExactScheduler));
    }

    @Override // javax.inject.Provider
    public InHouseAnalyticsFlushInteractor get() {
        return provideFlushInteractor(this.a.get());
    }
}
