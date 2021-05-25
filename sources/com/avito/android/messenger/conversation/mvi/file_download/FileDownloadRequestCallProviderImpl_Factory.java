package com.avito.android.messenger.conversation.mvi.file_download;

import com.avito.android.messenger.service.MessengerInfoProvider;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import ru.avito.messenger.SessionProvider;
public final class FileDownloadRequestCallProviderImpl_Factory implements Factory<FileDownloadRequestCallProviderImpl> {
    public final Provider<OkHttpClient> a;
    public final Provider<SessionProvider> b;
    public final Provider<MessengerInfoProvider> c;

    public FileDownloadRequestCallProviderImpl_Factory(Provider<OkHttpClient> provider, Provider<SessionProvider> provider2, Provider<MessengerInfoProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static FileDownloadRequestCallProviderImpl_Factory create(Provider<OkHttpClient> provider, Provider<SessionProvider> provider2, Provider<MessengerInfoProvider> provider3) {
        return new FileDownloadRequestCallProviderImpl_Factory(provider, provider2, provider3);
    }

    public static FileDownloadRequestCallProviderImpl newInstance(Lazy<OkHttpClient> lazy, SessionProvider sessionProvider, MessengerInfoProvider messengerInfoProvider) {
        return new FileDownloadRequestCallProviderImpl(lazy, sessionProvider, messengerInfoProvider);
    }

    @Override // javax.inject.Provider
    public FileDownloadRequestCallProviderImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get(), this.c.get());
    }
}
