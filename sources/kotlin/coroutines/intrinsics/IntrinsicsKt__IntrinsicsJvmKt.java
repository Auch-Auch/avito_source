package kotlin.coroutines.intrinsics;

import java.util.Objects;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class IntrinsicsKt__IntrinsicsJvmKt {
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Continuation<Unit> createCoroutineUnintercepted(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Continuation<Unit> continuation2;
        Intrinsics.checkNotNullParameter(function1, "$this$createCoroutineUnintercepted");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        Continuation<?> probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        if (function1 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function1).create(probeCoroutineCreated);
        }
        CoroutineContext context = probeCoroutineCreated.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            continuation2 = new RestrictedContinuationImpl(probeCoroutineCreated, probeCoroutineCreated, function1) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
                public int a;
                public final /* synthetic */ Continuation b;
                public final /* synthetic */ Function1 c;

                {
                    this.b = r1;
                    this.c = r3;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public Object invokeSuspend(@NotNull Object obj) {
                    int i = this.a;
                    if (i == 0) {
                        this.a = 1;
                        ResultKt.throwOnFailure(obj);
                        Function1 function12 = this.c;
                        Objects.requireNonNull(function12, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function12, 1)).invoke(this);
                    } else if (i == 1) {
                        this.a = 2;
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        } else {
            continuation2 = new ContinuationImpl(probeCoroutineCreated, context, probeCoroutineCreated, context, function1) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
                public int a;
                public final /* synthetic */ Continuation b;
                public final /* synthetic */ CoroutineContext c;
                public final /* synthetic */ Function1 d;

                {
                    this.b = r1;
                    this.c = r2;
                    this.d = r5;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public Object invokeSuspend(@NotNull Object obj) {
                    int i = this.a;
                    if (i == 0) {
                        this.a = 1;
                        ResultKt.throwOnFailure(obj);
                        Function1 function12 = this.d;
                        Objects.requireNonNull(function12, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function12, 1)).invoke(this);
                    } else if (i == 1) {
                        this.a = 2;
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        }
        return continuation2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Continuation<T> intercepted(@NotNull Continuation<? super T> continuation) {
        Continuation<T> continuation2;
        Intrinsics.checkNotNullParameter(continuation, "$this$intercepted");
        ContinuationImpl continuationImpl = !(continuation instanceof ContinuationImpl) ? null : continuation;
        return (continuationImpl == null || (continuation2 = (Continuation<T>) continuationImpl.intercepted()) == null) ? continuation : continuation2;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Continuation<Unit> continuation2;
        Intrinsics.checkNotNullParameter(function2, "$this$createCoroutineUnintercepted");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        Continuation<?> probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(r, probeCoroutineCreated);
        }
        CoroutineContext context = probeCoroutineCreated.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            continuation2 = new RestrictedContinuationImpl(probeCoroutineCreated, probeCoroutineCreated, function2, r) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
                public int a;
                public final /* synthetic */ Continuation b;
                public final /* synthetic */ Function2 c;
                public final /* synthetic */ Object d;

                {
                    this.b = r1;
                    this.c = r3;
                    this.d = r4;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public Object invokeSuspend(@NotNull Object obj) {
                    int i = this.a;
                    if (i == 0) {
                        this.a = 1;
                        ResultKt.throwOnFailure(obj);
                        Function2 function22 = this.c;
                        Objects.requireNonNull(function22, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function22, 2)).invoke(this.d, this);
                    } else if (i == 1) {
                        this.a = 2;
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        } else {
            continuation2 = new ContinuationImpl(probeCoroutineCreated, context, probeCoroutineCreated, context, function2, r) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
                public int a;
                public final /* synthetic */ Continuation b;
                public final /* synthetic */ CoroutineContext c;
                public final /* synthetic */ Function2 d;
                public final /* synthetic */ Object e;

                {
                    this.b = r1;
                    this.c = r2;
                    this.d = r5;
                    this.e = r6;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public Object invokeSuspend(@NotNull Object obj) {
                    int i = this.a;
                    if (i == 0) {
                        this.a = 1;
                        ResultKt.throwOnFailure(obj);
                        Function2 function22 = this.d;
                        Objects.requireNonNull(function22, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function22, 2)).invoke(this.e, this);
                    } else if (i == 1) {
                        this.a = 2;
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        }
        return continuation2;
    }
}
