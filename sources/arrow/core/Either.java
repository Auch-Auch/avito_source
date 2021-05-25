package arrow.core;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import arrow.higherkind;
import arrow.legacy.Disjunction;
import arrow.legacy.LeftProjection;
import arrow.legacy.RightProjection;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@higherkind
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 6*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00028\u00010\u0003j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0005:\u0003678B\t\b\u0002¢\u0006\u0004\b4\u00105J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJB\u0010\u000e\u001a\u00028\u0002\"\u0004\b\u0002\u0010\n2\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000b2\u0014\b\u0004\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000bH\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00028\u0001H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J5\u0010\u0015\u001a\u00028\u0002\"\u0004\b\u0002\u0010\n2\u0006\u0010\u0012\u001a\u00028\u00022\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016JM\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u0017\"\u0004\b\u0002\u0010\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00020\u00172$\u0010\u0014\u001a \u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00170\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ8\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\u0004\b\u0002\u0010\n2\u0014\b\u0004\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000bH\b¢\u0006\u0004\b \u0010!J8\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0002\u0010\n2\u0014\b\u0004\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000bH\b¢\u0006\u0004\b\"\u0010!JT\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0000\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010#2\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000b2\u0014\b\u0004\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\u000bH\b¢\u0006\u0004\b$\u0010%J&\u0010'\u001a\u00020\u00062\u0014\b\u0004\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u000bH\b¢\u0006\u0004\b'\u0010(J\u0013\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010)¢\u0006\u0004\b*\u0010+J\u001b\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010,H\u0007¢\u0006\u0004\b-\u0010.J\u001b\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010/H\u0007¢\u0006\u0004\b0\u00101R\u0016\u0010\u0007\u001a\u00020\u00068 @ X \u0004¢\u0006\u0006\u001a\u0004\b2\u0010\bR\u0016\u0010\t\u001a\u00020\u00068 @ X \u0004¢\u0006\u0006\u001a\u0004\b3\u0010\b\u0001\u00029:¨\u0006;"}, d2 = {"Larrow/core/Either;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Larrow/Kind;", "Larrow/core/ForEither;", "Larrow/core/EitherOf;", "", "isLeft", "()Z", "isRight", "C", "Lkotlin/Function1;", "fa", "fb", "fold", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "get", "()Ljava/lang/Object;", AuthSource.BOOKING_ORDER, "Lkotlin/Function2;", "f", "foldLeft", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Larrow/core/Eval;", "lb", "foldRight", "(Larrow/core/Eval;Lkotlin/jvm/functions/Function2;)Larrow/core/Eval;", "Larrow/legacy/Disjunction;", "toDisjunction", "()Larrow/legacy/Disjunction;", "swap", "()Larrow/core/Either;", "map", "(Lkotlin/jvm/functions/Function1;)Larrow/core/Either;", "mapLeft", "D", "bimap", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Larrow/core/Either;", "predicate", "exists", "(Lkotlin/jvm/functions/Function1;)Z", "Larrow/core/Option;", "toOption", "()Larrow/core/Option;", "Larrow/legacy/LeftProjection;", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "()Larrow/legacy/LeftProjection;", "Larrow/legacy/RightProjection;", "right", "()Larrow/legacy/RightProjection;", "isLeft$arrow_core", "isRight$arrow_core", "<init>", "()V", "Companion", "Left", "Right", "Larrow/core/Either$Left;", "Larrow/core/Either$Right;", "arrow-core"}, k = 1, mv = {1, 4, 0})
public abstract class Either<A, B> implements Kind<Kind<? extends ForEither, ? extends A>, B> {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00050\u0004\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0002¢\u0006\u0004\b\u0003\u0010\u0006J'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00020\u0004\"\u0004\b\u0002\u0010\u00072\u0006\u0010\b\u001a\u00028\u0002¢\u0006\u0004\b\b\u0010\u0006Jx\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00040\u0004\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\t\"\u0004\b\u0004\u0010\n2\u0006\u0010\u000b\u001a\u00028\u00032@\u0010\u0010\u001a<\u0012\u0004\u0012\u00028\u0003\u00122\u00120\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00020\rj\b\u0012\u0004\u0012\u00028\u0002`\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00040\r0\fH\u0010¢\u0006\u0004\b\u0011\u0010\u0012JI\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u00072\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00030\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Larrow/core/Either$Companion;", "", "L", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "Larrow/core/Either;", "", "(Ljava/lang/Object;)Larrow/core/Either;", "R", "right", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", AuthSource.SEND_ABUSE, "Lkotlin/Function1;", "Larrow/Kind;", "Larrow/core/ForEither;", "Larrow/core/EitherPartialOf;", "f", "tailRecM", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Larrow/core/Either;", "", "test", "Lkotlin/Function0;", "r", "l", "cond", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Larrow/core/Either;", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: arrow.core.Either$Companion */
        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final <L, R> Either<L, R> cond(boolean z, @NotNull Function0<? extends R> function0, @NotNull Function0<? extends L> function02) {
            Intrinsics.checkParameterIsNotNull(function0, "r");
            Intrinsics.checkParameterIsNotNull(function02, "l");
            return z ? right(function0.invoke()) : left(function02.invoke());
        }

