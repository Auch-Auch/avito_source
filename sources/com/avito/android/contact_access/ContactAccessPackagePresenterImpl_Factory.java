package com.avito.android.contact_access;

import android.os.Bundle;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ContactAccessPackagePresenterImpl_Factory implements Factory<ContactAccessPackagePresenterImpl> {
    public final Provider<ContactAccessPackageInteractor> a;
    public final Provider<Formatter<Throwable>> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<Bundle> d;

    public ContactAccessPackagePresenterImpl_Factory(Provider<ContactAccessPackageInteractor> provider, Provider<Formatter<Throwable>> provider2, Provider<SchedulersFactory> provider3, Provider<Bundle> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ContactAccessPackagePresenterImpl_Factory create(Provider<ContactAccessPackageInteractor> provider, Provider<Formatter<Throwable>> provider2, Provider<SchedulersFactory> provider3, Provider<Bundle> provider4) {
        return new ContactAccessPackagePresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ContactAccessPackagePresenterImpl newInstance(ContactAccessPackageInteractor contactAccessPackageInteractor, Formatter<Throwable> formatter, SchedulersFactory schedulersFactory, Bundle bundle) {
        return new ContactAccessPackagePresenterImpl(contactAccessPackageInteractor, formatter, schedulersFactory, bundle);
    }

    @Override // javax.inject.Provider
    public ContactAccessPackagePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
