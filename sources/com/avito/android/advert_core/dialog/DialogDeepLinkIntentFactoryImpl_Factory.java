package com.avito.android.advert_core.dialog;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DialogDeepLinkIntentFactoryImpl_Factory implements Factory<DialogDeepLinkIntentFactoryImpl> {
    public final Provider<Application> a;

    public DialogDeepLinkIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static DialogDeepLinkIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new DialogDeepLinkIntentFactoryImpl_Factory(provider);
    }

    public static DialogDeepLinkIntentFactoryImpl newInstance(Application application) {
        return new DialogDeepLinkIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public DialogDeepLinkIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
