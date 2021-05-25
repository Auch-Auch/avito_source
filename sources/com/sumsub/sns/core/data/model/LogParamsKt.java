package com.sumsub.sns.core.data.model;

import com.avito.android.remote.model.messenger.message.MessageBody;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/core/data/model/LogParams;", "", "", "toMap", "(Lcom/sumsub/sns/core/data/model/LogParams;)Ljava/util/Map;", "sns-core_release"}, k = 2, mv = {1, 4, 2})
public final class LogParamsKt {
    @NotNull
    public static final Map<String, String> toMap(@NotNull LogParams logParams) {
        Intrinsics.checkNotNullParameter(logParams, "$this$toMap");
        return r.mapOf(TuplesKt.to("errorType", logParams.getErrorType()), TuplesKt.to("location", logParams.getLocation()), TuplesKt.to("externalUserId", logParams.getExternalUserId()), TuplesKt.to("fileName", logParams.getFileName()), TuplesKt.to("applicantId", logParams.getApplicantId()), TuplesKt.to("message", logParams.getMessage()), TuplesKt.to(MessageBody.Location.KIND, logParams.getKind()), TuplesKt.to("stacktrace", logParams.getStacktrace()));
    }
}
