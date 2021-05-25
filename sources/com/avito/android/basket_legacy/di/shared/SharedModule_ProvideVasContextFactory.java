package com.avito.android.basket_legacy.di.shared;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SharedModule_ProvideVasContextFactory implements Factory<String> {
    public final SharedModule a;

    public SharedModule_ProvideVasContextFactory(SharedModule sharedModule) {
        this.a = sharedModule;
    }

    public static SharedModule_ProvideVasContextFactory create(SharedModule sharedModule) {
        return new SharedModule_ProvideVasContextFactory(sharedModule);
    }

    public static String provideVasContext(SharedModule sharedModule) {
        return (String) Preconditions.checkNotNullFromProvides(sharedModule.provideVasContext());
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideVasContext(this.a);
    }
}
