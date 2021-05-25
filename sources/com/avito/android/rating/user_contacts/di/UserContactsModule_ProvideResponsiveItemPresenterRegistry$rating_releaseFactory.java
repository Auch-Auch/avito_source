package com.avito.android.rating.user_contacts.di;

import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserContactsModule_ProvideResponsiveItemPresenterRegistry$rating_releaseFactory implements Factory<CallableResponsiveItemPresenterRegistry> {

    public static final class a {
        public static final UserContactsModule_ProvideResponsiveItemPresenterRegistry$rating_releaseFactory a = new UserContactsModule_ProvideResponsiveItemPresenterRegistry$rating_releaseFactory();
    }

    public static UserContactsModule_ProvideResponsiveItemPresenterRegistry$rating_releaseFactory create() {
        return a.a;
    }

    public static CallableResponsiveItemPresenterRegistry provideResponsiveItemPresenterRegistry$rating_release() {
        return (CallableResponsiveItemPresenterRegistry) Preconditions.checkNotNullFromProvides(UserContactsModule.provideResponsiveItemPresenterRegistry$rating_release());
    }

    @Override // javax.inject.Provider
    public CallableResponsiveItemPresenterRegistry get() {
        return provideResponsiveItemPresenterRegistry$rating_release();
    }
}
