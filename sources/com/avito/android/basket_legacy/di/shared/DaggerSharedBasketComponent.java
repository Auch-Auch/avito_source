package com.avito.android.basket_legacy.di.shared;

import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.basket_legacy.LegacyPaidServicesTracker;
import com.avito.android.basket_legacy.LegacyPaidServicesTrackerImpl;
import com.avito.android.basket_legacy.LegacyPaidServicesTrackerImpl_Factory;
import com.avito.android.basket_legacy.di.fees.FeesBasketModule;
import com.avito.android.basket_legacy.di.fees.FeesBasketModule_ProvideErrorFormatterFactory;
import com.avito.android.basket_legacy.di.fees.FeesBasketModule_ProvidePackageApplyInteractorFactory;
import com.avito.android.basket_legacy.di.shared.SharedBasketComponent;
import com.avito.android.basket_legacy.di.vas.PerformanceVasAnalyticsModule_ProvidesScreenDiInjectTracker$basket_releaseFactory;
import com.avito.android.basket_legacy.di.vas.PerformanceVasAnalyticsModule_ProvidesScreenFlowTrackerProviderFactory;
import com.avito.android.basket_legacy.di.vas.PerformanceVasAnalyticsModule_ProvidesScreenInitTrackerFactory;
import com.avito.android.basket_legacy.di.vas.PerformanceVasModule;
import com.avito.android.basket_legacy.di.vas.PerformanceVasModule_ProvideLegacyViewModelFactoryFactory;
import com.avito.android.basket_legacy.di.vas.PerformanceVasModule_ProvideLegacyViewModelImpl$basket_releaseFactory;
import com.avito.android.basket_legacy.di.vas.VisualVasAnalyticsModule_ProvidesScreenDiInjectTracker$basket_releaseFactory;
import com.avito.android.basket_legacy.di.vas.VisualVasAnalyticsModule_ProvidesScreenFlowTrackerProvider$basket_releaseFactory;
import com.avito.android.basket_legacy.di.vas.VisualVasAnalyticsModule_ProvidesScreenInitTracker$basket_releaseFactory;
import com.avito.android.basket_legacy.di.vas.VisualVasModule;
import com.avito.android.basket_legacy.di.vas.VisualVasModule_ProvideViewModelFactoryFactory;
import com.avito.android.basket_legacy.di.vas.VisualVasModule_ProvideViewModelImpl$basket_releaseFactory;
import com.avito.android.basket_legacy.fees.BasketInteractor;
import com.avito.android.basket_legacy.fees.BasketInteractorImpl;
import com.avito.android.basket_legacy.fees.BasketInteractorImpl_Factory;
import com.avito.android.basket_legacy.fees.SingleFeeServiceConverter;
import com.avito.android.basket_legacy.fees.SingleFeeServiceConverterImpl_Factory;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.ui.BasketActivity;
import com.avito.android.basket_legacy.ui.BasketActivity_MembersInjector;
import com.avito.android.basket_legacy.utils.VasType;
import com.avito.android.basket_legacy.viewmodels.activity.BasketViewModel;
import com.avito.android.basket_legacy.viewmodels.activity.BasketViewModelFactory;
import com.avito.android.basket_legacy.viewmodels.activity.BasketViewModelFactory_Factory;
import com.avito.android.basket_legacy.viewmodels.shared.SharedBasketViewModel;
import com.avito.android.basket_legacy.viewmodels.shared.SharedBasketViewModelFactory;
import com.avito.android.basket_legacy.viewmodels.vas.performance.LegacyPerformanceVasViewModelFactory;
import com.avito.android.basket_legacy.viewmodels.vas.visual.LegacyVisualVasViewModelFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.fees.refactor.PackageApplyInteractor;
import com.avito.android.fees.remote.FeesApi;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas.remote.VasApi;
import com.avito.android.vas_performance.LegacyPerformanceVasViewModel;
import com.avito.android.vas_performance.LegacyVisualVasViewModel;
import com.avito.android.vas_performance.PerformanceVasConverter;
import com.avito.android.vas_performance.PerformanceVasConverterImpl_Factory;
import com.avito.android.vas_performance.StringProvider;
import com.avito.android.vas_performance.StringProviderImpl;
import com.avito.android.vas_performance.StringProviderImpl_Factory;
import com.avito.android.vas_performance.VisualVasConverter;
import com.avito.android.vas_performance.VisualVasConverterImpl_Factory;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.repository.VasRepositoryImpl;
import com.avito.android.vas_performance.repository.VasRepositoryImpl_Factory;
import com.avito.android.vas_performance.tracker.PerformanceVasTracker;
import com.avito.android.vas_performance.tracker.PerformanceVasTrackerImpl;
import com.avito.android.vas_performance.tracker.PerformanceVasTrackerImpl_Factory;
import com.avito.android.vas_performance.tracker.VisualVasTracker;
import com.avito.android.vas_performance.tracker.VisualVasTrackerImpl;
import com.avito.android.vas_performance.tracker.VisualVasTrackerImpl_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerSharedBasketComponent implements SharedBasketComponent {
    public Provider<Analytics> A;
    public Provider<LegacyPerformanceVasViewModelFactory> B;
    public Provider<LegacyPerformanceVasViewModel> C;
    public Provider<VisualVasConverter> D;
    public Provider<StringProviderImpl> E;
    public Provider<StringProvider> F;
    public Provider<ScreenDiInjectTracker> G;
    public Provider<ScreenInitTracker> H;
    public Provider<ScreenFlowTrackerProvider> I;
    public Provider<VisualVasTrackerImpl> J;
    public Provider<VisualVasTracker> K;
    public Provider<LegacyVisualVasViewModelFactory> L;
    public Provider<LegacyVisualVasViewModel> M;
    public Provider<VasType> N;
    public Provider<PublishAnalyticsDataProvider> O;
    public Provider<SingleFeeServiceConverter> P;
    public Provider<BasketInteractorImpl> Q;
    public Provider<BasketInteractor> R;
    public Provider<ActivityIntentFactory> S;
    public Provider<DeepLinkIntentFactory> T;
    public Provider<BasketViewModelFactory> U;
    public Provider<BasketViewModel> V;
    public Provider<ScreenDiInjectTracker> W;
    public Provider<ScreenInitTracker> X;
    public Provider<LegacyPaidServicesTrackerImpl> Y;
    public Provider<LegacyPaidServicesTracker> Z;
    public final BasketDependencies a;
    public Provider<SharedBasketViewModelFactory> b;
    public Provider<SharedBasketViewModel> c;
    public Provider<BasketRepository> d;
    public Provider<Resources> e;
    public Provider<String> f;
    public Provider<String> g;
    public Provider<Boolean> h;
    public Provider<FeesApi> i;
    public Provider<SchedulersFactory> j;
    public Provider<ErrorFormatter> k;
    public Provider<PackageApplyInteractor> l;
    public Provider<FragmentActivity> m;
    public Provider<VasApi> n;
    public Provider<Features> o;
    public Provider<VasRepositoryImpl> p;
    public Provider<VasRepository> q;
    public Provider<PerformanceVasConverter> r = DoubleCheck.provider(PerformanceVasConverterImpl_Factory.create());
    public Provider<ScreenTrackerFactory> s;
    public Provider<Screen> t;
    public Provider<Boolean> u;
    public Provider<ScreenDiInjectTracker> v;
    public Provider<ScreenInitTracker> w;
    public Provider<ScreenFlowTrackerProvider> x;
    public Provider<PerformanceVasTrackerImpl> y;
    public Provider<PerformanceVasTracker> z;

    public static final class b implements SharedBasketComponent.Builder {
        public BasketDependencies a;
        public SharedModule b;
        public FeesBasketModule c;
        public PerformanceVasModule d;
        public Screen e;
        public Boolean f;

        public b(a aVar) {
        }

        @Override // com.avito.android.basket_legacy.di.shared.SharedBasketComponent.Builder
        public SharedBasketComponent.Builder basketDependencies(BasketDependencies basketDependencies) {
            this.a = (BasketDependencies) Preconditions.checkNotNull(basketDependencies);
            return this;
        }

        @Override // com.avito.android.basket_legacy.di.shared.SharedBasketComponent.Builder
        public SharedBasketComponent build() {
            Preconditions.checkBuilderRequirement(this.a, BasketDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, SharedModule.class);
            if (this.c == null) {
                this.c = new FeesBasketModule();
            }
            Preconditions.checkBuilderRequirement(this.d, PerformanceVasModule.class);
            Preconditions.checkBuilderRequirement(this.e, Screen.class);
            Preconditions.checkBuilderRequirement(this.f, Boolean.class);
            return new DaggerSharedBasketComponent(this.b, this.c, this.d, new VisualVasModule(), this.a, this.e, this.f, null);
        }

        @Override // com.avito.android.basket_legacy.di.shared.SharedBasketComponent.Builder
        public SharedBasketComponent.Builder packageFeesModule(FeesBasketModule feesBasketModule) {
            this.c = (FeesBasketModule) Preconditions.checkNotNull(feesBasketModule);
            return this;
        }

        @Override // com.avito.android.basket_legacy.di.shared.SharedBasketComponent.Builder
        public SharedBasketComponent.Builder performanceVasModule(PerformanceVasModule performanceVasModule) {
            this.d = (PerformanceVasModule) Preconditions.checkNotNull(performanceVasModule);
            return this;
        }

        @Override // com.avito.android.basket_legacy.di.shared.SharedBasketComponent.Builder
        public SharedBasketComponent.Builder sharedModule(SharedModule sharedModule) {
            this.b = (SharedModule) Preconditions.checkNotNull(sharedModule);
            return this;
        }

        @Override // com.avito.android.basket_legacy.di.shared.SharedBasketComponent.Builder
        public SharedBasketComponent.Builder withScreen(Screen screen) {
            this.e = (Screen) Preconditions.checkNotNull(screen);
            return this;
        }

        @Override // com.avito.android.basket_legacy.di.shared.SharedBasketComponent.Builder
        public SharedBasketComponent.Builder withSubComponents(boolean z) {
            this.f = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }
    }

    public static class c implements Provider<ActivityIntentFactory> {
        public final BasketDependencies a;

        public c(BasketDependencies basketDependencies) {
            this.a = basketDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ActivityIntentFactory get() {
            return (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory());
        }
    }

    public static class d implements Provider<Analytics> {
        public final BasketDependencies a;

        public d(BasketDependencies basketDependencies) {
            this.a = basketDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<PublishAnalyticsDataProvider> {
        public final BasketDependencies a;

        public e(BasketDependencies basketDependencies) {
            this.a = basketDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishAnalyticsDataProvider get() {
            return (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.analyticsDataProvider());
        }
    }

    public static class f implements Provider<DeepLinkIntentFactory> {
        public final BasketDependencies a;

        public f(BasketDependencies basketDependencies) {
            this.a = basketDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkIntentFactory get() {
            return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory());
        }
    }

    public static class g implements Provider<Features> {
        public final BasketDependencies a;

        public g(BasketDependencies basketDependencies) {
            this.a = basketDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class h implements Provider<FeesApi> {
        public final BasketDependencies a;

        public h(BasketDependencies basketDependencies) {
            this.a = basketDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FeesApi get() {
            return (FeesApi) Preconditions.checkNotNullFromComponent(this.a.feesApi());
        }
    }

    public static class i implements Provider<SchedulersFactory> {
        public final BasketDependencies a;

        public i(BasketDependencies basketDependencies) {
            this.a = basketDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class j implements Provider<ScreenTrackerFactory> {
        public final BasketDependencies a;

        public j(BasketDependencies basketDependencies) {
            this.a = basketDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class k implements Provider<VasApi> {
        public final BasketDependencies a;

        public k(BasketDependencies basketDependencies) {
            this.a = basketDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public VasApi get() {
            return (VasApi) Preconditions.checkNotNullFromComponent(this.a.vasApi());
        }
    }

    public DaggerSharedBasketComponent(SharedModule sharedModule, FeesBasketModule feesBasketModule, PerformanceVasModule performanceVasModule, VisualVasModule visualVasModule, BasketDependencies basketDependencies, Screen screen, Boolean bool, a aVar) {
        this.a = basketDependencies;
        Provider<SharedBasketViewModelFactory> provider = DoubleCheck.provider(SharedModule_ProvideFactoryFactory.create(sharedModule));
        this.b = provider;
        Provider<SharedBasketViewModel> provider2 = DoubleCheck.provider(SharedModule_ProvideSharedViewModelFactory.create(sharedModule, provider));
        this.c = provider2;
        this.d = DoubleCheck.provider(SharedModule_ProvideBasketRepositoryFactory.create(sharedModule, provider2));
        this.e = DoubleCheck.provider(SharedModule_ProvideResourcesFactory.create(sharedModule));
        this.f = DoubleCheck.provider(SharedModule_ProvideAdvertIdFactory.create(sharedModule));
        this.g = DoubleCheck.provider(SharedModule_ProvideVasContextFactory.create(sharedModule));
        this.h = DoubleCheck.provider(SharedModule_ProvideFeesParamFactory.create(sharedModule));
        this.i = new h(basketDependencies);
        this.j = new i(basketDependencies);
        Provider<ErrorFormatter> provider3 = DoubleCheck.provider(FeesBasketModule_ProvideErrorFormatterFactory.create(feesBasketModule, this.e));
        this.k = provider3;
        this.l = DoubleCheck.provider(FeesBasketModule_ProvidePackageApplyInteractorFactory.create(feesBasketModule, this.f, this.i, this.j, provider3));
        this.m = DoubleCheck.provider(SharedModule_ProvideActivityFactory.create(sharedModule));
        k kVar = new k(basketDependencies);
        this.n = kVar;
        g gVar = new g(basketDependencies);
        this.o = gVar;
        VasRepositoryImpl_Factory create = VasRepositoryImpl_Factory.create(kVar, this.j, gVar);
        this.p = create;
        this.q = DoubleCheck.provider(create);
        this.s = new j(basketDependencies);
        this.t = InstanceFactory.create(screen);
        Factory create2 = InstanceFactory.create(bool);
        this.u = create2;
        this.v = DoubleCheck.provider(PerformanceVasAnalyticsModule_ProvidesScreenDiInjectTracker$basket_releaseFactory.create(this.s, this.t, create2, TimerFactory_Factory.create()));
        this.w = DoubleCheck.provider(PerformanceVasAnalyticsModule_ProvidesScreenInitTrackerFactory.create(this.s, this.t, this.u, TimerFactory_Factory.create()));
        Provider<ScreenFlowTrackerProvider> provider4 = DoubleCheck.provider(PerformanceVasAnalyticsModule_ProvidesScreenFlowTrackerProviderFactory.create(this.s, this.t, TimerFactory_Factory.create()));
        this.x = provider4;
        PerformanceVasTrackerImpl_Factory create3 = PerformanceVasTrackerImpl_Factory.create(this.v, this.w, provider4);
        this.y = create3;
        Provider<PerformanceVasTracker> provider5 = DoubleCheck.provider(create3);
        this.z = provider5;
        d dVar = new d(basketDependencies);
        this.A = dVar;
        Provider<LegacyPerformanceVasViewModelFactory> provider6 = DoubleCheck.provider(PerformanceVasModule_ProvideLegacyViewModelFactoryFactory.create(performanceVasModule, this.f, this.q, this.d, this.r, this.j, provider5, dVar));
        this.B = provider6;
        this.C = DoubleCheck.provider(PerformanceVasModule_ProvideLegacyViewModelImpl$basket_releaseFactory.create(performanceVasModule, this.m, provider6));
        this.D = DoubleCheck.provider(VisualVasConverterImpl_Factory.create());
        StringProviderImpl_Factory create4 = StringProviderImpl_Factory.create(this.e);
        this.E = create4;
        this.F = DoubleCheck.provider(create4);
        this.G = DoubleCheck.provider(VisualVasAnalyticsModule_ProvidesScreenDiInjectTracker$basket_releaseFactory.create(this.s, this.t, this.u, TimerFactory_Factory.create()));
        this.H = DoubleCheck.provider(VisualVasAnalyticsModule_ProvidesScreenInitTracker$basket_releaseFactory.create(this.s, this.t, this.u, TimerFactory_Factory.create()));
        Provider<ScreenFlowTrackerProvider> provider7 = DoubleCheck.provider(VisualVasAnalyticsModule_ProvidesScreenFlowTrackerProvider$basket_releaseFactory.create(this.s, this.t, TimerFactory_Factory.create()));
        this.I = provider7;
        VisualVasTrackerImpl_Factory create5 = VisualVasTrackerImpl_Factory.create(this.G, this.H, provider7);
        this.J = create5;
        Provider<VisualVasTracker> provider8 = DoubleCheck.provider(create5);
        this.K = provider8;
        Provider<LegacyVisualVasViewModelFactory> provider9 = DoubleCheck.provider(VisualVasModule_ProvideViewModelFactoryFactory.create(visualVasModule, this.f, this.q, this.d, this.D, this.j, this.F, provider8));
        this.L = provider9;
        this.M = DoubleCheck.provider(VisualVasModule_ProvideViewModelImpl$basket_releaseFactory.create(visualVasModule, this.m, provider9));
        this.N = DoubleCheck.provider(SharedModule_ProvideVasTypeFactory.create(sharedModule));
        this.O = new e(basketDependencies);
        Provider<SingleFeeServiceConverter> provider10 = DoubleCheck.provider(SingleFeeServiceConverterImpl_Factory.create());
        this.P = provider10;
        BasketInteractorImpl_Factory create6 = BasketInteractorImpl_Factory.create(this.f, this.h, this.N, this.i, this.O, this.d, this.j, provider10);
        this.Q = create6;
        Provider<BasketInteractor> provider11 = DoubleCheck.provider(create6);
        this.R = provider11;
        c cVar = new c(basketDependencies);
        this.S = cVar;
        f fVar = new f(basketDependencies);
        this.T = fVar;
        Provider<BasketViewModelFactory> provider12 = DoubleCheck.provider(BasketViewModelFactory_Factory.create(this.N, provider11, this.j, cVar, fVar));
        this.U = provider12;
        this.V = DoubleCheck.provider(SharedModule_ProvideBasketViewModelFactory.create(sharedModule, provider12));
        this.W = DoubleCheck.provider(LegacyPaidServicesAnalyticsModule_ProvidesScreenDiInjectTracker$basket_releaseFactory.create(this.s, this.t, TimerFactory_Factory.create()));
        Provider<ScreenInitTracker> provider13 = DoubleCheck.provider(LegacyPaidServicesAnalyticsModule_ProvidesScreenInitTracker$basket_releaseFactory.create(this.s, this.t, TimerFactory_Factory.create()));
        this.X = provider13;
        LegacyPaidServicesTrackerImpl_Factory create7 = LegacyPaidServicesTrackerImpl_Factory.create(this.W, provider13);
        this.Y = create7;
        this.Z = DoubleCheck.provider(create7);
    }

    public static SharedBasketComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.basket_legacy.di.checkout.LegacyCheckoutDependencies
    public ActivityIntentFactory activityIntentFactory() {
        return (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory());
    }

    @Override // com.avito.android.basket_legacy.di.checkout.LegacyCheckoutDependencies
    public String advertId() {
        return this.f.get();
    }

    @Override // com.avito.android.vas_performance.di.VasDependencies
    public Analytics analytics() {
        return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
    }

    @Override // com.avito.android.basket_legacy.di.checkout.LegacyCheckoutDependencies
    public BasketRepository basketRepository() {
        return this.d.get();
    }

    @Override // com.avito.android.basket_legacy.di.checkout.LegacyCheckoutDependencies, com.avito.android.vas_performance.di.perfomance_legacy.PerformanceVasDependencies
    public DeepLinkIntentFactory deeplinkIntentFactory() {
        return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory());
    }

    @Override // com.avito.android.basket_legacy.di.checkout.LegacyCheckoutDependencies
    public Features features() {
        return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
    }

    @Override // com.avito.android.basket_legacy.di.shared.SharedBasketComponent
    public void inject(BasketActivity basketActivity) {
        BasketActivity_MembersInjector.injectViewModelProvider(basketActivity, DoubleCheck.lazy(this.V));
        BasketActivity_MembersInjector.injectAnalytics(basketActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        BasketActivity_MembersInjector.injectFactory(basketActivity, this.b.get());
        BasketActivity_MembersInjector.injectTracker(basketActivity, this.Z.get());
    }

    @Override // com.avito.android.vas_performance.di.perfomance_legacy.PerformanceVasDependencies
    public LegacyPerformanceVasViewModel legacyPerformanceVasViewModel() {
        return this.C.get();
    }

    @Override // com.avito.android.basket_legacy.di.checkout.LegacyCheckoutDependencies
    public boolean lfRequired() {
        return this.h.get().booleanValue();
    }

    @Override // com.avito.android.basket_legacy.di.checkout.LegacyCheckoutDependencies
    public Locale locale() {
        return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
    }

    @Override // com.avito.android.fees.refactor.di.PackageFeesDependencies
    public PackageApplyInteractor packageApplyInteractor() {
        return this.l.get();
    }

    @Override // com.avito.android.vas_performance.di.perfomance_legacy.PerformanceVasDependencies
    public PerformanceVasTracker performanceVasTracker() {
        return this.z.get();
    }

    @Override // com.avito.android.basket_legacy.di.checkout.LegacyCheckoutDependencies
    public Resources resources() {
        return this.e.get();
    }

    @Override // com.avito.android.basket_legacy.di.checkout.LegacyCheckoutDependencies
    public SchedulersFactory schedulersFactory() {
        return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
    }

    @Override // com.avito.android.basket_legacy.di.checkout.LegacyCheckoutDependencies
    public String vasContext() {
        return this.g.get();
    }

    @Override // com.avito.android.vas_performance.di.visual_legacy.VisualVasDependencies
    public VisualVasTracker visualVasTracker() {
        return this.K.get();
    }

    @Override // com.avito.android.vas_performance.di.visual_legacy.VisualVasDependencies
    public LegacyVisualVasViewModel visualVasViewModel() {
        return this.M.get();
    }
}
