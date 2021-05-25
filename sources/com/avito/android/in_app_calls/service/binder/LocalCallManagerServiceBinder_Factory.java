package com.avito.android.in_app_calls.service.binder;

import com.avito.android.in_app_calls.service.CallManagerServiceDelegate;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LocalCallManagerServiceBinder_Factory implements Factory<LocalCallManagerServiceBinder> {
    public final Provider<CallManagerServiceDelegate> a;

    public LocalCallManagerServiceBinder_Factory(Provider<CallManagerServiceDelegate> provider) {
        this.a = provider;
    }

    public static LocalCallManagerServiceBinder_Factory create(Provider<CallManagerServiceDelegate> provider) {
        return new LocalCallManagerServiceBinder_Factory(provider);
    }

    public static LocalCallManagerServiceBinder newInstance(CallManagerServiceDelegate callManagerServiceDelegate) {
        return new LocalCallManagerServiceBinder(callManagerServiceDelegate);
    }

    @Override // javax.inject.Provider
    public LocalCallManagerServiceBinder get() {
        return newInstance(this.a.get());
    }
}
