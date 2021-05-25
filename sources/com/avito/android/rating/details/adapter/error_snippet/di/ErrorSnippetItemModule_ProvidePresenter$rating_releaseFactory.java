package com.avito.android.rating.details.adapter.error_snippet.di;

import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.error_snippet.ErrorSnippetItemPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ErrorSnippetItemModule_ProvidePresenter$rating_releaseFactory implements Factory<ErrorSnippetItemPresenter> {
    public final Provider<PublishRelay<RatingDetailsItem>> a;

    public ErrorSnippetItemModule_ProvidePresenter$rating_releaseFactory(Provider<PublishRelay<RatingDetailsItem>> provider) {
        this.a = provider;
    }

    public static ErrorSnippetItemModule_ProvidePresenter$rating_releaseFactory create(Provider<PublishRelay<RatingDetailsItem>> provider) {
        return new ErrorSnippetItemModule_ProvidePresenter$rating_releaseFactory(provider);
    }

    public static ErrorSnippetItemPresenter providePresenter$rating_release(PublishRelay<RatingDetailsItem> publishRelay) {
        return (ErrorSnippetItemPresenter) Preconditions.checkNotNullFromProvides(ErrorSnippetItemModule.providePresenter$rating_release(publishRelay));
    }

    @Override // javax.inject.Provider
    public ErrorSnippetItemPresenter get() {
        return providePresenter$rating_release(this.a.get());
    }
}
