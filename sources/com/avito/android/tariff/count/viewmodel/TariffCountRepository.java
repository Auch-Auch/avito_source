package com.avito.android.tariff.count.viewmodel;

import com.avito.android.remote.model.DeepLinkResponse;
import com.avito.android.remote.model.TariffCountPriceResult;
import com.avito.android.remote.model.TariffCountResult;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/tariff/count/viewmodel/TariffCountRepository;", "", "", "checkoutContext", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/TariffCountResult;", "getTariffCount", "(Ljava/lang/String;)Lio/reactivex/Observable;", "countId", "Lcom/avito/android/remote/model/DeepLinkResponse;", "selectTariffCount", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/TariffCountPriceResult;", "getCountPrice", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface TariffCountRepository {
    @NotNull
    Observable<LoadingState<TariffCountPriceResult>> getCountPrice(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<LoadingState<TariffCountResult>> getTariffCount(@NotNull String str);

    @NotNull
    Observable<LoadingState<DeepLinkResponse>> selectTariffCount(@NotNull String str, @NotNull String str2);
}
