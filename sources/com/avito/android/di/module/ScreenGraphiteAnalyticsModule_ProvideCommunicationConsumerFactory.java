package com.avito.android.di.module;

import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.functions.Consumer;
import javax.inject.Provider;
public final class ScreenGraphiteAnalyticsModule_ProvideCommunicationConsumerFactory implements Factory<Consumer<Long>> {
    public final ScreenGraphiteAnalyticsModule a;
    public final Provider<PublishRelay<Long>> b;

    public ScreenGraphiteAnalyticsModule_ProvideCommunicationConsumerFactory(ScreenGraphiteAnalyticsModule screenGraphiteAnalyticsModule, Provider<PublishRelay<Long>> provider) {
        this.a = screenGraphiteAnalyticsModule;
        this.b = provider;
    }

    public static ScreenGraphiteAnalyticsModule_ProvideCommunicationConsumerFactory create(ScreenGraphiteAnalyticsModule screenGraphiteAnalyticsModule, Provider<PublishRelay<Long>> provider) {
        return new ScreenGraphiteAnalyticsModule_ProvideCommunicationConsumerFactory(screenGraphiteAnalyticsModule, provider);
    }

    public static Consumer<Long> provideCommunicationConsumer(ScreenGraphiteAnalyticsModule screenGraphiteAnalyticsModule, PublishRelay<Long> publishRelay) {
        return (Consumer) Preconditions.checkNotNullFromProvides(screenGraphiteAnalyticsModule.provideCommunicationConsumer(publishRelay));
    }

    @Override // javax.inject.Provider
    public Consumer<Long> get() {
        return provideCommunicationConsumer(this.a, this.b.get());
    }
}
