package com.avito.android.profile_phones.phones_list.list_item;

import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class PhoneListItemPresenterImpl_Factory implements Factory<PhoneListItemPresenterImpl> {
    public final Provider<Consumer<PhoneListItem>> a;

    public PhoneListItemPresenterImpl_Factory(Provider<Consumer<PhoneListItem>> provider) {
        this.a = provider;
    }

    public static PhoneListItemPresenterImpl_Factory create(Provider<Consumer<PhoneListItem>> provider) {
        return new PhoneListItemPresenterImpl_Factory(provider);
    }

    public static PhoneListItemPresenterImpl newInstance(Consumer<PhoneListItem> consumer) {
        return new PhoneListItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public PhoneListItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
