package com.avito.android.tariff.di;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HeaderModule_ProvideHeaderBlueprintFactory implements Factory<ItemBlueprint<?, ?>> {
    public final Provider<PaidServiceHeaderItemPresenter> a;

    public HeaderModule_ProvideHeaderBlueprintFactory(Provider<PaidServiceHeaderItemPresenter> provider) {
        this.a = provider;
    }

    public static HeaderModule_ProvideHeaderBlueprintFactory create(Provider<PaidServiceHeaderItemPresenter> provider) {
        return new HeaderModule_ProvideHeaderBlueprintFactory(provider);
    }

    public static ItemBlueprint<?, ?> provideHeaderBlueprint(PaidServiceHeaderItemPresenter paidServiceHeaderItemPresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(HeaderModule.provideHeaderBlueprint(paidServiceHeaderItemPresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideHeaderBlueprint(this.a.get());
    }
}
