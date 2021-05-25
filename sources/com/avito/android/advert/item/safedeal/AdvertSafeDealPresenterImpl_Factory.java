package com.avito.android.advert.item.safedeal;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.contactbar.feedback.FeedbackInteractor;
import com.avito.android.advert_core.feedback.FeedbackPreferences;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertSafeDealPresenterImpl_Factory implements Factory<AdvertSafeDealPresenterImpl> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<AccountStateProvider> c;
    public final Provider<AdvertDetailsAnalyticsInteractor> d;
    public final Provider<FeedbackInteractor> e;
    public final Provider<Analytics> f;
    public final Provider<Features> g;
    public final Provider<ClickStreamLinkHandler> h;
    public final Provider<FeedbackPreferences> i;
    public final Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup>> j;

    public AdvertSafeDealPresenterImpl_Factory(Provider<String> provider, Provider<String> provider2, Provider<AccountStateProvider> provider3, Provider<AdvertDetailsAnalyticsInteractor> provider4, Provider<FeedbackInteractor> provider5, Provider<Analytics> provider6, Provider<Features> provider7, Provider<ClickStreamLinkHandler> provider8, Provider<FeedbackPreferences> provider9, Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup>> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static AdvertSafeDealPresenterImpl_Factory create(Provider<String> provider, Provider<String> provider2, Provider<AccountStateProvider> provider3, Provider<AdvertDetailsAnalyticsInteractor> provider4, Provider<FeedbackInteractor> provider5, Provider<Analytics> provider6, Provider<Features> provider7, Provider<ClickStreamLinkHandler> provider8, Provider<FeedbackPreferences> provider9, Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup>> provider10) {
        return new AdvertSafeDealPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static AdvertSafeDealPresenterImpl newInstance(String str, String str2, AccountStateProvider accountStateProvider, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, FeedbackInteractor feedbackInteractor, Analytics analytics, Features features, ClickStreamLinkHandler clickStreamLinkHandler, FeedbackPreferences feedbackPreferences, ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup> manuallyExposedAbTestGroup) {
        return new AdvertSafeDealPresenterImpl(str, str2, accountStateProvider, advertDetailsAnalyticsInteractor, feedbackInteractor, analytics, features, clickStreamLinkHandler, feedbackPreferences, manuallyExposedAbTestGroup);
    }

    @Override // javax.inject.Provider
    public AdvertSafeDealPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
