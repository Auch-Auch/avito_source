package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import arrow.core.Try;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001aA\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\n\u0010\u000b\u001aa\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\f*\u00028\u0000*\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00010\u0001j\b\u0012\u0004\u0012\u00028\u0001`\u00032\"\u0010\r\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00030\u0004¢\u0006\u0004\b\u000f\u0010\u0010\u001a]\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032(\u0010\r\u001a$\u0012\u0004\u0012\u00020\t\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00030\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a_\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\f*\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032(\u0010\r\u001a$\u0012\u0004\u0012\u00020\t\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00030\bH\u0007¢\u0006\u0004\b\u0013\u0010\u0012\u001aG\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0014\u0010\u0012\u001aI\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\f*\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\bH\u0007¢\u0006\u0004\b\u0015\u0010\u0012\u001a\u0001\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u0000*\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032(\u0010\u0016\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00010\u0001j\b\u0012\u0004\u0012\u00028\u0001`\u00030\b2(\u0010\r\u001a$\u0012\u0004\u0012\u00020\t\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00010\u0001j\b\u0012\u0004\u0012\u00028\u0001`\u00030\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0019\u0010\u001a\u001aU\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u001b*:\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u00010\u0001j\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u0003`\u0003¢\u0006\u0004\b\u001c\u0010\u001d*\u001c\u0010\u001f\u001a\u0004\b\u0000\u0010\f\"\b\u0012\u0004\u0012\u00028\u00000\u001e2\b\u0012\u0004\u0012\u00028\u00000\u001e*\u001c\u0010!\u001a\u0004\b\u0000\u0010\f\"\b\u0012\u0004\u0012\u00028\u00000 2\b\u0012\u0004\u0012\u00028\u00000 ¨\u0006\""}, d2 = {"B", "Larrow/Kind;", "Larrow/core/ForTry;", "Larrow/core/TryOf;", "Lkotlin/Function0;", "default", "getOrDefault", "(Larrow/Kind;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "getOrElse", "(Larrow/Kind;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "f", "Larrow/core/Try;", "orElse", "(Larrow/Kind;Lkotlin/jvm/functions/Function0;)Larrow/core/Try;", "recoverWith", "(Larrow/Kind;Lkotlin/jvm/functions/Function1;)Larrow/core/Try;", "rescue", "recover", "handle", "s", "transform", "(Larrow/Kind;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Larrow/core/Try;", "try_", "(Lkotlin/jvm/functions/Function0;)Larrow/core/Try;", "T", "flatten", "(Larrow/Kind;)Larrow/core/Try;", "Larrow/core/Try$Failure;", "Failure", "Larrow/core/Try$Success;", "Success", "arrow-core"}, k = 2, mv = {1, 4, 0})
public final class TryKt {
    @NotNull
    public static final <T> Try<T> flatten(@NotNull Kind<ForTry, ? extends Kind<ForTry, ? extends T>> kind) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Try r1 = (Try) kind;
        if (r1 instanceof Try.Failure) {
            return Try.Companion.raise(((Try.Failure) r1).getException());
        } else if (r1 instanceof Try.Success) {
            Kind kind2 = (Kind) PredefKt.identity((Kind) ((Try.Success) r1).getValue());
            if (kind2 != null) {
                return (Try) kind2;
            }
            throw new TypeCastException("null cannot be cast to non-null type arrow.core.Try<A>");
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final <B> B getOrDefault(@NotNull Kind<ForTry, ? extends B> kind, @NotNull Function0<? extends B> function0) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "default");
        Try r1 = (Try) kind;
        if (r1 instanceof Try.Failure) {
            ((Try.Failure) r1).getException();
            return (B) function0.invoke();
        } else if (r1 instanceof Try.Success) {
            return (B) PredefKt.identity(((Try.Success) r1).getValue());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final <B> B getOrElse(@NotNull Kind<ForTry, ? extends B> kind, @NotNull Function1<? super Throwable, ? extends B> function1) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "default");
        Try r1 = (Try) kind;
        if (r1 instanceof Try.Failure) {
            return (B) function1.invoke(((Try.Failure) r1).getException());
        }
        if (r1 instanceof Try.Success) {
            return (B) PredefKt.identity(((Try.Success) r1).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    @Deprecated(message = UtilsKt.DeprecatedAmbiguity, replaceWith = @ReplaceWith(expression = "recover(f)", imports = {}))
    @NotNull
    public static final <A> Try<A> handle(@NotNull Kind<ForTry, ? extends A> kind, @NotNull Function1<? super Throwable, ? extends A> function1) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return recover((Try) kind, function1);
    }

    @NotNull
    public static final <B, A extends B> Try<B> orElse(@NotNull Kind<ForTry, ? extends A> kind, @NotNull Function0<? extends Kind<ForTry, ? extends B>> function0) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        Try<B> r1 = (Try) kind;
        if (r1 instanceof Try.Success) {
            return r1;
        }
        if (r1 instanceof Try.Failure) {
            Kind kind2 = (Kind) function0.invoke();
            if (kind2 != null) {
                return (Try) kind2;
            }
            throw new TypeCastException("null cannot be cast to non-null type arrow.core.Try<A>");
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final <B> Try<B> recover(@NotNull Kind<ForTry, ? extends B> kind, @NotNull Function1<? super Throwable, ? extends B> function1) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Try r1 = (Try) kind;
        if (r1 instanceof Try.Failure) {
            return new Try.Success(function1.invoke(((Try.Failure) r1).getException()));
        }
        if (r1 instanceof Try.Success) {
            return new Try.Success(((Try.Success) r1).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final <B> Try<B> recoverWith(@NotNull Kind<ForTry, ? extends B> kind, @NotNull Function1<? super Throwable, ? extends Kind<ForTry, ? extends B>> function1) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Try r1 = (Try) kind;
        if (r1 instanceof Try.Failure) {
            Kind kind2 = (Kind) function1.invoke(((Try.Failure) r1).getException());
            if (kind2 != null) {
                return (Try) kind2;
            }
            throw new TypeCastException("null cannot be cast to non-null type arrow.core.Try<A>");
        } else if (r1 instanceof Try.Success) {
            return new Try.Success(((Try.Success) r1).getValue());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Deprecated(message = UtilsKt.DeprecatedAmbiguity, replaceWith = @ReplaceWith(expression = "recoverWith(f)", imports = {}))
    @NotNull
    public static final <A> Try<A> rescue(@NotNull Kind<ForTry, ? extends A> kind, @NotNull Function1<? super Throwable, ? extends Kind<ForTry, ? extends A>> function1) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return recoverWith((Try) kind, function1);
    }

    @NotNull
    public static final <A, B> Try<B> transform(@NotNull Kind<ForTry, ? extends A> kind, @NotNull Function1<? super A, ? extends Kind<ForTry, ? extends B>> function1, @NotNull Function1<? super Throwable, ? extends Kind<ForTry, ? extends B>> function12) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "s");
        Intrinsics.checkParameterIsNotNull(function12, "f");
        Try r3 = (Try) kind;
        boolean z = r3 instanceof Try.Failure;
        if (z) {
            Kind kind2 = (Kind) function12.invoke(((Try.Failure) r3).getException());
            if (kind2 != null) {
                return (Try) kind2;
            }
            throw new TypeCastException("null cannot be cast to non-null type arrow.core.Try<A>");
        }
        boolean z2 = r3 instanceof Try.Success;
        if (z2) {
            Try.Success success = (Try.Success) r3;
            success.getValue();
            if (z) {
                return Try.Companion.raise(((Try.Failure) r3).getException());
            } else if (z2) {
                Kind kind3 = (Kind) function1.invoke((Object) success.getValue());
                if (kind3 != null) {
                    return (Try) kind3;
                }
                throw new TypeCastException("null cannot be cast to non-null type arrow.core.Try<A>");
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public static final <A> Try<A> try_(@NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "$receiver");
        Try.Companion companion = Try.Companion;
        try {
            return new Try.Success(function0.invoke());
        } catch (Throwable th) {
            return new Try.Failure(th);
        }
    }
}
