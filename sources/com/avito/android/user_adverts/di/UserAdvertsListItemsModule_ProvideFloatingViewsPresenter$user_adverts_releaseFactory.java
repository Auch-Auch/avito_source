package com.avito.android.user_adverts.di;

import com.avito.android.floating_views.FloatingViewsPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserAdvertsListItemsModule_ProvideFloatingViewsPresenter$user_adverts_releaseFactory implements Factory<FloatingViewsPresenter> {

    public static final class a {
        public static final UserAdvertsListItemsModule_ProvideFloatingViewsPresenter$user_adverts_releaseFactory a = new UserAdvertsListItemsModule_ProvideFloatingViewsPresenter$user_adverts_releaseFactory();
    }

    public static UserAdvertsListItemsModule_ProvideFloatingViewsPresenter$user_adverts_releaseFactory create() {
        return a.a;
    }

    public static FloatingViewsPresenter provideFloatingViewsPresenter$user_adverts_release() {
        return (FloatingViewsPresenter) Preconditions.checkNotNullFromProvides(UserAdvertsListItemsModule.provideFloatingViewsPresenter$user_adverts_release());
    }

    @Override // javax.inject.Provider
    public FloatingViewsPresenter get() {
        return provideFloatingViewsPresenter$user_adverts_release();
    }
}
