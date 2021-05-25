package com.avito.android.messenger.conversation.mvi.file_upload;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class FileUploadInteractorImpl_Factory implements Factory<FileUploadInteractorImpl> {
    public final Provider<MessengerFileUploadStarter> a;
    public final Provider<MessageRepo> b;
    public final Provider<FileStorageHelper> c;
    public final Provider<MessengerClient<AvitoMessengerApi>> d;
    public final Provider<FileUploadInitializer> e;
    public final Provider<Analytics> f;

    public FileUploadInteractorImpl_Factory(Provider<MessengerFileUploadStarter> provider, Provider<MessageRepo> provider2, Provider<FileStorageHelper> provider3, Provider<MessengerClient<AvitoMessengerApi>> provider4, Provider<FileUploadInitializer> provider5, Provider<Analytics> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static FileUploadInteractorImpl_Factory create(Provider<MessengerFileUploadStarter> provider, Provider<MessageRepo> provider2, Provider<FileStorageHelper> provider3, Provider<MessengerClient<AvitoMessengerApi>> provider4, Provider<FileUploadInitializer> provider5, Provider<Analytics> provider6) {
        return new FileUploadInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static FileUploadInteractorImpl newInstance(MessengerFileUploadStarter messengerFileUploadStarter, MessageRepo messageRepo, FileStorageHelper fileStorageHelper, MessengerClient<AvitoMessengerApi> messengerClient, FileUploadInitializer fileUploadInitializer, Analytics analytics) {
        return new FileUploadInteractorImpl(messengerFileUploadStarter, messageRepo, fileStorageHelper, messengerClient, fileUploadInitializer, analytics);
    }

    @Override // javax.inject.Provider
    public FileUploadInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
