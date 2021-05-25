package com.avito.android.developments_catalog.items.contactbar;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ContactsBlueprint_Factory implements Factory<ContactsBlueprint> {
    public final Provider<ContactsPresenter> a;

    public ContactsBlueprint_Factory(Provider<ContactsPresenter> provider) {
        this.a = provider;
    }

    public static ContactsBlueprint_Factory create(Provider<ContactsPresenter> provider) {
        return new ContactsBlueprint_Factory(provider);
    }

    public static ContactsBlueprint newInstance(ContactsPresenter contactsPresenter) {
        return new ContactsBlueprint(contactsPresenter);
    }

    @Override // javax.inject.Provider
    public ContactsBlueprint get() {
        return newInstance(this.a.get());
    }
}
