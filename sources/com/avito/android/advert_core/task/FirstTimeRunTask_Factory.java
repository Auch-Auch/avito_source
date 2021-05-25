package com.avito.android.advert_core.task;

import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FirstTimeRunTask_Factory implements Factory<FirstTimeRunTask> {
    public final Provider<Preferences> a;
    public final Provider<SchedulersFactory3> b;

    public FirstTimeRunTask_Factory(Provider<Preferences> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FirstTimeRunTask_Factory create(Provider<Preferences> provider, Provider<SchedulersFactory3> provider2) {
        return new FirstTimeRunTask_Factory(provider, provider2);
    }

    public static FirstTimeRunTask newInstance(Preferences preferences, SchedulersFactory3 schedulersFactory3) {
        return new FirstTimeRunTask(preferences, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public FirstTimeRunTask get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
