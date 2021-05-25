package com.avito.android.safedeal.delivery_courier.di.module;

import com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierContentsComparator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class DeliveryCourierOrderUpdateBlueprintsModule_ProvideDeliveryCourierContentsComparator$safedeal_releaseFactory implements Factory<DeliveryCourierContentsComparator> {

    public static final class a {
        public static final DeliveryCourierOrderUpdateBlueprintsModule_ProvideDeliveryCourierContentsComparator$safedeal_releaseFactory a = new DeliveryCourierOrderUpdateBlueprintsModule_ProvideDeliveryCourierContentsComparator$safedeal_releaseFactory();
    }

    public static DeliveryCourierOrderUpdateBlueprintsModule_ProvideDeliveryCourierContentsComparator$safedeal_releaseFactory create() {
        return a.a;
    }

    public static DeliveryCourierContentsComparator provideDeliveryCourierContentsComparator$safedeal_release() {
        return (DeliveryCourierContentsComparator) Preconditions.checkNotNullFromProvides(DeliveryCourierOrderUpdateBlueprintsModule.provideDeliveryCourierContentsComparator$safedeal_release());
    }

    @Override // javax.inject.Provider
    public DeliveryCourierContentsComparator get() {
        return provideDeliveryCourierContentsComparator$safedeal_release();
    }
}
