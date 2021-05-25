package com.sumsub.sns.core.common;

import androidx.annotation.StringRes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/common/StringResourceRepository;", "", "", "resourceId", "", "getString", "(I)Ljava/lang/CharSequence;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public interface StringResourceRepository {
    @NotNull
    CharSequence getString(@StringRes int i);
}
