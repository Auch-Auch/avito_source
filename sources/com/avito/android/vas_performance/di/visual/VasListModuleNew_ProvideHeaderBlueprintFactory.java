package com.avito.android.vas_performance.di.visual;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VasListModuleNew_ProvideHeaderBlueprintFactory implements Factory<ItemBlueprint<?, ?>> {
    public final VasListModuleNew a;
    public final Provider<PaidServiceHeaderItemPresenter> b;

    public VasListModuleNew_ProvideHeaderBlueprintFactory(VasListModuleNew vasListModuleNew, Provider<PaidServiceHeaderItemPresenter> provider) {
        this.a = vasListModuleNew;
        this.b = provider;
    }

    public static VasListModuleNew_ProvideHeaderBlueprintFactory create(VasListModuleNew vasListModuleNew, Provider<PaidServiceHeaderItemPresenter> provider) {
        return new VasListModuleNew_ProvideHeaderBlueprintFactory(vasListModuleNew, provider);
    }

    public static ItemBlueprint<?, ?> provideHeaderBlueprint(VasListModuleNew vasListModuleNew, PaidServiceHeaderItemPresenter paidServiceHeaderItemPresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(vasListModuleNew.provideHeaderBlueprint(paidServiceHeaderItemPresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideHeaderBlueprint(this.a, this.b.get());
    }
}
