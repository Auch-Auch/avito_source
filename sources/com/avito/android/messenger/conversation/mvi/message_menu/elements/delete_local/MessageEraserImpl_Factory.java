package com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local;

import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadCanceller;
import com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorage;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MessageEraserImpl_Factory implements Factory<MessageEraserImpl> {
    public final Provider<MessageRepo> a;
    public final Provider<PhotoInteractor> b;
    public final Provider<MessengerPhotoStorage> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<MessengerFileUploadCanceller> e;

    public MessageEraserImpl_Factory(Provider<MessageRepo> provider, Provider<PhotoInteractor> provider2, Provider<MessengerPhotoStorage> provider3, Provider<SchedulersFactory> provider4, Provider<MessengerFileUploadCanceller> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MessageEraserImpl_Factory create(Provider<MessageRepo> provider, Provider<PhotoInteractor> provider2, Provider<MessengerPhotoStorage> provider3, Provider<SchedulersFactory> provider4, Provider<MessengerFileUploadCanceller> provider5) {
        return new MessageEraserImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static MessageEraserImpl newInstance(MessageRepo messageRepo, PhotoInteractor photoInteractor, MessengerPhotoStorage messengerPhotoStorage, SchedulersFactory schedulersFactory, MessengerFileUploadCanceller messengerFileUploadCanceller) {
        return new MessageEraserImpl(messageRepo, photoInteractor, messengerPhotoStorage, schedulersFactory, messengerFileUploadCanceller);
    }

    @Override // javax.inject.Provider
    public MessageEraserImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
