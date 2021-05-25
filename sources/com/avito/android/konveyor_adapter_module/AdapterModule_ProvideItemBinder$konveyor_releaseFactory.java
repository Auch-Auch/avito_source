package com.avito.android.konveyor_adapter_module;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class AdapterModule_ProvideItemBinder$konveyor_releaseFactory implements Factory<ItemBinder> {
    public final Provider<Set<ItemBlueprint<?, ?>>> a;

    public AdapterModule_ProvideItemBinder$konveyor_releaseFactory(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        this.a = provider;
    }

    public static AdapterModule_ProvideItemBinder$konveyor_releaseFactory create(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        return new AdapterModule_ProvideItemBinder$konveyor_releaseFactory(provider);
    }

    public static ItemBinder provideItemBinder$konveyor_release(Set<ItemBlueprint<?, ?>> set) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(AdapterModule.provideItemBinder$konveyor_release(set));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder$konveyor_release(this.a.get());
    }
}
