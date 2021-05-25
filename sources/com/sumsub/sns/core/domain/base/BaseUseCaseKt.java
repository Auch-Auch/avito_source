package com.sumsub.sns.core.domain.base;

import com.sumsub.sns.core.domain.model.Either;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001af\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\u0003H\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u0007\n\u0005\b20\u0001¨\u0006\f"}, d2 = {"L", "R", "Lcom/sumsub/sns/core/domain/model/Either;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "onError", "onSuccess", "handle", "(Lcom/sumsub/sns/core/domain/model/Either;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "sns-core_release"}, k = 2, mv = {1, 4, 2})
public final class BaseUseCaseKt {
    public static final <L, R> void handle(@NotNull Either<? extends L, ? extends R> either, @NotNull Function1<? super L, Unit> function1, @NotNull Function1<? super R, Unit> function12) {
        Intrinsics.checkNotNullParameter(either, "$this$handle");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Intrinsics.checkNotNullParameter(function12, "onSuccess");
        if (either.isRight()) {
            function12.invoke((Object) ((Either.Right) either).getB());
        } else if (either.isLeft()) {
            function1.invoke((Object) ((Either.Left) either).getA());
        }
    }
}
