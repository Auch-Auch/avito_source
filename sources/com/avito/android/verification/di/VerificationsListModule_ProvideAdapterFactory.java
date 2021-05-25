package com.avito.android.verification.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VerificationsListModule_ProvideAdapterFactory implements Factory<AdapterPresenter> {
    public final VerificationsListModule a;
    public final Provider<ItemBinder> b;

    public VerificationsListModule_ProvideAdapterFactory(VerificationsListModule verificationsListModule, Provider<ItemBinder> provider) {
        this.a = verificationsListModule;
        this.b = provider;
    }

    public static VerificationsListModule_ProvideAdapterFactory create(VerificationsListModule verificationsListModule, Provider<ItemBinder> provider) {
        return new VerificationsListModule_ProvideAdapterFactory(verificationsListModule, provider);
    }

    public static AdapterPresenter provideAdapter(VerificationsListModule verificationsListModule, ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(verificationsListModule.provideAdapter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapter(this.a, this.b.get());
    }
}
