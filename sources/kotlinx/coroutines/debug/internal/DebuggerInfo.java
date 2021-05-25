package kotlinx.coroutines.debug.internal;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import java.io.Serializable;
import java.lang.Thread;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010%\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006,"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "Ljava/io/Serializable;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getDispatcher", "()Ljava/lang/String;", "dispatcher", "c", "getName", "name", "d", "getState", "state", "f", "getLastObservedThreadName", "lastObservedThreadName", "e", "getLastObservedThreadState", "lastObservedThreadState", "", "Ljava/lang/StackTraceElement;", g.a, "Ljava/util/List;", "getLastObservedStackTrace", "()Ljava/util/List;", "lastObservedStackTrace", "", AuthSource.SEND_ABUSE, "Ljava/lang/Long;", "getCoroutineId", "()Ljava/lang/Long;", "coroutineId", "h", "J", "getSequenceNumber", "()J", "sequenceNumber", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "source", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@PublishedApi
public final class DebuggerInfo implements Serializable {
    @Nullable
    public final Long a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @NotNull
    public final List<StackTraceElement> g;
    public final long h;

    public DebuggerInfo(@NotNull DebugCoroutineInfoImpl debugCoroutineInfoImpl, @NotNull CoroutineContext coroutineContext) {
        Thread.State state;
        CoroutineId coroutineId = (CoroutineId) coroutineContext.get(CoroutineId.Key);
        String str = null;
        this.a = coroutineId != null ? Long.valueOf(coroutineId.getId()) : null;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key);
        this.b = continuationInterceptor != null ? continuationInterceptor.toString() : null;
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.Key);
        this.c = coroutineName != null ? coroutineName.getName() : null;
        this.d = debugCoroutineInfoImpl.getState();
        Thread thread = debugCoroutineInfoImpl.lastObservedThread;
        this.e = (thread == null || (state = thread.getState()) == null) ? null : state.toString();
        Thread thread2 = debugCoroutineInfoImpl.lastObservedThread;
        this.f = thread2 != null ? thread2.getName() : str;
        this.g = debugCoroutineInfoImpl.lastObservedStackTrace();
        this.h = debugCoroutineInfoImpl.sequenceNumber;
    }

    @Nullable
    public final Long getCoroutineId() {
        return this.a;
    }

    @Nullable
    public final String getDispatcher() {
        return this.b;
    }

    @NotNull
    public final List<StackTraceElement> getLastObservedStackTrace() {
        return this.g;
    }

    @Nullable
    public final String getLastObservedThreadName() {
        return this.f;
    }

    @Nullable
    public final String getLastObservedThreadState() {
        return this.e;
    }

    @Nullable
    public final String getName() {
        return this.c;
    }

    public final long getSequenceNumber() {
        return this.h;
    }

    @NotNull
    public final String getState() {
        return this.d;
    }
}
