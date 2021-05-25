package com.avito.android.contact_access;

import android.os.Bundle;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ContactAccessServicePresenterImpl_Factory implements Factory<ContactAccessServicePresenterImpl> {
    public final Provider<ContactAccessServiceInteractor> a;
    public final Provider<Formatter<Throwable>> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<Bundle> d;

    public ContactAccessServicePresenterImpl_Factory(Provider<ContactAccessServiceInteractor> provider, Provider<Formatter<Throwable>> provider2, Provider<SchedulersFactory> provider3, Provider<Bundle> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ContactAccessServicePresenterImpl_Factory create(Provider<ContactAccessServiceInteractor> provider, Provider<Formatter<Throwable>> provider2, Provider<SchedulersFactory> provider3, Provider<Bundle> provider4) {
        return new ContactAccessServicePresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ContactAccessServicePresenterImpl newInstance(ContactAccessServiceInteractor contactAccessServiceInteractor, Formatter<Throwable> formatter, SchedulersFactory schedulersFactory, Bundle bundle) {
        return new ContactAccessServicePresenterImpl(contactAccessServiceInteractor, formatter, schedulersFactory, bundle);
    }

    @Override // javax.inject.Provider
    public ContactAccessServicePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
