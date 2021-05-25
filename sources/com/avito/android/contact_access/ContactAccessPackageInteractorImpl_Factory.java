package com.avito.android.contact_access;

import com.avito.android.contact_access.remote.ContactAccessApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ContactAccessPackageInteractorImpl_Factory implements Factory<ContactAccessPackageInteractorImpl> {
    public final Provider<ContactAccessApi> a;
    public final Provider<String> b;

    public ContactAccessPackageInteractorImpl_Factory(Provider<ContactAccessApi> provider, Provider<String> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ContactAccessPackageInteractorImpl_Factory create(Provider<ContactAccessApi> provider, Provider<String> provider2) {
        return new ContactAccessPackageInteractorImpl_Factory(provider, provider2);
    }

    public static ContactAccessPackageInteractorImpl newInstance(ContactAccessApi contactAccessApi, String str) {
        return new ContactAccessPackageInteractorImpl(contactAccessApi, str);
    }

    @Override // javax.inject.Provider
    public ContactAccessPackageInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
