package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelperImpl;
import com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInitializer;
import com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInitializerImpl;
import com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractor;
import com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractorImpl;
import com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadCanceller;
import com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadConfigProvider;
import com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadConfigProviderImpl;
import com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadStarter;
import com.avito.android.messenger.conversation.mvi.file_upload.UploadServiceCancellerImpl;
import com.avito.android.messenger.conversation.mvi.file_upload.UploadServiceStarterImpl;
import com.avito.android.messenger.conversation.mvi.file_upload.UploadStatusUpdatesHandler;
import com.avito.android.messenger.conversation.mvi.file_upload.UploadStatusUpdatesHandlerImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/di/FileUploadModule;", "", "<init>", "()V", "Declarations", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class FileUploadModule {
    @NotNull
    public static final FileUploadModule INSTANCE = new FileUploadModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/di/FileUploadModule$Declarations;", "", "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractorImpl;", "impl", "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor;", "bindFileUploadInteractor", "(Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractorImpl;)Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelperImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "bindFileStorageHelper", "(Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelperImpl;)Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadServiceStarterImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadStarter;", "bindMessengerFileUploadStarter", "(Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadServiceStarterImpl;)Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadStarter;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadServiceCancellerImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadCanceller;", "bindMessengerFileUploadCanceller", "(Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadServiceCancellerImpl;)Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadCanceller;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadConfigProviderImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadConfigProvider;", "bindMessengerFileUploadConfigProvider", "(Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadConfigProviderImpl;)Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadConfigProvider;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadStatusUpdatesHandlerImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadStatusUpdatesHandler;", "bindUploadStatusUpdatesHandler", "(Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadStatusUpdatesHandlerImpl;)Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadStatusUpdatesHandler;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInitializerImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInitializer;", "bindFileUploadInitializer", "(Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInitializerImpl;)Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInitializer;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Reusable
        @Binds
        @NotNull
        FileStorageHelper bindFileStorageHelper(@NotNull FileStorageHelperImpl fileStorageHelperImpl);

        @Singleton
        @Binds
        @NotNull
        FileUploadInitializer bindFileUploadInitializer(@NotNull FileUploadInitializerImpl fileUploadInitializerImpl);

        @Binds
        @NotNull
        FileUploadInteractor bindFileUploadInteractor(@NotNull FileUploadInteractorImpl fileUploadInteractorImpl);

        @Reusable
        @Binds
        @NotNull
        MessengerFileUploadCanceller bindMessengerFileUploadCanceller(@NotNull UploadServiceCancellerImpl uploadServiceCancellerImpl);

        @Binds
        @NotNull
        MessengerFileUploadConfigProvider bindMessengerFileUploadConfigProvider(@NotNull MessengerFileUploadConfigProviderImpl messengerFileUploadConfigProviderImpl);

        @Binds
        @NotNull
        MessengerFileUploadStarter bindMessengerFileUploadStarter(@NotNull UploadServiceStarterImpl uploadServiceStarterImpl);

        @Singleton
        @Binds
        @NotNull
        UploadStatusUpdatesHandler bindUploadStatusUpdatesHandler(@NotNull UploadStatusUpdatesHandlerImpl uploadStatusUpdatesHandlerImpl);
    }
}
