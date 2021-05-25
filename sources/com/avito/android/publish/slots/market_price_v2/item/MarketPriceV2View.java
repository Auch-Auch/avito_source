package com.avito.android.publish.slots.market_price_v2.item;

import android.content.Context;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2View;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "description", "", "setMarketPriceDescription", "(Ljava/lang/CharSequence;)V", ErrorBundle.DETAIL_ENTRY, "setMarketPriceDetails", "clearNotices", "()V", "", "notice", "", "markColor", "addNotice", "(Ljava/lang/String;Ljava/lang/Integer;)V", "callout", "setCallout", "(Ljava/lang/String;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface MarketPriceV2View extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MarketPriceV2View marketPriceV2View) {
            ItemView.DefaultImpls.onUnbind(marketPriceV2View);
        }
    }

    void addNotice(@NotNull String str, @Nullable Integer num);

    void clearNotices();

    @NotNull
    Context getContext();

    void setCallout(@Nullable String str);

    void setMarketPriceDescription(@NotNull CharSequence charSequence);

    void setMarketPriceDetails(@Nullable CharSequence charSequence);
}
