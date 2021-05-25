package com.avito.android.tariff.edit_info.item.alert_dialog;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.edit.TariffAlertAction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u0001\u0003\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/alert_dialog/TariffAlertActionItem;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "Lcom/avito/android/remote/model/edit/TariffAlertAction$ButtonStyle;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/edit/TariffAlertAction$ButtonStyle;", "getButtonStyle", "()Lcom/avito/android/remote/model/edit/TariffAlertAction$ButtonStyle;", "buttonStyle", "Lcom/avito/android/tariff/edit_info/item/alert_dialog/DeepLinkActionItem;", "Lcom/avito/android/tariff/edit_info/item/alert_dialog/TariffSheetActionItem;", "Lcom/avito/android/tariff/edit_info/item/alert_dialog/ShowNextActionItem;", "tariff_release"}, k = 1, mv = {1, 4, 2})
public abstract class TariffAlertActionItem {
    @NotNull
    public final String a;
    @NotNull
    public final TariffAlertAction.ButtonStyle b;

    public TariffAlertActionItem(String str, TariffAlertAction.ButtonStyle buttonStyle, j jVar) {
        this.a = str;
        this.b = buttonStyle;
    }

    @NotNull
    public final TariffAlertAction.ButtonStyle getButtonStyle() {
        return this.b;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }
}
