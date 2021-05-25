package com.avito.android.authorization.login_protection.adapter.another;

import com.avito.android.authorization.login_protection.action.PhoneListAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class AnotherPhoneItemPresenterImpl_Factory implements Factory<AnotherPhoneItemPresenterImpl> {
    public final Provider<Consumer<PhoneListAction>> a;

    public AnotherPhoneItemPresenterImpl_Factory(Provider<Consumer<PhoneListAction>> provider) {
        this.a = provider;
    }

    public static AnotherPhoneItemPresenterImpl_Factory create(Provider<Consumer<PhoneListAction>> provider) {
        return new AnotherPhoneItemPresenterImpl_Factory(provider);
    }

    public static AnotherPhoneItemPresenterImpl newInstance(Consumer<PhoneListAction> consumer) {
        return new AnotherPhoneItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public AnotherPhoneItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
