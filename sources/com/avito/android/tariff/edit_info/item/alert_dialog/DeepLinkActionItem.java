package com.avito.android.tariff.edit_info.item.alert_dialog;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.edit.TariffAlertAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/alert_dialog/DeepLinkActionItem;", "Lcom/avito/android/tariff/edit_info/item/alert_dialog/TariffAlertActionItem;", "Lcom/avito/android/deep_linking/links/DeepLink;", "c", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "", "title", "Lcom/avito/android/remote/model/edit/TariffAlertAction$ButtonStyle;", "buttonStyle", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/edit/TariffAlertAction$ButtonStyle;Lcom/avito/android/deep_linking/links/DeepLink;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class DeepLinkActionItem extends TariffAlertActionItem {
    @NotNull
    public final DeepLink c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeepLinkActionItem(@NotNull String str, @NotNull TariffAlertAction.ButtonStyle buttonStyle, @NotNull DeepLink deepLink) {
        super(str, buttonStyle, null);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(buttonStyle, "buttonStyle");
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        this.c = deepLink;
    }

    @NotNull
    public final DeepLink getDeeplink() {
        return this.c;
    }
}
