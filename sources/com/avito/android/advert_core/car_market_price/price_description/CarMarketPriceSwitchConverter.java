package com.avito.android.advert_core.car_market_price.price_description;

import com.avito.android.remote.model.PriceFeatureSwitch;
import com.avito.android.remote.model.SwitchType;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceSwitchConverter;", "", "", "Lcom/avito/android/remote/model/PriceFeatureSwitch;", "featureSwitches", "Lcom/avito/android/remote/model/SwitchType;", "selectedSwitchType", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceSwitchModel;", "convert", "(Ljava/util/List;Lcom/avito/android/remote/model/SwitchType;)Ljava/util/List;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface CarMarketPriceSwitchConverter {
    @NotNull
    List<CarMarketPriceSwitchModel> convert(@NotNull List<PriceFeatureSwitch> list, @Nullable SwitchType switchType);
}
