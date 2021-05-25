package com.avito.android.authorization.smart_lock.di;

import android.app.Activity;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SmartLockLoaderModule_ProvideSmartLockLoaderFactory implements Factory<SmartLockLoader> {
    public final Provider<Analytics> a;
    public final Provider<DialogRouter> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<Features> d;
    public final Provider<Activity> e;
    public final Provider<Kundle> f;

    public SmartLockLoaderModule_ProvideSmartLockLoaderFactory(Provider<Analytics> provider, Provider<DialogRouter> provider2, Provider<SchedulersFactory3> provider3, Provider<Features> provider4, Provider<Activity> provider5, Provider<Kundle> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static SmartLockLoaderModule_ProvideSmartLockLoaderFactory create(Provider<Analytics> provider, Provider<DialogRouter> provider2, Provider<SchedulersFactory3> provider3, Provider<Features> provider4, Provider<Activity> provider5, Provider<Kundle> provider6) {
        return new SmartLockLoaderModule_ProvideSmartLockLoaderFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static SmartLockLoader provideSmartLockLoader(Analytics analytics, DialogRouter dialogRouter, SchedulersFactory3 schedulersFactory3, Features features, Activity activity, Kundle kundle) {
        return (SmartLockLoader) Preconditions.checkNotNullFromProvides(SmartLockLoaderModule.provideSmartLockLoader(analytics, dialogRouter, schedulersFactory3, features, activity, kundle));
    }

    @Override // javax.inject.Provider
    public SmartLockLoader get() {
        return provideSmartLockLoader(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
