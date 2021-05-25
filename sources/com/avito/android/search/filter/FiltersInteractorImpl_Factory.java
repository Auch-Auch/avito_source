package com.avito.android.search.filter;

import com.avito.android.CategoriesInteractor;
import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.find.FindDetectLocationPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FiltersInteractorImpl_Factory implements Factory<FiltersInteractorImpl> {
    public final Provider<CategoriesInteractor> a;
    public final Provider<TopLocationInteractor> b;
    public final Provider<LocationApi> c;
    public final Provider<SearchApi> d;
    public final Provider<CategoriesParameterFactory> e;
    public final Provider<ReplaceLocationParametersTreeWrapper> f;
    public final Provider<SearchParams> g;
    public final Provider<Area> h;
    public final Provider<String> i;
    public final Provider<Boolean> j;
    public final Provider<SearchParamsConverter> k;
    public final Provider<ParametersTreeMapConverter> l;
    public final Provider<ParametersTreeSearchParamsConverter> m;
    public final Provider<TypedErrorThrowableConverter> n;
    public final Provider<SchedulersFactory3> o;
    public final Provider<Features> p;
    public final Provider<Kundle> q;
    public final Provider<LocationPermissionDialogPresenter> r;
    public final Provider<FindDetectLocationPresenter> s;
    public final Provider<LocationAnalyticsInteractor> t;

    public FiltersInteractorImpl_Factory(Provider<CategoriesInteractor> provider, Provider<TopLocationInteractor> provider2, Provider<LocationApi> provider3, Provider<SearchApi> provider4, Provider<CategoriesParameterFactory> provider5, Provider<ReplaceLocationParametersTreeWrapper> provider6, Provider<SearchParams> provider7, Provider<Area> provider8, Provider<String> provider9, Provider<Boolean> provider10, Provider<SearchParamsConverter> provider11, Provider<ParametersTreeMapConverter> provider12, Provider<ParametersTreeSearchParamsConverter> provider13, Provider<TypedErrorThrowableConverter> provider14, Provider<SchedulersFactory3> provider15, Provider<Features> provider16, Provider<Kundle> provider17, Provider<LocationPermissionDialogPresenter> provider18, Provider<FindDetectLocationPresenter> provider19, Provider<LocationAnalyticsInteractor> provider20) {
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
        this.p = provider16;
        this.q = provider17;
        this.r = provider18;
        this.s = provider19;
        this.t = provider20;
    }

    public static FiltersInteractorImpl_Factory create(Provider<CategoriesInteractor> provider, Provider<TopLocationInteractor> provider2, Provider<LocationApi> provider3, Provider<SearchApi> provider4, Provider<CategoriesParameterFactory> provider5, Provider<ReplaceLocationParametersTreeWrapper> provider6, Provider<SearchParams> provider7, Provider<Area> provider8, Provider<String> provider9, Provider<Boolean> provider10, Provider<SearchParamsConverter> provider11, Provider<ParametersTreeMapConverter> provider12, Provider<ParametersTreeSearchParamsConverter> provider13, Provider<TypedErrorThrowableConverter> provider14, Provider<SchedulersFactory3> provider15, Provider<Features> provider16, Provider<Kundle> provider17, Provider<LocationPermissionDialogPresenter> provider18, Provider<FindDetectLocationPresenter> provider19, Provider<LocationAnalyticsInteractor> provider20) {
        return new FiltersInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20);
    }

    public static FiltersInteractorImpl newInstance(CategoriesInteractor categoriesInteractor, TopLocationInteractor topLocationInteractor, LocationApi locationApi, SearchApi searchApi, CategoriesParameterFactory categoriesParameterFactory, ReplaceLocationParametersTreeWrapper replaceLocationParametersTreeWrapper, SearchParams searchParams, Area area, String str, boolean z, SearchParamsConverter searchParamsConverter, ParametersTreeMapConverter parametersTreeMapConverter, ParametersTreeSearchParamsConverter parametersTreeSearchParamsConverter, TypedErrorThrowableConverter typedErrorThrowableConverter, SchedulersFactory3 schedulersFactory3, Features features, Kundle kundle, LocationPermissionDialogPresenter locationPermissionDialogPresenter, FindDetectLocationPresenter findDetectLocationPresenter, LocationAnalyticsInteractor locationAnalyticsInteractor) {
        return new FiltersInteractorImpl(categoriesInteractor, topLocationInteractor, locationApi, searchApi, categoriesParameterFactory, replaceLocationParametersTreeWrapper, searchParams, area, str, z, searchParamsConverter, parametersTreeMapConverter, parametersTreeSearchParamsConverter, typedErrorThrowableConverter, schedulersFactory3, features, kundle, locationPermissionDialogPresenter, findDetectLocationPresenter, locationAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public FiltersInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get().booleanValue(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get());
    }
}
