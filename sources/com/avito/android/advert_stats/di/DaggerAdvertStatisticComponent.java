package com.avito.android.advert_stats.di;

import android.app.Application;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.advert_stats.AdvertStatsActivity;
import com.avito.android.advert_stats.AdvertStatsActivity_MembersInjector;
import com.avito.android.advert_stats.AdvertStatsRepository;
import com.avito.android.advert_stats.AdvertStatsViewModel;
import com.avito.android.advert_stats.AdvertStatsViewModelFactory;
import com.avito.android.advert_stats.di.AdvertStatisticComponent;
import com.avito.android.advert_stats.item.BarItemBlueprint;
import com.avito.android.advert_stats.item.BarItemPresenter;
import com.avito.android.advert_stats.item.OnBarItemClickListener;
import com.avito.android.advert_stats.item.PlotBlueprint;
import com.avito.android.advert_stats.item.PlotDimensionsProvider;
import com.avito.android.advert_stats.item.PlotItemPresenter;
import com.avito.android.advert_stats.item.PlotItemPresenterImpl;
import com.avito.android.advert_stats.item.PlotItemPresenterImpl_Factory;
import com.avito.android.advert_stats.item.StatisticDatesFormatter;
import com.avito.android.advert_stats.item.StatisticDatesFormatterImpl_Factory;
import com.avito.android.advert_stats.item.StatisticStringResourceProvider;
import com.avito.android.advert_stats.item.StatisticStringResourceProviderImpl;
import com.avito.android.advert_stats.item.StatisticStringResourceProviderImpl_Factory;
import com.avito.android.advert_stats.item.StatisticsIconProvider;
import com.avito.android.advert_stats.item.StatisticsIconProviderImpl_Factory;
import com.avito.android.advert_stats.item.StatisticsToItemsConverter;
import com.avito.android.advert_stats.item.StatisticsToItemsConverterImpl;
import com.avito.android.advert_stats.item.StatisticsToItemsConverterImpl_Factory;
import com.avito.android.advert_stats.item.WeekItemBlueprint;
import com.avito.android.advert_stats.item.WeekPresenter;
import com.avito.android.advert_stats.item.details.StatDetailItemBlueprint;
import com.avito.android.advert_stats.item.details.StatDetailItemBlueprint_Factory;
import com.avito.android.advert_stats.item.details.StatDetailItemPresenter_Factory;
import com.avito.android.advert_stats.item.disclaimer.NewStatisticsBannerBlueprint;
import com.avito.android.advert_stats.item.disclaimer.NewStatisticsBannerBlueprint_Factory;
import com.avito.android.advert_stats.item.disclaimer.NewStatisticsBannerPresenter;
import com.avito.android.advert_stats.item.hint.HintItemBlueprint;
import com.avito.android.advert_stats.item.hint.HintItemBlueprint_Factory;
import com.avito.android.advert_stats.item.hint.HintItemPresenter;
import com.avito.android.advert_stats.item.hint.HintItemPresenterImpl_Factory;
import com.avito.android.advert_stats.item.period.PeriodItemBlueprint;
import com.avito.android.advert_stats.item.period.PeriodItemBlueprint_Factory;
import com.avito.android.advert_stats.item.period.PeriodItemPresenter_Factory;
import com.avito.android.advert_stats.item.title.TitleItemBlueprint;
import com.avito.android.advert_stats.item.title.TitleItemBlueprint_Factory;
import com.avito.android.advert_stats.item.title.TitleItemPresenter_Factory;
import com.avito.android.advert_stats.remote.AdvertStatsApi;
import com.avito.android.advert_stats.tracker.AdvertStatsTracker;
import com.avito.android.advert_stats.tracker.AdvertStatsTrackerImpl;
import com.avito.android.advert_stats.tracker.AdvertStatsTrackerImpl_Factory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.bivrost.BivrostTutorialSessionStorage;
import com.avito.android.analytics.di.BivrostStatisticsModule_ProvideBivrostStorageFactory;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerAdvertStatisticComponent implements AdvertStatisticComponent {
    public Provider<DeviceMetrics> A;
    public Provider<PlotDimensionsProvider> B;
    public Provider<PlotItemPresenterImpl> C;
    public Provider<PlotItemPresenter> D;
    public Provider<OnBarItemClickListener> E;
    public Provider<BarItemPresenter> F;
    public Provider<WeekPresenter> G;
    public Provider<BarItemBlueprint> H;
    public Provider<ItemBinder> I;
    public Provider<AdapterPresenter> J;
    public Provider<WeekItemBlueprint> K;
    public Provider<ItemBinder> L;
    public Provider<AdapterPresenter> M;
    public Provider<PlotBlueprint> N;
    public Provider<TitleItemBlueprint> O;
    public Provider<PeriodItemBlueprint> P;
    public Provider<StatDetailItemBlueprint> Q;
    public Provider<HintItemPresenter> R;
    public Provider<HintItemBlueprint> S;
    public Provider<NewStatisticsBannerPresenter> T;
    public Provider<NewStatisticsBannerBlueprint> U;
    public Provider<ItemBinder> V;
    public Provider<AdapterPresenter> W;
    public final AdvertStatsDependencies a;
    public Provider<SchedulersFactory> b;
    public Provider<AdvertStatsApi> c;
    public Provider<Features> d;
    public Provider<AdvertStatsRepository> e;
    public Provider<Resources> f;
    public Provider<StatisticStringResourceProviderImpl> g;
    public Provider<StatisticStringResourceProvider> h;
    public Provider<StatisticsIconProvider> i = DoubleCheck.provider(StatisticsIconProviderImpl_Factory.create());
    public Provider<StatisticDatesFormatter> j = DoubleCheck.provider(StatisticDatesFormatterImpl_Factory.create());
    public Provider<Application> k;
    public Provider<PreferenceFactory> l;
    public Provider<BivrostTutorialSessionStorage> m;
    public Provider<StatisticsToItemsConverterImpl> n;
    public Provider<StatisticsToItemsConverter> o;
    public Provider<DeepLinkIntentFactory> p;
    public Provider<ActivityIntentFactory> q;
    public Provider<Analytics> r;
    public Provider<ScreenTrackerFactory> s;
    public Provider<ScreenDiInjectTracker> t;
    public Provider<ScreenInitTracker> u;
    public Provider<ScreenFlowTrackerProvider> v;
    public Provider<AdvertStatsTrackerImpl> w;
    public Provider<AdvertStatsTracker> x;
    public Provider<AdvertStatsViewModelFactory> y;
    public Provider<AdvertStatsViewModel> z;

    public static final class b implements AdvertStatisticComponent.Builder {
        public AdvertStatsDependencies a;
        public AdvertStatsModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.advert_stats.di.AdvertStatisticComponent.Builder
        public AdvertStatisticComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AdvertStatsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, AdvertStatsModule.class);
            return new DaggerAdvertStatisticComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.advert_stats.di.AdvertStatisticComponent.Builder
        public AdvertStatisticComponent.Builder dependencies(AdvertStatsDependencies advertStatsDependencies) {
            this.a = (AdvertStatsDependencies) Preconditions.checkNotNull(advertStatsDependencies);
            return this;
        }

        @Override // com.avito.android.advert_stats.di.AdvertStatisticComponent.Builder
        public AdvertStatisticComponent.Builder module(AdvertStatsModule advertStatsModule) {
            this.b = (AdvertStatsModule) Preconditions.checkNotNull(advertStatsModule);
            return this;
        }
    }

    public static class c implements Provider<ActivityIntentFactory> {
        public final AdvertStatsDependencies a;

        public c(AdvertStatsDependencies advertStatsDependencies) {
            this.a = advertStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ActivityIntentFactory get() {
            return (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory());
        }
    }

    public static class d implements Provider<AdvertStatsApi> {
        public final AdvertStatsDependencies a;

        public d(AdvertStatsDependencies advertStatsDependencies) {
            this.a = advertStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AdvertStatsApi get() {
            return (AdvertStatsApi) Preconditions.checkNotNullFromComponent(this.a.advertStatsApi());
        }
    }

    public static class e implements Provider<Analytics> {
        public final AdvertStatsDependencies a;

        public e(AdvertStatsDependencies advertStatsDependencies) {
            this.a = advertStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class f implements Provider<Application> {
        public final AdvertStatsDependencies a;

        public f(AdvertStatsDependencies advertStatsDependencies) {
            this.a = advertStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class g implements Provider<DeepLinkIntentFactory> {
        public final AdvertStatsDependencies a;

        public g(AdvertStatsDependencies advertStatsDependencies) {
            this.a = advertStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkIntentFactory get() {
            return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory());
        }
    }

    public static class h implements Provider<DeviceMetrics> {
        public final AdvertStatsDependencies a;

        public h(AdvertStatsDependencies advertStatsDependencies) {
            this.a = advertStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceMetrics get() {
            return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
        }
    }

    public static class i implements Provider<Features> {
        public final AdvertStatsDependencies a;

        public i(AdvertStatsDependencies advertStatsDependencies) {
            this.a = advertStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class j implements Provider<PreferenceFactory> {
        public final AdvertStatsDependencies a;

        public j(AdvertStatsDependencies advertStatsDependencies) {
            this.a = advertStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PreferenceFactory get() {
            return (PreferenceFactory) Preconditions.checkNotNullFromComponent(this.a.preferenceFactory());
        }
    }

    public static class k implements Provider<SchedulersFactory> {
        public final AdvertStatsDependencies a;

        public k(AdvertStatsDependencies advertStatsDependencies) {
            this.a = advertStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class l implements Provider<ScreenTrackerFactory> {
        public final AdvertStatsDependencies a;

        public l(AdvertStatsDependencies advertStatsDependencies) {
            this.a = advertStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public DaggerAdvertStatisticComponent(AdvertStatsModule advertStatsModule, AdvertStatsDependencies advertStatsDependencies, a aVar) {
        this.a = advertStatsDependencies;
        k kVar = new k(advertStatsDependencies);
        this.b = kVar;
        d dVar = new d(advertStatsDependencies);
        this.c = dVar;
        i iVar = new i(advertStatsDependencies);
        this.d = iVar;
        this.e = DoubleCheck.provider(AdvertStatsModule_ProviderInteractorFactory.create(advertStatsModule, dVar, kVar, iVar));
        Provider<Resources> provider = DoubleCheck.provider(AdvertStatsModule_ProvideResources$advert_stats_releaseFactory.create(advertStatsModule));
        this.f = provider;
        StatisticStringResourceProviderImpl_Factory create = StatisticStringResourceProviderImpl_Factory.create(provider);
        this.g = create;
        this.h = DoubleCheck.provider(create);
        f fVar = new f(advertStatsDependencies);
        this.k = fVar;
        j jVar = new j(advertStatsDependencies);
        this.l = jVar;
        Provider<BivrostTutorialSessionStorage> provider2 = DoubleCheck.provider(BivrostStatisticsModule_ProvideBivrostStorageFactory.create(fVar, jVar));
        this.m = provider2;
        StatisticsToItemsConverterImpl_Factory create2 = StatisticsToItemsConverterImpl_Factory.create(this.h, this.i, this.j, this.d, provider2);
        this.n = create2;
        this.o = DoubleCheck.provider(create2);
        this.p = new g(advertStatsDependencies);
        this.q = new c(advertStatsDependencies);
        this.r = new e(advertStatsDependencies);
        l lVar = new l(advertStatsDependencies);
        this.s = lVar;
        this.t = DoubleCheck.provider(StatsAnalyticsModule_ProvideScreenDiInjectTracker$advert_stats_releaseFactory.create(lVar, TimerFactory_Factory.create()));
        this.u = DoubleCheck.provider(StatsAnalyticsModule_ProvideScreenInitTrackerFactory.create(this.s, TimerFactory_Factory.create()));
        Provider<ScreenFlowTrackerProvider> provider3 = DoubleCheck.provider(StatsAnalyticsModule_ProvideScreenFlowTrackerProviderFactory.create(this.s, TimerFactory_Factory.create()));
        this.v = provider3;
        AdvertStatsTrackerImpl_Factory create3 = AdvertStatsTrackerImpl_Factory.create(this.t, this.u, provider3);
        this.w = create3;
        Provider<AdvertStatsTracker> provider4 = DoubleCheck.provider(create3);
        this.x = provider4;
        Provider<AdvertStatsViewModelFactory> provider5 = DoubleCheck.provider(AdvertStatsModule_ProviderViewModuleFactoryFactory.create(advertStatsModule, this.b, this.e, this.o, this.p, this.q, this.r, provider4, this.m));
        this.y = provider5;
        this.z = DoubleCheck.provider(AdvertStatsModule_ProvideViewodelFactory.create(advertStatsModule, provider5));
        h hVar = new h(advertStatsDependencies);
        this.A = hVar;
        Provider<PlotDimensionsProvider> provider6 = DoubleCheck.provider(AdvertStatsModule_ProvidePlotDimensProvider$advert_stats_releaseFactory.create(advertStatsModule, hVar));
        this.B = provider6;
        PlotItemPresenterImpl_Factory create4 = PlotItemPresenterImpl_Factory.create(provider6);
        this.C = create4;
        Provider<PlotItemPresenter> provider7 = DoubleCheck.provider(create4);
        this.D = provider7;
        Provider<OnBarItemClickListener> provider8 = DoubleCheck.provider(AdvertStatsModule_ProvideOnBarItemClickListener$advert_stats_releaseFactory.create(advertStatsModule, provider7));
        this.E = provider8;
        Provider<BarItemPresenter> provider9 = DoubleCheck.provider(AdvertStatsModule_ProvideBarItemPresenter$advert_stats_releaseFactory.create(advertStatsModule, this.B, provider8));
        this.F = provider9;
        this.G = DoubleCheck.provider(AdvertStatsModule_ProvideWeekPresenter$advert_stats_releaseFactory.create(advertStatsModule, provider9));
        Provider<BarItemBlueprint> provider10 = DoubleCheck.provider(AdvertStatsModule_ProvideBarItemBlueprint$advert_stats_releaseFactory.create(advertStatsModule, this.F));
        this.H = provider10;
        Provider<ItemBinder> provider11 = DoubleCheck.provider(AdvertStatsModule_ProvideChartSectionItemBinder$advert_stats_releaseFactory.create(advertStatsModule, provider10));
        this.I = provider11;
        Provider<AdapterPresenter> provider12 = DoubleCheck.provider(AdvertStatsModule_ProvideChartSectionAdapterPresenter$advert_stats_releaseFactory.create(advertStatsModule, provider11));
        this.J = provider12;
        Provider<WeekItemBlueprint> provider13 = DoubleCheck.provider(AdvertStatsModule_ProvideWeekItemBlueprint$advert_stats_releaseFactory.create(advertStatsModule, this.G, provider12, this.I));
        this.K = provider13;
        Provider<ItemBinder> provider14 = DoubleCheck.provider(AdvertStatsModule_ProvideWeekItemBinder$advert_stats_releaseFactory.create(advertStatsModule, provider13));
        this.L = provider14;
        Provider<AdapterPresenter> provider15 = DoubleCheck.provider(AdvertStatsModule_ProvideWeekAdapterPresenter$advert_stats_releaseFactory.create(advertStatsModule, provider14));
        this.M = provider15;
        this.N = DoubleCheck.provider(AdvertStatsModule_ProvidePlotItemBlueprint$advert_stats_releaseFactory.create(advertStatsModule, this.D, provider15, this.L, this.B));
        this.O = TitleItemBlueprint_Factory.create(TitleItemPresenter_Factory.create());
        this.P = PeriodItemBlueprint_Factory.create(PeriodItemPresenter_Factory.create());
        this.Q = StatDetailItemBlueprint_Factory.create(StatDetailItemPresenter_Factory.create());
        Provider<HintItemPresenter> provider16 = DoubleCheck.provider(HintItemPresenterImpl_Factory.create());
        this.R = provider16;
        this.S = HintItemBlueprint_Factory.create(provider16);
        Provider<NewStatisticsBannerPresenter> provider17 = DoubleCheck.provider(AdvertStatsModule_ProvideNewStatisticsPresenter$advert_stats_releaseFactory.create(advertStatsModule));
        this.T = provider17;
        NewStatisticsBannerBlueprint_Factory create5 = NewStatisticsBannerBlueprint_Factory.create(provider17);
        this.U = create5;
        Provider<ItemBinder> provider18 = DoubleCheck.provider(AdvertStatsModule_ProvideStatsItemBinder$advert_stats_releaseFactory.create(advertStatsModule, this.N, this.O, this.P, this.Q, this.S, create5));
        this.V = provider18;
        this.W = DoubleCheck.provider(AdvertStatsModule_ProvideAdapterPresenter$advert_stats_releaseFactory.create(advertStatsModule, provider18));
    }

    public static AdvertStatisticComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.advert_stats.di.AdvertStatisticComponent
    public void inject(AdvertStatsActivity advertStatsActivity) {
        AdvertStatsActivity_MembersInjector.injectViewModel(advertStatsActivity, this.z.get());
        AdvertStatsActivity_MembersInjector.injectAnalytics(advertStatsActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        AdvertStatsActivity_MembersInjector.injectItemBinder(advertStatsActivity, this.V.get());
        AdvertStatsActivity_MembersInjector.injectAdapterPresenter(advertStatsActivity, this.W.get());
        AdvertStatsActivity_MembersInjector.injectPlotPresenter(advertStatsActivity, this.D.get());
        AdvertStatsActivity_MembersInjector.injectHintItemPresenter(advertStatsActivity, this.R.get());
        AdvertStatsActivity_MembersInjector.injectStatisticsItemPresenter(advertStatsActivity, this.T.get());
        AdvertStatsActivity_MembersInjector.injectAdvertStatsTracker(advertStatsActivity, this.x.get());
        AdvertStatsActivity_MembersInjector.injectImplicitIntentFactory(advertStatsActivity, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
    }
}
