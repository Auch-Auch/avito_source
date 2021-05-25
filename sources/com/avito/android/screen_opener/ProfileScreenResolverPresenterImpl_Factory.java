package com.avito.android.screen_opener;

import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProfileScreenResolverPresenterImpl_Factory implements Factory<ProfileScreenResolverPresenterImpl> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<ProfileScreenResolverInteractor> c;
    public final Provider<UnknownScreenTracker> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<ErrorHelper> f;

    public ProfileScreenResolverPresenterImpl_Factory(Provider<String> provider, Provider<String> provider2, Provider<ProfileScreenResolverInteractor> provider3, Provider<UnknownScreenTracker> provider4, Provider<SchedulersFactory3> provider5, Provider<ErrorHelper> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static ProfileScreenResolverPresenterImpl_Factory create(Provider<String> provider, Provider<String> provider2, Provider<ProfileScreenResolverInteractor> provider3, Provider<UnknownScreenTracker> provider4, Provider<SchedulersFactory3> provider5, Provider<ErrorHelper> provider6) {
        return new ProfileScreenResolverPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ProfileScreenResolverPresenterImpl newInstance(String str, String str2, ProfileScreenResolverInteractor profileScreenResolverInteractor, UnknownScreenTracker unknownScreenTracker, SchedulersFactory3 schedulersFactory3, ErrorHelper errorHelper) {
        return new ProfileScreenResolverPresenterImpl(str, str2, profileScreenResolverInteractor, unknownScreenTracker, schedulersFactory3, errorHelper);
    }

    @Override // javax.inject.Provider
    public ProfileScreenResolverPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
