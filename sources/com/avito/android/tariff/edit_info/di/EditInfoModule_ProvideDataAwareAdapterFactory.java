package com.avito.android.tariff.edit_info.di;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditInfoModule_ProvideDataAwareAdapterFactory implements Factory<DataAwareAdapterPresenter> {
    public final Provider<ListUpdateCallback> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<DiffCalculator> c;

    public EditInfoModule_ProvideDataAwareAdapterFactory(Provider<ListUpdateCallback> provider, Provider<AdapterPresenter> provider2, Provider<DiffCalculator> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static EditInfoModule_ProvideDataAwareAdapterFactory create(Provider<ListUpdateCallback> provider, Provider<AdapterPresenter> provider2, Provider<DiffCalculator> provider3) {
        return new EditInfoModule_ProvideDataAwareAdapterFactory(provider, provider2, provider3);
    }

    public static DataAwareAdapterPresenter provideDataAwareAdapter(Lazy<ListUpdateCallback> lazy, AdapterPresenter adapterPresenter, DiffCalculator diffCalculator) {
        return (DataAwareAdapterPresenter) Preconditions.checkNotNullFromProvides(EditInfoModule.provideDataAwareAdapter(lazy, adapterPresenter, diffCalculator));
    }

    @Override // javax.inject.Provider
    public DataAwareAdapterPresenter get() {
        return provideDataAwareAdapter(DoubleCheck.lazy(this.a), this.b.get(), this.c.get());
    }
}
