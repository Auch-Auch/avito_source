package com.avito.android.authorization.auth;

import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.performance.ContentTracker;
import com.avito.android.performance.ScreenTracker;
import com.avito.android.social.SignInManager;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.social.button.SocialInfoProvider;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import java.util.ArrayList;
import javax.inject.Provider;
public final class AuthPresenterImpl_Factory implements Factory<AuthPresenterImpl> {
    public final Provider<AuthInteractor> a;
    public final Provider<SmartLockLoader> b;
    public final Provider<ArrayList<SignInManager>> c;
    public final Provider<SocialInfoProvider> d;
    public final Provider<Analytics> e;
    public final Provider<SchedulersFactory3> f;
    public final Provider<AuthResourceProvider> g;
    public final Provider<ScreenTracker> h;
    public final Provider<ContentTracker> i;
    public final Provider<SocialTypeToStringMapper> j;
    public final Provider<Kundle> k;
    public final Provider<String> l;

    public AuthPresenterImpl_Factory(Provider<AuthInteractor> provider, Provider<SmartLockLoader> provider2, Provider<ArrayList<SignInManager>> provider3, Provider<SocialInfoProvider> provider4, Provider<Analytics> provider5, Provider<SchedulersFactory3> provider6, Provider<AuthResourceProvider> provider7, Provider<ScreenTracker> provider8, Provider<ContentTracker> provider9, Provider<SocialTypeToStringMapper> provider10, Provider<Kundle> provider11, Provider<String> provider12) {
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

    public static AuthPresenterImpl_Factory create(Provider<AuthInteractor> provider, Provider<SmartLockLoader> provider2, Provider<ArrayList<SignInManager>> provider3, Provider<SocialInfoProvider> provider4, Provider<Analytics> provider5, Provider<SchedulersFactory3> provider6, Provider<AuthResourceProvider> provider7, Provider<ScreenTracker> provider8, Provider<ContentTracker> provider9, Provider<SocialTypeToStringMapper> provider10, Provider<Kundle> provider11, Provider<String> provider12) {
        return new AuthPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static AuthPresenterImpl newInstance(AuthInteractor authInteractor, SmartLockLoader smartLockLoader, ArrayList<SignInManager> arrayList, SocialInfoProvider socialInfoProvider, Analytics analytics, SchedulersFactory3 schedulersFactory3, AuthResourceProvider authResourceProvider, ScreenTracker screenTracker, ContentTracker contentTracker, SocialTypeToStringMapper socialTypeToStringMapper, Kundle kundle, String str) {
        return new AuthPresenterImpl(authInteractor, smartLockLoader, arrayList, socialInfoProvider, analytics, schedulersFactory3, authResourceProvider, screenTracker, contentTracker, socialTypeToStringMapper, kundle, str);
    }

    @Override // javax.inject.Provider
    public AuthPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get());
    }
}
