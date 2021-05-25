package com.avito.android.authorization.smart_lock.di;

import android.app.Activity;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SmartLockSaverModule_ProvideSmartLockSaverFactory implements Factory<SmartLockSaver> {
    public final Provider<Activity> a;
    public final Provider<Analytics> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<Features> d;
    public final Provider<Kundle> e;

    public SmartLockSaverModule_ProvideSmartLockSaverFactory(Provider<Activity> provider, Provider<Analytics> provider2, Provider<SchedulersFactory3> provider3, Provider<Features> provider4, Provider<Kundle> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static SmartLockSaverModule_ProvideSmartLockSaverFactory create(Provider<Activity> provider, Provider<Analytics> provider2, Provider<SchedulersFactory3> provider3, Provider<Features> provider4, Provider<Kundle> provider5) {
        return new SmartLockSaverModule_ProvideSmartLockSaverFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static SmartLockSaver provideSmartLockSaver(Activity activity, Analytics analytics, SchedulersFactory3 schedulersFactory3, Features features, Kundle kundle) {
        return (SmartLockSaver) Preconditions.checkNotNullFromProvides(SmartLockSaverModule.provideSmartLockSaver(activity, analytics, schedulersFactory3, features, kundle));
    }

    @Override // javax.inject.Provider
    public SmartLockSaver get() {
        return provideSmartLockSaver(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
