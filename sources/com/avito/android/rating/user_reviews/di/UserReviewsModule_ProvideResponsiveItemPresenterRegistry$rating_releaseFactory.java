package com.avito.android.rating.user_reviews.di;

import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserReviewsModule_ProvideResponsiveItemPresenterRegistry$rating_releaseFactory implements Factory<CallableResponsiveItemPresenterRegistry> {

    public static final class a {
        public static final UserReviewsModule_ProvideResponsiveItemPresenterRegistry$rating_releaseFactory a = new UserReviewsModule_ProvideResponsiveItemPresenterRegistry$rating_releaseFactory();
    }

    public static UserReviewsModule_ProvideResponsiveItemPresenterRegistry$rating_releaseFactory create() {
        return a.a;
    }

    public static CallableResponsiveItemPresenterRegistry provideResponsiveItemPresenterRegistry$rating_release() {
        return (CallableResponsiveItemPresenterRegistry) Preconditions.checkNotNullFromProvides(UserReviewsModule.provideResponsiveItemPresenterRegistry$rating_release());
    }

    @Override // javax.inject.Provider
    public CallableResponsiveItemPresenterRegistry get() {
        return provideResponsiveItemPresenterRegistry$rating_release();
    }
}
