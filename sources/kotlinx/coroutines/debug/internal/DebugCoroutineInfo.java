package kotlinx.coroutines.debug.internal;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b.\u0010/R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010 \u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028G@\u0006¢\u0006\f\n\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010\u0007R\u001b\u0010+\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%¨\u00060"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "", "", "Ljava/lang/StackTraceElement;", "c", "Ljava/util/List;", "getCreationStackTrace", "()Ljava/util/List;", "creationStackTrace", "", AuthSource.BOOKING_ORDER, "J", "getSequenceNumber", "()J", "sequenceNumber", "Lkotlin/coroutines/CoroutineContext;", "h", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Thread;", "e", "Ljava/lang/Thread;", "getLastObservedThread", "()Ljava/lang/Thread;", "lastObservedThread", "", "d", "Ljava/lang/String;", "getState", "()Ljava/lang/String;", "state", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", AuthSource.SEND_ABUSE, "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCreationStackBottom", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "creationStackBottom", g.a, "lastObservedStackTrace", "f", "getLastObservedFrame", "lastObservedFrame", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "source", "<init>", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@PublishedApi
public final class DebugCoroutineInfo {
    @Nullable
    public final CoroutineStackFrame a;
    public final long b;
    @NotNull
    public final List<StackTraceElement> c;
    @NotNull
    public final String d;
    @Nullable
    public final Thread e;
    @Nullable
    public final CoroutineStackFrame f;
    @NotNull
    public final List<StackTraceElement> g;
    @NotNull
    public final CoroutineContext h;

    public DebugCoroutineInfo(@NotNull DebugCoroutineInfoImpl debugCoroutineInfoImpl, @NotNull CoroutineContext coroutineContext) {
        this.h = coroutineContext;
        this.a = debugCoroutineInfoImpl.getCreationStackBottom();
        this.b = debugCoroutineInfoImpl.sequenceNumber;
        this.c = debugCoroutineInfoImpl.getCreationStackTrace();
        this.d = debugCoroutineInfoImpl.getState();
        this.e = debugCoroutineInfoImpl.lastObservedThread;
        this.f = debugCoroutineInfoImpl.getLastObservedFrame$kotlinx_coroutines_core();
        this.g = debugCoroutineInfoImpl.lastObservedStackTrace();
    }

    @NotNull
    public final CoroutineContext getContext() {
        return this.h;
    }

    @Nullable
    public final CoroutineStackFrame getCreationStackBottom() {
        return this.a;
    }

    @NotNull
    public final List<StackTraceElement> getCreationStackTrace() {
        return this.c;
    }

    @Nullable
    public final CoroutineStackFrame getLastObservedFrame() {
        return this.f;
    }

    @Nullable
    public final Thread getLastObservedThread() {
        return this.e;
    }

    public final long getSequenceNumber() {
        return this.b;
    }

    @NotNull
    public final String getState() {
        return this.d;
    }

    @JvmName(name = "lastObservedStackTrace")
    @NotNull
    public final List<StackTraceElement> lastObservedStackTrace() {
        return this.g;
    }
}
