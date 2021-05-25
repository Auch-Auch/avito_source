package com.avito.android.recycler.data_aware;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DataAwareAdapterPresenterImpl_Factory implements Factory<DataAwareAdapterPresenterImpl> {
    public final Provider<ListUpdateCallback> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<DiffCalculator> c;

    public DataAwareAdapterPresenterImpl_Factory(Provider<ListUpdateCallback> provider, Provider<AdapterPresenter> provider2, Provider<DiffCalculator> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static DataAwareAdapterPresenterImpl_Factory create(Provider<ListUpdateCallback> provider, Provider<AdapterPresenter> provider2, Provider<DiffCalculator> provider3) {
        return new DataAwareAdapterPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static DataAwareAdapterPresenterImpl newInstance(Lazy<ListUpdateCallback> lazy, AdapterPresenter adapterPresenter, DiffCalculator diffCalculator) {
        return new DataAwareAdapterPresenterImpl(lazy, adapterPresenter, diffCalculator);
    }

    @Override // javax.inject.Provider
    public DataAwareAdapterPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get(), this.c.get());
    }
}
