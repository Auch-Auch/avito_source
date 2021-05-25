package com.avito.android.messenger.conversation.mvi.file_upload;

import a2.a.a.o1.d.a0.f.e;
import a2.a.a.o1.d.a0.f.k;
import android.net.Uri;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Logs;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.io.File;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(BD\b\u0007\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0011\u0010\u001d\u001a\r\u0012\t\u0012\u00070\u0019¢\u0006\u0002\b\u001a0\u0018\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b&\u0010'J5\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R!\u0010\u001d\u001a\r\u0012\t\u0012\u00070\u0019¢\u0006\u0002\b\u001a0\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor;", "", ChannelContext.Item.USER_ID, "channelId", "localId", "Lcom/avito/android/remote/model/messenger/message/MessageBody$File;", "messageBody", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor$FileUploadResult;", "uploadFile", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/message/MessageBody$File;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInitializer;", "e", "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInitializer;", "fileUploadInitializer", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "c", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "fileStorageHelper", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "messageRepo", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "d", "Lru/avito/messenger/MessengerClient;", "client", "Lcom/avito/android/analytics/Analytics;", "f", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadStarter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadStarter;", "fileUploadStarter", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadStarter;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInitializer;Lcom/avito/android/analytics/Analytics;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FileUploadInteractorImpl implements FileUploadInteractor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final MessengerFileUploadStarter a;
    public final MessageRepo b;
    public final FileStorageHelper c;
    public final MessengerClient<AvitoMessengerApi> d;
    public final FileUploadInitializer e;
    public final Analytics f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractorImpl$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T, R> implements Function<String, SingleSource<? extends FileUploadInteractor.FileUploadResult>> {
        public final /* synthetic */ FileUploadInteractorImpl a;
        public final /* synthetic */ UploadUniqueInfo b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ MessageBody.File f;

        public a(FileUploadInteractorImpl fileUploadInteractorImpl, UploadUniqueInfo uploadUniqueInfo, String str, String str2, String str3, MessageBody.File file) {
            this.a = fileUploadInteractorImpl;
            this.b = uploadUniqueInfo;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = file;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends FileUploadInteractor.FileUploadResult> apply(String str) {
            String str2 = str;
            StringBuilder R = a2.b.a.a.a.R("Received fileId = ", str2, " for uploadId = ");
            R.append(this.b);
            Logs.debug$default("FileUploadInteractorImpl", R.toString(), null, 4, null);
            return FileUploadInteractorImpl.access$getFileReadyForUpload(this.a, this.c, this.d, this.e).flatMap(new k(this, str2));
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ UploadUniqueInfo a;

        public b(UploadUniqueInfo uploadUniqueInfo) {
            this.a = uploadUniqueInfo;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            StringBuilder L = a2.b.a.a.a.L("Upload flow for uploadId = ");
            L.append(this.a);
            L.append(" failed with error");
            Logs.debug("FileUploadInteractorImpl", L.toString(), th);
        }
    }

    public static final class c<T, R> implements Function<Throwable, FileUploadInteractor.FileUploadResult> {
        public static final c a = new c();

        @Override // io.reactivex.rxjava3.functions.Function
        public FileUploadInteractor.FileUploadResult apply(Throwable th) {
            return new FileUploadInteractor.FileUploadResult.Failed(th);
        }
    }

    @Inject
    public FileUploadInteractorImpl(@NotNull MessengerFileUploadStarter messengerFileUploadStarter, @NotNull MessageRepo messageRepo, @NotNull FileStorageHelper fileStorageHelper, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull FileUploadInitializer fileUploadInitializer, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(messengerFileUploadStarter, "fileUploadStarter");
        Intrinsics.checkNotNullParameter(messageRepo, "messageRepo");
        Intrinsics.checkNotNullParameter(fileStorageHelper, "fileStorageHelper");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(fileUploadInitializer, "fileUploadInitializer");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = messengerFileUploadStarter;
        this.b = messageRepo;
        this.c = fileStorageHelper;
        this.d = messengerClient;
        this.e = fileUploadInitializer;
        this.f = analytics;
    }

    public static final Single access$getFileReadyForUpload(FileUploadInteractorImpl fileUploadInteractorImpl, String str, String str2, String str3) {
        Single flatMap = InteropKt.toV3(fileUploadInteractorImpl.b.getMessageMetaInfo(str, str2, str3)).flatMap(new Function<Option<? extends T>, SingleSource<? extends R>>() { // from class: com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractorImpl$getFileReadyForUpload$$inlined$flatMapFold$1
            public final SingleSource<? extends R> apply(Option<? extends T> option) {
                if (option instanceof None) {
                    Single error = Single.error(new IllegalStateException("No metainfo found for this file message"));
                    Intrinsics.checkNotNullExpressionValue(error, "Single.error(IllegalStat… for this file message\"))");
                    return error;
                } else if (option instanceof Some) {
                    String path = ((MessageMetaInfo) ((Some) option).getT()).getPath();
                    if (path != null) {
                        FileStorageHelper fileStorageHelper = FileUploadInteractorImpl.this.c;
                        Uri parse = Uri.parse(path);
                        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(contentUri)");
                        Single<File> copyToInternalUploadCacheDirAndGet = fileStorageHelper.copyToInternalUploadCacheDirAndGet(parse);
                        if (copyToInternalUploadCacheDirAndGet != null) {
                            return copyToInternalUploadCacheDirAndGet;
                        }
                    }
                    Single error2 = Single.error(new IllegalStateException("No URI found for this file message"));
                    Intrinsics.checkNotNullExpressionValue(error2, "Single.error(IllegalStat… for this file message\"))");
                    return error2;
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
        return flatMap;
    }

    public static final Observable access$observeUploadStatus(FileUploadInteractorImpl fileUploadInteractorImpl, String str, String str2, String str3) {
        Observable flatMap = InteropKt.toV3(fileUploadInteractorImpl.b.observeMessageMetaInfo(str, str2, str3)).flatMap(e.a);
        Intrinsics.checkNotNullExpressionValue(flatMap, "messageRepo.observeMessa…          )\n            }");
        return flatMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [a2.a.a.o1.d.a0.f.f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractor
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.rxjava3.core.Single<com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractor.FileUploadResult> uploadFile(@org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.NotNull java.lang.String r13, @org.jetbrains.annotations.NotNull com.avito.android.remote.model.messenger.message.MessageBody.File r14) {
        /*
            r10 = this;
            java.lang.String r0 = "userId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "channelId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "localId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "messageBody"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.avito.android.messenger.conversation.mvi.file_upload.UploadUniqueInfo r0 = new com.avito.android.messenger.conversation.mvi.file_upload.UploadUniqueInfo
            r0.<init>(r13, r11, r12)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "File uploading flow has started for uploadId = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "FileUploadInteractorImpl"
            r3 = 0
            r4 = 4
            com.avito.android.util.Logs.debug$default(r2, r1, r3, r4, r3)
            com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInitializer r1 = r10.e
            io.reactivex.rxjava3.core.Completable r1 = r1.initIfNeeded()
            com.avito.android.messenger.conversation.mvi.data.MessageRepo r2 = r10.b
            r6 = 0
            r8 = 8
            r9 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            io.reactivex.Completable r2 = com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter.DefaultImpls.setFileUploadInProgress$default(r2, r3, r4, r5, r6, r8, r9)
            io.reactivex.rxjava3.core.Completable r2 = com.avito.android.util.rx3.InteropKt.toV3(r2)
            io.reactivex.rxjava3.core.Completable r1 = r1.andThen(r2)
            ru.avito.messenger.MessengerClient<ru.avito.messenger.api.AvitoMessengerApi> r2 = r10.d
            io.reactivex.Single r2 = r2.withMessengerApi()
            a2.a.a.o1.d.a0.f.c r3 = new a2.a.a.o1.d.a0.f.c
            r3.<init>(r12)
            io.reactivex.Single r2 = r2.flatMap(r3)
            java.lang.String r3 = "client.withMessengerApi(…          )\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            io.reactivex.rxjava3.core.Single r2 = com.avito.android.util.rx3.InteropKt.toV3(r2)
            kotlin.reflect.KProperty1 r3 = a2.a.a.o1.d.a0.f.d.a
            if (r3 == 0) goto L_0x006f
            a2.a.a.o1.d.a0.f.f r4 = new a2.a.a.o1.d.a0.f.f
            r4.<init>(r3)
            r3 = r4
        L_0x006f:
            io.reactivex.rxjava3.functions.Function r3 = (io.reactivex.rxjava3.functions.Function) r3
            io.reactivex.rxjava3.core.Single r2 = r2.map(r3)
            java.lang.String r3 = "client.withMessengerApi(…eateFileResponse::fileId)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            io.reactivex.rxjava3.core.Single r8 = r1.andThen(r2)
            com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractorImpl$a r9 = new com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractorImpl$a
            r1 = r9
            r2 = r10
            r3 = r0
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7)
            io.reactivex.rxjava3.core.Single r11 = r8.flatMap(r9)
            com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractorImpl$b r12 = new com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractorImpl$b
            r12.<init>(r0)
            io.reactivex.rxjava3.core.Single r11 = r11.doOnError(r12)
            com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractorImpl$c r12 = com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractorImpl.c.a
            io.reactivex.rxjava3.core.Single r11 = r11.onErrorReturn(r12)
            java.lang.String r12 = "fileUploadInitializer.in…eUploadResult.Failed(t) }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractorImpl.uploadFile(java.lang.String, java.lang.String, java.lang.String, com.avito.android.remote.model.messenger.message.MessageBody$File):io.reactivex.rxjava3.core.Single");
    }
}
