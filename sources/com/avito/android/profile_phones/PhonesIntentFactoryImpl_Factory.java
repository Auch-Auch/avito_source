package com.avito.android.profile_phones;

import com.avito.android.CoreActivityIntentFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhonesIntentFactoryImpl_Factory implements Factory<PhonesIntentFactoryImpl> {
    public final Provider<CoreActivityIntentFactory> a;

    public PhonesIntentFactoryImpl_Factory(Provider<CoreActivityIntentFactory> provider) {
        this.a = provider;
    }

    public static PhonesIntentFactoryImpl_Factory create(Provider<CoreActivityIntentFactory> provider) {
        return new PhonesIntentFactoryImpl_Factory(provider);
    }

    public static PhonesIntentFactoryImpl newInstance(CoreActivityIntentFactory coreActivityIntentFactory) {
        return new PhonesIntentFactoryImpl(coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public PhonesIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
