package com.avito.android.preferences;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SocialNotificationStateStorageImpl_Factory implements Factory<SocialNotificationStateStorageImpl> {
    public final Provider<Preferences> a;

    public SocialNotificationStateStorageImpl_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static SocialNotificationStateStorageImpl_Factory create(Provider<Preferences> provider) {
        return new SocialNotificationStateStorageImpl_Factory(provider);
    }

    public static SocialNotificationStateStorageImpl newInstance(Preferences preferences) {
        return new SocialNotificationStateStorageImpl(preferences);
    }

    @Override // javax.inject.Provider
    public SocialNotificationStateStorageImpl get() {
        return newInstance(this.a.get());
    }
}
