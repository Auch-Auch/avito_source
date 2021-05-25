package com.avito.android.basket_legacy.di.shared;

import androidx.fragment.app.FragmentActivity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SharedModule_ProvideActivityFactory implements Factory<FragmentActivity> {
    public final SharedModule a;

    public SharedModule_ProvideActivityFactory(SharedModule sharedModule) {
        this.a = sharedModule;
    }

    public static SharedModule_ProvideActivityFactory create(SharedModule sharedModule) {
        return new SharedModule_ProvideActivityFactory(sharedModule);
    }

    public static FragmentActivity provideActivity(SharedModule sharedModule) {
        return (FragmentActivity) Preconditions.checkNotNullFromProvides(sharedModule.provideActivity());
    }

    @Override // javax.inject.Provider
    public FragmentActivity get() {
        return provideActivity(this.a);
    }
}
