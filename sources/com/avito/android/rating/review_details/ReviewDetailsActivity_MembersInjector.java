package com.avito.android.rating.review_details;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.rating.review_details.reply.ReviewReplyPresenter;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class ReviewDetailsActivity_MembersInjector implements MembersInjector<ReviewDetailsActivity> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<ReviewDetailsPresenter> b;
    public final Provider<ReviewReplyPresenter> c;
    public final Provider<ActivityIntentFactory> d;
    public final Provider<Consumer<TnsGalleryItemClickAction>> e;
    public final Provider<Features> f;

    public ReviewDetailsActivity_MembersInjector(Provider<DeepLinkIntentFactory> provider, Provider<ReviewDetailsPresenter> provider2, Provider<ReviewReplyPresenter> provider3, Provider<ActivityIntentFactory> provider4, Provider<Consumer<TnsGalleryItemClickAction>> provider5, Provider<Features> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<ReviewDetailsActivity> create(Provider<DeepLinkIntentFactory> provider, Provider<ReviewDetailsPresenter> provider2, Provider<ReviewReplyPresenter> provider3, Provider<ActivityIntentFactory> provider4, Provider<Consumer<TnsGalleryItemClickAction>> provider5, Provider<Features> provider6) {
        return new ReviewDetailsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.rating.review_details.ReviewDetailsActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(ReviewDetailsActivity reviewDetailsActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        reviewDetailsActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.review_details.ReviewDetailsActivity.features")
    public static void injectFeatures(ReviewDetailsActivity reviewDetailsActivity, Features features) {
        reviewDetailsActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.rating.review_details.ReviewDetailsActivity.imageClicks")
    public static void injectImageClicks(ReviewDetailsActivity reviewDetailsActivity, Consumer<TnsGalleryItemClickAction> consumer) {
        reviewDetailsActivity.imageClicks = consumer;
    }

    @InjectedFieldSignature("com.avito.android.rating.review_details.ReviewDetailsActivity.intentFactory")
    public static void injectIntentFactory(ReviewDetailsActivity reviewDetailsActivity, ActivityIntentFactory activityIntentFactory) {
        reviewDetailsActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.review_details.ReviewDetailsActivity.presenter")
    public static void injectPresenter(ReviewDetailsActivity reviewDetailsActivity, ReviewDetailsPresenter reviewDetailsPresenter) {
        reviewDetailsActivity.presenter = reviewDetailsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.review_details.ReviewDetailsActivity.replyPresenter")
    public static void injectReplyPresenter(ReviewDetailsActivity reviewDetailsActivity, ReviewReplyPresenter reviewReplyPresenter) {
        reviewDetailsActivity.replyPresenter = reviewReplyPresenter;
    }

    public void injectMembers(ReviewDetailsActivity reviewDetailsActivity) {
        injectDeepLinkIntentFactory(reviewDetailsActivity, this.a.get());
        injectPresenter(reviewDetailsActivity, this.b.get());
        injectReplyPresenter(reviewDetailsActivity, this.c.get());
        injectIntentFactory(reviewDetailsActivity, this.d.get());
        injectImageClicks(reviewDetailsActivity, this.e.get());
        injectFeatures(reviewDetailsActivity, this.f.get());
    }
}
