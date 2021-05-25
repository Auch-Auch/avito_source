package com.avito.android.location;

import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.location.back_navigation.BackNavigationLocationInteractor;
import com.avito.android.remote.LocationApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SavedLocationInteractorImpl_Factory implements Factory<SavedLocationInteractorImpl> {
    public final Provider<SavedLocationStorage> a;
    public final Provider<LocationApi> b;
    public final Provider<TopLocationInteractor> c;
    public final Provider<Features> d;
    public final Provider<BackNavigationLocationInteractor> e;

    public SavedLocationInteractorImpl_Factory(Provider<SavedLocationStorage> provider, Provider<LocationApi> provider2, Provider<TopLocationInteractor> provider3, Provider<Features> provider4, Provider<BackNavigationLocationInteractor> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static SavedLocationInteractorImpl_Factory create(Provider<SavedLocationStorage> provider, Provider<LocationApi> provider2, Provider<TopLocationInteractor> provider3, Provider<Features> provider4, Provider<BackNavigationLocationInteractor> provider5) {
        return new SavedLocationInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SavedLocationInteractorImpl newInstance(SavedLocationStorage savedLocationStorage, LocationApi locationApi, TopLocationInteractor topLocationInteractor, Features features, BackNavigationLocationInteractor backNavigationLocationInteractor) {
        return new SavedLocationInteractorImpl(savedLocationStorage, locationApi, topLocationInteractor, features, backNavigationLocationInteractor);
    }

    @Override // javax.inject.Provider
    public SavedLocationInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
