package com.avito.android.beduin.di;

import androidx.fragment.app.Fragment;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BeduinActionHandlerModule_ProvideOpenLinkActionHandlerFactory implements Factory<BeduinActionHandler> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<DeepLinkFactory> b;
    public final Provider<Fragment> c;

    public BeduinActionHandlerModule_ProvideOpenLinkActionHandlerFactory(Provider<DeepLinkIntentFactory> provider, Provider<DeepLinkFactory> provider2, Provider<Fragment> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static BeduinActionHandlerModule_ProvideOpenLinkActionHandlerFactory create(Provider<DeepLinkIntentFactory> provider, Provider<DeepLinkFactory> provider2, Provider<Fragment> provider3) {
        return new BeduinActionHandlerModule_ProvideOpenLinkActionHandlerFactory(provider, provider2, provider3);
    }

    public static BeduinActionHandler provideOpenLinkActionHandler(DeepLinkIntentFactory deepLinkIntentFactory, DeepLinkFactory deepLinkFactory, Fragment fragment) {
        return (BeduinActionHandler) Preconditions.checkNotNullFromProvides(BeduinActionHandlerModule.INSTANCE.provideOpenLinkActionHandler(deepLinkIntentFactory, deepLinkFactory, fragment));
    }

    @Override // javax.inject.Provider
    public BeduinActionHandler get() {
        return provideOpenLinkActionHandler(this.a.get(), this.b.get(), this.c.get());
    }
}
