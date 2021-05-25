package com.avito.android.delivery.di.module;

import com.avito.android.delivery.order_cancellation.konveyor.ReasonItemBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class RdsOrderCancellationBlueprintsModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<ReasonItemBlueprint> a;

    public RdsOrderCancellationBlueprintsModule_ProvideItemBinderFactory(Provider<ReasonItemBlueprint> provider) {
        this.a = provider;
    }

    public static RdsOrderCancellationBlueprintsModule_ProvideItemBinderFactory create(Provider<ReasonItemBlueprint> provider) {
        return new RdsOrderCancellationBlueprintsModule_ProvideItemBinderFactory(provider);
    }

    public static ItemBinder provideItemBinder(ReasonItemBlueprint reasonItemBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(RdsOrderCancellationBlueprintsModule.INSTANCE.provideItemBinder(reasonItemBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get());
    }
}
