package com.avito.android.user_stats.di;

import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.user_stats.UserStatsResourcesProvider;
import com.avito.android.user_stats.UserStatsViewModel;
import com.avito.android.user_stats.di.UserStatsTabComponent;
import com.avito.android.user_stats.tab.UserStatsChartBarItemConverter;
import com.avito.android.user_stats.tab.UserStatsChartBarItemConverterImpl;
import com.avito.android.user_stats.tab.UserStatsChartBarItemConverterImpl_Factory;
import com.avito.android.user_stats.tab.UserStatsProvider;
import com.avito.android.user_stats.tab.UserStatsTabFragment;
import com.avito.android.user_stats.tab.UserStatsTabFragment_MembersInjector;
import com.avito.android.user_stats.tab.UserStatsTabInteractor;
import com.avito.android.user_stats.tab.UserStatsTabInteractorImpl;
import com.avito.android.user_stats.tab.UserStatsTabInteractorImpl_Factory;
import com.avito.android.user_stats.tab.UserStatsTabViewModel;
import com.avito.android.user_stats.tab.UserStatsTabViewModelFactory;
import com.avito.android.user_stats.tab.UserStatsTabViewModelFactory_Factory;
import com.avito.android.user_stats.tab.UserStatsTemplateItemConverter;
import com.avito.android.user_stats.tab.UserStatsTemplateItemConverterImpl;
import com.avito.android.user_stats.tab.UserStatsTemplateItemConverterImpl_Factory;
import com.avito.android.user_stats.tab.list.UserStatsTemplateUnitComparator_Factory;
import com.avito.android.user_stats.tab.list.items.UserStatsTemplateUnitPayloadCreator_Factory;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemBlueprint;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemBlueprint_Factory;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemComparator_Factory;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemPayloadCreator_Factory;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemPresenter;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemPresenterImpl_Factory;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.ChartItemBlueprint;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.ChartItemBlueprint_Factory;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.ChartItemPresenter;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.ChartItemPresenterImpl;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.ChartItemPresenterImpl_Factory;
import com.avito.android.user_stats.tab.list.items.blueprints.description.DescriptionBlueprint;
import com.avito.android.user_stats.tab.list.items.blueprints.description.DescriptionBlueprint_Factory;
import com.avito.android.user_stats.tab.list.items.blueprints.description.DescriptionItemPresenter;
import com.avito.android.user_stats.tab.list.items.blueprints.description.DescriptionItemPresenterImpl_Factory;
import com.avito.android.user_stats.tab.list.items.blueprints.header.HeaderItemBlueprint;
import com.avito.android.user_stats.tab.list.items.blueprints.header.HeaderItemBlueprint_Factory;
import com.avito.android.user_stats.tab.list.items.blueprints.header.HeaderItemPresenter;
import com.avito.android.user_stats.tab.list.items.blueprints.header.HeaderItemPresenterImpl_Factory;
import com.avito.android.user_stats.tab.list.items.blueprints.space.SpaceBlueprint;
import com.avito.android.user_stats.tab.list.items.blueprints.space.SpaceBlueprint_Factory;
import com.avito.android.user_stats.tab.list.items.blueprints.space.SpaceItemPresenter;
import com.avito.android.user_stats.tab.list.items.blueprints.space.SpaceItemPresenterImpl_Factory;
import com.avito.android.user_stats.tab.list.items.blueprints.two_columns.TwoColumnsBlueprint;
import com.avito.android.user_stats.tab.list.items.blueprints.two_columns.TwoColumnsBlueprint_Factory;
import com.avito.android.user_stats.tab.list.items.blueprints.two_columns.TwoColumnsItemPresenter;
import com.avito.android.user_stats.tab.list.items.blueprints.two_columns.TwoColumnsItemPresenterImpl_Factory;
import com.avito.android.user_stats.tracker.UserStatsTabTracker;
import com.avito.android.user_stats.tracker.UserStatsTabTrackerImpl;
import com.avito.android.user_stats.tracker.UserStatsTabTrackerImpl_Factory;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterImpl_Factory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.user_stats.model.UserStatsTabData;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerUserStatsTabComponent implements UserStatsTabComponent {
    public Provider<AdapterPresenter> A;
    public Provider<ChartItemPresenterImpl> B;
    public Provider<ChartItemPresenter> C;
    public Provider<ChartItemBlueprint> D;
    public Provider<HeaderItemPresenter> E;
    public Provider<AttributedTextFormatter> F;
    public Provider<HeaderItemBlueprint> G;
    public Provider<TwoColumnsItemPresenter> H;
    public Provider<TwoColumnsBlueprint> I;
    public Provider<DescriptionItemPresenter> J;
    public Provider<DescriptionBlueprint> K;
    public Provider<SpaceItemPresenter> L;
    public Provider<SpaceBlueprint> M;
    public Provider<ItemBinder> N;
    public Provider<SimpleAdapterPresenter> O;
    public Provider<DiffCalculator> P;
    public Provider<AdapterPresenter> Q;
    public Provider<Set<ItemPresenter<?, ?>>> R;
    public Provider<ScreenTrackerFactory> S;
    public Provider<TimerFactory> T;
    public Provider<ScreenDiInjectTracker> U;
    public Provider<ScreenInitTracker> V;
    public Provider<UserStatsTabTrackerImpl> W;
    public Provider<UserStatsTabTracker> X;
    public final UserStatsTabDependencies a;
    public Provider<ViewModelStoreOwner> b;
    public Provider<SchedulersFactory3> c;
    public Provider<String> d;
    public Provider<UserStatsProvider> e;
    public Provider<UserStatsTabData> f;
    public Provider<RandomKeyProvider> g;
    public Provider<UserStatsResourcesProvider> h;
    public Provider<UserStatsChartBarItemConverterImpl> i;
    public Provider<UserStatsChartBarItemConverter> j;
    public Provider<UserStatsTemplateItemConverterImpl> k;
    public Provider<UserStatsTemplateItemConverter> l;
    public Provider<UserStatsTabInteractorImpl> m;
    public Provider<UserStatsTabInteractor> n;
    public Provider<Analytics> o;
    public Provider<UserStatsViewModel> p;
    public Provider<UserStatsTabViewModelFactory> q;
    public Provider<UserStatsTabViewModel> r;
    public Provider<SimpleRecyclerAdapter> s;
    public Provider<ListUpdateCallback> t;
    public Provider<SimpleRecyclerAdapter> u = new DelegateFactory();
    public Provider<BarItemPresenter> v;
    public Provider<BarItemBlueprint> w;
    public Provider<ItemBinder> x;
    public Provider<SimpleAdapterPresenter> y;
    public Provider<DiffCalculator> z;

    public static final class b implements UserStatsTabComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.user_stats.di.UserStatsTabComponent.Factory
        public UserStatsTabComponent create(ViewModelStoreOwner viewModelStoreOwner, String str, UserStatsTabDependencies userStatsTabDependencies) {
            Preconditions.checkNotNull(viewModelStoreOwner);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(userStatsTabDependencies);
            return new DaggerUserStatsTabComponent(userStatsTabDependencies, viewModelStoreOwner, str, null);
        }
    }

    public static class c implements Provider<Analytics> {
        public final UserStatsTabDependencies a;

        public c(UserStatsTabDependencies userStatsTabDependencies) {
            this.a = userStatsTabDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<RandomKeyProvider> {
        public final UserStatsTabDependencies a;

        public d(UserStatsTabDependencies userStatsTabDependencies) {
            this.a = userStatsTabDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RandomKeyProvider get() {
            return (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider());
        }
    }

    public static class e implements Provider<SchedulersFactory3> {
        public final UserStatsTabDependencies a;

        public e(UserStatsTabDependencies userStatsTabDependencies) {
            this.a = userStatsTabDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class f implements Provider<ScreenTrackerFactory> {
        public final UserStatsTabDependencies a;

        public f(UserStatsTabDependencies userStatsTabDependencies) {
            this.a = userStatsTabDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class g implements Provider<TimerFactory> {
        public final UserStatsTabDependencies a;

        public g(UserStatsTabDependencies userStatsTabDependencies) {
            this.a = userStatsTabDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class h implements Provider<UserStatsProvider> {
        public final UserStatsTabDependencies a;

        public h(UserStatsTabDependencies userStatsTabDependencies) {
            this.a = userStatsTabDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserStatsProvider get() {
            return (UserStatsProvider) Preconditions.checkNotNullFromComponent(this.a.userStatsProvider());
        }
    }

    public static class i implements Provider<UserStatsResourcesProvider> {
        public final UserStatsTabDependencies a;

        public i(UserStatsTabDependencies userStatsTabDependencies) {
            this.a = userStatsTabDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserStatsResourcesProvider get() {
            return (UserStatsResourcesProvider) Preconditions.checkNotNullFromComponent(this.a.userStatsResourcesProvider());
        }
    }

    public static class j implements Provider<UserStatsViewModel> {
        public final UserStatsTabDependencies a;

        public j(UserStatsTabDependencies userStatsTabDependencies) {
            this.a = userStatsTabDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserStatsViewModel get() {
            return (UserStatsViewModel) Preconditions.checkNotNullFromComponent(this.a.userStatsViewModel());
        }
    }

    public DaggerUserStatsTabComponent(UserStatsTabDependencies userStatsTabDependencies, ViewModelStoreOwner viewModelStoreOwner, String str, a aVar) {
        this.a = userStatsTabDependencies;
        this.b = InstanceFactory.create(viewModelStoreOwner);
        this.c = new e(userStatsTabDependencies);
        Factory create = InstanceFactory.create(str);
        this.d = create;
        h hVar = new h(userStatsTabDependencies);
        this.e = hVar;
        this.f = DoubleCheck.provider(UserStatsTabModule_ProvideTabModelFactory.create(create, hVar));
        this.g = new d(userStatsTabDependencies);
        i iVar = new i(userStatsTabDependencies);
        this.h = iVar;
        UserStatsChartBarItemConverterImpl_Factory create2 = UserStatsChartBarItemConverterImpl_Factory.create(iVar);
        this.i = create2;
        Provider<UserStatsChartBarItemConverter> provider = DoubleCheck.provider(create2);
        this.j = provider;
        UserStatsTemplateItemConverterImpl_Factory create3 = UserStatsTemplateItemConverterImpl_Factory.create(this.g, provider);
        this.k = create3;
        Provider<UserStatsTemplateItemConverter> provider2 = DoubleCheck.provider(create3);
        this.l = provider2;
        UserStatsTabInteractorImpl_Factory create4 = UserStatsTabInteractorImpl_Factory.create(this.c, this.f, provider2);
        this.m = create4;
        Provider<UserStatsTabInteractor> provider3 = DoubleCheck.provider(create4);
        this.n = provider3;
        c cVar = new c(userStatsTabDependencies);
        this.o = cVar;
        j jVar = new j(userStatsTabDependencies);
        this.p = jVar;
        UserStatsTabViewModelFactory_Factory create5 = UserStatsTabViewModelFactory_Factory.create(provider3, this.c, this.f, cVar, jVar);
        this.q = create5;
        this.r = DoubleCheck.provider(UserStatsTabModule_ProvideUserStatsFactory.create(this.b, create5));
        DelegateFactory delegateFactory = new DelegateFactory();
        this.s = delegateFactory;
        this.t = DoubleCheck.provider(UserStatsTabModule_ProvideListUpdateCallback$user_stats_releaseFactory.create(delegateFactory));
        Provider<BarItemPresenter> provider4 = DoubleCheck.provider(BarItemPresenterImpl_Factory.create());
        this.v = provider4;
        BarItemBlueprint_Factory create6 = BarItemBlueprint_Factory.create(provider4);
        this.w = create6;
        Provider<ItemBinder> provider5 = DoubleCheck.provider(UserStatsPlotModule_ProvideItemBinder$user_stats_releaseFactory.create(create6));
        this.x = provider5;
        this.y = DoubleCheck.provider(UserStatsPlotModule_ProvideAdapterFactory.create(provider5));
        Provider<DiffCalculator> provider6 = DoubleCheck.provider(UserStatsPlotModule_ProvideDiffCalculator$user_stats_releaseFactory.create(BarItemComparator_Factory.create(), BarItemPayloadCreator_Factory.create()));
        this.z = provider6;
        Provider<AdapterPresenter> provider7 = DoubleCheck.provider(UserStatsPlotModule_ProvideDataAwareAdapter$user_stats_releaseFactory.create(this.u, this.y, provider6));
        this.A = provider7;
        DelegateFactory.setDelegate(this.u, DoubleCheck.provider(UserStatsPlotModule_ProvideRecyclerAdapter$user_stats_releaseFactory.create(provider7, this.x)));
        ChartItemPresenterImpl_Factory create7 = ChartItemPresenterImpl_Factory.create(this.u, this.v);
        this.B = create7;
        Provider<ChartItemPresenter> provider8 = DoubleCheck.provider(create7);
        this.C = provider8;
        this.D = ChartItemBlueprint_Factory.create(provider8, this.u, this.A);
        this.E = DoubleCheck.provider(HeaderItemPresenterImpl_Factory.create());
        Provider<AttributedTextFormatter> provider9 = DoubleCheck.provider(AttributedTextFormatterImpl_Factory.create());
        this.F = provider9;
        this.G = HeaderItemBlueprint_Factory.create(this.E, provider9);
        Provider<TwoColumnsItemPresenter> provider10 = DoubleCheck.provider(TwoColumnsItemPresenterImpl_Factory.create());
        this.H = provider10;
        this.I = TwoColumnsBlueprint_Factory.create(provider10, this.F);
        Provider<DescriptionItemPresenter> provider11 = DoubleCheck.provider(DescriptionItemPresenterImpl_Factory.create());
        this.J = provider11;
        this.K = DescriptionBlueprint_Factory.create(provider11, this.F);
        Provider<SpaceItemPresenter> provider12 = DoubleCheck.provider(SpaceItemPresenterImpl_Factory.create());
        this.L = provider12;
        SpaceBlueprint_Factory create8 = SpaceBlueprint_Factory.create(provider12);
        this.M = create8;
        Provider<ItemBinder> provider13 = DoubleCheck.provider(UserStatsTabModule_ProvideItemBinder$user_stats_releaseFactory.create(this.D, this.G, this.I, this.K, create8));
        this.N = provider13;
        this.O = DoubleCheck.provider(UserStatsTabModule_ProvideAdapterPresenter$user_stats_releaseFactory.create(provider13));
        Provider<DiffCalculator> provider14 = DoubleCheck.provider(UserStatsTabModule_ProvideDiffCalculator$user_stats_releaseFactory.create(UserStatsTemplateUnitComparator_Factory.create(), UserStatsTemplateUnitPayloadCreator_Factory.create()));
        this.P = provider14;
        Provider<AdapterPresenter> provider15 = DoubleCheck.provider(UserStatsTabModule_ProvideDataAwareAdapterPresenterImpl$user_stats_releaseFactory.create(this.t, this.O, provider14));
        this.Q = provider15;
        DelegateFactory.setDelegate(this.s, DoubleCheck.provider(UserStatsTabModule_ProvideRecyclerAdapter$user_stats_releaseFactory.create(provider15, this.N)));
        this.R = DoubleCheck.provider(UserStatsTabModule_ProvideItemPresentersSetFactory.create(this.C, this.J));
        f fVar = new f(userStatsTabDependencies);
        this.S = fVar;
        g gVar = new g(userStatsTabDependencies);
        this.T = gVar;
        this.U = DoubleCheck.provider(UserStatsTabTrackerModule_ProvideScreenDiInjectTrackerFactory.create(fVar, gVar));
        Provider<ScreenInitTracker> provider16 = DoubleCheck.provider(UserStatsTabTrackerModule_ProvideScreenInitTrackerFactory.create(this.S, this.T));
        this.V = provider16;
        UserStatsTabTrackerImpl_Factory create9 = UserStatsTabTrackerImpl_Factory.create(this.U, provider16);
        this.W = create9;
        this.X = DoubleCheck.provider(create9);
    }

    public static UserStatsTabComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.user_stats.di.UserStatsTabComponent
    public void inject(UserStatsTabFragment userStatsTabFragment) {
        UserStatsTabFragment_MembersInjector.injectViewModel(userStatsTabFragment, this.r.get());
        UserStatsTabFragment_MembersInjector.injectAdapter(userStatsTabFragment, this.s.get());
        UserStatsTabFragment_MembersInjector.injectAdapterPresenter(userStatsTabFragment, this.Q.get());
        UserStatsTabFragment_MembersInjector.injectDeepLinkIntentFactory(userStatsTabFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        UserStatsTabFragment_MembersInjector.injectItemPresentersSet(userStatsTabFragment, this.R.get());
        UserStatsTabFragment_MembersInjector.injectUserStatsTabTracker(userStatsTabFragment, this.X.get());
    }
}
