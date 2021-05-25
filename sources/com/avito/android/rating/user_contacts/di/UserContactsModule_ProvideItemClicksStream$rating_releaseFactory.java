package com.avito.android.rating.user_contacts.di;

import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserContactsModule_ProvideItemClicksStream$rating_releaseFactory implements Factory<PublishRelay<RatingDetailsItem>> {

    public static final class a {
        public static final UserContactsModule_ProvideItemClicksStream$rating_releaseFactory a = new UserContactsModule_ProvideItemClicksStream$rating_releaseFactory();
    }

    public static UserContactsModule_ProvideItemClicksStream$rating_releaseFactory create() {
        return a.a;
    }

    public static PublishRelay<RatingDetailsItem> provideItemClicksStream$rating_release() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(UserContactsModule.provideItemClicksStream$rating_release());
    }

    @Override // javax.inject.Provider
    public PublishRelay<RatingDetailsItem> get() {
        return provideItemClicksStream$rating_release();
    }
}
