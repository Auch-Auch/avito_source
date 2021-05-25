package com.avito.android.search.filter;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.search.filter.analytics.FilterAnalyticsInteractor;
import com.avito.android.search.filter.tracker.FiltersTracker;
import com.avito.android.select.new_metro.analytics.SelectMetroAnalytics;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FiltersPresenterImpl_Factory implements Factory<FiltersPresenterImpl> {
    public final Provider<FiltersInteractor> a;
    public final Provider<FiltersChangeProvider> b;
    public final Provider<DataAwareAdapterPresenter> c;
    public final Provider<CategoryParametersElementConverter> d;
    public final Provider<FiltersResourceProvider> e;
    public final Provider<SchedulersFactory3> f;
    public final Provider<FilterAnalyticsInteractor> g;
    public final Provider<SelectMetroAnalytics> h;
    public final Provider<FiltersTracker> i;
    public final Provider<Boolean> j;
    public final Provider<Kundle> k;
    public final Provider<Boolean> l;
    public final Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> m;
    public final Provider<SavedLocationInteractor> n;
    public final Provider<Features> o;

    public FiltersPresenterImpl_Factory(Provider<FiltersInteractor> provider, Provider<FiltersChangeProvider> provider2, Provider<DataAwareAdapterPresenter> provider3, Provider<CategoryParametersElementConverter> provider4, Provider<FiltersResourceProvider> provider5, Provider<SchedulersFactory3> provider6, Provider<FilterAnalyticsInteractor> provider7, Provider<SelectMetroAnalytics> provider8, Provider<FiltersTracker> provider9, Provider<Boolean> provider10, Provider<Kundle> provider11, Provider<Boolean> provider12, Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> provider13, Provider<SavedLocationInteractor> provider14, Provider<Features> provider15) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
        this.l = provider12;
        this.m = provider13;
        this.n = provider14;
        this.o = provider15;
    }

    public static FiltersPresenterImpl_Factory create(Provider<FiltersInteractor> provider, Provider<FiltersChangeProvider> provider2, Provider<DataAwareAdapterPresenter> provider3, Provider<CategoryParametersElementConverter> provider4, Provider<FiltersResourceProvider> provider5, Provider<SchedulersFactory3> provider6, Provider<FilterAnalyticsInteractor> provider7, Provider<SelectMetroAnalytics> provider8, Provider<FiltersTracker> provider9, Provider<Boolean> provider10, Provider<Kundle> provider11, Provider<Boolean> provider12, Provider<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> provider13, Provider<SavedLocationInteractor> provider14, Provider<Features> provider15) {
        return new FiltersPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
    }

    public static FiltersPresenterImpl newInstance(FiltersInteractor filtersInteractor, FiltersChangeProvider filtersChangeProvider, DataAwareAdapterPresenter dataAwareAdapterPresenter, CategoryParametersElementConverter categoryParametersElementConverter, FiltersResourceProvider filtersResourceProvider, SchedulersFactory3 schedulersFactory3, FilterAnalyticsInteractor filterAnalyticsInteractor, SelectMetroAnalytics selectMetroAnalytics, FiltersTracker filtersTracker, boolean z, Kundle kundle, boolean z2, SingleManuallyExposedAbTestGroup<SimpleTestGroup> singleManuallyExposedAbTestGroup, SavedLocationInteractor savedLocationInteractor, Features features) {
        return new FiltersPresenterImpl(filtersInteractor, filtersChangeProvider, dataAwareAdapterPresenter, categoryParametersElementConverter, filtersResourceProvider, schedulersFactory3, filterAnalyticsInteractor, selectMetroAnalytics, filtersTracker, z, kundle, z2, singleManuallyExposedAbTestGroup, savedLocationInteractor, features);
    }

    @Override // javax.inject.Provider
    public FiltersPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get().booleanValue(), this.k.get(), this.l.get().booleanValue(), this.m.get(), this.n.get(), this.o.get());
    }
}
