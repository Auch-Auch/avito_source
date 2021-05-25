package com.avito.android.app.work;

import androidx.work.Operation;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.functions.Cancellable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/work/Operation;", "Lio/reactivex/Scheduler;", "scheduler", "Lio/reactivex/Completable;", "completableResult", "(Landroidx/work/Operation;Lio/reactivex/Scheduler;)Lio/reactivex/Completable;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class OperationsKt {

    public static final class a implements CompletableOnSubscribe {
        public final /* synthetic */ Operation a;
        public final /* synthetic */ Scheduler b;

        /* renamed from: com.avito.android.app.work.OperationsKt$a$a  reason: collision with other inner class name */
        public static final class C0132a implements Cancellable {
            public final /* synthetic */ a a;
            public final /* synthetic */ Scheduler.Worker b;

            public C0132a(a aVar, Scheduler.Worker worker) {
                this.a = aVar;
                this.b = worker;
            }

            @Override // io.reactivex.functions.Cancellable
            public final void cancel() {
                this.a.a.getResult().cancel(false);
                this.b.dispose();
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ CompletableEmitter a;

            public b(CompletableEmitter completableEmitter) {
                this.a = completableEmitter;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CompletableEmitter completableEmitter = this.a;
                Intrinsics.checkNotNullExpressionValue(completableEmitter, "emitter");
                if (!completableEmitter.isDisposed()) {
                    this.a.onComplete();
                }
            }
        }

        public static final class c implements Executor {
            public final /* synthetic */ Scheduler.Worker a;

            public c(Scheduler.Worker worker) {
                this.a = worker;
            }

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.a.schedule(runnable);
            }
        }

        public a(Operation operation, Scheduler scheduler) {
            this.a = operation;
            this.b = scheduler;
        }

        @Override // io.reactivex.CompletableOnSubscribe
        public final void subscribe(@NotNull CompletableEmitter completableEmitter) {
            Intrinsics.checkNotNullParameter(completableEmitter, "emitter");
            Scheduler.Worker createWorker = this.b.createWorker();
            Intrinsics.checkNotNullExpressionValue(createWorker, "scheduler.createWorker()");
            completableEmitter.setCancellable(new C0132a(this, createWorker));
            this.a.getResult().addListener(new b(completableEmitter), new c(createWorker));
        }
    }

    @NotNull
    public static final Completable completableResult(@NotNull Operation operation, @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(operation, "$this$completableResult");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Completable create = Completable.create(new a(operation, scheduler));
        Intrinsics.checkNotNullExpressionValue(create, "Completable.create { emi…        }\n        )\n    }");
        return create;
    }

    public static /* synthetic */ Completable completableResult$default(Operation operation, Scheduler scheduler, int i, Object obj) {
        if ((i & 1) != 0) {
            scheduler = Schedulers.trampoline();
            Intrinsics.checkNotNullExpressionValue(scheduler, "Schedulers.trampoline()");
        }
        return completableResult(operation, scheduler);
    }
}
