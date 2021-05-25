package com.avito.android.publish.drafts.di;

import android.content.Context;
import com.avito.android.publish.drafts.PublishMessageHandler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDraftsModule_ProvideMessageHandlerFactory implements Factory<PublishMessageHandler> {
    public final Provider<Context> a;

    public PublishDraftsModule_ProvideMessageHandlerFactory(Provider<Context> provider) {
        this.a = provider;
    }

    public static PublishDraftsModule_ProvideMessageHandlerFactory create(Provider<Context> provider) {
        return new PublishDraftsModule_ProvideMessageHandlerFactory(provider);
    }

    public static PublishMessageHandler provideMessageHandler(Context context) {
        return (PublishMessageHandler) Preconditions.checkNotNullFromProvides(PublishDraftsModule.provideMessageHandler(context));
    }

    @Override // javax.inject.Provider
    public PublishMessageHandler get() {
        return provideMessageHandler(this.a.get());
    }
}
