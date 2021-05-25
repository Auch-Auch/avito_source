package com.avito.android.profile_phones.phones_list;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhonesConverterImpl_Factory implements Factory<PhonesConverterImpl> {
    public final Provider<PhonesListResourceProvider> a;

    public PhonesConverterImpl_Factory(Provider<PhonesListResourceProvider> provider) {
        this.a = provider;
    }

    public static PhonesConverterImpl_Factory create(Provider<PhonesListResourceProvider> provider) {
        return new PhonesConverterImpl_Factory(provider);
    }

    public static PhonesConverterImpl newInstance(PhonesListResourceProvider phonesListResourceProvider) {
        return new PhonesConverterImpl(phonesListResourceProvider);
    }

    @Override // javax.inject.Provider
    public PhonesConverterImpl get() {
        return newInstance(this.a.get());
    }
}
