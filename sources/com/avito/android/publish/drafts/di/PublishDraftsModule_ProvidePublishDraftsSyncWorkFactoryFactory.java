package com.avito.android.publish.drafts.di;

import android.content.Context;
import com.avito.android.app.work.PublishDraftsSyncWorkFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDraftsModule_ProvidePublishDraftsSyncWorkFactoryFactory implements Factory<PublishDraftsSyncWorkFactory> {
    public final Provider<Context> a;

    public PublishDraftsModule_ProvidePublishDraftsSyncWorkFactoryFactory(Provider<Context> provider) {
        this.a = provider;
    }

    public static PublishDraftsModule_ProvidePublishDraftsSyncWorkFactoryFactory create(Provider<Context> provider) {
        return new PublishDraftsModule_ProvidePublishDraftsSyncWorkFactoryFactory(provider);
    }

    public static PublishDraftsSyncWorkFactory providePublishDraftsSyncWorkFactory(Context context) {
        return (PublishDraftsSyncWorkFactory) Preconditions.checkNotNullFromProvides(PublishDraftsModule.providePublishDraftsSyncWorkFactory(context));
    }

    @Override // javax.inject.Provider
    public PublishDraftsSyncWorkFactory get() {
        return providePublishDraftsSyncWorkFactory(this.a.get());
    }
}
