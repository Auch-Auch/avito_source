package com.avito.android.messenger.conversation.mvi.file_upload;

import a2.a.a.o1.d.a0.f.m;
import a2.a.a.o1.d.a0.f.n;
import a2.a.a.o1.d.a0.f.o;
import a2.g.r.g;
import android.app.Application;
import arrow.core.Option;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.util.rx3.arrow.OptionKt;
import com.google.android.exoplayer2.util.MimeTypes;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.observer.request.GlobalRequestObserver;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0013\u0018\u0000 32\u00020\u0001:\u00013B)\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b1\u00102J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\\\u0010)\u001aH\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010 &*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u000f &*#\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010 &*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u000f\u0018\u00010%¢\u0006\u0002\b'0%¢\u0006\u0002\b'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010/¨\u00064"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadStatusUpdatesHandlerImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadStatusUpdatesHandler;", "", "subscribeToUploadUpdates", "()V", "", "filePath", "Lio/reactivex/rxjava3/core/Completable;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Completable;", "Lnet/gotev/uploadservice/data/UploadInfo;", "La2/a/a/o1/d/a0/f/m;", "status", "", "t", "Larrow/core/Option;", "La2/a/a/o1/d/a0/f/n;", AuthSource.BOOKING_ORDER, "(Lnet/gotev/uploadservice/data/UploadInfo;La2/a/a/o1/d/a0/f/m;Ljava/lang/Throwable;)Larrow/core/Option;", "com/avito/android/messenger/conversation/mvi/file_upload/UploadStatusUpdatesHandlerImpl$uploadRequestObserverDelegate$2$1", "c", "Lkotlin/Lazy;", "getUploadRequestObserverDelegate", "()Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadStatusUpdatesHandlerImpl$uploadRequestObserverDelegate$2$1;", "uploadRequestObserverDelegate", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "f", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "messageRepo", "Landroid/app/Application;", "d", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", g.a, "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "fileUploadStorageHelper", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "uploadStatusRelay", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "compositeDisposable", "<init>", "(Landroid/app/Application;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UploadStatusUpdatesHandlerImpl implements UploadStatusUpdatesHandler {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final CompositeDisposable a = new CompositeDisposable();
    public final PublishRelay<Option<n>> b = PublishRelay.create();
    public final Lazy c = t6.c.lazy(new e(this));
    public final Application d;
    public final SchedulersFactory3 e;
    public final MessageRepo f;
    public final FileStorageHelper g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadStatusUpdatesHandlerImpl$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            m.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[4] = 3;
        }
    }

    public static final class a<T> implements Consumer<Boolean> {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkNotNullExpressionValue(bool2, "isDeleted");
            sb.append(bool2.booleanValue() ? "Successfully deleted" : "Failed to delete");
            sb.append(" file ");
            sb.append(this.a);
            Logs.debug$default("UploadStatusUpdatesHandlerImpl", sb.toString(), null, 4, null);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.debug("UploadStatusUpdatesHandlerImpl", "Failed to delete cached file", th);
        }
    }

    public static final class c<T, R> implements Function<n, CompletableSource> {
        public final /* synthetic */ UploadStatusUpdatesHandlerImpl a;

        public c(UploadStatusUpdatesHandlerImpl uploadStatusUpdatesHandlerImpl) {
            this.a = uploadStatusUpdatesHandlerImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(n nVar) {
            Completable completable;
            n nVar2 = nVar;
            m mVar = nVar2.a;
            UploadUniqueInfo uploadUniqueInfo = nVar2.b;
            String str = nVar2.c;
            int ordinal = mVar.ordinal();
            if (ordinal == 0) {
                completable = UploadStatusUpdatesHandlerImpl.access$handleFileUploadedSuccessfully(this.a, uploadUniqueInfo, str);
            } else if (ordinal == 1) {
                completable = UploadStatusUpdatesHandlerImpl.access$handleFileUploadFailed(this.a, uploadUniqueInfo, str);
            } else if (ordinal != 4) {
                completable = Completable.complete();
            } else {
                completable = UploadStatusUpdatesHandlerImpl.access$handleFileUploadCancelled(this.a, str);
            }
            return completable.doOnError(o.a).onErrorComplete();
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("UploadStatusUpdatesHandlerImpl", "Fatal error. Completing upload status handling.", th);
        }
    }

    public static final class e extends Lambda implements Function0<UploadStatusUpdatesHandlerImpl$uploadRequestObserverDelegate$2$1> {
        public final /* synthetic */ UploadStatusUpdatesHandlerImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(UploadStatusUpdatesHandlerImpl uploadStatusUpdatesHandlerImpl) {
            super(0);
            this.a = uploadStatusUpdatesHandlerImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public UploadStatusUpdatesHandlerImpl$uploadRequestObserverDelegate$2$1 invoke() {
            return new UploadStatusUpdatesHandlerImpl$uploadRequestObserverDelegate$2$1(this);
        }
    }

    @Inject
    public UploadStatusUpdatesHandlerImpl(@NotNull Application application, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull MessageRepo messageRepo, @NotNull FileStorageHelper fileStorageHelper) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(messageRepo, "messageRepo");
        Intrinsics.checkNotNullParameter(fileStorageHelper, "fileUploadStorageHelper");
        this.d = application;
        this.e = schedulersFactory3;
        this.f = messageRepo;
        this.g = fileStorageHelper;
    }

    public static final Completable access$handleFileUploadCancelled(UploadStatusUpdatesHandlerImpl uploadStatusUpdatesHandlerImpl, String str) {
        return uploadStatusUpdatesHandlerImpl.a(str);
    }

    public static final Completable access$handleFileUploadFailed(UploadStatusUpdatesHandlerImpl uploadStatusUpdatesHandlerImpl, UploadUniqueInfo uploadUniqueInfo, String str) {
        Completable andThen = InteropKt.toV3(uploadStatusUpdatesHandlerImpl.f.setFileTransferFailed(uploadUniqueInfo.getUserId(), uploadUniqueInfo.getChannelId(), uploadUniqueInfo.getLocalId())).andThen(uploadStatusUpdatesHandlerImpl.a(str));
        Intrinsics.checkNotNullExpressionValue(andThen, "messageRepo.setFileTrans…nalStorage(fileToDelete))");
        return andThen;
    }

    public static final Completable access$handleFileUploadedSuccessfully(UploadStatusUpdatesHandlerImpl uploadStatusUpdatesHandlerImpl, UploadUniqueInfo uploadUniqueInfo, String str) {
        Completable andThen = InteropKt.toV3(uploadStatusUpdatesHandlerImpl.f.setFileUploadedSuccessfully(uploadUniqueInfo.getUserId(), uploadUniqueInfo.getChannelId(), uploadUniqueInfo.getLocalId())).andThen(uploadStatusUpdatesHandlerImpl.a(str));
        Intrinsics.checkNotNullExpressionValue(andThen, "messageRepo.setFileUploa…nalStorage(fileToDelete))");
        return andThen;
    }

    public static /* synthetic */ Option c(UploadStatusUpdatesHandlerImpl uploadStatusUpdatesHandlerImpl, UploadInfo uploadInfo, m mVar, Throwable th, int i) {
        int i2 = i & 2;
        return uploadStatusUpdatesHandlerImpl.b(uploadInfo, mVar, null);
    }

    public final Completable a(String str) {
        if (str != null) {
            Completable onErrorComplete = this.g.deleteFileFromInternalUploadCacheDir(str).doOnSuccess(new a(str)).doOnError(b.a).ignoreElement().onErrorComplete();
            Intrinsics.checkNotNullExpressionValue(onErrorComplete, "fileUploadStorageHelper.…       .onErrorComplete()");
            return onErrorComplete;
        }
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [a2.a.a.o1.d.a0.f.n] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final arrow.core.Option<a2.a.a.o1.d.a0.f.n> b(net.gotev.uploadservice.data.UploadInfo r3, a2.a.a.o1.d.a0.f.m r4, java.lang.Throwable r5) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Receiving a new upload status = "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = " for uploadId = "
            r0.append(r1)
            java.lang.String r1 = r3.getUploadId()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "UploadStatusUpdatesHandlerImpl"
            com.avito.android.util.Logs.debug(r1, r0, r5)
            com.avito.android.messenger.conversation.mvi.file_upload.UploadUniqueInfo$Companion r5 = com.avito.android.messenger.conversation.mvi.file_upload.UploadUniqueInfo.Companion
            java.lang.String r0 = r3.getUploadId()
            com.avito.android.messenger.conversation.mvi.file_upload.UploadUniqueInfo r5 = r5.fromString(r0)
            r0 = 0
            if (r5 == 0) goto L_0x0045
            a2.a.a.o1.d.a0.f.n r1 = new a2.a.a.o1.d.a0.f.n
            java.util.ArrayList r3 = r3.getFiles()
            java.lang.Object r3 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r3)
            net.gotev.uploadservice.data.UploadFile r3 = (net.gotev.uploadservice.data.UploadFile) r3
            if (r3 == 0) goto L_0x0041
            java.lang.String r0 = r3.getPath()
        L_0x0041:
            r1.<init>(r4, r5, r0)
            r0 = r1
        L_0x0045:
            arrow.core.Option r3 = arrow.core.OptionKt.toOption(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.file_upload.UploadStatusUpdatesHandlerImpl.b(net.gotev.uploadservice.data.UploadInfo, a2.a.a.o1.d.a0.f.m, java.lang.Throwable):arrow.core.Option");
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_upload.UploadStatusUpdatesHandler
    public void subscribeToUploadUpdates() {
        if (this.a.size() == 0) {
            Observable<Option<n>> observeOn = this.b.observeOn(this.e.io());
            Intrinsics.checkNotNullExpressionValue(observeOn, "uploadStatusRelay\n      …bserveOn(schedulers.io())");
            Disposable subscribe = OptionKt.filterDefined(observeOn).flatMapCompletable(new c(this)).doOnError(d.a).onErrorComplete().subscribe();
            Intrinsics.checkNotNullExpressionValue(subscribe, "uploadStatusRelay\n      …\n            .subscribe()");
            DisposableKt.addTo(subscribe, this.a);
            new GlobalRequestObserver(this.d, (UploadStatusUpdatesHandlerImpl$uploadRequestObserverDelegate$2$1) this.c.getValue(), null, 4, null);
        }
    }
}
