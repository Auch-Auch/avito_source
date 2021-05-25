package arrow.legacy;

import a2.b.a.a.a;
import arrow.core.Either;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import arrow.legacy.LeftLike;
import arrow.legacy.RightLike;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 '*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003:\u0003'()B\t\b\u0002¢\u0006\u0004\b%\u0010&J\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000H¦\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0001H¦\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u0007\u0010\bJ;\u0010\r\u001a\u00028\u0002\"\u0004\b\u0002\u0010\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00028\u0001¢\u0006\u0004\b\u000f\u0010\u0005J!\u0010\u0012\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00100\n¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00140\n¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\u0004\b\u0002\u0010\t2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J3\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u001a2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00140\n¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u001a¢\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"¢\u0006\u0004\b#\u0010$\u0001\u0002*+¨\u0006,"}, d2 = {"Larrow/legacy/Disjunction;", "L", "R", "Larrow/legacy/EitherLike;", "component1", "()Ljava/lang/Object;", "component2", "swap", "()Larrow/legacy/Disjunction;", "X", "Lkotlin/Function1;", "fl", "fr", "fold", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "get", "", "f", "forEach", "(Lkotlin/jvm/functions/Function1;)V", "", "predicate", "exists", "(Lkotlin/jvm/functions/Function1;)Z", "map", "(Lkotlin/jvm/functions/Function1;)Larrow/legacy/Disjunction;", "Larrow/core/Option;", "filter", "(Lkotlin/jvm/functions/Function1;)Larrow/core/Option;", "", "toList", "()Ljava/util/List;", "toOption", "()Larrow/core/Option;", "Larrow/core/Either;", "toEither", "()Larrow/core/Either;", "<init>", "()V", "Companion", "Left", "Right", "Larrow/legacy/Disjunction$Left;", "Larrow/legacy/Disjunction$Right;", "arrow-core"}, k = 1, mv = {1, 4, 0})
@Deprecated(message = "arrow.data.Either is already right biased. This data type will be removed in future releases")
public abstract class Disjunction<L, R> implements EitherLike {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00050\u0004\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0002¢\u0006\u0004\b\u0003\u0010\u0006J'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00020\t\"\u0004\b\u0002\u0010\u00072\u0006\u0010\b\u001a\u00028\u0002¢\u0006\u0004\b\b\u0010\n¨\u0006\r"}, d2 = {"Larrow/legacy/Disjunction$Companion;", "", "L", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "Larrow/legacy/Disjunction$Left;", "", "(Ljava/lang/Object;)Larrow/legacy/Disjunction$Left;", "R", "right", "Larrow/legacy/Disjunction$Right;", "(Ljava/lang/Object;)Larrow/legacy/Disjunction$Right;", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final <L> Left left(L l) {
            return new Left(l);
        }

        @NotNull
        public final <R> Right right(R r) {
            return new Right(r);
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u0001*\u0006\b\u0003\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0016\u001a\u00028\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00028\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0019"}, d2 = {"Larrow/legacy/Disjunction$Left;", "L", "R", "Larrow/legacy/Disjunction;", "Larrow/legacy/LeftLike;", "component1", "()Ljava/lang/Object;", "component2", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getValue", "value", "<init>", "(Ljava/lang/Object;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Left<L, R> extends Disjunction<L, R> implements LeftLike {
        public final L a;

        public Left(L l) {
            super(null);
            this.a = l;
        }

        @Override // arrow.legacy.Disjunction
        public L component1() {
            return this.a;
        }

        @Override // arrow.legacy.Disjunction
        @Nullable
        public R component2() {
            return null;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Left) {
                return Intrinsics.areEqual((Object) this.a, (Object) ((Left) obj).a);
            }
            return false;
        }

        public final L getValue() {
            return this.a;
        }

        public int hashCode() {
            L l = this.a;
            if (l == null) {
                return 43;
            }
            return l.hashCode() * 43;
        }

        @Override // arrow.legacy.EitherLike, arrow.legacy.LeftLike
        public boolean isLeft() {
            return LeftLike.DefaultImpls.isLeft(this);
        }

        @Override // arrow.legacy.EitherLike, arrow.legacy.LeftLike
        public boolean isRight() {
            return LeftLike.DefaultImpls.isRight(this);
        }

        @NotNull
        public String toString() {
            return a.q(a.L("Disjunction.Left("), this.a, ')');
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u0001*\u0006\b\u0003\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0016\u001a\u00028\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00028\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00028\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0019"}, d2 = {"Larrow/legacy/Disjunction$Right;", "L", "R", "Larrow/legacy/Disjunction;", "Larrow/legacy/RightLike;", "component1", "()Ljava/lang/Object;", "component2", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getValue", "value", "<init>", "(Ljava/lang/Object;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Right<L, R> extends Disjunction<L, R> implements RightLike {
        public final R a;

        public Right(R r) {
            super(null);
            this.a = r;
        }

        @Override // arrow.legacy.Disjunction
        @Nullable
        public L component1() {
            return null;
        }

        @Override // arrow.legacy.Disjunction
        public R component2() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Right) {
                return Intrinsics.areEqual((Object) this.a, (Object) ((Right) obj).a);
            }
            return false;
        }

        public final R getValue() {
            return this.a;
        }

        public int hashCode() {
            R r = this.a;
            if (r == null) {
                return 43;
            }
            return r.hashCode() * 43;
        }

        @Override // arrow.legacy.EitherLike, arrow.legacy.LeftLike
        public boolean isLeft() {
            return RightLike.DefaultImpls.isLeft(this);
        }

        @Override // arrow.legacy.EitherLike, arrow.legacy.LeftLike
        public boolean isRight() {
            return RightLike.DefaultImpls.isRight(this);
        }

        @NotNull
        public String toString() {
            return a.q(a.L("Disjunction.Right("), this.a, ')');
        }
    }

    public Disjunction() {
    }

    @Nullable
    public abstract L component1();

    @Nullable
    public abstract R component2();

    public final boolean exists(@NotNull Function1<? super R, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if (this instanceof Right) {
            return function1.invoke((Object) ((Right) this).getValue()).booleanValue();
        }
        if (this instanceof Left) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final Option<Disjunction<L, R>> filter(@NotNull Function1<? super R, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if (this instanceof Right) {
            if (function1.invoke((Object) ((Right) this).getValue()).booleanValue()) {
                return new Some(this);
            }
            return None.INSTANCE;
        } else if (this instanceof Left) {
            return None.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final <X> X fold(@NotNull Function1<? super L, ? extends X> function1, @NotNull Function1<? super R, ? extends X> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "fl");
        Intrinsics.checkParameterIsNotNull(function12, "fr");
        if (this instanceof Right) {
            return (X) function12.invoke((Object) ((Right) this).getValue());
        }
        if (this instanceof Left) {
            return (X) function1.invoke((Object) ((Left) this).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void forEach(@NotNull Function1<? super R, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (this instanceof Right) {
            function1.invoke((Object) ((Right) this).getValue());
        }
    }

    public final R get() {
        if (this instanceof Right) {
            return (R) ((Right) this).getValue();
        }
        if (this instanceof Left) {
            throw new NoSuchElementException("Disjunction.Left");
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final <X> Disjunction<L, X> map(@NotNull Function1<? super R, ? extends X> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (this instanceof Right) {
            return new Right(function1.invoke((Object) ((Right) this).getValue()));
        }
        if (this instanceof Left) {
            return new Left(((Left) this).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final Disjunction<R, L> swap() {
        if (this instanceof Right) {
            return new Left(((Right) this).getValue());
        }
        if (this instanceof Left) {
            return new Right(((Left) this).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final Either<L, R> toEither() {
        if (this instanceof Right) {
            return new Either.Right(((Right) this).getValue());
        }
        if (this instanceof Left) {
            return new Either.Left(((Left) this).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final List<R> toList() {
        if (this instanceof Right) {
            return d.listOf(((Right) this).getValue());
        }
        if (this instanceof Left) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final Option<R> toOption() {
        if (this instanceof Right) {
            return new Some(((Right) this).getValue());
        }
        if (this instanceof Left) {
            return None.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public Disjunction(j jVar) {
    }
}
