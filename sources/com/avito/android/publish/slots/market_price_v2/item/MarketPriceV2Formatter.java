package com.avito.android.publish.slots.market_price_v2.item;

import android.content.Context;
import com.avito.android.remote.model.badge.Badge;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2Formatter;", "", "Landroid/content/Context;", "context", "", "description", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "", "formatPriceDescription", "(Landroid/content/Context;Ljava/lang/String;Lcom/avito/android/remote/model/badge/Badge;)Ljava/lang/CharSequence;", "notice", "", "userPrice", "marketPrice", "formatPriceNotice", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Ljava/lang/String;", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface MarketPriceV2Formatter {
    @NotNull
    CharSequence formatPriceDescription(@NotNull Context context, @NotNull String str, @Nullable Badge badge);

    @NotNull
    String formatPriceNotice(@NotNull String str, @Nullable Long l, @Nullable Long l2);
}
