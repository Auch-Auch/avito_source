package com.avito.android.in_app_calls.service;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SystemCallStateProviderImpl_Factory implements Factory<SystemCallStateProviderImpl> {
    public final Provider<Context> a;

    public SystemCallStateProviderImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static SystemCallStateProviderImpl_Factory create(Provider<Context> provider) {
        return new SystemCallStateProviderImpl_Factory(provider);
    }

    public static SystemCallStateProviderImpl newInstance(Context context) {
        return new SystemCallStateProviderImpl(context);
    }

    @Override // javax.inject.Provider
    public SystemCallStateProviderImpl get() {
        return newInstance(this.a.get());
    }
}
