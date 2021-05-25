package com.avito.android.app.task;

import android.app.Application;
import com.avito.android.ab_tests.AbTestsReloadTask;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.google.android.exoplayer2.util.MimeTypes;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/app/task/FetchABTestsConfigTask;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "execute", "(Landroid/app/Application;)V", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/BuildInfo;", "Lcom/avito/android/ab_tests/AbTestsReloadTask;", "task", "Lcom/avito/android/ab_tests/AbTestsReloadTask;", "Lcom/avito/android/account/AccountStateProvider;", "accountState", "Lcom/avito/android/account/AccountStateProvider;", "<init>", "(Lcom/avito/android/ab_tests/AbTestsReloadTask;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/util/BuildInfo;)V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public final class FetchABTestsConfigTask implements ApplicationBackgroundStartupTask {
    public final AccountStateProvider accountState;
    public final BuildInfo buildInfo;
    public final AbTestsReloadTask task;

    public static final class a<T> implements Predicate<Boolean> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            return bool2.booleanValue();
        }
    }

    public static final class b<T, R> implements Function<Boolean, Unit> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Unit apply(Boolean bool) {
            return Unit.INSTANCE;
        }
    }

    public static final class c<T, R> implements Function<Unit, CompletableSource> {
        public final /* synthetic */ FetchABTestsConfigTask a;

        public c(FetchABTestsConfigTask fetchABTestsConfigTask) {
            this.a = fetchABTestsConfigTask;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(Unit unit) {
            return this.a.task.load();
        }
    }

    public static final class d implements Action {
        public static final d a = new d();

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            Logs.debug$default("FetchABTestsConfigTask", "Loaded AB Test config", null, 4, null);
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ FetchABTestsConfigTask a;

        public e(FetchABTestsConfigTask fetchABTestsConfigTask) {
            this.a = fetchABTestsConfigTask;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            if (!this.a.buildInfo.isDebug()) {
                Logs.error("FetchABTestsConfigTask", "Failed to load AB test config", th2);
            } else {
                Intrinsics.checkNotNullExpressionValue(th2, "it");
                throw th2;
            }
        }
    }

    public FetchABTestsConfigTask(@NotNull AbTestsReloadTask abTestsReloadTask, @NotNull AccountStateProvider accountStateProvider, @NotNull BuildInfo buildInfo2) {
        Intrinsics.checkNotNullParameter(abTestsReloadTask, "task");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountState");
        Intrinsics.checkNotNullParameter(buildInfo2, "buildInfo");
        this.task = abTestsReloadTask;
        this.accountState = accountStateProvider;
        this.buildInfo = buildInfo2;
    }

    @Override // com.avito.android.app.task.ApplicationBackgroundStartupTask
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        this.accountState.authorized().filter(a.a).map(b.a).startWithItem((R) Unit.INSTANCE).flatMapCompletable(new c(this)).subscribe(d.a, new e(this));
    }
}
