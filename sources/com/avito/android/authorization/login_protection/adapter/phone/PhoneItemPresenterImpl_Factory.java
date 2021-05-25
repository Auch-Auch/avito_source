package com.avito.android.authorization.login_protection.adapter.phone;

import com.avito.android.authorization.login_protection.action.PhoneListAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class PhoneItemPresenterImpl_Factory implements Factory<PhoneItemPresenterImpl> {
    public final Provider<Consumer<PhoneListAction>> a;

    public PhoneItemPresenterImpl_Factory(Provider<Consumer<PhoneListAction>> provider) {
        this.a = provider;
    }

    public static PhoneItemPresenterImpl_Factory create(Provider<Consumer<PhoneListAction>> provider) {
        return new PhoneItemPresenterImpl_Factory(provider);
    }

    public static PhoneItemPresenterImpl newInstance(Consumer<PhoneListAction> consumer) {
        return new PhoneItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public PhoneItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
