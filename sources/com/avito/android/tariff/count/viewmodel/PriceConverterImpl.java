package com.avito.android.tariff.count.viewmodel;

import com.avito.android.remote.model.TariffCountPrice;
import com.avito.android.remote.model.TariffCountPriceResult;
import com.avito.android.tariff.count.item.bonus.BonusItem;
import com.avito.android.tariff.count.recycler.TariffCountPayloadCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/tariff/count/viewmodel/PriceConverterImpl;", "Lcom/avito/android/tariff/count/viewmodel/PriceConverter;", "Lcom/avito/android/remote/model/TariffCountPrice;", "countPrice", "Lcom/avito/android/tariff/count/viewmodel/TariffCountCost;", "convertPrice", "(Lcom/avito/android/remote/model/TariffCountPrice;)Lcom/avito/android/tariff/count/viewmodel/TariffCountCost;", "Lcom/avito/android/remote/model/TariffCountPriceResult;", "priceResult", "(Lcom/avito/android/remote/model/TariffCountPriceResult;)Lcom/avito/android/tariff/count/viewmodel/TariffCountCost;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class PriceConverterImpl implements PriceConverter {
    @Override // com.avito.android.tariff.count.viewmodel.PriceConverter
    @NotNull
    public TariffCountCost convertPrice(@NotNull TariffCountPrice tariffCountPrice) {
        Intrinsics.checkNotNullParameter(tariffCountPrice, "countPrice");
        Price price = new Price(tariffCountPrice.getPrice(), tariffCountPrice.getOldPrice());
        TariffCountPrice.Bonus bonus = tariffCountPrice.getBonus();
        return new TariffCountCost(price, bonus != null ? new BonusItem(TariffCountPayloadCreator.PAYLOAD_BONUS, bonus.getTitle(), bonus.getDescription()) : null);
    }

    @Override // com.avito.android.tariff.count.viewmodel.PriceConverter
    @NotNull
    public TariffCountCost convertPrice(@NotNull TariffCountPriceResult tariffCountPriceResult) {
        Intrinsics.checkNotNullParameter(tariffCountPriceResult, "priceResult");
        return convertPrice(tariffCountPriceResult.getCountPrice());
    }
}
