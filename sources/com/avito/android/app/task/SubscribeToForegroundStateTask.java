package com.avito.android.app.task;

import android.app.Application;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.google.android.exoplayer2.util.MimeTypes;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\nR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/avito/android/app/task/SubscribeToForegroundStateTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "", "onStartApp", "()V", "onStopApp", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "", "Lcom/avito/android/app/task/ApplicationForegroundStartupTask;", "tasks", "Ljava/util/List;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/app/task/MutableApplicationStartupTasksRegistry;", "tasksRegistry", "Lcom/avito/android/app/task/MutableApplicationStartupTasksRegistry;", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Ljava/util/List;Lcom/avito/android/app/task/MutableApplicationStartupTasksRegistry;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/Analytics;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class SubscribeToForegroundStateTask implements ApplicationBlockingStartupTask, LifecycleObserver {
    public final Analytics analytics;
    public final CompositeDisposable disposables = new CompositeDisposable();
    public final LifecycleOwner lifecycleOwner;
    public final SchedulersFactory3 schedulers;
    public final List<ApplicationForegroundStartupTask> tasks;
    public final MutableApplicationStartupTasksRegistry tasksRegistry;

    public static final class a<T> implements Consumer<ApplicationForegroundStartupTask> {
        public final /* synthetic */ SubscribeToForegroundStateTask a;

        public a(SubscribeToForegroundStateTask subscribeToForegroundStateTask) {
            this.a = subscribeToForegroundStateTask;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ApplicationForegroundStartupTask applicationForegroundStartupTask) {
            ApplicationForegroundStartupTask applicationForegroundStartupTask2 = applicationForegroundStartupTask;
            SubscribeToForegroundStateTask subscribeToForegroundStateTask = this.a;
            Intrinsics.checkNotNullExpressionValue(applicationForegroundStartupTask2, "task");
            SubscribeToForegroundStateTask.access$executeTask(subscribeToForegroundStateTask, applicationForegroundStartupTask2);
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ SubscribeToForegroundStateTask a;

        public b(SubscribeToForegroundStateTask subscribeToForegroundStateTask) {
            this.a = subscribeToForegroundStateTask;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            SubscribeToForegroundStateTask.access$unsubscribeLifecycle(this.a);
        }
    }

    public static final class c implements Action {
        public static final c a = new c();

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("SubscribeForegroundTask", th);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.app.task.ApplicationForegroundStartupTask> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: com.avito.android.app.task.MutableApplicationStartupTasksRegistry */
    /* JADX WARN: Multi-variable type inference failed */
    public SubscribeToForegroundStateTask(@NotNull LifecycleOwner lifecycleOwner2, @NotNull List<? extends ApplicationForegroundStartupTask> list, @NotNull MutableApplicationStartupTasksRegistry mutableApplicationStartupTasksRegistry, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(list, "tasks");
        Intrinsics.checkNotNullParameter(mutableApplicationStartupTasksRegistry, "tasksRegistry");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics2, "analytics");
        this.lifecycleOwner = lifecycleOwner2;
        this.tasks = list;
        this.tasksRegistry = mutableApplicationStartupTasksRegistry;
        this.schedulers = schedulersFactory3;
        this.analytics = analytics2;
        for (ApplicationForegroundStartupTask applicationForegroundStartupTask : list) {
            this.tasksRegistry.onSchedule(applicationForegroundStartupTask.getClass());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v1, resolved type: com.avito.android.app.task.MutableApplicationStartupTasksRegistry */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$executeTask(SubscribeToForegroundStateTask subscribeToForegroundStateTask, ApplicationForegroundStartupTask applicationForegroundStartupTask) {
        ApplicationStartupTask.ExecutionResult executionResult;
        Objects.requireNonNull(subscribeToForegroundStateTask);
        try {
            Logs.debug$default("SubscribeForegroundTask", "Execute ApplicationForegroundStartupTask: " + applicationForegroundStartupTask.getClass().getName(), null, 4, null);
            applicationForegroundStartupTask.execute();
            executionResult = ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
        } catch (Exception e) {
            Analytics analytics2 = subscribeToForegroundStateTask.analytics;
            StringBuilder L = a2.b.a.a.a.L("SubscribeToForegroundStateTask. Error while executing task ");
            L.append(applicationForegroundStartupTask.getClass().getName());
            analytics2.track(new NonFatalError(L.toString(), e, null, 4, null));
            executionResult = new ApplicationStartupTask.ExecutionResult.Error(null, e, 1, null);
        }
        subscribeToForegroundStateTask.tasksRegistry.onExecuted(applicationForegroundStartupTask.getClass(), executionResult);
    }

    public static final void access$unsubscribeLifecycle(SubscribeToForegroundStateTask subscribeToForegroundStateTask) {
        subscribeToForegroundStateTask.lifecycleOwner.getLifecycle().removeObserver(subscribeToForegroundStateTask);
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        this.lifecycleOwner.getLifecycle().addObserver(this);
        return ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationBlockingStartupTask.Priority getPriority() {
        return ApplicationBlockingStartupTask.DefaultImpls.getPriority(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStartApp() {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = Observable.fromIterable(this.tasks).subscribeOn(this.schedulers.computation()).doOnNext(new a(this)).observeOn(this.schedulers.mainThread()).doOnTerminate(new b(this)).ignoreElements().subscribe(c.a, d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "Observable.fromIterable(…G_TAG, it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStopApp() {
        this.lifecycleOwner.getLifecycle().removeObserver(this);
    }
}
