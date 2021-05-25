package com.avito.android.social_management.di;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.dialog.DialogPresenterImpl;
import com.avito.android.dialog.DialogPresenterImpl_Factory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.preferences.SocialNotificationStateStorage;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.EqualityComparator;
import com.avito.android.remote.ProfileApi;
import com.avito.android.social.AppleSignInManager;
import com.avito.android.social.AppleSignInManagerImpl_Factory;
import com.avito.android.social.EsiaSignInManager;
import com.avito.android.social.EsiaSignInManagerImpl_Factory;
import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.FacebookSocialManagerImpl_Factory;
import com.avito.android.social.GoogleSocialManager;
import com.avito.android.social.GoogleSocialManagerImpl;
import com.avito.android.social.GoogleSocialManagerImpl_Factory;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.OdnoklassnikiSocialManagerImpl;
import com.avito.android.social.OdnoklassnikiSocialManagerImpl_Factory;
import com.avito.android.social.SignInManager;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.social.VkontakteSocialManager;
import com.avito.android.social.VkontakteSocialManagerImpl;
import com.avito.android.social.VkontakteSocialManagerImpl_Factory;
import com.avito.android.social_management.SocialManagementActivity;
import com.avito.android.social_management.SocialManagementActivity_MembersInjector;
import com.avito.android.social_management.SocialManagementInteractor;
import com.avito.android.social_management.SocialManagementInteractorImpl;
import com.avito.android.social_management.SocialManagementInteractorImpl_Factory;
import com.avito.android.social_management.SocialManagementPresenter;
import com.avito.android.social_management.SocialManagementPresenterImpl;
import com.avito.android.social_management.SocialManagementPresenterImpl_Factory;
import com.avito.android.social_management.SocialManagementResourceProvider;
import com.avito.android.social_management.SocialManagementResourceProviderImpl;
import com.avito.android.social_management.SocialManagementResourceProviderImpl_Factory;
import com.avito.android.social_management.adapter.SocialContentsComparator_Factory;
import com.avito.android.social_management.adapter.SocialEqualityComparator_Factory;
import com.avito.android.social_management.adapter.SocialItem;
import com.avito.android.social_management.adapter.available.AvailableItemPresenter;
import com.avito.android.social_management.adapter.available.di.AvailableItemModule_ProvideBlueprint$social_network_editor_releaseFactory;
import com.avito.android.social_management.adapter.available.di.AvailableItemModule_ProvidePresenter$social_network_editor_releaseFactory;
import com.avito.android.social_management.adapter.connected.ConnectedItemPresenter;
import com.avito.android.social_management.adapter.connected.di.ConnectedItemModule_ProvideBlueprint$social_network_editor_releaseFactory;
import com.avito.android.social_management.adapter.connected.di.ConnectedItemModule_ProvidePresenter$social_network_editor_releaseFactory;
import com.avito.android.social_management.adapter.header.HeaderItemPresenter;
import com.avito.android.social_management.adapter.header.di.HeaderItemModule_ProvideBlueprint$social_network_editor_releaseFactory;
import com.avito.android.social_management.adapter.header.di.HeaderItemModule_ProvidePresenter$social_network_editor_releaseFactory;
import com.avito.android.social_management.adapter.notification.NotificationItemBlueprint;
import com.avito.android.social_management.adapter.notification.NotificationItemBlueprint_Factory;
import com.avito.android.social_management.adapter.notification.NotificationItemPresenter;
import com.avito.android.social_management.adapter.notification.NotificationItemPresenterImpl;
import com.avito.android.social_management.adapter.notification.NotificationItemPresenterImpl_Factory;
import com.avito.android.social_management.adapter.notification.SocialNotificationAction;
import com.avito.android.social_management.di.SocialManagementComponent;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerSocialManagementComponent implements SocialManagementComponent {
    public Provider<SocialNotificationStateStorage> A;
    public Provider<SocialManagementInteractorImpl> B;
    public Provider<SocialManagementInteractor> C;
    public Provider<FacebookSocialManager> D;
    public Provider<Context> E;
    public Provider<OdnoklassnikiSocialManagerImpl> F;
    public Provider<OdnoklassnikiSocialManager> G;
    public Provider<VkontakteSocialManagerImpl> H;
    public Provider<VkontakteSocialManager> I;
    public Provider<GoogleSocialManagerImpl> J;
    public Provider<GoogleSocialManager> K;
    public Provider<AppleSignInManager> L;
    public Provider<EsiaSignInManager> M;
    public Provider<List<SignInManager>> N;
    public Provider<Resources> O;
    public Provider<ErrorFormatterImpl> P;
    public Provider<ErrorFormatter> Q;
    public Provider<ErrorHelperImpl> R;
    public Provider<ErrorHelper> S;
    public Provider<Activity> T;
    public Provider<DialogRouter> U;
    public Provider<DialogPresenterImpl> V;
    public Provider<DialogPresenter> W;
    public Provider<SocialManagementResourceProviderImpl> X;
    public Provider<SocialManagementResourceProvider> Y;
    public Provider<Analytics> Z;
    public final SocialManagementDependencies a;
    public Provider<SocialTypeToStringMapper> a0;
    public Provider<SimpleRecyclerAdapter> b = new DelegateFactory();
    public Provider<Kundle> b0;
    public Provider<PublishRelay<SocialItem>> c;
    public Provider<SocialManagementPresenterImpl> c0;
    public Provider<ConnectedItemPresenter> d;
    public Provider<SocialManagementPresenter> d0;
    public Provider<ItemBlueprint<?, ?>> e;
    public Provider<HeaderItemPresenter> f;
    public Provider<ItemBlueprint<?, ?>> g;
    public Provider<AvailableItemPresenter> h;
    public Provider<ItemBlueprint<?, ?>> i;
    public Provider<Set<ItemBlueprint<?, ?>>> j;
    public Provider<PublishRelay<SocialNotificationAction>> k;
    public Provider<NotificationItemPresenterImpl> l;
    public Provider<NotificationItemPresenter> m;
    public Provider<AttributedTextFormatter> n;
    public Provider<NotificationItemBlueprint> o;
    public Provider<ItemBlueprint<?, ?>> p;
    public Provider<Set<ItemBlueprint<?, ?>>> q;
    public Provider<ItemBinder> r;
    public Provider<AdapterPresenter> s;
    public Provider<ContentsComparator> t;
    public Provider<EqualityComparator> u;
    public Provider<DiffCalculator> v;
    public Provider<DataAwareAdapterPresenter> w;
    public Provider<ProfileApi> x;
    public Provider<SchedulersFactory> y;
    public Provider<Features> z;

    public static final class b implements SocialManagementComponent.Builder {
        public SocialManagementDependencies a;
        public Resources b;
        public Activity c;
        public Kundle d;

        public b(a aVar) {
        }

        @Override // com.avito.android.social_management.di.SocialManagementComponent.Builder
        public SocialManagementComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SocialManagementDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            return new DaggerSocialManagementComponent(this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.social_management.di.SocialManagementComponent.Builder
        public SocialManagementComponent.Builder dependentOn(SocialManagementDependencies socialManagementDependencies) {
            this.a = (SocialManagementDependencies) Preconditions.checkNotNull(socialManagementDependencies);
            return this;
        }

        @Override // com.avito.android.social_management.di.SocialManagementComponent.Builder
        public SocialManagementComponent.Builder withActivity(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.social_management.di.SocialManagementComponent.Builder
        public SocialManagementComponent.Builder withPresenterState(Kundle kundle) {
            this.d = kundle;
            return this;
        }

        @Override // com.avito.android.social_management.di.SocialManagementComponent.Builder
        public SocialManagementComponent.Builder withResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final SocialManagementDependencies a;

        public c(SocialManagementDependencies socialManagementDependencies) {
            this.a = socialManagementDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Context> {
        public final SocialManagementDependencies a;

        public d(SocialManagementDependencies socialManagementDependencies) {
            this.a = socialManagementDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class e implements Provider<Features> {
        public final SocialManagementDependencies a;

        public e(SocialManagementDependencies socialManagementDependencies) {
            this.a = socialManagementDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class f implements Provider<ProfileApi> {
        public final SocialManagementDependencies a;

        public f(SocialManagementDependencies socialManagementDependencies) {
            this.a = socialManagementDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class g implements Provider<SchedulersFactory> {
        public final SocialManagementDependencies a;

        public g(SocialManagementDependencies socialManagementDependencies) {
            this.a = socialManagementDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class h implements Provider<SocialNotificationStateStorage> {
        public final SocialManagementDependencies a;

        public h(SocialManagementDependencies socialManagementDependencies) {
            this.a = socialManagementDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SocialNotificationStateStorage get() {
            return (SocialNotificationStateStorage) Preconditions.checkNotNullFromComponent(this.a.socialNotificationStorage());
        }
    }

    public static class i implements Provider<SocialTypeToStringMapper> {
        public final SocialManagementDependencies a;

        public i(SocialManagementDependencies socialManagementDependencies) {
            this.a = socialManagementDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SocialTypeToStringMapper get() {
            return (SocialTypeToStringMapper) Preconditions.checkNotNullFromComponent(this.a.socialTypeToStringMapper());
        }
    }

    public DaggerSocialManagementComponent(SocialManagementDependencies socialManagementDependencies, Resources resources, Activity activity, Kundle kundle, a aVar) {
        this.a = socialManagementDependencies;
        Provider<PublishRelay<SocialItem>> provider = DoubleCheck.provider(SocialManagementModule_ProvideClicksStream$social_network_editor_releaseFactory.create());
        this.c = provider;
        Provider<ConnectedItemPresenter> provider2 = DoubleCheck.provider(ConnectedItemModule_ProvidePresenter$social_network_editor_releaseFactory.create(provider));
        this.d = provider2;
        this.e = DoubleCheck.provider(ConnectedItemModule_ProvideBlueprint$social_network_editor_releaseFactory.create(provider2));
        Provider<HeaderItemPresenter> provider3 = DoubleCheck.provider(HeaderItemModule_ProvidePresenter$social_network_editor_releaseFactory.create(this.c));
        this.f = provider3;
        this.g = DoubleCheck.provider(HeaderItemModule_ProvideBlueprint$social_network_editor_releaseFactory.create(provider3));
        Provider<AvailableItemPresenter> provider4 = DoubleCheck.provider(AvailableItemModule_ProvidePresenter$social_network_editor_releaseFactory.create(this.c));
        this.h = provider4;
        this.i = DoubleCheck.provider(AvailableItemModule_ProvideBlueprint$social_network_editor_releaseFactory.create(provider4));
        this.j = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
        Provider<PublishRelay<SocialNotificationAction>> provider5 = DoubleCheck.provider(SocialManagementModule_ProvideNotificationsActionsStream$social_network_editor_releaseFactory.create());
        this.k = provider5;
        NotificationItemPresenterImpl_Factory create = NotificationItemPresenterImpl_Factory.create(provider5);
        this.l = create;
        this.m = DoubleCheck.provider(create);
        Provider<AttributedTextFormatter> provider6 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.n = provider6;
        NotificationItemBlueprint_Factory create2 = NotificationItemBlueprint_Factory.create(this.m, provider6);
        this.o = create2;
        this.p = DoubleCheck.provider(create2);
        SetFactory build = SetFactory.builder(4, 1).addProvider(this.e).addProvider(this.g).addProvider(this.i).addCollectionProvider(this.j).addProvider(this.p).build();
        this.q = build;
        Provider<ItemBinder> provider7 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.r = provider7;
        this.s = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider7));
        this.t = DoubleCheck.provider(SocialContentsComparator_Factory.create());
        Provider<EqualityComparator> provider8 = DoubleCheck.provider(SocialEqualityComparator_Factory.create());
        this.u = provider8;
        Provider<DiffCalculator> provider9 = DoubleCheck.provider(SocialManagementModule_ProvideDiffCalculatorFactory.create(this.t, provider8));
        this.v = provider9;
        Provider<DataAwareAdapterPresenter> provider10 = DoubleCheck.provider(SocialManagementModule_ProvideDataAwareAdapterFactory.create(this.b, this.s, provider9));
        this.w = provider10;
        DelegateFactory.setDelegate(this.b, DoubleCheck.provider(SocialManagementModule_ProvideRecyclerAdapterFactory.create(provider10, this.r)));
        f fVar = new f(socialManagementDependencies);
        this.x = fVar;
        g gVar = new g(socialManagementDependencies);
        this.y = gVar;
        e eVar = new e(socialManagementDependencies);
        this.z = eVar;
        h hVar = new h(socialManagementDependencies);
        this.A = hVar;
        SocialManagementInteractorImpl_Factory create3 = SocialManagementInteractorImpl_Factory.create(fVar, gVar, eVar, hVar);
        this.B = create3;
        this.C = DoubleCheck.provider(create3);
        this.D = SingleCheck.provider(FacebookSocialManagerImpl_Factory.create());
        d dVar = new d(socialManagementDependencies);
        this.E = dVar;
        OdnoklassnikiSocialManagerImpl_Factory create4 = OdnoklassnikiSocialManagerImpl_Factory.create(dVar);
        this.F = create4;
        this.G = SingleCheck.provider(create4);
        VkontakteSocialManagerImpl_Factory create5 = VkontakteSocialManagerImpl_Factory.create(this.E);
        this.H = create5;
        this.I = SingleCheck.provider(create5);
        GoogleSocialManagerImpl_Factory create6 = GoogleSocialManagerImpl_Factory.create(this.E);
        this.J = create6;
        this.K = SingleCheck.provider(create6);
        this.L = SingleCheck.provider(AppleSignInManagerImpl_Factory.create());
        Provider<EsiaSignInManager> provider11 = SingleCheck.provider(EsiaSignInManagerImpl_Factory.create());
        this.M = provider11;
        this.N = DoubleCheck.provider(SocialManagementModule_ProvideSocialManagers$social_network_editor_releaseFactory.create(this.D, this.G, this.I, this.K, this.L, provider11, this.z));
        Factory create7 = InstanceFactory.create(resources);
        this.O = create7;
        ErrorFormatterImpl_Factory create8 = ErrorFormatterImpl_Factory.create(create7);
        this.P = create8;
        Provider<ErrorFormatter> provider12 = SingleCheck.provider(create8);
        this.Q = provider12;
        ErrorHelperImpl_Factory create9 = ErrorHelperImpl_Factory.create(provider12);
        this.R = create9;
        this.S = SingleCheck.provider(create9);
        Factory create10 = InstanceFactory.create(activity);
        this.T = create10;
        Provider<DialogRouter> provider13 = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create10));
        this.U = provider13;
        DialogPresenterImpl_Factory create11 = DialogPresenterImpl_Factory.create(this.T, provider13);
        this.V = create11;
        this.W = SingleCheck.provider(create11);
        SocialManagementResourceProviderImpl_Factory create12 = SocialManagementResourceProviderImpl_Factory.create(this.O);
        this.X = create12;
        this.Y = DoubleCheck.provider(create12);
        this.Z = new c(socialManagementDependencies);
        this.a0 = new i(socialManagementDependencies);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.b0 = createNullable;
        SocialManagementPresenterImpl_Factory create13 = SocialManagementPresenterImpl_Factory.create(this.C, this.N, this.w, this.c, this.k, this.S, this.W, this.Y, this.Z, this.y, this.a0, createNullable);
        this.c0 = create13;
        this.d0 = DoubleCheck.provider(create13);
    }

    public static SocialManagementComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.social_management.di.SocialManagementComponent
    public void inject(SocialManagementActivity socialManagementActivity) {
        SocialManagementActivity_MembersInjector.injectIntentFactory(socialManagementActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        SocialManagementActivity_MembersInjector.injectAdapter(socialManagementActivity, this.b.get());
        SocialManagementActivity_MembersInjector.injectPresenter(socialManagementActivity, this.d0.get());
        SocialManagementActivity_MembersInjector.injectAnalytics(socialManagementActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        SocialManagementActivity_MembersInjector.injectSocialTypeToStringMapper(socialManagementActivity, (SocialTypeToStringMapper) Preconditions.checkNotNullFromComponent(this.a.socialTypeToStringMapper()));
        SocialManagementActivity_MembersInjector.injectDeepLinkIntentFactory(socialManagementActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
    }
}
