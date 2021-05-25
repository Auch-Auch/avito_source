package com.avito.android.messenger.conversation.mvi.message_menu.elements;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.TextToChunkConverter;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.CopyToClipboardElementProvider;
import com.avito.android.util.ClipDataFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CopyToClipboardElementProvider_Factory implements Factory<CopyToClipboardElementProvider> {
    public final Provider<ClipDataFactory> a;
    public final Provider<Analytics> b;
    public final Provider<CopyToClipboardElementProvider.Callback> c;
    public final Provider<TextToChunkConverter> d;
    public final Provider<Features> e;

    public CopyToClipboardElementProvider_Factory(Provider<ClipDataFactory> provider, Provider<Analytics> provider2, Provider<CopyToClipboardElementProvider.Callback> provider3, Provider<TextToChunkConverter> provider4, Provider<Features> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static CopyToClipboardElementProvider_Factory create(Provider<ClipDataFactory> provider, Provider<Analytics> provider2, Provider<CopyToClipboardElementProvider.Callback> provider3, Provider<TextToChunkConverter> provider4, Provider<Features> provider5) {
        return new CopyToClipboardElementProvider_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CopyToClipboardElementProvider newInstance(ClipDataFactory clipDataFactory, Analytics analytics, CopyToClipboardElementProvider.Callback callback, TextToChunkConverter textToChunkConverter, Features features) {
        return new CopyToClipboardElementProvider(clipDataFactory, analytics, callback, textToChunkConverter, features);
    }

    @Override // javax.inject.Provider
    public CopyToClipboardElementProvider get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
