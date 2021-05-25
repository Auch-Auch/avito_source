package com.avito.android.app.task;

import a2.a.a.j.a.a1;
import a2.a.a.j.a.x0;
import android.app.Application;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.avito.android.MessengerWorkFactory;
import com.avito.android.util.SchedulersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import com.jakewharton.rxrelay2.BehaviorRelay;
import dagger.Lazy;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R:\u0010\u0014\u001a&\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u0012 \u0013*\u0012\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u0012\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/app/task/SendPendingMessagesTask;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "()V", "onPause", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "execute", "(Landroid/app/Application;)V", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/MessengerWorkFactory;", "workFactory", "Lcom/avito/android/MessengerWorkFactory;", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "", "kotlin.jvm.PlatformType", "foregroundStream", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "Ldagger/Lazy;", "Lcom/avito/android/app/task/PendingMessageHandler;", "pendingMessageHandler", "Ldagger/Lazy;", "<init>", "(Ldagger/Lazy;Lcom/avito/android/MessengerWorkFactory;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SendPendingMessagesTask implements ApplicationBackgroundStartupTask, LifecycleObserver {
    public final BehaviorRelay<Boolean> foregroundStream = BehaviorRelay.createDefault(Boolean.FALSE);
    public final Lazy<PendingMessageHandler> pendingMessageHandler;
    public final SchedulersFactory schedulers;
    public final MessengerWorkFactory workFactory;

    public static final class a<V> implements Callable<Object> {
        public final /* synthetic */ SendPendingMessagesTask a;

        public a(SendPendingMessagesTask sendPendingMessagesTask) {
            this.a = sendPendingMessagesTask;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "ProcessLifecycleOwner.get()");
            lifecycleOwner.getLifecycle().addObserver(this.a);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public SendPendingMessagesTask(@NotNull Lazy<PendingMessageHandler> lazy, @NotNull MessengerWorkFactory messengerWorkFactory, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(lazy, "pendingMessageHandler");
        Intrinsics.checkNotNullParameter(messengerWorkFactory, "workFactory");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.pendingMessageHandler = lazy;
        this.workFactory = messengerWorkFactory;
        this.schedulers = schedulersFactory;
    }

    public static final Completable access$startForegroundHandling(SendPendingMessagesTask sendPendingMessagesTask, Scheduler scheduler) {
        return sendPendingMessagesTask.pendingMessageHandler.get().startMessageHandling(scheduler);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void onPause() {
        this.foregroundStream.accept(Boolean.FALSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        this.foregroundStream.accept(Boolean.TRUE);
    }

    @Override // com.avito.android.app.task.ApplicationBackgroundStartupTask
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        SharedScheduler sharedScheduler = new SharedScheduler(this.schedulers.io());
        Completable switchMapCompletable = this.foregroundStream.observeOn(this.schedulers.computation()).distinctUntilChanged().switchMapSingle(new x0(this, new AtomicBoolean(true))).distinctUntilChanged().switchMapCompletable(new a1(this, sharedScheduler));
        Intrinsics.checkNotNullExpressionValue(switchMapCompletable, "foregroundStream.observe…          }\n            }");
        switchMapCompletable.subscribe();
        Completable.fromCallable(new a(this)).subscribeOn(this.schedulers.mainThread()).subscribe();
    }
}
