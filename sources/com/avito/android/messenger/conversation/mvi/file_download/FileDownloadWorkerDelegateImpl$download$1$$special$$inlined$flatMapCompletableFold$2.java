package com.avito.android.messenger.conversation.mvi.file_download;

import android.net.Uri;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.messenger.analytics.FileDownloadedEvent;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.file_download.FileDownloadException;
import com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerDelegateImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import ru.avito.android.persistence.messenger.TransferStatus;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.GetFileResponse;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "Larrow/core/Option;", "kotlin.jvm.PlatformType", "it", "Lio/reactivex/rxjava3/core/CompletableSource;", "apply", "(Larrow/core/Option;)Lio/reactivex/rxjava3/core/CompletableSource;", "com/avito/android/util/rx3/Singles$flatMapCompletableFold$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class FileDownloadWorkerDelegateImpl$download$1$$special$$inlined$flatMapCompletableFold$2<T, R> implements Function<Option<? extends T>, CompletableSource> {
    public final /* synthetic */ FileDownloadWorkerDelegateImpl.a a;

    public static final class a<T, R> implements io.reactivex.functions.Function<AvitoMessengerApi, SingleSource<? extends GetFileResponse>> {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends GetFileResponse> apply(AvitoMessengerApi avitoMessengerApi) {
            AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
            Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
            return avitoMessengerApi2.getFile(this.a);
        }
    }

    public static final class b<T, R> implements Function<GetFileResponse, io.reactivex.rxjava3.core.SingleSource<? extends Option<? extends Uri>>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FileDownloadWorkerDelegateImpl$download$1$$special$$inlined$flatMapCompletableFold$2 c;

        public b(String str, String str2, FileDownloadWorkerDelegateImpl$download$1$$special$$inlined$flatMapCompletableFold$2 fileDownloadWorkerDelegateImpl$download$1$$special$$inlined$flatMapCompletableFold$2) {
            this.a = str;
            this.b = str2;
            this.c = fileDownloadWorkerDelegateImpl$download$1$$special$$inlined$flatMapCompletableFold$2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public io.reactivex.rxjava3.core.SingleSource<? extends Option<? extends Uri>> apply(GetFileResponse getFileResponse) {
            GetFileResponse getFileResponse2 = getFileResponse;
            String component1 = getFileResponse2.component1();
            String component2 = getFileResponse2.component2();
            String concretizeMimeType = this.c.a.a.f.concretizeMimeType(this.a, this.b);
            FileDownloadWorkerDelegateImpl.a aVar = this.c.a;
            return FileDownloadWorkerDelegateImpl.access$downloadFileAndCopyToExternalStorage(aVar.a, aVar.b, aVar.c, aVar.d, component1, component2, this.a, concretizeMimeType);
        }
    }

    public FileDownloadWorkerDelegateImpl$download$1$$special$$inlined$flatMapCompletableFold$2(FileDownloadWorkerDelegateImpl.a aVar) {
        this.a = aVar;
    }

    public final CompletableSource apply(Option<? extends T> option) {
        if (option instanceof None) {
            Completable error = Completable.error(new FileDownloadException.MessageNotFoundInDb());
            Intrinsics.checkNotNullExpressionValue(error, "Completable.error(\n     …                        )");
            return error;
        } else if (option instanceof Some) {
            Pair pair = (Pair) ((Some) option).getT();
            LocalMessage localMessage = (LocalMessage) pair.component1();
            MessageMetaInfo messageMetaInfo = (MessageMetaInfo) pair.component2();
            MessageBody messageBody = localMessage.body;
            TransferStatus transferStatus = null;
            if (!(messageBody instanceof MessageBody.File)) {
                messageBody = null;
            }
            MessageBody.File file = (MessageBody.File) messageBody;
            String fileId = file != null ? file.getFileId() : null;
            String name = file != null ? file.getName() : null;
            String mimeType = file != null ? file.getMimeType() : null;
            boolean z = false;
            if (!(fileId == null || m.isBlank(fileId))) {
                if (!(name == null || m.isBlank(name))) {
                    if (mimeType == null || m.isBlank(mimeType)) {
                        z = true;
                    }
                    if (!z) {
                        if (messageMetaInfo != null) {
                            transferStatus = messageMetaInfo.getTransferStatus();
                        }
                        if (transferStatus == TransferStatus.IN_PROGRESS) {
                            Single<R> flatMap = this.a.a.d.withMessengerApi().flatMap(new a(fileId));
                            Intrinsics.checkNotNullExpressionValue(flatMap, "client.withMessengerApi(…                        }");
                            io.reactivex.rxjava3.core.Single<R> flatMap2 = InteropKt.toV3(flatMap).flatMap(new b(name, mimeType, this));
                            Intrinsics.checkNotNullExpressionValue(flatMap2, "client.withMessengerApi(…                        }");
                            Completable flatMapCompletable = flatMap2.flatMapCompletable(new Function<Option<? extends T>, CompletableSource>(fileId, this) { // from class: com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerDelegateImpl$download$1$$special$$inlined$flatMapCompletableFold$2$lambda$3
                                public final /* synthetic */ String a;
                                public final /* synthetic */ FileDownloadWorkerDelegateImpl$download$1$$special$$inlined$flatMapCompletableFold$2 b;

                                {
                                    this.a = r1;
                                    this.b = r2;
                                }

                                public final CompletableSource apply(Option<? extends T> option2) {
                                    if (option2 instanceof None) {
                                        Completable error2 = Completable.error(new FileDownloadException.CacheAndCopyFailed());
                                        Intrinsics.checkNotNullExpressionValue(error2, "Completable.error(FileDo…ion.CacheAndCopyFailed())");
                                        return error2;
                                    } else if (option2 instanceof Some) {
                                        this.b.a.a.g.track(new FileDownloadedEvent(this.b.a.c, this.a));
                                        MessageRepo messageRepo = this.b.a.a.c;
                                        FileDownloadWorkerDelegateImpl.a aVar = this.b.a;
                                        String str = aVar.b;
                                        String str2 = aVar.c;
                                        String str3 = aVar.d;
                                        String uri = ((Uri) ((Some) option2).getT()).toString();
                                        Intrinsics.checkNotNullExpressionValue(uri, "copiedFileUri.toString()");
                                        return InteropKt.toV3(messageRepo.setFileDownloadedSuccessfully(str, str2, str3, uri));
                                    } else {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // io.reactivex.rxjava3.functions.Function
                                public /* bridge */ /* synthetic */ CompletableSource apply(Object obj) {
                                    return apply((Option) ((Option) obj));
                                }
                            });
                            Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "flatMapCompletable { it.fold(ifEmpty, some) }");
                            return flatMapCompletable;
                        }
                    }
                }
            }
            Completable error2 = Completable.error(new FileDownloadException.IllegalMessageState(localMessage, messageMetaInfo));
            Intrinsics.checkNotNullExpressionValue(error2, "Completable.error(\n     …                        )");
            return error2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.reactivex.rxjava3.functions.Function
    public /* bridge */ /* synthetic */ CompletableSource apply(Object obj) {
        return apply((Option) ((Option) obj));
    }
}
