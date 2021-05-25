package com.avito.android.select.new_metro.di;

import androidx.fragment.app.Fragment;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.select.new_metro.ItemsHolder;
import com.avito.android.select.new_metro.SelectMetroFragment;
import com.avito.android.select.new_metro.SelectMetroFragment_MembersInjector;
import com.avito.android.select.new_metro.SelectMetroParams;
import com.avito.android.select.new_metro.adapter.MetroItemsComparator_Factory;
import com.avito.android.select.new_metro.adapter.checkbox_listitem.CheckBoxListItemViewProvider_Factory;
import com.avito.android.select.new_metro.adapter.filter.MetroFilterItemBluePrint;
import com.avito.android.select.new_metro.adapter.filter.MetroFilterItemPresenter;
import com.avito.android.select.new_metro.adapter.filter.MetroFilterItemPresenterImpl_Factory;
import com.avito.android.select.new_metro.adapter.gap.MetroListGapItemBlueprint;
import com.avito.android.select.new_metro.adapter.gap.MetroListGapItemBlueprint_Factory;
import com.avito.android.select.new_metro.adapter.gap.MetroListGapItemPresenter_Factory;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemBluePrint;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemPresenter;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemPresenterImpl_Factory;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItemBluePrint;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItemPresenter;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItemPresenterImpl_Factory;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemBlueprint;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemBlueprint_Factory;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemPresenter;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemPresenterImpl_Factory;
import com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypeBluePrint;
import com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypePresenter;
import com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypePresenterImpl_Factory;
import com.avito.android.select.new_metro.analytics.SelectMetroAnalytics;
import com.avito.android.select.new_metro.di.SelectMetroFragmentComponent;
import com.avito.android.select.new_metro.view_model.SelectMetroViewModel;
import com.avito.android.select.new_metro.view_model.SelectMetroViewModelFactory;
import com.avito.android.select.new_metro.view_model.SelectMetroViewModelFactory_Factory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.List;
import javax.inject.Provider;
public final class DaggerSelectMetroFragmentComponent implements SelectMetroFragmentComponent {
    public final CoreComponentDependencies a;
    public Provider<MetroLineItemPresenter> b;
    public Provider<MetroLineItemBluePrint> c;
    public Provider<MetroStationItemPresenter> d = DoubleCheck.provider(MetroStationItemPresenterImpl_Factory.create());
    public Provider<MetroStationItemBluePrint> e = SelectMetroFragmentModule_GetMetroStationItemBlueprint$select_releaseFactory.create(CheckBoxListItemViewProvider_Factory.create(), this.d);
    public Provider<MetroFilterItemPresenter> f = DoubleCheck.provider(MetroFilterItemPresenterImpl_Factory.create());
    public Provider<MetroFilterItemBluePrint> g = DoubleCheck.provider(SelectMetroFragmentModule_GetMetroFilterItemProvider$select_releaseFactory.create(CheckBoxListItemViewProvider_Factory.create(), this.f));
    public Provider<MetroListOutputTypePresenter> h;
    public Provider<MetroListOutputTypeBluePrint> i;
    public Provider<MetroSelectedStationsItemPresenter> j;
    public Provider<MetroSelectedStationsItemBlueprint> k;
    public Provider<MetroListGapItemBlueprint> l;
    public Provider<ItemBinder> m;
    public Provider<AdapterPresenter> n;
    public Provider<SimpleRecyclerAdapter> o;
    public Provider<DiffCalculator> p;
    public Provider<DataAwareAdapterPresenter> q;
    public Provider<SelectMetroParams> r;
    public Provider<Fragment> s;
    public Provider<List<Integer>> t;
    public Provider<ItemsHolder> u;
    public Provider<SchedulersFactory3> v;
    public Provider<Analytics> w;
    public Provider<SelectMetroAnalytics> x;
    public Provider<SelectMetroViewModelFactory> y;
    public Provider<SelectMetroViewModel> z;

    public static final class b implements SelectMetroFragmentComponent.Builder {
        public Fragment a;
        public SelectMetroParams b;
        public List<Integer> c;
        public CoreComponentDependencies d;

        public b(a aVar) {
        }

