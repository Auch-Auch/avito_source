package com.avito.android.publish.details.di;

import com.avito.android.publish.details.tags.PublishTagsViewModel;
import com.avito.android.ui.widget.tagged_input.TagsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideTagsViewModelFactory implements Factory<TagsViewModel> {
    public final PublishDetailsModule a;
    public final Provider<PublishTagsViewModel> b;

    public PublishDetailsModule_ProvideTagsViewModelFactory(PublishDetailsModule publishDetailsModule, Provider<PublishTagsViewModel> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideTagsViewModelFactory create(PublishDetailsModule publishDetailsModule, Provider<PublishTagsViewModel> provider) {
        return new PublishDetailsModule_ProvideTagsViewModelFactory(publishDetailsModule, provider);
    }

    public static TagsViewModel provideTagsViewModel(PublishDetailsModule publishDetailsModule, PublishTagsViewModel publishTagsViewModel) {
        return (TagsViewModel) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideTagsViewModel(publishTagsViewModel));
    }

    @Override // javax.inject.Provider
    public TagsViewModel get() {
        return provideTagsViewModel(this.a, this.b.get());
    }
}
