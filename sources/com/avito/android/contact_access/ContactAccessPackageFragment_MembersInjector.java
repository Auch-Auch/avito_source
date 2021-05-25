package com.avito.android.contact_access;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ContactAccessPackageFragment_MembersInjector implements MembersInjector<ContactAccessPackageFragment> {
    public final Provider<ContactAccessPackagePresenter> a;

    public ContactAccessPackageFragment_MembersInjector(Provider<ContactAccessPackagePresenter> provider) {
        this.a = provider;
    }

    public static MembersInjector<ContactAccessPackageFragment> create(Provider<ContactAccessPackagePresenter> provider) {
        return new ContactAccessPackageFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.contact_access.ContactAccessPackageFragment.presenter")
    public static void injectPresenter(ContactAccessPackageFragment contactAccessPackageFragment, ContactAccessPackagePresenter contactAccessPackagePresenter) {
        contactAccessPackageFragment.presenter = contactAccessPackagePresenter;
    }

    public void injectMembers(ContactAccessPackageFragment contactAccessPackageFragment) {
        injectPresenter(contactAccessPackageFragment, this.a.get());
    }
}
