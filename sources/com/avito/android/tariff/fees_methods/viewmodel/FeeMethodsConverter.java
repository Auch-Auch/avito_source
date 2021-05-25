package com.avito.android.tariff.fees_methods.viewmodel;

import com.avito.android.remote.model.FeeMethodsResult;
import com.avito.android.remote.model.LimitsInfo;
import com.avito.android.util.LoadingState;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u00060\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsConverter;", "", "Lcom/avito/android/util/LoadingState;", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/FeeMethodsResult;", "Lcom/avito/android/remote/model/LimitsInfo;", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeesScreenResponse;", CommonKt.EXTRA_RESPONSE, "Lcom/avito/android/tariff/fees_methods/viewmodel/FeesScreenState;", "convert", "(Lcom/avito/android/util/LoadingState;)Lcom/avito/android/util/LoadingState;", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface FeeMethodsConverter {
    @NotNull
    LoadingState<FeesScreenState> convert(@NotNull LoadingState<? super Pair<FeeMethodsResult, LimitsInfo>> loadingState);
}
