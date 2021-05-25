package com.avito.android.rating.details.adapter.user_profile_comment.di;

import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserProfileCommentItemModule_ProvidePresenter$rating_releaseFactory implements Factory<UserProfileCommentItemPresenter> {
    public final Provider<PublishRelay<RatingDetailsItem>> a;

    public UserProfileCommentItemModule_ProvidePresenter$rating_releaseFactory(Provider<PublishRelay<RatingDetailsItem>> provider) {
        this.a = provider;
    }

    public static UserProfileCommentItemModule_ProvidePresenter$rating_releaseFactory create(Provider<PublishRelay<RatingDetailsItem>> provider) {
        return new UserProfileCommentItemModule_ProvidePresenter$rating_releaseFactory(provider);
    }

    public static UserProfileCommentItemPresenter providePresenter$rating_release(PublishRelay<RatingDetailsItem> publishRelay) {
        return (UserProfileCommentItemPresenter) Preconditions.checkNotNullFromProvides(UserProfileCommentItemModule.providePresenter$rating_release(publishRelay));
    }

    @Override // javax.inject.Provider
    public UserProfileCommentItemPresenter get() {
        return providePresenter$rating_release(this.a.get());
    }
}
