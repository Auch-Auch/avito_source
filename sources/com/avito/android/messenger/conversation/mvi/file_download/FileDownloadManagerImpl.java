package com.avito.android.messenger.conversation.mvi.file_download;

import android.content.Context;
import androidx.work.WorkInfo;
import arrow.core.Option;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.util.rx3.Singles;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b$\u0010%J9\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManagerImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManager;", "", ChannelContext.Item.USER_ID, "channelId", "", "startFromTimestamp", "Lio/reactivex/rxjava3/core/Observable;", "", "Ljava/util/UUID;", "Landroidx/work/WorkInfo;", "observeNewDownloadFails", "(Ljava/lang/String;Ljava/lang/String;J)Lio/reactivex/rxjava3/core/Observable;", "localMessageId", "enqTimestamp", "Lio/reactivex/rxjava3/core/Completable;", "enqueueDownload", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lio/reactivex/rxjava3/core/Completable;", "cancelDownload", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Completable;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "d", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "fileStorageHelper", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "c", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "messageRepo", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers3", "<init>", "(Landroid/content/Context;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FileDownloadManagerImpl implements FileDownloadManager {
    public final Context a;
    public final SchedulersFactory3 b;
    public final MessageRepo c;
    public final FileStorageHelper d;

    public static final class a<V> implements Callable<Object> {
        public final /* synthetic */ FileDownloadManagerImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(FileDownloadManagerImpl fileDownloadManagerImpl, String str, String str2, String str3) {
            this.a = fileDownloadManagerImpl;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            return FileDownloadWorker.Companion.cancelWork(this.a.a, this.b, this.c, this.d);
        }
    }

    public static final class b<T, R> implements Function<Option<? extends MessageMetaInfo>, SingleSource<? extends Object>> {
        public final /* synthetic */ FileDownloadManagerImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public b(FileDownloadManagerImpl fileDownloadManagerImpl, String str, String str2, String str3) {
            this.a = fileDownloadManagerImpl;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends Object> apply(Option<? extends MessageMetaInfo> option) {
            String internalPath;
            Single<Boolean> deleteFileFromInternalDownloadCacheDir;
            MessageMetaInfo messageMetaInfo = (MessageMetaInfo) option.orNull();
            if (messageMetaInfo != null && (internalPath = messageMetaInfo.getInternalPath()) != null && (deleteFileFromInternalDownloadCacheDir = this.a.d.deleteFileFromInternalDownloadCacheDir(internalPath)) != null) {
                return deleteFileFromInternalDownloadCacheDir;
            }
            StringBuilder L = a2.b.a.a.a.L("cancelDownload() failed: internalPath is empty - userId=");
            L.append(this.b);
            L.append(", channelId = ");
            L.append(this.c);
            L.append(", localMessageId = ");
            L.append(this.d);
            Logs.debug$default("FileDownloadManager", L.toString(), null, 4, null);
            return Singles.toSingle(Unit.INSTANCE);
        }
    }

    public static final class c<T, R> implements Function<Boolean, CompletableSource> {
        public final /* synthetic */ FileDownloadManagerImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;

        public c(FileDownloadManagerImpl fileDownloadManagerImpl, String str, String str2, String str3, long j) {
            this.a = fileDownloadManagerImpl;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = j;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "alreadyEnqueued");
            if (bool2.booleanValue()) {
                return Completable.complete();
            }
            return InteropKt.toV3(this.a.c.setFileDownloadStarted(this.b, this.c, this.d)).andThen(FileDownloadWorker.Companion.enqueueWork(this.a.a, this.b, this.c, this.d, this.e));
        }
    }

    public static final class d<T1, T2, R> implements BiFunction<Map<UUID, ? extends WorkInfo>, Map<UUID, ? extends WorkInfo>, Map<UUID, ? extends WorkInfo>> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.BiFunction
        public Map<UUID, ? extends WorkInfo> apply(Map<UUID, ? extends WorkInfo> map, Map<UUID, ? extends WorkInfo> map2) {
            Map<UUID, ? extends WorkInfo> map3 = map2;
            Intrinsics.checkNotNullExpressionValue(map3, "cur");
            return r.minus((Map) map3, (Iterable) map.keySet());
        }
    }

    public static final class e<T> implements Predicate<Map<UUID, ? extends WorkInfo>> {
        public static final e a = new e();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Map<UUID, ? extends WorkInfo> map) {
            Map<UUID, ? extends WorkInfo> map2 = map;
            Intrinsics.checkNotNullExpressionValue(map2, "it");
            return !map2.isEmpty();
        }
    }

    @Inject
    public FileDownloadManagerImpl(@NotNull Context context, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull MessageRepo messageRepo, @NotNull FileStorageHelper fileStorageHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers3");
        Intrinsics.checkNotNullParameter(messageRepo, "messageRepo");
        Intrinsics.checkNotNullParameter(fileStorageHelper, "fileStorageHelper");
        this.a = context;
        this.b = schedulersFactory3;
        this.c = messageRepo;
        this.d = fileStorageHelper;
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_download.FileDownloadManager
    @NotNull
    public Completable cancelDownload(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "localMessageId");
        Completable andThen = Completable.fromCallable(new a(this, str, str2, str3)).andThen(InteropKt.toV3(this.c.getMessageMetaInfo(str, str2, str3)).flatMap(new b(this, str, str2, str3)).ignoreElement()).andThen(InteropKt.toV3(this.c.setFileDownloadCanceled(str, str2, str3)));
        Intrinsics.checkNotNullExpressionValue(andThen, "Completable.fromCallable…   ).toV3()\n            )");
        return andThen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_download.FileDownloadManager
    @NotNull
    public Completable enqueueDownload(@NotNull String str, @NotNull String str2, @NotNull String str3, long j) {
        a2.b.a.a.a.Z0(str, ChannelContext.Item.USER_ID, str2, "channelId", str3, "localMessageId");
        Completable flatMapCompletable = FileDownloadWorker.Companion.isAlreadyEnqueued(this.a, str, str2, str3).flatMapCompletable(new c(this, str, str2, str3, j));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "FileDownloadWorker.isAlr…          }\n            }");
        return flatMapCompletable;
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_download.FileDownloadManager
    @NotNull
    public Observable<Map<UUID, WorkInfo>> observeNewDownloadFails(@NotNull String str, @NotNull String str2, long j) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Observable<Map<UUID, WorkInfo>> filter = FileDownloadWorker.Companion.observeFails(this.a, this.b.mainThread(), this.b.io(), str, str2, j).scan(d.a).filter(e.a);
        Intrinsics.checkNotNullExpressionValue(filter, "FileDownloadWorker.obser…sNotEmpty()\n            }");
        return filter;
    }
}
