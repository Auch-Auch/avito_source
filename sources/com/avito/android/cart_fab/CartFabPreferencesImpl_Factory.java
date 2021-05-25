package com.avito.android.cart_fab;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CartFabPreferencesImpl_Factory implements Factory<CartFabPreferencesImpl> {
    public final Provider<Preferences> a;

    public CartFabPreferencesImpl_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static CartFabPreferencesImpl_Factory create(Provider<Preferences> provider) {
        return new CartFabPreferencesImpl_Factory(provider);
    }

    public static CartFabPreferencesImpl newInstance(Preferences preferences) {
        return new CartFabPreferencesImpl(preferences);
    }

    @Override // javax.inject.Provider
    public CartFabPreferencesImpl get() {
        return newInstance(this.a.get());
    }
}
