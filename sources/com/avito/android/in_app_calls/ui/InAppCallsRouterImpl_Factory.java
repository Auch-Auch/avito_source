package com.avito.android.in_app_calls.ui;

import androidx.fragment.app.FragmentManager;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InAppCallsRouterImpl_Factory implements Factory<InAppCallsRouterImpl> {
    public final Provider<FragmentManager> a;
    public final Provider<Integer> b;

    public InAppCallsRouterImpl_Factory(Provider<FragmentManager> provider, Provider<Integer> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static InAppCallsRouterImpl_Factory create(Provider<FragmentManager> provider, Provider<Integer> provider2) {
        return new InAppCallsRouterImpl_Factory(provider, provider2);
    }

    public static InAppCallsRouterImpl newInstance(FragmentManager fragmentManager, int i) {
        return new InAppCallsRouterImpl(fragmentManager, i);
    }

    @Override // javax.inject.Provider
    public InAppCallsRouterImpl get() {
        return newInstance(this.a.get(), this.b.get().intValue());
    }
}