        @NotNull
        public final <L> Either left(L l) {
            return new Left(l);
        }

        @NotNull
        public final <R> Either right(R r) {
            return new Right(r);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:? */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: A */
        /* JADX DEBUG: Multi-variable search result rejected for r2v16, resolved type: ? super A */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
        @NotNull
        public final <L, A, B> Either<L, B> tailRecM(A a, @NotNull Function1<? super A, ? extends Kind<? extends Kind<ForEither, ? extends L>, ? extends Either<? extends A, ? extends B>>> function1) {
            while (true) {
                Intrinsics.checkParameterIsNotNull(function1, "f");
                Kind kind = (Kind) function1.invoke((Object) a);
                if (kind != null) {
                    Either either = (Either) kind;
                    if (either instanceof Left) {
                        return new Left(((Left) either).getA());
                    }
                    if (either instanceof Right) {
                        Either either2 = (Either) ((Right) either).getB();
                        if (either2 instanceof Left) {
                            a = (Object) ((Left) either2).getA();
                        } else if (either2 instanceof Right) {
                            return new Right(((Right) either2).getB());
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type arrow.core.Either<A, B>");
                }
            }
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u0000 \u001d*\u0006\b\u0002\u0010\u0001 \u0001*\u0006\b\u0003\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003:\u0001\u001dB\u0011\b\u0001\u0012\u0006\u0010\u0006\u001a\u00028\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0004\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118P@\u0010X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u0016\u0010\u001a\u001a\u00020\u00118P@\u0010X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015¨\u0006\u001e"}, d2 = {"Larrow/core/Either$Left;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Larrow/core/Either;", "component1", "()Ljava/lang/Object;", AuthSource.SEND_ABUSE, "copy", "(Ljava/lang/Object;)Larrow/core/Either$Left;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "isRight$arrow_core", "()Z", "isRight", "Ljava/lang/Object;", "getA", "isLeft$arrow_core", "isLeft", "<init>", "(Ljava/lang/Object;)V", "Companion", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Left<A, B> extends Either<A, B> {
        public static final Companion Companion = new Companion(null);
        public final A a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ*\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00020\u00050\u0004\"\u0004\b\u0004\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Larrow/core/Either$Left$Companion;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, AuthSource.SEND_ABUSE, "Larrow/core/Either;", "", "invoke", "(Ljava/lang/Object;)Larrow/core/Either;", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final <A> Either invoke(A a) {
                return new Left(a);
            }

            public Companion(j jVar) {
            }
        }

        @PublishedApi
        public Left(A a3) {
            super(null);
            this.a = a3;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: arrow.core.Either$Left */
        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public static /* bridge */ /* synthetic */ Left copy$default(Left left, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = left.a;
            }
            return left.copy(obj);
        }

        public final A component1() {
            return this.a;
        }

        @NotNull
        public final Left<A, B> copy(A a3) {
            return new Left<>(a3);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Left) && Intrinsics.areEqual(this.a, ((Left) obj).a);
            }
            return true;
        }

        public final A getA() {
            return this.a;
        }

        public int hashCode() {
            A a3 = this.a;
            if (a3 != null) {
                return a3.hashCode();
            }
            return 0;
        }

        @Override // arrow.core.Either
        public boolean isLeft$arrow_core() {
            return true;
        }

        @Override // arrow.core.Either
        public boolean isRight$arrow_core() {
            return false;
        }

        public String toString() {
            return a.r(a.L("Left(a="), this.a, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u0000 \u001e*\u0006\b\u0002\u0010\u0001 \u0001*\u0006\b\u0003\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003:\u0001\u001eB\u0011\b\u0001\u0012\u0006\u0010\u0006\u001a\u00028\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0004\u001a\u00028\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\u00028\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\u0016\u0010\u0019\u001a\u00020\u00118P@\u0010X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00118P@\u0010X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001f"}, d2 = {"Larrow/core/Either$Right;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Larrow/core/Either;", "component1", "()Ljava/lang/Object;", AuthSource.BOOKING_ORDER, "copy", "(Ljava/lang/Object;)Larrow/core/Either$Right;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getB", "isRight$arrow_core", "()Z", "isRight", "isLeft$arrow_core", "isLeft", "<init>", "(Ljava/lang/Object;)V", "Companion", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Right<A, B> extends Either<A, B> {
        public static final Companion Companion = new Companion(null);
        public final B a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ*\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00040\u0004\"\u0004\b\u0004\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Larrow/core/Either$Right$Companion;", "", "B", AuthSource.BOOKING_ORDER, "Larrow/core/Either;", "", "invoke", "(Ljava/lang/Object;)Larrow/core/Either;", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final <B> Either invoke(B b) {
                return new Right(b);
            }

            public Companion(j jVar) {
            }
        }

        @PublishedApi
        public Right(B b) {
            super(null);
            this.a = b;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: arrow.core.Either$Right */
        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public static /* bridge */ /* synthetic */ Right copy$default(Right right, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = right.a;
            }
            return right.copy(obj);
        }

        public final B component1() {
            return this.a;
        }

        @NotNull
        public final Right<A, B> copy(B b) {
            return new Right<>(b);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Right) && Intrinsics.areEqual(this.a, ((Right) obj).a);
            }
            return true;
        }

