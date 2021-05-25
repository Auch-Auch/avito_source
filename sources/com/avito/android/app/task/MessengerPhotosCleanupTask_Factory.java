package com.avito.android.app.task;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MessengerPhotosCleanupTask_Factory implements Factory<MessengerPhotosCleanupTask> {
    public final Provider<MessengerPhotosCleaner> a;

    public MessengerPhotosCleanupTask_Factory(Provider<MessengerPhotosCleaner> provider) {
        this.a = provider;
    }

    public static MessengerPhotosCleanupTask_Factory create(Provider<MessengerPhotosCleaner> provider) {
        return new MessengerPhotosCleanupTask_Factory(provider);
    }

    public static MessengerPhotosCleanupTask newInstance(MessengerPhotosCleaner messengerPhotosCleaner) {
        return new MessengerPhotosCleanupTask(messengerPhotosCleaner);
    }

    @Override // javax.inject.Provider
    public MessengerPhotosCleanupTask get() {
        return newInstance(this.a.get());
    }
}
