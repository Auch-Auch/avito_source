package com.avito.android.validation;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideDataAwareAdapterFactory implements Factory<DataAwareAdapterPresenter> {
    public final ParametersListModule a;
    public final Provider<ListUpdateCallback> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<DiffCalculator> d;

    public ParametersListModule_ProvideDataAwareAdapterFactory(ParametersListModule parametersListModule, Provider<ListUpdateCallback> provider, Provider<AdapterPresenter> provider2, Provider<DiffCalculator> provider3) {
        this.a = parametersListModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ParametersListModule_ProvideDataAwareAdapterFactory create(ParametersListModule parametersListModule, Provider<ListUpdateCallback> provider, Provider<AdapterPresenter> provider2, Provider<DiffCalculator> provider3) {
        return new ParametersListModule_ProvideDataAwareAdapterFactory(parametersListModule, provider, provider2, provider3);
    }

    public static DataAwareAdapterPresenter provideDataAwareAdapter(ParametersListModule parametersListModule, Lazy<ListUpdateCallback> lazy, AdapterPresenter adapterPresenter, DiffCalculator diffCalculator) {
        return (DataAwareAdapterPresenter) Preconditions.checkNotNullFromProvides(parametersListModule.provideDataAwareAdapter(lazy, adapterPresenter, diffCalculator));
    }

    @Override // javax.inject.Provider
    public DataAwareAdapterPresenter get() {
        return provideDataAwareAdapter(this.a, DoubleCheck.lazy(this.b), this.c.get(), this.d.get());
    }
}
