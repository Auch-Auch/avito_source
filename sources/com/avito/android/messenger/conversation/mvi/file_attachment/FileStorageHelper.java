package com.avito.android.messenger.conversation.mvi.file_attachment;

import android.net.Uri;
import arrow.core.Option;
import io.reactivex.rxjava3.core.Single;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH&¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\n2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\n2\u0006\u0010\u0019\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\n2\u0006\u0010\u0019\u001a\u00020\u0002H&¢\u0006\u0004\b\u001d\u0010\u001cJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\nH&¢\u0006\u0004\b\u001e\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "", "", "fileName", "originalMimeType", "concretizeMimeType", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Landroid/net/Uri;", "contentUri", "fallbackMimeType", "Lio/reactivex/rxjava3/core/Single;", "Larrow/core/Option;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileInfo;", "readFileInfoByContentUri", "(Landroid/net/Uri;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Ljava/io/File;", "createTempFileInInternalDownloadCacheDir", "()Lio/reactivex/rxjava3/core/Single;", "srcFile", "destFileName", "destFileMimeType", "copyFileToDownloads", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "copyToInternalUploadCacheDirAndGet", "(Landroid/net/Uri;)Lio/reactivex/rxjava3/core/Single;", "filePath", "", "deleteFileFromInternalUploadCacheDir", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "deleteFileFromInternalDownloadCacheDir", "clearInternalUploadCacheDir", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface FileStorageHelper {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single readFileInfoByContentUri$default(FileStorageHelper fileStorageHelper, Uri uri, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                return fileStorageHelper.readFileInfoByContentUri(uri, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readFileInfoByContentUri");
        }
    }

    @NotNull
    Single<Boolean> clearInternalUploadCacheDir();

    @NotNull
    String concretizeMimeType(@NotNull String str, @NotNull String str2);

    @NotNull
    Single<Option<Uri>> copyFileToDownloads(@NotNull File file, @NotNull String str, @NotNull String str2);

    @NotNull
    Single<File> copyToInternalUploadCacheDirAndGet(@NotNull Uri uri);

    @NotNull
    Single<File> createTempFileInInternalDownloadCacheDir();

    @NotNull
    Single<Boolean> deleteFileFromInternalDownloadCacheDir(@NotNull String str);

    @NotNull
    Single<Boolean> deleteFileFromInternalUploadCacheDir(@NotNull String str);

    @NotNull
    Single<Option<FileInfo>> readFileInfoByContentUri(@NotNull Uri uri, @Nullable String str);
}
