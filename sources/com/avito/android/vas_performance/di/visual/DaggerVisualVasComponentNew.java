package com.avito.android.vas_performance.di.visual;

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
import com.avito.android.vas_performance.VisualVasConverter;
import com.avito.android.vas_performance.VisualVasConverterImpl_Factory;
import com.avito.android.vas_performance.di.visual.VisualVasComponentNew;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.repository.VasRepositoryImpl;
import com.avito.android.vas_performance.repository.VasRepositoryImpl_Factory;
import com.avito.android.vas_performance.tracker.VisualVasTracker;
import com.avito.android.vas_performance.tracker.VisualVasTrackerImpl;
import com.avito.android.vas_performance.tracker.VisualVasTrackerImpl_Factory;
import com.avito.android.vas_performance.ui.VisualVasFragment;
import com.avito.android.vas_performance.ui.VisualVasFragment_MembersInjector;
import com.avito.android.vas_performance.ui.VisualVasViewModel;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItemBlueprint;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItemBlueprint_Factory;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItemPresenter;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItemPresenterImpl_Factory;
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
public final class DaggerVisualVasComponentNew implements VisualVasComponentNew {
    public Provider<VisualVasViewModel> A;
    public final VisualVasDependenciesNew a;
    public Provider<PaidServiceHeaderItemPresenter> b;
    public Provider<ItemBlueprint<?, ?>> c;
    public Provider<Set<ItemBlueprint<?, ?>>> d = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<VisualVasItemPresenter> e = DoubleCheck.provider(VisualVasItemPresenterImpl_Factory.create());
    public Provider<AttributedTextFormatter> f;
    public Provider<VisualVasItemBlueprint> g;
    public Provider<ItemBlueprint<?, ?>> h;
    public Provider<Set<ItemBlueprint<?, ?>>> i;
    public Provider<ItemBinder> j;
    public Provider<AdapterPresenter> k;
    public Provider<Fragment> l;
    public Provider<VasApi> m;
    public Provider<SchedulersFactory> n;
    public Provider<Features> o;
    public Provider<VasRepositoryImpl> p;
    public Provider<VasRepository> q;
    public Provider<VisualVasConverter> r;
    public Provider<ScreenTrackerFactory> s;
    public Provider<Screen> t;
    public Provider<ScreenDiInjectTracker> u;
    public Provider<ScreenInitTracker> v;
    public Provider<ScreenFlowTrackerProvider> w;
    public Provider<VisualVasTrackerImpl> x;
    public Provider<VisualVasTracker> y;
    public Provider<ViewModelProvider.Factory> z;

