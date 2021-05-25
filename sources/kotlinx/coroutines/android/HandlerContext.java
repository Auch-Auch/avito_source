package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0002\u0012\u0006\u0010,\u001a\u00020)\u0012\b\u00100\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010#\u001a\u00020\u0005¢\u0006\u0004\b1\u00102B\u001d\b\u0016\u0012\u0006\u0010,\u001a\u00020)\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b1\u00103J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0016¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010(\u001a\u00020\u00008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010%R\u0018\u00100\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00064"}, d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "isDispatchNeeded", "(Lkotlin/coroutines/CoroutineContext;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "d", "Z", "invokeImmediately", AuthSource.SEND_ABUSE, "Lkotlinx/coroutines/android/HandlerContext;", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "immediate", "Landroid/os/Handler;", AuthSource.BOOKING_ORDER, "Landroid/os/Handler;", "handler", "_immediate", "c", "Ljava/lang/String;", "name", "<init>", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "(Landroid/os/Handler;Ljava/lang/String;)V", "kotlinx-coroutines-android"}, k = 1, mv = {1, 4, 0})
public final class HandlerContext extends HandlerDispatcher implements Delay {
    public volatile HandlerContext _immediate;
    @NotNull
    public final HandlerContext a;
    public final Handler b;
    public final String c;
    public final boolean d;

    public static final class a extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ HandlerContext a;
        public final /* synthetic */ Runnable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(HandlerContext handlerContext, Runnable runnable) {
            super(1);
            this.a = handlerContext;
            this.b = runnable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            this.a.b.removeCallbacks(this.b);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandlerContext(Handler handler, String str, boolean z) {
        super(null);
        HandlerContext handlerContext = null;
        this.b = handler;
        this.c = str;
        this.d = z;
        this._immediate = z ? this : handlerContext;
        HandlerContext handlerContext2 = this._immediate;
        if (handlerContext2 == null) {
            handlerContext2 = new HandlerContext(handler, str, true);
            this._immediate = handlerContext2;
            Unit unit = Unit.INSTANCE;
        }
        this.a = handlerContext2;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        this.b.post(runnable);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).b == this.b;
    }

    public int hashCode() {
        return System.identityHashCode(this.b);
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        this.b.postDelayed(runnable, e.coerceAtMost(j, 4611686018427387903L));
        return new DisposableHandle(this, runnable) { // from class: kotlinx.coroutines.android.HandlerContext$invokeOnTimeout$1
            public final /* synthetic */ HandlerContext a;
            public final /* synthetic */ Runnable b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlinx.coroutines.DisposableHandle
            public void dispose() {
                this.a.b.removeCallbacks(this.b);
            }
        };
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        return !this.d || (Intrinsics.areEqual(Looper.myLooper(), this.b.getLooper()) ^ true);
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long j, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 = new Runnable(this, cancellableContinuation) { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1
            public final /* synthetic */ HandlerContext a;
            public final /* synthetic */ CancellableContinuation b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.b.resumeUndispatched(this.a, Unit.INSTANCE);
            }
        };
        this.b.postDelayed(handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1, e.coerceAtMost(j, 4611686018427387903L));
        cancellableContinuation.invokeOnCancellation(new a(this, handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1));
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher, java.lang.Object
    @NotNull
    public String toString() {
        String stringInternalImpl = toStringInternalImpl();
        if (stringInternalImpl != null) {
            return stringInternalImpl;
        }
        String str = this.c;
        if (str == null) {
            str = this.b.toString();
        }
        return this.d ? a2.b.a.a.a.c3(str, ".immediate") : str;
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.MainCoroutineDispatcher
    @NotNull
    public HandlerContext getImmediate() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HandlerContext(Handler handler, String str, int i, j jVar) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public HandlerContext(@NotNull Handler handler, @Nullable String str) {
        this(handler, str, false);
    }
}
