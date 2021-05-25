package com.avito.android.publish.sts_scanner.di;

import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.sts_scanner.StsScannerPresenter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StsScannerModule_ProviderStsScannerPresenterFactory implements Factory<StsScannerPresenter> {
    public final StsScannerModule a;
    public final Provider<PublishParametersInteractor> b;
    public final Provider<PublishEventTracker> c;
    public final Provider<SchedulersFactory> d;

    public StsScannerModule_ProviderStsScannerPresenterFactory(StsScannerModule stsScannerModule, Provider<PublishParametersInteractor> provider, Provider<PublishEventTracker> provider2, Provider<SchedulersFactory> provider3) {
        this.a = stsScannerModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static StsScannerModule_ProviderStsScannerPresenterFactory create(StsScannerModule stsScannerModule, Provider<PublishParametersInteractor> provider, Provider<PublishEventTracker> provider2, Provider<SchedulersFactory> provider3) {
        return new StsScannerModule_ProviderStsScannerPresenterFactory(stsScannerModule, provider, provider2, provider3);
    }

    public static StsScannerPresenter providerStsScannerPresenter(StsScannerModule stsScannerModule, PublishParametersInteractor publishParametersInteractor, PublishEventTracker publishEventTracker, SchedulersFactory schedulersFactory) {
        return (StsScannerPresenter) Preconditions.checkNotNullFromProvides(stsScannerModule.providerStsScannerPresenter(publishParametersInteractor, publishEventTracker, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public StsScannerPresenter get() {
        return providerStsScannerPresenter(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
