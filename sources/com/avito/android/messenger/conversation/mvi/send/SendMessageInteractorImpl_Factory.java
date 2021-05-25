package com.avito.android.messenger.conversation.mvi.send;

import com.avito.android.messenger.MessageLocalIdGenerator;
import com.avito.android.messenger.TextToChunkConverter;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class SendMessageInteractorImpl_Factory implements Factory<SendMessageInteractorImpl> {
    public final Provider<String> a;
    public final Provider<MessengerClient<AvitoMessengerApi>> b;
    public final Provider<TextToChunkConverter> c;
    public final Provider<PhotoPickerResultHandler> d;
    public final Provider<MessageLocalIdGenerator> e;
    public final Provider<TimeSource> f;
    public final Provider<MessageRepo> g;
    public final Provider<SchedulersFactory> h;

    public SendMessageInteractorImpl_Factory(Provider<String> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<TextToChunkConverter> provider3, Provider<PhotoPickerResultHandler> provider4, Provider<MessageLocalIdGenerator> provider5, Provider<TimeSource> provider6, Provider<MessageRepo> provider7, Provider<SchedulersFactory> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static SendMessageInteractorImpl_Factory create(Provider<String> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<TextToChunkConverter> provider3, Provider<PhotoPickerResultHandler> provider4, Provider<MessageLocalIdGenerator> provider5, Provider<TimeSource> provider6, Provider<MessageRepo> provider7, Provider<SchedulersFactory> provider8) {
        return new SendMessageInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static SendMessageInteractorImpl newInstance(String str, MessengerClient<AvitoMessengerApi> messengerClient, TextToChunkConverter textToChunkConverter, PhotoPickerResultHandler photoPickerResultHandler, MessageLocalIdGenerator messageLocalIdGenerator, TimeSource timeSource, MessageRepo messageRepo, SchedulersFactory schedulersFactory) {
        return new SendMessageInteractorImpl(str, messengerClient, textToChunkConverter, photoPickerResultHandler, messageLocalIdGenerator, timeSource, messageRepo, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public SendMessageInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
