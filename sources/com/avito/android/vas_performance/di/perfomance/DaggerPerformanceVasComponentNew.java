package com.avito.android.vas_performance.di.perfomance;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.android.vas.remote.VasApi;
import com.avito.android.vas_performance.PerformanceVasConverter;
import com.avito.android.vas_performance.PerformanceVasConverterImpl_Factory;
import com.avito.android.vas_performance.PerformanceVasViewModel;
import com.avito.android.vas_performance.di.perfomance.PerformanceVasComponentNew;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.repository.VasRepositoryImpl;
import com.avito.android.vas_performance.repository.VasRepositoryImpl_Factory;
import com.avito.android.vas_performance.tracker.PerformanceVasTracker;
import com.avito.android.vas_performance.tracker.PerformanceVasTrackerImpl;
import com.avito.android.vas_performance.tracker.PerformanceVasTrackerImpl_Factory;
import com.avito.android.vas_performance.ui.PerformanceVasFragment;
import com.avito.android.vas_performance.ui.PerformanceVasFragment_MembersInjector;
import com.avito.android.vas_performance.ui.items.info_action.InfoActionItemBlueprint;
import com.avito.android.vas_performance.ui.items.info_action.InfoActionItemBlueprint_Factory;
import com.avito.android.vas_performance.ui.items.info_action.InfoActionItemPresenter;
import com.avito.android.vas_performance.ui.items.info_action.InfoActionItemPresenterImpl_Factory;
import com.avito.android.vas_performance.ui.items.tabs.TabsItemBlueprint;
import com.avito.android.vas_performance.ui.items.tabs.TabsItemBlueprint_Factory;
import com.avito.android.vas_performance.ui.items.tabs.TabsItemPresenter;
import com.avito.android.vas_performance.ui.items.tabs.TabsItemPresenterImpl_Factory;
import com.avito.android.vas_performance.ui.items.vas.PerformanceVasBlueprint;
import com.avito.android.vas_performance.ui.items.vas.PerformanceVasBlueprint_Factory;
import com.avito.android.vas_performance.ui.items.vas.PerformanceVasItemPresenter;
import com.avito.android.vas_performance.ui.items.vas.PerformanceVasItemPresenterImpl_Factory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerPerformanceVasComponentNew implements PerformanceVasComponentNew {
    public Provider<ScreenDiInjectTracker> A;
    public Provider<ScreenInitTracker> B;
    public Provider<ScreenFlowTrackerProvider> C;
    public Provider<PerformanceVasTrackerImpl> D;
    public Provider<PerformanceVasTracker> E;
    public Provider<ViewModelProvider.Factory> F;
    public Provider<PerformanceVasViewModel> G;
    public final PerformanceVasDependenciesNew a;
    public Provider<PaidServiceHeaderItemPresenter> b;
    public Provider<ItemBlueprint<?, ?>> c;
    public Provider<Set<ItemBlueprint<?, ?>>> d = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<TabsItemPresenter> e;
    public Provider<TabsItemBlueprint> f;
    public Provider<ItemBlueprint<?, ?>> g;
    public Provider<PerformanceVasItemPresenter> h;
    public Provider<AttributedTextFormatter> i;
    public Provider<PerformanceVasBlueprint> j;
    public Provider<ItemBlueprint<?, ?>> k;
    public Provider<InfoActionItemPresenter> l;
    public Provider<InfoActionItemBlueprint> m;
    public Provider<ItemBlueprint<?, ?>> n;
    public Provider<Set<ItemBlueprint<?, ?>>> o;
    public Provider<ItemBinder> p;
    public Provider<AdapterPresenter> q;
    public Provider<Fragment> r;
    public Provider<VasApi> s;
    public Provider<SchedulersFactory> t;
    public Provider<Features> u;
    public Provider<VasRepositoryImpl> v;
    public Provider<VasRepository> w;
    public Provider<PerformanceVasConverter> x;
    public Provider<ScreenTrackerFactory> y;
    public Provider<Screen> z;

    public static final class b implements PerformanceVasComponentNew.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.vas_performance.di.perfomance.PerformanceVasComponentNew.Factory
        public PerformanceVasComponentNew create(PerformanceVasDependenciesNew performanceVasDependenciesNew, PerformanceVasModuleNew performanceVasModuleNew, Fragment fragment) {
            Preconditions.checkNotNull(performanceVasDependenciesNew);
            Preconditions.checkNotNull(performanceVasModuleNew);
            Preconditions.checkNotNull(fragment);
            return new DaggerPerformanceVasComponentNew(new ListModuleNew(), performanceVasModuleNew, performanceVasDependenciesNew, fragment, null);
        }
    }

    public static class c implements Provider<Features> {
        public final PerformanceVasDependenciesNew a;

        public c(PerformanceVasDependenciesNew performanceVasDependenciesNew) {
            this.a = performanceVasDependenciesNew;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final PerformanceVasDependenciesNew a;

        public d(PerformanceVasDependenciesNew performanceVasDependenciesNew) {
            this.a = performanceVasDependenciesNew;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class e implements Provider<Screen> {
        public final PerformanceVasDependenciesNew a;

        public e(PerformanceVasDependenciesNew performanceVasDependenciesNew) {
            this.a = performanceVasDependenciesNew;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Screen get() {
            return (Screen) Preconditions.checkNotNullFromComponent(this.a.screen());
        }
    }

    public static class f implements Provider<ScreenTrackerFactory> {
        public final PerformanceVasDependenciesNew a;

        public f(PerformanceVasDependenciesNew performanceVasDependenciesNew) {
            this.a = performanceVasDependenciesNew;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class g implements Provider<VasApi> {
        public final PerformanceVasDependenciesNew a;

        public g(PerformanceVasDependenciesNew performanceVasDependenciesNew) {
            this.a = performanceVasDependenciesNew;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public VasApi get() {
            return (VasApi) Preconditions.checkNotNullFromComponent(this.a.vasApi());
        }
    }

    public DaggerPerformanceVasComponentNew(ListModuleNew listModuleNew, PerformanceVasModuleNew performanceVasModuleNew, PerformanceVasDependenciesNew performanceVasDependenciesNew, Fragment fragment, a aVar) {
        this.a = performanceVasDependenciesNew;
        Provider<PaidServiceHeaderItemPresenter> provider = DoubleCheck.provider(ListModuleNew_ProvideHeaderPresenterFactory.create(listModuleNew));
        this.b = provider;
        this.c = DoubleCheck.provider(ListModuleNew_ProvideHeaderBlueprintFactory.create(listModuleNew, provider));
        Provider<TabsItemPresenter> provider2 = DoubleCheck.provider(TabsItemPresenterImpl_Factory.create());
        this.e = provider2;
        TabsItemBlueprint_Factory create = TabsItemBlueprint_Factory.create(provider2);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        this.h = DoubleCheck.provider(PerformanceVasItemPresenterImpl_Factory.create());
        Provider<AttributedTextFormatter> provider3 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.i = provider3;
        PerformanceVasBlueprint_Factory create2 = PerformanceVasBlueprint_Factory.create(this.h, provider3);
        this.j = create2;
        this.k = DoubleCheck.provider(create2);
        Provider<InfoActionItemPresenter> provider4 = DoubleCheck.provider(InfoActionItemPresenterImpl_Factory.create());
        this.l = provider4;
        InfoActionItemBlueprint_Factory create3 = InfoActionItemBlueprint_Factory.create(provider4);
        this.m = create3;
        this.n = DoubleCheck.provider(create3);
        SetFactory build = SetFactory.builder(4, 1).addProvider(this.c).addCollectionProvider(this.d).addProvider(this.g).addProvider(this.k).addProvider(this.n).build();
        this.o = build;
        Provider<ItemBinder> provider5 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.p = provider5;
        this.q = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider5));
        this.r = InstanceFactory.create(fragment);
        g gVar = new g(performanceVasDependenciesNew);
        this.s = gVar;
        d dVar = new d(performanceVasDependenciesNew);
        this.t = dVar;
        c cVar = new c(performanceVasDependenciesNew);
        this.u = cVar;
        VasRepositoryImpl_Factory create4 = VasRepositoryImpl_Factory.create(gVar, dVar, cVar);
        this.v = create4;
        this.w = DoubleCheck.provider(create4);
        this.x = DoubleCheck.provider(PerformanceVasConverterImpl_Factory.create());
        f fVar = new f(performanceVasDependenciesNew);
        this.y = fVar;
        e eVar = new e(performanceVasDependenciesNew);
        this.z = eVar;
        this.A = DoubleCheck.provider(PerformanceVasAnalyticsModuleNew_ProvidesScreenDiInjectTracker$vas_performance_releaseFactory.create(fVar, eVar, TimerFactory_Factory.create()));
        this.B = DoubleCheck.provider(PerformanceVasAnalyticsModuleNew_ProvidesScreenInitTrackerFactory.create(this.y, this.z, TimerFactory_Factory.create()));
        Provider<ScreenFlowTrackerProvider> provider6 = DoubleCheck.provider(PerformanceVasAnalyticsModuleNew_ProvidesScreenFlowTrackerProviderFactory.create(this.y, this.z, TimerFactory_Factory.create()));
        this.C = provider6;
        PerformanceVasTrackerImpl_Factory create5 = PerformanceVasTrackerImpl_Factory.create(this.A, this.B, provider6);
        this.D = create5;
        Provider<PerformanceVasTracker> provider7 = DoubleCheck.provider(create5);
        this.E = provider7;
        Provider<ViewModelProvider.Factory> provider8 = DoubleCheck.provider(PerformanceVasModuleNew_ProvideViewModelFactoryFactory.create(performanceVasModuleNew, this.w, this.t, this.x, provider7));
        this.F = provider8;
        this.G = DoubleCheck.provider(PerformanceVasModuleNew_ProvideViewModel$vas_performance_releaseFactory.create(performanceVasModuleNew, this.r, provider8));
    }

    public static PerformanceVasComponentNew.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.vas_performance.di.perfomance.PerformanceVasComponentNew
    public void inject(PerformanceVasFragment performanceVasFragment) {
        PerformanceVasFragment_MembersInjector.injectItemBinder(performanceVasFragment, this.p.get());
        PerformanceVasFragment_MembersInjector.injectAdapterPresenter(performanceVasFragment, this.q.get());
        PerformanceVasFragment_MembersInjector.injectViewModel(performanceVasFragment, this.G.get());
        PerformanceVasFragment_MembersInjector.injectAnalytics(performanceVasFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        PerformanceVasFragment_MembersInjector.injectDeepLinkIntentFactory(performanceVasFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
        PerformanceVasFragment_MembersInjector.injectItemPresenterSet(performanceVasFragment, SetBuilder.newSetBuilder(4).add(this.e.get()).add(this.h.get()).add(this.l.get()).add(this.b.get()).build());
        PerformanceVasFragment_MembersInjector.injectTracker(performanceVasFragment, this.E.get());
    }
}
