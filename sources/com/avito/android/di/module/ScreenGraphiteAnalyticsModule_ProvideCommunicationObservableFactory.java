package com.avito.android.di.module;

import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.Observable;
import javax.inject.Provider;
public final class ScreenGraphiteAnalyticsModule_ProvideCommunicationObservableFactory implements Factory<Observable<Long>> {
    public final ScreenGraphiteAnalyticsModule a;
    public final Provider<PublishRelay<Long>> b;

    public ScreenGraphiteAnalyticsModule_ProvideCommunicationObservableFactory(ScreenGraphiteAnalyticsModule screenGraphiteAnalyticsModule, Provider<PublishRelay<Long>> provider) {
        this.a = screenGraphiteAnalyticsModule;
        this.b = provider;
    }

    public static ScreenGraphiteAnalyticsModule_ProvideCommunicationObservableFactory create(ScreenGraphiteAnalyticsModule screenGraphiteAnalyticsModule, Provider<PublishRelay<Long>> provider) {
        return new ScreenGraphiteAnalyticsModule_ProvideCommunicationObservableFactory(screenGraphiteAnalyticsModule, provider);
    }

    public static Observable<Long> provideCommunicationObservable(ScreenGraphiteAnalyticsModule screenGraphiteAnalyticsModule, PublishRelay<Long> publishRelay) {
        return (Observable) Preconditions.checkNotNullFromProvides(screenGraphiteAnalyticsModule.provideCommunicationObservable(publishRelay));
    }

    @Override // javax.inject.Provider
    public Observable<Long> get() {
        return provideCommunicationObservable(this.a, this.b.get());
    }
}
