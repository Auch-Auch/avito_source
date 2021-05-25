package com.sumsub.sns.core.domain.model;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003:\u0002\u0017\u0018B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005\"\u0004\b\u0002\u0010\u00012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\t\"\u0004\b\u0002\u0010\u00022\u0006\u0010\b\u001a\u00028\u0002¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\u000f\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0012\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013\u0001\u0002\u0005\t¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/core/domain/model/Either;", "L", "R", "", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/domain/model/Either$Left;", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "(Ljava/lang/Object;)Lcom/sumsub/sns/core/domain/model/Either$Left;", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/domain/model/Either$Right;", "right", "(Ljava/lang/Object;)Lcom/sumsub/sns/core/domain/model/Either$Right;", "Lkotlin/Function1;", "fnL", "fnR", "either", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "isRight", "()Z", "isLeft", "<init>", "()V", "Left", "Right", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class Either<L, R> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00028\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/core/domain/model/Either$Left;", "L", "Lcom/sumsub/sns/core/domain/model/Either;", "", "component1", "()Ljava/lang/Object;", AuthSource.SEND_ABUSE, "copy", "(Ljava/lang/Object;)Lcom/sumsub/sns/core/domain/model/Either$Left;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getA", "<init>", "(Ljava/lang/Object;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Left<L> extends Either {
        public final L a;

        public Left(L l) {
            super(null);
            this.a = l;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.core.domain.model.Either$Left */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Left copy$default(Left left, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = left.a;
            }
            return left.copy(obj);
        }

        public final L component1() {
            return this.a;
        }

        @NotNull
        public final Left<L> copy(L l) {
            return new Left<>(l);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Left) && Intrinsics.areEqual(this.a, ((Left) obj).a);
            }
            return true;
        }

        public final L getA() {
            return this.a;
        }

        public int hashCode() {
            L l = this.a;
            if (l != null) {
                return l.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.r(a.L("Left(a="), this.a, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00020\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00028\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0004\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/core/domain/model/Either$Right;", "R", "Lcom/sumsub/sns/core/domain/model/Either;", "", "component1", "()Ljava/lang/Object;", AuthSource.BOOKING_ORDER, "copy", "(Ljava/lang/Object;)Lcom/sumsub/sns/core/domain/model/Either$Right;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getB", "<init>", "(Ljava/lang/Object;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Right<R> extends Either {
        public final R a;

        public Right(R r) {
            super(null);
            this.a = r;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.core.domain.model.Either$Right */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Right copy$default(Right right, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = right.a;
            }
            return right.copy(obj);
        }

        public final R component1() {
            return this.a;
        }

        @NotNull
        public final Right<R> copy(R r) {
            return new Right<>(r);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Right) && Intrinsics.areEqual(this.a, ((Right) obj).a);
            }
            return true;
        }

        public final R getB() {
            return this.a;
        }

        public int hashCode() {
            R r = this.a;
            if (r != null) {
                return r.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.r(a.L("Right(b="), this.a, ")");
        }
    }

    public Either() {
    }

    @NotNull
    public final Object either(@NotNull Function1<? super L, ? extends Object> function1, @NotNull Function1<? super R, ? extends Object> function12) {
        Intrinsics.checkNotNullParameter(function1, "fnL");
        Intrinsics.checkNotNullParameter(function12, "fnR");
        if (this instanceof Left) {
            return function1.invoke((Object) ((Left) this).getA());
        }
        if (this instanceof Right) {
            return function12.invoke((Object) ((Right) this).getB());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isLeft() {
        return this instanceof Left;
    }

    public final boolean isRight() {
        return this instanceof Right;
    }

    @NotNull
    public final <L> Left<L> left(L l) {
        return new Left<>(l);
    }

    @NotNull
    public final <R> Right<R> right(R r) {
        return new Right<>(r);
    }

    public Either(j jVar) {
    }
}
