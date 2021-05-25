package com.sumsub.sns.core.data.model;

import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSInvalidParametersException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getMessages", "()Ljava/util/List;", "messages", "<init>", "(Ljava/util/List;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class SNSInvalidParametersException extends Exception {
    @NotNull
    public final List<String> a;

    public SNSInvalidParametersException(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "messages");
        this.a = list;
    }

    @NotNull
    public final List<String> getMessages() {
        return this.a;
    }
}
