package com.avito.android.messenger.conversation.mvi.file_download;

import android.content.Context;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FileDownloadManagerImpl_Factory implements Factory<FileDownloadManagerImpl> {
    public final Provider<Context> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<MessageRepo> c;
    public final Provider<FileStorageHelper> d;

    public FileDownloadManagerImpl_Factory(Provider<Context> provider, Provider<SchedulersFactory3> provider2, Provider<MessageRepo> provider3, Provider<FileStorageHelper> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static FileDownloadManagerImpl_Factory create(Provider<Context> provider, Provider<SchedulersFactory3> provider2, Provider<MessageRepo> provider3, Provider<FileStorageHelper> provider4) {
        return new FileDownloadManagerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static FileDownloadManagerImpl newInstance(Context context, SchedulersFactory3 schedulersFactory3, MessageRepo messageRepo, FileStorageHelper fileStorageHelper) {
        return new FileDownloadManagerImpl(context, schedulersFactory3, messageRepo, fileStorageHelper);
    }

    @Override // javax.inject.Provider
    public FileDownloadManagerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
