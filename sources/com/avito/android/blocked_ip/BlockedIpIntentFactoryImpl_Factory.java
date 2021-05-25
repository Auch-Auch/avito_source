package com.avito.android.blocked_ip;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BlockedIpIntentFactoryImpl_Factory implements Factory<BlockedIpIntentFactoryImpl> {
    public final Provider<Context> a;

    public BlockedIpIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static BlockedIpIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new BlockedIpIntentFactoryImpl_Factory(provider);
    }

    public static BlockedIpIntentFactoryImpl newInstance(Context context) {
        return new BlockedIpIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public BlockedIpIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
