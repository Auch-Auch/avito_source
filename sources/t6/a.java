package t6;

import java.util.Objects;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.DeepRecursiveScope;
import kotlin.ExperimentalStdlibApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.a;
@ExperimentalStdlibApi
public final class a<T, R> extends DeepRecursiveScope<T, R> implements Continuation<R> {
    public Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> a;
    public Object b;
    public Continuation<Object> c = this;
    public Object d = DeepRecursiveKt.access$getUNDEFINED_RESULT$p();

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function3<? super kotlin.DeepRecursiveScope<T, R>, ? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(@NotNull Function3<? super DeepRecursiveScope<T, R>, ? super T, ? super Continuation<? super R>, ? extends Object> function3, T t) {
        super(null);
        Intrinsics.checkNotNullParameter(function3, "block");
        this.a = function3;
        this.b = t;
    }

    @Override // kotlin.DeepRecursiveScope
    @Nullable
    public Object callRecursive(T t, @NotNull Continuation<? super R> continuation) {
        Objects.requireNonNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.c = continuation;
        this.b = t;
        Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        this.c = null;
        this.d = obj;
    }

    @Override // kotlin.DeepRecursiveScope
    @Nullable
    public <U, S> Object callRecursive(@NotNull DeepRecursiveFunction<U, S> deepRecursiveFunction, U u, @NotNull Continuation<? super S> continuation) {
        Function3<DeepRecursiveScope<U, S>, U, Continuation<? super S>, Object> block$kotlin_stdlib = deepRecursiveFunction.getBlock$kotlin_stdlib();
        Objects.requireNonNull(block$kotlin_stdlib, "null cannot be cast to non-null type kotlin.DeepRecursiveFunctionBlock /* = suspend kotlin.DeepRecursiveScope<*, *>.(kotlin.Any?) -> kotlin.Any? */");
        Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function3 = this.a;
        if (block$kotlin_stdlib != function3) {
            this.a = block$kotlin_stdlib;
            Objects.requireNonNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.c = new Continuation<Object>(this, function3, continuation) { // from class: kotlin.DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1
                public final /* synthetic */ a b;
                public final /* synthetic */ Function3 c;
                public final /* synthetic */ Continuation d;

                {
                    this.b = r2;
                    this.c = r3;
                    this.d = r4;
                }

                @Override // kotlin.coroutines.Continuation
                @NotNull
                public CoroutineContext getContext() {
                    return CoroutineContext.this;
                }

                @Override // kotlin.coroutines.Continuation
                public void resumeWith(@NotNull Object obj) {
                    a aVar = this.b;
                    aVar.a = this.c;
                    aVar.c = this.d;
                    aVar.d = obj;
                }
            };
        } else {
            Objects.requireNonNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.c = continuation;
        }
        this.b = u;
        Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended;
    }
}
