package com.avito.android.tariff.fees_methods.viewmodel;

import com.avito.android.remote.model.FeeMethodsResult;
import com.avito.android.remote.model.LimitsInfo;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\n\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0002`\t0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsRepository;", "", "", "checkoutContext", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/FeeMethodsResult;", "Lcom/avito/android/remote/model/LimitsInfo;", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeesScreenResponse;", "getFeeMethods", "(Ljava/lang/String;)Lio/reactivex/Observable;", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface FeeMethodsRepository {
    @NotNull
    Observable<LoadingState<Pair<FeeMethodsResult, LimitsInfo>>> getFeeMethods(@NotNull String str);
}
