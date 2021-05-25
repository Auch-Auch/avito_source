package com.avito.android.social;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GoogleSocialManagerImpl_Factory implements Factory<GoogleSocialManagerImpl> {
    public final Provider<Context> a;

    public GoogleSocialManagerImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static GoogleSocialManagerImpl_Factory create(Provider<Context> provider) {
        return new GoogleSocialManagerImpl_Factory(provider);
    }

    public static GoogleSocialManagerImpl newInstance(Context context) {
        return new GoogleSocialManagerImpl(context);
    }

    @Override // javax.inject.Provider
    public GoogleSocialManagerImpl get() {
        return newInstance(this.a.get());
    }
}
