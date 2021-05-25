package com.avito.android.search.map.view;

import android.app.Activity;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarkerIconFactoryImpl_Factory implements Factory<MarkerIconFactoryImpl> {
    public final Provider<Activity> a;

    public MarkerIconFactoryImpl_Factory(Provider<Activity> provider) {
        this.a = provider;
    }

    public static MarkerIconFactoryImpl_Factory create(Provider<Activity> provider) {
        return new MarkerIconFactoryImpl_Factory(provider);
    }

    public static MarkerIconFactoryImpl newInstance(Activity activity) {
        return new MarkerIconFactoryImpl(activity);
    }

    @Override // javax.inject.Provider
    public MarkerIconFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
