package com.avito.android;

import com.avito.android.app.task.LocalMessageSender;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractor;
import com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadCanceller;
import com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorage;
import com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolver;
import com.avito.android.messenger.service.ImageUploadStarter;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class PendingMessageHandlerModule_ProvideLocalMessageSenderFactory implements Factory<LocalMessageSender> {
    public final Provider<MessengerClient<AvitoMessengerApi>> a;
    public final Provider<FileUploadInteractor> b;
    public final Provider<MessageBodyResolver> c;
    public final Provider<MessengerEntityConverter> d;
    public final Provider<ImageUploadStarter> e;
    public final Provider<PhotoInteractor> f;
    public final Provider<MessengerPhotoStorage> g;
    public final Provider<SchedulersFactory> h;
    public final Provider<Features> i;
    public final Provider<MessengerFileUploadCanceller> j;

    public PendingMessageHandlerModule_ProvideLocalMessageSenderFactory(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<FileUploadInteractor> provider2, Provider<MessageBodyResolver> provider3, Provider<MessengerEntityConverter> provider4, Provider<ImageUploadStarter> provider5, Provider<PhotoInteractor> provider6, Provider<MessengerPhotoStorage> provider7, Provider<SchedulersFactory> provider8, Provider<Features> provider9, Provider<MessengerFileUploadCanceller> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static PendingMessageHandlerModule_ProvideLocalMessageSenderFactory create(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<FileUploadInteractor> provider2, Provider<MessageBodyResolver> provider3, Provider<MessengerEntityConverter> provider4, Provider<ImageUploadStarter> provider5, Provider<PhotoInteractor> provider6, Provider<MessengerPhotoStorage> provider7, Provider<SchedulersFactory> provider8, Provider<Features> provider9, Provider<MessengerFileUploadCanceller> provider10) {
        return new PendingMessageHandlerModule_ProvideLocalMessageSenderFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static LocalMessageSender provideLocalMessageSender(MessengerClient<AvitoMessengerApi> messengerClient, FileUploadInteractor fileUploadInteractor, MessageBodyResolver messageBodyResolver, MessengerEntityConverter messengerEntityConverter, ImageUploadStarter imageUploadStarter, PhotoInteractor photoInteractor, MessengerPhotoStorage messengerPhotoStorage, SchedulersFactory schedulersFactory, Features features, MessengerFileUploadCanceller messengerFileUploadCanceller) {
        return (LocalMessageSender) Preconditions.checkNotNullFromProvides(PendingMessageHandlerModule.INSTANCE.provideLocalMessageSender(messengerClient, fileUploadInteractor, messageBodyResolver, messengerEntityConverter, imageUploadStarter, photoInteractor, messengerPhotoStorage, schedulersFactory, features, messengerFileUploadCanceller));
    }

    @Override // javax.inject.Provider
    public LocalMessageSender get() {
        return provideLocalMessageSender(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
