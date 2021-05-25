package kotlin;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import t6.p.a.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0004\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\b\u0010\t*v\b\u0003\u0010\u0010\"5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\b\u000e25\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\b\u000eB\u0002\b\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"T", "R", "Lkotlin/DeepRecursiveFunction;", "value", "invoke", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Result;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "UNDEFINED_RESULT", "Lkotlin/Function3;", "Lkotlin/DeepRecursiveScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "Lkotlin/ExperimentalStdlibApi;", "DeepRecursiveFunctionBlock", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
public final class DeepRecursiveKt {
    public static final Object a = Result.m242constructorimpl(a.getCOROUTINE_SUSPENDED());

    static {
        Result.Companion companion = Result.Companion;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    public static final <T, R> R invoke(@NotNull DeepRecursiveFunction<T, R> deepRecursiveFunction, T t) {
        Intrinsics.checkNotNullParameter(deepRecursiveFunction, "$this$invoke");
        t6.a aVar = new t6.a(deepRecursiveFunction.getBlock$kotlin_stdlib(), t);
        while (true) {
            R r = (R) aVar.d;
            Continuation<Object> continuation = aVar.c;
            if (continuation == null) {
                ResultKt.throwOnFailure(r);
                return r;
            } else if (Result.m244equalsimpl0(a, r)) {
                try {
                    Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function3 = aVar.a;
                    Object obj = aVar.b;
                    if (function3 != null) {
                        Object invoke = ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, 3)).invoke(aVar, obj, continuation);
                        if (invoke != a.getCOROUTINE_SUSPENDED()) {
                            Result.Companion companion = Result.Companion;
                            continuation.resumeWith(Result.m242constructorimpl(invoke));
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type (R, P, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                    }
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    continuation.resumeWith(Result.m242constructorimpl(ResultKt.createFailure(th)));
                }
            } else {
                aVar.d = a;
                continuation.resumeWith(r);
            }
        }
    }
}
