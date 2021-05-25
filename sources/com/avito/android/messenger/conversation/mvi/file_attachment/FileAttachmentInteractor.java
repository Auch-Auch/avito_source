package com.avito.android.messenger.conversation.mvi.file_attachment;

import android.net.Uri;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentInteractor;", "", "Landroid/net/Uri;", "persistableContentUri", "", "allowedFileMaxSize", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileInfo;", "uploadFileByUri", "(Landroid/net/Uri;J)Lio/reactivex/rxjava3/core/Single;", "", "", "getAllowedMimeTypes", "()[Ljava/lang/String;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface FileAttachmentInteractor {
    @NotNull
    String[] getAllowedMimeTypes();

    @NotNull
    Single<FileInfo> uploadFileByUri(@NotNull Uri uri, long j);
}
