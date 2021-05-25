package arrow.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a-\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a?\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00070\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0006*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00028\u0000`\b¢\u0006\u0004\b\t\u0010\n\u001a>\u0010\u000f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\rH\b¢\u0006\u0004\b\u000f\u0010\u0010\"\u0016\u0010\u0012\u001a\u00020\u00118\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\"\u0016\u0010\u0014\u001a\u00020\u00118\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013*(\u0010\u0015\u001a\u0004\b\u0000\u0010\u0001\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0003¨\u0006\u0016"}, d2 = {"P1", "T", "t", "Lkotlin/Function1;", "constant", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "", "", "Larrow/core/Predicate;", "mapNullable", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "", "i", "Lkotlin/Function2;", "f", "hashCodeForNullable", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function2;)I", "", "DeprecatedAmbiguity", "Ljava/lang/String;", "DeprecatedUnsafeAccess", "Predicate", "arrow-core"}, k = 2, mv = {1, 4, 0})
public final class UtilsKt {
    @NotNull
    public static final String DeprecatedAmbiguity = "This function is ambiguous and will be removed in future versions of Arrow";
    @NotNull
    public static final String DeprecatedUnsafeAccess = "This function is unsafe and will be removed in future versions of Arrow. Replace or import `arrow.syntax.unsafe.*` if you wish to continue using it in this way";

    public static final class a extends Lambda implements Function1<P1, T> {
        public final /* synthetic */ Object a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Object obj) {
            super(1);
            this.a = obj;
        }

        @Override // kotlin.jvm.functions.Function1
        public final T invoke(P1 p1) {
            return (T) this.a;
        }
    }

    public static final class b extends Lambda implements Function1<T, Boolean> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function1 function1) {
            super(1);
            this.a = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(Object obj) {
            return Boolean.valueOf(obj != null ? ((Boolean) this.a.invoke(obj)).booleanValue() : false);
        }
    }

    @NotNull
    public static final <P1, T> Function1<P1, T> constant(T t) {
        return new a(t);
    }

    public static final <T> int hashCodeForNullable(@Nullable T t, int i, @NotNull Function2<? super Integer, ? super Integer, Integer> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "f");
        return t == null ? i : function2.invoke(Integer.valueOf(i), Integer.valueOf(t.hashCode())).intValue();
    }

    @NotNull
    public static final <T> Function1<T, Boolean> mapNullable(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        return new b(function1);
    }
}
