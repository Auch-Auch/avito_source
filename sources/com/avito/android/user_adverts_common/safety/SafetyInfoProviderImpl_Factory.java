package com.avito.android.user_adverts_common.safety;

import com.avito.android.remote.UserAdvertsCommonApi;
import com.avito.android.server_time.TimeSource;
import com.avito.android.user_adverts_common.safety.storage.SafetyInfoSessionStorage;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SafetyInfoProviderImpl_Factory implements Factory<SafetyInfoProviderImpl> {
    public final Provider<UserAdvertsCommonApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<SafetyInfoSessionStorage> c;
    public final Provider<TimeSource> d;

    public SafetyInfoProviderImpl_Factory(Provider<UserAdvertsCommonApi> provider, Provider<SchedulersFactory3> provider2, Provider<SafetyInfoSessionStorage> provider3, Provider<TimeSource> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SafetyInfoProviderImpl_Factory create(Provider<UserAdvertsCommonApi> provider, Provider<SchedulersFactory3> provider2, Provider<SafetyInfoSessionStorage> provider3, Provider<TimeSource> provider4) {
        return new SafetyInfoProviderImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static SafetyInfoProviderImpl newInstance(UserAdvertsCommonApi userAdvertsCommonApi, SchedulersFactory3 schedulersFactory3, SafetyInfoSessionStorage safetyInfoSessionStorage, TimeSource timeSource) {
        return new SafetyInfoProviderImpl(userAdvertsCommonApi, schedulersFactory3, safetyInfoSessionStorage, timeSource);
    }

    @Override // javax.inject.Provider
    public SafetyInfoProviderImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
