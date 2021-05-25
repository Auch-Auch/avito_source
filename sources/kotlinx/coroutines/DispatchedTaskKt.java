package kotlinx.coroutines;

import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u000f\u001a'\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a.\u0010\u0011\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a \u0010\u0015\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\b¢\u0006\u0004\b\u0015\u0010\u0016\"\u0016\u0010\u0017\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\"\u001c\u0010\u0019\u001a\u00020\u00028\u0000@\u0001XT¢\u0006\f\n\u0004\b\u0019\u0010\u0018\u0012\u0004\b\u001a\u0010\u001b\"\u0016\u0010\u001c\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018\"\u001a\u0010\u001d\u001a\u00020\t*\u00020\u00028@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u0016\u0010\u001f\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u0018\"\u001a\u0010 \u001a\u00020\t*\u00020\u00028@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001e\"\u0016\u0010!\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b!\u0010\u0018¨\u0006\""}, d2 = {"T", "Lkotlinx/coroutines/DispatchedTask;", "", "mode", "", "dispatch", "(Lkotlinx/coroutines/DispatchedTask;I)V", "Lkotlin/coroutines/Continuation;", "delegate", "", "undispatched", Tracker.Events.CREATIVE_RESUME, "(Lkotlinx/coroutines/DispatchedTask;Lkotlin/coroutines/Continuation;Z)V", "Lkotlinx/coroutines/EventLoop;", "eventLoop", "Lkotlin/Function0;", "block", "runUnconfinedEventLoop", "(Lkotlinx/coroutines/DispatchedTask;Lkotlinx/coroutines/EventLoop;Lkotlin/jvm/functions/Function0;)V", "", OkListener.KEY_EXCEPTION, "resumeWithStackTrace", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;)V", "MODE_UNINITIALIZED", "I", "MODE_CANCELLABLE", "getMODE_CANCELLABLE$annotations", "()V", "MODE_ATOMIC", "isReusableMode", "(I)Z", "MODE_UNDISPATCHED", "isCancellableMode", "MODE_CANCELLABLE_REUSABLE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class DispatchedTaskKt {
    public static final int MODE_ATOMIC = 0;
    public static final int MODE_CANCELLABLE = 1;
    public static final int MODE_CANCELLABLE_REUSABLE = 2;
    public static final int MODE_UNDISPATCHED = 4;
    public static final int MODE_UNINITIALIZED = -1;

    public static final <T> void dispatch(@NotNull DispatchedTask<? super T> dispatchedTask, int i) {
        Continuation<? super T> delegate$kotlinx_coroutines_core = dispatchedTask.getDelegate$kotlinx_coroutines_core();
        boolean z = i == 4;
        if (z || !(delegate$kotlinx_coroutines_core instanceof DispatchedContinuation) || isCancellableMode(i) != isCancellableMode(dispatchedTask.resumeMode)) {
            resume(dispatchedTask, delegate$kotlinx_coroutines_core, z);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) delegate$kotlinx_coroutines_core).dispatcher;
        CoroutineContext context = delegate$kotlinx_coroutines_core.getContext();
        if (coroutineDispatcher.isDispatchNeeded(context)) {
            coroutineDispatcher.dispatch(context, dispatchedTask);
            return;
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedTask);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            resume(dispatchedTask, dispatchedTask.getDelegate$kotlinx_coroutines_core(), true);
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
        } catch (Throwable th) {
            eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            throw th;
        }
        eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
    }

    @PublishedApi
    public static /* synthetic */ void getMODE_CANCELLABLE$annotations() {
    }

    public static final boolean isCancellableMode(int i) {
        return i == 1 || i == 2;
    }

    public static final boolean isReusableMode(int i) {
        return i == 2;
    }

    public static final <T> void resume(@NotNull DispatchedTask<? super T> dispatchedTask, @NotNull Continuation<? super T> continuation, boolean z) {
        Object obj;
        Object takeState$kotlinx_coroutines_core = dispatchedTask.takeState$kotlinx_coroutines_core();
        Throwable exceptionalResult$kotlinx_coroutines_core = dispatchedTask.getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            Result.Companion companion = Result.Companion;
            obj = ResultKt.createFailure(exceptionalResult$kotlinx_coroutines_core);
        } else {
            Result.Companion companion2 = Result.Companion;
            obj = dispatchedTask.getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        }
        Object r2 = Result.m242constructorimpl(obj);
        if (z) {
            Objects.requireNonNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            CoroutineContext context = dispatchedContinuation.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
            try {
                dispatchedContinuation.continuation.resumeWith(r2);
            } finally {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        } else {
            continuation.resumeWith(r2);
        }
    }

    public static final void resumeWithStackTrace(@NotNull Continuation<?> continuation, @NotNull Throwable th) {
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m242constructorimpl(ResultKt.createFailure(th)));
    }

    public static final void runUnconfinedEventLoop(@NotNull DispatchedTask<?> dispatchedTask, @NotNull EventLoop eventLoop, @NotNull Function0<Unit> function0) {
        eventLoop.incrementUseCount(true);
        try {
            function0.invoke();
            do {
            } while (eventLoop.processUnconfinedEvent());
            InlineMarker.finallyStart(1);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            eventLoop.decrementUseCount(true);
            InlineMarker.finallyEnd(1);
            throw th;
        }
        eventLoop.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
    }
}
