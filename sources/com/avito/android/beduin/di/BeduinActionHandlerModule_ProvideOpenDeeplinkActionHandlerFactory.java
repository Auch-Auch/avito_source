package com.avito.android.beduin.di;

import androidx.fragment.app.Fragment;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BeduinActionHandlerModule_ProvideOpenDeeplinkActionHandlerFactory implements Factory<BeduinActionHandler> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<Fragment> b;

    public BeduinActionHandlerModule_ProvideOpenDeeplinkActionHandlerFactory(Provider<DeepLinkIntentFactory> provider, Provider<Fragment> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static BeduinActionHandlerModule_ProvideOpenDeeplinkActionHandlerFactory create(Provider<DeepLinkIntentFactory> provider, Provider<Fragment> provider2) {
        return new BeduinActionHandlerModule_ProvideOpenDeeplinkActionHandlerFactory(provider, provider2);
    }

    public static BeduinActionHandler provideOpenDeeplinkActionHandler(DeepLinkIntentFactory deepLinkIntentFactory, Fragment fragment) {
        return (BeduinActionHandler) Preconditions.checkNotNullFromProvides(BeduinActionHandlerModule.INSTANCE.provideOpenDeeplinkActionHandler(deepLinkIntentFactory, fragment));
    }

    @Override // javax.inject.Provider
    public BeduinActionHandler get() {
        return provideOpenDeeplinkActionHandler(this.a.get(), this.b.get());
    }
}
