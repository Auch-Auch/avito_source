package com.avito.android.user_advert.advert;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyAdvertStorageImpl_Factory implements Factory<MyAdvertStorageImpl> {
    public final Provider<Preferences> a;

    public MyAdvertStorageImpl_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static MyAdvertStorageImpl_Factory create(Provider<Preferences> provider) {
        return new MyAdvertStorageImpl_Factory(provider);
    }

    public static MyAdvertStorageImpl newInstance(Preferences preferences) {
        return new MyAdvertStorageImpl(preferences);
    }

    @Override // javax.inject.Provider
    public MyAdvertStorageImpl get() {
        return newInstance(this.a.get());
    }
}
