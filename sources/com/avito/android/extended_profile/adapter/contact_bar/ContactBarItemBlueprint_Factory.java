package com.avito.android.extended_profile.adapter.contact_bar;

import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ContactBarItemBlueprint_Factory implements Factory<ContactBarItemBlueprint> {
    public final Provider<ContactBarItemPresenter> a;
    public final Provider<Features> b;

    public ContactBarItemBlueprint_Factory(Provider<ContactBarItemPresenter> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ContactBarItemBlueprint_Factory create(Provider<ContactBarItemPresenter> provider, Provider<Features> provider2) {
        return new ContactBarItemBlueprint_Factory(provider, provider2);
    }

    public static ContactBarItemBlueprint newInstance(ContactBarItemPresenter contactBarItemPresenter, Features features) {
        return new ContactBarItemBlueprint(contactBarItemPresenter, features);
    }

    @Override // javax.inject.Provider
    public ContactBarItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
