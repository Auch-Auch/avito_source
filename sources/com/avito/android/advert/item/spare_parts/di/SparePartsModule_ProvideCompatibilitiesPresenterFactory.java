package com.avito.android.advert.item.spare_parts.di;

import com.avito.android.advert.item.spare_parts.SparePartsInteractor;
import com.avito.android.advert.item.spare_parts.SparePartsPresenter;
import com.avito.android.spare_parts.SparePartsFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SparePartsModule_ProvideCompatibilitiesPresenterFactory implements Factory<SparePartsPresenter> {
    public final Provider<SparePartsInteractor> a;
    public final Provider<SparePartsFormatter> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<Kundle> d;

    public SparePartsModule_ProvideCompatibilitiesPresenterFactory(Provider<SparePartsInteractor> provider, Provider<SparePartsFormatter> provider2, Provider<SchedulersFactory3> provider3, Provider<Kundle> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SparePartsModule_ProvideCompatibilitiesPresenterFactory create(Provider<SparePartsInteractor> provider, Provider<SparePartsFormatter> provider2, Provider<SchedulersFactory3> provider3, Provider<Kundle> provider4) {
        return new SparePartsModule_ProvideCompatibilitiesPresenterFactory(provider, provider2, provider3, provider4);
    }

    public static SparePartsPresenter provideCompatibilitiesPresenter(SparePartsInteractor sparePartsInteractor, SparePartsFormatter sparePartsFormatter, SchedulersFactory3 schedulersFactory3, Kundle kundle) {
        return (SparePartsPresenter) Preconditions.checkNotNullFromProvides(SparePartsModule.INSTANCE.provideCompatibilitiesPresenter(sparePartsInteractor, sparePartsFormatter, schedulersFactory3, kundle));
    }

    @Override // javax.inject.Provider
    public SparePartsPresenter get() {
        return provideCompatibilitiesPresenter(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
