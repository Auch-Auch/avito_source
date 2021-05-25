package com.avito.android.messenger.conversation.mvi.file_download;

import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadModule;", "", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadWorkerDelegateImpl;", "impl", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadWorkerDelegate;", "bindFileDownloadWorkerDelegate", "(Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadWorkerDelegateImpl;)Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadWorkerDelegate;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManagerImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManager;", "bindFileDownloadManager", "(Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManagerImpl;)Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManager;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadRequestCallProviderImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadRequestCallProvider;", "bindFileDownloadRequestCallProvider", "(Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadRequestCallProviderImpl;)Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadRequestCallProvider;", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface FileDownloadModule {
    @Reusable
    @Binds
    @NotNull
    FileDownloadManager bindFileDownloadManager(@NotNull FileDownloadManagerImpl fileDownloadManagerImpl);

    @Reusable
    @Binds
    @NotNull
    FileDownloadRequestCallProvider bindFileDownloadRequestCallProvider(@NotNull FileDownloadRequestCallProviderImpl fileDownloadRequestCallProviderImpl);

    @Reusable
    @Binds
    @NotNull
    FileDownloadWorkerDelegate bindFileDownloadWorkerDelegate(@NotNull FileDownloadWorkerDelegateImpl fileDownloadWorkerDelegateImpl);
}
