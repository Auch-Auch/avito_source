package com.avito.android.messenger.conversation.mvi.file_download;

import a2.a.a.o1.d.a0.e.f;
import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.messenger.conversation.mvi.file_download.FileDownloadException;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BT\b\u0007\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0011\u0010\u001e\u001a\r\u0012\t\u0012\u00070\u001a¢\u0006\u0002\b\u001b0\u0019\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b+\u0010,J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R!\u0010\u001e\u001a\r\u0012\t\u0012\u00070\u001a¢\u0006\u0002\b\u001b0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadWorkerDelegateImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadWorkerDelegate;", "", ChannelContext.Item.USER_ID, "channelId", "localMessageId", "Lio/reactivex/rxjava3/core/Completable;", "download", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Completable;", "Lcom/avito/android/util/SchedulersFactory3;", "h", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "f", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "fileStorageHelper", "Lcom/avito/android/analytics/Analytics;", g.a, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "d", "Lru/avito/messenger/MessengerClient;", "client", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "c", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "messageRepo", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadRequestCallProvider;", "e", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadRequestCallProvider;", "fileDownloadRequestCallProvider", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/Features;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadRequestCallProvider;Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory3;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FileDownloadWorkerDelegateImpl implements FileDownloadWorkerDelegate {
    public final AccountStateProvider a;
    public final Features b;
    public final MessageRepo c;
    public final MessengerClient<AvitoMessengerApi> d;
    public final FileDownloadRequestCallProvider e;
    public final FileStorageHelper f;
    public final Analytics g;
    public final SchedulersFactory3 h;

    public static final class a<T, R> implements Function<String, CompletableSource> {
        public final /* synthetic */ FileDownloadWorkerDelegateImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(FileDownloadWorkerDelegateImpl fileDownloadWorkerDelegateImpl, String str, String str2, String str3) {
            this.a = fileDownloadWorkerDelegateImpl;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(String str) {
            String str2 = str;
            if (!Intrinsics.areEqual(str2, this.b)) {
                Intrinsics.checkNotNullExpressionValue(str2, "currentUserId");
                return Completable.error(new FileDownloadException.Unauthorized(str2, this.b));
            }
            Completable flatMapCompletable = InteropKt.toV3(this.a.c.getMessageAndMetaInfo(this.b, this.c, this.d)).flatMapCompletable(new FileDownloadWorkerDelegateImpl$download$1$$special$$inlined$flatMapCompletableFold$2(this));
            Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "flatMapCompletable { it.fold(ifEmpty, some) }");
            return flatMapCompletable;
        }
    }

    public static final class b<T, R> implements Function<Throwable, CompletableSource> {
        public final /* synthetic */ FileDownloadWorkerDelegateImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public b(FileDownloadWorkerDelegateImpl fileDownloadWorkerDelegateImpl, String str, String str2, String str3) {
            this.a = fileDownloadWorkerDelegateImpl;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(Throwable th) {
            FileDownloadException fileDownloadException;
            Throwable th2 = th;
            Completable v3 = InteropKt.toV3(this.a.c.setFileTransferFailed(this.b, this.c, this.d));
            if (th2 instanceof FileDownloadException) {
                fileDownloadException = (FileDownloadException) th2;
            } else {
                fileDownloadException = new FileDownloadException.Unknown(th2);
            }
            return v3.andThen(Completable.error(fileDownloadException));
        }
    }

    @Inject
    public FileDownloadWorkerDelegateImpl(@NotNull AccountStateProvider accountStateProvider, @NotNull Features features, @NotNull MessageRepo messageRepo, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull FileDownloadRequestCallProvider fileDownloadRequestCallProvider, @NotNull FileStorageHelper fileStorageHelper, @NotNull Analytics analytics, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(messageRepo, "messageRepo");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(fileDownloadRequestCallProvider, "fileDownloadRequestCallProvider");
        Intrinsics.checkNotNullParameter(fileStorageHelper, "fileStorageHelper");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = accountStateProvider;
        this.b = features;
        this.c = messageRepo;
        this.d = messengerClient;
        this.e = fileDownloadRequestCallProvider;
        this.f = fileStorageHelper;
        this.g = analytics;
        this.h = schedulersFactory3;
    }

    public static final Single access$downloadFileAndCopyToExternalStorage(FileDownloadWorkerDelegateImpl fileDownloadWorkerDelegateImpl, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Single<R> flatMap = fileDownloadWorkerDelegateImpl.e.getDownloadRequestCall(str4, str5).flatMap(new f(fileDownloadWorkerDelegateImpl, str, str2, str3, str4, str6, str7));
        Intrinsics.checkNotNullExpressionValue(flatMap, "fileDownloadRequestCallP…          }\n            }");
        return flatMap;
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerDelegate
    @NotNull
    public Completable download(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Completable completable;
        a2.b.a.a.a.Z0(str, ChannelContext.Item.USER_ID, str2, "channelId", str3, "localMessageId");
        if (!this.b.getMessengerDynamicAttachMenu().invoke().booleanValue()) {
            completable = Completable.error(new FileDownloadException.FeatureIsDisabled());
        } else {
            completable = this.a.userId().firstOrError().flatMapCompletable(new a(this, str, str2, str3));
        }
        Completable onErrorResumeNext = completable.onErrorResumeNext(new b(this, str, str2, str3));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "if (!features.messengerD…          )\n            }");
        return onErrorResumeNext;
    }
}
