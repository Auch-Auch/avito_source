package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a+\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001aQ\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\u0007*\u00028\u0000*\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00010\bj\b\u0012\u0004\u0012\u00028\u0001`\n2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u0002¢\u0006\u0004\b\f\u0010\r\u001aD\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\bj\b\u0012\u0004\u0012\u00028\u0000`\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0004¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a+\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0006*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0006*\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0012\u001a\u0019\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0006¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"T", "Larrow/core/Option;", "Lkotlin/Function0;", "default", "getOrElse", "(Larrow/core/Option;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Larrow/Kind;", "Larrow/core/ForOption;", "Larrow/core/OptionOf;", "alternative", "orElse", "(Larrow/Kind;Lkotlin/jvm/functions/Function0;)Larrow/core/Option;", "value", "or", "(Larrow/Kind;Larrow/core/Option;)Larrow/core/Option;", "toOption", "(Ljava/lang/Object;)Larrow/core/Option;", "", "f", "maybe", "(ZLkotlin/jvm/functions/Function0;)Larrow/core/Option;", "some", "none", "()Larrow/core/Option;", "arrow-core"}, k = 2, mv = {1, 4, 0})
public final class OptionKt {
    public static final <T> T getOrElse(@NotNull Option<? extends T> option, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(option, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "default");
        if (option instanceof None) {
            return (T) function0.invoke();
        }
        if (option instanceof Some) {
            return (T) PredefKt.identity(((Some) option).getT());
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final <A> Option<A> maybe(boolean z, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (z) {
            return new Some(function0.invoke());
        }
        return None.INSTANCE;
    }

    @NotNull
    public static final <A> Option<A> none() {
        return None.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: arrow.core.Option<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Option<T> or(@NotNull Kind<ForOption, ? extends T> kind, @NotNull Option<? extends T> option) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Intrinsics.checkParameterIsNotNull(option, "value");
        Option<T> option2 = (Option) kind;
        return option2.isEmpty() ? option : option2;
    }

    @NotNull
    public static final <A, B extends A> Option<B> orElse(@NotNull Kind<ForOption, ? extends B> kind, @NotNull Function0<? extends Option<? extends B>> function0) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "alternative");
        Option<B> option = (Option) kind;
        return option.isEmpty() ? (Option) function0.invoke() : option;
    }

    @NotNull
    public static final <A> Option<A> some(A a) {
        return new Some(a);
    }

    @NotNull
    public static final <T> Option<T> toOption(@Nullable T t) {
        if (t != null) {
            return new Some(t);
        }
        return None.INSTANCE;
    }
}
