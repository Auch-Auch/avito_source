package com.avito.android.tariff.edit_info.item.alert_dialog;

import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/alert_dialog/AlertDialogItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/tariff/edit_info/item/alert_dialog/TariffBannerItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/tariff/edit_info/item/alert_dialog/TariffBannerItem;", "getInfo", "()Lcom/avito/android/tariff/edit_info/item/alert_dialog/TariffBannerItem;", "info", "<init>", "(Ljava/lang/String;Lcom/avito/android/tariff/edit_info/item/alert_dialog/TariffBannerItem;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class AlertDialogItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final TariffBannerItem b;

    public AlertDialogItem(@NotNull String str, @NotNull TariffBannerItem tariffBannerItem) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(tariffBannerItem, "info");
        this.a = str;
        this.b = tariffBannerItem;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final TariffBannerItem getInfo() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }
}
