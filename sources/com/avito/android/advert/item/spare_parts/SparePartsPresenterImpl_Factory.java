package com.avito.android.advert.item.spare_parts;

import com.avito.android.spare_parts.SparePartsFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SparePartsPresenterImpl_Factory implements Factory<SparePartsPresenterImpl> {
    public final Provider<SparePartsInteractor> a;
    public final Provider<SparePartsFormatter> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<SparePartsItemType> d;
    public final Provider<Kundle> e;

    public SparePartsPresenterImpl_Factory(Provider<SparePartsInteractor> provider, Provider<SparePartsFormatter> provider2, Provider<SchedulersFactory3> provider3, Provider<SparePartsItemType> provider4, Provider<Kundle> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static SparePartsPresenterImpl_Factory create(Provider<SparePartsInteractor> provider, Provider<SparePartsFormatter> provider2, Provider<SchedulersFactory3> provider3, Provider<SparePartsItemType> provider4, Provider<Kundle> provider5) {
        return new SparePartsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SparePartsPresenterImpl newInstance(SparePartsInteractor sparePartsInteractor, SparePartsFormatter sparePartsFormatter, SchedulersFactory3 schedulersFactory3, SparePartsItemType sparePartsItemType, Kundle kundle) {
        return new SparePartsPresenterImpl(sparePartsInteractor, sparePartsFormatter, schedulersFactory3, sparePartsItemType, kundle);
    }

    @Override // javax.inject.Provider
    public SparePartsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
