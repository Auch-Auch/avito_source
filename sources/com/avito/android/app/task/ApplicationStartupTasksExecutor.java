package com.avito.android.app.task;

import android.app.Application;
import com.avito.android.TypedLazy;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.task.StartupAnalyticsTracker;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.FatalRxError;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.google.android.exoplayer2.util.MimeTypes;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.o.a;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001BM\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0018\u0012\u0014\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u00190\u0018\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010%\u001a\u00020\"\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u00190\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u001a\u0010*\u001a\u00020(*\u00020\u00078B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010)¨\u0006-"}, d2 = {"Lcom/avito/android/app/task/ApplicationStartupTasksExecutor;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "execute", "(Landroid/app/Application;)V", "Lcom/avito/android/app/task/ApplicationStartupTask;", "task", "Ljava/lang/Class;", "type", "Lkotlin/Function0;", "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execution", AuthSource.SEND_ABUSE, "(Lcom/avito/android/app/task/ApplicationStartupTask;Ljava/lang/Class;Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", "f", "Z", "failOnUnexpectedError", "", "Lcom/avito/android/TypedLazy;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "backgroundTasks", "Lcom/avito/android/app/task/MutableApplicationStartupTasksRegistry;", "c", "Lcom/avito/android/app/task/MutableApplicationStartupTasksRegistry;", "tasksRegistry", "Lcom/avito/android/analytics/task/StartupAnalyticsTracker;", "e", "Lcom/avito/android/analytics/task/StartupAnalyticsTracker;", "tracker", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "blockingTasks", "", "(Lcom/avito/android/app/task/ApplicationStartupTask;)Ljava/lang/String;", "name", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/avito/android/app/task/MutableApplicationStartupTasksRegistry;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/task/StartupAnalyticsTracker;Z)V", "core_release"}, k = 1, mv = {1, 4, 2})
public class ApplicationStartupTasksExecutor {
    public final List<ApplicationBlockingStartupTask> a;
    public final List<TypedLazy<? extends ApplicationBackgroundStartupTask>> b;
    public final MutableApplicationStartupTasksRegistry c;
    public final SchedulersFactory3 d;
    public final StartupAnalyticsTracker e;
    public final boolean f;

    public static final class a<T> implements Consumer<TypedLazy<? extends ApplicationBackgroundStartupTask>> {
        public final /* synthetic */ ApplicationStartupTasksExecutor a;
        public final /* synthetic */ Application b;

        public a(ApplicationStartupTasksExecutor applicationStartupTasksExecutor, Application application) {
            this.a = applicationStartupTasksExecutor;
            this.b = application;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TypedLazy<? extends ApplicationBackgroundStartupTask> typedLazy) {
            TypedLazy<? extends ApplicationBackgroundStartupTask> typedLazy2 = typedLazy;
            ApplicationStartupTasksExecutor applicationStartupTasksExecutor = this.a;
            Intrinsics.checkNotNullExpressionValue(typedLazy2, "it");
            ApplicationStartupTasksExecutor.access$executeBackgroundTask(applicationStartupTasksExecutor, typedLazy2, this.b);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("ApplicationStartupTasksExecutor", "Unexpected error during background tasks execution", th);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.app.task.ApplicationBlockingStartupTask> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.TypedLazy<? extends com.avito.android.app.task.ApplicationBackgroundStartupTask>> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: com.avito.android.app.task.MutableApplicationStartupTasksRegistry */
    /* JADX WARN: Multi-variable type inference failed */
    public ApplicationStartupTasksExecutor(@NotNull List<? extends ApplicationBlockingStartupTask> list, @NotNull List<? extends TypedLazy<? extends ApplicationBackgroundStartupTask>> list2, @NotNull MutableApplicationStartupTasksRegistry mutableApplicationStartupTasksRegistry, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull StartupAnalyticsTracker startupAnalyticsTracker, boolean z) {
        Intrinsics.checkNotNullParameter(list, "blockingTasks");
        Intrinsics.checkNotNullParameter(list2, "backgroundTasks");
        Intrinsics.checkNotNullParameter(mutableApplicationStartupTasksRegistry, "tasksRegistry");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(startupAnalyticsTracker, "tracker");
        this.a = list;
        this.b = list2;
        this.c = mutableApplicationStartupTasksRegistry;
        this.d = schedulersFactory3;
        this.e = startupAnalyticsTracker;
        this.f = z;
        for (ApplicationBlockingStartupTask applicationBlockingStartupTask : list) {
            this.c.onSchedule(applicationBlockingStartupTask.getClass());
        }
        Iterator<T> it = this.b.iterator();
        while (it.hasNext()) {
            this.c.onSchedule(it.next().getType());
        }
    }

    public static final void access$executeBackgroundTask(ApplicationStartupTasksExecutor applicationStartupTasksExecutor, TypedLazy typedLazy, Application application) {
        Objects.requireNonNull(applicationStartupTasksExecutor);
        ApplicationBackgroundStartupTask applicationBackgroundStartupTask = (ApplicationBackgroundStartupTask) typedLazy.get();
        applicationStartupTasksExecutor.a(applicationBackgroundStartupTask, typedLazy.getType(), new a2.a.a.j.a.a(applicationBackgroundStartupTask, application));
    }

    public final void a(ApplicationStartupTask applicationStartupTask, Class<? extends ApplicationStartupTask> cls, Function0<? extends ApplicationStartupTask.ExecutionResult> function0) {
        ApplicationStartupTask.ExecutionResult executionResult;
        ApplicationStartupTask.ExecutionResult executionResult2;
        StringBuilder L = a2.b.a.a.a.L("Execute ApplicationStartupTask: ");
        L.append(b(applicationStartupTask));
        Logs.debug$default("ApplicationStartupTasksExecutor", L.toString(), null, 4, null);
        try {
            executionResult = (ApplicationStartupTask.ExecutionResult) function0.invoke();
        } catch (Exception e2) {
            if (this.f) {
                executionResult2 = new ApplicationStartupTask.ExecutionResult.Failure(e2);
            } else {
                StringBuilder L2 = a2.b.a.a.a.L("ApplicationStartupTask ");
                L2.append(b(applicationStartupTask));
                L2.append(" failed");
                executionResult2 = new ApplicationStartupTask.ExecutionResult.Error(L2.toString(), e2);
            }
            executionResult = executionResult2;
        }
        this.c.onExecuted(cls, executionResult);
        if (executionResult instanceof ApplicationStartupTask.ExecutionResult.Success) {
            StringBuilder L3 = a2.b.a.a.a.L("StartupTask ");
            L3.append(b(applicationStartupTask));
            L3.append(" completed");
            Logs.debug$default("ApplicationStartupTasksExecutor", L3.toString(), null, 4, null);
        } else if (executionResult instanceof ApplicationStartupTask.ExecutionResult.Error) {
            StringBuilder L4 = a2.b.a.a.a.L("StartupTask ");
            L4.append(b(applicationStartupTask));
            L4.append(" failed: ");
            ApplicationStartupTask.ExecutionResult.Error error = (ApplicationStartupTask.ExecutionResult.Error) executionResult;
            String message = error.getMessage();
            if (message == null) {
                message = "";
            }
            L4.append(message);
            Logs.error("ApplicationStartupTasksExecutor", L4.toString(), error.getError());
        } else if (executionResult instanceof ApplicationStartupTask.ExecutionResult.Failure) {
            StringBuilder L5 = a2.b.a.a.a.L("StartupTask ");
            L5.append(b(applicationStartupTask));
            L5.append(" failed");
            throw new FatalRxError(L5.toString(), ((ApplicationStartupTask.ExecutionResult.Failure) executionResult).getError());
        }
    }

    public final String b(ApplicationStartupTask applicationStartupTask) {
        String name = applicationStartupTask.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "javaClass.name");
        return name;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.avito.android.app.task.ApplicationStartupTasksExecutor */
    /* JADX WARN: Multi-variable type inference failed */
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        for (ApplicationBlockingStartupTask applicationBlockingStartupTask : CollectionsKt___CollectionsKt.sortedWith(this.a, new Comparator<T>() { // from class: com.avito.android.app.task.ApplicationStartupTasksExecutor$execute$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return a.compareValues(Integer.valueOf(t2.getPriority().ordinal()), Integer.valueOf(t.getPriority().ordinal()));
            }
        })) {
            Timer B1 = a2.b.a.a.a.B1();
            a(applicationBlockingStartupTask, applicationBlockingStartupTask.getClass(), new a2.a.a.j.a.b(applicationBlockingStartupTask, application));
            StartupAnalyticsTracker startupAnalyticsTracker = this.e;
            String simpleName = applicationBlockingStartupTask.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "task.javaClass.simpleName");
            startupAnalyticsTracker.track(simpleName, B1.elapsed());
        }
        Observable.fromIterable(this.b).subscribeOn(this.d.computation()).observeOn(this.d.computation()).subscribe(new a(this, application), b.a);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ApplicationStartupTasksExecutor(List list, List list2, MutableApplicationStartupTasksRegistry mutableApplicationStartupTasksRegistry, SchedulersFactory3 schedulersFactory3, StartupAnalyticsTracker startupAnalyticsTracker, boolean z, int i, j jVar) {
        this(list, list2, mutableApplicationStartupTasksRegistry, schedulersFactory3, startupAnalyticsTracker, (i & 32) != 0 ? false : z);
    }
}