        public final B getB() {
            return this.a;
        }

        public int hashCode() {
            B b = this.a;
            if (b != null) {
                return b.hashCode();
            }
            return 0;
        }

        @Override // arrow.core.Either
        public boolean isLeft$arrow_core() {
            return false;
        }

        @Override // arrow.core.Either
        public boolean isRight$arrow_core() {
            return true;
        }

        public String toString() {
            return a.r(a.L("Right(b="), this.a, ")");
        }
    }

    public Either() {
    }

    @NotNull
    public final <C, D> Either<C, D> bimap(@NotNull Function1<? super A, ? extends C> function1, @NotNull Function1<? super B, ? extends D> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "fa");
        Intrinsics.checkParameterIsNotNull(function12, "fb");
        if (this instanceof Right) {
            return new Right(function12.invoke((Object) ((Right) this).getB()));
        }
        if (this instanceof Left) {
            return new Left(function1.invoke((Object) ((Left) this).getA()));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean exists(@NotNull Function1<? super B, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if (this instanceof Right) {
            return function1.invoke((Object) ((Right) this).getB()).booleanValue();
        }
        if (this instanceof Left) {
            ((Left) this).getA();
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final <C> C fold(@NotNull Function1<? super A, ? extends C> function1, @NotNull Function1<? super B, ? extends C> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "fa");
        Intrinsics.checkParameterIsNotNull(function12, "fb");
        if (this instanceof Right) {
            return (C) function12.invoke((Object) ((Right) this).getB());
        }
        if (this instanceof Left) {
            return (C) function1.invoke((Object) ((Left) this).getA());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final <C> C foldLeft(C c, @NotNull Function2<? super C, ? super B, ? extends C> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "f");
        if (this instanceof Right) {
            return (C) function2.invoke(c, (Object) ((Right) this).getB());
        }
        if (this instanceof Left) {
            return c;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: arrow.core.Eval<? extends C> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <C> Eval<C> foldRight(@NotNull Eval<? extends C> eval, @NotNull Function2<? super B, ? super Eval<? extends C>, ? extends Eval<? extends C>> function2) {
        Intrinsics.checkParameterIsNotNull(eval, "lb");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        if (this instanceof Right) {
            return (Eval) function2.invoke((Object) ((Right) this).getB(), eval);
        }
        if (this instanceof Left) {
            return eval;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Deprecated(message = UtilsKt.DeprecatedUnsafeAccess, replaceWith = @ReplaceWith(expression = "getOrElse { ifLeft }", imports = {}))
    public final B get() {
        if (this instanceof Right) {
            return (B) ((Right) this).getB();
        }
        if (this instanceof Left) {
            throw new NoSuchElementException("Disjunction.Left");
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isLeft() {
        return isLeft$arrow_core();
    }

    public abstract boolean isLeft$arrow_core();

    public final boolean isRight() {
        return isRight$arrow_core();
    }

    public abstract boolean isRight$arrow_core();

    @Deprecated(message = "arrow.data.Either is right biased. This method will be removed in future releases")
    @NotNull
    public final LeftProjection<A, B> left() {
        return new LeftProjection<>(this);
    }

    @NotNull
    public final <C> Either<A, C> map(@NotNull Function1<? super B, ? extends C> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (this instanceof Right) {
            return new Right(function1.invoke((Object) ((Right) this).getB()));
        }
        if (this instanceof Left) {
            return new Left(((Left) this).getA());
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final <C> Either<C, B> mapLeft(@NotNull Function1<? super A, ? extends C> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (this instanceof Right) {
            return new Right(((Right) this).getB());
        }
        if (this instanceof Left) {
            return new Left(function1.invoke((Object) ((Left) this).getA()));
        }
        throw new NoWhenBranchMatchedException();
    }

    @Deprecated(message = "arrow.data.Either is right biased. This method will be removed in future releases")
    @NotNull
    public final RightProjection<A, B> right() {
        return new RightProjection<>(this);
    }

    @NotNull
    public final Either<B, A> swap() {
        if (this instanceof Right) {
            return new Left(((Right) this).getB());
        }
        if (this instanceof Left) {
            return new Right(((Left) this).getA());
        }
        throw new NoWhenBranchMatchedException();
    }

    @Deprecated(message = "arrow.data.Either is right biased. This method will be removed in future releases")
    @NotNull
    public final Disjunction<A, B> toDisjunction() {
        if (this instanceof Right) {
            return new Disjunction.Right(((Right) this).getB());
        }
        if (this instanceof Left) {
            return new Disjunction.Left(((Left) this).getA());
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final Option<B> toOption() {
        if (this instanceof Right) {
            return new Some(((Right) this).getB());
        }
        if (this instanceof Left) {
            ((Left) this).getA();
            return None.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public Either(j jVar) {
    }
}
