package com.avito.android.social;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VkontakteSocialManagerImpl_Factory implements Factory<VkontakteSocialManagerImpl> {
    public final Provider<Context> a;

    public VkontakteSocialManagerImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static VkontakteSocialManagerImpl_Factory create(Provider<Context> provider) {
        return new VkontakteSocialManagerImpl_Factory(provider);
    }

    public static VkontakteSocialManagerImpl newInstance(Context context) {
        return new VkontakteSocialManagerImpl(context);
    }

    @Override // javax.inject.Provider
    public VkontakteSocialManagerImpl get() {
        return newInstance(this.a.get());
    }
}
