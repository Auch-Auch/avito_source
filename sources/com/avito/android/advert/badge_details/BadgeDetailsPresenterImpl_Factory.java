package com.avito.android.advert.badge_details;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BadgeDetailsPresenterImpl_Factory implements Factory<BadgeDetailsPresenterImpl> {
    public final Provider<Integer> a;
    public final Provider<String> b;
    public final Provider<String> c;
    public final Provider<Kundle> d;
    public final Provider<Analytics> e;
    public final Provider<BadgeDetailsInteractor> f;
    public final Provider<BadgeDetailsResourceProvider> g;
    public final Provider<SchedulersFactory3> h;

    public BadgeDetailsPresenterImpl_Factory(Provider<Integer> provider, Provider<String> provider2, Provider<String> provider3, Provider<Kundle> provider4, Provider<Analytics> provider5, Provider<BadgeDetailsInteractor> provider6, Provider<BadgeDetailsResourceProvider> provider7, Provider<SchedulersFactory3> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static BadgeDetailsPresenterImpl_Factory create(Provider<Integer> provider, Provider<String> provider2, Provider<String> provider3, Provider<Kundle> provider4, Provider<Analytics> provider5, Provider<BadgeDetailsInteractor> provider6, Provider<BadgeDetailsResourceProvider> provider7, Provider<SchedulersFactory3> provider8) {
        return new BadgeDetailsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static BadgeDetailsPresenterImpl newInstance(int i, String str, String str2, Kundle kundle, Analytics analytics, BadgeDetailsInteractor badgeDetailsInteractor, BadgeDetailsResourceProvider badgeDetailsResourceProvider, SchedulersFactory3 schedulersFactory3) {
        return new BadgeDetailsPresenterImpl(i, str, str2, kundle, analytics, badgeDetailsInteractor, badgeDetailsResourceProvider, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public BadgeDetailsPresenterImpl get() {
        return newInstance(this.a.get().intValue(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
