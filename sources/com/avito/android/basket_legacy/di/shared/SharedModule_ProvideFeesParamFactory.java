package com.avito.android.basket_legacy.di.shared;

import dagger.internal.Factory;
public final class SharedModule_ProvideFeesParamFactory implements Factory<Boolean> {
    public final SharedModule a;

    public SharedModule_ProvideFeesParamFactory(SharedModule sharedModule) {
        this.a = sharedModule;
    }

    public static SharedModule_ProvideFeesParamFactory create(SharedModule sharedModule) {
        return new SharedModule_ProvideFeesParamFactory(sharedModule);
    }

    public static boolean provideFeesParam(SharedModule sharedModule) {
        return sharedModule.provideFeesParam();
    }

    @Override // javax.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provideFeesParam(this.a));
    }
}
