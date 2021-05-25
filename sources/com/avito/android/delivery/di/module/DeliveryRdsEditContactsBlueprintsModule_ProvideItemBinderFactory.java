package com.avito.android.delivery.di.module;

import com.avito.android.delivery.summary.konveyor.button.ButtonItemBlueprint;
import com.avito.android.delivery.summary.konveyor.input.InputItemBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DeliveryRdsEditContactsBlueprintsModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<InputItemBlueprint> a;
    public final Provider<ButtonItemBlueprint> b;

    public DeliveryRdsEditContactsBlueprintsModule_ProvideItemBinderFactory(Provider<InputItemBlueprint> provider, Provider<ButtonItemBlueprint> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DeliveryRdsEditContactsBlueprintsModule_ProvideItemBinderFactory create(Provider<InputItemBlueprint> provider, Provider<ButtonItemBlueprint> provider2) {
        return new DeliveryRdsEditContactsBlueprintsModule_ProvideItemBinderFactory(provider, provider2);
    }

    public static ItemBinder provideItemBinder(InputItemBlueprint inputItemBlueprint, ButtonItemBlueprint buttonItemBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(DeliveryRdsEditContactsBlueprintsModule.INSTANCE.provideItemBinder(inputItemBlueprint, buttonItemBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get(), this.b.get());
    }
}
