package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.time.Duration;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0016\u0010\u000e\u001a\u00020\u0003*\u00020\bH\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\"\u001a\u0010\u0006\u001a\u00020\u0010*\u00020\u000f8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"", "awaitCancellation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "", "delay", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/time/Duration;", "duration", "delay-p9JZ4hM", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDelayMillis-LRDsOJo", "(D)J", "toDelayMillis", "Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/Delay;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class DelayKt {
    @Nullable
    public static final Object awaitCancellation(@NotNull Continuation<?> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Object result = cancellableContinuationImpl.getResult();
        if (result == a.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public static final Object delay(long j, @NotNull Continuation<? super Unit> continuation) {
        if (j <= 0) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (j < Long.MAX_VALUE) {
            getDelay(cancellableContinuationImpl.getContext()).scheduleResumeAfterDelay(j, cancellableContinuationImpl);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == a.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @ExperimentalTime
    @Nullable
    /* renamed from: delay-p9JZ4hM  reason: not valid java name */
    public static final Object m496delayp9JZ4hM(double d, @NotNull Continuation<? super Unit> continuation) {
        Object delay = delay(m497toDelayMillisLRDsOJo(d), continuation);
        return delay == a.getCOROUTINE_SUSPENDED() ? delay : Unit.INSTANCE;
    }

    @NotNull
    public static final Delay getDelay(@NotNull CoroutineContext coroutineContext) {
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor.Key);
        if (!(element instanceof Delay)) {
            element = null;
        }
        Delay delay = (Delay) element;
        return delay != null ? delay : DefaultExecutorKt.getDefaultDelay();
    }

    @ExperimentalTime
    /* renamed from: toDelayMillis-LRDsOJo  reason: not valid java name */
    public static final long m497toDelayMillisLRDsOJo(double d) {
        if (Duration.m444compareToLRDsOJo(d, Duration.Companion.m489getZEROUwyO8pc()) > 0) {
            return e.coerceAtLeast(Duration.m480toLongMillisecondsimpl(d), 1L);
        }
        return 0;
    }
}
