package com.avito.android.phone_confirmation.state;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhoneConfirmationTimeStorageImpl_Factory implements Factory<PhoneConfirmationTimeStorageImpl> {
    public final Provider<Preferences> a;

    public PhoneConfirmationTimeStorageImpl_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static PhoneConfirmationTimeStorageImpl_Factory create(Provider<Preferences> provider) {
        return new PhoneConfirmationTimeStorageImpl_Factory(provider);
    }

    public static PhoneConfirmationTimeStorageImpl newInstance(Preferences preferences) {
        return new PhoneConfirmationTimeStorageImpl(preferences);
    }

    @Override // javax.inject.Provider
    public PhoneConfirmationTimeStorageImpl get() {
        return newInstance(this.a.get());
    }
}
