package com.avito.android.basket_legacy.di.shared;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SharedModule_ProvideAdvertIdFactory implements Factory<String> {
    public final SharedModule a;

    public SharedModule_ProvideAdvertIdFactory(SharedModule sharedModule) {
        this.a = sharedModule;
    }

    public static SharedModule_ProvideAdvertIdFactory create(SharedModule sharedModule) {
        return new SharedModule_ProvideAdvertIdFactory(sharedModule);
    }

    public static String provideAdvertId(SharedModule sharedModule) {
        return (String) Preconditions.checkNotNullFromProvides(sharedModule.provideAdvertId());
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideAdvertId(this.a);
    }
}
