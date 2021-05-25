package com.avito.android.advert_core.discount.item.contact;

import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ContactItemBlueprint_Factory implements Factory<ContactItemBlueprint> {
    public final Provider<ContactItemPresenter> a;
    public final Provider<Features> b;

    public ContactItemBlueprint_Factory(Provider<ContactItemPresenter> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ContactItemBlueprint_Factory create(Provider<ContactItemPresenter> provider, Provider<Features> provider2) {
        return new ContactItemBlueprint_Factory(provider, provider2);
    }

    public static ContactItemBlueprint newInstance(ContactItemPresenter contactItemPresenter, Features features) {
        return new ContactItemBlueprint(contactItemPresenter, features);
    }

    @Override // javax.inject.Provider
    public ContactItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
