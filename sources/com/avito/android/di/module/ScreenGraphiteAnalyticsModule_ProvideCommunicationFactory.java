package com.avito.android.di.module;

import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ScreenGraphiteAnalyticsModule_ProvideCommunicationFactory implements Factory<PublishRelay<Long>> {
    public final ScreenGraphiteAnalyticsModule a;

    public ScreenGraphiteAnalyticsModule_ProvideCommunicationFactory(ScreenGraphiteAnalyticsModule screenGraphiteAnalyticsModule) {
        this.a = screenGraphiteAnalyticsModule;
    }

    public static ScreenGraphiteAnalyticsModule_ProvideCommunicationFactory create(ScreenGraphiteAnalyticsModule screenGraphiteAnalyticsModule) {
        return new ScreenGraphiteAnalyticsModule_ProvideCommunicationFactory(screenGraphiteAnalyticsModule);
    }

    public static PublishRelay<Long> provideCommunication(ScreenGraphiteAnalyticsModule screenGraphiteAnalyticsModule) {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(screenGraphiteAnalyticsModule.provideCommunication());
    }

    @Override // javax.inject.Provider
    public PublishRelay<Long> get() {
        return provideCommunication(this.a);
    }
}
