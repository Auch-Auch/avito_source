package com.avito.android.app.task;

import android.app.Application;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.google.android.exoplayer2.util.MimeTypes;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/app/task/PublishDraftsCleanupTask;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "execute", "(Landroid/app/Application;)V", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "publishDraftWiper", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/util/BuildInfo;", "build", "Lcom/avito/android/util/BuildInfo;", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/account/AccountStateProvider;", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/publish/drafts/PublishDraftWiper;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/BuildInfo;)V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class PublishDraftsCleanupTask implements ApplicationBackgroundStartupTask {
    public final AccountStateProvider accountStateProvider;
    public final BuildInfo build;
    public final PublishDraftWiper publishDraftWiper;
    public final SchedulersFactory schedulers;

    public static final class a<T> implements Predicate<Boolean> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "it");
            return !bool2.booleanValue();
        }
    }

    public static final class b<T, R> implements Function<Boolean, Unit> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class c<T, R> implements Function<Unit, CompletableSource> {
        public final /* synthetic */ PublishDraftsCleanupTask a;

        public c(PublishDraftsCleanupTask publishDraftsCleanupTask) {
            this.a = publishDraftsCleanupTask;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return this.a.publishDraftWiper.deleteDraftWithPhotos();
        }
    }

    public static final class d implements Action {
        public static final d a = new d();

        @Override // io.reactivex.functions.Action
        public final void run() {
            Logs.debug$default("PublishDrafts", "Publish drafts deleted on logout", null, 4, null);
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ PublishDraftsCleanupTask a;

        public e(PublishDraftsCleanupTask publishDraftsCleanupTask) {
            this.a = publishDraftsCleanupTask;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Logs.error("PublishDrafts", "Failed to deleted drafts on ", th2);
            if (this.a.build.isDebug()) {
                Intrinsics.checkNotNullExpressionValue(th2, "it");
                throw th2;
            }
        }
    }

    public PublishDraftsCleanupTask(@NotNull AccountStateProvider accountStateProvider2, @NotNull PublishDraftWiper publishDraftWiper2, @NotNull SchedulersFactory schedulersFactory, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(accountStateProvider2, "accountStateProvider");
        Intrinsics.checkNotNullParameter(publishDraftWiper2, "publishDraftWiper");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(buildInfo, "build");
        this.accountStateProvider = accountStateProvider2;
        this.publishDraftWiper = publishDraftWiper2;
        this.schedulers = schedulersFactory;
        this.build = buildInfo;
    }

    @Override // com.avito.android.app.task.ApplicationBackgroundStartupTask
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        InteropKt.toV2(this.accountStateProvider.authorized()).filter(a.a).map(b.a).flatMapCompletable(new c(this)).subscribeOn(this.schedulers.io()).observeOn(this.schedulers.io()).subscribe(d.a, new e(this));
    }
}
