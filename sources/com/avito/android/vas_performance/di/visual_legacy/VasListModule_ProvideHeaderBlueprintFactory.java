package com.avito.android.vas_performance.di.visual_legacy;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VasListModule_ProvideHeaderBlueprintFactory implements Factory<ItemBlueprint<?, ?>> {
    public final VasListModule a;
    public final Provider<PaidServiceHeaderItemPresenter> b;

    public VasListModule_ProvideHeaderBlueprintFactory(VasListModule vasListModule, Provider<PaidServiceHeaderItemPresenter> provider) {
        this.a = vasListModule;
        this.b = provider;
    }

    public static VasListModule_ProvideHeaderBlueprintFactory create(VasListModule vasListModule, Provider<PaidServiceHeaderItemPresenter> provider) {
        return new VasListModule_ProvideHeaderBlueprintFactory(vasListModule, provider);
    }

    public static ItemBlueprint<?, ?> provideHeaderBlueprint(VasListModule vasListModule, PaidServiceHeaderItemPresenter paidServiceHeaderItemPresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(vasListModule.provideHeaderBlueprint(paidServiceHeaderItemPresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideHeaderBlueprint(this.a, this.b.get());
    }
}
