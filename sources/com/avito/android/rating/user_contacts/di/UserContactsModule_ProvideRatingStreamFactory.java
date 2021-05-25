package com.avito.android.rating.user_contacts.di;

import com.avito.android.rating.user_contacts.action.UserContactAction;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserContactsModule_ProvideRatingStreamFactory implements Factory<PublishRelay<UserContactAction>> {

    public static final class a {
        public static final UserContactsModule_ProvideRatingStreamFactory a = new UserContactsModule_ProvideRatingStreamFactory();
    }

    public static UserContactsModule_ProvideRatingStreamFactory create() {
        return a.a;
    }

    public static PublishRelay<UserContactAction> provideRatingStream() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(UserContactsModule.provideRatingStream());
    }

    @Override // javax.inject.Provider
    public PublishRelay<UserContactAction> get() {
        return provideRatingStream();
    }
}
