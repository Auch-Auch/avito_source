package com.avito.android.verification;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerificationIntentFactoryImpl_Factory implements Factory<VerificationIntentFactoryImpl> {
    public final Provider<Context> a;

    public VerificationIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static VerificationIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new VerificationIntentFactoryImpl_Factory(provider);
    }

    public static VerificationIntentFactoryImpl newInstance(Context context) {
        return new VerificationIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public VerificationIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
