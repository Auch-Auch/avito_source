package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import arrow.core.Either;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0003\n\u0002\b\u0003\u001a'\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\u0005\u001aw\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000b**\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\f\u0012\u0004\u0012\u00028\u00010\fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000e2\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012\u001aN\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\n*&\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\r\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00028\u00000\fj\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0000`\u000e2\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a^\u0010\u0017\u001a\u00028\u0001\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n**\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\f\u0012\u0004\u0012\u00028\u00010\fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000e2\u0014\b\u0004\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fH\b¢\u0006\u0004\b\u0017\u0010\u0018\u001az\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n**\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\f\u0012\u0004\u0012\u00028\u00010\fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000e2\u0014\b\u0004\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00190\u000f2\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\b¢\u0006\u0004\b\u001b\u0010\u001c\u001aM\u0010\u001e\u001a\u00020\u0019\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n**\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\f\u0012\u0004\u0012\u00028\u00010\fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000e2\u0006\u0010\u001d\u001a\u00028\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0001\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000b**\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\f\u0012\u0004\u0012\u00028\u00010\fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000e2F\u0010 \u001aB\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f0\fj\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f`\u000e¢\u0006\u0004\b!\u0010\"\u001a\u0001\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n**\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\f\u0012\u0004\u0012\u00028\u00010\fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000e2.\u0010#\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\f\u0012\u0004\u0012\u00028\u00010\fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000e¢\u0006\u0004\b$\u0010\"\u001a0\u0010(\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\b¢\u0006\u0004\b(\u0010)\u001a#\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002\"\u0004\b\u0000\u0010\t*\u00028\u0000¢\u0006\u0004\b\u0001\u0010\u0005\u001a#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\t*\u00028\u0000¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006*"}, d2 = {"L", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "Larrow/core/Either;", "", "Left", "(Ljava/lang/Object;)Larrow/core/Either;", "R", "right", "Right", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "Larrow/Kind;", "Larrow/core/ForEither;", "Larrow/core/EitherOf;", "Lkotlin/Function1;", "f", "flatMap", "(Larrow/Kind;Lkotlin/jvm/functions/Function1;)Larrow/core/Either;", "Lkotlin/Function0;", "default", "getOrElse", "(Larrow/Kind;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrHandle", "(Larrow/Kind;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "predicate", "filterOrElse", "(Larrow/Kind;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Larrow/core/Either;", "elem", "contains", "(Larrow/Kind;Ljava/lang/Object;)Z", "ff", "ap", "(Larrow/Kind;Larrow/Kind;)Larrow/core/Either;", "y", "combineK", "T", SDKConstants.PARAM_A2U_BODY, "", "eitherTry", "(Lkotlin/jvm/functions/Function0;)Larrow/core/Either;", "arrow-core"}, k = 2, mv = {1, 4, 0})
public final class EitherKt {

