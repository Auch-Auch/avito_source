package com.avito.android.advert_core.car_market_price.price_description;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PriceDescription;
import com.avito.android.remote.model.SwitchType;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionPresenterImpl;", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionPresenter;", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionView;", "view", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionView;Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionItem;I)V", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceSwitchModel;", "switch", AuthSource.SEND_ABUSE, "(Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionView;Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceSwitchModel;)V", "Lcom/avito/android/remote/model/SwitchType;", "Lcom/avito/android/remote/model/SwitchType;", "lastSelectedType", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceSwitchConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceSwitchConverter;", "priceSwitchConverter", "<init>", "(Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceSwitchConverter;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class CarMarketPriceDescriptionPresenterImpl implements CarMarketPriceDescriptionPresenter {
    public SwitchType a;
    public final CarMarketPriceSwitchConverter b;

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

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CarMarketPriceSwitchModel a;
        public final /* synthetic */ CarMarketPriceDescriptionPresenterImpl b;
        public final /* synthetic */ List c;
        public final /* synthetic */ CarMarketPriceDescriptionView d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CarMarketPriceSwitchModel carMarketPriceSwitchModel, CarMarketPriceDescriptionPresenterImpl carMarketPriceDescriptionPresenterImpl, List list, CarMarketPriceDescriptionView carMarketPriceDescriptionView) {
            super(0);
            this.a = carMarketPriceSwitchModel;
            this.b = carMarketPriceDescriptionPresenterImpl;
            this.c = list;
            this.d = carMarketPriceDescriptionView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (!this.a.isActivated()) {
                CarMarketPriceDescriptionPresenterImpl.access$activateItem(this.b, this.c, this.a);
                this.b.a(this.d, this.a);
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public CarMarketPriceDescriptionPresenterImpl(@NotNull CarMarketPriceSwitchConverter carMarketPriceSwitchConverter) {
        Intrinsics.checkNotNullParameter(carMarketPriceSwitchConverter, "priceSwitchConverter");
        this.b = carMarketPriceSwitchConverter;
    }

    public static final void access$activateItem(CarMarketPriceDescriptionPresenterImpl carMarketPriceDescriptionPresenterImpl, List list, CarMarketPriceSwitchModel carMarketPriceSwitchModel) {
        Objects.requireNonNull(carMarketPriceDescriptionPresenterImpl);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CarMarketPriceSwitchModel carMarketPriceSwitchModel2 = (CarMarketPriceSwitchModel) it.next();
            carMarketPriceSwitchModel2.setActivated(Intrinsics.areEqual(carMarketPriceSwitchModel2, carMarketPriceSwitchModel));
        }
    }

    public final void a(CarMarketPriceDescriptionView carMarketPriceDescriptionView, CarMarketPriceSwitchModel carMarketPriceSwitchModel) {
        this.a = carMarketPriceSwitchModel.getType();
        if (carMarketPriceSwitchModel.getShouldShowStub()) {
            carMarketPriceDescriptionView.setStubParams(carMarketPriceSwitchModel.getStubIcon(), carMarketPriceSwitchModel.getStubMessage());
            carMarketPriceDescriptionView.showStub();
            return;
        }
        List<String> features = carMarketPriceSwitchModel.getFeatures();
        Intrinsics.checkNotNull(features);
        carMarketPriceDescriptionView.setFeatures(features);
        carMarketPriceDescriptionView.showFeatures();
    }

    public void bindView(@NotNull CarMarketPriceDescriptionView carMarketPriceDescriptionView, @NotNull CarMarketPriceDescriptionItem carMarketPriceDescriptionItem, int i) {
        Intrinsics.checkNotNullParameter(carMarketPriceDescriptionView, "view");
        Intrinsics.checkNotNullParameter(carMarketPriceDescriptionItem, "item");
        PriceDescription priceDescription = carMarketPriceDescriptionItem.getPriceDescription();
        carMarketPriceDescriptionView.setTitle(priceDescription.getTitle());
        List<CarMarketPriceSwitchModel> convert = this.b.convert(priceDescription.getFeatureSwitches(), this.a);
        for (T t : convert) {
            a aVar = new a(t, this, convert, carMarketPriceDescriptionView);
            SwitchType type = t.getType();
            if (type != null) {
                int ordinal = type.ordinal();
                if (ordinal == 0) {
                    carMarketPriceDescriptionView.setLeftFeatureButtonParams(t.getTitle(), t.isActivated(), aVar);
                } else if (ordinal == 1) {
                    carMarketPriceDescriptionView.setRightFeatureButtonParams(t.getTitle(), t.isActivated(), aVar);
                }
            }
            if (t.isActivated()) {
                a(carMarketPriceDescriptionView, t);
            }
        }
    }
}
