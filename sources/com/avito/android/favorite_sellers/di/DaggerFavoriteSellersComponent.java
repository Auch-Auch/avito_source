package com.avito.android.favorite_sellers.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import androidx.core.app.NotificationManagerCompat;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractorFactoryImpl_Factory;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl_Factory;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.common.CounterInteractor;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.connection_quality.connectivity.ConnectivityProviderImpl;
import com.avito.android.connection_quality.connectivity.ConnectivityProviderImpl_Factory;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedStatusResolverFactory;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideAdvertConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideFavoriteStatusResolverFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.dialog.DialogPresenterImpl;
import com.avito.android.dialog.DialogPresenterImpl_Factory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.events.notifications_settings.NotificationSettingsChangeEvent;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl_Factory;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.favorite.FavoriteAdvertsUploadInteractor;
import com.avito.android.favorite_sellers.FavoriteSellerAdvertsStatusProcessor;
import com.avito.android.favorite_sellers.FavoriteSellerAdvertsStatusProcessorImpl;
import com.avito.android.favorite_sellers.FavoriteSellerAdvertsStatusProcessorImpl_Factory;
import com.avito.android.favorite_sellers.FavoriteSellersConverter;
import com.avito.android.favorite_sellers.FavoriteSellersConverterImpl;
import com.avito.android.favorite_sellers.FavoriteSellersConverterImpl_Factory;
import com.avito.android.favorite_sellers.FavoriteSellersFragment;
import com.avito.android.favorite_sellers.FavoriteSellersFragment_MembersInjector;
import com.avito.android.favorite_sellers.FavoriteSellersInteractor;
import com.avito.android.favorite_sellers.FavoriteSellersInteractorImpl;
import com.avito.android.favorite_sellers.FavoriteSellersInteractorImpl_Factory;
import com.avito.android.favorite_sellers.FavoriteSellersPresenter;
import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl_Factory;
import com.avito.android.favorite_sellers.FavoriteSellersResourceProvider;
import com.avito.android.favorite_sellers.FavoriteSellersResourceProviderImpl;
import com.avito.android.favorite_sellers.FavoriteSellersResourceProviderImpl_Factory;
import com.avito.android.favorite_sellers.ScreenMode;
import com.avito.android.favorite_sellers.TabOpenAnalytics;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemBlueprint;
import com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemBlueprint_Factory;
import com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemPresenter;
import com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemPresenterImpl;
import com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemPresenterImpl_Factory;
import com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts.OtherAdvertsItemBlueprint;
import com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts.OtherAdvertsItemBlueprint_Factory;
import com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts.OtherAdvertsItemPresenterImpl;
import com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts.OtherAdvertsItemPresenterImpl_Factory;
import com.avito.android.favorite_sellers.adapter.advert_list.di.AdvertListItemModule_ProvideAdapterPresenterFactory;
import com.avito.android.favorite_sellers.adapter.advert_list.di.AdvertListItemModule_ProvideFavoriteAdvertsPresenterFactory;
import com.avito.android.favorite_sellers.adapter.advert_list.di.AdvertListItemModule_ProvideItemBinderFactory;
import com.avito.android.favorite_sellers.adapter.advert_list.di.AdvertListItemModule_ProvideItemBlueprintsFactory;
import com.avito.android.favorite_sellers.adapter.advert_list.di.AdvertListItemModule_ProvideViewedAdvertsPresenterFactory;
import com.avito.android.favorite_sellers.adapter.error.ErrorItemBlueprint;
import com.avito.android.favorite_sellers.adapter.error.ErrorItemBlueprint_Factory;
import com.avito.android.favorite_sellers.adapter.error.ErrorItemPresenterImpl;
import com.avito.android.favorite_sellers.adapter.error.ErrorItemPresenterImpl_Factory;
import com.avito.android.favorite_sellers.adapter.info.InfoItemBlueprint;
import com.avito.android.favorite_sellers.adapter.info.InfoItemBlueprint_Factory;
import com.avito.android.favorite_sellers.adapter.info.InfoItemPresenterImpl_Factory;
import com.avito.android.favorite_sellers.adapter.loading.LoadingItemBlueprint;
import com.avito.android.favorite_sellers.adapter.loading.LoadingItemBlueprint_Factory;
import com.avito.android.favorite_sellers.adapter.loading.LoadingItemPresenterImpl;
import com.avito.android.favorite_sellers.adapter.loading.LoadingItemPresenterImpl_Factory;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemBlueprint;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemBlueprint_Factory;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenterImpl;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenterImpl_Factory;
import com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemBlueprint;
import com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemBlueprint_Factory;
import com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemPresenterImpl;
import com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemPresenterImpl_Factory;
import com.avito.android.favorite_sellers.adapter.recommendation.di.RecommendationItemModule_ProvideAdapterPresenterFactory;
import com.avito.android.favorite_sellers.adapter.recommendation.di.RecommendationItemModule_ProvideItemBinderFactory;
import com.avito.android.favorite_sellers.adapter.seller.SellerItemBlueprint;
import com.avito.android.favorite_sellers.adapter.seller.SellerItemBlueprint_Factory;
import com.avito.android.favorite_sellers.adapter.seller.SellerItemPresenter;
import com.avito.android.favorite_sellers.adapter.seller.SellerItemPresenterImpl;
import com.avito.android.favorite_sellers.adapter.seller.SellerItemPresenterImpl_Factory;
import com.avito.android.favorite_sellers.di.FavoriteSellersComponent;
import com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractor;
import com.avito.android.favorite_sellers.interactor.FavoriteSellersSyncInteractor;
import com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor;
import com.avito.android.favorite_sellers.tracker.FavoriteSellersTrackersModule_ProvideScreenFactory;
import com.avito.android.favorite_sellers.tracker.sellers.SellersTrackerModule_ProvideContentTrackerFactory;
import com.avito.android.favorite_sellers.tracker.sellers.SellersTrackerModule_ProvideContentTrackerToSetFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarModule_ProvideCompositeSnackbarPresenterFactory;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerModule;
import com.avito.android.notification_manager_provider.NotificationManagerModule_ProvideNotificationManagerProviderFactory;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.performance.ContentTracker;
import com.avito.android.performance.DiInjectTracker;
import com.avito.android.performance.DiInjectTrackerImpl;
import com.avito.android.performance.DiInjectTrackerImpl_Factory;
import com.avito.android.performance.InitTracker;
import com.avito.android.performance.InitTracker_Factory;
import com.avito.android.performance.ScreenTracker;
import com.avito.android.performance.ScreenTrackerImpl;
import com.avito.android.performance.ScreenTrackerImpl_Factory;
import com.avito.android.performance.SimpleTracker;
import com.avito.android.performance.di.PerformanceTrackersModule_ProvideContentTrackersFactory;
import com.avito.android.performance.di.PerformanceTrackersModule_ProvidesScreenDiInjectTracker$tns_core_releaseFactory;
import com.avito.android.performance.di.PerformanceTrackersModule_ProvidesScreenFlowTrackerProviderFactory;
import com.avito.android.performance.di.PerformanceTrackersModule_ProvidesScreenInitTrackerFactory;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.section.SectionResourceProvider;
import com.avito.android.section.SectionResourceProviderImpl;
import com.avito.android.section.SectionResourceProviderImpl_Factory;
import com.avito.android.section.di.SectionAdvertItemsModule_ProvideSectionAdvertItemPresenter$serp_core_releaseFactory;
import com.avito.android.section.di.SectionAdvertItemsModule_ProvideSectionItemWidthProvider$serp_core_releaseFactory;
import com.avito.android.section.item.SectionAdvertItemBlueprintImpl;
import com.avito.android.section.item.SectionAdvertItemBlueprintImpl_Factory;
import com.avito.android.section.item.SectionAdvertItemDoubleBlueprintImpl;
import com.avito.android.section.item.SectionAdvertItemDoubleBlueprintImpl_Factory;
import com.avito.android.section.item.SectionAdvertItemPresenter;
import com.avito.android.section.item.SectionItemWidthProvider;
import com.avito.android.serp.adapter.AdvertSpanCountProvider;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Locale;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerFavoriteSellersComponent implements FavoriteSellersComponent {
    public Provider<Observable<FavoriteSellersItemAction>> A;
    public Provider<ConnectivityProvider> A0;
    public Provider<Resources> B;
    public Provider<Observable<NotificationSettingsChangeEvent>> B0;
    public Provider<FavoriteSellersResourceProviderImpl> C;
    public Provider<CompositeSnackbarPresenter> C0;
    public Provider<FavoriteSellersResourceProvider> D;
    public Provider<FavoriteSellersPresenterImpl> D0;
    public Provider<AdvertSpanCountProvider> E;
    public Provider<FavoriteSellersPresenter> E0;
    public Provider<AdvertSpanCountProvider> F;
    public Provider<DeviceMetrics> F0;
    public Provider<SerpAdvertConverter> G;
    public Provider<SectionResourceProviderImpl> G0;
    public Provider<FavoritesSyncDao> H;
    public Provider<SectionResourceProvider> H0;
    public Provider<FavoriteAdvertsUploadInteractor> I;
    public Provider<SectionItemWidthProvider> I0;
    public Provider<FavoriteAdvertsEventInteractor> J;
    public Provider<SectionAdvertItemPresenter> J0;
    public Provider<Analytics> K;
    public Provider<TimeSource> K0;
    public Provider<FavoriteAdvertsAnalyticsInteractorImpl> L;
    public Provider<Locale> L0;
    public Provider<FavoriteAdvertsInteractorImpl> M;
    public Provider<SectionAdvertItemBlueprintImpl> M0;
    public Provider<FavoriteStatusResolver> N;
    public Provider<SectionAdvertItemDoubleBlueprintImpl> N0;
    public Provider<ViewedAdvertsDao> O;
    public Provider<Consumer<FavoriteSellersItemAction>> O0;
    public Provider<ViewedAdvertsEventInteractor> P;
    public Provider<OtherAdvertsItemPresenterImpl> P0;
    public Provider<ViewedAdvertsInteractor> Q;
    public Provider<OtherAdvertsItemBlueprint> Q0;
    public Provider<ViewedStatusResolver> R;
    public Provider<Set<ItemBlueprint<?, ?>>> R0;
    public Provider<FavoriteSellersConverterImpl> S;
    public Provider<ItemBinder> S0;
    public Provider<FavoriteSellersConverter> T;
    public Provider<AdapterPresenter> T0;
    public Provider<FavoriteSellerAdvertsStatusProcessorImpl> U;
    public Provider<FavoriteAdvertsPresenter> U0;
    public Provider<FavoriteSellerAdvertsStatusProcessor> V;
    public Provider<ViewedAdvertsPresenter> V0;
    public Provider<Activity> W;
    public Provider<AdvertListItemBlueprint> W0;
    public Provider<DialogRouter> X;
    public Provider<ItemBlueprint<?, ?>> X0;
    public Provider<DialogPresenterImpl> Y;
    public Provider<SellerItemPresenterImpl> Y0;
    public Provider<DialogPresenter> Z;
    public Provider<SellerItemPresenter> Z0;
    public final FavoriteSellersDependencies a;
    public Provider<ErrorFormatterImpl> a0;
    public Provider<SellerItemBlueprint> a1;
    public Provider<Set<ItemBlueprint<?, ?>>> b = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<ErrorFormatter> b0;
    public Provider<ItemBlueprint<?, ?>> b1;
    public Provider<Kundle> c;
    public Provider<ErrorHelperImpl> c0;
    public Provider<ErrorItemPresenterImpl> c1;
    public Provider<AdvertListItemPresenterImpl> d;
    public Provider<ErrorHelper> d0;
    public Provider<ErrorItemBlueprint> d1;
    public Provider<AdvertListItemPresenter> e;
    public Provider<ScreenTrackerFactory> e0;
    public Provider<InfoItemBlueprint> e1;
    public Provider<Set<ItemBlueprint<?, ?>>> f;
    public Provider<TimerFactory> f0;
    public Provider<SubscriptionSource> f1;
    public Provider<Boolean> g;
    public Provider<ScreenDiInjectTracker> g0;
    public Provider<Kundle> g1;
    public Provider<String> h;
    public Provider<DiInjectTrackerImpl> h0;
    public Provider<RecommendationItemPresenterImpl> h1;
    public Provider<String> i;
    public Provider<DiInjectTracker> i0;
    public Provider<RecommendationItemPresenter> i1;
    public Provider<SchedulersFactory3> j;
    public Provider<ScreenInitTracker> j0;
    public Provider<SellerCarouselItemPresenterImpl> j1;
    public Provider<AccountStateProvider> k;
    public Provider<InitTracker> k0;
    public Provider<SellerCarouselItemBlueprint> k1;
    public Provider<FavoriteSellersApi> l;
    public Provider<SimpleTracker> l0;
    public Provider<Set<ItemBlueprint<?, ?>>> l1;
    public Provider<FavoriteSellersReadInteractor> m;
    public Provider<Set<ContentTracker>> m0;
    public Provider<ItemBinder> m1;
    public Provider<CounterInteractor> n;
    public Provider<ScreenFlowTrackerProvider> n0;
    public Provider<AdapterPresenter> n1;
    public Provider<Application> o;
    public Provider<ContentTracker> o0;
    public Provider<RecommendationItemBlueprint> o1;
    public Provider<NotificationManagerCompat> p;
    public Provider<ContentTracker> p0;
    public Provider<LoadingItemPresenterImpl> p1;
    public Provider<NotificationManagerProvider> q;
    public Provider<Set<ContentTracker>> q0;
    public Provider<LoadingItemBlueprint> q1;
    public Provider<Features> r;
    public Provider<ScreenTrackerImpl> r0;
    public Provider<Set<ItemBlueprint<?, ?>>> r1;
    public Provider<FavoriteSellersWriteInteractor> s;
    public Provider<ScreenTracker> s0;
    public Provider<ItemBinder> s1;
    public Provider<FavoriteSellersRepository> t;
    public Provider<TabOpenAnalytics> t0;
    public Provider<CallableResponsiveItemPresenterRegistry> t1;
    public Provider<FavoriteSellersSyncInteractor> u;
    public Provider<FavoriteAdvertsResourceProvider> u0;
    public Provider<ResponsiveAdapterPresenter> u1;
    public Provider<ScreenMode> v;
    public Provider<FavoriteAdvertsPresenter> v0;
    public Provider<DestroyableViewHolderBuilder> v1;
    public Provider<FavoriteSellersInteractorImpl> w;
    public Provider<Kundle> w0;
    public Provider<FavoriteSellersInteractor> x;
    public Provider<Context> x0;
    public Provider<AdapterPresenter> y;
    public Provider<SchedulersFactory> y0;
    public Provider<PublishRelay<FavoriteSellersItemAction>> z;
    public Provider<ConnectivityProviderImpl> z0;

    public static final class b implements FavoriteSellersComponent.Builder {
        public FavoriteSellersDependencies a;
        public Kundle b;
        public Boolean c;
        public String d;
        public String e;
        public Kundle f;
        public Kundle g;
        public Activity h;
        public Resources i;
        public PublishRelay<FavoriteSellersItemAction> j;
        public SubscriptionSource k;
        public SerpOnboardingHandler l;

        public b(a aVar) {
        }

        @Override // com.avito.android.favorite_sellers.di.FavoriteSellersComponent.Builder
        public FavoriteSellersComponent build() {
            Preconditions.checkBuilderRequirement(this.a, FavoriteSellersDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Boolean.class);
            Preconditions.checkBuilderRequirement(this.e, String.class);
            Preconditions.checkBuilderRequirement(this.h, Activity.class);
            Preconditions.checkBuilderRequirement(this.i, Resources.class);
            Preconditions.checkBuilderRequirement(this.j, PublishRelay.class);
            Preconditions.checkBuilderRequirement(this.k, SubscriptionSource.class);
            return new DaggerFavoriteSellersComponent(new NotificationManagerModule(), this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, null);
        }

        @Override // com.avito.android.favorite_sellers.di.FavoriteSellersComponent.Builder
        public FavoriteSellersComponent.Builder dependentOn(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = (FavoriteSellersDependencies) Preconditions.checkNotNull(favoriteSellersDependencies);
            return this;
        }

        @Override // com.avito.android.favorite_sellers.di.FavoriteSellersComponent.Builder
        public FavoriteSellersComponent.Builder with(Kundle kundle) {
            this.b = kundle;
            return this;
        }

        @Override // com.avito.android.favorite_sellers.di.FavoriteSellersComponent.Builder
        public FavoriteSellersComponent.Builder withAdvertListItemPresenterState(Kundle kundle) {
            this.f = kundle;
            return this;
        }

        @Override // com.avito.android.favorite_sellers.di.FavoriteSellersComponent.Builder
        public FavoriteSellersComponent.Builder withAnalyticsRecommendationSource(SubscriptionSource subscriptionSource) {
            this.k = (SubscriptionSource) Preconditions.checkNotNull(subscriptionSource);
            return this;
        }

        @Override // com.avito.android.favorite_sellers.di.FavoriteSellersComponent.Builder
        public FavoriteSellersComponent.Builder withDataType(String str) {
            this.e = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.favorite_sellers.di.FavoriteSellersComponent.Builder
        public FavoriteSellersComponent.Builder withRecommendationPresenterState(Kundle kundle) {
            this.g = kundle;
            return this;
        }

        @Override // com.avito.android.favorite_sellers.di.FavoriteSellersComponent.Builder
        public FavoriteSellersComponent.Builder withSerpOnboardingHandler(SerpOnboardingHandler serpOnboardingHandler) {
            this.l = null;
            return this;
        }

        @Override // com.avito.android.favorite_sellers.di.FavoriteSellersComponent.Builder
        public FavoriteSellersComponent.Builder withUserKey(String str) {
            this.d = str;
            return this;
        }

        @Override // com.avito.android.favorite_sellers.di.FavoriteSellersComponent.Builder
        public FavoriteSellersComponent.Builder with(boolean z) {
            this.c = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.favorite_sellers.di.FavoriteSellersComponent.Builder
        public FavoriteSellersComponent.Builder with(Activity activity) {
            this.h = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.favorite_sellers.di.FavoriteSellersComponent.Builder
        public FavoriteSellersComponent.Builder with(Resources resources) {
            this.i = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.favorite_sellers.di.FavoriteSellersComponent.Builder
        public FavoriteSellersComponent.Builder with(PublishRelay publishRelay) {
            this.j = (PublishRelay) Preconditions.checkNotNull(publishRelay);
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final FavoriteSellersDependencies a;

        public c(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final FavoriteSellersDependencies a;

        public d(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<Application> {
        public final FavoriteSellersDependencies a;

        public e(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class f implements Provider<Context> {
        public final FavoriteSellersDependencies a;

        public f(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class g implements Provider<DeviceMetrics> {
        public final FavoriteSellersDependencies a;

        public g(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceMetrics get() {
            return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
        }
    }

    public static class h implements Provider<FavoriteAdvertsEventInteractor> {
        public final FavoriteSellersDependencies a;

        public h(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsEventInteractor get() {
            return (FavoriteAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsEventInteractor());
        }
    }

    public static class i implements Provider<FavoriteAdvertsUploadInteractor> {
        public final FavoriteSellersDependencies a;

        public i(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsUploadInteractor get() {
            return (FavoriteAdvertsUploadInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsUploadInteractor());
        }
    }

    public static class j implements Provider<FavoriteSellersApi> {
        public final FavoriteSellersDependencies a;

        public j(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteSellersApi get() {
            return (FavoriteSellersApi) Preconditions.checkNotNullFromComponent(this.a.favoriteSellersApi());
        }
    }

    public static class k implements Provider<CounterInteractor> {
        public final FavoriteSellersDependencies a;

        public k(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CounterInteractor get() {
            return (CounterInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteSellersCounterProvider());
        }
    }

    public static class l implements Provider<FavoriteSellersRepository> {
        public final FavoriteSellersDependencies a;

        public l(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteSellersRepository get() {
            return (FavoriteSellersRepository) Preconditions.checkNotNullFromComponent(this.a.favoriteSellersRepository());
        }
    }

    public static class m implements Provider<FavoritesSyncDao> {
        public final FavoriteSellersDependencies a;

        public m(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesSyncDao get() {
            return (FavoritesSyncDao) Preconditions.checkNotNullFromComponent(this.a.favoritesSyncDao());
        }
    }

    public static class n implements Provider<Features> {
        public final FavoriteSellersDependencies a;

        public n(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class o implements Provider<Locale> {
        public final FavoriteSellersDependencies a;

        public o(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class p implements Provider<Observable<NotificationSettingsChangeEvent>> {
        public final FavoriteSellersDependencies a;

        public p(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Observable<NotificationSettingsChangeEvent> get() {
            return (Observable) Preconditions.checkNotNullFromComponent(this.a.notificationSettingsObservable());
        }
    }

    public static class q implements Provider<SchedulersFactory3> {
        public final FavoriteSellersDependencies a;

        public q(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class r implements Provider<SchedulersFactory> {
        public final FavoriteSellersDependencies a;

        public r(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class s implements Provider<ScreenTrackerFactory> {
        public final FavoriteSellersDependencies a;

        public s(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class t implements Provider<TimeSource> {
        public final FavoriteSellersDependencies a;

        public t(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class u implements Provider<TimerFactory> {
        public final FavoriteSellersDependencies a;

        public u(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class v implements Provider<ViewedAdvertsDao> {
        public final FavoriteSellersDependencies a;

        public v(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsDao get() {
            return (ViewedAdvertsDao) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsDao());
        }
    }

    public static class w implements Provider<ViewedAdvertsEventInteractor> {
        public final FavoriteSellersDependencies a;

        public w(FavoriteSellersDependencies favoriteSellersDependencies) {
            this.a = favoriteSellersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsEventInteractor get() {
            return (ViewedAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsEventInteractor());
        }
    }

    public DaggerFavoriteSellersComponent(NotificationManagerModule notificationManagerModule, FavoriteSellersDependencies favoriteSellersDependencies, Kundle kundle, Boolean bool, String str, String str2, Kundle kundle2, Kundle kundle3, Activity activity, Resources resources, PublishRelay publishRelay, SubscriptionSource subscriptionSource, SerpOnboardingHandler serpOnboardingHandler, a aVar) {
        this.a = favoriteSellersDependencies;
        Factory createNullable = InstanceFactory.createNullable(kundle2);
        this.c = createNullable;
        AdvertListItemPresenterImpl_Factory create = AdvertListItemPresenterImpl_Factory.create(createNullable);
        this.d = create;
        this.e = DoubleCheck.provider(create);
        this.f = DoubleCheck.provider(AdvertListItemModule_ProvideItemBlueprintsFactory.create());
        this.g = InstanceFactory.create(bool);
        this.h = InstanceFactory.createNullable(str);
        Factory create2 = InstanceFactory.create(str2);
        this.i = create2;
        q qVar = new q(favoriteSellersDependencies);
        this.j = qVar;
        c cVar = new c(favoriteSellersDependencies);
        this.k = cVar;
        j jVar = new j(favoriteSellersDependencies);
        this.l = jVar;
        this.m = DoubleCheck.provider(FavoriteSellersModule_ProvideFavoriteSellersReadInteractor$favorite_sellers_releaseFactory.create(this.h, create2, qVar, cVar, jVar));
        this.n = new k(favoriteSellersDependencies);
        e eVar = new e(favoriteSellersDependencies);
        this.o = eVar;
        Provider<NotificationManagerCompat> provider = DoubleCheck.provider(FavoriteSellersModule_ProvideNotificationManager$favorite_sellers_releaseFactory.create(eVar));
        this.p = provider;
        NotificationManagerModule_ProvideNotificationManagerProviderFactory create3 = NotificationManagerModule_ProvideNotificationManagerProviderFactory.create(notificationManagerModule, provider);
        this.q = create3;
        n nVar = new n(favoriteSellersDependencies);
        this.r = nVar;
        this.s = DoubleCheck.provider(FavoriteSellersModule_ProvideFavoriteSellersWriteInteractor$favorite_sellers_releaseFactory.create(this.j, this.n, this.l, create3, nVar));
        l lVar = new l(favoriteSellersDependencies);
        this.t = lVar;
        Provider<FavoriteSellersSyncInteractor> provider2 = DoubleCheck.provider(FavoriteSellersModule_ProvideFavoriteSellersSyncInteractor$favorite_sellers_releaseFactory.create(lVar));
        this.u = provider2;
        Provider<ScreenMode> provider3 = DoubleCheck.provider(FavoriteSellersModule_ProvideScreenMode$favorite_sellers_releaseFactory.create(this.g, this.m, this.s, provider2));
        this.v = provider3;
        FavoriteSellersInteractorImpl_Factory create4 = FavoriteSellersInteractorImpl_Factory.create(provider3);
        this.w = create4;
        this.x = DoubleCheck.provider(create4);
        this.y = new DelegateFactory();
        Factory create5 = InstanceFactory.create(publishRelay);
        this.z = create5;
        this.A = DoubleCheck.provider(create5);
        Factory create6 = InstanceFactory.create(resources);
        this.B = create6;
        FavoriteSellersResourceProviderImpl_Factory create7 = FavoriteSellersResourceProviderImpl_Factory.create(create6);
        this.C = create7;
        this.D = DoubleCheck.provider(create7);
        this.E = SingleCheck.provider(SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory.create(this.B));
        Provider<AdvertSpanCountProvider> provider4 = SingleCheck.provider(SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory.create(this.B));
        this.F = provider4;
        this.G = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertConverterFactory.create(this.E, provider4, this.B, this.r));
        this.H = new m(favoriteSellersDependencies);
        this.I = new i(favoriteSellersDependencies);
        this.J = new h(favoriteSellersDependencies);
        d dVar = new d(favoriteSellersDependencies);
        this.K = dVar;
        FavoriteAdvertsAnalyticsInteractorImpl_Factory create8 = FavoriteAdvertsAnalyticsInteractorImpl_Factory.create(dVar, this.k);
        this.L = create8;
        FavoriteAdvertsInteractorImpl_Factory create9 = FavoriteAdvertsInteractorImpl_Factory.create(this.H, this.I, this.J, create8, this.j);
        this.M = create9;
        this.N = SingleCheck.provider(SerpItemConverterModule_ProvideFavoriteStatusResolverFactory.create(create9));
        this.O = new v(favoriteSellersDependencies);
        this.P = new w(favoriteSellersDependencies);
        Provider<ViewedAdvertsInteractor> provider5 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory.create(ViewedAdvertsInteractorFactoryImpl_Factory.create(), this.O, this.j, this.P, this.r));
        this.Q = provider5;
        Provider<ViewedStatusResolver> provider6 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedStatusResolverFactory.create(provider5));
        this.R = provider6;
        FavoriteSellersConverterImpl_Factory create10 = FavoriteSellersConverterImpl_Factory.create(this.G, this.N, provider6);
        this.S = create10;
        this.T = DoubleCheck.provider(create10);
        FavoriteSellerAdvertsStatusProcessorImpl_Factory create11 = FavoriteSellerAdvertsStatusProcessorImpl_Factory.create(this.N, this.R);
        this.U = create11;
        this.V = DoubleCheck.provider(create11);
        Factory create12 = InstanceFactory.create(activity);
        this.W = create12;
        Provider<DialogRouter> provider7 = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create12));
        this.X = provider7;
        DialogPresenterImpl_Factory create13 = DialogPresenterImpl_Factory.create(this.W, provider7);
        this.Y = create13;
        this.Z = SingleCheck.provider(create13);
        ErrorFormatterImpl_Factory create14 = ErrorFormatterImpl_Factory.create(this.B);
        this.a0 = create14;
        Provider<ErrorFormatter> provider8 = SingleCheck.provider(create14);
        this.b0 = provider8;
        ErrorHelperImpl_Factory create15 = ErrorHelperImpl_Factory.create(provider8);
        this.c0 = create15;
        this.d0 = SingleCheck.provider(create15);
        s sVar = new s(favoriteSellersDependencies);
        this.e0 = sVar;
        u uVar = new u(favoriteSellersDependencies);
        this.f0 = uVar;
        Provider<ScreenDiInjectTracker> provider9 = SingleCheck.provider(PerformanceTrackersModule_ProvidesScreenDiInjectTracker$tns_core_releaseFactory.create(sVar, uVar, FavoriteSellersTrackersModule_ProvideScreenFactory.create()));
        this.g0 = provider9;
        DiInjectTrackerImpl_Factory create16 = DiInjectTrackerImpl_Factory.create(provider9);
        this.h0 = create16;
        this.i0 = SingleCheck.provider(create16);
        Provider<ScreenInitTracker> provider10 = SingleCheck.provider(PerformanceTrackersModule_ProvidesScreenInitTrackerFactory.create(this.e0, this.f0, FavoriteSellersTrackersModule_ProvideScreenFactory.create()));
        this.j0 = provider10;
        InitTracker_Factory create17 = InitTracker_Factory.create(provider10);
        this.k0 = create17;
        this.l0 = SingleCheck.provider(create17);
        this.m0 = SingleCheck.provider(PerformanceTrackersModule_ProvideContentTrackersFactory.create());
        Provider<ScreenFlowTrackerProvider> provider11 = SingleCheck.provider(PerformanceTrackersModule_ProvidesScreenFlowTrackerProviderFactory.create(this.e0, this.f0, FavoriteSellersTrackersModule_ProvideScreenFactory.create()));
        this.n0 = provider11;
        Provider<ContentTracker> provider12 = SingleCheck.provider(SellersTrackerModule_ProvideContentTrackerFactory.create(provider11));
        this.o0 = provider12;
        this.p0 = SingleCheck.provider(SellersTrackerModule_ProvideContentTrackerToSetFactory.create(provider12));
        SetFactory build = SetFactory.builder(1, 1).addCollectionProvider(this.m0).addProvider(this.p0).build();
        this.q0 = build;
        ScreenTrackerImpl_Factory create18 = ScreenTrackerImpl_Factory.create(this.i0, this.l0, build);
        this.r0 = create18;
        this.s0 = SingleCheck.provider(create18);
        this.t0 = DoubleCheck.provider(FavoriteSellersModule_ProvideTabOpenAnalyrics$favorite_sellers_releaseFactory.create(this.K, this.v));
        Provider<FavoriteAdvertsResourceProvider> provider13 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory.create(this.B));
        this.u0 = provider13;
        this.v0 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory.create(this.M, this.j, provider13));
        this.w0 = InstanceFactory.createNullable(kundle);
        f fVar = new f(favoriteSellersDependencies);
        this.x0 = fVar;
        r rVar = new r(favoriteSellersDependencies);
        this.y0 = rVar;
        ConnectivityProviderImpl_Factory create19 = ConnectivityProviderImpl_Factory.create(fVar, rVar);
        this.z0 = create19;
        this.A0 = SingleCheck.provider(create19);
        this.B0 = new p(favoriteSellersDependencies);
        Provider<CompositeSnackbarPresenter> provider14 = SingleCheck.provider(CompositeSnackbarModule_ProvideCompositeSnackbarPresenterFactory.create());
        this.C0 = provider14;
        FavoriteSellersPresenterImpl_Factory create20 = FavoriteSellersPresenterImpl_Factory.create(this.x, this.y, this.A, this.j, this.D, this.q, this.T, this.V, this.k, this.Z, this.d0, this.s0, this.v, this.K, this.t0, this.o0, this.v0, this.w0, this.A0, this.B0, provider14, this.r);
        this.D0 = create20;
        this.E0 = DoubleCheck.provider(create20);
        this.F0 = new g(favoriteSellersDependencies);
        SectionResourceProviderImpl_Factory create21 = SectionResourceProviderImpl_Factory.create(this.B);
        this.G0 = create21;
        Provider<SectionResourceProvider> provider15 = SingleCheck.provider(create21);
        this.H0 = provider15;
        Provider<SectionItemWidthProvider> provider16 = SingleCheck.provider(SectionAdvertItemsModule_ProvideSectionItemWidthProvider$serp_core_releaseFactory.create(this.F0, provider15));
        this.I0 = provider16;
        Provider<SectionAdvertItemPresenter> provider17 = SingleCheck.provider(SectionAdvertItemsModule_ProvideSectionAdvertItemPresenter$serp_core_releaseFactory.create(this.E0, provider16));
        this.J0 = provider17;
        t tVar = new t(favoriteSellersDependencies);
        this.K0 = tVar;
        o oVar = new o(favoriteSellersDependencies);
        this.L0 = oVar;
        this.M0 = SectionAdvertItemBlueprintImpl_Factory.create(provider17, tVar, oVar, this.A0);
        this.N0 = SectionAdvertItemDoubleBlueprintImpl_Factory.create(this.J0, this.K0, this.L0, this.A0);
        Provider<Consumer<FavoriteSellersItemAction>> provider18 = DoubleCheck.provider(this.z);
        this.O0 = provider18;
        OtherAdvertsItemPresenterImpl_Factory create22 = OtherAdvertsItemPresenterImpl_Factory.create(provider18, this.I0);
        this.P0 = create22;
        this.Q0 = OtherAdvertsItemBlueprint_Factory.create(create22);
        SetFactory build2 = SetFactory.builder(3, 1).addCollectionProvider(this.f).addProvider(this.M0).addProvider(this.N0).addProvider(this.Q0).build();
        this.R0 = build2;
        Provider<ItemBinder> provider19 = DoubleCheck.provider(AdvertListItemModule_ProvideItemBinderFactory.create(build2));
        this.S0 = provider19;
        this.T0 = AdvertListItemModule_ProvideAdapterPresenterFactory.create(provider19);
        this.U0 = AdvertListItemModule_ProvideFavoriteAdvertsPresenterFactory.create(this.M, this.u0, this.j);
        AdvertListItemModule_ProvideViewedAdvertsPresenterFactory create23 = AdvertListItemModule_ProvideViewedAdvertsPresenterFactory.create(this.P, this.j);
        this.V0 = create23;
        AdvertListItemBlueprint_Factory create24 = AdvertListItemBlueprint_Factory.create(this.e, this.T0, this.U0, create23, this.S0);
        this.W0 = create24;
        this.X0 = DoubleCheck.provider(create24);
        SellerItemPresenterImpl_Factory create25 = SellerItemPresenterImpl_Factory.create(this.O0, this.q);
        this.Y0 = create25;
        Provider<SellerItemPresenter> provider20 = DoubleCheck.provider(create25);
        this.Z0 = provider20;
        SellerItemBlueprint_Factory create26 = SellerItemBlueprint_Factory.create(provider20);
        this.a1 = create26;
        this.b1 = DoubleCheck.provider(create26);
        ErrorItemPresenterImpl_Factory create27 = ErrorItemPresenterImpl_Factory.create(this.O0);
        this.c1 = create27;
        this.d1 = ErrorItemBlueprint_Factory.create(create27);
        this.e1 = InfoItemBlueprint_Factory.create(InfoItemPresenterImpl_Factory.create());
        this.f1 = InstanceFactory.create(subscriptionSource);
        Factory createNullable2 = InstanceFactory.createNullable(kundle3);
        this.g1 = createNullable2;
        RecommendationItemPresenterImpl_Factory create28 = RecommendationItemPresenterImpl_Factory.create(this.x, this.t, this.A, this.q, this.j, this.b0, this.K, this.f1, this.C0, createNullable2);
        this.h1 = create28;
        this.i1 = DoubleCheck.provider(create28);
        SellerCarouselItemPresenterImpl_Factory create29 = SellerCarouselItemPresenterImpl_Factory.create(this.O0);
        this.j1 = create29;
        this.k1 = SellerCarouselItemBlueprint_Factory.create(create29);
        SetFactory build3 = SetFactory.builder(1, 0).addProvider(this.k1).build();
        this.l1 = build3;
        Provider<ItemBinder> provider21 = DoubleCheck.provider(RecommendationItemModule_ProvideItemBinderFactory.create(build3));
        this.m1 = provider21;
        RecommendationItemModule_ProvideAdapterPresenterFactory create30 = RecommendationItemModule_ProvideAdapterPresenterFactory.create(provider21);
        this.n1 = create30;
        this.o1 = RecommendationItemBlueprint_Factory.create(this.i1, create30, this.m1);
        LoadingItemPresenterImpl_Factory create31 = LoadingItemPresenterImpl_Factory.create(this.O0);
        this.p1 = create31;
        this.q1 = LoadingItemBlueprint_Factory.create(create31);
        SetFactory build4 = SetFactory.builder(6, 1).addCollectionProvider(this.b).addProvider(this.X0).addProvider(this.b1).addProvider(this.d1).addProvider(this.e1).addProvider(this.o1).addProvider(this.q1).build();
        this.r1 = build4;
        Provider<ItemBinder> provider22 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build4));
        this.s1 = provider22;
        DelegateFactory.setDelegate(this.y, SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider22)));
        Provider<CallableResponsiveItemPresenterRegistry> provider23 = DoubleCheck.provider(FavoriteSellersModule_ProvideResponsiveItemPresenterRegistry$favorite_sellers_releaseFactory.create(this.e));
        this.t1 = provider23;
        this.u1 = DoubleCheck.provider(FavoriteSellersModule_ProvideAdapterPresenter$favorite_sellers_releaseFactory.create(this.y, provider23));
        this.v1 = DoubleCheck.provider(FavoriteSellersModule_ProvideDestroyableViewHolderBuilder$favorite_sellers_releaseFactory.create(this.s1));
    }

    public static FavoriteSellersComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.favorite_sellers.di.FavoriteSellersComponent
    public void inject(FavoriteSellersFragment favoriteSellersFragment) {
        FavoriteSellersFragment_MembersInjector.injectIntentFactory(favoriteSellersFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        FavoriteSellersFragment_MembersInjector.injectImplicitIntentFactory(favoriteSellersFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        FavoriteSellersFragment_MembersInjector.injectDeepLinkIntentFactory(favoriteSellersFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        FavoriteSellersFragment_MembersInjector.injectAdapterPresenter(favoriteSellersFragment, this.u1.get());
        FavoriteSellersFragment_MembersInjector.injectViewHolderBuilder(favoriteSellersFragment, this.v1.get());
        FavoriteSellersFragment_MembersInjector.injectPresenter(favoriteSellersFragment, this.E0.get());
        FavoriteSellersFragment_MembersInjector.injectRecommendationPresenter(favoriteSellersFragment, this.i1.get());
        FavoriteSellersFragment_MembersInjector.injectAdvertListItemPresenter(favoriteSellersFragment, this.e.get());
        FavoriteSellersFragment_MembersInjector.injectAnalytics(favoriteSellersFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        FavoriteSellersFragment_MembersInjector.injectScreenTracker(favoriteSellersFragment, this.s0.get());
        FavoriteSellersFragment_MembersInjector.injectFeatures(favoriteSellersFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        FavoriteSellersFragment_MembersInjector.injectAbTestsConfigProvider(favoriteSellersFragment, (AbTestsConfigProvider) Preconditions.checkNotNullFromComponent(this.a.abTestConfigProvider()));
        FavoriteSellersFragment_MembersInjector.injectSnackbarPresenter(favoriteSellersFragment, this.C0.get());
    }
}
