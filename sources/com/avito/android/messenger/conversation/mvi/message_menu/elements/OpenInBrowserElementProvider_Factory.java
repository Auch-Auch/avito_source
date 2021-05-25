package com.avito.android.messenger.conversation.mvi.message_menu.elements;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.OpenInBrowserElementProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class OpenInBrowserElementProvider_Factory implements Factory<OpenInBrowserElementProvider> {
    public final Provider<OpenInBrowserElementProvider.Callback> a;
    public final Provider<Analytics> b;

    public OpenInBrowserElementProvider_Factory(Provider<OpenInBrowserElementProvider.Callback> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static OpenInBrowserElementProvider_Factory create(Provider<OpenInBrowserElementProvider.Callback> provider, Provider<Analytics> provider2) {
        return new OpenInBrowserElementProvider_Factory(provider, provider2);
    }

    public static OpenInBrowserElementProvider newInstance(OpenInBrowserElementProvider.Callback callback, Analytics analytics) {
        return new OpenInBrowserElementProvider(callback, analytics);
    }

    @Override // javax.inject.Provider
    public OpenInBrowserElementProvider get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
