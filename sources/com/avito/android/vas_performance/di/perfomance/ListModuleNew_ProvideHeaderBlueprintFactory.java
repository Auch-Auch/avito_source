package com.avito.android.vas_performance.di.perfomance;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ListModuleNew_ProvideHeaderBlueprintFactory implements Factory<ItemBlueprint<?, ?>> {
    public final ListModuleNew a;
    public final Provider<PaidServiceHeaderItemPresenter> b;

    public ListModuleNew_ProvideHeaderBlueprintFactory(ListModuleNew listModuleNew, Provider<PaidServiceHeaderItemPresenter> provider) {
        this.a = listModuleNew;
        this.b = provider;
    }

    public static ListModuleNew_ProvideHeaderBlueprintFactory create(ListModuleNew listModuleNew, Provider<PaidServiceHeaderItemPresenter> provider) {
        return new ListModuleNew_ProvideHeaderBlueprintFactory(listModuleNew, provider);
    }

    public static ItemBlueprint<?, ?> provideHeaderBlueprint(ListModuleNew listModuleNew, PaidServiceHeaderItemPresenter paidServiceHeaderItemPresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(listModuleNew.provideHeaderBlueprint(paidServiceHeaderItemPresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideHeaderBlueprint(this.a, this.b.get());
    }
}
