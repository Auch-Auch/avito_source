package com.avito.android.messenger.channels.mvi.common.v3;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.rx.concurrent.RxExecutor;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0004B\u001d\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/CommandQueue;", "Lkotlin/Function0;", "", "CommandT", "Lio/reactivex/disposables/Disposable;", "command", ProductAction.ACTION_ADD, "(Lkotlin/jvm/functions/Function0;)V", "dispose", "()V", "", "isDisposed", "()Z", "Lcom/avito/android/messenger/channels/mvi/common/v3/ShouldCancelChecker;", "c", "Lcom/avito/android/messenger/channels/mvi/common/v3/ShouldCancelChecker;", "shouldCancelChecker", "Lcom/avito/android/util/rx/concurrent/RxExecutor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/rx/concurrent/RxExecutor;", "executor", "Ljava/util/LinkedList;", AuthSource.SEND_ABUSE, "Ljava/util/LinkedList;", "queue", "Lio/reactivex/Scheduler;", "scheduler", "<init>", "(Lio/reactivex/Scheduler;Lcom/avito/android/messenger/channels/mvi/common/v3/ShouldCancelChecker;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public final class CommandQueue<CommandT extends Function0<? extends Unit>> implements Disposable {
    public final LinkedList<CommandT> a = new LinkedList<>();
    public final RxExecutor b;
    public final ShouldCancelChecker<CommandT> c;

    public CommandQueue(@NotNull Scheduler scheduler, @NotNull ShouldCancelChecker<CommandT> shouldCancelChecker) {
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics.checkNotNullParameter(shouldCancelChecker, "shouldCancelChecker");
        this.c = shouldCancelChecker;
        this.b = new RxExecutor(new SharedScheduler(scheduler));
    }

    public static final void access$processQueue(CommandQueue commandQueue) {
        commandQueue.b.execute(new Runnable() { // from class: com.avito.android.messenger.channels.mvi.common.v3.CommandQueue$processQueue$$inlined$invoke$1
            @Override // java.lang.Runnable
            public final void run() {
                if (!CommandQueue.access$getQueue$p(CommandQueue.this).isEmpty()) {
                    ((Function0) CommandQueue.access$getQueue$p(CommandQueue.this).peek()).invoke();
                    CommandQueue.access$getQueue$p(CommandQueue.this).remove();
                    CommandQueue.access$processQueue(CommandQueue.this);
                }
            }
        });
    }

    public final void add(@NotNull CommandT commandt) {
        Intrinsics.checkNotNullParameter(commandt, "command");
        this.b.execute(new CommandQueue$add$$inlined$invoke$1(this, commandt));
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.b.isDisposed();
    }
}
