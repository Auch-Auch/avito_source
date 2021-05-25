package com.avito.android.calls_shared.analytics.mapping;

import android.content.Context;
import com.avito.android.analytics.NetworkTypeProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallEventFactory_Factory implements Factory<CallEventFactory> {
    public final Provider<Context> a;
    public final Provider<NetworkTypeProvider> b;

    public CallEventFactory_Factory(Provider<Context> provider, Provider<NetworkTypeProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CallEventFactory_Factory create(Provider<Context> provider, Provider<NetworkTypeProvider> provider2) {
        return new CallEventFactory_Factory(provider, provider2);
    }

    public static CallEventFactory newInstance(Context context, NetworkTypeProvider networkTypeProvider) {
        return new CallEventFactory(context, networkTypeProvider);
    }

    @Override // javax.inject.Provider
    public CallEventFactory get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
