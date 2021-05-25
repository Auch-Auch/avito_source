package com.avito.android.auto_catalog.di;

import com.avito.android.serp.adapter.RdsAdvertGridItemBlueprint;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class AutoCatalogModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<RdsAdvertGridItemBlueprint> a;
    public final Provider<Set<ItemBlueprint<?, ?>>> b;

    public AutoCatalogModule_ProvideItemBinderFactory(Provider<RdsAdvertGridItemBlueprint> provider, Provider<Set<ItemBlueprint<?, ?>>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AutoCatalogModule_ProvideItemBinderFactory create(Provider<RdsAdvertGridItemBlueprint> provider, Provider<Set<ItemBlueprint<?, ?>>> provider2) {
        return new AutoCatalogModule_ProvideItemBinderFactory(provider, provider2);
    }

    public static ItemBinder provideItemBinder(RdsAdvertGridItemBlueprint rdsAdvertGridItemBlueprint, Set<ItemBlueprint<?, ?>> set) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(AutoCatalogModule.INSTANCE.provideItemBinder(rdsAdvertGridItemBlueprint, set));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get(), this.b.get());
    }
}