        @Override // com.avito.android.select.new_metro.di.SelectMetroFragmentComponent.Builder
        public SelectMetroFragmentComponent.Builder bindFragment(Fragment fragment) {
            this.a = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.select.new_metro.di.SelectMetroFragmentComponent.Builder
        public SelectMetroFragmentComponent.Builder bindParams(SelectMetroParams selectMetroParams) {
            this.b = (SelectMetroParams) Preconditions.checkNotNull(selectMetroParams);
            return this;
        }

        @Override // com.avito.android.select.new_metro.di.SelectMetroFragmentComponent.Builder
        public SelectMetroFragmentComponent.Builder bindSelectedStations(List list) {
            this.c = (List) Preconditions.checkNotNull(list);
            return this;
        }

        @Override // com.avito.android.select.new_metro.di.SelectMetroFragmentComponent.Builder
        public SelectMetroFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Fragment.class);
            Preconditions.checkBuilderRequirement(this.b, SelectMetroParams.class);
            Preconditions.checkBuilderRequirement(this.c, List.class);
            Preconditions.checkBuilderRequirement(this.d, CoreComponentDependencies.class);
            return new DaggerSelectMetroFragmentComponent(this.d, this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.select.new_metro.di.SelectMetroFragmentComponent.Builder
        public SelectMetroFragmentComponent.Builder setDependencies(CoreComponentDependencies coreComponentDependencies) {
            this.d = (CoreComponentDependencies) Preconditions.checkNotNull(coreComponentDependencies);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final CoreComponentDependencies a;

        public c(CoreComponentDependencies coreComponentDependencies) {
            this.a = coreComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final CoreComponentDependencies a;

        public d(CoreComponentDependencies coreComponentDependencies) {
            this.a = coreComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerSelectMetroFragmentComponent(CoreComponentDependencies coreComponentDependencies, Fragment fragment, SelectMetroParams selectMetroParams, List list, a aVar) {
        this.a = coreComponentDependencies;
        Provider<MetroLineItemPresenter> provider = DoubleCheck.provider(MetroLineItemPresenterImpl_Factory.create());
        this.b = provider;
        this.c = DoubleCheck.provider(SelectMetroFragmentModule_GetGetMetroLineBluePrint$select_releaseFactory.create(provider));
        Provider<MetroListOutputTypePresenter> provider2 = DoubleCheck.provider(MetroListOutputTypePresenterImpl_Factory.create());
        this.h = provider2;
        this.i = DoubleCheck.provider(SelectMetroFragmentModule_GetMetroListOutputTypeBluePrint$select_releaseFactory.create(provider2));
        Provider<MetroSelectedStationsItemPresenter> provider3 = DoubleCheck.provider(MetroSelectedStationsItemPresenterImpl_Factory.create());
        this.j = provider3;
        this.k = MetroSelectedStationsItemBlueprint_Factory.create(provider3);
        MetroListGapItemBlueprint_Factory create = MetroListGapItemBlueprint_Factory.create(MetroListGapItemPresenter_Factory.create());
        this.l = create;
        Provider<ItemBinder> provider4 = DoubleCheck.provider(SelectMetroFragmentModule_GetBinder$select_releaseFactory.create(this.c, this.e, this.g, this.i, this.k, create));
        this.m = provider4;
        Provider<AdapterPresenter> provider5 = DoubleCheck.provider(SelectMetroFragmentModule_GetAdapter$select_releaseFactory.create(provider4));
        this.n = provider5;
        this.o = DoubleCheck.provider(SelectMetroFragmentModule_GetRecyclerAdapter$select_releaseFactory.create(provider5, this.m));
        Provider<DiffCalculator> provider6 = DoubleCheck.provider(SelectMetroFragmentModule_ProvideDiffCalculator$select_releaseFactory.create(MetroItemsComparator_Factory.create()));
        this.p = provider6;
        this.q = DoubleCheck.provider(SelectMetroFragmentModule_ProvideDataAwareAdapterPresenter$select_releaseFactory.create(this.o, this.n, provider6));
        this.r = InstanceFactory.create(selectMetroParams);
        this.s = InstanceFactory.create(fragment);
        Factory create2 = InstanceFactory.create(list);
        this.t = create2;
        this.u = DoubleCheck.provider(SelectMetroFragmentModule_GetItemsHolder$select_releaseFactory.create(this.r, this.s, create2));
        this.v = new d(coreComponentDependencies);
        c cVar = new c(coreComponentDependencies);
        this.w = cVar;
        Provider<SelectMetroAnalytics> provider7 = SingleCheck.provider(SelectMetroBaseModule_GetAnalyticsInteractorFactory.create(cVar));
        this.x = provider7;
        SelectMetroViewModelFactory_Factory create3 = SelectMetroViewModelFactory_Factory.create(this.u, this.v, provider7, this.r);
        this.y = create3;
        this.z = DoubleCheck.provider(SelectMetroFragmentModule_GetSelectViewModel$select_releaseFactory.create(create3, this.s));
    }

    public static SelectMetroFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.select.new_metro.di.SelectMetroFragmentComponent
    public void inject(SelectMetroFragment selectMetroFragment) {
        SelectMetroFragment_MembersInjector.injectRecyclerPresenter(selectMetroFragment, this.q.get());
        SelectMetroFragment_MembersInjector.injectRecyclerAdapter(selectMetroFragment, this.o.get());
        SelectMetroFragment_MembersInjector.injectSelectMetroViewModel(selectMetroFragment, this.z.get());
        SelectMetroFragment_MembersInjector.injectItemBinder(selectMetroFragment, this.m.get());
        SelectMetroFragment_MembersInjector.injectMetroLineItemPresenter(selectMetroFragment, this.b.get());
        SelectMetroFragment_MembersInjector.injectMetroStationsPresenter(selectMetroFragment, this.d.get());
        SelectMetroFragment_MembersInjector.injectMetroTypePresenter(selectMetroFragment, this.h.get());
        SelectMetroFragment_MembersInjector.injectMetroFiltersPresenter(selectMetroFragment, this.f.get());
        SelectMetroFragment_MembersInjector.injectSelectedStationsItemPresenter(selectMetroFragment, this.j.get());
        SelectMetroFragment_MembersInjector.injectFeatures(selectMetroFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
    }
}
