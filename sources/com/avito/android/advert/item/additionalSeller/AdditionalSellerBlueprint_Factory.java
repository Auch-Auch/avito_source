package com.avito.android.advert.item.additionalSeller;

import com.avito.android.advert.item.additionalSeller.AdditionalSellerView;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdditionalSellerBlueprint_Factory implements Factory<AdditionalSellerBlueprint> {
    public final Provider<AdditionalSellerPresenter> a;
    public final Provider<AdditionalSellerView.Listener> b;

    public AdditionalSellerBlueprint_Factory(Provider<AdditionalSellerPresenter> provider, Provider<AdditionalSellerView.Listener> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdditionalSellerBlueprint_Factory create(Provider<AdditionalSellerPresenter> provider, Provider<AdditionalSellerView.Listener> provider2) {
        return new AdditionalSellerBlueprint_Factory(provider, provider2);
    }

    public static AdditionalSellerBlueprint newInstance(AdditionalSellerPresenter additionalSellerPresenter, AdditionalSellerView.Listener listener) {
        return new AdditionalSellerBlueprint(additionalSellerPresenter, listener);
    }

    @Override // javax.inject.Provider
    public AdditionalSellerBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
