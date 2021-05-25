package com.avito.android.messenger.conversation.mvi.file_download;

import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.MessageEraser;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FileMessageClickInteractorImpl_Factory implements Factory<FileMessageClickInteractorImpl> {
    public final Provider<String> a;
    public final Provider<TimeSource> b;
    public final Provider<FileStorageHelper> c;
    public final Provider<FileDownloadManager> d;
    public final Provider<MessageEraser> e;
    public final Provider<PermissionChecker> f;
    public final Provider<SchedulersFactory> g;

    public FileMessageClickInteractorImpl_Factory(Provider<String> provider, Provider<TimeSource> provider2, Provider<FileStorageHelper> provider3, Provider<FileDownloadManager> provider4, Provider<MessageEraser> provider5, Provider<PermissionChecker> provider6, Provider<SchedulersFactory> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static FileMessageClickInteractorImpl_Factory create(Provider<String> provider, Provider<TimeSource> provider2, Provider<FileStorageHelper> provider3, Provider<FileDownloadManager> provider4, Provider<MessageEraser> provider5, Provider<PermissionChecker> provider6, Provider<SchedulersFactory> provider7) {
        return new FileMessageClickInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static FileMessageClickInteractorImpl newInstance(String str, TimeSource timeSource, FileStorageHelper fileStorageHelper, FileDownloadManager fileDownloadManager, MessageEraser messageEraser, PermissionChecker permissionChecker, SchedulersFactory schedulersFactory) {
        return new FileMessageClickInteractorImpl(str, timeSource, fileStorageHelper, fileDownloadManager, messageEraser, permissionChecker, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public FileMessageClickInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
