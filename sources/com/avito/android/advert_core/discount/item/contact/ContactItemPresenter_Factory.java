package com.avito.android.advert_core.discount.item.contact;

import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ContactItemPresenter_Factory implements Factory<ContactItemPresenter> {
    public final Provider<AdvertContactsPresenter> a;

    public ContactItemPresenter_Factory(Provider<AdvertContactsPresenter> provider) {
        this.a = provider;
    }

    public static ContactItemPresenter_Factory create(Provider<AdvertContactsPresenter> provider) {
        return new ContactItemPresenter_Factory(provider);
    }

    public static ContactItemPresenter newInstance(AdvertContactsPresenter advertContactsPresenter) {
        return new ContactItemPresenter(advertContactsPresenter);
    }

    @Override // javax.inject.Provider
    public ContactItemPresenter get() {
        return newInstance(this.a.get());
    }
}
