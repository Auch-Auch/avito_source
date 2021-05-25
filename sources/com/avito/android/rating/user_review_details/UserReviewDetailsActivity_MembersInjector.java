package com.avito.android.rating.user_review_details;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class UserReviewDetailsActivity_MembersInjector implements MembersInjector<UserReviewDetailsActivity> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<UserReviewDetailsPresenter> b;
    public final Provider<Features> c;
    public final Provider<ActivityIntentFactory> d;
    public final Provider<Consumer<TnsGalleryItemClickAction>> e;

    public UserReviewDetailsActivity_MembersInjector(Provider<DeepLinkIntentFactory> provider, Provider<UserReviewDetailsPresenter> provider2, Provider<Features> provider3, Provider<ActivityIntentFactory> provider4, Provider<Consumer<TnsGalleryItemClickAction>> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<UserReviewDetailsActivity> create(Provider<DeepLinkIntentFactory> provider, Provider<UserReviewDetailsPresenter> provider2, Provider<Features> provider3, Provider<ActivityIntentFactory> provider4, Provider<Consumer<TnsGalleryItemClickAction>> provider5) {
        return new UserReviewDetailsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.rating.user_review_details.UserReviewDetailsActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(UserReviewDetailsActivity userReviewDetailsActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        userReviewDetailsActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.user_review_details.UserReviewDetailsActivity.features")
    public static void injectFeatures(UserReviewDetailsActivity userReviewDetailsActivity, Features features) {
        userReviewDetailsActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.rating.user_review_details.UserReviewDetailsActivity.imageClicks")
    public static void injectImageClicks(UserReviewDetailsActivity userReviewDetailsActivity, Consumer<TnsGalleryItemClickAction> consumer) {
        userReviewDetailsActivity.imageClicks = consumer;
    }

    @InjectedFieldSignature("com.avito.android.rating.user_review_details.UserReviewDetailsActivity.intentFactory")
    public static void injectIntentFactory(UserReviewDetailsActivity userReviewDetailsActivity, ActivityIntentFactory activityIntentFactory) {
        userReviewDetailsActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.user_review_details.UserReviewDetailsActivity.presenter")
    public static void injectPresenter(UserReviewDetailsActivity userReviewDetailsActivity, UserReviewDetailsPresenter userReviewDetailsPresenter) {
        userReviewDetailsActivity.presenter = userReviewDetailsPresenter;
    }

    public void injectMembers(UserReviewDetailsActivity userReviewDetailsActivity) {
        injectDeepLinkIntentFactory(userReviewDetailsActivity, this.a.get());
        injectPresenter(userReviewDetailsActivity, this.b.get());
        injectFeatures(userReviewDetailsActivity, this.c.get());
        injectIntentFactory(userReviewDetailsActivity, this.d.get());
        injectImageClicks(userReviewDetailsActivity, this.e.get());
    }
}
