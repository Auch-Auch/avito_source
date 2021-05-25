package com.avito.android.publish.details.di;

import com.avito.android.publish.details.tags.PublishTagsInteractor;
import com.avito.android.publish.details.tags.PublishTagsViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideTagsViewModelFactoryFactory implements Factory<PublishTagsViewModelFactory> {
    public final PublishDetailsModule a;
    public final Provider<PublishTagsInteractor> b;
    public final Provider<SchedulersFactory> c;

    public PublishDetailsModule_ProvideTagsViewModelFactoryFactory(PublishDetailsModule publishDetailsModule, Provider<PublishTagsInteractor> provider, Provider<SchedulersFactory> provider2) {
        this.a = publishDetailsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PublishDetailsModule_ProvideTagsViewModelFactoryFactory create(PublishDetailsModule publishDetailsModule, Provider<PublishTagsInteractor> provider, Provider<SchedulersFactory> provider2) {
        return new PublishDetailsModule_ProvideTagsViewModelFactoryFactory(publishDetailsModule, provider, provider2);
    }

    public static PublishTagsViewModelFactory provideTagsViewModelFactory(PublishDetailsModule publishDetailsModule, PublishTagsInteractor publishTagsInteractor, SchedulersFactory schedulersFactory) {
        return (PublishTagsViewModelFactory) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideTagsViewModelFactory(publishTagsInteractor, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public PublishTagsViewModelFactory get() {
        return provideTagsViewModelFactory(this.a, this.b.get(), this.c.get());
    }
}
