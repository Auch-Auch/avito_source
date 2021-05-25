package com.avito.android.advert_core.car_market_price.price_chart;

import android.content.Context;
import com.avito.android.remote.model.UniversalColor;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJG\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0016H&¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "", ErrorBundle.DETAIL_ENTRY, "setDetails", "(Ljava/lang/CharSequence;)V", "clearChartSections", "()V", "Lcom/avito/android/remote/model/UniversalColor;", "titleColor", "lineColor", "", "lineCornersRadii", "", "isAccented", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "marginEnd", "addChartSection", "(Ljava/lang/String;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;[FZII)V", VKApiConst.POSITION, "leftOffset", "moveChartToPosition", "(II)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface CarMarketPriceChartView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull CarMarketPriceChartView carMarketPriceChartView) {
            ItemView.DefaultImpls.onUnbind(carMarketPriceChartView);
        }
    }

    void addChartSection(@NotNull String str, @NotNull UniversalColor universalColor, @NotNull UniversalColor universalColor2, @NotNull float[] fArr, boolean z, int i, int i2);

    void clearChartSections();

    @NotNull
    Context getContext();

    void moveChartToPosition(int i, int i2);

    void setDetails(@Nullable CharSequence charSequence);

    void setSubtitle(@Nullable String str);

    void setTitle(@NotNull String str);
}
