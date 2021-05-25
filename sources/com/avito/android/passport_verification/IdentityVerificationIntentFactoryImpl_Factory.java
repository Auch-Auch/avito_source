package com.avito.android.passport_verification;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class IdentityVerificationIntentFactoryImpl_Factory implements Factory<IdentityVerificationIntentFactoryImpl> {
    public final Provider<Context> a;

    public IdentityVerificationIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static IdentityVerificationIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new IdentityVerificationIntentFactoryImpl_Factory(provider);
    }

    public static IdentityVerificationIntentFactoryImpl newInstance(Context context) {
        return new IdentityVerificationIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public IdentityVerificationIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
