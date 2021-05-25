package com.avito.android.extended_profile.di;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ExtendedProfileModule_ProvideActionRelayFactory implements Factory<PublishRelay<ExtendedProfileItemAction>> {

    public static final class a {
        public static final ExtendedProfileModule_ProvideActionRelayFactory a = new ExtendedProfileModule_ProvideActionRelayFactory();
    }

    public static ExtendedProfileModule_ProvideActionRelayFactory create() {
        return a.a;
    }

    public static PublishRelay<ExtendedProfileItemAction> provideActionRelay() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(ExtendedProfileModule.provideActionRelay());
    }

    @Override // javax.inject.Provider
    public PublishRelay<ExtendedProfileItemAction> get() {
        return provideActionRelay();
    }
}
