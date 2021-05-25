package com.avito.android.messenger;

import com.avito.android.deep_linking.DeepLinkFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MessengerEntityConverterImpl_Factory implements Factory<MessengerEntityConverterImpl> {
    public final Provider<TextToChunkConverter> a;
    public final Provider<DeepLinkFactory> b;

    public MessengerEntityConverterImpl_Factory(Provider<TextToChunkConverter> provider, Provider<DeepLinkFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MessengerEntityConverterImpl_Factory create(Provider<TextToChunkConverter> provider, Provider<DeepLinkFactory> provider2) {
        return new MessengerEntityConverterImpl_Factory(provider, provider2);
    }

    public static MessengerEntityConverterImpl newInstance(TextToChunkConverter textToChunkConverter, DeepLinkFactory deepLinkFactory) {
        return new MessengerEntityConverterImpl(textToChunkConverter, deepLinkFactory);
    }

    @Override // javax.inject.Provider
    public MessengerEntityConverterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
