package com.avito.android.rating.publish.deal_proofs;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DealProofsIntentFactoryImpl_Factory implements Factory<DealProofsIntentFactoryImpl> {
    public final Provider<Context> a;

    public DealProofsIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static DealProofsIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new DealProofsIntentFactoryImpl_Factory(provider);
    }

    public static DealProofsIntentFactoryImpl newInstance(Context context) {
        return new DealProofsIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public DealProofsIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
