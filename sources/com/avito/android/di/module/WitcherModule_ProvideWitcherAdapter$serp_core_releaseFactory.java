package com.avito.android.di.module;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class WitcherModule_ProvideWitcherAdapter$serp_core_releaseFactory implements Factory<SimpleAdapterPresenter> {
    public final Provider<ItemBinder> a;

    public WitcherModule_ProvideWitcherAdapter$serp_core_releaseFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static WitcherModule_ProvideWitcherAdapter$serp_core_releaseFactory create(Provider<ItemBinder> provider) {
        return new WitcherModule_ProvideWitcherAdapter$serp_core_releaseFactory(provider);
    }

    public static SimpleAdapterPresenter provideWitcherAdapter$serp_core_release(ItemBinder itemBinder) {
        return (SimpleAdapterPresenter) Preconditions.checkNotNullFromProvides(WitcherModule.INSTANCE.provideWitcherAdapter$serp_core_release(itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleAdapterPresenter get() {
        return provideWitcherAdapter$serp_core_release(this.a.get());
    }
}
