package com.avito.android.advert_core.car_market_price.price_description;

import com.avito.konveyor.blueprint.ItemView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\rJ/\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u000e\u0010\rJ#\u0010\u0012\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "buttonText", "", "isActivated", "Lkotlin/Function0;", "clickListener", "setLeftFeatureButtonParams", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "setRightFeatureButtonParams", "", "stubIconId", "stubText", "setStubParams", "(Ljava/lang/Integer;Ljava/lang/String;)V", "showStub", "()V", "", "features", "setFeatures", "(Ljava/util/List;)V", "showFeatures", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface CarMarketPriceDescriptionView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull CarMarketPriceDescriptionView carMarketPriceDescriptionView) {
            ItemView.DefaultImpls.onUnbind(carMarketPriceDescriptionView);
        }
    }

    void setFeatures(@NotNull List<String> list);

    void setLeftFeatureButtonParams(@NotNull String str, boolean z, @Nullable Function0<Unit> function0);

    void setRightFeatureButtonParams(@NotNull String str, boolean z, @Nullable Function0<Unit> function0);

    void setStubParams(@Nullable Integer num, @Nullable String str);

    void setTitle(@NotNull String str);

    void showFeatures();

    void showStub();
}
