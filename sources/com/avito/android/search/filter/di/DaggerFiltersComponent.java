package com.avito.android.search.filter.di;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.CategoriesInteractor;
import com.avito.android.Features;
import com.avito.android.FilterAnalyticsData;
import com.avito.android.TopLocationInteractor;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator_Factory;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.blueprints.CheckBoxItemPresenter;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.common.InputFormatter;
import com.avito.android.geo.GeoStorage;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.SavedLocationInteractorImpl;
import com.avito.android.location.SavedLocationInteractorImpl_Factory;
import com.avito.android.location.SavedLocationStorage;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl_Factory;
import com.avito.android.location.back_navigation.BackNavigationLocationInteractor;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.location.di.module.FindDetectLocationModule_ProvideDefaultLocationInteractorFactory;
import com.avito.android.location.di.module.FindDetectLocationModule_ProvideDefaultLocationProviderFactory;
import com.avito.android.location.di.module.FindDetectLocationModule_ProvideDetectLocationHelper$user_location_releaseFactory;
import com.avito.android.location.di.module.FindDetectLocationModule_ProvideDetectLocationInteractor$user_location_releaseFactory;
import com.avito.android.location.di.module.FindDetectLocationModule_ProvideWeakHandler$user_location_releaseFactory;
import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.location.find.DefaultLocationProvider;
import com.avito.android.location.find.DetectLocationInteractor;
import com.avito.android.location.find.DetectLocationProvider;
import com.avito.android.location.find.DetectLocationProviderImpl;
import com.avito.android.location.find.DetectLocationProviderImpl_Factory;
import com.avito.android.location.find.FindDetectLocationPresenter;
import com.avito.android.location.find.FindDetectLocationPresenterImpl;
import com.avito.android.location.find.FindDetectLocationPresenterImpl_Factory;
import com.avito.android.location.find.util.DetectLocationHelper;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.permissions.LocationPermissionProviderImpl;
import com.avito.android.permissions.LocationPermissionProviderImpl_Factory;
import com.avito.android.price.PriceInputFormatterImpl_Factory;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl_Factory;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.search.filter.CategoriesParameterFactory;
import com.avito.android.search.filter.CategoriesParameterFactoryImpl;
import com.avito.android.search.filter.CategoriesParameterFactoryImpl_Factory;
import com.avito.android.search.filter.DialogResourceProvider;
import com.avito.android.search.filter.FiltersChangeProvider;
import com.avito.android.search.filter.FiltersChangeProviderImpl_Factory;
import com.avito.android.search.filter.FiltersFragment;
import com.avito.android.search.filter.FiltersFragment_MembersInjector;
import com.avito.android.search.filter.FiltersInteractor;
import com.avito.android.search.filter.FiltersInteractorImpl;
import com.avito.android.search.filter.FiltersInteractorImpl_Factory;
import com.avito.android.search.filter.FiltersPresenter;
import com.avito.android.search.filter.FiltersPresenterImpl;
import com.avito.android.search.filter.FiltersPresenterImpl_Factory;
import com.avito.android.search.filter.FiltersResourceProvider;
import com.avito.android.search.filter.FiltersResourceProviderImpl;
import com.avito.android.search.filter.FiltersResourceProviderImpl_Factory;
import com.avito.android.search.filter.InputItemFormatterProvider;
import com.avito.android.search.filter.InputItemFormatterProviderImpl;
import com.avito.android.search.filter.InputItemFormatterProviderImpl_Factory;
import com.avito.android.search.filter.MultiselectDialogFactory;
import com.avito.android.search.filter.MultiselectDialogFactoryImpl;
import com.avito.android.search.filter.MultiselectDialogFactoryImpl_Factory;
import com.avito.android.search.filter.MultiselectDialogPresenter;
import com.avito.android.search.filter.MultiselectDialogPresenterImpl;
import com.avito.android.search.filter.MultiselectDialogPresenterImpl_Factory;
import com.avito.android.search.filter.ParametersTreeMapConverter;
import com.avito.android.search.filter.ParametersTreeMapConverterImpl_Factory;
import com.avito.android.search.filter.ParametersTreeSearchParamsConverter;
import com.avito.android.search.filter.ParametersTreeSearchParamsConverterImpl_Factory;
import com.avito.android.search.filter.ReplaceLocationParametersTreeWrapper;
import com.avito.android.search.filter.ReplaceLocationParametersTreeWrapperImpl_Factory;
import com.avito.android.search.filter.SelectDialogFactory;
import com.avito.android.search.filter.SelectDialogFactoryImpl;
import com.avito.android.search.filter.SelectDialogFactoryImpl_Factory;
import com.avito.android.search.filter.SelectDialogPresenter;
import com.avito.android.search.filter.SelectDialogPresenterImpl;
import com.avito.android.search.filter.SelectDialogPresenterImpl_Factory;
import com.avito.android.search.filter.SelectableItemIconFactory;
import com.avito.android.search.filter.SelectableItemIconFactoryImpl;
import com.avito.android.search.filter.SelectableItemIconFactoryImpl_Factory;
import com.avito.android.search.filter.SelectableItemIconFactoryResourceProvider;
import com.avito.android.search.filter.SelectableItemIconFactoryResourceProviderImpl;
import com.avito.android.search.filter.SelectableItemIconFactoryResourceProviderImpl_Factory;
import com.avito.android.search.filter.adapter.BubblesSelectItemBlueprint;
import com.avito.android.search.filter.adapter.BubblesSelectItemBlueprint_Factory;
import com.avito.android.search.filter.adapter.BubblesSelectItemPresenter;
import com.avito.android.search.filter.adapter.BubblesSelectItemPresenterImpl;
import com.avito.android.search.filter.adapter.BubblesSelectItemPresenterImpl_Factory;
import com.avito.android.search.filter.adapter.ChangeDisplayTypeBlueprint;
import com.avito.android.search.filter.adapter.ChangeDisplayTypeBlueprint_Factory;
import com.avito.android.search.filter.adapter.ChangeDisplayTypePresenter;
import com.avito.android.search.filter.adapter.ChangeDisplayTypePresenterImpl;
import com.avito.android.search.filter.adapter.ChangeDisplayTypePresenterImpl_Factory;
import com.avito.android.search.filter.adapter.CheckBoxItemBlueprint;
import com.avito.android.search.filter.adapter.CheckBoxItemBlueprint_Factory;
import com.avito.android.search.filter.adapter.DisplayTypeSelectItemBlueprint;
import com.avito.android.search.filter.adapter.DisplayTypeSelectItemBlueprint_Factory;
import com.avito.android.search.filter.adapter.DisplayTypeSelectPresenter;
import com.avito.android.search.filter.adapter.DisplayTypeSelectPresenter_Factory;
import com.avito.android.search.filter.adapter.FilterItemsContentsComparator;
import com.avito.android.search.filter.adapter.FilterItemsContentsComparatorImpl_Factory;
import com.avito.android.search.filter.adapter.InlineMultiselectItemBlueprint;
import com.avito.android.search.filter.adapter.InlineMultiselectItemBlueprint_Factory;
import com.avito.android.search.filter.adapter.InlineMultiselectItemPresenter;
import com.avito.android.search.filter.adapter.InlineMultiselectItemPresenterImpl;
import com.avito.android.search.filter.adapter.InlineMultiselectItemPresenterImpl_Factory;
import com.avito.android.search.filter.adapter.InlineSelectItemBlueprint;
import com.avito.android.search.filter.adapter.InlineSelectItemBlueprint_Factory;
import com.avito.android.search.filter.adapter.InlineSelectItemPresenter;
import com.avito.android.search.filter.adapter.InlineSelectItemPresenterImpl;
import com.avito.android.search.filter.adapter.InlineSelectItemPresenterImpl_Factory;
import com.avito.android.search.filter.adapter.InlineTabsSelectItemBlueprint;
import com.avito.android.search.filter.adapter.InlineTabsSelectItemBlueprint_Factory;
import com.avito.android.search.filter.adapter.InlineTabsSelectItemPresenter;
import com.avito.android.search.filter.adapter.InlineTabsSelectItemPresenterImpl;
import com.avito.android.search.filter.adapter.InlineTabsSelectItemPresenterImpl_Factory;
import com.avito.android.search.filter.adapter.InputItemBlueprint;
import com.avito.android.search.filter.adapter.InputItemBlueprint_Factory;
import com.avito.android.search.filter.adapter.InputItemPresenter;
import com.avito.android.search.filter.adapter.InputItemPresenterImpl;
import com.avito.android.search.filter.adapter.InputItemPresenterImpl_Factory;
import com.avito.android.search.filter.adapter.MultiselectItemBlueprint;
import com.avito.android.search.filter.adapter.MultiselectItemBlueprint_Factory;
import com.avito.android.search.filter.adapter.MultiselectItemPresenter;
import com.avito.android.search.filter.adapter.MultiselectItemPresenterImpl;
import com.avito.android.search.filter.adapter.MultiselectItemPresenterImpl_Factory;
import com.avito.android.search.filter.adapter.SelectItemBlueprint;
import com.avito.android.search.filter.adapter.SelectItemBlueprint_Factory;
import com.avito.android.search.filter.adapter.SelectItemPresenter;
import com.avito.android.search.filter.adapter.SelectItemPresenterImpl;
import com.avito.android.search.filter.adapter.SelectItemPresenterImpl_Factory;
import com.avito.android.search.filter.adapter.SelectableItemCheckBoxBlueprint;
import com.avito.android.search.filter.adapter.SelectableItemCheckBoxBlueprint_Factory;
import com.avito.android.search.filter.adapter.SelectableItemPresenter;
import com.avito.android.search.filter.adapter.SelectableItemPresenterMultiselectImpl;
import com.avito.android.search.filter.adapter.SelectableItemPresenterMultiselectImpl_Factory;
import com.avito.android.search.filter.adapter.SelectableItemPresenterSelectImpl;
import com.avito.android.search.filter.adapter.SelectableItemPresenterSelectImpl_Factory;
import com.avito.android.search.filter.adapter.SelectableItemRadioButtonBlueprint;
import com.avito.android.search.filter.adapter.SelectableItemRadioButtonBlueprint_Factory;
import com.avito.android.search.filter.analytics.FilterAnalyticsInteractor;
import com.avito.android.search.filter.analytics.FilterAnalyticsInteractorImpl;
import com.avito.android.search.filter.analytics.FilterAnalyticsInteractorImpl_Factory;
import com.avito.android.search.filter.di.FiltersComponent;
import com.avito.android.search.filter.groupSelect.GroupSelectDialogFactory;
import com.avito.android.search.filter.groupSelect.GroupSelectDialogFactoryImpl;
import com.avito.android.search.filter.groupSelect.GroupSelectDialogFactoryImpl_Factory;
import com.avito.android.search.filter.groupSelect.GroupSelectDialogPresenter;
import com.avito.android.search.filter.groupSelect.GroupSelectDialogPresenterImpl;
import com.avito.android.search.filter.groupSelect.GroupSelectDialogPresenterImpl_Factory;
import com.avito.android.search.filter.tracker.FiltersTracker;
import com.avito.android.search.filter.tracker.FiltersTrackerImpl;
import com.avito.android.search.filter.tracker.FiltersTrackerImpl_Factory;
import com.avito.android.select.group_select.GroupSelectPresenter_Factory;
import com.avito.android.select.new_metro.analytics.SelectMetroAnalytics;
import com.avito.android.select.new_metro.di.SelectMetroBaseModule_GetAnalyticsInteractorFactory;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.WeakHandler;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerFiltersComponent implements FiltersComponent {
    public Provider<GeoStorage> A;
    public Provider<ItemBinder> A0;
    public Provider<GroupSelectDialogPresenter> A1;
    public Provider<DefaultLocationInteractor> B;
    public Provider<AdapterPresenter> B0;
    public Provider<GroupSelectDialogFactoryImpl> B1;
    public Provider<DefaultLocationProvider> C;
    public Provider<SimpleRecyclerAdapter> C0;
    public Provider<GroupSelectDialogFactory> C1;
    public Provider<Activity> D;
    public Provider<ListUpdateCallback> D0;
    public Provider<ActivityInteractor> E;
    public Provider<FilterItemsContentsComparator> E0;
    public Provider<WeakHandler> F;
    public Provider<DiffCalculator> F0;
    public Provider<DetectLocationHelper> G;
    public Provider<DataAwareAdapterPresenter> G0;
    public Provider<SchedulersFactory> H;
    public Provider<Locale> H0;
    public Provider<DetectLocationInteractor> I;
    public Provider<Boolean> I0;
    public Provider<DetectLocationProviderImpl> J;
    public Provider<HtmlCleaner> J0;
    public Provider<DetectLocationProvider> K;
    public Provider<HtmlNodeFactory> K0;
    public Provider<FindDetectLocationPresenterImpl> L;
    public Provider<CategoryParametersElementConverter> L0;
    public Provider<FindDetectLocationPresenter> M;
    public Provider<FilterAnalyticsData> M0;
    public Provider<Analytics> N;
    public Provider<FilterAnalyticsInteractorImpl> N0;
    public Provider<TimeSource> O;
    public Provider<FilterAnalyticsInteractor> O0;
    public Provider<LocationAnalyticsInteractorImpl> P;
    public Provider<SelectMetroAnalytics> P0;
    public Provider<LocationAnalyticsInteractor> Q;
    public Provider<ScreenTrackerFactory> Q0;
    public Provider<FiltersInteractorImpl> R;
    public Provider<TimerFactory> R0;
    public Provider<FiltersInteractor> S;
    public Provider<ScreenDiInjectTracker> S0;
    public Provider<FiltersChangeProvider> T;
    public Provider<ScreenInitTracker> T0;
    public Provider<SelectItemPresenterImpl> U;
    public Provider<ScreenFlowTrackerProvider> U0;
    public Provider<SelectItemPresenter> V;
    public Provider<FiltersTrackerImpl> V0;
    public Provider<SelectItemBlueprint> W;
    public Provider<FiltersTracker> W0;
    public Provider<InputFormatter> X;
    public Provider<Boolean> X0;
    public Provider<InputItemFormatterProviderImpl> Y;
    public Provider<Kundle> Y0;
    public Provider<InputItemFormatterProvider> Z;
    public Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> Z0;
    public final FiltersDependencies a;
    public Provider<InputItemPresenterImpl> a0;
    public Provider<SavedLocationStorage> a1;
    public Provider<CategoriesInteractor> b;
    public Provider<InputItemPresenter> b0;
    public Provider<BackNavigationLocationInteractor> b1;
    public Provider<TopLocationInteractor> c;
    public Provider<InputItemBlueprint> c0;
    public Provider<SavedLocationInteractorImpl> c1;
    public Provider<LocationApi> d;
    public Provider<CheckBoxItemPresenter> d0;
    public Provider<SavedLocationInteractor> d1;
    public Provider<SearchApi> e;
    public Provider<CheckBoxItemBlueprint> e0;
    public Provider<FiltersPresenterImpl> e1;
    public Provider<Resources> f;
    public Provider<MultiselectItemPresenterImpl> f0;
    public Provider<FiltersPresenter> f1;
    public Provider<FiltersResourceProviderImpl> g;
    public Provider<MultiselectItemPresenter> g0;
    public Provider<DialogResourceProvider> g1;
    public Provider<FiltersResourceProvider> h;
    public Provider<MultiselectItemBlueprint> h0;
    public Provider<MultiselectDialogPresenterImpl> h1;
    public Provider<CategoriesParameterFactoryImpl> i;
    public Provider<InlineMultiselectItemPresenterImpl> i0;
    public Provider<MultiselectDialogPresenter> i1;
    public Provider<CategoriesParameterFactory> j;
    public Provider<InlineMultiselectItemPresenter> j0;
    public Provider<SelectableItemPresenterMultiselectImpl> j1;
    public Provider<ReplaceLocationParametersTreeWrapper> k = DoubleCheck.provider(ReplaceLocationParametersTreeWrapperImpl_Factory.create());
    public Provider<InlineMultiselectItemBlueprint> k0;
    public Provider<SelectableItemPresenter> k1;
    public Provider<SearchParams> l;
    public Provider<InlineSelectItemPresenterImpl> l0;
    public Provider<SelectableItemIconFactoryResourceProviderImpl> l1;
    public Provider<Area> m;
    public Provider<InlineSelectItemPresenter> m0;
    public Provider<SelectableItemIconFactoryResourceProvider> m1;
    public Provider<String> n;
    public Provider<InlineSelectItemBlueprint> n0;
    public Provider<SelectableItemIconFactoryImpl> n1;
    public Provider<Boolean> o;
    public Provider<ChangeDisplayTypePresenterImpl> o0;
    public Provider<SelectableItemIconFactory> o1;
    public Provider<SearchParamsConverter> p;
    public Provider<ChangeDisplayTypePresenter> p0;
    public Provider<SelectableItemCheckBoxBlueprint> p1;
    public Provider<ParametersTreeMapConverter> q;
    public Provider<ChangeDisplayTypeBlueprint> q0;
    public Provider<MultiselectDialogFactoryImpl> q1;
    public Provider<ParametersTreeSearchParamsConverter> r;
    public Provider<DisplayTypeSelectPresenter> r0;
    public Provider<MultiselectDialogFactory> r1;
    public Provider<TypedErrorThrowableConverter> s;
    public Provider<DisplayTypeSelectItemBlueprint> s0;
    public Provider<SelectDialogPresenterImpl> s1;
    public Provider<SchedulersFactory3> t;
    public Provider<Kundle> t0;
    public Provider<SelectDialogPresenter> t1;
    public Provider<Features> u;
    public Provider<BubblesSelectItemPresenterImpl> u0;
    public Provider<SelectableItemPresenterSelectImpl> u1;
    public Provider<Kundle> v;
    public Provider<BubblesSelectItemPresenter> v0;
    public Provider<SelectableItemPresenter> v1;
    public Provider<Fragment> w;
    public Provider<BubblesSelectItemBlueprint> w0;
    public Provider<SelectableItemRadioButtonBlueprint> w1;
    public Provider<LocationPermissionProviderImpl> x;
    public Provider<InlineTabsSelectItemPresenterImpl> x0;
    public Provider<SelectDialogFactoryImpl> x1;
    public Provider<LocationPermissionProvider> y;
    public Provider<InlineTabsSelectItemPresenter> y0;
    public Provider<SelectDialogFactory> y1;
    public Provider<LocationPermissionDialogPresenter> z;
    public Provider<InlineTabsSelectItemBlueprint> z0;
    public Provider<GroupSelectDialogPresenterImpl> z1;

    public static final class b implements FiltersComponent.Builder {
        public FiltersDependencies a;
        public LocationDependencies b;
        public Kundle c;
        public Boolean d;
        public Boolean e;
        public Resources f;
        public Activity g;
        public Fragment h;
        public ActivityInteractor i;
        public SearchParams j;
        public FilterAnalyticsData k;
        public Area l;
        public Boolean m;
        public String n;
        public Kundle o;
        public Kundle p;

        public b(a aVar) {
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent build() {
            Preconditions.checkBuilderRequirement(this.a, FiltersDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, LocationDependencies.class);
            Preconditions.checkBuilderRequirement(this.d, Boolean.class);
            Preconditions.checkBuilderRequirement(this.e, Boolean.class);
            Preconditions.checkBuilderRequirement(this.f, Resources.class);
            Preconditions.checkBuilderRequirement(this.g, Activity.class);
            Preconditions.checkBuilderRequirement(this.h, Fragment.class);
            Preconditions.checkBuilderRequirement(this.i, ActivityInteractor.class);
            Preconditions.checkBuilderRequirement(this.m, Boolean.class);
            return new DaggerFiltersComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, null);
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent.Builder dependentOn(FiltersDependencies filtersDependencies) {
            this.a = (FiltersDependencies) Preconditions.checkNotNull(filtersDependencies);
            return this;
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent.Builder locationDependencies(LocationDependencies locationDependencies) {
            this.b = (LocationDependencies) Preconditions.checkNotNull(locationDependencies);
            return this;
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent.Builder withActivity(Activity activity) {
            this.g = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent.Builder withActivityInteractor(ActivityInteractor activityInteractor) {
            this.i = (ActivityInteractor) Preconditions.checkNotNull(activityInteractor);
            return this;
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent.Builder withBubblePresenterState(Kundle kundle) {
            this.p = kundle;
            return this;
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent.Builder withFilterAnalyticsData(FilterAnalyticsData filterAnalyticsData) {
            this.k = filterAnalyticsData;
            return this;
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent.Builder withFragment(Fragment fragment) {
            this.h = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent.Builder withInteractorState(Kundle kundle) {
            this.o = kundle;
            return this;
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent.Builder withIsFirstStart(boolean z) {
            this.e = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent.Builder withIsOnlySortShown(boolean z) {
            this.d = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent.Builder withMapSerpState(String str) {
            this.n = str;
            return this;
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent.Builder withPresenterState(Kundle kundle) {
            this.c = kundle;
            return this;
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent.Builder withResources(Resources resources) {
            this.f = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent.Builder withSearchArea(Area area) {
            this.l = area;
            return this;
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent.Builder withSearchParams(SearchParams searchParams) {
            this.j = searchParams;
            return this;
        }

        @Override // com.avito.android.search.filter.di.FiltersComponent.Builder
        public FiltersComponent.Builder withShowSimpleMap(boolean z) {
            this.m = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }
    }

    public static class c implements Provider<BackNavigationLocationInteractor> {
        public final LocationDependencies a;

        public c(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BackNavigationLocationInteractor get() {
            return (BackNavigationLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.backNavigationLocationInteractor());
        }
    }

    public static class d implements Provider<LocationApi> {
        public final LocationDependencies a;

        public d(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LocationApi get() {
            return (LocationApi) Preconditions.checkNotNullFromComponent(this.a.locationApi());
        }
    }

    public static class e implements Provider<SavedLocationStorage> {
        public final LocationDependencies a;

        public e(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SavedLocationStorage get() {
            return (SavedLocationStorage) Preconditions.checkNotNullFromComponent(this.a.savedLocationStorage());
        }
    }

    public static class f implements Provider<TopLocationInteractor> {
        public final LocationDependencies a;

        public f(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TopLocationInteractor get() {
            return (TopLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.topLocationInteractor());
        }
    }

    public static class g implements Provider<Analytics> {
        public final FiltersDependencies a;

        public g(FiltersDependencies filtersDependencies) {
            this.a = filtersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class h implements Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> {
        public final FiltersDependencies a;

        public h(FiltersDependencies filtersDependencies) {
            this.a = filtersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SingleManuallyExposedAbTestGroup<SimpleTestGroup> get() {
            return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.autoGenerationsFilterWithPhotosTestGroup());
        }
    }

    public static class i implements Provider<CategoriesInteractor> {
        public final FiltersDependencies a;

        public i(FiltersDependencies filtersDependencies) {
            this.a = filtersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CategoriesInteractor get() {
            return (CategoriesInteractor) Preconditions.checkNotNullFromComponent(this.a.categoriesInteractor());
        }
    }

    public static class j implements Provider<Features> {
        public final FiltersDependencies a;

        public j(FiltersDependencies filtersDependencies) {
            this.a = filtersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class k implements Provider<GeoStorage> {
        public final FiltersDependencies a;

        public k(FiltersDependencies filtersDependencies) {
            this.a = filtersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public GeoStorage get() {
            return (GeoStorage) Preconditions.checkNotNullFromComponent(this.a.geoStorage());
        }
    }

    public static class l implements Provider<HtmlCleaner> {
        public final FiltersDependencies a;

        public l(FiltersDependencies filtersDependencies) {
            this.a = filtersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlCleaner get() {
            return (HtmlCleaner) Preconditions.checkNotNullFromComponent(this.a.htmlCleaner());
        }
    }

    public static class m implements Provider<HtmlNodeFactory> {
        public final FiltersDependencies a;

        public m(FiltersDependencies filtersDependencies) {
            this.a = filtersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlNodeFactory get() {
            return (HtmlNodeFactory) Preconditions.checkNotNullFromComponent(this.a.htmlNodeFactory());
        }
    }

    public static class n implements Provider<Locale> {
        public final FiltersDependencies a;

        public n(FiltersDependencies filtersDependencies) {
            this.a = filtersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class o implements Provider<SchedulersFactory3> {
        public final FiltersDependencies a;

        public o(FiltersDependencies filtersDependencies) {
            this.a = filtersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class p implements Provider<SchedulersFactory> {
        public final FiltersDependencies a;

        public p(FiltersDependencies filtersDependencies) {
            this.a = filtersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class q implements Provider<ScreenTrackerFactory> {
        public final FiltersDependencies a;

        public q(FiltersDependencies filtersDependencies) {
            this.a = filtersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class r implements Provider<SearchApi> {
        public final FiltersDependencies a;

        public r(FiltersDependencies filtersDependencies) {
            this.a = filtersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchApi get() {
            return (SearchApi) Preconditions.checkNotNullFromComponent(this.a.searchApi());
        }
    }

    public static class s implements Provider<TimeSource> {
        public final FiltersDependencies a;

        public s(FiltersDependencies filtersDependencies) {
            this.a = filtersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class t implements Provider<TimerFactory> {
        public final FiltersDependencies a;

        public t(FiltersDependencies filtersDependencies) {
            this.a = filtersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class u implements Provider<TypedErrorThrowableConverter> {
        public final FiltersDependencies a;

        public u(FiltersDependencies filtersDependencies) {
            this.a = filtersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerFiltersComponent(FiltersDependencies filtersDependencies, LocationDependencies locationDependencies, Kundle kundle, Boolean bool, Boolean bool2, Resources resources, Activity activity, Fragment fragment, ActivityInteractor activityInteractor, SearchParams searchParams, FilterAnalyticsData filterAnalyticsData, Area area, Boolean bool3, String str, Kundle kundle2, Kundle kundle3, a aVar) {
        this.a = filtersDependencies;
        this.b = new i(filtersDependencies);
        this.c = new f(locationDependencies);
        this.d = new d(locationDependencies);
        this.e = new r(filtersDependencies);
        Factory create = InstanceFactory.create(resources);
        this.f = create;
        FiltersResourceProviderImpl_Factory create2 = FiltersResourceProviderImpl_Factory.create(create);
        this.g = create2;
        Provider<FiltersResourceProvider> provider = DoubleCheck.provider(create2);
        this.h = provider;
        CategoriesParameterFactoryImpl_Factory create3 = CategoriesParameterFactoryImpl_Factory.create(provider);
        this.i = create3;
        this.j = DoubleCheck.provider(create3);
        this.l = InstanceFactory.createNullable(searchParams);
        this.m = InstanceFactory.createNullable(area);
        this.n = InstanceFactory.createNullable(str);
        this.o = InstanceFactory.create(bool3);
        this.p = DoubleCheck.provider(SearchParamsConverterImpl_Factory.create());
        this.q = DoubleCheck.provider(ParametersTreeMapConverterImpl_Factory.create());
        this.r = DoubleCheck.provider(ParametersTreeSearchParamsConverterImpl_Factory.create());
        this.s = new u(filtersDependencies);
        this.t = new o(filtersDependencies);
        this.u = new j(filtersDependencies);
        this.v = InstanceFactory.createNullable(kundle2);
        Factory create4 = InstanceFactory.create(fragment);
        this.w = create4;
        LocationPermissionProviderImpl_Factory create5 = LocationPermissionProviderImpl_Factory.create(create4);
        this.x = create5;
        Provider<LocationPermissionProvider> provider2 = DoubleCheck.provider(create5);
        this.y = provider2;
        this.z = DoubleCheck.provider(FiltersModule_ProvideLocationPermissionDialogPresenter$filter_releaseFactory.create(provider2));
        k kVar = new k(filtersDependencies);
        this.A = kVar;
        Provider<DefaultLocationInteractor> provider3 = DoubleCheck.provider(FindDetectLocationModule_ProvideDefaultLocationInteractorFactory.create(kVar));
        this.B = provider3;
        this.C = DoubleCheck.provider(FindDetectLocationModule_ProvideDefaultLocationProviderFactory.create(provider3));
        this.D = InstanceFactory.create(activity);
        this.E = InstanceFactory.create(activityInteractor);
        Provider<WeakHandler> provider4 = DoubleCheck.provider(FindDetectLocationModule_ProvideWeakHandler$user_location_releaseFactory.create());
        this.F = provider4;
        Provider<DetectLocationHelper> provider5 = DoubleCheck.provider(FindDetectLocationModule_ProvideDetectLocationHelper$user_location_releaseFactory.create(this.D, this.E, provider4));
        this.G = provider5;
        p pVar = new p(filtersDependencies);
        this.H = pVar;
        Provider<DetectLocationInteractor> provider6 = DoubleCheck.provider(FindDetectLocationModule_ProvideDetectLocationInteractor$user_location_releaseFactory.create(provider5, pVar, this.A));
        this.I = provider6;
        DetectLocationProviderImpl_Factory create6 = DetectLocationProviderImpl_Factory.create(provider6);
        this.J = create6;
        Provider<DetectLocationProvider> provider7 = DoubleCheck.provider(create6);
        this.K = provider7;
        FindDetectLocationPresenterImpl_Factory create7 = FindDetectLocationPresenterImpl_Factory.create(this.C, provider7);
        this.L = create7;
        this.M = DoubleCheck.provider(create7);
        g gVar = new g(filtersDependencies);
        this.N = gVar;
        s sVar = new s(filtersDependencies);
        this.O = sVar;
        LocationAnalyticsInteractorImpl_Factory create8 = LocationAnalyticsInteractorImpl_Factory.create(gVar, sVar);
        this.P = create8;
        Provider<LocationAnalyticsInteractor> provider8 = SingleCheck.provider(create8);
        this.Q = provider8;
        FiltersInteractorImpl_Factory create9 = FiltersInteractorImpl_Factory.create(this.b, this.c, this.d, this.e, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.z, this.M, provider8);
        this.R = create9;
        this.S = DoubleCheck.provider(create9);
        Provider<FiltersChangeProvider> provider9 = DoubleCheck.provider(FiltersChangeProviderImpl_Factory.create());
        this.T = provider9;
        SelectItemPresenterImpl_Factory create10 = SelectItemPresenterImpl_Factory.create(provider9);
        this.U = create10;
        Provider<SelectItemPresenter> provider10 = DoubleCheck.provider(create10);
        this.V = provider10;
        this.W = SelectItemBlueprint_Factory.create(provider10);
        Provider<InputFormatter> provider11 = DoubleCheck.provider(PriceInputFormatterImpl_Factory.create());
        this.X = provider11;
        InputItemFormatterProviderImpl_Factory create11 = InputItemFormatterProviderImpl_Factory.create(provider11);
        this.Y = create11;
        Provider<InputItemFormatterProvider> provider12 = DoubleCheck.provider(create11);
        this.Z = provider12;
        InputItemPresenterImpl_Factory create12 = InputItemPresenterImpl_Factory.create(this.T, provider12);
        this.a0 = create12;
        Provider<InputItemPresenter> provider13 = DoubleCheck.provider(create12);
        this.b0 = provider13;
        this.c0 = InputItemBlueprint_Factory.create(provider13);
        Provider<CheckBoxItemPresenter> provider14 = DoubleCheck.provider(FiltersCoreModule_ProvideCheckBoxItemPresenter$filter_releaseFactory.create(this.T));
        this.d0 = provider14;
        this.e0 = CheckBoxItemBlueprint_Factory.create(provider14);
        MultiselectItemPresenterImpl_Factory create13 = MultiselectItemPresenterImpl_Factory.create(this.T);
        this.f0 = create13;
        Provider<MultiselectItemPresenter> provider15 = DoubleCheck.provider(create13);
        this.g0 = provider15;
        this.h0 = MultiselectItemBlueprint_Factory.create(provider15);
        InlineMultiselectItemPresenterImpl_Factory create14 = InlineMultiselectItemPresenterImpl_Factory.create(this.T);
        this.i0 = create14;
        Provider<InlineMultiselectItemPresenter> provider16 = DoubleCheck.provider(create14);
        this.j0 = provider16;
        this.k0 = InlineMultiselectItemBlueprint_Factory.create(provider16);
        InlineSelectItemPresenterImpl_Factory create15 = InlineSelectItemPresenterImpl_Factory.create(this.T);
        this.l0 = create15;
        Provider<InlineSelectItemPresenter> provider17 = DoubleCheck.provider(create15);
        this.m0 = provider17;
        this.n0 = InlineSelectItemBlueprint_Factory.create(provider17);
        ChangeDisplayTypePresenterImpl_Factory create16 = ChangeDisplayTypePresenterImpl_Factory.create(this.T);
        this.o0 = create16;
        Provider<ChangeDisplayTypePresenter> provider18 = DoubleCheck.provider(create16);
        this.p0 = provider18;
        this.q0 = ChangeDisplayTypeBlueprint_Factory.create(provider18);
        DisplayTypeSelectPresenter_Factory create17 = DisplayTypeSelectPresenter_Factory.create(this.T);
        this.r0 = create17;
        this.s0 = DisplayTypeSelectItemBlueprint_Factory.create(create17);
        Factory createNullable = InstanceFactory.createNullable(kundle3);
        this.t0 = createNullable;
        BubblesSelectItemPresenterImpl_Factory create18 = BubblesSelectItemPresenterImpl_Factory.create(this.T, createNullable);
        this.u0 = create18;
        Provider<BubblesSelectItemPresenter> provider19 = DoubleCheck.provider(create18);
        this.v0 = provider19;
        this.w0 = BubblesSelectItemBlueprint_Factory.create(provider19);
        InlineTabsSelectItemPresenterImpl_Factory create19 = InlineTabsSelectItemPresenterImpl_Factory.create(this.T);
        this.x0 = create19;
        Provider<InlineTabsSelectItemPresenter> provider20 = DoubleCheck.provider(create19);
        this.y0 = provider20;
        InlineTabsSelectItemBlueprint_Factory create20 = InlineTabsSelectItemBlueprint_Factory.create(provider20);
        this.z0 = create20;
        Provider<ItemBinder> provider21 = DoubleCheck.provider(FiltersCoreModule_ProvideItemBinder$filter_releaseFactory.create(this.W, this.c0, this.e0, this.h0, this.k0, this.n0, this.q0, this.s0, this.w0, create20));
        this.A0 = provider21;
        Provider<AdapterPresenter> provider22 = DoubleCheck.provider(FiltersCoreModule_ProvideAdapterPresenter$filter_releaseFactory.create(provider21));
        this.B0 = provider22;
        Provider<SimpleRecyclerAdapter> provider23 = DoubleCheck.provider(FiltersCoreModule_ProvideRecyclerAdapter$filter_releaseFactory.create(provider22, this.A0));
        this.C0 = provider23;
        this.D0 = DoubleCheck.provider(FiltersCoreModule_ProvideListUpdateCallback$filter_releaseFactory.create(provider23));
        Provider<FilterItemsContentsComparator> provider24 = DoubleCheck.provider(FilterItemsContentsComparatorImpl_Factory.create());
        this.E0 = provider24;
        Provider<DiffCalculator> provider25 = DoubleCheck.provider(FiltersCoreModule_ProvideDiffCalculator$filter_releaseFactory.create(provider24));
        this.F0 = provider25;
        this.G0 = DoubleCheck.provider(FiltersCoreModule_ProvideDataAwareAdapterPresenter$filter_releaseFactory.create(this.D0, this.B0, provider25));
        this.H0 = new n(filtersDependencies);
        this.I0 = InstanceFactory.create(bool);
        this.J0 = new l(filtersDependencies);
        this.K0 = new m(filtersDependencies);
        this.L0 = DoubleCheck.provider(FiltersModule_ProvideCategoryParametersElementConverter$filter_releaseFactory.create(PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory.create(), this.O, this.H0, this.u, this.I0, this.f, this.J0, this.K0));
        this.M0 = InstanceFactory.createNullable(filterAnalyticsData);
        FilterAnalyticsInteractorImpl_Factory create21 = FilterAnalyticsInteractorImpl_Factory.create(this.N, this.l, TreeStateIdGenerator_Factory.create(), this.M0);
        this.N0 = create21;
        this.O0 = DoubleCheck.provider(create21);
        this.P0 = SingleCheck.provider(SelectMetroBaseModule_GetAnalyticsInteractorFactory.create(this.N));
        q qVar = new q(filtersDependencies);
        this.Q0 = qVar;
        t tVar = new t(filtersDependencies);
        this.R0 = tVar;
        this.S0 = DoubleCheck.provider(FiltersTrackerModule_ProvideScreenDiInjectTracker$filter_releaseFactory.create(qVar, tVar));
        this.T0 = DoubleCheck.provider(FiltersTrackerModule_ProvideScreenInitTrackerFactory.create(this.Q0, this.R0));
        Provider<ScreenFlowTrackerProvider> provider26 = DoubleCheck.provider(FiltersTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.Q0, this.R0));
        this.U0 = provider26;
        FiltersTrackerImpl_Factory create22 = FiltersTrackerImpl_Factory.create(this.S0, this.T0, provider26);
        this.V0 = create22;
        this.W0 = DoubleCheck.provider(create22);
        this.X0 = InstanceFactory.create(bool2);
        this.Y0 = InstanceFactory.createNullable(kundle);
        this.Z0 = new h(filtersDependencies);
        e eVar = new e(locationDependencies);
        this.a1 = eVar;
        c cVar = new c(locationDependencies);
        this.b1 = cVar;
        SavedLocationInteractorImpl_Factory create23 = SavedLocationInteractorImpl_Factory.create(eVar, this.d, this.c, this.u, cVar);
        this.c1 = create23;
        Provider<SavedLocationInteractor> provider27 = SingleCheck.provider(create23);
        this.d1 = provider27;
        FiltersPresenterImpl_Factory create24 = FiltersPresenterImpl_Factory.create(this.S, this.T, this.G0, this.L0, this.h, this.t, this.O0, this.P0, this.W0, this.X0, this.Y0, this.I0, this.Z0, provider27, this.u);
        this.e1 = create24;
        this.f1 = DoubleCheck.provider(create24);
        Provider<DialogResourceProvider> provider28 = DoubleCheck.provider(this.g);
        this.g1 = provider28;
        MultiselectDialogPresenterImpl_Factory create25 = MultiselectDialogPresenterImpl_Factory.create(this.T, provider28);
        this.h1 = create25;
        Provider<MultiselectDialogPresenter> provider29 = DoubleCheck.provider(create25);
        this.i1 = provider29;
        SelectableItemPresenterMultiselectImpl_Factory create26 = SelectableItemPresenterMultiselectImpl_Factory.create(provider29);
        this.j1 = create26;
        this.k1 = DoubleCheck.provider(create26);
        SelectableItemIconFactoryResourceProviderImpl_Factory create27 = SelectableItemIconFactoryResourceProviderImpl_Factory.create(this.f);
        this.l1 = create27;
        Provider<SelectableItemIconFactoryResourceProvider> provider30 = DoubleCheck.provider(create27);
        this.m1 = provider30;
        SelectableItemIconFactoryImpl_Factory create28 = SelectableItemIconFactoryImpl_Factory.create(provider30);
        this.n1 = create28;
        Provider<SelectableItemIconFactory> provider31 = DoubleCheck.provider(create28);
        this.o1 = provider31;
        SelectableItemCheckBoxBlueprint_Factory create29 = SelectableItemCheckBoxBlueprint_Factory.create(this.k1, provider31);
        this.p1 = create29;
        MultiselectDialogFactoryImpl_Factory create30 = MultiselectDialogFactoryImpl_Factory.create(create29, this.i1);
        this.q1 = create30;
        this.r1 = DoubleCheck.provider(create30);
        SelectDialogPresenterImpl_Factory create31 = SelectDialogPresenterImpl_Factory.create(this.T, this.g1);
        this.s1 = create31;
        Provider<SelectDialogPresenter> provider32 = DoubleCheck.provider(create31);
        this.t1 = provider32;
        SelectableItemPresenterSelectImpl_Factory create32 = SelectableItemPresenterSelectImpl_Factory.create(provider32);
        this.u1 = create32;
        Provider<SelectableItemPresenter> provider33 = DoubleCheck.provider(create32);
        this.v1 = provider33;
        SelectableItemRadioButtonBlueprint_Factory create33 = SelectableItemRadioButtonBlueprint_Factory.create(provider33, this.o1);
        this.w1 = create33;
        SelectDialogFactoryImpl_Factory create34 = SelectDialogFactoryImpl_Factory.create(create33, this.t1);
        this.x1 = create34;
        this.y1 = DoubleCheck.provider(create34);
        GroupSelectDialogPresenterImpl_Factory create35 = GroupSelectDialogPresenterImpl_Factory.create(GroupSelectPresenter_Factory.create(), this.T);
        this.z1 = create35;
        Provider<GroupSelectDialogPresenter> provider34 = DoubleCheck.provider(create35);
        this.A1 = provider34;
        GroupSelectDialogFactoryImpl_Factory create36 = GroupSelectDialogFactoryImpl_Factory.create(provider34, this.u);
        this.B1 = create36;
        this.C1 = DoubleCheck.provider(create36);
    }

    public static FiltersComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.search.filter.di.FiltersComponent
    public void inject(FiltersFragment filtersFragment) {
        FiltersFragment_MembersInjector.injectPresenter(filtersFragment, this.f1.get());
        FiltersFragment_MembersInjector.injectInteractor(filtersFragment, this.S.get());
        FiltersFragment_MembersInjector.injectFeatures(filtersFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        FiltersFragment_MembersInjector.injectRecyclerAdapter(filtersFragment, this.C0.get());
        FiltersFragment_MembersInjector.injectIntentFactory(filtersFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        FiltersFragment_MembersInjector.injectMultiselectDialogFactory(filtersFragment, this.r1.get());
        FiltersFragment_MembersInjector.injectSelectDialogFactory(filtersFragment, this.y1.get());
        FiltersFragment_MembersInjector.injectGroupSelectDialogFactory(filtersFragment, this.C1.get());
        FiltersFragment_MembersInjector.injectAnalytics(filtersFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        FiltersFragment_MembersInjector.injectTracker(filtersFragment, this.W0.get());
        FiltersFragment_MembersInjector.injectBubblesSelectItemPresenter(filtersFragment, this.v0.get());
        FiltersFragment_MembersInjector.injectLocationPermissionDialogPresenter(filtersFragment, this.z.get());
        FiltersFragment_MembersInjector.injectImplicitIntentFactory(filtersFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
    }
}
