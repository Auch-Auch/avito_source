package com.avito.android.messenger.conversation.mvi.file_attachment;

import a2.a.a.o1.d.a0.d.a;
import android.net.Uri;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileAttachmentException;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentInteractor;", "Landroid/net/Uri;", "persistableContentUri", "", "allowedFileMaxSize", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileInfo;", "uploadFileByUri", "(Landroid/net/Uri;J)Lio/reactivex/rxjava3/core/Single;", "", "", "getAllowedMimeTypes", "()[Ljava/lang/String;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "fileStorageHelper", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;Lcom/avito/android/util/SchedulersFactory3;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FileAttachmentInteractorImpl implements FileAttachmentInteractor {
    public final FileStorageHelper a;
    public final SchedulersFactory3 b;

    @Inject
    public FileAttachmentInteractorImpl(@NotNull FileStorageHelper fileStorageHelper, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(fileStorageHelper, "fileStorageHelper");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = fileStorageHelper;
        this.b = schedulersFactory3;
    }

    public static final Single access$checkFileMaxSize(FileAttachmentInteractorImpl fileAttachmentInteractorImpl, FileInfo fileInfo, long j) {
        Objects.requireNonNull(fileAttachmentInteractorImpl);
        if (fileInfo.getSizeInBytes() > j) {
            Single error = Single.error(new FileAttachmentException.FileMaxSizeExceeded(fileInfo.getSizeInBytes(), j));
            Intrinsics.checkNotNullExpressionValue(error, "Single.error(FileAttachm…tes, allowedFileMaxSize))");
            return error;
        }
        Single just = Single.just(fileInfo);
        Intrinsics.checkNotNullExpressionValue(just, "Single.just(fileInfo)");
        return just;
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_attachment.FileAttachmentInteractor
    @NotNull
    public String[] getAllowedMimeTypes() {
        return FileFormats.INSTANCE.getMimeTypes();
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_attachment.FileAttachmentInteractor
    @NotNull
    public Single<FileInfo> uploadFileByUri(@NotNull Uri uri, long j) {
        Intrinsics.checkNotNullParameter(uri, "persistableContentUri");
        Single onErrorResumeNext = FileStorageHelper.DefaultImpls.readFileInfoByContentUri$default(this.a, uri, null, 2, null).onErrorResumeNext(a.a);
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "fileStorageHelper.readFi…ception(t))\n            }");
        Single flatMap = onErrorResumeNext.flatMap(new Function<Option<? extends T>, SingleSource<? extends R>>(this, j) { // from class: com.avito.android.messenger.conversation.mvi.file_attachment.FileAttachmentInteractorImpl$uploadFileByUri$$inlined$flatMapFold$1
            public final /* synthetic */ FileAttachmentInteractorImpl a;
            public final /* synthetic */ long b;

            {
                this.a = r1;
                this.b = r2;
            }

            public final SingleSource<? extends R> apply(Option<? extends T> option) {
                if (option instanceof None) {
                    Single error = Single.error(FileAttachmentException.NoSuchFileFoundException.INSTANCE);
                    Intrinsics.checkNotNullExpressionValue(error, "Single.error<FileInfo>(F…NoSuchFileFoundException)");
                    return error;
                } else if (option instanceof Some) {
                    FileInfo fileInfo = (FileInfo) ((Some) option).getT();
                    long j2 = this.b;
                    if (fileInfo.getSizeInBytes() > j2) {
                        Single error2 = Single.error(new FileAttachmentException.FileMaxSizeExceeded(fileInfo.getSizeInBytes(), j2));
                        Intrinsics.checkNotNullExpressionValue(error2, "Single.error(FileAttachm…tes, allowedFileMaxSize))");
                        return error2;
                    }
                    Single just = Single.just(fileInfo);
                    Intrinsics.checkNotNullExpressionValue(just, "Single.just(fileInfo)");
                    return just;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            @Override // io.reactivex.rxjava3.functions.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Option) ((Option) obj));
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.fold(ifEmpty, some) }");
        return a2.b.a.a.a.e2(this.b, flatMap, "readFileInfo(persistable…scribeOn(schedulers.io())");
    }
}
