package com.avito.android.publish.drafts.di;

import com.avito.android.photo_picker.legacy.DraftPhotosWiper;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.PublishDraftWiper;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDraftsModule_ProvidePublishDraftWiperFactory implements Factory<PublishDraftWiper> {
    public final Provider<DraftPhotosWiper> a;
    public final Provider<PublishDraftRepository> b;

    public PublishDraftsModule_ProvidePublishDraftWiperFactory(Provider<DraftPhotosWiper> provider, Provider<PublishDraftRepository> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PublishDraftsModule_ProvidePublishDraftWiperFactory create(Provider<DraftPhotosWiper> provider, Provider<PublishDraftRepository> provider2) {
        return new PublishDraftsModule_ProvidePublishDraftWiperFactory(provider, provider2);
    }

    public static PublishDraftWiper providePublishDraftWiper(DraftPhotosWiper draftPhotosWiper, Lazy<PublishDraftRepository> lazy) {
        return (PublishDraftWiper) Preconditions.checkNotNullFromProvides(PublishDraftsModule.providePublishDraftWiper(draftPhotosWiper, lazy));
    }

    @Override // javax.inject.Provider
    public PublishDraftWiper get() {
        return providePublishDraftWiper(this.a.get(), DoubleCheck.lazy(this.b));
    }
}
