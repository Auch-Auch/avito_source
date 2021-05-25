package com.sumsub.sns.core.domain.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b&\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u0001*\u0006\b\u0001\u0010\u0003 \u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/sumsub/sns/core/domain/base/BaseDirectUseCase;", "", "Type", "Params", "params", "run", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseDirectUseCase<Type, Params> {
    @Nullable
    public abstract Object run(Params params, @NotNull Continuation<? super Type> continuation);
}
