package com.avito.android.authorization.login_suggests;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LoginSuggestsResourceProviderImpl_Factory implements Factory<LoginSuggestsResourceProviderImpl> {
    public final Provider<Resources> a;

    public LoginSuggestsResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static LoginSuggestsResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new LoginSuggestsResourceProviderImpl_Factory(provider);
    }

    public static LoginSuggestsResourceProviderImpl newInstance(Resources resources) {
        return new LoginSuggestsResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public LoginSuggestsResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
