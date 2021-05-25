package com.avito.android.authorization.login_protection.adapter.another;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AnotherPhoneItemBlueprint_Factory implements Factory<AnotherPhoneItemBlueprint> {
    public final Provider<AnotherPhoneItemPresenter> a;

    public AnotherPhoneItemBlueprint_Factory(Provider<AnotherPhoneItemPresenter> provider) {
        this.a = provider;
    }

    public static AnotherPhoneItemBlueprint_Factory create(Provider<AnotherPhoneItemPresenter> provider) {
        return new AnotherPhoneItemBlueprint_Factory(provider);
    }

    public static AnotherPhoneItemBlueprint newInstance(AnotherPhoneItemPresenter anotherPhoneItemPresenter) {
        return new AnotherPhoneItemBlueprint(anotherPhoneItemPresenter);
    }

    @Override // javax.inject.Provider
    public AnotherPhoneItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
