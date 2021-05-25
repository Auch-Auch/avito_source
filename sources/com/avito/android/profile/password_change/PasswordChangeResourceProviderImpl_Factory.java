package com.avito.android.profile.password_change;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PasswordChangeResourceProviderImpl_Factory implements Factory<PasswordChangeResourceProviderImpl> {
    public final Provider<Resources> a;

    public PasswordChangeResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static PasswordChangeResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new PasswordChangeResourceProviderImpl_Factory(provider);
    }

    public static PasswordChangeResourceProviderImpl newInstance(Resources resources) {
        return new PasswordChangeResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public PasswordChangeResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
