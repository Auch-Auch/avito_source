package com.avito.android.authorization.login_protection.adapter.not_found;

import dagger.internal.Factory;
public final class PhoneNotFoundItemPresenterImpl_Factory implements Factory<PhoneNotFoundItemPresenterImpl> {

    public static final class a {
        public static final PhoneNotFoundItemPresenterImpl_Factory a = new PhoneNotFoundItemPresenterImpl_Factory();
    }

    public static PhoneNotFoundItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static PhoneNotFoundItemPresenterImpl newInstance() {
        return new PhoneNotFoundItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public PhoneNotFoundItemPresenterImpl get() {
        return newInstance();
    }
}