    public static final class b implements VisualVasComponentNew.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.vas_performance.di.visual.VisualVasComponentNew.Factory
        public VisualVasComponentNew create(VisualVasDependenciesNew visualVasDependenciesNew, VisualVasModuleNew visualVasModuleNew, Fragment fragment) {
            Preconditions.checkNotNull(visualVasDependenciesNew);
            Preconditions.checkNotNull(visualVasModuleNew);
            Preconditions.checkNotNull(fragment);
            return new DaggerVisualVasComponentNew(new VasListModuleNew(), visualVasModuleNew, visualVasDependenciesNew, fragment, null);
        }
    }

    public static class c implements Provider<Features> {
        public final VisualVasDependenciesNew a;

        public c(VisualVasDependenciesNew visualVasDependenciesNew) {
            this.a = visualVasDependenciesNew;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final VisualVasDependenciesNew a;

        public d(VisualVasDependenciesNew visualVasDependenciesNew) {
            this.a = visualVasDependenciesNew;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class e implements Provider<Screen> {
        public final VisualVasDependenciesNew a;

        public e(VisualVasDependenciesNew visualVasDependenciesNew) {
            this.a = visualVasDependenciesNew;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Screen get() {
            return (Screen) Preconditions.checkNotNullFromComponent(this.a.screen());
        }
    }

    public static class f implements Provider<ScreenTrackerFactory> {
        public final VisualVasDependenciesNew a;

        public f(VisualVasDependenciesNew visualVasDependenciesNew) {
            this.a = visualVasDependenciesNew;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class g implements Provider<VasApi> {
        public final VisualVasDependenciesNew a;

        public g(VisualVasDependenciesNew visualVasDependenciesNew) {
            this.a = visualVasDependenciesNew;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public VasApi get() {
            return (VasApi) Preconditions.checkNotNullFromComponent(this.a.vasApi());
        }
    }

    public DaggerVisualVasComponentNew(VasListModuleNew vasListModuleNew, VisualVasModuleNew visualVasModuleNew, VisualVasDependenciesNew visualVasDependenciesNew, Fragment fragment, a aVar) {
        this.a = visualVasDependenciesNew;
        Provider<PaidServiceHeaderItemPresenter> provider = DoubleCheck.provider(VasListModuleNew_ProvideHeaderPresenterFactory.create(vasListModuleNew));
        this.b = provider;
        this.c = DoubleCheck.provider(VasListModuleNew_ProvideHeaderBlueprintFactory.create(vasListModuleNew, provider));
        Provider<AttributedTextFormatter> provider2 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.f = provider2;
        VisualVasItemBlueprint_Factory create = VisualVasItemBlueprint_Factory.create(this.e, provider2);
        this.g = create;
        this.h = DoubleCheck.provider(create);
        SetFactory build = SetFactory.builder(2, 1).addProvider(this.c).addCollectionProvider(this.d).addProvider(this.h).build();
        this.i = build;
        Provider<ItemBinder> provider3 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.j = provider3;
        this.k = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider3));
        this.l = InstanceFactory.create(fragment);
        g gVar = new g(visualVasDependenciesNew);
        this.m = gVar;
        d dVar = new d(visualVasDependenciesNew);
        this.n = dVar;
        c cVar = new c(visualVasDependenciesNew);
        this.o = cVar;
        VasRepositoryImpl_Factory create2 = VasRepositoryImpl_Factory.create(gVar, dVar, cVar);
        this.p = create2;
        this.q = DoubleCheck.provider(create2);
        this.r = DoubleCheck.provider(VisualVasConverterImpl_Factory.create());
        f fVar = new f(visualVasDependenciesNew);
        this.s = fVar;
        e eVar = new e(visualVasDependenciesNew);
        this.t = eVar;
        this.u = DoubleCheck.provider(VisualVasAnalyticsModuleNew_ProvidesScreenDiInjectTracker$vas_performance_releaseFactory.create(fVar, eVar, TimerFactory_Factory.create()));
        this.v = DoubleCheck.provider(VisualVasAnalyticsModuleNew_ProvidesScreenInitTracker$vas_performance_releaseFactory.create(this.s, this.t, TimerFactory_Factory.create()));
        Provider<ScreenFlowTrackerProvider> provider4 = DoubleCheck.provider(VisualVasAnalyticsModuleNew_ProvidesScreenFlowTrackerProvider$vas_performance_releaseFactory.create(this.s, this.t, TimerFactory_Factory.create()));
        this.w = provider4;
        VisualVasTrackerImpl_Factory create3 = VisualVasTrackerImpl_Factory.create(this.u, this.v, provider4);
        this.x = create3;
        Provider<VisualVasTracker> provider5 = DoubleCheck.provider(create3);
        this.y = provider5;
        Provider<ViewModelProvider.Factory> provider6 = DoubleCheck.provider(VisualVasModuleNew_ProvideViewModelFactoryFactory.create(visualVasModuleNew, this.q, this.r, this.n, provider5));
        this.z = provider6;
        this.A = DoubleCheck.provider(VisualVasModuleNew_ProvideViewModel$vas_performance_releaseFactory.create(visualVasModuleNew, this.l, provider6));
    }

    public static VisualVasComponentNew.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.vas_performance.di.visual.VisualVasComponentNew
    public void inject(VisualVasFragment visualVasFragment) {
        VisualVasFragment_MembersInjector.injectItemBinder(visualVasFragment, this.j.get());
        VisualVasFragment_MembersInjector.injectAdapterPresenter(visualVasFragment, this.k.get());
        VisualVasFragment_MembersInjector.injectItemPresenterSet(visualVasFragment, SetBuilder.newSetBuilder(2).add(this.e.get()).add(this.b.get()).build());
        VisualVasFragment_MembersInjector.injectViewModel(visualVasFragment, this.A.get());
        VisualVasFragment_MembersInjector.injectDeepLinkIntentFactory(visualVasFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
        VisualVasFragment_MembersInjector.injectAnalytics(visualVasFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        VisualVasFragment_MembersInjector.injectTracker(visualVasFragment, this.y.get());
    }
}
