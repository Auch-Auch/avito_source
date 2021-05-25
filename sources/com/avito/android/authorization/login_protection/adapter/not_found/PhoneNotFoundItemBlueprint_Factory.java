package com.avito.android.authorization.login_protection.adapter.not_found;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhoneNotFoundItemBlueprint_Factory implements Factory<PhoneNotFoundItemBlueprint> {
    public final Provider<PhoneNotFoundItemPresenter> a;

    public PhoneNotFoundItemBlueprint_Factory(Provider<PhoneNotFoundItemPresenter> provider) {
        this.a = provider;
    }

    public static PhoneNotFoundItemBlueprint_Factory create(Provider<PhoneNotFoundItemPresenter> provider) {
        return new PhoneNotFoundItemBlueprint_Factory(provider);
    }

    public static PhoneNotFoundItemBlueprint newInstance(PhoneNotFoundItemPresenter phoneNotFoundItemPresenter) {
        return new PhoneNotFoundItemBlueprint(phoneNotFoundItemPresenter);
    }

    @Override // javax.inject.Provider
    public PhoneNotFoundItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
