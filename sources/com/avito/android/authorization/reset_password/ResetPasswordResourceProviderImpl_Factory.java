package com.avito.android.authorization.reset_password;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ResetPasswordResourceProviderImpl_Factory implements Factory<ResetPasswordResourceProviderImpl> {
    public final Provider<Resources> a;

    public ResetPasswordResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ResetPasswordResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new ResetPasswordResourceProviderImpl_Factory(provider);
    }

    public static ResetPasswordResourceProviderImpl newInstance(Resources resources) {
        return new ResetPasswordResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public ResetPasswordResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
