package com.avito.android.tariff.count.viewmodel;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.count.item.bonus.BonusItem;
import com.avito.android.tariff.count.recycler.TariffCountPayloadCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/tariff/count/viewmodel/TariffCountCost;", "", "Lcom/avito/android/tariff/count/viewmodel/Price;", AuthSource.SEND_ABUSE, "Lcom/avito/android/tariff/count/viewmodel/Price;", "getPrice", "()Lcom/avito/android/tariff/count/viewmodel/Price;", "price", "Lcom/avito/android/tariff/count/item/bonus/BonusItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/tariff/count/item/bonus/BonusItem;", "getBonus", "()Lcom/avito/android/tariff/count/item/bonus/BonusItem;", TariffCountPayloadCreator.PAYLOAD_BONUS, "<init>", "(Lcom/avito/android/tariff/count/viewmodel/Price;Lcom/avito/android/tariff/count/item/bonus/BonusItem;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffCountCost {
    @NotNull
    public final Price a;
    @Nullable
    public final BonusItem b;

    public TariffCountCost(@NotNull Price price, @Nullable BonusItem bonusItem) {
        Intrinsics.checkNotNullParameter(price, "price");
        this.a = price;
        this.b = bonusItem;
    }

    @Nullable
    public final BonusItem getBonus() {
        return this.b;
    }

    @NotNull
    public final Price getPrice() {
        return this.a;
    }
}
