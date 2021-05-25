package com.avito.android.beduin.common;

import com.avito.android.beduin.BeduinApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BeduinInteractor_Factory implements Factory<BeduinInteractor> {
    public final Provider<BeduinApi> a;
    public final Provider<SchedulersFactory3> b;

    public BeduinInteractor_Factory(Provider<BeduinApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static BeduinInteractor_Factory create(Provider<BeduinApi> provider, Provider<SchedulersFactory3> provider2) {
        return new BeduinInteractor_Factory(provider, provider2);
    }

    public static BeduinInteractor newInstance(BeduinApi beduinApi, SchedulersFactory3 schedulersFactory3) {
        return new BeduinInteractor(beduinApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public BeduinInteractor get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
