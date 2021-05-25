package com.avito.android.basket_legacy.di.shared;

import com.avito.android.basket_legacy.utils.VasType;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SharedModule_ProvideVasTypeFactory implements Factory<VasType> {
    public final SharedModule a;

    public SharedModule_ProvideVasTypeFactory(SharedModule sharedModule) {
        this.a = sharedModule;
    }

    public static SharedModule_ProvideVasTypeFactory create(SharedModule sharedModule) {
        return new SharedModule_ProvideVasTypeFactory(sharedModule);
    }

    public static VasType provideVasType(SharedModule sharedModule) {
        return (VasType) Preconditions.checkNotNullFromProvides(sharedModule.provideVasType());
    }

    @Override // javax.inject.Provider
    public VasType get() {
        return provideVasType(this.a);
    }
}
