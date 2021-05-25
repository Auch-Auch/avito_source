package com.avito.android.basket_legacy.di.shared;

import android.content.res.Resources;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SharedModule_ProvideResourcesFactory implements Factory<Resources> {
    public final SharedModule a;

    public SharedModule_ProvideResourcesFactory(SharedModule sharedModule) {
        this.a = sharedModule;
    }

    public static SharedModule_ProvideResourcesFactory create(SharedModule sharedModule) {
        return new SharedModule_ProvideResourcesFactory(sharedModule);
    }

    public static Resources provideResources(SharedModule sharedModule) {
        return (Resources) Preconditions.checkNotNullFromProvides(sharedModule.provideResources());
    }

    @Override // javax.inject.Provider
    public Resources get() {
        return provideResources(this.a);
    }
}
