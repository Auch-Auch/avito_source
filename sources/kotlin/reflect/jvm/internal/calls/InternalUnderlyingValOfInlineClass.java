package kotlin.reflect.jvm.internal.calls;

import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u001b\u001cJ'\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0017\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0001\u0002\u001d\u001e¨\u0006\u001f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Method;", "", "instance", "", "args", "callMethod", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "", "Ljava/lang/reflect/Type;", "c", "Ljava/util/List;", "getParameterTypes", "()Ljava/util/List;", "parameterTypes", AuthSource.BOOKING_ORDER, "Ljava/lang/reflect/Method;", "unboxMethod", AuthSource.SEND_ABUSE, "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "getMember", "()Ljava/lang/reflect/Method;", "member", "Bound", "Unbound", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public abstract class InternalUnderlyingValOfInlineClass implements Caller<Method> {
    @NotNull
    public final Type a;
    public final Method b;
    @NotNull
    public final List<Type> c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "d", "Ljava/lang/Object;", "boundReceiver", "Ljava/lang/reflect/Method;", "unboxMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static final class Bound extends InternalUnderlyingValOfInlineClass implements BoundCaller {
        public final Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Bound(@NotNull Method method, @Nullable Object obj) {
            super(method, CollectionsKt__CollectionsKt.emptyList(), null);
            Intrinsics.checkNotNullParameter(method, "unboxMethod");
            this.d = obj;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            Intrinsics.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            return callMethod(this.d, objArr);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/reflect/Method;", "unboxMethod", "<init>", "(Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static final class Unbound extends InternalUnderlyingValOfInlineClass {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Unbound(@NotNull Method method) {
            super(method, d.listOf(method.getDeclaringClass()), null);
            Intrinsics.checkNotNullParameter(method, "unboxMethod");
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            Object[] objArr2;
            Intrinsics.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Object obj = objArr[0];
            CallerImpl.Companion companion = CallerImpl.Companion;
            if (objArr.length <= 1) {
                objArr2 = new Object[0];
            } else {
                objArr2 = ArraysKt___ArraysJvmKt.copyOfRange(objArr, 1, objArr.length);
                Objects.requireNonNull(objArr2, "null cannot be cast to non-null type kotlin.Array<T>");
            }
            return callMethod(obj, objArr2);
        }
    }

    public InternalUnderlyingValOfInlineClass(Method method, List list, j jVar) {
        this.b = method;
        this.c = list;
        Class<?> returnType = method.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "unboxMethod.returnType");
        this.a = returnType;
    }

    @Nullable
    public final Object callMethod(@Nullable Object obj, @NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        return this.b.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    public void checkArguments(@NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        Caller.DefaultImpls.checkArguments(this, objArr);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @Nullable
    public final Method getMember() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public final List<Type> getParameterTypes() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public final Type getReturnType() {
        return this.a;
    }
}
