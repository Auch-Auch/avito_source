package com.avito.android.publish.details.di;

import com.avito.android.publish.slots.no_car.item.NoCarSlotItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublishDetailsModule_ProvideNoCarSlotPresenterFactory implements Factory<NoCarSlotItemPresenter> {
    public final PublishDetailsModule a;

    public PublishDetailsModule_ProvideNoCarSlotPresenterFactory(PublishDetailsModule publishDetailsModule) {
        this.a = publishDetailsModule;
    }

    public static PublishDetailsModule_ProvideNoCarSlotPresenterFactory create(PublishDetailsModule publishDetailsModule) {
        return new PublishDetailsModule_ProvideNoCarSlotPresenterFactory(publishDetailsModule);
    }

    public static NoCarSlotItemPresenter provideNoCarSlotPresenter(PublishDetailsModule publishDetailsModule) {
        return (NoCarSlotItemPresenter) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideNoCarSlotPresenter());
    }

    @Override // javax.inject.Provider
    public NoCarSlotItemPresenter get() {
        return provideNoCarSlotPresenter(this.a);
    }
}
