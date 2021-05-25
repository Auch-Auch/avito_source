package com.avito.android.messenger.conversation.mvi.file_download;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class FileDownloadWorker_MembersInjector implements MembersInjector<FileDownloadWorker> {
    public final Provider<FileDownloadWorkerDelegate> a;

    public FileDownloadWorker_MembersInjector(Provider<FileDownloadWorkerDelegate> provider) {
        this.a = provider;
    }

    public static MembersInjector<FileDownloadWorker> create(Provider<FileDownloadWorkerDelegate> provider) {
        return new FileDownloadWorker_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorker.delegate")
    public static void injectDelegate(FileDownloadWorker fileDownloadWorker, FileDownloadWorkerDelegate fileDownloadWorkerDelegate) {
        fileDownloadWorker.delegate = fileDownloadWorkerDelegate;
    }

    public void injectMembers(FileDownloadWorker fileDownloadWorker) {
        injectDelegate(fileDownloadWorker, this.a.get());
    }
}
