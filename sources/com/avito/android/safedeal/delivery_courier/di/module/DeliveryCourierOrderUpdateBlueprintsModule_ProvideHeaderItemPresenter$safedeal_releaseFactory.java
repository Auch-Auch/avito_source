package com.avito.android.safedeal.delivery_courier.di.module;

import com.avito.android.safedeal.delivery_courier.summary.konveyor.header.HeaderItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class DeliveryCourierOrderUpdateBlueprintsModule_ProvideHeaderItemPresenter$safedeal_releaseFactory implements Factory<HeaderItemPresenter> {

    public static final class a {
        public static final DeliveryCourierOrderUpdateBlueprintsModule_ProvideHeaderItemPresenter$safedeal_releaseFactory a = new DeliveryCourierOrderUpdateBlueprintsModule_ProvideHeaderItemPresenter$safedeal_releaseFactory();
    }

    public static DeliveryCourierOrderUpdateBlueprintsModule_ProvideHeaderItemPresenter$safedeal_releaseFactory create() {
        return a.a;
    }

    public static HeaderItemPresenter provideHeaderItemPresenter$safedeal_release() {
        return (HeaderItemPresenter) Preconditions.checkNotNullFromProvides(DeliveryCourierOrderUpdateBlueprintsModule.provideHeaderItemPresenter$safedeal_release());
    }

    @Override // javax.inject.Provider
    public HeaderItemPresenter get() {
        return provideHeaderItemPresenter$safedeal_release();
    }
}
