package com.avito.android.payment.di.module;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class TopUpFormModule_ProvideAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final TopUpFormModule a;
    public final Provider<ItemBinder> b;

    public TopUpFormModule_ProvideAdapterPresenterFactory(TopUpFormModule topUpFormModule, Provider<ItemBinder> provider) {
        this.a = topUpFormModule;
        this.b = provider;
    }

    public static TopUpFormModule_ProvideAdapterPresenterFactory create(TopUpFormModule topUpFormModule, Provider<ItemBinder> provider) {
        return new TopUpFormModule_ProvideAdapterPresenterFactory(topUpFormModule, provider);
    }

    public static AdapterPresenter provideAdapterPresenter(TopUpFormModule topUpFormModule, ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(topUpFormModule.provideAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapterPresenter(this.a, this.b.get());
    }
}
