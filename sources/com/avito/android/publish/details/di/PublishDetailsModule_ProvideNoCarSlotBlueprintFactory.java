package com.avito.android.publish.details.di;

import com.avito.android.publish.slots.no_car.item.NoCarSlotBlueprint;
import com.avito.android.publish.slots.no_car.item.NoCarSlotItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideNoCarSlotBlueprintFactory implements Factory<NoCarSlotBlueprint> {
    public final PublishDetailsModule a;
    public final Provider<NoCarSlotItemPresenter> b;

    public PublishDetailsModule_ProvideNoCarSlotBlueprintFactory(PublishDetailsModule publishDetailsModule, Provider<NoCarSlotItemPresenter> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideNoCarSlotBlueprintFactory create(PublishDetailsModule publishDetailsModule, Provider<NoCarSlotItemPresenter> provider) {
        return new PublishDetailsModule_ProvideNoCarSlotBlueprintFactory(publishDetailsModule, provider);
    }

    public static NoCarSlotBlueprint provideNoCarSlotBlueprint(PublishDetailsModule publishDetailsModule, NoCarSlotItemPresenter noCarSlotItemPresenter) {
        return (NoCarSlotBlueprint) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideNoCarSlotBlueprint(noCarSlotItemPresenter));
    }

    @Override // javax.inject.Provider
    public NoCarSlotBlueprint get() {
        return provideNoCarSlotBlueprint(this.a, this.b.get());
    }
}
