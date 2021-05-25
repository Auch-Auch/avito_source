package com.avito.android.publish.drafts.di;

import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublishDraftsModule_ProvidePublishDraftUpdateObservableFactory implements Factory<PublishRelay<String>> {

    public static final class a {
        public static final PublishDraftsModule_ProvidePublishDraftUpdateObservableFactory a = new PublishDraftsModule_ProvidePublishDraftUpdateObservableFactory();
    }

    public static PublishDraftsModule_ProvidePublishDraftUpdateObservableFactory create() {
        return a.a;
    }

    public static PublishRelay<String> providePublishDraftUpdateObservable() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(PublishDraftsModule.providePublishDraftUpdateObservable());
    }

    @Override // javax.inject.Provider
    public PublishRelay<String> get() {
        return providePublishDraftUpdateObservable();
    }
}
