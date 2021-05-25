package com.avito.android.photo_gallery.di;

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
import com.avito.android.advert_core.contactbar.AdvertActionIconFactory;
import com.avito.android.advert_core.contactbar.AdvertContactsInteractor;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.contactbar.AdvertContactsResourceProvider;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudPreferences;
import com.avito.android.advert_core.contactbar.feedback.FeedbackInteractor;
import com.avito.android.advert_core.feedback.FeedbackPreferences;
import com.avito.android.advert_core.job.AdvertJobInteractor;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.calls_shared.AppCallsUsageTracker;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LegacyPhotoGalleryModule_ProvideAdvertContactsPresenterFactory implements Factory<AdvertContactsPresenter> {
    public final Provider<Features> a;
    public final Provider<Analytics> b;
    public final Provider<ProfileInfoStorage> c;
    public final Provider<AdvertDetailsAnalyticsInteractor> d;
    public final Provider<AdvertContactsInteractor> e;
    public final Provider<AdvertMessengerInteractor> f;
    public final Provider<FeedbackInteractor> g;
    public final Provider<AdvertActionIconFactory> h;
    public final Provider<AccountStateProvider> i;
    public final Provider<Formatter<AdvertPrice>> j;
    public final Provider<AntiFraudPreferences> k;
    public final Provider<FeedbackPreferences> l;
    public final Provider<SchedulersFactory3> m;
    public final Provider<AbTestGroup<SimpleTestGroupWithControl2>> n;
    public final Provider<SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup>> o;
    public final Provider<ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup>> p;
    public final Provider<ExposedAbTestGroup<SimpleTestGroupWithNone>> q;
    public final Provider<AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup>> r;
    public final Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup>> s;
    public final Provider<ExposedAbTestGroup<SimpleTestGroup>> t;
    public final Provider<AppCallsUsageTracker> u;
    public final Provider<AdvertContactsResourceProvider> v;
    public final Provider<PermissionChecker> w;
    public final Provider<AdvertJobInteractor> x;

    public LegacyPhotoGalleryModule_ProvideAdvertContactsPresenterFactory(Provider<Features> provider, Provider<Analytics> provider2, Provider<ProfileInfoStorage> provider3, Provider<AdvertDetailsAnalyticsInteractor> provider4, Provider<AdvertContactsInteractor> provider5, Provider<AdvertMessengerInteractor> provider6, Provider<FeedbackInteractor> provider7, Provider<AdvertActionIconFactory> provider8, Provider<AccountStateProvider> provider9, Provider<Formatter<AdvertPrice>> provider10, Provider<AntiFraudPreferences> provider11, Provider<FeedbackPreferences> provider12, Provider<SchedulersFactory3> provider13, Provider<AbTestGroup<SimpleTestGroupWithControl2>> provider14, Provider<SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup>> provider15, Provider<ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup>> provider16, Provider<ExposedAbTestGroup<SimpleTestGroupWithNone>> provider17, Provider<AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup>> provider18, Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup>> provider19, Provider<ExposedAbTestGroup<SimpleTestGroup>> provider20, Provider<AppCallsUsageTracker> provider21, Provider<AdvertContactsResourceProvider> provider22, Provider<PermissionChecker> provider23, Provider<AdvertJobInteractor> provider24) {
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
    }

    public static LegacyPhotoGalleryModule_ProvideAdvertContactsPresenterFactory create(Provider<Features> provider, Provider<Analytics> provider2, Provider<ProfileInfoStorage> provider3, Provider<AdvertDetailsAnalyticsInteractor> provider4, Provider<AdvertContactsInteractor> provider5, Provider<AdvertMessengerInteractor> provider6, Provider<FeedbackInteractor> provider7, Provider<AdvertActionIconFactory> provider8, Provider<AccountStateProvider> provider9, Provider<Formatter<AdvertPrice>> provider10, Provider<AntiFraudPreferences> provider11, Provider<FeedbackPreferences> provider12, Provider<SchedulersFactory3> provider13, Provider<AbTestGroup<SimpleTestGroupWithControl2>> provider14, Provider<SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup>> provider15, Provider<ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup>> provider16, Provider<ExposedAbTestGroup<SimpleTestGroupWithNone>> provider17, Provider<AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup>> provider18, Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup>> provider19, Provider<ExposedAbTestGroup<SimpleTestGroup>> provider20, Provider<AppCallsUsageTracker> provider21, Provider<AdvertContactsResourceProvider> provider22, Provider<PermissionChecker> provider23, Provider<AdvertJobInteractor> provider24) {
        return new LegacyPhotoGalleryModule_ProvideAdvertContactsPresenterFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24);
    }

    public static AdvertContactsPresenter provideAdvertContactsPresenter(Features features, Analytics analytics, ProfileInfoStorage profileInfoStorage, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, AdvertContactsInteractor advertContactsInteractor, AdvertMessengerInteractor advertMessengerInteractor, FeedbackInteractor feedbackInteractor, AdvertActionIconFactory advertActionIconFactory, AccountStateProvider accountStateProvider, Formatter<AdvertPrice> formatter, AntiFraudPreferences antiFraudPreferences, FeedbackPreferences feedbackPreferences, SchedulersFactory3 schedulersFactory3, AbTestGroup<SimpleTestGroupWithControl2> abTestGroup, SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup> singleManuallyExposedAbTestGroup, ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup> manuallyExposedAbTestGroup, ExposedAbTestGroup<SimpleTestGroupWithNone> exposedAbTestGroup, AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup> abTestGroup2, ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup> manuallyExposedAbTestGroup2, ExposedAbTestGroup<SimpleTestGroup> exposedAbTestGroup2, AppCallsUsageTracker appCallsUsageTracker, AdvertContactsResourceProvider advertContactsResourceProvider, PermissionChecker permissionChecker, AdvertJobInteractor advertJobInteractor) {
        return (AdvertContactsPresenter) Preconditions.checkNotNullFromProvides(LegacyPhotoGalleryModule.INSTANCE.provideAdvertContactsPresenter(features, analytics, profileInfoStorage, advertDetailsAnalyticsInteractor, advertContactsInteractor, advertMessengerInteractor, feedbackInteractor, advertActionIconFactory, accountStateProvider, formatter, antiFraudPreferences, feedbackPreferences, schedulersFactory3, abTestGroup, singleManuallyExposedAbTestGroup, manuallyExposedAbTestGroup, exposedAbTestGroup, abTestGroup2, manuallyExposedAbTestGroup2, exposedAbTestGroup2, appCallsUsageTracker, advertContactsResourceProvider, permissionChecker, advertJobInteractor));
    }

    @Override // javax.inject.Provider
    public AdvertContactsPresenter get() {
        return provideAdvertContactsPresenter(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get(), this.u.get(), this.v.get(), this.w.get(), this.x.get());
    }
}
