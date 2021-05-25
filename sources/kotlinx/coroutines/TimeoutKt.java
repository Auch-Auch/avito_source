package kotlinx.coroutines;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u6.a.e0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aW\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H@ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\t\u0010\n\u001aZ\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\f\u001a\u00020\u000b2'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H@ø\u0001\u0000ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\r\u0010\u000e\u001aL\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\n\u001aO\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\f\u001a\u00020\u000b2'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001aa\u0010\u0014\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0011\"\b\b\u0001\u0010\u0000*\u00028\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00122'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"T", "", "timeMillis", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "withTimeout", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/time/Duration;", "timeout", "withTimeout-lwyi7ZQ", "(DLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "withTimeoutOrNull-lwyi7ZQ", "U", "Lu6/a/e0;", "coroutine", AuthSource.SEND_ABUSE, "(Lu6/a/e0;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "time", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/TimeoutCancellationException;", "TimeoutCancellationException", "(JLkotlinx/coroutines/Job;)Lkotlinx/coroutines/TimeoutCancellationException;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class TimeoutKt {

    @DebugMetadata(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", i = {0, 0, 0}, l = {101}, m = "withTimeoutOrNull", n = {"timeMillis", "block", "coroutine"}, s = {"J$0", "L$0", "L$1"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public long c;
        public Object d;
        public Object e;

        public a(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return TimeoutKt.withTimeoutOrNull(0, null, this);
        }
    }

    @NotNull
    public static final TimeoutCancellationException TimeoutCancellationException(long j, @NotNull Job job) {
        return new TimeoutCancellationException(a2.b.a.a.a.V2("Timed out waiting for ", j, " ms"), job);
    }

    public static final <U, T extends U> Object a(e0<U, ? super T> e0Var, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        JobKt.disposeOnCompletion(e0Var, DelayKt.getDelay(e0Var.uCont.getContext()).invokeOnTimeout(e0Var.c, e0Var, e0Var.getContext()));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(e0Var, e0Var, function2);
    }

    @Nullable
    public static final <T> Object withTimeout(long j, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        if (j > 0) {
            Object a3 = a(new e0(j, continuation), function2);
            if (a3 == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return a3;
        }
        throw new TimeoutCancellationException("Timed out immediately");
    }

    @ExperimentalTime
    @Nullable
    /* renamed from: withTimeout-lwyi7ZQ  reason: not valid java name */
    public static final <T> Object m498withTimeoutlwyi7ZQ(double d, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return withTimeout(DelayKt.m497toDelayMillisLRDsOJo(d), function2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object withTimeoutOrNull(long r7, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.TimeoutKt.a
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.TimeoutKt$a r0 = (kotlinx.coroutines.TimeoutKt.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.TimeoutKt$a r0 = new kotlinx.coroutines.TimeoutKt$a
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r7 = r0.e
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r0.d
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ TimeoutCancellationException -> 0x0032 }
            goto L_0x006d
        L_0x0032:
            r8 = move-exception
            goto L_0x0071
        L_0x0034:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L_0x0046
            return r4
        L_0x0046:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r10.element = r4
            r0.c = r7     // Catch:{ TimeoutCancellationException -> 0x006e }
            r0.d = r9     // Catch:{ TimeoutCancellationException -> 0x006e }
            r0.e = r10     // Catch:{ TimeoutCancellationException -> 0x006e }
            r0.b = r3     // Catch:{ TimeoutCancellationException -> 0x006e }
            u6.a.e0 r2 = new u6.a.e0     // Catch:{ TimeoutCancellationException -> 0x006e }
            r2.<init>(r7, r0)     // Catch:{ TimeoutCancellationException -> 0x006e }
            r10.element = r2     // Catch:{ TimeoutCancellationException -> 0x006e }
            java.lang.Object r7 = a(r2, r9)     // Catch:{ TimeoutCancellationException -> 0x006e }
            java.lang.Object r8 = t6.p.a.a.getCOROUTINE_SUSPENDED()     // Catch:{ TimeoutCancellationException -> 0x006e }
            if (r7 != r8) goto L_0x0069
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ TimeoutCancellationException -> 0x006e }
        L_0x0069:
            if (r7 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r10 = r7
        L_0x006d:
            return r10
        L_0x006e:
            r7 = move-exception
            r8 = r7
            r7 = r10
        L_0x0071:
            kotlinx.coroutines.Job r9 = r8.coroutine
            T r7 = r7.element
            u6.a.e0 r7 = (u6.a.e0) r7
            if (r9 != r7) goto L_0x007a
            return r4
        L_0x007a:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @ExperimentalTime
    @Nullable
    /* renamed from: withTimeoutOrNull-lwyi7ZQ  reason: not valid java name */
    public static final <T> Object m499withTimeoutOrNulllwyi7ZQ(double d, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return withTimeoutOrNull(DelayKt.m497toDelayMillisLRDsOJo(d), function2, continuation);
    }
}
