package com.avito.android.rating.user_reviews.adapter.placeholder.di;

import com.avito.android.rating.user_reviews.adapter.placeholder.PlaceholderItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PlaceholderItemModule_ProvidePresenter$rating_releaseFactory implements Factory<PlaceholderItemPresenter> {

    public static final class a {
        public static final PlaceholderItemModule_ProvidePresenter$rating_releaseFactory a = new PlaceholderItemModule_ProvidePresenter$rating_releaseFactory();
    }

    public static PlaceholderItemModule_ProvidePresenter$rating_releaseFactory create() {
        return a.a;
    }

    public static PlaceholderItemPresenter providePresenter$rating_release() {
        return (PlaceholderItemPresenter) Preconditions.checkNotNullFromProvides(PlaceholderItemModule.providePresenter$rating_release());
    }

    @Override // javax.inject.Provider
    public PlaceholderItemPresenter get() {
        return providePresenter$rating_release();
    }
}
