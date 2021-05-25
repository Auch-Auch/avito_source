package com.avito.android.vas_performance.di.perfomance_legacy;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ListModule_ProvideHeaderBlueprintFactory implements Factory<ItemBlueprint<?, ?>> {
    public final ListModule a;
    public final Provider<PaidServiceHeaderItemPresenter> b;

    public ListModule_ProvideHeaderBlueprintFactory(ListModule listModule, Provider<PaidServiceHeaderItemPresenter> provider) {
        this.a = listModule;
        this.b = provider;
    }

    public static ListModule_ProvideHeaderBlueprintFactory create(ListModule listModule, Provider<PaidServiceHeaderItemPresenter> provider) {
        return new ListModule_ProvideHeaderBlueprintFactory(listModule, provider);
    }

    public static ItemBlueprint<?, ?> provideHeaderBlueprint(ListModule listModule, PaidServiceHeaderItemPresenter paidServiceHeaderItemPresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(listModule.provideHeaderBlueprint(paidServiceHeaderItemPresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideHeaderBlueprint(this.a, this.b.get());
    }
}
