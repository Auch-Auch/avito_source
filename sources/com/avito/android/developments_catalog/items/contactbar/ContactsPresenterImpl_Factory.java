package com.avito.android.developments_catalog.items.contactbar;

import com.avito.android.developments_catalog.DevelopmentsCatalogPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ContactsPresenterImpl_Factory implements Factory<ContactsPresenterImpl> {
    public final Provider<DevelopmentsCatalogPresenter> a;

    public ContactsPresenterImpl_Factory(Provider<DevelopmentsCatalogPresenter> provider) {
        this.a = provider;
    }

    public static ContactsPresenterImpl_Factory create(Provider<DevelopmentsCatalogPresenter> provider) {
        return new ContactsPresenterImpl_Factory(provider);
    }

    public static ContactsPresenterImpl newInstance(DevelopmentsCatalogPresenter developmentsCatalogPresenter) {
        return new ContactsPresenterImpl(developmentsCatalogPresenter);
    }

    @Override // javax.inject.Provider
    public ContactsPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
