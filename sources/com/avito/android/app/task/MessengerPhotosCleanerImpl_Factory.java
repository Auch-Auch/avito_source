package com.avito.android.app.task;

import com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorage;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MessengerPhotosCleanerImpl_Factory implements Factory<MessengerPhotosCleanerImpl> {
    public final Provider<TimeSource> a;
    public final Provider<MessengerPhotoStorage> b;
    public final Provider<PhotoInteractor> c;
    public final Provider<SchedulersFactory> d;

    public MessengerPhotosCleanerImpl_Factory(Provider<TimeSource> provider, Provider<MessengerPhotoStorage> provider2, Provider<PhotoInteractor> provider3, Provider<SchedulersFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MessengerPhotosCleanerImpl_Factory create(Provider<TimeSource> provider, Provider<MessengerPhotoStorage> provider2, Provider<PhotoInteractor> provider3, Provider<SchedulersFactory> provider4) {
        return new MessengerPhotosCleanerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static MessengerPhotosCleanerImpl newInstance(TimeSource timeSource, MessengerPhotoStorage messengerPhotoStorage, PhotoInteractor photoInteractor, SchedulersFactory schedulersFactory) {
        return new MessengerPhotosCleanerImpl(timeSource, messengerPhotoStorage, photoInteractor, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public MessengerPhotosCleanerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
