package com.avito.android.rating.details.di;

import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class RatingDetailsModule_ProvideItemClicksStream$rating_releaseFactory implements Factory<PublishRelay<RatingDetailsItem>> {

    public static final class a {
        public static final RatingDetailsModule_ProvideItemClicksStream$rating_releaseFactory a = new RatingDetailsModule_ProvideItemClicksStream$rating_releaseFactory();
    }

    public static RatingDetailsModule_ProvideItemClicksStream$rating_releaseFactory create() {
        return a.a;
    }

    public static PublishRelay<RatingDetailsItem> provideItemClicksStream$rating_release() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(RatingDetailsModule.provideItemClicksStream$rating_release());
    }

    @Override // javax.inject.Provider
    public PublishRelay<RatingDetailsItem> get() {
        return provideItemClicksStream$rating_release();
    }
}
