package com.avito.android.photo_gallery.di;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
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
import com.avito.android.advert_core.contactbar.AdvertContactsInteractorImpl;
import com.avito.android.advert_core.contactbar.AdvertContactsInteractorImpl_Factory;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.contactbar.AdvertContactsResourceProvider;
import com.avito.android.advert_core.contactbar.AdvertContactsResourceProviderImpl;
import com.avito.android.advert_core.contactbar.AdvertContactsResourceProviderImpl_Factory;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudPreferences;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudPreferencesImpl;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudPreferencesImpl_Factory;
import com.avito.android.advert_core.contactbar.feedback.FeedbackInteractor;
import com.avito.android.advert_core.feedback.FeedbackPreferences;
import com.avito.android.advert_core.feedback.FeedbackPreferencesImpl;
import com.avito.android.advert_core.feedback.FeedbackPreferencesImpl_Factory;
import com.avito.android.advert_core.job.AdvertJobInteractor;
import com.avito.android.advert_core.job.AdvertJobInteractorImpl;
import com.avito.android.advert_core.job.AdvertJobInteractorImpl_Factory;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractor;
import com.avito.android.advert_core.teaser.TeaserObserver;
import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.AppCallsUsageTracker;
import com.avito.android.calls_shared.CallUuidProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.job.JobApi;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.photo_gallery.LegacyPhotoGalleryActivity;
import com.avito.android.photo_gallery.LegacyPhotoGalleryActivity_MembersInjector;
import com.avito.android.photo_gallery.di.LegacyPhotoGalleryActivityComponent;
import com.avito.android.photo_gallery.tracker.PhotoGalleryTracker;
import com.avito.android.photo_gallery.tracker.PhotoGalleryTrackerImpl;
import com.avito.android.photo_gallery.tracker.PhotoGalleryTrackerImpl_Factory;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.AsyncPhoneApi;
import com.avito.android.serp.CommercialBannerTimeProviderImpl_Factory;
import com.avito.android.serp.CommercialBannersAnalyticsInteractorImpl;
import com.avito.android.serp.CommercialBannersAnalyticsInteractorImpl_Factory;
import com.avito.android.serp.analytics.BannerPageSource;
import com.avito.android.util.AdvertPriceFormatter;
import com.avito.android.util.AdvertPriceFormatter_Factory;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Formatter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Locale;
import javax.inject.Provider;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DaggerLegacyPhotoGalleryActivityComponent implements LegacyPhotoGalleryActivityComponent {
    public Provider<Preferences> A;
    public Provider<AntiFraudPreferencesImpl> B;
    public Provider<AntiFraudPreferences> C;
    public Provider<FeedbackPreferencesImpl> D;
    public Provider<FeedbackPreferences> E;
    public Provider<AbTestGroup<SimpleTestGroupWithControl2>> F;
    public Provider<SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup>> G;
    public Provider<ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup>> H;
    public Provider<ExposedAbTestGroup<SimpleTestGroupWithNone>> I;
    public Provider<AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup>> J;
    public Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup>> K;
    public Provider<ExposedAbTestGroup<SimpleTestGroup>> L;
    public Provider<Resources> M;
    public Provider<AdvertContactsResourceProviderImpl> N;
    public Provider<AdvertContactsResourceProvider> O;
    public Provider<PermissionChecker> P;
    public Provider<JobApi> Q;
    public Provider<AdvertJobInteractorImpl> R;
    public Provider<AdvertJobInteractor> S;
    public Provider<AdvertContactsPresenter> T;
    public Provider<Formatter<String>> U = DoubleCheck.provider(LegacyPhotoGalleryModule_ProvidePhoneNumberFormatterProviderFactory.create(PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create()));
    public Provider<Formatter<Throwable>> V = DoubleCheck.provider(LegacyPhotoGalleryModule_ProvideThrowableFormatter$photo_gallery_releaseFactory.create(this.M));
    public Provider<ScreenTrackerFactory> W;
    public Provider<TimerFactory> X;
    public Provider<ScreenDiInjectTracker> Y;
    public Provider<ScreenInitTracker> Z;
    public final PhotoGalleryDependencies a;
    public Provider<PhotoGalleryTrackerImpl> a0;
    public Provider<Features> b;
    public Provider<PhotoGalleryTracker> b0;
    public Provider<Analytics> c;
    public Provider<Activity> c0;
    public Provider<ProfileInfoStorage> d;
    public Provider<DialogRouter> d0;
    public Provider<BannerPageSource> e;
    public Provider<TreeClickStreamParent> f;
    public Provider<TreeStateIdGenerator> g;
    public Provider<CommercialBannersAnalyticsInteractorImpl> h;
    public Provider<AccountStateProvider> i;
    public Provider<AdvertDetailsAnalyticsInteractor> j;
    public Provider<AsyncPhoneApi> k;
    public Provider<CallsApi> l;
    public Provider<NetworkTypeProvider> m;
    public Provider<CallUuidProvider> n;
    public Provider<AppCallsUsageTracker> o;
    public Provider<SchedulersFactory3> p;
    public Provider<AdvertContactsInteractorImpl> q;
    public Provider<AdvertContactsInteractor> r;
    public Provider<AvitoMessengerApi> s;
    public Provider<AdvertMessengerInteractor> t;
    public Provider<AdvertDetailsApi> u;
    public Provider<FeedbackInteractor> v;
    public Provider<Application> w;
    public Provider<AdvertActionIconFactory> x;
    public Provider<Locale> y;
    public Provider<AdvertPriceFormatter> z;

    public static class a0 implements Provider<AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup>> {
        public final PhotoGalleryDependencies a;

        public a0(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup> get() {
            return (AbTestGroup) Preconditions.checkNotNullFromComponent(this.a.sendEmployersPhoneOnCallToSellerButtonClickInResumes());
        }
    }

    public static final class b implements LegacyPhotoGalleryActivityComponent.Builder {
        public Activity a;
        public Resources b;
        public TreeClickStreamParent c;
        public BannerPageSource d;
        public PhotoGalleryDependencies e;

        public b(a aVar) {
        }

        @Override // com.avito.android.photo_gallery.di.LegacyPhotoGalleryActivityComponent.Builder
        public LegacyPhotoGalleryActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Activity.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.d, BannerPageSource.class);
            Preconditions.checkBuilderRequirement(this.e, PhotoGalleryDependencies.class);
            return new DaggerLegacyPhotoGalleryActivityComponent(this.e, this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.photo_gallery.di.LegacyPhotoGalleryActivityComponent.Builder
        public LegacyPhotoGalleryActivityComponent.Builder photoGalleryDependencies(PhotoGalleryDependencies photoGalleryDependencies) {
            this.e = (PhotoGalleryDependencies) Preconditions.checkNotNull(photoGalleryDependencies);
            return this;
        }

        @Override // com.avito.android.photo_gallery.di.LegacyPhotoGalleryActivityComponent.Builder
        public LegacyPhotoGalleryActivityComponent.Builder with(Activity activity) {
            this.a = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.photo_gallery.di.LegacyPhotoGalleryActivityComponent.Builder
        public LegacyPhotoGalleryActivityComponent.Builder withBannerPageSource(BannerPageSource bannerPageSource) {
            this.d = (BannerPageSource) Preconditions.checkNotNull(bannerPageSource);
            return this;
        }

        @Override // com.avito.android.photo_gallery.di.LegacyPhotoGalleryActivityComponent.Builder
        public LegacyPhotoGalleryActivityComponent.Builder with(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.photo_gallery.di.LegacyPhotoGalleryActivityComponent.Builder
        public LegacyPhotoGalleryActivityComponent.Builder with(TreeClickStreamParent treeClickStreamParent) {
            this.c = treeClickStreamParent;
            return this;
        }
    }

    public static class b0 implements Provider<TimerFactory> {
        public final PhotoGalleryDependencies a;

        public b0(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final PhotoGalleryDependencies a;

        public c(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class c0 implements Provider<TreeStateIdGenerator> {
        public final PhotoGalleryDependencies a;

        public c0(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TreeStateIdGenerator get() {
            return (TreeStateIdGenerator) Preconditions.checkNotNullFromComponent(this.a.treeStateIdGenerator());
        }
    }

    public static class d implements Provider<ExposedAbTestGroup<SimpleTestGroupWithNone>> {
        public final PhotoGalleryDependencies a;

        public d(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<SimpleTestGroupWithNone> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.advertContactApplyWithoutChatTestGroup());
        }
    }

    public static class e implements Provider<AdvertDetailsApi> {
        public final PhotoGalleryDependencies a;

        public e(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AdvertDetailsApi get() {
            return (AdvertDetailsApi) Preconditions.checkNotNullFromComponent(this.a.advertDetailsApi());
        }
    }

    public static class f implements Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup>> {
        public final PhotoGalleryDependencies a;

        public f(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup> get() {
            return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.advertDetailsMarketplaceNoPurchaseFeedbackTestGroup());
        }
    }

    public static class g implements Provider<ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup>> {
        public final PhotoGalleryDependencies a;

        public g(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup> get() {
            return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.advertDetailsNoCallFeedbackTestGroup());
        }
    }

    public static class h implements Provider<Analytics> {
        public final PhotoGalleryDependencies a;

        public h(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class i implements Provider<SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup>> {
        public final PhotoGalleryDependencies a;

        public i(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup> get() {
            return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.antiFraudCheckListTest());
        }
    }

    public static class j implements Provider<AppCallsUsageTracker> {
        public final PhotoGalleryDependencies a;

        public j(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AppCallsUsageTracker get() {
            return (AppCallsUsageTracker) Preconditions.checkNotNullFromComponent(this.a.appCallUsageTracker());
        }
    }

    public static class k implements Provider<Application> {
        public final PhotoGalleryDependencies a;

        public k(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class l implements Provider<AsyncPhoneApi> {
        public final PhotoGalleryDependencies a;

        public l(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AsyncPhoneApi get() {
            return (AsyncPhoneApi) Preconditions.checkNotNullFromComponent(this.a.asyncPhoneApi());
        }
    }

    public static class m implements Provider<AvitoMessengerApi> {
        public final PhotoGalleryDependencies a;

        public m(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AvitoMessengerApi get() {
            return (AvitoMessengerApi) Preconditions.checkNotNullFromComponent(this.a.avitoMessengerApi());
        }
    }

    public static class n implements Provider<CallUuidProvider> {
        public final PhotoGalleryDependencies a;

        public n(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CallUuidProvider get() {
            return (CallUuidProvider) Preconditions.checkNotNullFromComponent(this.a.callUuidProvider());
        }
    }

    public static class o implements Provider<CallsApi> {
        public final PhotoGalleryDependencies a;

        public o(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CallsApi get() {
            return (CallsApi) Preconditions.checkNotNullFromComponent(this.a.callsApi());
        }
    }

    public static class p implements Provider<Features> {
        public final PhotoGalleryDependencies a;

        public p(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class q implements Provider<JobApi> {
        public final PhotoGalleryDependencies a;

        public q(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public JobApi get() {
            return (JobApi) Preconditions.checkNotNullFromComponent(this.a.jobApi());
        }
    }

    public static class r implements Provider<ExposedAbTestGroup<SimpleTestGroup>> {
        public final PhotoGalleryDependencies a;

        public r(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<SimpleTestGroup> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.jobApplicationProgressBarTestGroup());
        }
    }

    public static class s implements Provider<AbTestGroup<SimpleTestGroupWithControl2>> {
        public final PhotoGalleryDependencies a;

        public s(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AbTestGroup<SimpleTestGroupWithControl2> get() {
            return (AbTestGroup) Preconditions.checkNotNullFromComponent(this.a.justDialSellerPhoneTestGroup());
        }
    }

    public static class t implements Provider<Locale> {
        public final PhotoGalleryDependencies a;

        public t(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class u implements Provider<NetworkTypeProvider> {
        public final PhotoGalleryDependencies a;

        public u(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NetworkTypeProvider get() {
            return (NetworkTypeProvider) Preconditions.checkNotNullFromComponent(this.a.networkTypeProvider());
        }
    }

    public static class v implements Provider<PermissionChecker> {
        public final PhotoGalleryDependencies a;

        public v(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PermissionChecker get() {
            return (PermissionChecker) Preconditions.checkNotNullFromComponent(this.a.permissionChecker());
        }
    }

    public static class w implements Provider<Preferences> {
        public final PhotoGalleryDependencies a;

        public w(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Preferences get() {
            return (Preferences) Preconditions.checkNotNullFromComponent(this.a.preferences());
        }
    }

    public static class x implements Provider<ProfileInfoStorage> {
        public final PhotoGalleryDependencies a;

        public x(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileInfoStorage get() {
            return (ProfileInfoStorage) Preconditions.checkNotNullFromComponent(this.a.profileInfoStorage());
        }
    }

    public static class y implements Provider<SchedulersFactory3> {
        public final PhotoGalleryDependencies a;

        public y(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class z implements Provider<ScreenTrackerFactory> {
        public final PhotoGalleryDependencies a;

        public z(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = photoGalleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public DaggerLegacyPhotoGalleryActivityComponent(PhotoGalleryDependencies photoGalleryDependencies, Activity activity, Resources resources, TreeClickStreamParent treeClickStreamParent, BannerPageSource bannerPageSource, a aVar) {
        this.a = photoGalleryDependencies;
        this.b = new p(photoGalleryDependencies);
        this.c = new h(photoGalleryDependencies);
        this.d = new x(photoGalleryDependencies);
        this.e = InstanceFactory.create(bannerPageSource);
        Factory createNullable = InstanceFactory.createNullable(treeClickStreamParent);
        this.f = createNullable;
        c0 c0Var = new c0(photoGalleryDependencies);
        this.g = c0Var;
        CommercialBannersAnalyticsInteractorImpl_Factory create = CommercialBannersAnalyticsInteractorImpl_Factory.create(this.e, this.c, createNullable, c0Var, CommercialBannerTimeProviderImpl_Factory.create());
        this.h = create;
        c cVar = new c(photoGalleryDependencies);
        this.i = cVar;
        this.j = DoubleCheck.provider(LegacyPhotoGalleryModule_ProvideAdvertDetailsAnalyticsInteractor$photo_gallery_releaseFactory.create(this.c, create, cVar, this.g, this.f, this.b));
        l lVar = new l(photoGalleryDependencies);
        this.k = lVar;
        o oVar = new o(photoGalleryDependencies);
        this.l = oVar;
        u uVar = new u(photoGalleryDependencies);
        this.m = uVar;
        this.n = new n(photoGalleryDependencies);
        this.o = new j(photoGalleryDependencies);
        this.p = new y(photoGalleryDependencies);
        AdvertContactsInteractorImpl_Factory create2 = AdvertContactsInteractorImpl_Factory.create(lVar, oVar, uVar, this.i, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create(), this.n, this.o, this.b, this.p);
        this.q = create2;
        this.r = DoubleCheck.provider(create2);
        m mVar = new m(photoGalleryDependencies);
        this.s = mVar;
        this.t = DoubleCheck.provider(LegacyPhotoGalleryModule_ProvideAdvertMessengerInteractor$photo_gallery_releaseFactory.create(mVar, this.i, this.p));
        e eVar = new e(photoGalleryDependencies);
        this.u = eVar;
        this.v = DoubleCheck.provider(LegacyPhotoGalleryModule_ProvideNoCallFeedbackInteractor$photo_gallery_releaseFactory.create(eVar, this.p));
        k kVar = new k(photoGalleryDependencies);
        this.w = kVar;
        this.x = DoubleCheck.provider(LegacyPhotoGalleryModule_ProvideAdvertActionIconFactoryFactory.create(kVar));
        t tVar = new t(photoGalleryDependencies);
        this.y = tVar;
        this.z = AdvertPriceFormatter_Factory.create(tVar);
        w wVar = new w(photoGalleryDependencies);
        this.A = wVar;
        AntiFraudPreferencesImpl_Factory create3 = AntiFraudPreferencesImpl_Factory.create(wVar);
        this.B = create3;
        this.C = DoubleCheck.provider(create3);
        FeedbackPreferencesImpl_Factory create4 = FeedbackPreferencesImpl_Factory.create(this.A);
        this.D = create4;
        this.E = DoubleCheck.provider(create4);
        this.F = new s(photoGalleryDependencies);
        this.G = new i(photoGalleryDependencies);
        this.H = new g(photoGalleryDependencies);
        this.I = new d(photoGalleryDependencies);
        this.J = new a0(photoGalleryDependencies);
        this.K = new f(photoGalleryDependencies);
        this.L = new r(photoGalleryDependencies);
        Factory create5 = InstanceFactory.create(resources);
        this.M = create5;
        AdvertContactsResourceProviderImpl_Factory create6 = AdvertContactsResourceProviderImpl_Factory.create(create5);
        this.N = create6;
        this.O = DoubleCheck.provider(create6);
        this.P = new v(photoGalleryDependencies);
        q qVar = new q(photoGalleryDependencies);
        this.Q = qVar;
        AdvertJobInteractorImpl_Factory create7 = AdvertJobInteractorImpl_Factory.create(qVar);
        this.R = create7;
        Provider<AdvertJobInteractor> provider = DoubleCheck.provider(create7);
        this.S = provider;
        this.T = DoubleCheck.provider(LegacyPhotoGalleryModule_ProvideAdvertContactsPresenterFactory.create(this.b, this.c, this.d, this.j, this.r, this.t, this.v, this.x, this.i, this.z, this.C, this.E, this.p, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.o, this.O, this.P, provider));
        z zVar = new z(photoGalleryDependencies);
        this.W = zVar;
        b0 b0Var = new b0(photoGalleryDependencies);
        this.X = b0Var;
        this.Y = DoubleCheck.provider(LegacyPhotoTrackerModule_ProvideScreenDiInjectTracker$photo_gallery_releaseFactory.create(zVar, b0Var));
        Provider<ScreenInitTracker> provider2 = DoubleCheck.provider(LegacyPhotoTrackerModule_ProvideScreenInitTrackerFactory.create(this.W, this.X));
        this.Z = provider2;
        PhotoGalleryTrackerImpl_Factory create8 = PhotoGalleryTrackerImpl_Factory.create(this.Y, provider2);
        this.a0 = create8;
        this.b0 = DoubleCheck.provider(create8);
        Factory create9 = InstanceFactory.create(activity);
        this.c0 = create9;
        this.d0 = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create9));
    }

    public static LegacyPhotoGalleryActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.photo_gallery.di.LegacyPhotoGalleryActivityComponent
    public void inject(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity) {
        LegacyPhotoGalleryActivity_MembersInjector.injectImplicitIntentFactory(legacyPhotoGalleryActivity, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        LegacyPhotoGalleryActivity_MembersInjector.injectDeepLinkIntentFactory(legacyPhotoGalleryActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        LegacyPhotoGalleryActivity_MembersInjector.injectActivityIntentFactory(legacyPhotoGalleryActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        LegacyPhotoGalleryActivity_MembersInjector.injectFeatures(legacyPhotoGalleryActivity, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        LegacyPhotoGalleryActivity_MembersInjector.injectAnalytics(legacyPhotoGalleryActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        LegacyPhotoGalleryActivity_MembersInjector.injectAdvertContactsPresenter(legacyPhotoGalleryActivity, this.T.get());
        LegacyPhotoGalleryActivity_MembersInjector.injectPhoneNumberFormatter(legacyPhotoGalleryActivity, this.U.get());
        LegacyPhotoGalleryActivity_MembersInjector.injectErrorFormatter(legacyPhotoGalleryActivity, this.V.get());
        LegacyPhotoGalleryActivity_MembersInjector.injectTracker(legacyPhotoGalleryActivity, this.b0.get());
        LegacyPhotoGalleryActivity_MembersInjector.injectDialogRouter(legacyPhotoGalleryActivity, this.d0.get());
        LegacyPhotoGalleryActivity_MembersInjector.injectTeaserObserver(legacyPhotoGalleryActivity, (TeaserObserver) Preconditions.checkNotNullFromComponent(this.a.teaserObserver()));
    }
}
