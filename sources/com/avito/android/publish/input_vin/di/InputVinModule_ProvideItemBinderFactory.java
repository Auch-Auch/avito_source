package com.avito.android.publish.input_vin.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class InputVinModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<Set<ItemBlueprint<?, ?>>> a;

    public InputVinModule_ProvideItemBinderFactory(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        this.a = provider;
    }

    public static InputVinModule_ProvideItemBinderFactory create(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        return new InputVinModule_ProvideItemBinderFactory(provider);
    }

    public static ItemBinder provideItemBinder(Set<ItemBlueprint<?, ?>> set) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(InputVinModule.provideItemBinder(set));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get());
    }
}
