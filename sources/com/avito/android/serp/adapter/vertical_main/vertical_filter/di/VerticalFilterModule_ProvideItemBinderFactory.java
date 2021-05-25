package com.avito.android.serp.adapter.vertical_main.vertical_filter.di;

import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemBlueprint;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class VerticalFilterModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<Set<ItemBlueprint<?, ?>>> a;
    public final Provider<VerticalSearchFilterSegmentedItemBlueprint> b;

    public VerticalFilterModule_ProvideItemBinderFactory(Provider<Set<ItemBlueprint<?, ?>>> provider, Provider<VerticalSearchFilterSegmentedItemBlueprint> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static VerticalFilterModule_ProvideItemBinderFactory create(Provider<Set<ItemBlueprint<?, ?>>> provider, Provider<VerticalSearchFilterSegmentedItemBlueprint> provider2) {
        return new VerticalFilterModule_ProvideItemBinderFactory(provider, provider2);
    }

    public static ItemBinder provideItemBinder(Set<ItemBlueprint<?, ?>> set, VerticalSearchFilterSegmentedItemBlueprint verticalSearchFilterSegmentedItemBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(VerticalFilterModule.INSTANCE.provideItemBinder(set, verticalSearchFilterSegmentedItemBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get(), this.b.get());
    }
}
