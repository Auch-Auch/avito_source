package com.avito.android.advert_core.contactbar;

import com.avito.android.Features;
import com.avito.android.ab_tests.configs.AntiFraudCheckListTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsNoCallFeedbackTestGroup;
import com.avito.android.ab_tests.groups.SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithControl2;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudPreferences;
import com.avito.android.advert_core.contactbar.feedback.FeedbackInteractor;
import com.avito.android.advert_core.feedback.FeedbackPreferences;
import com.avito.android.advert_core.job.AdvertJobInteractor;
import com.avito.android.advert_core.marketplace.MarketplacePresenter;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.calls_shared.AppCallsUsageTracker;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertContactsPresenterImpl_Factory implements Factory<AdvertContactsPresenterImpl> {
    public final Provider<AdvertJobInteractor> A;
    public final Provider<MarketplacePresenter> a;
    public final Provider<AdvertActionIconFactory> b;
    public final Provider<ProfileInfoStorage> c;
    public final Provider<AdvertMessengerInteractor> d;
    public final Provider<AdvertContactsInteractor> e;
    public final Provider<AdvertDetailsAnalyticsInteractor> f;
    public final Provider<FeedbackInteractor> g;
    public final Provider<AccountStateProvider> h;
    public final Provider<AdvertContactsResourceProvider> i;
    public final Provider<Formatter<AdvertPrice>> j;
    public final Provider<AntiFraudPreferences> k;
    public final Provider<FeedbackPreferences> l;
    public final Provider<Analytics> m;
    public final Provider<SchedulersFactory3> n;
    public final Provider<Features> o;
    public final Provider<SourceScreen> p;
    public final Provider<AbTestGroup<SimpleTestGroupWithControl2>> q;
    public final Provider<SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup>> r;
    public final Provider<Preferences> s;
    public final Provider<PermissionChecker> t;
    public final Provider<AppCallsUsageTracker> u;
    public final Provider<ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup>> v;
    public final Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup>> w;
    public final Provider<ExposedAbTestGroup<SimpleTestGroupWithNone>> x;
    public final Provider<AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup>> y;
    public final Provider<ExposedAbTestGroup<SimpleTestGroup>> z;

    public AdvertContactsPresenterImpl_Factory(Provider<MarketplacePresenter> provider, Provider<AdvertActionIconFactory> provider2, Provider<ProfileInfoStorage> provider3, Provider<AdvertMessengerInteractor> provider4, Provider<AdvertContactsInteractor> provider5, Provider<AdvertDetailsAnalyticsInteractor> provider6, Provider<FeedbackInteractor> provider7, Provider<AccountStateProvider> provider8, Provider<AdvertContactsResourceProvider> provider9, Provider<Formatter<AdvertPrice>> provider10, Provider<AntiFraudPreferences> provider11, Provider<FeedbackPreferences> provider12, Provider<Analytics> provider13, Provider<SchedulersFactory3> provider14, Provider<Features> provider15, Provider<SourceScreen> provider16, Provider<AbTestGroup<SimpleTestGroupWithControl2>> provider17, Provider<SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup>> provider18, Provider<Preferences> provider19, Provider<PermissionChecker> provider20, Provider<AppCallsUsageTracker> provider21, Provider<ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup>> provider22, Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup>> provider23, Provider<ExposedAbTestGroup<SimpleTestGroupWithNone>> provider24, Provider<AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup>> provider25, Provider<ExposedAbTestGroup<SimpleTestGroup>> provider26, Provider<AdvertJobInteractor> provider27) {
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
        this.k = provider11;
        this.l = provider12;
        this.m = provider13;
        this.n = provider14;
        this.o = provider15;
        this.p = provider16;
        this.q = provider17;
        this.r = provider18;
        this.s = provider19;
        this.t = provider20;
        this.u = provider21;
        this.v = provider22;
        this.w = provider23;
        this.x = provider24;
        this.y = provider25;
        this.z = provider26;
        this.A = provider27;
    }

    public static AdvertContactsPresenterImpl_Factory create(Provider<MarketplacePresenter> provider, Provider<AdvertActionIconFactory> provider2, Provider<ProfileInfoStorage> provider3, Provider<AdvertMessengerInteractor> provider4, Provider<AdvertContactsInteractor> provider5, Provider<AdvertDetailsAnalyticsInteractor> provider6, Provider<FeedbackInteractor> provider7, Provider<AccountStateProvider> provider8, Provider<AdvertContactsResourceProvider> provider9, Provider<Formatter<AdvertPrice>> provider10, Provider<AntiFraudPreferences> provider11, Provider<FeedbackPreferences> provider12, Provider<Analytics> provider13, Provider<SchedulersFactory3> provider14, Provider<Features> provider15, Provider<SourceScreen> provider16, Provider<AbTestGroup<SimpleTestGroupWithControl2>> provider17, Provider<SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup>> provider18, Provider<Preferences> provider19, Provider<PermissionChecker> provider20, Provider<AppCallsUsageTracker> provider21, Provider<ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup>> provider22, Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup>> provider23, Provider<ExposedAbTestGroup<SimpleTestGroupWithNone>> provider24, Provider<AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup>> provider25, Provider<ExposedAbTestGroup<SimpleTestGroup>> provider26, Provider<AdvertJobInteractor> provider27) {
        return new AdvertContactsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27);
    }

    public static AdvertContactsPresenterImpl newInstance(MarketplacePresenter marketplacePresenter, AdvertActionIconFactory advertActionIconFactory, ProfileInfoStorage profileInfoStorage, AdvertMessengerInteractor advertMessengerInteractor, AdvertContactsInteractor advertContactsInteractor, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, FeedbackInteractor feedbackInteractor, AccountStateProvider accountStateProvider, AdvertContactsResourceProvider advertContactsResourceProvider, Formatter<AdvertPrice> formatter, AntiFraudPreferences antiFraudPreferences, FeedbackPreferences feedbackPreferences, Analytics analytics, SchedulersFactory3 schedulersFactory3, Features features, SourceScreen sourceScreen, AbTestGroup<SimpleTestGroupWithControl2> abTestGroup, SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup> singleManuallyExposedAbTestGroup, Preferences preferences, PermissionChecker permissionChecker, AppCallsUsageTracker appCallsUsageTracker, ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup> manuallyExposedAbTestGroup, ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup> manuallyExposedAbTestGroup2, ExposedAbTestGroup<SimpleTestGroupWithNone> exposedAbTestGroup, AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup> abTestGroup2, ExposedAbTestGroup<SimpleTestGroup> exposedAbTestGroup2, AdvertJobInteractor advertJobInteractor) {
        return new AdvertContactsPresenterImpl(marketplacePresenter, advertActionIconFactory, profileInfoStorage, advertMessengerInteractor, advertContactsInteractor, advertDetailsAnalyticsInteractor, feedbackInteractor, accountStateProvider, advertContactsResourceProvider, formatter, antiFraudPreferences, feedbackPreferences, analytics, schedulersFactory3, features, sourceScreen, abTestGroup, singleManuallyExposedAbTestGroup, preferences, permissionChecker, appCallsUsageTracker, manuallyExposedAbTestGroup, manuallyExposedAbTestGroup2, exposedAbTestGroup, abTestGroup2, exposedAbTestGroup2, advertJobInteractor);
    }

    @Override // javax.inject.Provider
    public AdvertContactsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get(), this.u.get(), this.v.get(), this.w.get(), this.x.get(), this.y.get(), this.z.get(), this.A.get());
    }
}
