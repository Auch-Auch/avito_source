package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import arrow.core.Either;
import arrow.higherkind;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@higherkind
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000 '*\u0006\b\u0000\u0010\u0001 \u00012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0004:\u0001'B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b%\u0010&J-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\tJC\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00052(\u0010\n\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00010\u0002j\b\u0012\u0004\u0012\u00028\u0001`\u00040\u0006¢\u0006\u0004\b\u000b\u0010\tJC\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00052(\u0010\u0007\u001a$\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0004\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\f\u0010\tJO\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u000524\u0010\n\u001a0\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0002j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006`\u0004¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011HÀ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0013¨\u0006("}, d2 = {"Larrow/core/Function0;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Larrow/Kind;", "Larrow/core/ForFunction0;", "Larrow/core/Function0Of;", "B", "Lkotlin/Function1;", "f", "map", "(Lkotlin/jvm/functions/Function1;)Larrow/core/Function0;", "ff", "flatMap", "coflatMap", "ap", "(Larrow/Kind;)Larrow/core/Function0;", "extract", "()Ljava/lang/Object;", "Lkotlin/Function0;", "component1$arrow_core", "()Lkotlin/jvm/functions/Function0;", "component1", "copy", "(Lkotlin/jvm/functions/Function0;)Larrow/core/Function0;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function0;", "getF$arrow_core", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Companion", "arrow-core"}, k = 1, mv = {1, 4, 0})
public final class Function0<A> implements Kind<ForFunction0, A> {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final kotlin.jvm.functions.Function0<A> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006JP\u0010\r\u001a\u00028\u0002\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u00072\u0006\u0010\u0003\u001a\u00028\u00012*\u0010\f\u001a&\u0012\u0004\u0012\u00028\u0001\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b0\t0\bH\u0010¢\u0006\u0004\b\r\u0010\u000eJS\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u00072\u0006\u0010\u0003\u001a\u00028\u00012*\u0010\f\u001a&\u0012\u0004\u0012\u00028\u0001\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b0\t0\b¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Larrow/core/Function0$Companion;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, AuthSource.SEND_ABUSE, "Larrow/core/Function0;", "just", "(Ljava/lang/Object;)Larrow/core/Function0;", "B", "Lkotlin/Function1;", "Larrow/Kind;", "Larrow/core/ForFunction0;", "Larrow/core/Either;", "f", "loop", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tailRecM", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Larrow/core/Function0;", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {

        public static final class a extends Lambda implements kotlin.jvm.functions.Function0<A> {
            public final /* synthetic */ Object a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Object obj) {
                super(0);
                this.a = obj;
            }

            @Override // kotlin.jvm.functions.Function0
            public final A invoke() {
                return (A) this.a;
            }
        }

        public static final class b extends Lambda implements kotlin.jvm.functions.Function0<B> {
            public final /* synthetic */ Object a;
            public final /* synthetic */ Function1 b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Object obj, Function1 function1) {
                super(0);
                this.a = obj;
                this.b = function1;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: arrow.core.Function0$Companion */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final B invoke() {
                return (B) Function0.Companion.loop(this.a, this.b);
            }
        }

        public Companion() {
        }

        @NotNull
        public final <A> Function0<A> just(A a3) {
            return Function0Kt.k(new a(a3));
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:? */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: A */
        /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: ? super A */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
        public final <A, B> B loop(A a3, @NotNull Function1<? super A, ? extends Kind<ForFunction0, ? extends Either<? extends A, ? extends B>>> function1) {
            while (true) {
                Intrinsics.checkParameterIsNotNull(function1, "f");
                Kind kind = (Kind) function1.invoke((Object) a3);
                if (kind != null) {
                    Either either = (Either) Function0Kt.invoke((Function0) kind);
                    if (either instanceof Either.Right) {
                        return (B) ((Either.Right) either).getB();
                    }
                    if (either instanceof Either.Left) {
                        a3 = (Object) ((Either.Left) either).getA();
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type arrow.core.Function0<A>");
                }
            }
        }

        @NotNull
        public final <A, B> Function0<B> tailRecM(A a3, @NotNull Function1<? super A, ? extends Kind<ForFunction0, ? extends Either<? extends A, ? extends B>>> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "f");
            return Function0Kt.k(new b(a3, function1));
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Function1<? super A, ? extends B>, Function0<? extends B>> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(1);
            this.a = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Function1 function1 = (Function1) obj;
            Intrinsics.checkParameterIsNotNull(function1, "f");
            return this.a.map(function1);
        }
    }

    public static final class b extends Lambda implements kotlin.jvm.functions.Function0<B> {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ Function1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function0 function0, Function1 function1) {
            super(0);
            this.a = function0;
            this.b = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public final B invoke() {
            return (B) this.b.invoke(this.a);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function0<? extends A> */
    /* JADX WARN: Multi-variable type inference failed */
    public Function0(@NotNull kotlin.jvm.functions.Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "f");
        this.a = function0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: arrow.core.Function0 */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static /* bridge */ /* synthetic */ Function0 copy$default(Function0 function0, kotlin.jvm.functions.Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function02 = function0.a;
        }
        return function0.copy(function02);
    }

    @NotNull
    public final <B> Function0<B> ap(@NotNull Kind<ForFunction0, ? extends Function1<? super A, ? extends B>> kind) {
        Intrinsics.checkParameterIsNotNull(kind, "ff");
        Function0<B> flatMap = ((Function0) kind).flatMap(new a(this));
        if (flatMap != null) {
            return flatMap;
        }
        throw new TypeCastException("null cannot be cast to non-null type arrow.core.Function0<A>");
    }

    @NotNull
    public final <B> Function0<B> coflatMap(@NotNull Function1<? super Kind<ForFunction0, ? extends A>, ? extends B> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return Function0Kt.k(new b(this, function1));
    }

    @NotNull
    public final kotlin.jvm.functions.Function0<A> component1$arrow_core() {
        return this.a;
    }

    @NotNull
    public final Function0<A> copy(@NotNull kotlin.jvm.functions.Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "f");
        return new Function0<>(function0);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Function0) && Intrinsics.areEqual(this.a, ((Function0) obj).a);
        }
        return true;
    }

    public final A extract() {
        return this.a.invoke();
    }

    @NotNull
    public final <B> Function0<B> flatMap(@NotNull Function1<? super A, ? extends Kind<ForFunction0, ? extends B>> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "ff");
        Kind kind = (Kind) function1.invoke(this.a.invoke());
        if (kind != null) {
            return (Function0) kind;
        }
        throw new TypeCastException("null cannot be cast to non-null type arrow.core.Function0<A>");
    }

    @NotNull
    public final kotlin.jvm.functions.Function0<A> getF$arrow_core() {
        return this.a;
    }

    public int hashCode() {
        kotlin.jvm.functions.Function0<A> function0 = this.a;
        if (function0 != null) {
            return function0.hashCode();
        }
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: arrow.core.Function0$Companion */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <B> Function0<B> map(@NotNull Function1<? super A, ? extends B> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return Companion.just(function1.invoke((Object) Function0Kt.invoke(this)));
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Function0(f=");
        L.append(this.a);
        L.append(")");
        return L.toString();
    }
}
