package com.avito.android.messenger.conversation.mvi.file_download;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class FileDownloadWorkerDelegateImpl_Factory implements Factory<FileDownloadWorkerDelegateImpl> {
    public final Provider<AccountStateProvider> a;
    public final Provider<Features> b;
    public final Provider<MessageRepo> c;
    public final Provider<MessengerClient<AvitoMessengerApi>> d;
    public final Provider<FileDownloadRequestCallProvider> e;
    public final Provider<FileStorageHelper> f;
    public final Provider<Analytics> g;
    public final Provider<SchedulersFactory3> h;

    public FileDownloadWorkerDelegateImpl_Factory(Provider<AccountStateProvider> provider, Provider<Features> provider2, Provider<MessageRepo> provider3, Provider<MessengerClient<AvitoMessengerApi>> provider4, Provider<FileDownloadRequestCallProvider> provider5, Provider<FileStorageHelper> provider6, Provider<Analytics> provider7, Provider<SchedulersFactory3> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static FileDownloadWorkerDelegateImpl_Factory create(Provider<AccountStateProvider> provider, Provider<Features> provider2, Provider<MessageRepo> provider3, Provider<MessengerClient<AvitoMessengerApi>> provider4, Provider<FileDownloadRequestCallProvider> provider5, Provider<FileStorageHelper> provider6, Provider<Analytics> provider7, Provider<SchedulersFactory3> provider8) {
        return new FileDownloadWorkerDelegateImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static FileDownloadWorkerDelegateImpl newInstance(AccountStateProvider accountStateProvider, Features features, MessageRepo messageRepo, MessengerClient<AvitoMessengerApi> messengerClient, FileDownloadRequestCallProvider fileDownloadRequestCallProvider, FileStorageHelper fileStorageHelper, Analytics analytics, SchedulersFactory3 schedulersFactory3) {
        return new FileDownloadWorkerDelegateImpl(accountStateProvider, features, messageRepo, messengerClient, fileDownloadRequestCallProvider, fileStorageHelper, analytics, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public FileDownloadWorkerDelegateImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
