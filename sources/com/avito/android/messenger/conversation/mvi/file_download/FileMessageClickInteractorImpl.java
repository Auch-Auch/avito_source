package com.avito.android.messenger.conversation.mvi.file_download;

import android.net.Uri;
import android.os.Build;
import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.messenger.channels.mvi.common.v4.ActionSingle;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueueWithTransformByKey;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileInfo;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.messenger.conversation.mvi.file_download.FileMessageClickInteractor;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.MessageEraser;
import com.avito.android.messenger.di.ChannelId;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.rx3.InteropKt;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import ru.avito.android.persistence.messenger.TransferStatus;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00059:;<=BM\u0012\u0006\u0010)\u001a\u00020\"\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u00103\u001a\u000202\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000304¢\u0006\u0004\b6\u00107BC\b\u0017\u0012\b\b\u0001\u0010)\u001a\u00020\"\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u00103\u001a\u000202¢\u0006\u0004\b6\u00108J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR4\u0010\u0018\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0012j\u0002`\u00130\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR4\u0010&\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\"0\u0012j\u0002`#0\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u0017R\u0016\u0010)\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u0006>"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractor$State;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "message", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "metaInfo", "", "onBubbleClick", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;Lru/avito/android/persistence/messenger/MessageMetaInfo;)V", "onCancelClick", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;)V", "Lcom/avito/android/permissions/PermissionChecker;", "w", "Lcom/avito/android/permissions/PermissionChecker;", "permissionChecker", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lkotlin/Pair;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", VKApiConst.Q, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getRequestPermissionsForFileMessageStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "requestPermissionsForFileMessageStream", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManager;", "u", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManager;", "fileDownloadManager", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/MessageEraser;", VKApiConst.VERSION, "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/MessageEraser;", "messageEraser", "Landroid/net/Uri;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/UriAndMimeType;", "p", "getFileMessageClickedStream", "fileMessageClickedStream", "r", "Ljava/lang/String;", "channelId", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "t", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "fileStorageHelper", "Lcom/avito/android/server_time/TimeSource;", "s", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "reducerQueue", "<init>", "(Ljava/lang/String;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManager;Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/MessageEraser;Lcom/avito/android/permissions/PermissionChecker;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;)V", "(Ljava/lang/String;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManager;Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/MessageEraser;Lcom/avito/android/permissions/PermissionChecker;Lcom/avito/android/util/SchedulersFactory;)V", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "OnBubbleClickAction", "OnCancelClickAction", "c", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FileMessageClickInteractorImpl extends BaseMviEntityWithReducerQueue<FileMessageClickInteractor.State> implements FileMessageClickInteractor {
    @NotNull
    public final SingleLiveEvent<Pair<Uri, String>> p;
    @NotNull
    public final SingleLiveEvent<Pair<LocalMessage, MessageMetaInfo>> q;
    public final String r;
    public final TimeSource s;
    public final FileStorageHelper t;
    public final FileDownloadManager u;
    public final MessageEraser v;
    public final PermissionChecker w;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractorImpl$OnBubbleClickAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/ActionSingle;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractor$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractor$State;)Lio/reactivex/Single;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "d", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "getMessage", "()Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "message", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "e", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "getMetaInfo", "()Lru/avito/android/persistence/messenger/MessageMetaInfo;", "metaInfo", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractorImpl;Lcom/avito/android/remote/model/messenger/message/LocalMessage;Lru/avito/android/persistence/messenger/MessageMetaInfo;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class OnBubbleClickAction extends ActionSingle<FileMessageClickInteractor.State> {
        @NotNull
        public final LocalMessage d;
        @Nullable
        public final MessageMetaInfo e;
        public final /* synthetic */ FileMessageClickInteractorImpl f;

        public static final class a<T, R> implements Function<Throwable, Option<? extends FileInfo>> {
            public final /* synthetic */ OnBubbleClickAction a;

            public a(OnBubbleClickAction onBubbleClickAction, MessageBody.File file) {
                this.a = onBubbleClickAction;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.functions.Function
            public Option<? extends FileInfo> apply(Throwable th) {
                Logs.error(this.a.f.getTAG(), "fileStorageHelper.readFileInfoByContentUri() failed!", th);
                return OptionKt.none();
            }
        }

        public static final class b<T> implements Consumer<Throwable> {
            public final /* synthetic */ OnBubbleClickAction a;

            public b(OnBubbleClickAction onBubbleClickAction) {
                this.a = onBubbleClickAction;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Logs.error(this.a.f.getTAG(), "fileDownloadManager.enqueueDownload() failed!", th);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnBubbleClickAction(@NotNull FileMessageClickInteractorImpl fileMessageClickInteractorImpl, @Nullable LocalMessage localMessage, MessageMetaInfo messageMetaInfo) {
            super(null, "message = " + localMessage + ", metaInfo = " + messageMetaInfo, 1, null);
            Intrinsics.checkNotNullParameter(localMessage, "message");
            this.f = fileMessageClickInteractorImpl;
            this.d = localMessage;
            this.e = messageMetaInfo;
        }

        @NotNull
        public final LocalMessage getMessage() {
            return this.d;
        }

        @Nullable
        public final MessageMetaInfo getMetaInfo() {
            return this.e;
        }

        @NotNull
        public Single<?> invoke(@NotNull FileMessageClickInteractor.State state) {
            String path;
            Intrinsics.checkNotNullParameter(state, "curState");
            MessageBody messageBody = this.d.body;
            Objects.requireNonNull(messageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.File");
            MessageBody.File file = (MessageBody.File) messageBody;
            MessageMetaInfo messageMetaInfo = this.e;
            TransferStatus transferStatus = null;
            Uri parse = (messageMetaInfo == null || (path = messageMetaInfo.getPath()) == null) ? null : Uri.parse(path);
            String str = this.d.remoteId;
            boolean z = true;
            if (!(str == null || m.isBlank(str))) {
                MessageMetaInfo messageMetaInfo2 = this.e;
                if ((messageMetaInfo2 != null ? messageMetaInfo2.getTransferStatus() : null) != TransferStatus.IN_PROGRESS) {
                    FileInfo orNull = parse != null ? this.f.t.readFileInfoByContentUri(parse, file.getMimeType()).onErrorReturn(new a(this, file)).blockingGet().orNull() : null;
                    if (parse != null) {
                        MessageMetaInfo messageMetaInfo3 = this.e;
                        if (messageMetaInfo3 != null) {
                            transferStatus = messageMetaInfo3.getTransferStatus();
                        }
                        if (transferStatus == TransferStatus.SUCCESS && orNull != null) {
                            this.f.getFileMessageClickedStream().postValue(TuplesKt.to(parse, orNull.getMimeType()));
                            return Singles.toSingle(Unit.INSTANCE);
                        }
                    }
                    if (Build.VERSION.SDK_INT < 29) {
                        z = this.f.w.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE");
                    }
                    if (z) {
                        FileDownloadManager fileDownloadManager = this.f.u;
                        LocalMessage localMessage = this.d;
                        Single<?> singleDefault = InteropKt.toV2(fileDownloadManager.enqueueDownload(localMessage.userId, localMessage.channelId, localMessage.localId, this.f.s.now())).doOnError(new b(this)).onErrorComplete().toSingleDefault(Unit.INSTANCE);
                        Intrinsics.checkNotNullExpressionValue(singleDefault, "fileDownloadManager.enqu…   .toSingleDefault(Unit)");
                        return singleDefault;
                    }
                    this.f.getRequestPermissionsForFileMessageStream().postValue(TuplesKt.to(this.d, this.e));
                    return Singles.toSingle(Unit.INSTANCE);
                }
            }
            return Singles.toSingle(Unit.INSTANCE);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractorImpl$OnCancelClickAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/ActionSingle;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractor$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractor$State;)Lio/reactivex/Single;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "d", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "getMessage", "()Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "message", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractorImpl;Lcom/avito/android/remote/model/messenger/message/LocalMessage;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class OnCancelClickAction extends ActionSingle<FileMessageClickInteractor.State> {
        @NotNull
        public final LocalMessage d;
        public final /* synthetic */ FileMessageClickInteractorImpl e;

        /* compiled from: java-style lambda group */
        public static final class a<T> implements Consumer<Throwable> {
            public final /* synthetic */ int a;
            public final /* synthetic */ Object b;

            public a(int i, Object obj) {
                this.a = i;
                this.b = obj;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public final void accept(Throwable th) {
                int i = this.a;
                if (i == 0) {
                    String tag = ((OnCancelClickAction) this.b).e.getTAG();
                    Logs.error(tag, "FileMessageCancelClicked: messageEraser.deleteLocalMessage() failed - userId = " + ((OnCancelClickAction) this.b).getMessage().userId + ", channelId = " + ((OnCancelClickAction) this.b).e.r + ", localId = " + ((OnCancelClickAction) this.b).getMessage().localId, th);
                } else if (i == 1) {
                    String tag2 = ((OnCancelClickAction) this.b).e.getTAG();
                    Logs.error(tag2, "FileMessageCancelClicked: fileDownloadManager.cancelDownload() failed - userId = " + ((OnCancelClickAction) this.b).getMessage().userId + ", channelId = " + ((OnCancelClickAction) this.b).e.r + ", localId = " + ((OnCancelClickAction) this.b).getMessage().localId, th);
                } else {
                    throw null;
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnCancelClickAction(@NotNull FileMessageClickInteractorImpl fileMessageClickInteractorImpl, LocalMessage localMessage) {
            super(null, "message = " + localMessage, 1, null);
            Intrinsics.checkNotNullParameter(localMessage, "message");
            this.e = fileMessageClickInteractorImpl;
            this.d = localMessage;
        }

        @NotNull
        public final LocalMessage getMessage() {
            return this.d;
        }

        @NotNull
        public Single<?> invoke(@NotNull FileMessageClickInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            String str = this.d.remoteId;
            if (str == null || m.isBlank(str)) {
                Single<Boolean> onErrorReturnItem = this.e.v.deleteLocalMessage(this.d.userId, this.e.r, this.d.localId).doOnError(new a(0, this)).onErrorReturnItem(Boolean.FALSE);
                Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "messageEraser.deleteLoca….onErrorReturnItem(false)");
                return onErrorReturnItem;
            }
            Single<?> singleDefault = InteropKt.toV2(this.e.u.cancelDownload(this.d.userId, this.e.r, this.d.localId)).doOnError(new a(1, this)).onErrorComplete().toSingleDefault(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(singleDefault, "fileDownloadManager.canc…   .toSingleDefault(Unit)");
            return singleDefault;
        }
    }

    public static final class a implements ShouldCancelChecker<FileMessageClickInteractor.State> {
        @NotNull
        public static final a a = new a();

        @Override // com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker
        public boolean aShouldCancelB(@NotNull Reducible<FileMessageClickInteractor.State> reducible, @NotNull Reducible<FileMessageClickInteractor.State> reducible2) {
            Intrinsics.checkNotNullParameter(reducible, AuthSource.SEND_ABUSE);
            Intrinsics.checkNotNullParameter(reducible2, AuthSource.BOOKING_ORDER);
            b bVar = b.a;
            return Intrinsics.areEqual(bVar.getKey(reducible), bVar.getKey(reducible2));
        }
    }

    public static final class b implements ReducerQueueWithTransformByKey.KeySelector<FileMessageClickInteractor.State, String> {
        @NotNull
        public static final b a = new b();

        @Nullable
        /* renamed from: a */
        public String getKey(@NotNull Reducible<FileMessageClickInteractor.State> reducible) {
            Intrinsics.checkNotNullParameter(reducible, "reducible");
            if (reducible instanceof OnBubbleClickAction) {
                return a2.b.a.a.a.s(a2.b.a.a.a.L("OnBubbleClickAction(localMessageId = "), ((OnBubbleClickAction) reducible).getMessage().localId, ')');
            }
            if (reducible instanceof OnCancelClickAction) {
                return a2.b.a.a.a.s(a2.b.a.a.a.L("OnCancelClickAction(localMessageId = "), ((OnCancelClickAction) reducible).getMessage().localId, ')');
            }
            return null;
        }
    }

    public static final class c implements ReducerQueueWithTransformByKey.Transformer<FileMessageClickInteractor.State, String> {
        public final Scheduler a;

        public c(@NotNull Scheduler scheduler) {
            Intrinsics.checkNotNullParameter(scheduler, "schedulerForThrottling");
            this.a = scheduler;
        }

        /* Return type fixed from 'io.reactivex.Observable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, io.reactivex.Observable] */
        @Override // com.avito.android.messenger.channels.mvi.common.v4.ReducerQueueWithTransformByKey.Transformer
        public Observable<Reducible<FileMessageClickInteractor.State>> transform(String str, Observable<Reducible<FileMessageClickInteractor.State>> observable) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(observable, "obs");
            if (str2 == null) {
                return observable;
            }
            Observable<Reducible<FileMessageClickInteractor.State>> throttleLatest = observable.throttleLatest(1500, TimeUnit.MILLISECONDS, this.a, true);
            Intrinsics.checkNotNullExpressionValue(throttleLatest, "obs.throttleLatest(\n    …rue\n                    )");
            return throttleLatest;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileMessageClickInteractorImpl(@NotNull String str, @NotNull TimeSource timeSource, @NotNull FileStorageHelper fileStorageHelper, @NotNull FileDownloadManager fileDownloadManager, @NotNull MessageEraser messageEraser, @NotNull PermissionChecker permissionChecker, @NotNull SchedulersFactory schedulersFactory, @NotNull ReducerQueue<FileMessageClickInteractor.State> reducerQueue) {
        super("FileMessageClickInteractor", FileMessageClickInteractor.State.INSTANCE, schedulersFactory, a.a, reducerQueue, null, null, null, 224, null);
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(fileStorageHelper, "fileStorageHelper");
        Intrinsics.checkNotNullParameter(fileDownloadManager, "fileDownloadManager");
        Intrinsics.checkNotNullParameter(messageEraser, "messageEraser");
        Intrinsics.checkNotNullParameter(permissionChecker, "permissionChecker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(reducerQueue, "reducerQueue");
        this.r = str;
        this.s = timeSource;
        this.t = fileStorageHelper;
        this.u = fileDownloadManager;
        this.v = messageEraser;
        this.w = permissionChecker;
        this.p = new SingleLiveEvent<>();
        this.q = new SingleLiveEvent<>();
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_download.FileMessageClickInteractor
    public void onBubbleClick(@NotNull LocalMessage localMessage, @Nullable MessageMetaInfo messageMetaInfo) {
        Intrinsics.checkNotNullParameter(localMessage, "message");
        getReducerQueue().plusAssign(new OnBubbleClickAction(this, localMessage, messageMetaInfo));
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_download.FileMessageClickInteractor
    public void onCancelClick(@NotNull LocalMessage localMessage) {
        Intrinsics.checkNotNullParameter(localMessage, "message");
        getReducerQueue().plusAssign(new OnCancelClickAction(this, localMessage));
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_download.FileMessageClickInteractor
    @NotNull
    public SingleLiveEvent<Pair<Uri, String>> getFileMessageClickedStream() {
        return this.p;
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_download.FileMessageClickInteractor
    @NotNull
    public SingleLiveEvent<Pair<LocalMessage, MessageMetaInfo>> getRequestPermissionsForFileMessageStream() {
        return this.q;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public FileMessageClickInteractorImpl(@ChannelId @NotNull String str, @NotNull TimeSource timeSource, @NotNull FileStorageHelper fileStorageHelper, @NotNull FileDownloadManager fileDownloadManager, @NotNull MessageEraser messageEraser, @NotNull PermissionChecker permissionChecker, @NotNull SchedulersFactory schedulersFactory) {
        this(str, timeSource, fileStorageHelper, fileDownloadManager, messageEraser, permissionChecker, schedulersFactory, new ReducerQueueWithTransformByKey(schedulersFactory.io(), b.a, new c(schedulersFactory.io())));
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(fileStorageHelper, "fileStorageHelper");
        Intrinsics.checkNotNullParameter(fileDownloadManager, "fileDownloadManager");
        Intrinsics.checkNotNullParameter(messageEraser, "messageEraser");
        Intrinsics.checkNotNullParameter(permissionChecker, "permissionChecker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
    }
}
