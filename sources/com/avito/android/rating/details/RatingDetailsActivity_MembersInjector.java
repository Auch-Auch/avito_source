package com.avito.android.rating.details;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.konveyor.ItemBinder;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class RatingDetailsActivity_MembersInjector implements MembersInjector<RatingDetailsActivity> {
    public final Provider<ResponsiveAdapterPresenter> a;
    public final Provider<ItemBinder> b;
    public final Provider<RatingDetailsPresenter> c;
    public final Provider<DeepLinkIntentFactory> d;
    public final Provider<Features> e;
    public final Provider<Analytics> f;
    public final Provider<ActivityIntentFactory> g;

    public RatingDetailsActivity_MembersInjector(Provider<ResponsiveAdapterPresenter> provider, Provider<ItemBinder> provider2, Provider<RatingDetailsPresenter> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<Features> provider5, Provider<Analytics> provider6, Provider<ActivityIntentFactory> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<RatingDetailsActivity> create(Provider<ResponsiveAdapterPresenter> provider, Provider<ItemBinder> provider2, Provider<RatingDetailsPresenter> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<Features> provider5, Provider<Analytics> provider6, Provider<ActivityIntentFactory> provider7) {
        return new RatingDetailsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.rating.details.RatingDetailsActivity.adapterPresenter")
    public static void injectAdapterPresenter(RatingDetailsActivity ratingDetailsActivity, ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        ratingDetailsActivity.adapterPresenter = responsiveAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.details.RatingDetailsActivity.analytics")
    public static void injectAnalytics(RatingDetailsActivity ratingDetailsActivity, Analytics analytics) {
        ratingDetailsActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.rating.details.RatingDetailsActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(RatingDetailsActivity ratingDetailsActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        ratingDetailsActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.details.RatingDetailsActivity.features")
    public static void injectFeatures(RatingDetailsActivity ratingDetailsActivity, Features features) {
        ratingDetailsActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.rating.details.RatingDetailsActivity.intentFactory")
    public static void injectIntentFactory(RatingDetailsActivity ratingDetailsActivity, ActivityIntentFactory activityIntentFactory) {
        ratingDetailsActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.details.RatingDetailsActivity.itemBinder")
    public static void injectItemBinder(RatingDetailsActivity ratingDetailsActivity, ItemBinder itemBinder) {
        ratingDetailsActivity.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.rating.details.RatingDetailsActivity.presenter")
    public static void injectPresenter(RatingDetailsActivity ratingDetailsActivity, RatingDetailsPresenter ratingDetailsPresenter) {
        ratingDetailsActivity.presenter = ratingDetailsPresenter;
    }

    public void injectMembers(RatingDetailsActivity ratingDetailsActivity) {
        injectAdapterPresenter(ratingDetailsActivity, this.a.get());
        injectItemBinder(ratingDetailsActivity, this.b.get());
        injectPresenter(ratingDetailsActivity, this.c.get());
        injectDeepLinkIntentFactory(ratingDetailsActivity, this.d.get());
        injectFeatures(ratingDetailsActivity, this.e.get());
        injectAnalytics(ratingDetailsActivity, this.f.get());
        injectIntentFactory(ratingDetailsActivity, this.g.get());
    }
}
