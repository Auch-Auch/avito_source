package com.avito.android.advert_core.car_market_price.price_description;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PriceFeatureSwitch;
import com.avito.android.remote.model.SwitchType;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceSwitchConverterImpl;", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceSwitchConverter;", "", "Lcom/avito/android/remote/model/PriceFeatureSwitch;", "featureSwitches", "Lcom/avito/android/remote/model/SwitchType;", "selectedSwitchType", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceSwitchModel;", "convert", "(Ljava/util/List;Lcom/avito/android/remote/model/SwitchType;)Ljava/util/List;", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionResourceProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionResourceProvider;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class CarMarketPriceSwitchConverterImpl implements CarMarketPriceSwitchConverter {
    public final CarMarketPriceDescriptionResourceProvider a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SwitchType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            SwitchType switchType = SwitchType.PROS;
            iArr[0] = 1;
            SwitchType switchType2 = SwitchType.CONS;
            iArr[1] = 2;
        }
    }

    @Inject
    public CarMarketPriceSwitchConverterImpl(@NotNull CarMarketPriceDescriptionResourceProvider carMarketPriceDescriptionResourceProvider) {
        Intrinsics.checkNotNullParameter(carMarketPriceDescriptionResourceProvider, "resourceProvider");
        this.a = carMarketPriceDescriptionResourceProvider;
    }

    @Override // com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceSwitchConverter
    @NotNull
    public List<CarMarketPriceSwitchModel> convert(@NotNull List<PriceFeatureSwitch> list, @Nullable SwitchType switchType) {
        Integer num;
        Intrinsics.checkNotNullParameter(list, "featureSwitches");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            boolean z = switchType != null ? t2.getType() == switchType : i == 0;
            List<String> features = t2.getFeatures();
            boolean z2 = features == null || features.isEmpty();
            SwitchType type = t2.getType();
            if (type != null) {
                int ordinal = type.ordinal();
                if (ordinal == 0) {
                    num = Integer.valueOf(this.a.getCarMarketPriceProsStubIcon());
                } else if (ordinal == 1) {
                    num = Integer.valueOf(this.a.getCarMarketPriceConsStubIcon());
                }
                arrayList.add(new CarMarketPriceSwitchModel(t2.getTitle(), t2.getType(), t2.getFeatures(), z2, num, t2.getFallback(), z));
                i = i2;
            }
            num = null;
            arrayList.add(new CarMarketPriceSwitchModel(t2.getTitle(), t2.getType(), t2.getFeatures(), z2, num, t2.getFallback(), z));
            i = i2;
        }
        return arrayList;
    }
}
