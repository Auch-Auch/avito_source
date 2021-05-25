package com.avito.android.shop_settings_select;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ShopSettingsSelection;
import com.avito.android.remote.model.ShopSettingsSelections;
import com.avito.android.shop_settings_select.blueprints.shop_settings_selection.ShopSettingsSelectionItem;
import com.avito.android.shop_settings_select.di.CheckedIds;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u000e\b\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/shop_settings_select/ShopSettingsSelectConverterImpl;", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectConverter;", "Lcom/avito/android/remote/model/ShopSettingsSelections;", "selections", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectContent;", "convert", "(Lcom/avito/android/remote/model/ShopSettingsSelections;)Lcom/avito/android/shop_settings_select/ShopSettingsSelectContent;", "", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getCheckedIds", "()Ljava/util/List;", "checkedIds", "<init>", "(Ljava/util/List;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSelectConverterImpl implements ShopSettingsSelectConverter {
    @NotNull
    public final List<String> a;

    @Inject
    public ShopSettingsSelectConverterImpl(@CheckedIds @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "checkedIds");
        this.a = list;
    }

    @Override // com.avito.android.shop_settings_select.ShopSettingsSelectConverter
    @NotNull
    public ShopSettingsSelectContent convert(@NotNull ShopSettingsSelections shopSettingsSelections) {
        Intrinsics.checkNotNullParameter(shopSettingsSelections, "selections");
        String title = shopSettingsSelections.getTitle();
        List<ShopSettingsSelection> values = shopSettingsSelections.getValues();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(values, 10));
        for (T t : values) {
            arrayList.add(new ShopSettingsSelectionItem(t.getId(), t.getTitle(), t.getHasChildren(), this.a.contains(t.getId())));
        }
        return new ShopSettingsSelectContent(title, arrayList);
    }

    @NotNull
    public final List<String> getCheckedIds() {
        return this.a;
    }
}
