package com.sumsub.sns.core.data.source.log;

import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.data.model.LogParams;
import com.sumsub.sns.core.data.model.LogParamsKt;
import com.sumsub.sns.core.data.model.LogType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/core/data/source/log/RealLogRepository;", "Lcom/sumsub/sns/core/data/source/log/LogRepository;", "Lcom/sumsub/sns/core/data/model/LogType;", "type", "Lcom/sumsub/sns/core/data/model/LogParams;", "params", "", "send", "(Lcom/sumsub/sns/core/data/model/LogType;Lcom/sumsub/sns/core/data/model/LogParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/log/LogService;", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/source/log/LogService;", "remote", "<init>", "(Lcom/sumsub/sns/core/data/source/log/LogService;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class RealLogRepository implements LogRepository {
    public final LogService a;

    public RealLogRepository(@NotNull LogService logService) {
        Intrinsics.checkNotNullParameter(logService, "remote");
        this.a = logService;
    }

    @Override // com.sumsub.sns.core.data.source.log.LogRepository
    @Nullable
    public Object send(@NotNull LogType logType, @NotNull LogParams logParams, @NotNull Continuation<? super Unit> continuation) {
        Object send = this.a.send(logType.getValue(), LogParamsKt.toMap(logParams), continuation);
        return send == a.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
    }
}
