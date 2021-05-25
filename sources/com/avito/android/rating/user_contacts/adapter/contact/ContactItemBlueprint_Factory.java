package com.avito.android.rating.user_contacts.adapter.contact;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ContactItemBlueprint_Factory implements Factory<ContactItemBlueprint> {
    public final Provider<ContactItemPresenter> a;

    public ContactItemBlueprint_Factory(Provider<ContactItemPresenter> provider) {
        this.a = provider;
    }

    public static ContactItemBlueprint_Factory create(Provider<ContactItemPresenter> provider) {
        return new ContactItemBlueprint_Factory(provider);
    }

    public static ContactItemBlueprint newInstance(ContactItemPresenter contactItemPresenter) {
        return new ContactItemBlueprint(contactItemPresenter);
    }

    @Override // javax.inject.Provider
    public ContactItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
