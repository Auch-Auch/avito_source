package com.avito.android.messenger.conversation.mvi.file_upload;

import com.avito.android.messenger.service.MessengerInfoProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.SessionProvider;
public final class MessengerFileUploadConfigProviderImpl_Factory implements Factory<MessengerFileUploadConfigProviderImpl> {
    public final Provider<SessionProvider> a;
    public final Provider<MessengerInfoProvider> b;

    public MessengerFileUploadConfigProviderImpl_Factory(Provider<SessionProvider> provider, Provider<MessengerInfoProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MessengerFileUploadConfigProviderImpl_Factory create(Provider<SessionProvider> provider, Provider<MessengerInfoProvider> provider2) {
        return new MessengerFileUploadConfigProviderImpl_Factory(provider, provider2);
    }

    public static MessengerFileUploadConfigProviderImpl newInstance(SessionProvider sessionProvider, MessengerInfoProvider messengerInfoProvider) {
        return new MessengerFileUploadConfigProviderImpl(sessionProvider, messengerInfoProvider);
    }

    @Override // javax.inject.Provider
    public MessengerFileUploadConfigProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
