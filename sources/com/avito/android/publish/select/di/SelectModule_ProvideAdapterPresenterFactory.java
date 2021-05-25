package com.avito.android.publish.select.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SelectModule_ProvideAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final SelectModule a;
    public final Provider<ItemBinder> b;

    public SelectModule_ProvideAdapterPresenterFactory(SelectModule selectModule, Provider<ItemBinder> provider) {
        this.a = selectModule;
        this.b = provider;
    }

    public static SelectModule_ProvideAdapterPresenterFactory create(SelectModule selectModule, Provider<ItemBinder> provider) {
        return new SelectModule_ProvideAdapterPresenterFactory(selectModule, provider);
    }

    public static AdapterPresenter provideAdapterPresenter(SelectModule selectModule, ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(selectModule.provideAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapterPresenter(this.a, this.b.get());
    }
}
