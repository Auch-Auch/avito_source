package com.avito.android.search.map.viewed_pins;

import android.content.SharedPreferences;
import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ViewedPinsStorageImpl_Factory implements Factory<ViewedPinsStorageImpl> {
    public final Provider<SharedPreferences> a;
    public final Provider<Features> b;

    public ViewedPinsStorageImpl_Factory(Provider<SharedPreferences> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ViewedPinsStorageImpl_Factory create(Provider<SharedPreferences> provider, Provider<Features> provider2) {
        return new ViewedPinsStorageImpl_Factory(provider, provider2);
    }

    public static ViewedPinsStorageImpl newInstance(SharedPreferences sharedPreferences, Features features) {
        return new ViewedPinsStorageImpl(sharedPreferences, features);
    }

    @Override // javax.inject.Provider
    public ViewedPinsStorageImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
