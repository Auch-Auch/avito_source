package com.avito.android.publish.details.di;

import com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublishDetailsModule_ProvideObjectsItemPresenterFactory implements Factory<MultiStateObjectsItemPresenter> {
    public final PublishDetailsModule a;

    public PublishDetailsModule_ProvideObjectsItemPresenterFactory(PublishDetailsModule publishDetailsModule) {
        this.a = publishDetailsModule;
    }

    public static PublishDetailsModule_ProvideObjectsItemPresenterFactory create(PublishDetailsModule publishDetailsModule) {
        return new PublishDetailsModule_ProvideObjectsItemPresenterFactory(publishDetailsModule);
    }

    public static MultiStateObjectsItemPresenter provideObjectsItemPresenter(PublishDetailsModule publishDetailsModule) {
        return (MultiStateObjectsItemPresenter) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideObjectsItemPresenter());
    }

    @Override // javax.inject.Provider
    public MultiStateObjectsItemPresenter get() {
        return provideObjectsItemPresenter(this.a);
    }
}
