package com.avito.android.bundles.vas_union.di;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VasPerformanceListModule_ProvideHeaderBlueprintFactory implements Factory<ItemBlueprint<?, ?>> {
    public final VasPerformanceListModule a;
    public final Provider<PaidServiceHeaderItemPresenter> b;

    public VasPerformanceListModule_ProvideHeaderBlueprintFactory(VasPerformanceListModule vasPerformanceListModule, Provider<PaidServiceHeaderItemPresenter> provider) {
        this.a = vasPerformanceListModule;
        this.b = provider;
    }

    public static VasPerformanceListModule_ProvideHeaderBlueprintFactory create(VasPerformanceListModule vasPerformanceListModule, Provider<PaidServiceHeaderItemPresenter> provider) {
        return new VasPerformanceListModule_ProvideHeaderBlueprintFactory(vasPerformanceListModule, provider);
    }

    public static ItemBlueprint<?, ?> provideHeaderBlueprint(VasPerformanceListModule vasPerformanceListModule, PaidServiceHeaderItemPresenter paidServiceHeaderItemPresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(vasPerformanceListModule.provideHeaderBlueprint(paidServiceHeaderItemPresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideHeaderBlueprint(this.a, this.b.get());
    }
}
