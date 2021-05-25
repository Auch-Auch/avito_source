package com.avito.android.suggest_locations;

import com.avito.android.suggest_locations.analytics.SuggestLocationsAnalyticsInteractor;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SuggestLocationsPresenterImpl_Factory implements Factory<SuggestLocationsPresenterImpl> {
    public final Provider<SuggestLocationsInteractor> a;
    public final Provider<SuggestLocationsAnalyticsInteractor> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<String> d;
    public final Provider<String> e;
    public final Provider<Integer> f;
    public final Provider<Boolean> g;
    public final Provider<String> h;
    public final Provider<Boolean> i;
    public final Provider<String> j;
    public final Provider<Boolean> k;
    public final Provider<Kundle> l;

    public SuggestLocationsPresenterImpl_Factory(Provider<SuggestLocationsInteractor> provider, Provider<SuggestLocationsAnalyticsInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<String> provider4, Provider<String> provider5, Provider<Integer> provider6, Provider<Boolean> provider7, Provider<String> provider8, Provider<Boolean> provider9, Provider<String> provider10, Provider<Boolean> provider11, Provider<Kundle> provider12) {
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
    }

    public static SuggestLocationsPresenterImpl_Factory create(Provider<SuggestLocationsInteractor> provider, Provider<SuggestLocationsAnalyticsInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<String> provider4, Provider<String> provider5, Provider<Integer> provider6, Provider<Boolean> provider7, Provider<String> provider8, Provider<Boolean> provider9, Provider<String> provider10, Provider<Boolean> provider11, Provider<Kundle> provider12) {
        return new SuggestLocationsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static SuggestLocationsPresenterImpl newInstance(SuggestLocationsInteractor suggestLocationsInteractor, SuggestLocationsAnalyticsInteractor suggestLocationsAnalyticsInteractor, SchedulersFactory3 schedulersFactory3, String str, String str2, Integer num, boolean z, String str3, boolean z2, String str4, boolean z3, Kundle kundle) {
        return new SuggestLocationsPresenterImpl(suggestLocationsInteractor, suggestLocationsAnalyticsInteractor, schedulersFactory3, str, str2, num, z, str3, z2, str4, z3, kundle);
    }

    @Override // javax.inject.Provider
    public SuggestLocationsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get().booleanValue(), this.h.get(), this.i.get().booleanValue(), this.j.get(), this.k.get().booleanValue(), this.l.get());
    }
}
