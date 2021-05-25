package com.avito.android.publish.premoderation.di;

import com.avito.android.publish.premoderation.AdvertDuplicatePresenter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishAdvertDuplicateModule_ProvideAdvertDuplicatePresenterFactory implements Factory<AdvertDuplicatePresenter> {
    public final PublishAdvertDuplicateModule a;
    public final Provider<SchedulersFactory> b;

    public PublishAdvertDuplicateModule_ProvideAdvertDuplicatePresenterFactory(PublishAdvertDuplicateModule publishAdvertDuplicateModule, Provider<SchedulersFactory> provider) {
        this.a = publishAdvertDuplicateModule;
        this.b = provider;
    }

    public static PublishAdvertDuplicateModule_ProvideAdvertDuplicatePresenterFactory create(PublishAdvertDuplicateModule publishAdvertDuplicateModule, Provider<SchedulersFactory> provider) {
        return new PublishAdvertDuplicateModule_ProvideAdvertDuplicatePresenterFactory(publishAdvertDuplicateModule, provider);
    }

    public static AdvertDuplicatePresenter provideAdvertDuplicatePresenter(PublishAdvertDuplicateModule publishAdvertDuplicateModule, SchedulersFactory schedulersFactory) {
        return (AdvertDuplicatePresenter) Preconditions.checkNotNullFromProvides(publishAdvertDuplicateModule.provideAdvertDuplicatePresenter(schedulersFactory));
    }

    @Override // javax.inject.Provider
    public AdvertDuplicatePresenter get() {
        return provideAdvertDuplicatePresenter(this.a, this.b.get());
    }
}
