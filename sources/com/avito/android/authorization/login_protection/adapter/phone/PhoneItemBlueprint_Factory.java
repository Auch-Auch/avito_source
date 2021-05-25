package com.avito.android.authorization.login_protection.adapter.phone;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhoneItemBlueprint_Factory implements Factory<PhoneItemBlueprint> {
    public final Provider<PhoneItemPresenter> a;

    public PhoneItemBlueprint_Factory(Provider<PhoneItemPresenter> provider) {
        this.a = provider;
    }

    public static PhoneItemBlueprint_Factory create(Provider<PhoneItemPresenter> provider) {
        return new PhoneItemBlueprint_Factory(provider);
    }

    public static PhoneItemBlueprint newInstance(PhoneItemPresenter phoneItemPresenter) {
        return new PhoneItemBlueprint(phoneItemPresenter);
    }

    @Override // javax.inject.Provider
    public PhoneItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
