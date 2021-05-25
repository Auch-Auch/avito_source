package com.sumsub.sns.core.data.source.log;

import com.sumsub.sns.core.data.model.LogParams;
import com.sumsub.sns.core.data.model.LogType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/sumsub/sns/core/data/source/log/LogRepository;", "", "Lcom/sumsub/sns/core/data/model/LogType;", "type", "Lcom/sumsub/sns/core/data/model/LogParams;", "params", "", "send", "(Lcom/sumsub/sns/core/data/model/LogType;Lcom/sumsub/sns/core/data/model/LogParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public interface LogRepository {
    @Nullable
    Object send(@NotNull LogType logType, @NotNull LogParams logParams, @NotNull Continuation<? super Unit> continuation);
}
