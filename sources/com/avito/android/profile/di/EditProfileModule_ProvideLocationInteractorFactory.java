package com.avito.android.profile.di;

import com.avito.android.profile.edit.LocationInteractor;
import com.avito.android.profile.edit.LocationInteractorResourceProvider;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditProfileModule_ProvideLocationInteractorFactory implements Factory<LocationInteractor> {
    public final Provider<LocationApi> a;
    public final Provider<ProfileApi> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<LocationInteractorResourceProvider> d;
    public final Provider<Kundle> e;

    public EditProfileModule_ProvideLocationInteractorFactory(Provider<LocationApi> provider, Provider<ProfileApi> provider2, Provider<SchedulersFactory> provider3, Provider<LocationInteractorResourceProvider> provider4, Provider<Kundle> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static EditProfileModule_ProvideLocationInteractorFactory create(Provider<LocationApi> provider, Provider<ProfileApi> provider2, Provider<SchedulersFactory> provider3, Provider<LocationInteractorResourceProvider> provider4, Provider<Kundle> provider5) {
        return new EditProfileModule_ProvideLocationInteractorFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static LocationInteractor provideLocationInteractor(LocationApi locationApi, ProfileApi profileApi, SchedulersFactory schedulersFactory, LocationInteractorResourceProvider locationInteractorResourceProvider, Kundle kundle) {
        return (LocationInteractor) Preconditions.checkNotNullFromProvides(EditProfileModule.provideLocationInteractor(locationApi, profileApi, schedulersFactory, locationInteractorResourceProvider, kundle));
    }

    @Override // javax.inject.Provider
    public LocationInteractor get() {
        return provideLocationInteractor(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
