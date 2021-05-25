package com.avito.android.validation;

import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideRecyclerAdapterFactory implements Factory<SimpleRecyclerAdapter> {
    public final ParametersListModule a;
    public final Provider<DataAwareAdapterPresenter> b;
    public final Provider<ItemBinder> c;

    public ParametersListModule_ProvideRecyclerAdapterFactory(ParametersListModule parametersListModule, Provider<DataAwareAdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = parametersListModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ParametersListModule_ProvideRecyclerAdapterFactory create(ParametersListModule parametersListModule, Provider<DataAwareAdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new ParametersListModule_ProvideRecyclerAdapterFactory(parametersListModule, provider, provider2);
    }

    public static SimpleRecyclerAdapter provideRecyclerAdapter(ParametersListModule parametersListModule, DataAwareAdapterPresenter dataAwareAdapterPresenter, ItemBinder itemBinder) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(parametersListModule.provideRecyclerAdapter(dataAwareAdapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return provideRecyclerAdapter(this.a, this.b.get(), this.c.get());
    }
}
