package com.avito.android.safedeal.delivery_courier.di.module;

import com.avito.android.safedeal.delivery_courier.order_update.konveyor.text.TextItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class DeliveryCourierOrderUpdateBlueprintsModule_ProvideTextItemPresenter$safedeal_releaseFactory implements Factory<TextItemPresenter> {

    public static final class a {
        public static final DeliveryCourierOrderUpdateBlueprintsModule_ProvideTextItemPresenter$safedeal_releaseFactory a = new DeliveryCourierOrderUpdateBlueprintsModule_ProvideTextItemPresenter$safedeal_releaseFactory();
    }

    public static DeliveryCourierOrderUpdateBlueprintsModule_ProvideTextItemPresenter$safedeal_releaseFactory create() {
        return a.a;
    }

    public static TextItemPresenter provideTextItemPresenter$safedeal_release() {
        return (TextItemPresenter) Preconditions.checkNotNullFromProvides(DeliveryCourierOrderUpdateBlueprintsModule.provideTextItemPresenter$safedeal_release());
    }

    @Override // javax.inject.Provider
    public TextItemPresenter get() {
        return provideTextItemPresenter$safedeal_release();
    }
}
