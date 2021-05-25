package com.avito.android.rating.user_reviews;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.util.DialogRouter;
import com.avito.konveyor.ItemBinder;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class UserReviewsActivity_MembersInjector implements MembersInjector<UserReviewsActivity> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<ResponsiveAdapterPresenter> c;
    public final Provider<ItemBinder> d;
    public final Provider<UserReviewsPresenter> e;
    public final Provider<DialogRouter> f;
    public final Provider<Analytics> g;
    public final Provider<Features> h;

    public UserReviewsActivity_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ResponsiveAdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<UserReviewsPresenter> provider5, Provider<DialogRouter> provider6, Provider<Analytics> provider7, Provider<Features> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static MembersInjector<UserReviewsActivity> create(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ResponsiveAdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<UserReviewsPresenter> provider5, Provider<DialogRouter> provider6, Provider<Analytics> provider7, Provider<Features> provider8) {
        return new UserReviewsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @InjectedFieldSignature("com.avito.android.rating.user_reviews.UserReviewsActivity.adapterPresenter")
    public static void injectAdapterPresenter(UserReviewsActivity userReviewsActivity, ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        userReviewsActivity.adapterPresenter = responsiveAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.user_reviews.UserReviewsActivity.analytics")
    public static void injectAnalytics(UserReviewsActivity userReviewsActivity, Analytics analytics) {
        userReviewsActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.rating.user_reviews.UserReviewsActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(UserReviewsActivity userReviewsActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        userReviewsActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.user_reviews.UserReviewsActivity.dialogRouter")
    public static void injectDialogRouter(UserReviewsActivity userReviewsActivity, DialogRouter dialogRouter) {
        userReviewsActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.rating.user_reviews.UserReviewsActivity.features")
    public static void injectFeatures(UserReviewsActivity userReviewsActivity, Features features) {
        userReviewsActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.rating.user_reviews.UserReviewsActivity.intentFactory")
    public static void injectIntentFactory(UserReviewsActivity userReviewsActivity, ActivityIntentFactory activityIntentFactory) {
        userReviewsActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.user_reviews.UserReviewsActivity.itemBinder")
    public static void injectItemBinder(UserReviewsActivity userReviewsActivity, ItemBinder itemBinder) {
        userReviewsActivity.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.rating.user_reviews.UserReviewsActivity.presenter")
    public static void injectPresenter(UserReviewsActivity userReviewsActivity, UserReviewsPresenter userReviewsPresenter) {
        userReviewsActivity.presenter = userReviewsPresenter;
    }

    public void injectMembers(UserReviewsActivity userReviewsActivity) {
        injectIntentFactory(userReviewsActivity, this.a.get());
        injectDeepLinkIntentFactory(userReviewsActivity, this.b.get());
        injectAdapterPresenter(userReviewsActivity, this.c.get());
        injectItemBinder(userReviewsActivity, this.d.get());
        injectPresenter(userReviewsActivity, this.e.get());
        injectDialogRouter(userReviewsActivity, this.f.get());
        injectAnalytics(userReviewsActivity, this.g.get());
        injectFeatures(userReviewsActivity, this.h.get());
    }
}
