package com.avito.android.contact_access;

import com.avito.android.contact_access.remote.ContactAccessApi;
import com.avito.android.social.incomplete.IncompleteSocialInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ContactAccessServiceInteractorImpl_Factory implements Factory<ContactAccessServiceInteractorImpl> {
    public final Provider<IncompleteSocialInteractor> a;
    public final Provider<ContactAccessApi> b;
    public final Provider<ContactAccessServiceArguments> c;

    public ContactAccessServiceInteractorImpl_Factory(Provider<IncompleteSocialInteractor> provider, Provider<ContactAccessApi> provider2, Provider<ContactAccessServiceArguments> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ContactAccessServiceInteractorImpl_Factory create(Provider<IncompleteSocialInteractor> provider, Provider<ContactAccessApi> provider2, Provider<ContactAccessServiceArguments> provider3) {
        return new ContactAccessServiceInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static ContactAccessServiceInteractorImpl newInstance(IncompleteSocialInteractor incompleteSocialInteractor, ContactAccessApi contactAccessApi, ContactAccessServiceArguments contactAccessServiceArguments) {
        return new ContactAccessServiceInteractorImpl(incompleteSocialInteractor, contactAccessApi, contactAccessServiceArguments);
    }

    @Override // javax.inject.Provider
    public ContactAccessServiceInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
