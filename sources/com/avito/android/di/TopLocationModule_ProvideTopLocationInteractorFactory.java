package com.avito.android.di;

import com.avito.android.TopLocationInteractor;
import com.avito.android.remote.LocationApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class TopLocationModule_ProvideTopLocationInteractorFactory implements Factory<TopLocationInteractor> {
    public final Provider<LocationApi> a;

    public TopLocationModule_ProvideTopLocationInteractorFactory(Provider<LocationApi> provider) {
        this.a = provider;
    }

    public static TopLocationModule_ProvideTopLocationInteractorFactory create(Provider<LocationApi> provider) {
        return new TopLocationModule_ProvideTopLocationInteractorFactory(provider);
    }

    public static TopLocationInteractor provideTopLocationInteractor(LocationApi locationApi) {
        return (TopLocationInteractor) Preconditions.checkNotNullFromProvides(TopLocationModule.provideTopLocationInteractor(locationApi));
    }

    @Override // javax.inject.Provider
    public TopLocationInteractor get() {
        return provideTopLocationInteractor(this.a.get());
    }
}
