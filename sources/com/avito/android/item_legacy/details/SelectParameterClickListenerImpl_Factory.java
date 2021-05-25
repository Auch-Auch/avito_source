package com.avito.android.item_legacy.details;

import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectParameterClickListenerImpl_Factory implements Factory<SelectParameterClickListenerImpl> {
    public final Provider<Integer> a;
    public final Provider<Features> b;

    public SelectParameterClickListenerImpl_Factory(Provider<Integer> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SelectParameterClickListenerImpl_Factory create(Provider<Integer> provider, Provider<Features> provider2) {
        return new SelectParameterClickListenerImpl_Factory(provider, provider2);
    }

    public static SelectParameterClickListenerImpl newInstance(int i, Features features) {
        return new SelectParameterClickListenerImpl(i, features);
    }

    @Override // javax.inject.Provider
    public SelectParameterClickListenerImpl get() {
        return newInstance(this.a.get().intValue(), this.b.get());
    }
}
