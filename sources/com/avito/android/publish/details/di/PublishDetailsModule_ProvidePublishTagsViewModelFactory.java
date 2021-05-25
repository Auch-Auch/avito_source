package com.avito.android.publish.details.di;

import com.avito.android.publish.details.tags.PublishTagsViewModel;
import com.avito.android.publish.details.tags.PublishTagsViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvidePublishTagsViewModelFactory implements Factory<PublishTagsViewModel> {
    public final PublishDetailsModule a;
    public final Provider<PublishTagsViewModelFactory> b;

    public PublishDetailsModule_ProvidePublishTagsViewModelFactory(PublishDetailsModule publishDetailsModule, Provider<PublishTagsViewModelFactory> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvidePublishTagsViewModelFactory create(PublishDetailsModule publishDetailsModule, Provider<PublishTagsViewModelFactory> provider) {
        return new PublishDetailsModule_ProvidePublishTagsViewModelFactory(publishDetailsModule, provider);
    }

    public static PublishTagsViewModel providePublishTagsViewModel(PublishDetailsModule publishDetailsModule, PublishTagsViewModelFactory publishTagsViewModelFactory) {
        return (PublishTagsViewModel) Preconditions.checkNotNullFromProvides(publishDetailsModule.providePublishTagsViewModel(publishTagsViewModelFactory));
    }

    @Override // javax.inject.Provider
    public PublishTagsViewModel get() {
        return providePublishTagsViewModel(this.a, this.b.get());
    }
}
