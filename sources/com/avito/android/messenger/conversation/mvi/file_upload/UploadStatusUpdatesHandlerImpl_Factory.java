package com.avito.android.messenger.conversation.mvi.file_upload;

import android.app.Application;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UploadStatusUpdatesHandlerImpl_Factory implements Factory<UploadStatusUpdatesHandlerImpl> {
    public final Provider<Application> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<MessageRepo> c;
    public final Provider<FileStorageHelper> d;

    public UploadStatusUpdatesHandlerImpl_Factory(Provider<Application> provider, Provider<SchedulersFactory3> provider2, Provider<MessageRepo> provider3, Provider<FileStorageHelper> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static UploadStatusUpdatesHandlerImpl_Factory create(Provider<Application> provider, Provider<SchedulersFactory3> provider2, Provider<MessageRepo> provider3, Provider<FileStorageHelper> provider4) {
        return new UploadStatusUpdatesHandlerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static UploadStatusUpdatesHandlerImpl newInstance(Application application, SchedulersFactory3 schedulersFactory3, MessageRepo messageRepo, FileStorageHelper fileStorageHelper) {
        return new UploadStatusUpdatesHandlerImpl(application, schedulersFactory3, messageRepo, fileStorageHelper);
    }

    @Override // javax.inject.Provider
    public UploadStatusUpdatesHandlerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
