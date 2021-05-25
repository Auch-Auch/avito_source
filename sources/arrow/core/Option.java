package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import arrow.core.Either;
import arrow.higherkind;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.r.a.j;
@higherkind
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 ?*\u0006\b\u0000\u0010\u0001 \u00012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0004:\u0001?B\t\b\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00028\u0000H'¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\f\u0010\u000bJ2\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\r2\u0014\b\u0004\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000eH\b¢\u0006\u0004\b\u0010\u0010\u0011JL\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u0000\"\u0004\b\u0001\u0010\u0012\"\u0004\b\u0002\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u001a\b\u0004\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0015H\b¢\u0006\u0004\b\u0010\u0010\u0016J8\u0010\u001a\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000eH\b¢\u0006\u0004\b\u001a\u0010\u001bJH\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\r2*\b\u0004\u0010\u000f\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00010\u0002j\b\u0012\u0004\u0012\u00028\u0001`\u00040\u000eH\b¢\u0006\u0004\b\u001c\u0010\u0011JO\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\r24\u0010\u001d\u001a0\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\u0002j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e`\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ6\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001e\b\u0004\u0010!\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u000ej\b\u0012\u0004\u0012\u00028\u0000` H\b¢\u0006\u0004\b\"\u0010\u0011J6\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001e\b\u0004\u0010!\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u000ej\b\u0012\u0004\u0012\u00028\u0000` H\b¢\u0006\u0004\b#\u0010\u0011J0\u0010$\u001a\u00020\u00052\u001e\b\u0004\u0010!\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u000ej\b\u0012\u0004\u0012\u00028\u0000` H\b¢\u0006\u0004\b$\u0010%J0\u0010'\u001a\u00020\u00052\u001e\b\u0004\u0010&\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u000ej\b\u0012\u0004\u0012\u00028\u0000` H\b¢\u0006\u0004\b'\u0010%J$\u0010)\u001a\u00020(2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020(0\u000eH\b¢\u0006\u0004\b)\u0010*J5\u0010,\u001a\u00028\u0001\"\u0004\b\u0001\u0010\r2\u0006\u0010+\u001a\u00028\u00012\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015¢\u0006\u0004\b,\u0010-JM\u00100\u001a\b\u0012\u0004\u0012\u00028\u00010.\"\u0004\b\u0001\u0010\r2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00010.2$\u0010\u000f\u001a \u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010.\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010.0\u0015¢\u0006\u0004\b0\u00101J-\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u000003\"\u0004\b\u0001\u001022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0017¢\u0006\u0004\b4\u00105J\u0013\u00107\u001a\b\u0012\u0004\u0012\u00028\u000006¢\u0006\u0004\b7\u00108J*\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u001092\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000H\u0004¢\u0006\u0004\b;\u0010<\u0001\u0002@A¨\u0006B"}, d2 = {"Larrow/core/Option;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Larrow/Kind;", "Larrow/core/ForOption;", "Larrow/core/OptionOf;", "", "isEmpty", "()Z", "nonEmpty", "isDefined", "get", "()Ljava/lang/Object;", "orNull", "B", "Lkotlin/Function1;", "f", "map", "(Lkotlin/jvm/functions/Function1;)Larrow/core/Option;", "P1", "R", "p1", "Lkotlin/Function2;", "(Larrow/core/Option;Lkotlin/jvm/functions/Function2;)Larrow/core/Option;", "Lkotlin/Function0;", "ifEmpty", "some", "fold", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "flatMap", "ff", "ap", "(Larrow/Kind;)Larrow/core/Option;", "Larrow/core/Predicate;", "predicate", "filter", "filterNot", "exists", "(Lkotlin/jvm/functions/Function1;)Z", "p", "forall", "", "forEach", "(Lkotlin/jvm/functions/Function1;)V", AuthSource.BOOKING_ORDER, "foldLeft", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Larrow/core/Eval;", "lb", "foldRight", "(Larrow/core/Eval;Lkotlin/jvm/functions/Function2;)Larrow/core/Eval;", "L", "Larrow/core/Either;", "toEither", "(Lkotlin/jvm/functions/Function0;)Larrow/core/Either;", "", "toList", "()Ljava/util/List;", "X", "value", "and", "(Larrow/core/Option;)Larrow/core/Option;", "<init>", "()V", "Companion", "Larrow/core/None;", "Larrow/core/Some;", "arrow-core"}, k = 1, mv = {1, 4, 0})
public abstract class Option<A> implements Kind<ForOption, A> {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006Jl\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u00072\u0006\u0010\u0003\u001a\u00028\u00012@\u0010\r\u001a<\u0012\u0004\u0012\u00028\u0001\u00122\u00120\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b0\tj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b`\f0\bH\u0010¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b\u0010\u0010\u0006J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u0019\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Larrow/core/Option$Companion;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, AuthSource.SEND_ABUSE, "Larrow/core/Option;", "just", "(Ljava/lang/Object;)Larrow/core/Option;", "B", "Lkotlin/Function1;", "Larrow/Kind;", "Larrow/core/ForOption;", "Larrow/core/Either;", "Larrow/core/OptionOf;", "f", "tailRecM", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Larrow/core/Option;", "fromNullable", "invoke", "empty", "()Larrow/core/Option;", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final <A> Option<A> empty() {
            return None.INSTANCE;
        }

        @NotNull
        public final <A> Option<A> fromNullable(@Nullable A a) {
            return a != null ? new Some(a) : None.INSTANCE;
        }

        @NotNull
        public final <A> Option<A> invoke(A a) {
            return new Some(a);
        }

        @NotNull
        public final <A> Option<A> just(A a) {
            return new Some(a);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:? */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: A */
        /* JADX DEBUG: Multi-variable search result rejected for r3v15, resolved type: ? super A */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
        @NotNull
        public final <A, B> Option<B> tailRecM(A a, @NotNull Function1<? super A, ? extends Kind<ForOption, ? extends Either<? extends A, ? extends B>>> function1) {
            while (true) {
                Intrinsics.checkParameterIsNotNull(function1, "f");
                Kind kind = (Kind) function1.invoke((Object) a);
                if (kind != null) {
                    Option option = (Option) kind;
                    if (option instanceof Some) {
                        Some some = (Some) option;
                        Either either = (Either) some.getT();
                        if (either instanceof Either.Left) {
                            a = (Object) ((Either.Left) some.getT()).getA();
                        } else if (either instanceof Either.Right) {
                            return new Some(((Either.Right) some.getT()).getB());
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else if (option instanceof None) {
                        return None.INSTANCE;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type arrow.core.Option<A>");
                }
            }
        }

        public Companion(j jVar) {
        }
    }

    public Option() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: arrow.core.Option<? extends X> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <X> Option<X> and(@NotNull Option<? extends X> option) {
        Intrinsics.checkParameterIsNotNull(option, "value");
        return isEmpty() ? None.INSTANCE : option;
    }

    @NotNull
    public final <B> Option<B> ap(@NotNull Kind<ForOption, ? extends Function1<? super A, ? extends B>> kind) {
        Option<B> option;
        Intrinsics.checkParameterIsNotNull(kind, "ff");
        Option option2 = (Option) kind;
        if (option2 instanceof None) {
            option = None.INSTANCE;
        } else if (option2 instanceof Some) {
            Function1 function1 = (Function1) ((Some) option2).getT();
            if (this instanceof None) {
                option = None.INSTANCE;
            } else if (this instanceof Some) {
                option = new Some(function1.invoke(((Some) this).getT()));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (option != null) {
            return option;
        }
        throw new TypeCastException("null cannot be cast to non-null type arrow.core.Option<A>");
    }

    public final boolean exists(@NotNull Function1<? super A, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if (this instanceof None) {
            return false;
        }
        if (this instanceof Some) {
            return function1.invoke((Object) ((Some) this).getT()).booleanValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final Option<A> filter(@NotNull Function1<? super A, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if (!(this instanceof None)) {
            if (this instanceof Some) {
                Object obj = (Object) ((Some) this).getT();
                if (function1.invoke(obj).booleanValue()) {
                    return new Some(obj);
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return None.INSTANCE;
    }

    @NotNull
    public final Option<A> filterNot(@NotNull Function1<? super A, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if (!(this instanceof None)) {
            if (this instanceof Some) {
                Object obj = (Object) ((Some) this).getT();
                if (!function1.invoke(obj).booleanValue()) {
                    return new Some(obj);
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return None.INSTANCE;
    }

    @NotNull
    public final <B> Option<B> flatMap(@NotNull Function1<? super A, ? extends Kind<ForOption, ? extends B>> function1) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (this instanceof None) {
            obj = None.INSTANCE;
        } else if (this instanceof Some) {
            obj = (Kind) function1.invoke((Object) ((Some) this).getT());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (obj != null) {
            return (Option) obj;
        }
        throw new TypeCastException("null cannot be cast to non-null type arrow.core.Option<A>");
    }

    public final <R> R fold(@NotNull Function0<? extends R> function0, @NotNull Function1<? super A, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function0, "ifEmpty");
        Intrinsics.checkParameterIsNotNull(function1, "some");
        if (this instanceof None) {
            return (R) function0.invoke();
        }
        if (this instanceof Some) {
            return (R) function1.invoke((Object) ((Some) this).getT());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final <B> B foldLeft(B b, @NotNull Function2<? super B, ? super A, ? extends B> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "f");
        if (this instanceof Some) {
            return (B) function2.invoke(b, (Object) ((Some) this).getT());
        }
        if (this instanceof None) {
            return b;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: arrow.core.Eval<? extends B> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <B> Eval<B> foldRight(@NotNull Eval<? extends B> eval, @NotNull Function2<? super A, ? super Eval<? extends B>, ? extends Eval<? extends B>> function2) {
        Intrinsics.checkParameterIsNotNull(eval, "lb");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        if (this instanceof Some) {
            return (Eval) function2.invoke((Object) ((Some) this).getT(), eval);
        }
        if (this instanceof None) {
            return eval;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Deprecated(message = UtilsKt.DeprecatedUnsafeAccess, replaceWith = @ReplaceWith(expression = "fold({ Unit }, f)", imports = {}))
    public final void forEach(@NotNull Function1<? super A, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (nonEmpty()) {
            function1.invoke(get());
        }
    }

    public final boolean forall(@NotNull Function1<? super A, Boolean> function1) {
        Boolean bool;
        Intrinsics.checkParameterIsNotNull(function1, "p");
        if (this instanceof None) {
            bool = Boolean.TRUE;
        } else if (this instanceof Some) {
            bool = function1.invoke((Object) ((Some) this).getT());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return bool.booleanValue();
    }

    @Deprecated(message = UtilsKt.DeprecatedUnsafeAccess, replaceWith = @ReplaceWith(expression = "getOrElse { ifEmpty }", imports = {}))
    public abstract A get();

    public final boolean isDefined() {
        return !isEmpty();
    }

    public abstract boolean isEmpty();

    @NotNull
    public final <P1, R> Option<R> map(@NotNull Option<? extends P1> option, @NotNull Function2<? super A, ? super P1, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(option, "p1");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        if (isEmpty()) {
            return None.INSTANCE;
        }
        if (option instanceof None) {
            return None.INSTANCE;
        }
        if (option instanceof Some) {
            return new Some(function2.invoke(get(), (Object) ((Some) option).getT()));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean nonEmpty() {
        return isDefined();
    }

    @Nullable
    public final A orNull() {
        if (this instanceof None) {
            return null;
        }
        if (this instanceof Some) {
            return (A) PredefKt.identity(((Some) this).getT());
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final <L> Either<L, A> toEither(@NotNull Function0<? extends L> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "ifEmpty");
        if (this instanceof None) {
            return EitherKt.left(function0.invoke());
        }
        if (this instanceof Some) {
            return EitherKt.right(((Some) this).getT());
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final List<A> toList() {
        if (this instanceof None) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (this instanceof Some) {
            return d.listOf(((Some) this).getT());
        }
        throw new NoWhenBranchMatchedException();
    }

    public Option(j jVar) {
    }

    @NotNull
    public final <B> Option<B> map(@NotNull Function1<? super A, ? extends B> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (this instanceof None) {
            return None.INSTANCE;
        }
        if (this instanceof Some) {
            return new Some(function1.invoke((Object) ((Some) this).getT()));
        }
        throw new NoWhenBranchMatchedException();
    }
}
