package com.avito.android.publish.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.CurrentUserIdProvider;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.html_editor.EditorHistoryProvider;
import com.avito.android.html_editor.PrefEditorHistoryProvider;
import com.avito.android.html_editor.di.EditorHistoryModule;
import com.avito.android.html_editor.di.EditorHistoryModule_ProvideEditorPreferencesFactory;
import com.avito.android.html_editor.di.EditorHistoryModule_ProvideEditorSerializerFactory;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.photo_picker.legacy.DraftIdProvider;
import com.avito.android.progress_overlay.ProgressDialogRouter;
import com.avito.android.publish.ProfileSourceInteractor;
import com.avito.android.publish.PublishActivity;
import com.avito.android.publish.PublishActivity_MembersInjector;
import com.avito.android.publish.PublishViewModelFactory;
import com.avito.android.publish.SubmissionPresenter;
import com.avito.android.publish.analytics.PhotoPickerOnPublishEventTracker;
import com.avito.android.publish.analytics.PublishContactsTracker;
import com.avito.android.publish.analytics.PublishContactsTrackerImpl;
import com.avito.android.publish.analytics.PublishContactsTrackerImpl_Factory;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.analytics.PublishEventTrackerImpl;
import com.avito.android.publish.analytics.PublishEventTrackerImpl_Factory;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.draft_onboarding.DraftOnboardingInteractor;
import com.avito.android.publish.draft_onboarding.DraftOnboardingInteractorImpl;
import com.avito.android.publish.draft_onboarding.DraftOnboardingInteractorImpl_Factory;
import com.avito.android.publish.draft_onboarding.DraftOnboardingResourceProvider;
import com.avito.android.publish.draft_onboarding.DraftOnboardingResourceProviderImpl;
import com.avito.android.publish.draft_onboarding.DraftOnboardingResourceProviderImpl_Factory;
import com.avito.android.publish.draft_onboarding.DraftOnboardingSessionStorage;
import com.avito.android.publish.drafts.PublishDraftDataHolder;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.publish.drafts.PublishMessageHandler;
import com.avito.android.publish.drafts.analytics.PublishDraftEventTracker;
import com.avito.android.publish.drafts.analytics.PublishSessionIdGenerator;
import com.avito.android.publish.drafts.di.PublishDraftActivityModule;
import com.avito.android.publish.drafts.di.PublishDraftActivityModule_ProvideSubcategoryTitleHolderForDraftFactory;
import com.avito.android.publish.drafts.di.PublishDraftsAnalyticsModule_ProvidePublishEventTrackerFactory;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.category_parameters.AttributesTreeConverter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import com.avito.android.validate_advert.remote.ValidateAdvertApi;
import com.google.gson.Gson;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerPublishComponent implements PublishComponent {
    public Provider<ScreenFlowTrackerProvider> A;
    public Provider<PublishContactsTrackerImpl> B;
    public Provider<PublishContactsTracker> C;
    public Provider<ProfileSourceInteractor> D;
    public Provider<DraftOnboardingSessionStorage> E;
    public Provider<Resources> F;
    public Provider<DraftOnboardingResourceProviderImpl> G;
    public Provider<DraftOnboardingResourceProvider> H;
    public Provider<DraftOnboardingInteractorImpl> I;
    public Provider<DraftOnboardingInteractor> J;
    public Provider<PublishViewModelFactory> K;
    public final PublishDependencies a;
    public final LocationDependencies b;
    public final EditorHistoryModule c;
    public Provider<CategoryParametersConverter> d;
    public Provider<Activity> e;
    public Provider<DialogRouter> f;
    public Provider<FragmentActivity> g;
    public Provider<ProgressDialogRouter> h;
    public Provider<Analytics> i;
    public Provider<PublishAnalyticsDataProvider> j;
    public Provider<CurrentUserIdProvider> k;
    public Provider<PublishEventTrackerImpl> l;
    public Provider<SchedulersFactory> m;
    public Provider<PublishDraftRepository> n;
    public Provider<DraftIdProvider> o;
    public Provider<PublishDraftDataHolder> p;
    public Provider<PublishDraftWiper> q;
    public Provider<BuildInfo> r;
    public Provider<Gson> s;
    public Provider<PublishMessageHandler> t;
    public Provider<SubmissionPresenter> u;
    public Provider<ProfileApi> v;
    public Provider<ScreenTrackerFactory> w;
    public Provider<TimerFactory> x;
    public Provider<ScreenDiInjectTracker> y;
    public Provider<ScreenInitTracker> z;

    public static final class b implements PublishComponent.Builder {
        public PublishDependencies a;
        public LocationDependencies b;
        public PublishModule c;
        public Resources d;
        public Activity e;
        public FragmentActivity f;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.di.PublishComponent.Builder
        public PublishComponent.Builder activity(Activity activity) {
            this.e = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.publish.di.PublishComponent.Builder
        public PublishComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PublishDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, LocationDependencies.class);
            if (this.c == null) {
                this.c = new PublishModule();
            }
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, Activity.class);
            Preconditions.checkBuilderRequirement(this.f, FragmentActivity.class);
            return new DaggerPublishComponent(this.c, new PublishDraftActivityModule(), new EditorHistoryModule(), this.a, this.b, this.d, this.e, this.f, null);
        }

        @Override // com.avito.android.publish.di.PublishComponent.Builder
        public PublishComponent.Builder fragmentActivity(FragmentActivity fragmentActivity) {
            this.f = (FragmentActivity) Preconditions.checkNotNull(fragmentActivity);
            return this;
        }

        @Override // com.avito.android.publish.di.PublishComponent.Builder
        public PublishComponent.Builder locationDependencies(LocationDependencies locationDependencies) {
            this.b = (LocationDependencies) Preconditions.checkNotNull(locationDependencies);
            return this;
        }

        @Override // com.avito.android.publish.di.PublishComponent.Builder
        public PublishComponent.Builder publishDependencies(PublishDependencies publishDependencies) {
            this.a = (PublishDependencies) Preconditions.checkNotNull(publishDependencies);
            return this;
        }

        @Override // com.avito.android.publish.di.PublishComponent.Builder
        public PublishComponent.Builder publishModule(PublishModule publishModule) {
            this.c = (PublishModule) Preconditions.checkNotNull(publishModule);
            return this;
        }

        @Override // com.avito.android.publish.di.PublishComponent.Builder
        @Deprecated
        public PublishComponent.Builder publishParametersModule(PublishParametersModule publishParametersModule) {
            Preconditions.checkNotNull(publishParametersModule);
            return this;
        }

        @Override // com.avito.android.publish.di.PublishComponent.Builder
        public PublishComponent.Builder resources(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final PublishDependencies a;

        public c(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<BuildInfo> {
        public final PublishDependencies a;

        public d(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class e implements Provider<CurrentUserIdProvider> {
        public final PublishDependencies a;

        public e(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CurrentUserIdProvider get() {
            return (CurrentUserIdProvider) Preconditions.checkNotNullFromComponent(this.a.currentUserIdProvider());
        }
    }

    public static class f implements Provider<DraftIdProvider> {
        public final PublishDependencies a;

        public f(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DraftIdProvider get() {
            return (DraftIdProvider) Preconditions.checkNotNullFromComponent(this.a.draftIdProvider());
        }
    }

    public static class g implements Provider<ProfileApi> {
        public final PublishDependencies a;

        public g(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class h implements Provider<DraftOnboardingSessionStorage> {
        public final PublishDependencies a;

        public h(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DraftOnboardingSessionStorage get() {
            return (DraftOnboardingSessionStorage) Preconditions.checkNotNullFromComponent(this.a.provideStorage());
        }
    }

    public static class i implements Provider<PublishAnalyticsDataProvider> {
        public final PublishDependencies a;

        public i(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishAnalyticsDataProvider get() {
            return (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider());
        }
    }

    public static class j implements Provider<PublishDraftRepository> {
        public final PublishDependencies a;

        public j(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishDraftRepository get() {
            return (PublishDraftRepository) Preconditions.checkNotNullFromComponent(this.a.publishDraftRepository());
        }
    }

    public static class k implements Provider<PublishDraftWiper> {
        public final PublishDependencies a;

        public k(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishDraftWiper get() {
            return (PublishDraftWiper) Preconditions.checkNotNullFromComponent(this.a.publishDraftWiper());
        }
    }

    public static class l implements Provider<PublishMessageHandler> {
        public final PublishDependencies a;

        public l(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishMessageHandler get() {
            return (PublishMessageHandler) Preconditions.checkNotNullFromComponent(this.a.publishMessageHandler());
        }
    }

    public static class m implements Provider<SchedulersFactory> {
        public final PublishDependencies a;

        public m(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class n implements Provider<ScreenTrackerFactory> {
        public final PublishDependencies a;

        public n(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class o implements Provider<TimerFactory> {
        public final PublishDependencies a;

        public o(PublishDependencies publishDependencies) {
            this.a = publishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public DaggerPublishComponent(PublishModule publishModule, PublishDraftActivityModule publishDraftActivityModule, EditorHistoryModule editorHistoryModule, PublishDependencies publishDependencies, LocationDependencies locationDependencies, Resources resources, Activity activity, FragmentActivity fragmentActivity, a aVar) {
        this.a = publishDependencies;
        this.b = locationDependencies;
        this.c = editorHistoryModule;
        this.d = DoubleCheck.provider(PublishModule_ProvideConverterFactory.create(publishModule));
        Factory create = InstanceFactory.create(activity);
        this.e = create;
        this.f = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create));
        Factory create2 = InstanceFactory.create(fragmentActivity);
        this.g = create2;
        this.h = DoubleCheck.provider(PublishModule_ProvideDialogRouterFactory.create(publishModule, create2));
        c cVar = new c(publishDependencies);
        this.i = cVar;
        i iVar = new i(publishDependencies);
        this.j = iVar;
        e eVar = new e(publishDependencies);
        this.k = eVar;
        this.l = PublishEventTrackerImpl_Factory.create(cVar, iVar, eVar, PublishAnalyticModule_ProvideAnalyticsSerializerFactory.create());
        this.m = new m(publishDependencies);
        this.n = new j(publishDependencies);
        f fVar = new f(publishDependencies);
        this.o = fVar;
        this.p = DoubleCheck.provider(PublishDraftActivityModule_ProvideSubcategoryTitleHolderForDraftFactory.create(publishDraftActivityModule, fVar));
        this.q = new k(publishDependencies);
        this.r = new d(publishDependencies);
        Provider<Gson> provider = DoubleCheck.provider(PublishModule_ProvideGsonFactory.create(publishModule));
        this.s = provider;
        l lVar = new l(publishDependencies);
        this.t = lVar;
        this.u = DoubleCheck.provider(PublishModule_ProvideSubmissionPresenterFactory.create(publishModule, this.l, this.j, this.m, this.n, this.p, this.q, this.r, provider, lVar));
        this.v = new g(publishDependencies);
        n nVar = new n(publishDependencies);
        this.w = nVar;
        o oVar = new o(publishDependencies);
        this.x = oVar;
        this.y = DoubleCheck.provider(PublishModule_ProvidesScreenDiInjectTracker$publish_releaseFactory.create(publishModule, nVar, oVar));
        this.z = DoubleCheck.provider(PublishModule_ProvidesScreenInitTrackerFactory.create(publishModule, this.w, this.x));
        Provider<ScreenFlowTrackerProvider> provider2 = DoubleCheck.provider(PublishModule_ProvidesScreenFlowTrackerProviderFactory.create(publishModule, this.w, this.x));
        this.A = provider2;
        PublishContactsTrackerImpl_Factory create3 = PublishContactsTrackerImpl_Factory.create(this.y, this.z, provider2);
        this.B = create3;
        Provider<PublishContactsTracker> provider3 = DoubleCheck.provider(create3);
        this.C = provider3;
        this.D = DoubleCheck.provider(PublishModule_ProvideInteractorFactory.create(publishModule, this.v, provider3, this.m));
        this.E = new h(publishDependencies);
        Factory create4 = InstanceFactory.create(resources);
        this.F = create4;
        DraftOnboardingResourceProviderImpl_Factory create5 = DraftOnboardingResourceProviderImpl_Factory.create(create4);
        this.G = create5;
        Provider<DraftOnboardingResourceProvider> provider4 = DoubleCheck.provider(create5);
        this.H = provider4;
        DraftOnboardingInteractorImpl_Factory create6 = DraftOnboardingInteractorImpl_Factory.create(this.E, this.m, provider4);
        this.I = create6;
        Provider<DraftOnboardingInteractor> provider5 = DoubleCheck.provider(create6);
        this.J = provider5;
        this.K = DoubleCheck.provider(PublishModule_ProvideViewModelFactory$publish_releaseFactory.create(publishModule, this.l, provider5, this.r));
    }

    public static PublishComponent.Builder builder() {
        return new b(null);
    }

    public final PublishEventTrackerImpl a() {
        return new PublishEventTrackerImpl((Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()), (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider()), (CurrentUserIdProvider) Preconditions.checkNotNullFromComponent(this.a.currentUserIdProvider()), PublishAnalyticModule_ProvideAnalyticsSerializerFactory.provideAnalyticsSerializer());
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public AbTestsConfigProvider abTestsConfigProvider() {
        return (AbTestsConfigProvider) Preconditions.checkNotNullFromComponent(this.a.abTestsConfigProvider());
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    public AccountStorageInteractor accountStorageInteractor() {
        return (AccountStorageInteractor) Preconditions.checkNotNullFromComponent(this.a.accountStorageInteractor());
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public ActivityIntentFactory activityIntentFactory() {
        return (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory());
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public Analytics analytics() {
        return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public Application application() {
        return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    public AttributesTreeConverter attributesConverter() {
        return (AttributesTreeConverter) Preconditions.checkNotNullFromComponent(this.a.attributesConverter());
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    public BuildInfo buildInfo() {
        return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public CategoryParametersConverter categoryParametersConverter() {
        return this.d.get();
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    public ComputerVisionInteractor computerVisionInteractor() {
        return (ComputerVisionInteractor) Preconditions.checkNotNullFromComponent(this.a.computerVisionInteractor());
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public Context context() {
        return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    public DeepLinkFactory deepLinkFactory() {
        return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public DeepLinkIntentFactory deepLinkIntentFactory() {
        return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory());
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public DeviceMetrics deviceMetrics() {
        return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
    }

    @Override // com.avito.android.publish.input_vin.di.InputVinDependencies
    public DialogRouter dialogRouter() {
        return this.f.get();
    }

    @Override // com.avito.android.publish.infomodel_request.di.InfomodelRequestDependencies
    public PublishDraftEventTracker draftEventTracker() {
        return PublishDraftsAnalyticsModule_ProvidePublishEventTrackerFactory.providePublishEventTracker((Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()), (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider()), PublishAnalyticModule_ProvideAnalyticsSerializerFactory.provideAnalyticsSerializer());
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    public EditorHistoryProvider editorHistoryProvider() {
        return new PrefEditorHistoryProvider(EditorHistoryModule_ProvideEditorPreferencesFactory.provideEditorPreferences(this.c, (Application) Preconditions.checkNotNullFromComponent(this.a.application()), (PreferenceFactory) Preconditions.checkNotNullFromComponent(this.a.preferencesFactory())), EditorHistoryModule_ProvideEditorSerializerFactory.provideEditorSerializer(this.c));
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public Features features() {
        return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
    }

    @Override // com.avito.android.publish.input_vin.di.InputVinDependencies, com.avito.android.publish.details.di.PublishDetailsDependencies
    public HtmlCleaner htmlCleaner() {
        return (HtmlCleaner) Preconditions.checkNotNullFromComponent(this.a.htmlCleaner());
    }

    @Override // com.avito.android.publish.input_vin.di.InputVinDependencies
    public HtmlNodeFactory htmlNodeFactory() {
        return (HtmlNodeFactory) Preconditions.checkNotNullFromComponent(this.a.htmlNodeFactory());
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    public HtmlRenderer htmlRenderer() {
        return (HtmlRenderer) Preconditions.checkNotNullFromComponent(this.a.htmlRenderer());
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public ImplicitIntentFactory implicitIntentFactory() {
        return (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory());
    }

    @Override // com.avito.android.publish.di.PublishComponent
    public void inject(PublishActivity publishActivity) {
        PublishActivity_MembersInjector.injectDeepLinkIntentFactory(publishActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        PublishActivity_MembersInjector.injectIntentFactory(publishActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        PublishActivity_MembersInjector.injectPresenter(publishActivity, this.u.get());
        PublishActivity_MembersInjector.injectPublishDraftDataHolder(publishActivity, this.p.get());
        PublishActivity_MembersInjector.injectAnalytics(publishActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        PublishActivity_MembersInjector.injectAnalyticsData(publishActivity, (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider()));
        PublishActivity_MembersInjector.injectPublishEventTracker(publishActivity, a());
        PublishActivity_MembersInjector.injectPhotoPickerEventTracker(publishActivity, (PhotoPickerOnPublishEventTracker) Preconditions.checkNotNullFromComponent(this.a.photoPickerOnPublishEventTracker()));
        PublishActivity_MembersInjector.injectFeatures(publishActivity, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        PublishActivity_MembersInjector.injectAbTestsConfigProvider(publishActivity, (AbTestsConfigProvider) Preconditions.checkNotNullFromComponent(this.a.abTestsConfigProvider()));
        PublishActivity_MembersInjector.injectViewModelFactory(publishActivity, this.K.get());
        PublishActivity_MembersInjector.injectDialogRouter(publishActivity, this.f.get());
    }

    @Override // com.avito.android.publish.input_vin.di.InputVinDependencies
    public Locale locale() {
        return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public LocationApi locationApi() {
        return (LocationApi) Preconditions.checkNotNullFromComponent(this.b.locationApi());
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public PrivatePhotosStorage privatePhotosStorage() {
        return (PrivatePhotosStorage) Preconditions.checkNotNullFromComponent(this.a.privatePhotosStorage());
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public ProfileApi profileApi() {
        return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    public ProfileSourceInteractor profileSource() {
        return this.D.get();
    }

    @Override // com.avito.android.publish.input_vin.di.InputVinDependencies
    public ProgressDialogRouter progressDialogRouter() {
        return this.h.get();
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public PublishAnalyticsDataProvider publishAnalyticsDataProvider() {
        return (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider());
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public PublishApi publishApi() {
        return (PublishApi) Preconditions.checkNotNullFromComponent(this.a.publishApi());
    }

    @Override // com.avito.android.publish.category_suggest.di.CategoriesSuggestionsDependencies
    public PublishDraftDataHolder publishDraftDataHolder() {
        return this.p.get();
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public PublishDraftRepository publishDraftRepository() {
        return (PublishDraftRepository) Preconditions.checkNotNullFromComponent(this.a.publishDraftRepository());
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    public PublishDraftWiper publishDraftWiper() {
        return (PublishDraftWiper) Preconditions.checkNotNullFromComponent(this.a.publishDraftWiper());
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public PublishEventTracker publishEventTracker() {
        return a();
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    public PublishLimitsApi publishLimitsApi() {
        return (PublishLimitsApi) Preconditions.checkNotNullFromComponent(this.a.publishLimitsApi());
    }

    @Override // com.avito.android.publish.infomodel_request.di.InfomodelRequestDependencies
    public PublishSessionIdGenerator publishSessionIdGenerator() {
        return (PublishSessionIdGenerator) Preconditions.checkNotNullFromComponent(this.a.publishSessionIdGenerator());
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    public SchedulersFactory3 schedulers3() {
        return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public SchedulersFactory schedulersFactory() {
        return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    public ScreenTrackerFactory screenTrackerFactory() {
        return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
    }

    @Override // com.avito.android.publish.sts_scanner.di.StsScannerDependencies
    public SharedPhotosStorage sharedPhotosStorage() {
        return (SharedPhotosStorage) Preconditions.checkNotNullFromComponent(this.a.sharedPhotosStorage());
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    public SubmissionPresenter submissionPresenter() {
        return this.u.get();
    }

    @Override // com.avito.android.publish.input_vin.di.InputVinDependencies
    public TimeSource timeSource() {
        return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    public TimerFactory timerFactory() {
        return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    public TypedErrorThrowableConverter typedErrorThrowableConverter() {
        return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    public ValidateAdvertApi validateAdvertApi() {
        return (ValidateAdvertApi) Preconditions.checkNotNullFromComponent(this.a.validateAdvertApi());
    }
}
