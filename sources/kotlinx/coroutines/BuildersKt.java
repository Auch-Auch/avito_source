package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
import u6.a.a0;
import u6.a.f0;
import u6.a.h;
import u6.a.i;
import u6.a.s;
import u6.a.t;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class BuildersKt {
    @NotNull
    public static final <T> Deferred<T> async(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        h hVar;
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            hVar = new s(newCoroutineContext, function2);
        } else {
            hVar = new h(newCoroutineContext, true);
        }
        ((AbstractCoroutine) hVar).start(coroutineStart, hVar, function2);
        return hVar;
    }

    public static /* synthetic */ Deferred async$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return async(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    @Nullable
    public static final <T> Object invoke(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return withContext(coroutineDispatcher, function2, continuation);
    }

    @NotNull
    public static final Job launch(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        AbstractCoroutine abstractCoroutine;
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            abstractCoroutine = new t(newCoroutineContext, function2);
        } else {
            abstractCoroutine = new a0(newCoroutineContext, true);
        }
        abstractCoroutine.start(coroutineStart, abstractCoroutine, function2);
        return abstractCoroutine;
    }

    public static /* synthetic */ Job launch$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return launch(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        if (r1 != null) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T runBlocking(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r7) throws java.lang.InterruptedException {
        /*
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            kotlin.coroutines.ContinuationInterceptor$Key r1 = kotlin.coroutines.ContinuationInterceptor.Key
            kotlin.coroutines.CoroutineContext$Element r1 = r6.get(r1)
            kotlin.coroutines.ContinuationInterceptor r1 = (kotlin.coroutines.ContinuationInterceptor) r1
            r2 = 0
            if (r1 != 0) goto L_0x0020
            kotlinx.coroutines.ThreadLocalEventLoop r1 = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE
            kotlinx.coroutines.EventLoop r1 = r1.getEventLoop$kotlinx_coroutines_core()
            kotlinx.coroutines.GlobalScope r3 = kotlinx.coroutines.GlobalScope.INSTANCE
            kotlin.coroutines.CoroutineContext r6 = r6.plus(r1)
            kotlin.coroutines.CoroutineContext r6 = kotlinx.coroutines.CoroutineContextKt.newCoroutineContext(r3, r6)
            goto L_0x0040
        L_0x0020:
            boolean r3 = r1 instanceof kotlinx.coroutines.EventLoop
            if (r3 != 0) goto L_0x0025
            r1 = r2
        L_0x0025:
            kotlinx.coroutines.EventLoop r1 = (kotlinx.coroutines.EventLoop) r1
            if (r1 == 0) goto L_0x0034
            boolean r3 = r1.shouldBeProcessedFromContext()
            if (r3 == 0) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r1 = r2
        L_0x0031:
            if (r1 == 0) goto L_0x0034
            goto L_0x003a
        L_0x0034:
            kotlinx.coroutines.ThreadLocalEventLoop r1 = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE
            kotlinx.coroutines.EventLoop r1 = r1.currentOrNull$kotlinx_coroutines_core()
        L_0x003a:
            kotlinx.coroutines.GlobalScope r3 = kotlinx.coroutines.GlobalScope.INSTANCE
            kotlin.coroutines.CoroutineContext r6 = kotlinx.coroutines.CoroutineContextKt.newCoroutineContext(r3, r6)
        L_0x0040:
            u6.a.c r3 = new u6.a.c
            r3.<init>(r6, r0, r1)
            kotlinx.coroutines.CoroutineStart r6 = kotlinx.coroutines.CoroutineStart.DEFAULT
            r3.start(r6, r3, r7)
            kotlinx.coroutines.TimeSource r6 = kotlinx.coroutines.TimeSourceKt.getTimeSource()
            if (r6 == 0) goto L_0x0053
            r6.registerTimeLoopThread()
        L_0x0053:
            kotlinx.coroutines.EventLoop r6 = r3.d     // Catch:{ all -> 0x00bc }
            r7 = 1
            r0 = 0
            if (r6 == 0) goto L_0x005c
            kotlinx.coroutines.EventLoop.incrementUseCount$default(r6, r0, r7, r2)     // Catch:{ all -> 0x00bc }
        L_0x005c:
            boolean r6 = java.lang.Thread.interrupted()     // Catch:{ all -> 0x00b3 }
            if (r6 != 0) goto L_0x00aa
            kotlinx.coroutines.EventLoop r6 = r3.d     // Catch:{ all -> 0x00b3 }
            if (r6 == 0) goto L_0x006b
            long r4 = r6.processNextEvent()     // Catch:{ all -> 0x00b3 }
            goto L_0x0070
        L_0x006b:
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0070:
            boolean r6 = r3.isCompleted()     // Catch:{ all -> 0x00b3 }
            if (r6 == 0) goto L_0x009c
            kotlinx.coroutines.EventLoop r6 = r3.d
            if (r6 == 0) goto L_0x007d
            kotlinx.coroutines.EventLoop.decrementUseCount$default(r6, r0, r7, r2)
        L_0x007d:
            kotlinx.coroutines.TimeSource r6 = kotlinx.coroutines.TimeSourceKt.getTimeSource()
            if (r6 == 0) goto L_0x0086
            r6.unregisterTimeLoopThread()
        L_0x0086:
            java.lang.Object r6 = r3.getState$kotlinx_coroutines_core()
            java.lang.Object r6 = kotlinx.coroutines.JobSupportKt.unboxState(r6)
            boolean r7 = r6 instanceof kotlinx.coroutines.CompletedExceptionally
            if (r7 != 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r2 = r6
        L_0x0094:
            kotlinx.coroutines.CompletedExceptionally r2 = (kotlinx.coroutines.CompletedExceptionally) r2
            if (r2 != 0) goto L_0x0099
            return r6
        L_0x0099:
            java.lang.Throwable r6 = r2.cause
            throw r6
        L_0x009c:
            kotlinx.coroutines.TimeSource r6 = kotlinx.coroutines.TimeSourceKt.getTimeSource()
            if (r6 == 0) goto L_0x00a6
            r6.parkNanos(r3, r4)
            goto L_0x005c
        L_0x00a6:
            java.util.concurrent.locks.LockSupport.parkNanos(r3, r4)
            goto L_0x005c
        L_0x00aa:
            java.lang.InterruptedException r6 = new java.lang.InterruptedException
            r6.<init>()
            r3.cancelCoroutine(r6)
            throw r6
        L_0x00b3:
            r6 = move-exception
            kotlinx.coroutines.EventLoop r1 = r3.d
            if (r1 == 0) goto L_0x00bb
            kotlinx.coroutines.EventLoop.decrementUseCount$default(r1, r0, r7, r2)
        L_0x00bb:
            throw r6
        L_0x00bc:
            r6 = move-exception
            kotlinx.coroutines.TimeSource r7 = kotlinx.coroutines.TimeSourceKt.getTimeSource()
            if (r7 == 0) goto L_0x00c6
            r7.unregisterTimeLoopThread()
        L_0x00c6:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.BuildersKt.runBlocking(kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    public static /* synthetic */ Object runBlocking$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) throws InterruptedException {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return runBlocking(coroutineContext, function2);
    }

    /* JADX INFO: finally extract failed */
    @Nullable
    public static final <T> Object withContext(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        Object obj;
        CoroutineContext context = continuation.getContext();
        CoroutineContext plus = context.plus(coroutineContext);
        YieldKt.checkCompletion(plus);
        if (plus == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(plus, continuation);
            obj = UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, function2);
        } else {
            ContinuationInterceptor.Key key = ContinuationInterceptor.Key;
            if (Intrinsics.areEqual((ContinuationInterceptor) plus.get(key), (ContinuationInterceptor) context.get(key))) {
                f0 f0Var = new f0(plus, continuation);
                Object updateThreadContext = ThreadContextKt.updateThreadContext(plus, null);
                try {
                    Object startUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(f0Var, f0Var, function2);
                    ThreadContextKt.restoreThreadContext(plus, updateThreadContext);
                    obj = startUndispatchedOrReturn;
                } catch (Throwable th) {
                    ThreadContextKt.restoreThreadContext(plus, updateThreadContext);
                    throw th;
                }
            } else {
                i iVar = new i(plus, continuation);
                iVar.initParentJob$kotlinx_coroutines_core();
                CancellableKt.startCoroutineCancellable$default(function2, iVar, iVar, null, 4, null);
                obj = iVar.o();
            }
        }
        if (obj == a.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return obj;
    }
}