    public static final class a extends Lambda implements Function1<Function1<? super B, ? extends C>, Either<? extends A, ? extends C>> {
        public final /* synthetic */ Kind a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Kind kind) {
            super(1);
            this.a = kind;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Function1 function1 = (Function1) obj;
            Intrinsics.checkParameterIsNotNull(function1, "f");
            Kind kind = this.a;
            if (kind != null) {
                Either either = (Either) kind;
                if (either instanceof Either.Right) {
                    return new Either.Right(function1.invoke(((Either.Right) either).getB()));
                }
                if (either instanceof Either.Left) {
                    return new Either.Left(((Either.Left) either).getA());
                }
                throw new NoWhenBranchMatchedException();
            }
            throw new TypeCastException("null cannot be cast to non-null type arrow.core.Either<A, B>");
        }
    }

    @NotNull
    public static final <L> Either Left(L l) {
        return Either.Companion.left(l);
    }

    @NotNull
    public static final <R> Either Right(R r) {
        return Either.Companion.right(r);
    }

    @NotNull
    public static final <A, B, C> Either<A, C> ap(@NotNull Kind<? extends Kind<ForEither, ? extends A>, ? extends B> kind, @NotNull Kind<? extends Kind<ForEither, ? extends A>, ? extends Function1<? super B, ? extends C>> kind2) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Intrinsics.checkParameterIsNotNull(kind2, "ff");
        Either<A, C> flatMap = flatMap((Either) kind2, new a(kind));
        if (flatMap != null) {
            return flatMap;
        }
        throw new TypeCastException("null cannot be cast to non-null type arrow.core.Either<A, B>");
    }

    @NotNull
    public static final <A, B> Either<A, B> combineK(@NotNull Kind<? extends Kind<ForEither, ? extends A>, ? extends B> kind, @NotNull Kind<? extends Kind<ForEither, ? extends A>, ? extends B> kind2) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Intrinsics.checkParameterIsNotNull(kind2, "y");
        if (kind instanceof Either.Left) {
            return (Either) kind2;
        }
        return (Either) kind;
    }

    public static final <A, B> boolean contains(@NotNull Kind<? extends Kind<ForEither, ? extends A>, ? extends B> kind, B b) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Either either = (Either) kind;
        if (either instanceof Either.Right) {
            return Intrinsics.areEqual(((Either.Right) either).getB(), b);
        }
        if (either instanceof Either.Left) {
            ((Either.Left) either).getA();
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Deprecated(message = UtilsKt.DeprecatedAmbiguity, replaceWith = @ReplaceWith(expression = "Try { body }.toEither()", imports = {}))
    @NotNull
    public static final <T> Either<Throwable, T> eitherTry(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, SDKConstants.PARAM_A2U_BODY);
        try {
            return new Either.Right(function0.invoke());
        } catch (Throwable th) {
            return new Either.Left(th);
        }
    }

    @NotNull
    public static final <A, B> Either<A, B> filterOrElse(@NotNull Kind<? extends Kind<ForEither, ? extends A>, ? extends B> kind, @NotNull Function1<? super B, Boolean> function1, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Intrinsics.checkParameterIsNotNull(function0, "default");
        Either either = (Either) kind;
        if (either instanceof Either.Right) {
            Object obj = (Object) ((Either.Right) either).getB();
            return function1.invoke(obj).booleanValue() ? new Either.Right(obj) : new Either.Left(function0.invoke());
        } else if (either instanceof Either.Left) {
            return new Either.Left(((Either.Left) either).getA());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public static final <A, B, C> Either<A, C> flatMap(@NotNull Kind<? extends Kind<ForEither, ? extends A>, ? extends B> kind, @NotNull Function1<? super B, ? extends Either<? extends A, ? extends C>> function1) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Either either = (Either) kind;
        if (either instanceof Either.Right) {
            return (Either) function1.invoke((Object) ((Either.Right) either).getB());
        }
        if (either instanceof Either.Left) {
            return new Either.Left(((Either.Left) either).getA());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <B> B getOrElse(@NotNull Kind<? extends Kind<ForEither, ?>, ? extends B> kind, @NotNull Function0<? extends B> function0) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "default");
        Either either = (Either) kind;
        if (either instanceof Either.Right) {
            return (B) PredefKt.identity(((Either.Right) either).getB());
        }
        if (either instanceof Either.Left) {
            ((Either.Left) either).getA();
            return (B) function0.invoke();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <A, B> B getOrHandle(@NotNull Kind<? extends Kind<ForEither, ? extends A>, ? extends B> kind, @NotNull Function1<? super A, ? extends B> function1) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "default");
        Either either = (Either) kind;
        if (either instanceof Either.Right) {
            return (B) PredefKt.identity(((Either.Right) either).getB());
        }
        if (either instanceof Either.Left) {
            return (B) function1.invoke((Object) ((Either.Left) either).getA());
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final <A> Either left(A a3) {
        return new Either.Left(a3);
    }

    @NotNull
    public static final <A> Either right(A a3) {
        return new Either.Right(a3);
    }
}
