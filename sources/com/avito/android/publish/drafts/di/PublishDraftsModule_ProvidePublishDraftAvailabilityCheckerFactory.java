package com.avito.android.publish.drafts.di;

import com.avito.android.publish.drafts.PublishDraftAvailabilityChecker;
import com.avito.android.publish.drafts.PublishDraftRepository;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDraftsModule_ProvidePublishDraftAvailabilityCheckerFactory implements Factory<PublishDraftAvailabilityChecker> {
    public final Provider<PublishDraftRepository> a;

    public PublishDraftsModule_ProvidePublishDraftAvailabilityCheckerFactory(Provider<PublishDraftRepository> provider) {
        this.a = provider;
    }

    public static PublishDraftsModule_ProvidePublishDraftAvailabilityCheckerFactory create(Provider<PublishDraftRepository> provider) {
        return new PublishDraftsModule_ProvidePublishDraftAvailabilityCheckerFactory(provider);
    }

    public static PublishDraftAvailabilityChecker providePublishDraftAvailabilityChecker(Lazy<PublishDraftRepository> lazy) {
        return (PublishDraftAvailabilityChecker) Preconditions.checkNotNullFromProvides(PublishDraftsModule.providePublishDraftAvailabilityChecker(lazy));
    }

    @Override // javax.inject.Provider
    public PublishDraftAvailabilityChecker get() {
        return providePublishDraftAvailabilityChecker(DoubleCheck.lazy(this.a));
    }
}
