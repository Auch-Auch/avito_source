package com.avito.android.calls_shared.storage;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallStorageImpl_Factory implements Factory<CallStorageImpl> {
    public final Provider<Preferences> a;

    public CallStorageImpl_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static CallStorageImpl_Factory create(Provider<Preferences> provider) {
        return new CallStorageImpl_Factory(provider);
    }

    public static CallStorageImpl newInstance(Preferences preferences) {
        return new CallStorageImpl(preferences);
    }

    @Override // javax.inject.Provider
    public CallStorageImpl get() {
        return newInstance(this.a.get());
    }
}
