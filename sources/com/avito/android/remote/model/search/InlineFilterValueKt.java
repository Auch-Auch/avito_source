package com.avito.android.remote.model.search;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006\"\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0006\"\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0006\"\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0006\"\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006\"\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u0006\"\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/search/InlineFilterValue;", "", "isNotEmpty", "(Lcom/avito/android/remote/model/search/InlineFilterValue;)Z", "", "CHANGED_PARAM_RANGE_FROM", "Ljava/lang/String;", "CHANGED_PARAM_LIST_VALUE", "CHANGED_PARAM_INT_VALUE", "CHANGED_PARAM_VALUE", "CHANGED_PARAM_RANGE_INT_FROM", "CHANGED_PARAM_RANGE_INT_TO", "CHANGED_PARAM_RANGE_TO", "DEFAULT_FORMAT", "models_release"}, k = 2, mv = {1, 4, 2})
public final class InlineFilterValueKt {
    private static final String CHANGED_PARAM_INT_VALUE = "changedParamValueInt";
    private static final String CHANGED_PARAM_LIST_VALUE = "changedParamValueList";
    private static final String CHANGED_PARAM_RANGE_FROM = "changedParamValueFrom";
    private static final String CHANGED_PARAM_RANGE_INT_FROM = "changedParamValueIntFrom";
    private static final String CHANGED_PARAM_RANGE_INT_TO = "changedParamValueIntTo";
    private static final String CHANGED_PARAM_RANGE_TO = "changedParamValueTo";
    private static final String CHANGED_PARAM_VALUE = "changedParamValue";
    private static final String DEFAULT_FORMAT = "yyyy-MM-dd";

    public static final boolean isNotEmpty(@Nullable InlineFilterValue inlineFilterValue) {
        return inlineFilterValue != null && (inlineFilterValue.isEmpty() ^ true);
    }
}
