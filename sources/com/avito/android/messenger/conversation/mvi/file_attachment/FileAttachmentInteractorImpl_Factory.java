package com.avito.android.messenger.conversation.mvi.file_attachment;

import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FileAttachmentInteractorImpl_Factory implements Factory<FileAttachmentInteractorImpl> {
    public final Provider<FileStorageHelper> a;
    public final Provider<SchedulersFactory3> b;

    public FileAttachmentInteractorImpl_Factory(Provider<FileStorageHelper> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FileAttachmentInteractorImpl_Factory create(Provider<FileStorageHelper> provider, Provider<SchedulersFactory3> provider2) {
        return new FileAttachmentInteractorImpl_Factory(provider, provider2);
    }

    public static FileAttachmentInteractorImpl newInstance(FileStorageHelper fileStorageHelper, SchedulersFactory3 schedulersFactory3) {
        return new FileAttachmentInteractorImpl(fileStorageHelper, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public FileAttachmentInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
