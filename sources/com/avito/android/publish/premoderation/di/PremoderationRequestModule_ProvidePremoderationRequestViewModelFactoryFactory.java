package com.avito.android.publish.premoderation.di;

import com.avito.android.Features;
import com.avito.android.publish.premoderation.AdvertProactiveModerationInteractor;
import com.avito.android.publish.premoderation.PremoderationRequestViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PremoderationRequestModule_ProvidePremoderationRequestViewModelFactoryFactory implements Factory<PremoderationRequestViewModelFactory> {
    public final PremoderationRequestModule a;
    public final Provider<AdvertProactiveModerationInteractor> b;
    public final Provider<Features> c;
    public final Provider<SchedulersFactory> d;

    public PremoderationRequestModule_ProvidePremoderationRequestViewModelFactoryFactory(PremoderationRequestModule premoderationRequestModule, Provider<AdvertProactiveModerationInteractor> provider, Provider<Features> provider2, Provider<SchedulersFactory> provider3) {
        this.a = premoderationRequestModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static PremoderationRequestModule_ProvidePremoderationRequestViewModelFactoryFactory create(PremoderationRequestModule premoderationRequestModule, Provider<AdvertProactiveModerationInteractor> provider, Provider<Features> provider2, Provider<SchedulersFactory> provider3) {
        return new PremoderationRequestModule_ProvidePremoderationRequestViewModelFactoryFactory(premoderationRequestModule, provider, provider2, provider3);
    }

    public static PremoderationRequestViewModelFactory providePremoderationRequestViewModelFactory(PremoderationRequestModule premoderationRequestModule, AdvertProactiveModerationInteractor advertProactiveModerationInteractor, Features features, SchedulersFactory schedulersFactory) {
        return (PremoderationRequestViewModelFactory) Preconditions.checkNotNullFromProvides(premoderationRequestModule.providePremoderationRequestViewModelFactory(advertProactiveModerationInteractor, features, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public PremoderationRequestViewModelFactory get() {
        return providePremoderationRequestViewModelFactory(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
