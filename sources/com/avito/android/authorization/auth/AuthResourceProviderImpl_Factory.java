package com.avito.android.authorization.auth;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AuthResourceProviderImpl_Factory implements Factory<AuthResourceProviderImpl> {
    public final Provider<Resources> a;

    public AuthResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static AuthResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new AuthResourceProviderImpl_Factory(provider);
    }

    public static AuthResourceProviderImpl newInstance(Resources resources) {
        return new AuthResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public AuthResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
