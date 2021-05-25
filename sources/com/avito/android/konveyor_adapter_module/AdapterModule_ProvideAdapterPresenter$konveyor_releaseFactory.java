package com.avito.android.konveyor_adapter_module;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory implements Factory<AdapterPresenter> {
    public final Provider<ItemBinder> a;

    public AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory create(Provider<ItemBinder> provider) {
        return new AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory(provider);
    }

    public static AdapterPresenter provideAdapterPresenter$konveyor_release(ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(AdapterModule.provideAdapterPresenter$konveyor_release(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapterPresenter$konveyor_release(this.a.get());
    }
}
