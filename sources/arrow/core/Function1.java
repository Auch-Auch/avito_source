package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import arrow.core.Either;
import arrow.higherkind;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@higherkind
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 \u0016*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00028\u00010\u0003j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0005:\u0001\u0016B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\u0014\u0010\u0015J3\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\u0004\b\u0002\u0010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ[\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\u0004\b\u0002\u0010\u00062:\u0010\b\u001a6\u0012\u0004\u0012\u00028\u0001\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00028\u00020\u0003j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002`\u00050\u0007¢\u0006\u0004\b\u000b\u0010\nJg\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\u0004\b\u0002\u0010\u00062F\u0010\f\u001aB\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00070\u0003j\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007`\u0005¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u000f\u0010\nR%\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Larrow/core/Function1;", "I", "O", "Larrow/Kind;", "Larrow/core/ForFunction1;", "Larrow/core/Function1Of;", "B", "Lkotlin/Function1;", "f", "map", "(Lkotlin/jvm/functions/Function1;)Larrow/core/Function1;", "flatMap", "ff", "ap", "(Larrow/Kind;)Larrow/core/Function1;", ImagesContract.LOCAL, AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", "getF", "()Lkotlin/jvm/functions/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Companion", "arrow-core"}, k = 1, mv = {1, 4, 0})
public final class Function1<I, O> implements Kind<Kind<? extends ForFunction1, ? extends I>, O> {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final kotlin.jvm.functions.Function1<I, O> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0002\u0010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u00062\u0006\u0010\u0007\u001a\u00028\u0003¢\u0006\u0004\b\b\u0010\tJ\u0001\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00040\u0003\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0006\"\u0004\b\u0004\u0010\n2\u0006\u0010\u0007\u001a\u00028\u00032R\u0010\u0010\u001aN\u0012\u0004\u0012\u00028\u0003\u0012D\u0012B\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u000e0\fj\u001a\u0012\u0004\u0012\u00028\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u000e`\u000f0\u000b¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Larrow/core/Function1$Companion;", "", "I", "Larrow/core/Function1;", "ask", "()Larrow/core/Function1;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, AuthSource.SEND_ABUSE, "just", "(Ljava/lang/Object;)Larrow/core/Function1;", "B", "Lkotlin/Function1;", "Larrow/Kind;", "Larrow/core/ForFunction1;", "Larrow/core/Either;", "Larrow/core/Function1Of;", "f", "tailRecM", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Larrow/core/Function1;", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {

        public static final class a extends Lambda implements kotlin.jvm.functions.Function1<I, I> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final I invoke(I i) {
                return i;
            }
        }

        public static final class b extends Lambda implements kotlin.jvm.functions.Function1<I, A> {
            public final /* synthetic */ Object a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Object obj) {
                super(1);
                this.a = obj;
            }

            @Override // kotlin.jvm.functions.Function1
            public final A invoke(I i) {
                return (A) this.a;
            }
        }

        public static final class c extends Lambda implements kotlin.jvm.functions.Function1<I, B> {
            public final /* synthetic */ Object a;
            public final /* synthetic */ kotlin.jvm.functions.Function1 b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(Object obj, kotlin.jvm.functions.Function1 function1) {
                super(1);
                this.a = obj;
                this.b = function1;
            }

            @Override // kotlin.jvm.functions.Function1
            public final B invoke(I i) {
                return (B) Companion.access$step(Function1.Companion, this.a, i, this.b);
            }
        }

        public Companion() {
        }

        public static final Object access$step(Companion companion, Object obj, Object obj2, @NotNull kotlin.jvm.functions.Function1 function1) {
            Objects.requireNonNull(companion);
            while (true) {
                Either either = (Either) Function1Kt.invoke((Kind) function1.invoke(obj), obj2);
                if (either instanceof Either.Right) {
                    return ((Either.Right) either).getB();
                }
                if (either instanceof Either.Left) {
                    obj = ((Either.Left) either).getA();
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }

        @NotNull
        public final <I> Function1<I, I> ask() {
            return Function1Kt.k(a.a);
        }

        @NotNull
        public final <I, A> Function1<I, A> just(A a3) {
            return Function1Kt.k(new b(a3));
        }

        @NotNull
        public final <I, A, B> Function1<I, B> tailRecM(A a3, @NotNull kotlin.jvm.functions.Function1<? super A, ? extends Kind<? extends Kind<ForFunction1, ? extends I>, ? extends Either<? extends A, ? extends B>>> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "f");
            return Function1Kt.k(new c(a3, function1));
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements kotlin.jvm.functions.Function1<kotlin.jvm.functions.Function1<? super O, ? extends B>, Function1<I, ? extends B>> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function1 function1) {
            super(1);
            this.a = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            kotlin.jvm.functions.Function1 function1 = (kotlin.jvm.functions.Function1) obj;
            Intrinsics.checkParameterIsNotNull(function1, "f");
            return this.a.map(function1);
        }
    }

    public static final class b extends Lambda implements kotlin.jvm.functions.Function1<I, B> {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ kotlin.jvm.functions.Function1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function1 function1, kotlin.jvm.functions.Function1 function12) {
            super(1);
            this.a = function1;
            this.b = function12;
        }

        @Override // kotlin.jvm.functions.Function1
        public final B invoke(I i) {
            return (B) Function1Kt.invoke((Kind) this.b.invoke(this.a.getF().invoke(i)), i);
        }
    }

    public static final class c extends Lambda implements kotlin.jvm.functions.Function1<I, O> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Function1 function1) {
            super(1);
            this.a = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public final O invoke(I i) {
            return (O) Function1Kt.invoke(this.a, i);
        }
    }

    public static final class d extends Lambda implements kotlin.jvm.functions.Function1<I, O> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Function1 function1) {
            super(1);
            this.a = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public final O invoke(I i) {
            return this.a.getF().invoke(i);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super I, ? extends O> */
    /* JADX WARN: Multi-variable type inference failed */
    public Function1(@NotNull kotlin.jvm.functions.Function1<? super I, ? extends O> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        this.a = function1;
    }

    @NotNull
    public final <B> Function1<I, B> ap(@NotNull Kind<? extends Kind<ForFunction1, ? extends I>, ? extends kotlin.jvm.functions.Function1<? super O, ? extends B>> kind) {
        Intrinsics.checkParameterIsNotNull(kind, "ff");
        Function1<I, B> flatMap = ((Function1) kind).flatMap(new a(this));
        if (flatMap != null) {
            return flatMap;
        }
        throw new TypeCastException("null cannot be cast to non-null type arrow.core.Function1<I, O>");
    }

    @NotNull
    public final <B> Function1<I, B> flatMap(@NotNull kotlin.jvm.functions.Function1<? super O, ? extends Kind<? extends Kind<ForFunction1, ? extends I>, ? extends B>> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return Function1Kt.k(new b(this, function1));
    }

    @NotNull
    public final kotlin.jvm.functions.Function1<I, O> getF() {
        return this.a;
    }

    @NotNull
    public final Function1<I, O> local(@NotNull kotlin.jvm.functions.Function1<? super I, ? extends I> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return Function1Kt.k(PredefKt.andThen(function1, new c(this)));
    }

    @NotNull
    public final <B> Function1<I, B> map(@NotNull kotlin.jvm.functions.Function1<? super O, ? extends B> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return Function1Kt.k(PredefKt.compose(function1, new d(this)));
    }
}
