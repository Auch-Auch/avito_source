package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.user_profile.SubscriptionStatus;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0016\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013¨\u0006\u001e"}, d2 = {"Landroidx/lifecycle/DispatchQueue;", "", "", Tracker.Events.CREATIVE_PAUSE, "()V", Tracker.Events.CREATIVE_RESUME, "finish", "drainQueue", "", "canRun", "()Z", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "runnable", "dispatchAndEnqueue", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", AuthSource.SEND_ABUSE, "(Ljava/lang/Runnable;)V", "Z", SubscriptionStatus.PAUSED, "Ljava/util/Queue;", "d", "Ljava/util/Queue;", "queue", AuthSource.BOOKING_ORDER, "finished", "c", "isDraining", "<init>", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 4, 1})
public final class DispatchQueue {
    public boolean a = true;
    public boolean b;
    public boolean c;
    public final Queue<Runnable> d = new ArrayDeque();

    public static final class a implements Runnable {
        public final /* synthetic */ DispatchQueue a;
        public final /* synthetic */ CoroutineContext b;
        public final /* synthetic */ Runnable c;

        public a(DispatchQueue dispatchQueue, CoroutineContext coroutineContext, Runnable runnable) {
            this.a = dispatchQueue;
            this.b = coroutineContext;
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a(this.c);
        }
    }

    @MainThread
    public final void a(Runnable runnable) {
        if (this.d.offer(runnable)) {
            drainQueue();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    }

    @MainThread
    public final boolean canRun() {
        return this.b || !this.a;
    }

    @AnyThread
    @SuppressLint({"WrongThread"})
    public final void dispatchAndEnqueue(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        if (immediate.isDispatchNeeded(coroutineContext) || canRun()) {
            immediate.dispatch(coroutineContext, new a(this, coroutineContext, runnable));
        } else {
            a(runnable);
        }
    }

    @MainThread
    public final void drainQueue() {
        if (!this.c) {
            boolean z = false;
            z = true;
            try {
                while (true) {
                    if (!(!this.d.isEmpty())) {
                        break;
                    } else if (!canRun()) {
                        break;
                    } else {
                        Runnable poll = this.d.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                this.c = false;
            } finally {
                this.c = z;
            }
        }
    }

    @MainThread
    public final void finish() {
        this.b = true;
        drainQueue();
    }

    @MainThread
    public final void pause() {
        this.a = true;
    }

    @MainThread
    public final void resume() {
        if (this.a) {
            if (!this.b) {
                this.a = false;
                drainQueue();
                return;
            }
            throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
        }
    }
}
