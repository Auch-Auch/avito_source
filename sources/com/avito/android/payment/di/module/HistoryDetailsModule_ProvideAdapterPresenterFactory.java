package com.avito.android.payment.di.module;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HistoryDetailsModule_ProvideAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final HistoryDetailsModule a;
    public final Provider<ItemBinder> b;

    public HistoryDetailsModule_ProvideAdapterPresenterFactory(HistoryDetailsModule historyDetailsModule, Provider<ItemBinder> provider) {
        this.a = historyDetailsModule;
        this.b = provider;
    }

    public static HistoryDetailsModule_ProvideAdapterPresenterFactory create(HistoryDetailsModule historyDetailsModule, Provider<ItemBinder> provider) {
        return new HistoryDetailsModule_ProvideAdapterPresenterFactory(historyDetailsModule, provider);
    }

    public static AdapterPresenter provideAdapterPresenter(HistoryDetailsModule historyDetailsModule, ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(historyDetailsModule.provideAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapterPresenter(this.a, this.b.get());
    }
}
