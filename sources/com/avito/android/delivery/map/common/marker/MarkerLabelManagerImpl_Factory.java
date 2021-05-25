package com.avito.android.delivery.map.common.marker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarkerLabelManagerImpl_Factory implements Factory<MarkerLabelManagerImpl> {
    public final Provider<Context> a;

    public MarkerLabelManagerImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static MarkerLabelManagerImpl_Factory create(Provider<Context> provider) {
        return new MarkerLabelManagerImpl_Factory(provider);
    }

    public static MarkerLabelManagerImpl newInstance(Context context) {
        return new MarkerLabelManagerImpl(context);
    }

    @Override // javax.inject.Provider
    public MarkerLabelManagerImpl get() {
        return newInstance(this.a.get());
    }
}
