package com.avito.android.feedback_adverts;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class FeedbackAdvertsActivity_MembersInjector implements MembersInjector<FeedbackAdvertsActivity> {
    public final Provider<FeedbackAdvertsPresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;
    public final Provider<Analytics> d;
    public final Provider<Features> e;
    public final Provider<ActivityIntentFactory> f;

    public FeedbackAdvertsActivity_MembersInjector(Provider<FeedbackAdvertsPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<Analytics> provider4, Provider<Features> provider5, Provider<ActivityIntentFactory> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<FeedbackAdvertsActivity> create(Provider<FeedbackAdvertsPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<Analytics> provider4, Provider<Features> provider5, Provider<ActivityIntentFactory> provider6) {
        return new FeedbackAdvertsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.feedback_adverts.FeedbackAdvertsActivity.activityIntentFactory")
    public static void injectActivityIntentFactory(FeedbackAdvertsActivity feedbackAdvertsActivity, ActivityIntentFactory activityIntentFactory) {
        feedbackAdvertsActivity.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.feedback_adverts.FeedbackAdvertsActivity.adapterPresenter")
    public static void injectAdapterPresenter(FeedbackAdvertsActivity feedbackAdvertsActivity, AdapterPresenter adapterPresenter) {
        feedbackAdvertsActivity.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.feedback_adverts.FeedbackAdvertsActivity.analytics")
    public static void injectAnalytics(FeedbackAdvertsActivity feedbackAdvertsActivity, Analytics analytics) {
        feedbackAdvertsActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.feedback_adverts.FeedbackAdvertsActivity.features")
    public static void injectFeatures(FeedbackAdvertsActivity feedbackAdvertsActivity, Features features) {
        feedbackAdvertsActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.feedback_adverts.FeedbackAdvertsActivity.itemBinder")
    public static void injectItemBinder(FeedbackAdvertsActivity feedbackAdvertsActivity, ItemBinder itemBinder) {
        feedbackAdvertsActivity.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.feedback_adverts.FeedbackAdvertsActivity.presenter")
    public static void injectPresenter(FeedbackAdvertsActivity feedbackAdvertsActivity, FeedbackAdvertsPresenter feedbackAdvertsPresenter) {
        feedbackAdvertsActivity.presenter = feedbackAdvertsPresenter;
    }

    public void injectMembers(FeedbackAdvertsActivity feedbackAdvertsActivity) {
        injectPresenter(feedbackAdvertsActivity, this.a.get());
        injectAdapterPresenter(feedbackAdvertsActivity, this.b.get());
        injectItemBinder(feedbackAdvertsActivity, this.c.get());
        injectAnalytics(feedbackAdvertsActivity, this.d.get());
        injectFeatures(feedbackAdvertsActivity, this.e.get());
        injectActivityIntentFactory(feedbackAdvertsActivity, this.f.get());
    }
}
