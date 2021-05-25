package com.sumsub.sns.core.domain.model;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.UserDataStore;
import com.sumsub.sns.core.domain.model.Either;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aO\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u001a[\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\t*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n2\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00028\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\n0\u0003¢\u0006\u0004\b\f\u0010\r\u001aO\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\t*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "Lkotlin/Function1;", "f", "c", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "T", "L", "R", "Lcom/sumsub/sns/core/domain/model/Either;", UserDataStore.FIRST_NAME, "flatMap", "(Lcom/sumsub/sns/core/domain/model/Either;Lkotlin/jvm/functions/Function1;)Lcom/sumsub/sns/core/domain/model/Either;", "map", "sns-core_release"}, k = 2, mv = {1, 4, 2})
public final class EitherKt {

    public static final class a extends Lambda implements Function1<A, C> {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ Function1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function1 function1, Function1 function12) {
            super(1);
            this.a = function1;
            this.b = function12;
        }

        @Override // kotlin.jvm.functions.Function1
        public final C invoke(A a3) {
            return (C) this.b.invoke(this.a.invoke(a3));
        }
    }

    @NotNull
    public static final <A, B, C> Function1<A, C> c(@NotNull Function1<? super A, ? extends B> function1, @NotNull Function1<? super B, ? extends C> function12) {
        Intrinsics.checkNotNullParameter(function1, "$this$c");
        Intrinsics.checkNotNullParameter(function12, "f");
        return new a(function1, function12);
    }

    @NotNull
    public static final <T, L, R> Either<L, T> flatMap(@NotNull Either<? extends L, ? extends R> either, @NotNull Function1<? super R, ? extends Either<? extends L, ? extends T>> function1) {
        Intrinsics.checkNotNullParameter(either, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, UserDataStore.FIRST_NAME);
        if (either instanceof Either.Left) {
            return new Either.Left(((Either.Left) either).getA());
        }
        if (either instanceof Either.Right) {
            return (Either) function1.invoke((Object) ((Either.Right) either).getB());
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final <T, L, R> Either<L, T> map(@NotNull Either<? extends L, ? extends R> either, @NotNull Function1<? super R, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(either, "$this$map");
        Intrinsics.checkNotNullParameter(function1, UserDataStore.FIRST_NAME);
        return flatMap(either, c(function1, new Function1<T, Either.Right<? extends T>>(either) { // from class: com.sumsub.sns.core.domain.model.EitherKt.b
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return ((Either) this.receiver).right(obj);
            }
        }));
    }
}
