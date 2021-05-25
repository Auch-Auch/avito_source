package com.avito.android.publish.contacts;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ContactMethodParameterInteractorImpl_Factory implements Factory<ContactMethodParameterInteractorImpl> {
    public final Provider<Resources> a;

    public ContactMethodParameterInteractorImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ContactMethodParameterInteractorImpl_Factory create(Provider<Resources> provider) {
        return new ContactMethodParameterInteractorImpl_Factory(provider);
    }

    public static ContactMethodParameterInteractorImpl newInstance(Resources resources) {
        return new ContactMethodParameterInteractorImpl(resources);
    }

    @Override // javax.inject.Provider
    public ContactMethodParameterInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
