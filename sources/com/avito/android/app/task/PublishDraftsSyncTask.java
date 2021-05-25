package com.avito.android.app.task;

import a2.a.a.j.a.j0;
import a2.a.a.j.a.k0;
import a2.a.a.j.a.l0;
import a2.a.a.j.a.m0;
import a2.a.a.j.a.n0;
import a2.a.a.j.a.o0;
import a2.a.a.j.a.p0;
import a2.a.a.j.a.q0;
import a2.a.a.j.a.s0;
import a2.a.a.j.a.t0;
import android.app.Application;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractor;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx.RetryWhenKt;
import com.google.android.exoplayer2.util.MimeTypes;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0017B3\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/app/task/PublishDraftsSyncTask;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "execute", "(Landroid/app/Application;)V", "Lkotlin/Function1;", "", "Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;", "uploadingProgressProvider", "Lkotlin/jvm/functions/Function1;", "Lcom/avito/android/publish/drafts/PublishDraftRepository;", "draftRepository", "Lcom/avito/android/publish/drafts/PublishDraftRepository;", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "<init>", "(Lcom/avito/android/publish/drafts/PublishDraftRepository;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;Lkotlin/jvm/functions/Function1;)V", AuthSource.SEND_ABUSE, "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class PublishDraftsSyncTask implements ApplicationBackgroundStartupTask {
    public final ConnectivityProvider connectivityProvider;
    public final PublishDraftRepository draftRepository;
    public final SchedulersFactory schedulers;
    public final Function1<String, UploadingProgressInteractor> uploadingProgressProvider;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PublishDraftRepository.DraftSyncResult.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public static final class a extends Exception {
    }

    public static final class b<T, R> implements Function<Unit, CompletableSource> {
        public final /* synthetic */ PublishDraftsSyncTask a;

        public b(PublishDraftsSyncTask publishDraftsSyncTask) {
            this.a = publishDraftsSyncTask;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return Single.defer(new j0(this)).map(k0.a).retryWhen(RetryWhenKt.delayedRetry(200, 1, this.a.schedulers.computation(), m0.a, l0.a)).ignoreElement().doOnComplete(n0.a).doOnError(o0.a).onErrorComplete();
        }
    }

    public static final class c implements Action {
        public static final c a = new c();

        @Override // io.reactivex.functions.Action
        public final void run() {
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("PublishDraftsSyncTask", th);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, ? extends com.avito.android.photo_picker.legacy.UploadingProgressInteractor> */
    /* JADX WARN: Multi-variable type inference failed */
    public PublishDraftsSyncTask(@NotNull PublishDraftRepository publishDraftRepository, @NotNull SchedulersFactory schedulersFactory, @NotNull ConnectivityProvider connectivityProvider2, @NotNull Function1<? super String, ? extends UploadingProgressInteractor> function1) {
        Intrinsics.checkNotNullParameter(publishDraftRepository, "draftRepository");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(connectivityProvider2, "connectivityProvider");
        Intrinsics.checkNotNullParameter(function1, "uploadingProgressProvider");
        this.draftRepository = publishDraftRepository;
        this.schedulers = schedulersFactory;
        this.connectivityProvider = connectivityProvider2;
        this.uploadingProgressProvider = function1;
    }

    @Override // com.avito.android.app.task.ApplicationBackgroundStartupTask
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        this.connectivityProvider.getConnectionAvailability().startWith((Observable<Boolean>) Boolean.valueOf(this.connectivityProvider.isConnectionAvailable())).distinctUntilChanged().filter(p0.a).map(q0.a).mergeWith(this.draftRepository.observeDraftsById().switchMap(new s0(this)).distinctUntilChanged().map(t0.a)).debounce(500, TimeUnit.MILLISECONDS, this.schedulers.computation()).flatMapCompletable(new b(this)).subscribe(c.a, d.a);
    }
}
