package com.avito.android.rating.details.adapter.rating.di;

import com.avito.android.rating.details.adapter.rating.RatingItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class RatingItemModule_ProvidePresenter$rating_releaseFactory implements Factory<RatingItemPresenter> {

    public static final class a {
        public static final RatingItemModule_ProvidePresenter$rating_releaseFactory a = new RatingItemModule_ProvidePresenter$rating_releaseFactory();
    }

    public static RatingItemModule_ProvidePresenter$rating_releaseFactory create() {
        return a.a;
    }

    public static RatingItemPresenter providePresenter$rating_release() {
        return (RatingItemPresenter) Preconditions.checkNotNullFromProvides(RatingItemModule.providePresenter$rating_release());
    }

    @Override // javax.inject.Provider
    public RatingItemPresenter get() {
        return providePresenter$rating_release();
    }
}
