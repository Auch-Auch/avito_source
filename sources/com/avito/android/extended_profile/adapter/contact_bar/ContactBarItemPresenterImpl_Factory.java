package com.avito.android.extended_profile.adapter.contact_bar;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class ContactBarItemPresenterImpl_Factory implements Factory<ContactBarItemPresenterImpl> {
    public final Provider<Consumer<ExtendedProfileItemAction>> a;

    public ContactBarItemPresenterImpl_Factory(Provider<Consumer<ExtendedProfileItemAction>> provider) {
        this.a = provider;
    }

    public static ContactBarItemPresenterImpl_Factory create(Provider<Consumer<ExtendedProfileItemAction>> provider) {
        return new ContactBarItemPresenterImpl_Factory(provider);
    }

    public static ContactBarItemPresenterImpl newInstance(Consumer<ExtendedProfileItemAction> consumer) {
        return new ContactBarItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public ContactBarItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
