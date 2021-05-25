package com.avito.android.notification_center.landing.recommends.di;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractorFactoryImpl_Factory;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.db.viewed.ViewedAdvertsDao;
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
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsConverter;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsConverterImpl;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsConverterImpl_Factory;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsFragment;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsFragment_MembersInjector;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsInteractor;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsInteractorImpl;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsInteractorImpl_Factory;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsPresenter;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsPresenterImpl;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsPresenterImpl_Factory;
import com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsFragmentComponent;
import com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemBlueprint;
import com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemBlueprint_Factory;
import com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemPresenter;
import com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemPresenterImpl;
import com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemPresenterImpl_Factory;
import com.avito.android.notification_center.landing.recommends.item.header.NotificationCenterLandingRecommendsHeaderItemBlueprint;
import com.avito.android.notification_center.landing.recommends.item.header.NotificationCenterLandingRecommendsHeaderItemBlueprint_Factory;
import com.avito.android.notification_center.landing.recommends.item.header.NotificationCenterLandingRecommendsHeaderItemPresenter;
import com.avito.android.notification_center.landing.recommends.item.header.NotificationCenterLandingRecommendsHeaderItemPresenterImpl_Factory;
import com.avito.android.notification_center.landing.recommends.item.review.NotificationCenterLandingRecommendsReviewItemBlueprint;
import com.avito.android.notification_center.landing.recommends.item.review.NotificationCenterLandingRecommendsReviewItemBlueprint_Factory;
import com.avito.android.notification_center.landing.recommends.item.review.NotificationCenterLandingRecommendsReviewItemPresenter;
import com.avito.android.notification_center.landing.recommends.item.review.NotificationCenterLandingRecommendsReviewItemPresenterImpl;
import com.avito.android.notification_center.landing.recommends.item.review.NotificationCenterLandingRecommendsReviewItemPresenterImpl_Factory;
import com.avito.android.notification_center.landing.recommends.item.title.NotificationCenterLandingRecommendsTitleItemBlueprint;
import com.avito.android.notification_center.landing.recommends.item.title.NotificationCenterLandingRecommendsTitleItemBlueprint_Factory;
import com.avito.android.notification_center.landing.recommends.item.title.NotificationCenterLandingRecommendsTitleItemPresenter;
import com.avito.android.notification_center.landing.recommends.item.title.NotificationCenterLandingRecommendsTitleItemPresenterImpl;
import com.avito.android.notification_center.landing.recommends.item.title.NotificationCenterLandingRecommendsTitleItemPresenterImpl_Factory;
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
public final class DaggerNotificationCenterLandingRecommendsFragmentComponent implements NotificationCenterLandingRecommendsFragmentComponent {
    public Provider<SchedulersFactory3> A;
    public Provider<ViewedAdvertsEventInteractor> B;
    public Provider<Features> C;
    public Provider<ViewedAdvertsInteractor> D;
    public Provider<ViewedStatusResolver> E;
    public Provider<NotificationCenterLandingRecommendsConverterImpl> F;
    public Provider<NotificationCenterLandingRecommendsConverter> G;
    public Provider<NotificationsApi> H;
    public Provider<SchedulersFactory> I;
    public Provider<NotificationCenterLandingRecommendsInteractorImpl> J;
    public Provider<NotificationCenterLandingRecommendsInteractor> K;
    public Provider<Analytics> L;
    public Provider<Resources> M;
    public Provider<FavoriteAdvertsResourceProviderImpl> N;
    public Provider<FavoriteAdvertsResourceProvider> O;
    public Provider<FavoriteAdvertsPresenterImpl> P;
    public Provider<FavoriteAdvertsPresenter> Q;
    public Provider<ViewedAdvertsPresenter> R = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory.create(this.B, this.A));
    public Provider<Kundle> S;
    public Provider<NotificationCenterLandingRecommendsPresenterImpl> T;
    public Provider<NotificationCenterLandingRecommendsPresenter> U;
    public final NotificationCenterLandingRecommendsDependencies a;
    public Provider<Relay<Integer>> b;
    public Provider<Relay<FavorableItem>> c;
    public Provider<NotificationCenterLandingRecommendsAdvertItemPresenterImpl> d;
    public Provider<NotificationCenterLandingRecommendsAdvertItemPresenter> e;
    public Provider<TimeSource> f;
    public Provider<Locale> g;
    public Provider<ConnectivityProvider> h;
    public Provider<NotificationCenterLandingRecommendsAdvertItemBlueprint> i;
    public Provider<NotificationCenterLandingRecommendsHeaderItemPresenter> j;
    public Provider<NotificationCenterLandingRecommendsHeaderItemBlueprint> k;
    public Provider<Relay<Integer>> l;
    public Provider<NotificationCenterLandingRecommendsReviewItemPresenterImpl> m;
    public Provider<NotificationCenterLandingRecommendsReviewItemPresenter> n;
    public Provider<NotificationCenterLandingRecommendsReviewItemBlueprint> o;
    public Provider<Relay<Integer>> p;
    public Provider<NotificationCenterLandingRecommendsTitleItemPresenterImpl> q;
    public Provider<NotificationCenterLandingRecommendsTitleItemPresenter> r;
    public Provider<NotificationCenterLandingRecommendsTitleItemBlueprint> s;
    public Provider<ItemBinder> t;
    public Provider<AdapterPresenter> u;
    public Provider<String> v;
    public Provider<FavoriteAdvertsInteractor> w;
    public Provider<FavoriteStatusResolverImpl> x;
    public Provider<FavoriteStatusResolver> y;
    public Provider<ViewedAdvertsDao> z;

    public static final class b implements NotificationCenterLandingRecommendsFragmentComponent.Builder {
        public NotificationCenterLandingRecommendsDependencies a;
        public String b;
        public Kundle c;
        public Resources d;
        public Relay<FavorableItem> e;
        public Relay<Integer> f;
        public Relay<Integer> g;
        public Relay<Integer> h;

        public b(a aVar) {
        }

        @Override // com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsFragmentComponent.Builder
        public NotificationCenterLandingRecommendsFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, NotificationCenterLandingRecommendsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, Relay.class);
            Preconditions.checkBuilderRequirement(this.f, Relay.class);
            Preconditions.checkBuilderRequirement(this.g, Relay.class);
            Preconditions.checkBuilderRequirement(this.h, Relay.class);
            return new DaggerNotificationCenterLandingRecommendsFragmentComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
        }

        @Override // com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsFragmentComponent.Builder
        public NotificationCenterLandingRecommendsFragmentComponent.Builder dependencies(NotificationCenterLandingRecommendsDependencies notificationCenterLandingRecommendsDependencies) {
            this.a = (NotificationCenterLandingRecommendsDependencies) Preconditions.checkNotNull(notificationCenterLandingRecommendsDependencies);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsFragmentComponent.Builder
        public NotificationCenterLandingRecommendsFragmentComponent.Builder withId(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsFragmentComponent.Builder
        public NotificationCenterLandingRecommendsFragmentComponent.Builder withItemAdvertFavoriteRelay(Relay relay) {
            this.e = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsFragmentComponent.Builder
        public NotificationCenterLandingRecommendsFragmentComponent.Builder withItemAdvertRelay(Relay relay) {
            this.f = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsFragmentComponent.Builder
        public NotificationCenterLandingRecommendsFragmentComponent.Builder withItemReviewRelay(Relay relay) {
            this.g = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsFragmentComponent.Builder
        public NotificationCenterLandingRecommendsFragmentComponent.Builder withItemTitleRelay(Relay relay) {
            this.h = (Relay) Preconditions.checkNotNull(relay);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsFragmentComponent.Builder
        public NotificationCenterLandingRecommendsFragmentComponent.Builder withPresenterState(Kundle kundle) {
            this.c = kundle;
            return this;
        }

        @Override // com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsFragmentComponent.Builder
        public NotificationCenterLandingRecommendsFragmentComponent.Builder withResources(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final NotificationCenterLandingRecommendsDependencies a;

        public c(NotificationCenterLandingRecommendsDependencies notificationCenterLandingRecommendsDependencies) {
            this.a = notificationCenterLandingRecommendsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<ConnectivityProvider> {
        public final NotificationCenterLandingRecommendsDependencies a;

        public d(NotificationCenterLandingRecommendsDependencies notificationCenterLandingRecommendsDependencies) {
            this.a = notificationCenterLandingRecommendsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ConnectivityProvider get() {
            return (ConnectivityProvider) Preconditions.checkNotNullFromComponent(this.a.connectivityProvider());
        }
    }

    public static class e implements Provider<FavoriteAdvertsInteractor> {
        public final NotificationCenterLandingRecommendsDependencies a;

        public e(NotificationCenterLandingRecommendsDependencies notificationCenterLandingRecommendsDependencies) {
            this.a = notificationCenterLandingRecommendsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsInteractor get() {
            return (FavoriteAdvertsInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsInteractor());
        }
    }

    public static class f implements Provider<Features> {
        public final NotificationCenterLandingRecommendsDependencies a;

        public f(NotificationCenterLandingRecommendsDependencies notificationCenterLandingRecommendsDependencies) {
            this.a = notificationCenterLandingRecommendsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<Locale> {
        public final NotificationCenterLandingRecommendsDependencies a;

        public g(NotificationCenterLandingRecommendsDependencies notificationCenterLandingRecommendsDependencies) {
            this.a = notificationCenterLandingRecommendsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class h implements Provider<NotificationsApi> {
        public final NotificationCenterLandingRecommendsDependencies a;

        public h(NotificationCenterLandingRecommendsDependencies notificationCenterLandingRecommendsDependencies) {
            this.a = notificationCenterLandingRecommendsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationsApi get() {
            return (NotificationsApi) Preconditions.checkNotNullFromComponent(this.a.notificationsApi());
        }
    }

    public static class i implements Provider<SchedulersFactory3> {
        public final NotificationCenterLandingRecommendsDependencies a;

        public i(NotificationCenterLandingRecommendsDependencies notificationCenterLandingRecommendsDependencies) {
            this.a = notificationCenterLandingRecommendsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class j implements Provider<SchedulersFactory> {
        public final NotificationCenterLandingRecommendsDependencies a;

        public j(NotificationCenterLandingRecommendsDependencies notificationCenterLandingRecommendsDependencies) {
            this.a = notificationCenterLandingRecommendsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class k implements Provider<TimeSource> {
        public final NotificationCenterLandingRecommendsDependencies a;

        public k(NotificationCenterLandingRecommendsDependencies notificationCenterLandingRecommendsDependencies) {
            this.a = notificationCenterLandingRecommendsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class l implements Provider<ViewedAdvertsDao> {
        public final NotificationCenterLandingRecommendsDependencies a;

        public l(NotificationCenterLandingRecommendsDependencies notificationCenterLandingRecommendsDependencies) {
            this.a = notificationCenterLandingRecommendsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsDao get() {
            return (ViewedAdvertsDao) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsDao());
        }
    }

    public static class m implements Provider<ViewedAdvertsEventInteractor> {
        public final NotificationCenterLandingRecommendsDependencies a;

        public m(NotificationCenterLandingRecommendsDependencies notificationCenterLandingRecommendsDependencies) {
            this.a = notificationCenterLandingRecommendsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsEventInteractor get() {
            return (ViewedAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsEventInteractor());
        }
    }

    public DaggerNotificationCenterLandingRecommendsFragmentComponent(NotificationCenterLandingRecommendsDependencies notificationCenterLandingRecommendsDependencies, String str, Kundle kundle, Resources resources, Relay relay, Relay relay2, Relay relay3, Relay relay4, a aVar) {
        this.a = notificationCenterLandingRecommendsDependencies;
        this.b = InstanceFactory.create(relay2);
        Factory create = InstanceFactory.create(relay);
        this.c = create;
        NotificationCenterLandingRecommendsAdvertItemPresenterImpl_Factory create2 = NotificationCenterLandingRecommendsAdvertItemPresenterImpl_Factory.create(this.b, create);
        this.d = create2;
        Provider<NotificationCenterLandingRecommendsAdvertItemPresenter> provider = DoubleCheck.provider(create2);
        this.e = provider;
        k kVar = new k(notificationCenterLandingRecommendsDependencies);
        this.f = kVar;
        g gVar = new g(notificationCenterLandingRecommendsDependencies);
        this.g = gVar;
        d dVar = new d(notificationCenterLandingRecommendsDependencies);
        this.h = dVar;
        this.i = NotificationCenterLandingRecommendsAdvertItemBlueprint_Factory.create(provider, kVar, gVar, dVar);
        Provider<NotificationCenterLandingRecommendsHeaderItemPresenter> provider2 = DoubleCheck.provider(NotificationCenterLandingRecommendsHeaderItemPresenterImpl_Factory.create());
        this.j = provider2;
        this.k = NotificationCenterLandingRecommendsHeaderItemBlueprint_Factory.create(provider2);
        Factory create3 = InstanceFactory.create(relay3);
        this.l = create3;
        NotificationCenterLandingRecommendsReviewItemPresenterImpl_Factory create4 = NotificationCenterLandingRecommendsReviewItemPresenterImpl_Factory.create(create3);
        this.m = create4;
        Provider<NotificationCenterLandingRecommendsReviewItemPresenter> provider3 = DoubleCheck.provider(create4);
        this.n = provider3;
        this.o = NotificationCenterLandingRecommendsReviewItemBlueprint_Factory.create(provider3);
        Factory create5 = InstanceFactory.create(relay4);
        this.p = create5;
        NotificationCenterLandingRecommendsTitleItemPresenterImpl_Factory create6 = NotificationCenterLandingRecommendsTitleItemPresenterImpl_Factory.create(create5);
        this.q = create6;
        Provider<NotificationCenterLandingRecommendsTitleItemPresenter> provider4 = DoubleCheck.provider(create6);
        this.r = provider4;
        NotificationCenterLandingRecommendsTitleItemBlueprint_Factory create7 = NotificationCenterLandingRecommendsTitleItemBlueprint_Factory.create(provider4);
        this.s = create7;
        Provider<ItemBinder> provider5 = DoubleCheck.provider(NotificationCenterLandingRecommendsFragmentModule_ProvideItemBinderFactory.create(this.i, this.k, this.o, create7));
        this.t = provider5;
        this.u = DoubleCheck.provider(NotificationCenterLandingRecommendsFragmentModule_ProvideAdapterPresenterFactory.create(provider5));
        this.v = InstanceFactory.create(str);
        e eVar = new e(notificationCenterLandingRecommendsDependencies);
        this.w = eVar;
        FavoriteStatusResolverImpl_Factory create8 = FavoriteStatusResolverImpl_Factory.create(eVar);
        this.x = create8;
        this.y = DoubleCheck.provider(create8);
        this.z = new l(notificationCenterLandingRecommendsDependencies);
        this.A = new i(notificationCenterLandingRecommendsDependencies);
        this.B = new m(notificationCenterLandingRecommendsDependencies);
        this.C = new f(notificationCenterLandingRecommendsDependencies);
        Provider<ViewedAdvertsInteractor> provider6 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory.create(ViewedAdvertsInteractorFactoryImpl_Factory.create(), this.z, this.A, this.B, this.C));
        this.D = provider6;
        Provider<ViewedStatusResolver> provider7 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedStatusResolverFactory.create(provider6));
        this.E = provider7;
        NotificationCenterLandingRecommendsConverterImpl_Factory create9 = NotificationCenterLandingRecommendsConverterImpl_Factory.create(this.y, provider7, this.C);
        this.F = create9;
        this.G = DoubleCheck.provider(create9);
        h hVar = new h(notificationCenterLandingRecommendsDependencies);
        this.H = hVar;
        j jVar = new j(notificationCenterLandingRecommendsDependencies);
        this.I = jVar;
        NotificationCenterLandingRecommendsInteractorImpl_Factory create10 = NotificationCenterLandingRecommendsInteractorImpl_Factory.create(hVar, jVar);
        this.J = create10;
        this.K = DoubleCheck.provider(create10);
        this.L = new c(notificationCenterLandingRecommendsDependencies);
        Factory create11 = InstanceFactory.create(resources);
        this.M = create11;
        FavoriteAdvertsResourceProviderImpl_Factory create12 = FavoriteAdvertsResourceProviderImpl_Factory.create(create11);
        this.N = create12;
        Provider<FavoriteAdvertsResourceProvider> provider8 = DoubleCheck.provider(create12);
        this.O = provider8;
        FavoriteAdvertsPresenterImpl_Factory create13 = FavoriteAdvertsPresenterImpl_Factory.create(this.w, provider8, this.A);
        this.P = create13;
        this.Q = DoubleCheck.provider(create13);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.S = createNullable;
        NotificationCenterLandingRecommendsPresenterImpl_Factory create14 = NotificationCenterLandingRecommendsPresenterImpl_Factory.create(this.v, this.G, this.K, this.b, this.c, this.l, this.p, this.u, this.L, this.Q, this.R, this.I, createNullable);
        this.T = create14;
        this.U = DoubleCheck.provider(create14);
    }

    public static NotificationCenterLandingRecommendsFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsFragmentComponent
    public void inject(NotificationCenterLandingRecommendsFragment notificationCenterLandingRecommendsFragment) {
        NotificationCenterLandingRecommendsFragment_MembersInjector.injectAdapterPresenter(notificationCenterLandingRecommendsFragment, this.u.get());
        NotificationCenterLandingRecommendsFragment_MembersInjector.injectItemBinder(notificationCenterLandingRecommendsFragment, this.t.get());
        NotificationCenterLandingRecommendsFragment_MembersInjector.injectPresenter(notificationCenterLandingRecommendsFragment, this.U.get());
        NotificationCenterLandingRecommendsFragment_MembersInjector.injectViewedAdvertsPresenter(notificationCenterLandingRecommendsFragment, this.R.get());
        NotificationCenterLandingRecommendsFragment_MembersInjector.injectAnalytics(notificationCenterLandingRecommendsFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
