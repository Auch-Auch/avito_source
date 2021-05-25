package arrow.core;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import arrow.core.Either;
import arrow.higherkind;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@higherkind
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000 -*\u0006\b\u0000\u0010\u0001 \u00012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0004:\u0001-B\u000f\u0012\u0006\u0010\u001a\u001a\u00028\u0000¢\u0006\u0004\b+\u0010,J0\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\b¢\u0006\u0004\b\b\u0010\tJF\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00052(\u0010\u0007\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00010\u0002j\b\u0012\u0004\u0012\u00028\u0001`\u00040\u0006H\b¢\u0006\u0004\b\n\u0010\tJ5\u0010\r\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u000b\u001a\u00028\u00012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b\r\u0010\u000eJM\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f\"\u0004\b\u0001\u0010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f2$\u0010\u0007\u001a \u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000f0\f¢\u0006\u0004\b\u0011\u0010\u0012JC\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00052(\u0010\u0007\u001a$\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0004\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0013\u0010\tJ\r\u0010\u0014\u001a\u00028\u0000¢\u0006\u0004\b\u0014\u0010\u0015JO\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u000524\u0010\u0016\u001a0\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0002j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006`\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0015J \u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u001a\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0019\u0010\u001a\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0015¨\u0006."}, d2 = {"Larrow/core/Id;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Larrow/Kind;", "Larrow/core/ForId;", "Larrow/core/IdOf;", "B", "Lkotlin/Function1;", "f", "map", "(Lkotlin/jvm/functions/Function1;)Larrow/core/Id;", "flatMap", AuthSource.BOOKING_ORDER, "Lkotlin/Function2;", "foldLeft", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Larrow/core/Eval;", "lb", "foldRight", "(Larrow/core/Eval;Lkotlin/jvm/functions/Function2;)Larrow/core/Eval;", "coflatMap", "extract", "()Ljava/lang/Object;", "ff", "ap", "(Larrow/Kind;)Larrow/core/Id;", "component1", "value", "copy", "(Ljava/lang/Object;)Larrow/core/Id;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getValue", "<init>", "(Ljava/lang/Object;)V", "Companion", "arrow-core"}, k = 1, mv = {1, 4, 0})
public final class Id<A> implements Kind<ForId, A> {
    public static final Companion Companion = new Companion(null);
    public final A a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011Jl\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u00032\u0006\u0010\u0004\u001a\u00028\u00012@\u0010\n\u001a<\u0012\u0004\u0012\u00028\u0001\u00122\u00120\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b0\u0006j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b`\t0\u0005H\u0010¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Larrow/core/Id$Companion;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", AuthSource.SEND_ABUSE, "Lkotlin/Function1;", "Larrow/Kind;", "Larrow/core/ForId;", "Larrow/core/Either;", "Larrow/core/IdOf;", "f", "Larrow/core/Id;", "tailRecM", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Larrow/core/Id;", "just", "(Ljava/lang/Object;)Larrow/core/Id;", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final <A> Id<A> just(A a) {
            return new Id<>(a);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:? */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: A */
        /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: ? super A */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
        @NotNull
        public final <A, B> Id<B> tailRecM(A a, @NotNull Function1<? super A, ? extends Kind<ForId, ? extends Either<? extends A, ? extends B>>> function1) {
            while (true) {
                Intrinsics.checkParameterIsNotNull(function1, "f");
                Kind kind = (Kind) function1.invoke((Object) a);
                if (kind != null) {
                    Either either = (Either) ((Id) kind).getValue();
                    if (either instanceof Either.Left) {
                        a = (Object) ((Either.Left) either).getA();
                    } else if (either instanceof Either.Right) {
                        return new Id<>(((Either.Right) either).getB());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type arrow.core.Id<A>");
                }
            }
        }

        public Companion(j jVar) {
        }
    }

    public Id(A a3) {
        this.a = a3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: arrow.core.Id */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static /* bridge */ /* synthetic */ Id copy$default(Id id, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = id.a;
        }
        return id.copy(obj);
    }

    @NotNull
    public final <B> Id<B> ap(@NotNull Kind<ForId, ? extends Function1<? super A, ? extends B>> kind) {
        Intrinsics.checkParameterIsNotNull(kind, "ff");
        return new Id<>(((Function1) ((Id) kind).getValue()).invoke(getValue()));
    }

    @NotNull
    public final <B> Id<B> coflatMap(@NotNull Function1<? super Kind<ForId, ? extends A>, ? extends B> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        getValue();
        return new Id<>(function1.invoke(this));
    }

    public final A component1() {
        return this.a;
    }

    @NotNull
    public final Id<A> copy(A a3) {
        return new Id<>(a3);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Id) && Intrinsics.areEqual(this.a, ((Id) obj).a);
        }
        return true;
    }

    public final A extract() {
        return this.a;
    }

    @NotNull
    public final <B> Id<B> flatMap(@NotNull Function1<? super A, ? extends Kind<ForId, ? extends B>> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Kind kind = (Kind) function1.invoke(getValue());
        if (kind != null) {
            return (Id) kind;
        }
        throw new TypeCastException("null cannot be cast to non-null type arrow.core.Id<A>");
    }

    public final <B> B foldLeft(B b, @NotNull Function2<? super B, ? super A, ? extends B> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "f");
        return (B) function2.invoke(b, this.a);
    }

    @NotNull
    public final <B> Eval<B> foldRight(@NotNull Eval<? extends B> eval, @NotNull Function2<? super A, ? super Eval<? extends B>, ? extends Eval<? extends B>> function2) {
        Intrinsics.checkParameterIsNotNull(eval, "lb");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        return (Eval) function2.invoke(this.a, eval);
    }

    public final A getValue() {
        return this.a;
    }

    public int hashCode() {
        A a3 = this.a;
        if (a3 != null) {
            return a3.hashCode();
        }
        return 0;
    }

    @NotNull
    public final <B> Id<B> map(@NotNull Function1<? super A, ? extends B> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return new Id<>(function1.invoke(getValue()));
    }

    public String toString() {
        return a.r(a.L("Id(value="), this.a, ")");
    }
}
