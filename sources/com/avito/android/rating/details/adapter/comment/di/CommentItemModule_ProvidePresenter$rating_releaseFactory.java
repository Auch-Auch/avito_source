package com.avito.android.rating.details.adapter.comment.di;

import com.avito.android.rating.details.adapter.comment.CommentItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CommentItemModule_ProvidePresenter$rating_releaseFactory implements Factory<CommentItemPresenter> {

    public static final class a {
        public static final CommentItemModule_ProvidePresenter$rating_releaseFactory a = new CommentItemModule_ProvidePresenter$rating_releaseFactory();
    }

    public static CommentItemModule_ProvidePresenter$rating_releaseFactory create() {
        return a.a;
    }

    public static CommentItemPresenter providePresenter$rating_release() {
        return (CommentItemPresenter) Preconditions.checkNotNullFromProvides(CommentItemModule.providePresenter$rating_release());
    }

    @Override // javax.inject.Provider
    public CommentItemPresenter get() {
        return providePresenter$rating_release();
    }
}
