package arrow.core;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import arrow.higherkind;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@higherkind
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000 1*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00028\u00010\u0003j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0005:\u00011B\u0017\u0012\u0006\u0010\u001e\u001a\u00028\u0000\u0012\u0006\u0010\u0012\u001a\u00028\u0001¢\u0006\u0004\b/\u00100J3\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\u0004\b\u0002\u0010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\u0004\b\t\u0010\nJc\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\u0004\b\u0002\u0010\u00062B\u0010\b\u001a>\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00070\u0003j\u0018\u0012\u0002\b\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007`\u0005¢\u0006\u0004\b\u000b\u0010\fJj\u0010\u000e\u001a\u0013\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\r\u0012\u0004\u0012\u00028\u00020\u0000\"\u0004\b\u0002\u0010\u00062D\u0010\b\u001a@\u0012\u0004\u0012\u00028\u0001\u00126\u00124\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0004\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\r0\u0003\u0012\u0004\u0012\u00028\u00020\u0003j\u0013\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\r\u0012\u0004\u0012\u00028\u0002`\u00050\u0007¢\u0006\u0004\b\u000e\u0010\nJ[\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\u0004\b\u0002\u0010\u00062:\u0010\b\u001a6\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00028\u00010\u0003j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0005\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\u0004\b\u000f\u0010\nJ\r\u0010\u0010\u001a\u00028\u0001¢\u0006\u0004\b\u0010\u0010\u0011J5\u0010\u0014\u001a\u00028\u0002\"\u0004\b\u0002\u0010\u00062\u0006\u0010\u0012\u001a\u00028\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015JM\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00020\u0016\"\u0004\b\u0002\u0010\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00020\u00162$\u0010\b\u001a \u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00160\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0011J\u0010\u0010\u001d\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0011J0\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u001e\u001a\u00028\u00002\b\b\u0002\u0010\u0012\u001a\u00028\u0001HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0019\u0010\u001e\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010,\u001a\u0004\b-\u0010\u0011R\u0019\u0010\u0012\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b.\u0010\u0011¨\u00062"}, d2 = {"Larrow/core/Tuple2;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Larrow/Kind;", "Larrow/core/ForTuple2;", "Larrow/core/Tuple2Of;", "C", "Lkotlin/Function1;", "f", "map", "(Lkotlin/jvm/functions/Function1;)Larrow/core/Tuple2;", "ap", "(Larrow/Kind;)Larrow/core/Tuple2;", "Lkotlin/UnsafeVariance;", "flatMap", "coflatMap", "extract", "()Ljava/lang/Object;", AuthSource.BOOKING_ORDER, "Lkotlin/Function2;", "foldL", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Larrow/core/Eval;", "lb", "foldR", "(Larrow/core/Eval;Lkotlin/jvm/functions/Function2;)Larrow/core/Eval;", "reverse", "()Larrow/core/Tuple2;", "component1", "component2", AuthSource.SEND_ABUSE, "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Larrow/core/Tuple2;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getA", "getB", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Companion", "arrow-core"}, k = 1, mv = {1, 4, 0})
public final class Tuple2<A, B> implements Kind<Kind<? extends ForTuple2, ? extends A>, B> {
    public static final Companion Companion = new Companion(null);
    public final A a;
    public final B b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Larrow/core/Tuple2$Companion;", "", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public Tuple2(A a3, B b2) {
        this.a = a3;
        this.b = b2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: arrow.core.Tuple2 */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static /* bridge */ /* synthetic */ Tuple2 copy$default(Tuple2 tuple2, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = tuple2.a;
        }
        if ((i & 2) != 0) {
            obj2 = tuple2.b;
        }
        return tuple2.copy(obj, obj2);
    }

    @NotNull
    public final <C> Tuple2<A, C> ap(@NotNull Kind<? extends Kind<ForTuple2, ?>, ? extends Function1<? super B, ? extends C>> kind) {
        Intrinsics.checkParameterIsNotNull(kind, "f");
        return map(((Tuple2) kind).b);
    }

    @NotNull
    public final <C> Tuple2<A, C> coflatMap(@NotNull Function1<? super Kind<? extends Kind<ForTuple2, ? extends A>, ? extends B>, ? extends C> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return TupleNKt.toT(this.a, function1.invoke(this));
    }

    public final A component1() {
        return this.a;
    }

    public final B component2() {
        return this.b;
    }

    @NotNull
    public final Tuple2<A, B> copy(A a3, B b2) {
        return new Tuple2<>(a3, b2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tuple2)) {
            return false;
        }
        Tuple2 tuple2 = (Tuple2) obj;
        return Intrinsics.areEqual(this.a, tuple2.a) && Intrinsics.areEqual(this.b, tuple2.b);
    }

    public final B extract() {
        return this.b;
    }

    @NotNull
    public final <C> Tuple2<A, C> flatMap(@NotNull Function1<? super B, ? extends Kind<? extends Kind<ForTuple2, ? extends A>, ? extends C>> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Kind kind = (Kind) function1.invoke(this.b);
        if (kind != null) {
            return (Tuple2) kind;
        }
        throw new TypeCastException("null cannot be cast to non-null type arrow.core.Tuple2<A, B>");
    }

    public final <C> C foldL(C c, @NotNull Function2<? super C, ? super B, ? extends C> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "f");
        return (C) function2.invoke(c, this.b);
    }

    @NotNull
    public final <C> Eval<C> foldR(@NotNull Eval<? extends C> eval, @NotNull Function2<? super B, ? super Eval<? extends C>, ? extends Eval<? extends C>> function2) {
        Intrinsics.checkParameterIsNotNull(eval, "lb");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        return (Eval) function2.invoke(this.b, eval);
    }

    public final A getA() {
        return this.a;
    }

    public final B getB() {
        return this.b;
    }

    public int hashCode() {
        A a3 = this.a;
        int i = 0;
        int hashCode = (a3 != null ? a3.hashCode() : 0) * 31;
        B b2 = this.b;
        if (b2 != null) {
            i = b2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public final <C> Tuple2<A, C> map(@NotNull Function1<? super B, ? extends C> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return TupleNKt.toT(this.a, function1.invoke(this.b));
    }

    @NotNull
    public final Tuple2<B, A> reverse() {
        return new Tuple2<>(this.b, this.a);
    }

    public String toString() {
        StringBuilder L = a.L("Tuple2(a=");
        L.append((Object) this.a);
        L.append(", b=");
        return a.r(L, this.b, ")");
    }
}
