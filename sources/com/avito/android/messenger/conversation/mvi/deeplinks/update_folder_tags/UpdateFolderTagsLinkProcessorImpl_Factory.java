package com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class UpdateFolderTagsLinkProcessorImpl_Factory implements Factory<UpdateFolderTagsLinkProcessorImpl> {
    public final Provider<MessengerClient<AvitoMessengerApi>> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<Formatter<Throwable>> c;
    public final Provider<Analytics> d;

    public UpdateFolderTagsLinkProcessorImpl_Factory(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<SchedulersFactory> provider2, Provider<Formatter<Throwable>> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static UpdateFolderTagsLinkProcessorImpl_Factory create(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<SchedulersFactory> provider2, Provider<Formatter<Throwable>> provider3, Provider<Analytics> provider4) {
        return new UpdateFolderTagsLinkProcessorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static UpdateFolderTagsLinkProcessorImpl newInstance(MessengerClient<AvitoMessengerApi> messengerClient, SchedulersFactory schedulersFactory, Formatter<Throwable> formatter, Analytics analytics) {
        return new UpdateFolderTagsLinkProcessorImpl(messengerClient, schedulersFactory, formatter, analytics);
    }

    @Override // javax.inject.Provider
    public UpdateFolderTagsLinkProcessorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
