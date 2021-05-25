package com.avito.android.tariff.count.viewmodel;

import com.avito.android.remote.model.TariffCountPrice;
import com.avito.android.remote.model.TariffCountPriceResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/tariff/count/viewmodel/PriceConverter;", "", "Lcom/avito/android/remote/model/TariffCountPriceResult;", "priceResult", "Lcom/avito/android/tariff/count/viewmodel/TariffCountCost;", "convertPrice", "(Lcom/avito/android/remote/model/TariffCountPriceResult;)Lcom/avito/android/tariff/count/viewmodel/TariffCountCost;", "Lcom/avito/android/remote/model/TariffCountPrice;", "countPrice", "(Lcom/avito/android/remote/model/TariffCountPrice;)Lcom/avito/android/tariff/count/viewmodel/TariffCountCost;", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface PriceConverter {
    @NotNull
    TariffCountCost convertPrice(@NotNull TariffCountPrice tariffCountPrice);

    @NotNull
    TariffCountCost convertPrice(@NotNull TariffCountPriceResult tariffCountPriceResult);
}
