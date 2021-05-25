package com.avito.android.extended_profile.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ExtendedProfileSpanLookup_Factory implements Factory<ExtendedProfileSpanLookup> {
    public final Provider<Integer> a;

    public ExtendedProfileSpanLookup_Factory(Provider<Integer> provider) {
        this.a = provider;
    }

    public static ExtendedProfileSpanLookup_Factory create(Provider<Integer> provider) {
        return new ExtendedProfileSpanLookup_Factory(provider);
    }

    public static ExtendedProfileSpanLookup newInstance(int i) {
        return new ExtendedProfileSpanLookup(i);
    }

    @Override // javax.inject.Provider
    public ExtendedProfileSpanLookup get() {
        return newInstance(this.a.get().intValue());
    }
}
