package com.avito.android.social;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class OdnoklassnikiSocialManagerImpl_Factory implements Factory<OdnoklassnikiSocialManagerImpl> {
    public final Provider<Context> a;

    public OdnoklassnikiSocialManagerImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static OdnoklassnikiSocialManagerImpl_Factory create(Provider<Context> provider) {
        return new OdnoklassnikiSocialManagerImpl_Factory(provider);
    }

    public static OdnoklassnikiSocialManagerImpl newInstance(Context context) {
        return new OdnoklassnikiSocialManagerImpl(context);
    }

    @Override // javax.inject.Provider
    public OdnoklassnikiSocialManagerImpl get() {
        return newInstance(this.a.get());
    }
}
