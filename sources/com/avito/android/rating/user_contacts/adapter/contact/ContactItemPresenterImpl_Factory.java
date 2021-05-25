package com.avito.android.rating.user_contacts.adapter.contact;

import com.avito.android.rating.user_contacts.action.UserContactAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class ContactItemPresenterImpl_Factory implements Factory<ContactItemPresenterImpl> {
    public final Provider<Consumer<UserContactAction>> a;

    public ContactItemPresenterImpl_Factory(Provider<Consumer<UserContactAction>> provider) {
        this.a = provider;
    }

    public static ContactItemPresenterImpl_Factory create(Provider<Consumer<UserContactAction>> provider) {
        return new ContactItemPresenterImpl_Factory(provider);
    }

    public static ContactItemPresenterImpl newInstance(Consumer<UserContactAction> consumer) {
        return new ContactItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public ContactItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
