package com.sumsub.sns.core.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/core/common/SNSErrorListener;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", OkListener.KEY_EXCEPTION, "", "onThrowError", "(Ljava/lang/Exception;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public interface SNSErrorListener {
    void onThrowError(@NotNull Exception exc);
}
