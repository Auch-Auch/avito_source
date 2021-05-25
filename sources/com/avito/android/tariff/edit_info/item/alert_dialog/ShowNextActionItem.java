package com.avito.android.tariff.edit_info.item.alert_dialog;

import com.avito.android.remote.model.edit.TariffAlertAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/alert_dialog/ShowNextActionItem;", "Lcom/avito/android/tariff/edit_info/item/alert_dialog/TariffAlertActionItem;", "", "title", "Lcom/avito/android/remote/model/edit/TariffAlertAction$ButtonStyle;", "buttonStyle", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/edit/TariffAlertAction$ButtonStyle;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class ShowNextActionItem extends TariffAlertActionItem {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShowNextActionItem(@NotNull String str, @NotNull TariffAlertAction.ButtonStyle buttonStyle) {
        super(str, buttonStyle, null);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(buttonStyle, "buttonStyle");
    }
}
