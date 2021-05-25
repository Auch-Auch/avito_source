package com.avito.android.util.rx.concurrent;

import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u0006\u001a\u00020\u00042\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\nø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001b"}, d2 = {"Lcom/avito/android/util/rx/concurrent/RxExecutor;", "Ljava/util/concurrent/Executor;", "Lio/reactivex/disposables/Disposable;", "Lkotlin/Function0;", "", "block", "invoke", "(Lkotlin/jvm/functions/Function0;)V", "Ljava/lang/Runnable;", "execute", "(Ljava/lang/Runnable;)V", "dispose", "()V", "", "isDisposed", "()Z", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/Disposable;", "disposable", "Lcom/jakewharton/rxrelay2/Relay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/Relay;", "runnablesRelay", "Lio/reactivex/Scheduler;", "scheduler", "<init>", "(Lio/reactivex/Scheduler;)V", "rx"}, k = 1, mv = {1, 4, 2})
public final class RxExecutor implements Executor, Disposable {
    public final Disposable a;
    public final Relay<Runnable> b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [a2.a.a.n3.y.f.a] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RxExecutor(@org.jetbrains.annotations.NotNull io.reactivex.Scheduler r3) {
        /*
            r2 = this;
            java.lang.String r0 = "scheduler"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r2.<init>()
            java.lang.String r0 = "PublishRelay.create<T>().toSerialized()"
            com.jakewharton.rxrelay2.Relay r0 = a2.b.a.a.a.J1(r0)
            r2.b = r0
            io.reactivex.Observable r3 = r0.observeOn(r3)
            com.avito.android.util.rx.concurrent.RxExecutor$a r0 = com.avito.android.util.rx.concurrent.RxExecutor.a.a
            if (r0 == 0) goto L_0x001e
            a2.a.a.n3.y.f.a r1 = new a2.a.a.n3.y.f.a
            r1.<init>(r0)
            r0 = r1
        L_0x001e:
            io.reactivex.functions.Consumer r0 = (io.reactivex.functions.Consumer) r0
            io.reactivex.disposables.Disposable r3 = r3.subscribe(r0)
            java.lang.String r0 = "runnablesRelay\n         ….subscribe(Runnable::run)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.rx.concurrent.RxExecutor.<init>(io.reactivex.Scheduler):void");
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.a.dispose();
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "block");
        this.b.accept(runnable);
    }

    public final void invoke(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        execute(new Runnable(function0) { // from class: com.avito.android.util.rx.concurrent.RxExecutor$invoke$1
            public final /* synthetic */ Function0 a;

            {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.invoke();
            }
        });
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.a.isDisposed();
    }
}
