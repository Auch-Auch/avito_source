package com.avito.android.profile.di;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditProfileModule_ProvideDataAwareAdapterFactory implements Factory<AdapterPresenter> {
    public final Provider<ListUpdateCallback> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<DiffCalculator> c;

    public EditProfileModule_ProvideDataAwareAdapterFactory(Provider<ListUpdateCallback> provider, Provider<AdapterPresenter> provider2, Provider<DiffCalculator> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static EditProfileModule_ProvideDataAwareAdapterFactory create(Provider<ListUpdateCallback> provider, Provider<AdapterPresenter> provider2, Provider<DiffCalculator> provider3) {
        return new EditProfileModule_ProvideDataAwareAdapterFactory(provider, provider2, provider3);
    }

    public static AdapterPresenter provideDataAwareAdapter(Lazy<ListUpdateCallback> lazy, AdapterPresenter adapterPresenter, DiffCalculator diffCalculator) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(EditProfileModule.provideDataAwareAdapter(lazy, adapterPresenter, diffCalculator));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideDataAwareAdapter(DoubleCheck.lazy(this.a), this.b.get(), this.c.get());
    }
}
