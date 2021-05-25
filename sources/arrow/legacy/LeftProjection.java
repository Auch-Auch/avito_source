package arrow.legacy;

import arrow.core.Either;
import arrow.core.EitherKt;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Deprecated(message = "arrow.data.Either is right biased. This data type will be removed in future releases")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003B\u001b\u0012\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010¢\u0006\u0004\b \u0010!J\r\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0010\"\u0004\b\u0002\u0010\u000f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J3\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00100\u00132\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0019\u0010\u001aR%\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Larrow/legacy/LeftProjection;", "L", "R", "", "get", "()Ljava/lang/Object;", "Lkotlin/Function1;", "", "f", "forEach", "(Lkotlin/jvm/functions/Function1;)V", "", "predicate", "exists", "(Lkotlin/jvm/functions/Function1;)Z", "X", "Larrow/core/Either;", "map", "(Lkotlin/jvm/functions/Function1;)Larrow/core/Either;", "Larrow/core/Option;", "filter", "(Lkotlin/jvm/functions/Function1;)Larrow/core/Option;", "", "toList", "()Ljava/util/List;", "toOption", "()Larrow/core/Option;", AuthSource.SEND_ABUSE, "Larrow/core/Either;", "getE", "()Larrow/core/Either;", "e", "<init>", "(Larrow/core/Either;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
public final class LeftProjection<L, R> {
    @NotNull
    public final Either<L, R> a;

    public static final class a extends Lambda implements Function1<L, Either> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function1 function1) {
            super(1);
            this.a = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public Either invoke(Object obj) {
            return EitherKt.Left(this.a.invoke(obj));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: arrow.core.Either<? extends L, ? extends R> */
    /* JADX WARN: Multi-variable type inference failed */
    public LeftProjection(@NotNull Either<? extends L, ? extends R> either) {
        Intrinsics.checkParameterIsNotNull(either, "e");
        this.a = either;
    }

    public final boolean exists(@NotNull Function1<? super L, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Either<L, R> either = this.a;
        if (either instanceof Either.Left) {
            return function1.invoke((Object) ((Either.Left) either).getA()).booleanValue();
        }
        if (either instanceof Either.Right) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final Option<Either<L, R>> filter(@NotNull Function1<? super L, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Either<L, R> either = this.a;
        if (either instanceof Either.Left) {
            if (function1.invoke((Object) ((Either.Left) either).getA()).booleanValue()) {
                return new Some(this.a);
            }
            return None.INSTANCE;
        } else if (either instanceof Either.Right) {
            return None.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void forEach(@NotNull Function1<? super L, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Either<L, R> either = this.a;
        if (either instanceof Either.Left) {
            function1.invoke((Object) ((Either.Left) either).getA());
        }
    }

    public final L get() {
        Either<L, R> either = this.a;
        if (either instanceof Either.Left) {
            return (L) ((Either.Left) either).getA();
        }
        if (either instanceof Either.Right) {
            throw new NoSuchElementException("Either.left.value on Right");
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final Either<L, R> getE() {
        return this.a;
    }

    @NotNull
    public final <X> Either<X, R> map(@NotNull Function1<? super L, ? extends X> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return LeftProjectionKt.flatMap(this, new a(function1));
    }

    @NotNull
    public final List<L> toList() {
        Either<L, R> either = this.a;
        if (either instanceof Either.Left) {
            return d.listOf(((Either.Left) either).getA());
        }
        if (either instanceof Either.Right) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final Option<L> toOption() {
        Either<L, R> either = this.a;
        if (either instanceof Either.Left) {
            return new Some(((Either.Left) this.a).getA());
        }
        if (either instanceof Either.Right) {
            return None.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
