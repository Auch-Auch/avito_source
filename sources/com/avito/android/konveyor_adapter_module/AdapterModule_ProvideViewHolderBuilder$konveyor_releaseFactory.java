package com.avito.android.konveyor_adapter_module;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdapterModule_ProvideViewHolderBuilder$konveyor_releaseFactory implements Factory<ViewHolderBuilder<BaseViewHolder>> {
    public final Provider<ItemBinder> a;

    public AdapterModule_ProvideViewHolderBuilder$konveyor_releaseFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static AdapterModule_ProvideViewHolderBuilder$konveyor_releaseFactory create(Provider<ItemBinder> provider) {
        return new AdapterModule_ProvideViewHolderBuilder$konveyor_releaseFactory(provider);
    }

    public static ViewHolderBuilder<BaseViewHolder> provideViewHolderBuilder$konveyor_release(ItemBinder itemBinder) {
        return (ViewHolderBuilder) Preconditions.checkNotNullFromProvides(AdapterModule.provideViewHolderBuilder$konveyor_release(itemBinder));
    }

    @Override // javax.inject.Provider
    public ViewHolderBuilder<BaseViewHolder> get() {
        return provideViewHolderBuilder$konveyor_release(this.a.get());
    }
}
