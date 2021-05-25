package com.avito.android.push;

import android.content.Context;
import com.avito.android.push.provider.GcmPushTokenProvider;
import com.avito.android.push.provider.PushTokenProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PushTokenProviderModule_ProvidePushTokenProviderFactory implements Factory<PushTokenProvider> {
    public final Provider<Context> a;
    public final Provider<GcmPushTokenProvider> b;

    public PushTokenProviderModule_ProvidePushTokenProviderFactory(Provider<Context> provider, Provider<GcmPushTokenProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PushTokenProviderModule_ProvidePushTokenProviderFactory create(Provider<Context> provider, Provider<GcmPushTokenProvider> provider2) {
        return new PushTokenProviderModule_ProvidePushTokenProviderFactory(provider, provider2);
    }

    public static PushTokenProvider providePushTokenProvider(Context context, GcmPushTokenProvider gcmPushTokenProvider) {
        return (PushTokenProvider) Preconditions.checkNotNullFromProvides(PushTokenProviderModule.INSTANCE.providePushTokenProvider(context, gcmPushTokenProvider));
    }

    @Override // javax.inject.Provider
    public PushTokenProvider get() {
        return providePushTokenProvider(this.a.get(), this.b.get());
    }
}
