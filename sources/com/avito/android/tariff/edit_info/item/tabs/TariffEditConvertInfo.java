package com.avito.android.tariff.edit_info.item.tabs;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.edit_info.item.TariffEditInfo;
import com.avito.android.tariff.edit_info.item.alert_dialog.AlertDialogItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/tabs/TariffEditConvertInfo;", "", "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItem;", "c", "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItem;", "getTabsItem", "()Lcom/avito/android/tariff/edit_info/item/tabs/TabsItem;", "tabsItem", "Lcom/avito/android/tariff/edit_info/item/alert_dialog/AlertDialogItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/tariff/edit_info/item/alert_dialog/AlertDialogItem;", "getDialogItem", "()Lcom/avito/android/tariff/edit_info/item/alert_dialog/AlertDialogItem;", "dialogItem", "Lcom/avito/android/tariff/edit_info/item/TariffEditInfo;", AuthSource.SEND_ABUSE, "Lcom/avito/android/tariff/edit_info/item/TariffEditInfo;", "getTariffEditInfo", "()Lcom/avito/android/tariff/edit_info/item/TariffEditInfo;", "tariffEditInfo", "<init>", "(Lcom/avito/android/tariff/edit_info/item/TariffEditInfo;Lcom/avito/android/tariff/edit_info/item/alert_dialog/AlertDialogItem;Lcom/avito/android/tariff/edit_info/item/tabs/TabsItem;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffEditConvertInfo {
    @NotNull
    public final TariffEditInfo a;
    @Nullable
    public final AlertDialogItem b;
    @NotNull
    public final TabsItem c;

    public TariffEditConvertInfo(@NotNull TariffEditInfo tariffEditInfo, @Nullable AlertDialogItem alertDialogItem, @NotNull TabsItem tabsItem) {
        Intrinsics.checkNotNullParameter(tariffEditInfo, "tariffEditInfo");
        Intrinsics.checkNotNullParameter(tabsItem, "tabsItem");
        this.a = tariffEditInfo;
        this.b = alertDialogItem;
        this.c = tabsItem;
    }

    @Nullable
    public final AlertDialogItem getDialogItem() {
        return this.b;
    }

    @NotNull
    public final TabsItem getTabsItem() {
        return this.c;
    }

    @NotNull
    public final TariffEditInfo getTariffEditInfo() {
        return this.a;
    }
}
