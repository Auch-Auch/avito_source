package com.avito.android.notification_center.landing.unified.di;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractorFactoryImpl_Factory;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedStatusResolverFactory;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl_Factory;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.favorite.FavoriteAdvertsResourceProviderImpl;
import com.avito.android.favorite.FavoriteAdvertsResourceProviderImpl_Factory;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedActivity;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedActivity_MembersInjector;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedInteractor;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedInteractorImpl;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedInteractorImpl_Factory;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenter;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenterImpl;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenterImpl_Factory;
import com.avito.android.notification_center.landing.unified.NotificationsCenterLandingUnifiedConverter;
import com.avito.android.notification_center.landing.unified.NotificationsCenterLandingUnifiedConverterImpl;
import com.avito.android.notification_center.landing.unified.NotificationsCenterLandingUnifiedConverterImpl_Factory;
import com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertBlueprint;
import com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertBlueprint_Factory;
import com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItem;
import com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertPresenter;
import com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertPresenterImpl;
import com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertPresenterImpl_Factory;
import com.avito.android.notification_center.landing.unified.button.UnifiedButtonBlueprint;
import com.avito.android.notification_center.landing.unified.button.UnifiedButtonBlueprint_Factory;
import com.avito.android.notification_center.landing.unified.button.UnifiedButtonItem;
import com.avito.android.notification_center.landing.unified.button.UnifiedButtonPresenter;
import com.avito.android.notification_center.landing.unified.button.UnifiedButtonPresenterImpl;
import com.avito.android.notification_center.landing.unified.button.UnifiedButtonPresenterImpl_Factory;
import com.avito.android.notification_center.landing.unified.description.UnifiedDescriptionBlueprint;
import com.avito.android.notification_center.landing.unified.description.UnifiedDescriptionBlueprint_Factory;
import com.avito.android.notification_center.landing.unified.description.UnifiedDescriptionPresenter;
import com.avito.android.notification_center.landing.unified.description.UnifiedDescriptionPresenterImpl_Factory;
import com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedComponent;
import com.avito.android.notification_center.landing.unified.divider.UnifiedDividerBlueprint;
import com.avito.android.notification_center.landing.unified.divider.UnifiedDividerBlueprint_Factory;
import com.avito.android.notification_center.landing.unified.divider.UnifiedDividerPresenter;
import com.avito.android.notification_center.landing.unified.divider.UnifiedDividerPresenterImpl_Factory;
import com.avito.android.notification_center.landing.unified.image.UnifiedImageBlueprint;
import com.avito.android.notification_center.landing.unified.image.UnifiedImageBlueprint_Factory;
import com.avito.android.notification_center.landing.unified.image.UnifiedImagePresenter;
import com.avito.android.notification_center.landing.unified.image.UnifiedImagePresenterImpl_Factory;
import com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonBlueprint;
import com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonBlueprint_Factory;
import com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonItem;
import com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonPresenter;
import com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonPresenterImpl;
import com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonPresenterImpl_Factory;
import com.avito.android.notification_center.landing.unified.space.UnifiedSpaceBlueprint;
import com.avito.android.notification_center.landing.unified.space.UnifiedSpaceBlueprint_Factory;
import com.avito.android.notification_center.landing.unified.space.UnifiedSpacePresenter;
import com.avito.android.notification_center.landing.unified.space.UnifiedSpacePresenterImpl_Factory;
import com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitleBlueprint;
import com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitleBlueprint_Factory;
import com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitleItem;
import com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitlePresenter;
import com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitlePresenterImpl;
import com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitlePresenterImpl_Factory;
import com.avito.android.notification_center.landing.unified.title.UnifiedTitleBlueprint;
import com.avito.android.notification_center.landing.unified.title.UnifiedTitleBlueprint_Factory;
import com.avito.android.notification_center.landing.unified.title.UnifiedTitlePresenter;
import com.avito.android.notification_center.landing.unified.title.UnifiedTitlePresenterImpl_Factory;
import com.avito.android.remote.NotificationsApi;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.FavoriteStatusResolverImpl;
import com.avito.android.serp.adapter.FavoriteStatusResolverImpl_Factory;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.Relay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerNotificationCenterLandingUnifiedComponent implements NotificationCenterLandingUnifiedComponent {
    public Provider<UnifiedSpaceBlueprint> A;
    public Provider<Relay<UnifiedSubtitleItem>> B;
    public Provider<UnifiedSubtitlePresenterImpl> C;
    public Provider<UnifiedSubtitlePresenter> D;
    public Provider<UnifiedSubtitleBlueprint> E;
    public Provider<UnifiedTitlePresenter> F;
    public Provider<UnifiedTitleBlueprint> G;
    public Provider<ItemBinder> H;
    public Provider<AdapterPresenter> I;
    public Provider<Analytics> J;
    public Provider<NotificationsApi> K;
    public Provider<SchedulersFactory> L;
    public Provider<NotificationCenterLandingUnifiedInteractorImpl> M;
    public Provider<NotificationCenterLandingUnifiedInteractor> N;
    public Provider<FavoriteAdvertsInteractor> O;
    public Provider<FavoriteStatusResolverImpl> P;
    public Provider<FavoriteStatusResolver> Q;
    public Provider<ViewedAdvertsDao> R;
    public Provider<SchedulersFactory3> S;
    public Provider<ViewedAdvertsEventInteractor> T;
    public Provider<Features> U;
    public Provider<ViewedAdvertsInteractor> V;
    public Provider<ViewedStatusResolver> W;
    public Provider<NotificationsCenterLandingUnifiedConverterImpl> X;
    public Provider<NotificationsCenterLandingUnifiedConverter> Y;
    public Provider<Resources> Z;
    public final NotificationCenterLandingUnifiedDependencies a;
    public Provider<FavoriteAdvertsResourceProviderImpl> a0;
    public Provider<String> b;
    public Provider<FavoriteAdvertsResourceProvider> b0;
    public Provider<Relay<UnifiedAdvertItem>> c;
    public Provider<FavoriteAdvertsPresenterImpl> c0;
    public Provider<Relay<FavorableItem>> d;
    public Provider<FavoriteAdvertsPresenter> d0;
    public Provider<UnifiedAdvertPresenterImpl> e;
    public Provider<ViewedAdvertsPresenter> e0 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory.create(this.T, this.S));
    public Provider<UnifiedAdvertPresenter> f;
    public Provider<Kundle> f0;
    public Provider<Locale> g;
    public Provider<NotificationCenterLandingUnifiedPresenterImpl> g0;
    public Provider<TimeSource> h;
    public Provider<NotificationCenterLandingUnifiedPresenter> h0;
    public Provider<ConnectivityProvider> i;
    public Provider<UnifiedAdvertBlueprint> j;
    public Provider<Relay<UnifiedButtonItem>> k;
    public Provider<UnifiedButtonPresenterImpl> l;
    public Provider<UnifiedButtonPresenter> m;
    public Provider<UnifiedButtonBlueprint> n;
    public Provider<UnifiedDescriptionPresenter> o;
    public Provider<UnifiedDescriptionBlueprint> p;
    public Provider<UnifiedDividerPresenter> q;
    public Provider<UnifiedDividerBlueprint> r;
    public Provider<UnifiedImagePresenter> s;
    public Provider<UnifiedImageBlueprint> t;
    public Provider<Relay<UnifiedPairButtonItem>> u;
    public Provider<Relay<UnifiedPairButtonItem>> v;
    public Provider<UnifiedPairButtonPresenterImpl> w;
    public Provider<UnifiedPairButtonPresenter> x;
    public Provider<UnifiedPairButtonBlueprint> y;
    public Provider<UnifiedSpacePresenter> z;

    public static final class b implements NotificationCenterLandingUnifiedComponent.Builder {
        public NotificationCenterLandingUnifiedDependencies a;
        public String b;
        public Kundle c;
        public Resources d;
        public Relay<UnifiedAdvertItem> e;
        public Relay<FavorableItem> f;
        public Relay<UnifiedButtonItem> g;
        public Relay<UnifiedPairButtonItem> h;
        public Relay<UnifiedPairButtonItem> i;
        public Relay<UnifiedSubtitleItem> j;

        public b(a aVar) {
        }

        @Override // com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedComponent.Builder
        public NotificationCenterLandingUnifiedComponent build() {
            Preconditions.checkBuilderRequirement(this.a, NotificationCenterLandingUnifiedDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, Relay.class);
            Preconditions.checkBuilderRequirement(this.f, Relay.class);
            Preconditions.checkBuilderRequirement(this.g, Relay.class);
            Preconditions.checkBuilderRequirement(this.h, Relay.class);
            Preconditions.checkBuilderRequirement(this.i, Relay.class);
            Preconditions.checkBuilderRequirement(this.j, Relay.class);
            return new DaggerNotificationCenterLandingUnifiedComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, null);
        }

        @Override // com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedComponent.Builder
        public NotificationCenterLandingUnifiedComponent.Builder dependencies(NotificationCenterLandingUnifiedDependencies notificationCenterLandingUnifiedDependencies) {
            this.a = (NotificationCenterLandingUnifiedDependencies) Preconditions.checkNotNull(notificationCenterLandingUnifiedDependencies);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedComponent.Builder
        public NotificationCenterLandingUnifiedComponent.Builder withAdvertClickRelay(Relay relay) {
            this.e = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedComponent.Builder
        public NotificationCenterLandingUnifiedComponent.Builder withAdvertFavoriteRelay(Relay relay) {
            this.f = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedComponent.Builder
        public NotificationCenterLandingUnifiedComponent.Builder withButtonClickRelay(Relay relay) {
            this.g = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedComponent.Builder
        public NotificationCenterLandingUnifiedComponent.Builder withId(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedComponent.Builder
        public NotificationCenterLandingUnifiedComponent.Builder withPairButtonFirstClickRelay(Relay relay) {
            this.h = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedComponent.Builder
        public NotificationCenterLandingUnifiedComponent.Builder withPairButtonSecondClickRelay(Relay relay) {
            this.i = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedComponent.Builder
        public NotificationCenterLandingUnifiedComponent.Builder withPresenterState(Kundle kundle) {
            this.c = kundle;
            return this;
        }

        @Override // com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedComponent.Builder
        public NotificationCenterLandingUnifiedComponent.Builder withResources(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedComponent.Builder
        public NotificationCenterLandingUnifiedComponent.Builder withSubtitleClickRelay(Relay relay) {
            this.j = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final NotificationCenterLandingUnifiedDependencies a;

        public c(NotificationCenterLandingUnifiedDependencies notificationCenterLandingUnifiedDependencies) {
            this.a = notificationCenterLandingUnifiedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<ConnectivityProvider> {
        public final NotificationCenterLandingUnifiedDependencies a;

        public d(NotificationCenterLandingUnifiedDependencies notificationCenterLandingUnifiedDependencies) {
            this.a = notificationCenterLandingUnifiedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ConnectivityProvider get() {
            return (ConnectivityProvider) Preconditions.checkNotNullFromComponent(this.a.connectivityProvider());
        }
    }

    public static class e implements Provider<FavoriteAdvertsInteractor> {
        public final NotificationCenterLandingUnifiedDependencies a;

        public e(NotificationCenterLandingUnifiedDependencies notificationCenterLandingUnifiedDependencies) {
            this.a = notificationCenterLandingUnifiedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsInteractor get() {
            return (FavoriteAdvertsInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsInteractor());
        }
    }

    public static class f implements Provider<Features> {
        public final NotificationCenterLandingUnifiedDependencies a;

        public f(NotificationCenterLandingUnifiedDependencies notificationCenterLandingUnifiedDependencies) {
            this.a = notificationCenterLandingUnifiedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<Locale> {
        public final NotificationCenterLandingUnifiedDependencies a;

        public g(NotificationCenterLandingUnifiedDependencies notificationCenterLandingUnifiedDependencies) {
            this.a = notificationCenterLandingUnifiedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class h implements Provider<NotificationsApi> {
        public final NotificationCenterLandingUnifiedDependencies a;

        public h(NotificationCenterLandingUnifiedDependencies notificationCenterLandingUnifiedDependencies) {
            this.a = notificationCenterLandingUnifiedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationsApi get() {
            return (NotificationsApi) Preconditions.checkNotNullFromComponent(this.a.notificationsApi());
        }
    }

    public static class i implements Provider<SchedulersFactory3> {
        public final NotificationCenterLandingUnifiedDependencies a;

        public i(NotificationCenterLandingUnifiedDependencies notificationCenterLandingUnifiedDependencies) {
            this.a = notificationCenterLandingUnifiedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class j implements Provider<SchedulersFactory> {
        public final NotificationCenterLandingUnifiedDependencies a;

        public j(NotificationCenterLandingUnifiedDependencies notificationCenterLandingUnifiedDependencies) {
            this.a = notificationCenterLandingUnifiedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class k implements Provider<TimeSource> {
        public final NotificationCenterLandingUnifiedDependencies a;

        public k(NotificationCenterLandingUnifiedDependencies notificationCenterLandingUnifiedDependencies) {
            this.a = notificationCenterLandingUnifiedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class l implements Provider<ViewedAdvertsDao> {
        public final NotificationCenterLandingUnifiedDependencies a;

        public l(NotificationCenterLandingUnifiedDependencies notificationCenterLandingUnifiedDependencies) {
            this.a = notificationCenterLandingUnifiedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsDao get() {
            return (ViewedAdvertsDao) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsDao());
        }
    }

    public static class m implements Provider<ViewedAdvertsEventInteractor> {
        public final NotificationCenterLandingUnifiedDependencies a;

        public m(NotificationCenterLandingUnifiedDependencies notificationCenterLandingUnifiedDependencies) {
            this.a = notificationCenterLandingUnifiedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsEventInteractor get() {
            return (ViewedAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsEventInteractor());
        }
    }

    public DaggerNotificationCenterLandingUnifiedComponent(NotificationCenterLandingUnifiedDependencies notificationCenterLandingUnifiedDependencies, String str, Kundle kundle, Resources resources, Relay relay, Relay relay2, Relay relay3, Relay relay4, Relay relay5, Relay relay6, a aVar) {
        this.a = notificationCenterLandingUnifiedDependencies;
        this.b = InstanceFactory.create(str);
        this.c = InstanceFactory.create(relay);
        Factory create = InstanceFactory.create(relay2);
        this.d = create;
        UnifiedAdvertPresenterImpl_Factory create2 = UnifiedAdvertPresenterImpl_Factory.create(this.c, create);
        this.e = create2;
        Provider<UnifiedAdvertPresenter> provider = DoubleCheck.provider(create2);
        this.f = provider;
        g gVar = new g(notificationCenterLandingUnifiedDependencies);
        this.g = gVar;
        k kVar = new k(notificationCenterLandingUnifiedDependencies);
        this.h = kVar;
        d dVar = new d(notificationCenterLandingUnifiedDependencies);
        this.i = dVar;
        this.j = UnifiedAdvertBlueprint_Factory.create(provider, gVar, kVar, dVar);
        Factory create3 = InstanceFactory.create(relay3);
        this.k = create3;
        UnifiedButtonPresenterImpl_Factory create4 = UnifiedButtonPresenterImpl_Factory.create(create3);
        this.l = create4;
        Provider<UnifiedButtonPresenter> provider2 = DoubleCheck.provider(create4);
        this.m = provider2;
        this.n = UnifiedButtonBlueprint_Factory.create(provider2);
        Provider<UnifiedDescriptionPresenter> provider3 = DoubleCheck.provider(UnifiedDescriptionPresenterImpl_Factory.create());
        this.o = provider3;
        this.p = UnifiedDescriptionBlueprint_Factory.create(provider3);
        Provider<UnifiedDividerPresenter> provider4 = DoubleCheck.provider(UnifiedDividerPresenterImpl_Factory.create());
        this.q = provider4;
        this.r = UnifiedDividerBlueprint_Factory.create(provider4);
        Provider<UnifiedImagePresenter> provider5 = DoubleCheck.provider(UnifiedImagePresenterImpl_Factory.create());
        this.s = provider5;
        this.t = UnifiedImageBlueprint_Factory.create(provider5);
        this.u = InstanceFactory.create(relay4);
        Factory create5 = InstanceFactory.create(relay5);
        this.v = create5;
        UnifiedPairButtonPresenterImpl_Factory create6 = UnifiedPairButtonPresenterImpl_Factory.create(this.u, create5);
        this.w = create6;
        Provider<UnifiedPairButtonPresenter> provider6 = DoubleCheck.provider(create6);
        this.x = provider6;
        this.y = UnifiedPairButtonBlueprint_Factory.create(provider6);
        Provider<UnifiedSpacePresenter> provider7 = DoubleCheck.provider(UnifiedSpacePresenterImpl_Factory.create());
        this.z = provider7;
        this.A = UnifiedSpaceBlueprint_Factory.create(provider7);
        Factory create7 = InstanceFactory.create(relay6);
        this.B = create7;
        UnifiedSubtitlePresenterImpl_Factory create8 = UnifiedSubtitlePresenterImpl_Factory.create(create7);
        this.C = create8;
        Provider<UnifiedSubtitlePresenter> provider8 = DoubleCheck.provider(create8);
        this.D = provider8;
        this.E = UnifiedSubtitleBlueprint_Factory.create(provider8);
        Provider<UnifiedTitlePresenter> provider9 = DoubleCheck.provider(UnifiedTitlePresenterImpl_Factory.create());
        this.F = provider9;
        UnifiedTitleBlueprint_Factory create9 = UnifiedTitleBlueprint_Factory.create(provider9);
        this.G = create9;
        Provider<ItemBinder> provider10 = DoubleCheck.provider(NotificationCenterLandingUnifiedModule_ProvideItemBinder$notification_center_releaseFactory.create(this.j, this.n, this.p, this.r, this.t, this.y, this.A, this.E, create9));
        this.H = provider10;
        this.I = DoubleCheck.provider(NotificationCenterLandingUnifiedModule_ProvideAdapterPresenter$notification_center_releaseFactory.create(provider10));
        this.J = new c(notificationCenterLandingUnifiedDependencies);
        h hVar = new h(notificationCenterLandingUnifiedDependencies);
        this.K = hVar;
        j jVar = new j(notificationCenterLandingUnifiedDependencies);
        this.L = jVar;
        NotificationCenterLandingUnifiedInteractorImpl_Factory create10 = NotificationCenterLandingUnifiedInteractorImpl_Factory.create(hVar, jVar);
        this.M = create10;
        this.N = DoubleCheck.provider(create10);
        e eVar = new e(notificationCenterLandingUnifiedDependencies);
        this.O = eVar;
        FavoriteStatusResolverImpl_Factory create11 = FavoriteStatusResolverImpl_Factory.create(eVar);
        this.P = create11;
        this.Q = DoubleCheck.provider(create11);
        this.R = new l(notificationCenterLandingUnifiedDependencies);
        this.S = new i(notificationCenterLandingUnifiedDependencies);
        this.T = new m(notificationCenterLandingUnifiedDependencies);
        this.U = new f(notificationCenterLandingUnifiedDependencies);
        Provider<ViewedAdvertsInteractor> provider11 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory.create(ViewedAdvertsInteractorFactoryImpl_Factory.create(), this.R, this.S, this.T, this.U));
        this.V = provider11;
        Provider<ViewedStatusResolver> provider12 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedStatusResolverFactory.create(provider11));
        this.W = provider12;
        NotificationsCenterLandingUnifiedConverterImpl_Factory create12 = NotificationsCenterLandingUnifiedConverterImpl_Factory.create(this.Q, provider12, this.U);
        this.X = create12;
        this.Y = DoubleCheck.provider(create12);
        Factory create13 = InstanceFactory.create(resources);
        this.Z = create13;
        FavoriteAdvertsResourceProviderImpl_Factory create14 = FavoriteAdvertsResourceProviderImpl_Factory.create(create13);
        this.a0 = create14;
        Provider<FavoriteAdvertsResourceProvider> provider13 = DoubleCheck.provider(create14);
        this.b0 = provider13;
        FavoriteAdvertsPresenterImpl_Factory create15 = FavoriteAdvertsPresenterImpl_Factory.create(this.O, provider13, this.S);
        this.c0 = create15;
        this.d0 = DoubleCheck.provider(create15);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.f0 = createNullable;
        NotificationCenterLandingUnifiedPresenterImpl_Factory create16 = NotificationCenterLandingUnifiedPresenterImpl_Factory.create(this.b, this.I, this.J, this.N, this.L, this.Y, this.c, this.d, this.k, this.u, this.v, this.B, this.d0, this.e0, createNullable);
        this.g0 = create16;
        this.h0 = DoubleCheck.provider(create16);
    }

    public static NotificationCenterLandingUnifiedComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedComponent
    public void inject(NotificationCenterLandingUnifiedActivity notificationCenterLandingUnifiedActivity) {
        NotificationCenterLandingUnifiedActivity_MembersInjector.injectDeepLinkIntentFactory(notificationCenterLandingUnifiedActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        NotificationCenterLandingUnifiedActivity_MembersInjector.injectPresenter(notificationCenterLandingUnifiedActivity, this.h0.get());
        NotificationCenterLandingUnifiedActivity_MembersInjector.injectItemBinder(notificationCenterLandingUnifiedActivity, this.H.get());
        NotificationCenterLandingUnifiedActivity_MembersInjector.injectAdapterPresenter(notificationCenterLandingUnifiedActivity, this.I.get());
        NotificationCenterLandingUnifiedActivity_MembersInjector.injectAnalytics(notificationCenterLandingUnifiedActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
