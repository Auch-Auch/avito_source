package com.avito.android.validation;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final ParametersListModule a;
    public final Provider<ItemBinder> b;

    public ParametersListModule_ProvideAdapterPresenterFactory(ParametersListModule parametersListModule, Provider<ItemBinder> provider) {
        this.a = parametersListModule;
        this.b = provider;
    }

    public static ParametersListModule_ProvideAdapterPresenterFactory create(ParametersListModule parametersListModule, Provider<ItemBinder> provider) {
        return new ParametersListModule_ProvideAdapterPresenterFactory(parametersListModule, provider);
    }

    public static AdapterPresenter provideAdapterPresenter(ParametersListModule parametersListModule, ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(parametersListModule.provideAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapterPresenter(this.a, this.b.get());
    }
}
