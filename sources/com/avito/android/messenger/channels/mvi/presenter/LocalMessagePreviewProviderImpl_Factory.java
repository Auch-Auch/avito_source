package com.avito.android.messenger.channels.mvi.presenter;

import android.content.Context;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LocalMessagePreviewProviderImpl_Factory implements Factory<LocalMessagePreviewProviderImpl> {
    public final Provider<Context> a;
    public final Provider<AttributedTextFormatter> b;

    public LocalMessagePreviewProviderImpl_Factory(Provider<Context> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static LocalMessagePreviewProviderImpl_Factory create(Provider<Context> provider, Provider<AttributedTextFormatter> provider2) {
        return new LocalMessagePreviewProviderImpl_Factory(provider, provider2);
    }

    public static LocalMessagePreviewProviderImpl newInstance(Context context, AttributedTextFormatter attributedTextFormatter) {
        return new LocalMessagePreviewProviderImpl(context, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public LocalMessagePreviewProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
