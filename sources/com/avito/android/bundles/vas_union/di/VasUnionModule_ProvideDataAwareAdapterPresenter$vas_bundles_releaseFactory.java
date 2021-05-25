package com.avito.android.bundles.vas_union.di;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VasUnionModule_ProvideDataAwareAdapterPresenter$vas_bundles_releaseFactory implements Factory<DataAwareAdapterPresenter> {
    public final Provider<ListUpdateCallback> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<DiffCalculator> c;

    public VasUnionModule_ProvideDataAwareAdapterPresenter$vas_bundles_releaseFactory(Provider<ListUpdateCallback> provider, Provider<AdapterPresenter> provider2, Provider<DiffCalculator> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static VasUnionModule_ProvideDataAwareAdapterPresenter$vas_bundles_releaseFactory create(Provider<ListUpdateCallback> provider, Provider<AdapterPresenter> provider2, Provider<DiffCalculator> provider3) {
        return new VasUnionModule_ProvideDataAwareAdapterPresenter$vas_bundles_releaseFactory(provider, provider2, provider3);
    }

    public static DataAwareAdapterPresenter provideDataAwareAdapterPresenter$vas_bundles_release(ListUpdateCallback listUpdateCallback, AdapterPresenter adapterPresenter, DiffCalculator diffCalculator) {
        return (DataAwareAdapterPresenter) Preconditions.checkNotNullFromProvides(VasUnionModule.provideDataAwareAdapterPresenter$vas_bundles_release(listUpdateCallback, adapterPresenter, diffCalculator));
    }

    @Override // javax.inject.Provider
    public DataAwareAdapterPresenter get() {
        return provideDataAwareAdapterPresenter$vas_bundles_release(this.a.get(), this.b.get(), this.c.get());
    }
}
