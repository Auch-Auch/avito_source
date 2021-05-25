package com.avito.android.messenger.conversation.mvi.message_menu;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MessageContextDataFactoryImpl_Factory implements Factory<MessageContextDataFactoryImpl> {
    public final Provider<Context> a;
    public final Provider<Features> b;
    public final Provider<AttributedTextFormatter> c;

    public MessageContextDataFactoryImpl_Factory(Provider<Context> provider, Provider<Features> provider2, Provider<AttributedTextFormatter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MessageContextDataFactoryImpl_Factory create(Provider<Context> provider, Provider<Features> provider2, Provider<AttributedTextFormatter> provider3) {
        return new MessageContextDataFactoryImpl_Factory(provider, provider2, provider3);
    }

    public static MessageContextDataFactoryImpl newInstance(Context context, Features features, AttributedTextFormatter attributedTextFormatter) {
        return new MessageContextDataFactoryImpl(context, features, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public MessageContextDataFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
